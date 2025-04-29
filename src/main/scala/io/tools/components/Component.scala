package io.tools.components

import com.raquo.airstream.core.Signal
import com.raquo.laminar.api.L
import com.raquo.laminar.api.L.*
import com.raquo.laminar.nodes.ReactiveHtmlElement
import io.tools.components.SelectOption.SelectOption
import io.tools.components.util.DatePicker.{atTimeNow, dtpicker, dtpickerMaybe}
import io.tools.facede.ICheck.iCheck
import io.tools.facede.MaskMoney.{maskMoney, unmasked}
import io.tools.facede.{MaskMoney, MaskMoneyOpts}
import io.tools.util.NumberUtil
import io.tools.validation.Validation.{Feedback, FormValidation}
import org.querki.jquery.{$, JQueryEventObject}
import org.scalajs.dom
import org.scalajs.dom.HTMLElement

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.scalajs.js

// SelectOption
object SelectOption:

  case class SelectOption[T](
    id: String,
    text: String,
    value: Option[T] = None,
    selected: Boolean = false
  )

  extension [T](l: Seq[SelectOption[T]])
    def selectBy(key: String): Seq[SelectOption[T]] =
      l.collect { it => it.copy(selected = it.id == key) }

    def unselected: Seq[SelectOption[T]] =
      SelectOption("", "Selecione...", None) +: l

type CWriter[State, T] = (State, T) => State
type CReader[State, T] = State => T
type CValidator = Signal[Option[FormValidation]]

trait CAttr

case class CAttrReaderF():
  infix def :=[State, T](f: CReader[State, T]): CAttrReader[State, T] = CAttrReader(f)

case class CAttrWriterF():
  infix def :=[State, T](f: CWriter[State, T]): CAttrWriter[State, T] = CAttrWriter(f)

case class CAttrValidatorF():
  infix def :=(f: CValidator): CAttrValidator = CAttrValidator(f)

case class CAttrStateF():
  infix def :=[T](state: Var[T]): CAttrState[T] = CAttrState(state)

case class CAttrOptionsF():
  infix def :=[T](options: Var[Seq[SelectOption[T]]]): CAttrOptions[T] = CAttrOptions(options)

case class CAttrMaskOptsF():
  infix def :=(opts: MaskMoneyOpts): CAttrMaskOpts = CAttrMaskOpts(opts)

case class CAttrReader[State, T](f: CReader[State, T]) extends CAttr
case class CAttrWriter[State, T](f: CWriter[State, T]) extends CAttr
case class CAttrState[T](state: Var[T]) extends CAttr
case class CAttrOptions[T](options: Var[Seq[SelectOption[T]]]) extends CAttr
case class CAttrValidator(validator: CValidator) extends CAttr
case class CAttrMaskOpts(opts: MaskMoneyOpts) extends CAttr

object CAttr:
  def reader: CAttrReaderF = CAttrReaderF()
  def writer: CAttrWriterF = CAttrWriterF()
  def validator: CAttrValidatorF = CAttrValidatorF()
  def state: CAttrStateF = CAttrStateF()
  def options: CAttrOptionsF = CAttrOptionsF()
  def maskOpts: CAttrMaskOptsF = CAttrMaskOptsF()

// Component
trait Component[State, T]():
  def node: ReactiveHtmlElement[dom.html.Element]
  val state: Option[Var[State]]
  val reader: Option[CReader[State, T]] = None
  val writer: Option[CWriter[State, T]] = None
  val validator: Option[CValidator] = None

// Input
trait Input[State](mods: Modifier[ReactiveHtmlElement[HTMLElement]]*)
  extends Component[State, String]:
  override def node: ReactiveHtmlElement[dom.html.Element] =
    val el = input(mods)
    (state, reader, writer) match
      case (Some(st), Some(r), Some(w)) =>
        el.amend(
          controlled(
            value <-- st.signal.map(r),
            onInput.mapToValue --> st.updater(w)
          )
        )
      case (Some(st), Some(r), None) =>
        el.amend(value <-- st.signal.map(r))
      case (Some(st), None, Some(w)) =>
        el.amend(onInput.mapToValue --> st.updater(w))
      case _ => el

object Input:

  type Inputs[State] = Modifier[ReactiveHtmlElement[HTMLElement]] | CAttrReader[State, String] |
    CAttrWriter[State, String] | CAttrValidator | CAttrState[State]

  /** Example:
    * {{{
    *   val nameInput = Input(
    *     state := Var[Person](Person()),
    *     reader := { (p: Person) => p.name },
    *     writer := { (state: Person, text: String) => state.copy(name = text) },
    *     idAttr := "name"
    *   )
    * }}}
    *
    * @param mods
    * @tparam State
    * @return
    */

  def apply[State](
    mods: Inputs[State]*
  ): Input[State] =
    val atts = mods.collect { case r: ReactiveHtmlElement[HTMLElement] => r }
    val r = mods.collectFirst { case r: CAttrReader[State, String] => r }
    val w = mods.collectFirst { case r: CAttrWriter[State, String] => r }
    val v = mods.collectFirst { case r: CAttrValidator => r }
    val st = mods.collectFirst { case r: CAttrState[State] => r }
    new Input[State](atts*) {
      override val state = st.map(_.state)
      override val reader = r.map(_.f)
      override val writer = w.map(_.f)
      override val validator = v.map(_.validator)
    }

// InputDate
trait InputDate[State](mods: Modifier[ReactiveHtmlElement[HTMLElement]]*)(using
  df: DateTimeFormatter
) extends Component[State, LocalDateTime]:
  override def node: ReactiveHtmlElement[dom.html.Element] =
    val el = input(
      mods,
      cls("datepicker"),
      readOnly(true),
      onMountCallback { ctx =>
        $(ctx.thisNode.ref).dtpicker() { date =>
          (state, writer) match
            case (Some(st), Some(w)) =>
              st.update(s => w(s, date.atTimeNow))
            case _ => ()
        }
      }
    )
    (state, reader) match
      case (Some(st), Some(f)) => el.amend(value <-- st.signal.map(s => f(s).format(df)))
      case _                   => el

object InputDate:

  type Inputs[State] = Modifier[ReactiveHtmlElement[HTMLElement]] |
    CAttrReader[State, LocalDateTime] | CAttrWriter[State, LocalDateTime] | CAttrValidator |
    CAttrState[State]

  /** {{{
    *   InputDate(
    *     state := stateVar,
    *     validator := error(_.validator.find("vencimento")),
    *     reader := { (state: ContaPagar) => state.primeiroVencimento },
    *     writer := { (state: ContaPagar, d: LocalDateTime) => state.copy(primeiroVencimento = d) },
    *   )
    * }}}
    *
    * @param state
    * @param mods
    * @tparam State
    * @return
    */
  def apply[State](
    mods: Inputs[State]*
  ): DateTimeFormatter ?=> InputDate[State] =
    val atts = mods.collect { case r: ReactiveHtmlElement[HTMLElement] => r }
    val r = mods.collectFirst { case r: CAttrReader[State, LocalDateTime] => r }
    val w = mods.collectFirst { case r: CAttrWriter[State, LocalDateTime] => r }
    val v = mods.collectFirst { case r: CAttrValidator => r }
    val st = mods.collectFirst { case r: CAttrState[State] => r }
    new InputDate[State](atts*) {
      override val state = st.map(_.state)
      override val reader = r.map(_.f)
      override val writer = w.map(_.f)
      override val validator = v.map(_.validator)
    }

trait InputDateMaybe[State](mods: Modifier[ReactiveHtmlElement[HTMLElement]]*)(
  using df: DateTimeFormatter
) extends Component[State, Option[LocalDateTime]]:
  override def node: ReactiveHtmlElement[dom.html.Element] =

    val el = input(
      mods,
      cls("datepicker"),
      readOnly(true),
      onMountCallback { ctx =>
        $(ctx.thisNode.ref).dtpickerMaybe() { date =>
          (state, writer) match
            case (Some(st), Some(w)) =>
              st.update(s => w(s, date.map(_.atTimeNow)))
            case _ => ()
        }
      }
    )
    (state, reader) match
      case (Some(st), Some(f)) =>
        el.amend(
          value <-- st
            .signal
            .map {
              s => f(s).map(_.format(df)).getOrElse("")
            }
        )
      case _ => el

object InputDateMaybe:

  type Inputs[State] = Modifier[ReactiveHtmlElement[HTMLElement]] |
    CAttrReader[State, Option[LocalDateTime]] | CAttrWriter[State, Option[LocalDateTime]] | CAttrValidator |
    CAttrState[State]

  /** {{{
   *   InputDate(
   *     state := stateVar,
   *     validator := error(_.validator.find("vencimento")),
   *     reader := { (state: ContaPagar) => state.primeiroVencimento },
   *     writer := { (state: ContaPagar, d: LocalDateTime) => state.copy(primeiroVencimento = d) },
   *   )
   * }}}
   *
   * @param state
   * @param mods
   * @tparam State
   * @return
   */
  def apply[State](mods: Inputs[State]*): DateTimeFormatter ?=> InputDateMaybe[State] =
    val atts = mods.collect { case r: ReactiveHtmlElement[HTMLElement] => r }
    val r = mods.collectFirst { case r: CAttrReader[State, Option[LocalDateTime]] => r }
    val w = mods.collectFirst { case r: CAttrWriter[State, Option[LocalDateTime]] => r }
    val v = mods.collectFirst { case r: CAttrValidator => r }
    val st = mods.collectFirst { case r: CAttrState[State] => r }
    new InputDateMaybe[State](atts *) {
      override val state = st.map(_.state)
      override val reader = r.map(_.f)
      override val writer = w.map(_.f)
      override val validator = v.map(_.validator)
    }

// InputMoney
trait InputMoney[State](opts: MaskMoneyOpts, mods: Modifier[ReactiveHtmlElement[HTMLElement]]*)
  extends Component[State, Double]:
  override def node: ReactiveHtmlElement[dom.html.Element] =
    val el = input(
      mods,
      cls("number"),
      onMountCallback { ctx =>
        val mask = $(ctx.thisNode.ref)
          .maskMoney(opts)

        mask.on(
          "blur",
          { (ev: JQueryEventObject, _) =>
            (state, writer) match
              case (Some(stVar), Some(w)) =>
                stVar.update(s => w(s, mask.unmasked))
              case _ => ()

          }
        )
      }
    )
    (state, reader) match
      case (Some(stVar), Some(f)) =>
        el.amend(
          value <-- stVar.signal.map { s =>
            NumberUtil.toMoney(f(s))
          }
        )
      case _ => el

object InputMoney:

  type Inputs[State] = Modifier[ReactiveHtmlElement[HTMLElement]] | CAttrReader[State, Double] |
    CAttrWriter[State, Double] | CAttrValidator | CAttrState[State] | CAttrMaskOpts

  /** {{{
    *   InputMoney(
    *     state := stateVar,
    *     opts := MaskMoneyOpts(),
    *     validator := error(_.validator.find("value")),
    *     reader := { (state: S) => state.value },
    *     writer := { (state: S, value: Double) => state.copy(value = value) }
    *   )
    * }}}
    *
    * @param mods
    * @tparam State
    * @return
    */
  def apply[State](
    mods: Inputs[State]*
  ): InputMoney[State] =
    val atts = mods.collect { case r: ReactiveHtmlElement[HTMLElement] => r }
    val r = mods.collectFirst { case r: CAttrReader[State, Double] => r }
    val w = mods.collectFirst { case r: CAttrWriter[State, Double] => r }
    val v = mods.collectFirst { case r: CAttrValidator => r }
    val st = mods.collectFirst { case r: CAttrState[State] => r }
    val opts = mods.collectFirst { case r: CAttrMaskOpts => r }
    new InputMoney[State](opts.map(_.opts).getOrElse(MaskMoneyOpts()), atts*) {
      override val state = st.map(_.state)
      override val reader = r.map(_.f)
      override val writer = w.map(_.f)
      override val validator = v.map(_.validator)
    }

// CheckBox
trait CheckBox[State](lbl: String, mods: Modifier[ReactiveHtmlElement[HTMLElement]]*)
  extends Component[State, Boolean]:

  override def node: ReactiveHtmlElement[dom.html.Element] =
    val el = div(
      cls("i-checks"),
      label(
        div(
          cls("icheckbox_square-green"),
          input(
            typ("checkbox"),
            onMountCallback { _ =>
              $(".icheckbox_square-green").iCheck()

              $(".icheckbox_square-green").on(
                "ifToggled",
                { (ev: JQueryEventObject, _) =>
                  (state, writer) match
                    case (Some(stVar), Some(w)) =>
                      val value = $(ev.currentTarget).find("input").is(":checked")
                      stVar.update(st => w(st, value))
                    case _ => ()

                }
              )
            },
            mods
          )
        ),
        s" $lbl"
      )
    )
    (state, reader) match
      case (Some(stVar), Some(f)) =>
        el.amend(checked <-- stVar.signal.map(f))
      case _ => el

object CheckBox:

  type Inputs[State] = Modifier[ReactiveHtmlElement[HTMLElement]] | CAttrReader[State, Boolean] |
    CAttrWriter[State, Boolean] | CAttrValidator | CAttrState[State]

  /** {{{
    *   CheckBox(
    *     "Conta recorrente",
    *     state := stateVar,
    *     reader := { (state: ContaPagar) => state.recurrent },
    *     writer := { (state: ContaPagar, b: Boolean) => state.copy(recurrent = b) }
    *   )
    * }}}
    *
    * @param label
    * @param mods
    * @tparam State
    * @return
    */
  def apply[State](
    label: String,
    mods: Inputs[State]*
  ): CheckBox[State] =
    val atts = mods.collect { case r: ReactiveHtmlElement[HTMLElement] => r }
    val r = mods.collectFirst { case r: CAttrReader[State, Boolean] => r }
    val w = mods.collectFirst { case r: CAttrWriter[State, Boolean] => r }
    val v = mods.collectFirst { case r: CAttrValidator => r }
    val st = mods.collectFirst { case r: CAttrState[State] => r }
    new CheckBox[State](label, atts*) {
      override val state = st.map(_.state)
      override val reader = r.map(_.f)
      override val writer = w.map(_.f)
      override val validator = v.map(_.validator)
    }

    // TextArea
trait TextArea[State](mods: Modifier[ReactiveHtmlElement[HTMLElement]]*)
  extends Component[State, String]:
  override def node: ReactiveHtmlElement[dom.html.Element] =
    val el = textArea(mods)
    (state, reader, writer) match
      case (Some(stVar), Some(r), Some(w)) =>
        el.amend(
          controlled(
            value <-- stVar.signal.map(r),
            onInput.mapToValue --> stVar.updater(w)
          )
        )
      case (Some(stVar), Some(r), None) =>
        el.amend(value <-- stVar.signal.map(r))
      case (Some(stVar), None, Some(w)) =>
        el.amend(onInput.mapToValue --> stVar.updater(w))
      case _ => el

object TextArea:
  type Inputs[State] = Modifier[ReactiveHtmlElement[HTMLElement]] | CAttrReader[State, String] |
    CAttrWriter[State, String] | CAttrValidator | CAttrState[State]

  def apply[State](
    mods: Inputs[State]*
  ): TextArea[State] =
    val atts = mods.collect { case r: ReactiveHtmlElement[HTMLElement] => r }
    val r = mods.collectFirst { case r: CAttrReader[State, String] => r }
    val w = mods.collectFirst { case r: CAttrWriter[State, String] => r }
    val v = mods.collectFirst { case r: CAttrValidator => r }
    val st = mods.collectFirst { case r: CAttrState[State] => r }
    new TextArea[State](atts*) {
      override val state = st.map(_.state)
      override val reader = r.map(_.f)
      override val writer = w.map(_.f)
      override val validator = v.map(_.validator)
    }

trait Select[State, T](
  mods: Modifier[ReactiveHtmlElement[HTMLElement]]*
) extends Component[State, String]:

  val options: Option[Var[Seq[SelectOption[T]]]]

  override def node: ReactiveHtmlElement[dom.html.Element] =
    val el = select(mods)
    val el2 =
      options match
        case Some(opts) =>
          el.amend(
            children <-- opts.signal.map(
              _.map(it => option(value := it.id, selected := it.selected, it.text))
            )
          )
        case _ => el

    (state, writer) match
      case (Some(stVar), Some(f)) => el2.amend(onChange.mapToValue --> stVar.updater(f))
      case _                      => el2

object Select:

  type Inputs[State, T] = Modifier[ReactiveHtmlElement[HTMLElement]] | CAttrValidator |
    CAttrWriter[State, SelectOption[T]] | CAttrState[State] | CAttrOptions[T]

  /** {{{
    *   Select(
    *     state := stateVar,
    *     options := subgruposVar,
    *     validator := error(_.validator.find("cedente")),
    *     writer := { (state: ContaPagar, opt: SelectOption[ContaPagarSubGrupo]) =>
    *       state.copy(subGrupo = opt.value.getOrElse(ContaPagarSubGrupo()))
    *     }
    *   )
    * }}}
    *
    * @param mods
    * @tparam State
    * @tparam T
    * @return
    */
  def apply[State, T](
    mods: Inputs[State, T]*
  ): Select[State, T] =
    val atts = mods.collect { case r: ReactiveHtmlElement[HTMLElement] => r }
    // val r = mods.collectFirst { case r: CAttrReader[State, String] => r }
    val w = mods.collectFirst { case r: CAttrWriter[State, SelectOption[T]] => r }
    val v = mods.collectFirst { case r: CAttrValidator => r }
    val st = mods.collectFirst { case r: CAttrState[State] => r }
    val opts = mods.collectFirst { case r: CAttrOptions[T] => r }

    new Select[State, T](atts*) {
      override val options = opts.map(_.options)
      override val state = st.map(_.state)
      override val validator = v.map(_.validator)
      override val writer = Some(
        { (s: State, text: String) =>
          options match
            case Some(opts) =>
              val newOpts = opts.now().map { opt =>
                opt.copy(selected = opt.id == text)
              }
              // set option to selected
              opts.update(_ => newOpts)
              // dispatch writer
              (newOpts.find(_.selected), w) match
                case (Some(v), Some(wf)) => wf.f(s, v)
                case _                   => s
            case _ => s
        }
      )
    }

case class Person(id: Int = 0, name: String = "")

def test =

  import CAttr.*

  val stateVar = Var[Person](Person())
  val nameInput = Input(
    state := Var[Person](Person()),
    reader := { (p: Person) => p.name },
    writer := { (state: Person, text: String) => state.copy(name = text) },
    idAttr := "name"
  )
