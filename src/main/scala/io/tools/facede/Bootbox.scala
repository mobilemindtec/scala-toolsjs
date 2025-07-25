package io.tools.facede

import io.tools.facede.Bootbox.bootbox

import scala.scalajs.js
import scala.scalajs.js.{Dynamic, timers}
import scala.scalajs.js.annotation.JSGlobal
import js.JSConverters.*

// https://bootboxjs.com/v4.x/documentation.html
object Bootbox:

  enum BoxButtonType(val value: String):
    case Main extends BoxButtonType("main")
    case Alert extends BoxButtonType("alert")
    case Confirm extends BoxButtonType("confirm")
    case Prompt extends BoxButtonType("prompt")

  case class BoxButton(name: BoxButtonType | String = BoxButtonType.Main,
                       label: String,
                       className: String = "",
                       callback: js.Function1[js.Any, Unit] | Null = null)

  class InputOption(val text: String, val value: String) extends js.Object

  enum InputType(val value: String):
    case Text extends InputType("text")
    case TextArea extends InputType("textarea")
    case Email extends InputType("email")
    case Select extends InputType("select")
    case Checkbox extends InputType("checkbox")
    case Date extends InputType("date")
    case Time extends InputType("time")
    case Number extends InputType("number")
    case Password extends InputType("password")

  enum Size(val value: String):
    case Small extends Size("small")
    case Large extends Size("large")


  case class AlertConfig[T](size: Size = Size.Small, // or large,
                            title: String = "",
                            message: String,
                            className: String = "",
                            onEscape: Boolean = false,
                            animate: Boolean = true,
                            closeButton: Boolean = true,
                            buttons: Seq[BoxButton] = Nil,
                            callback: js.Function1[T, Unit] | Null = null,
                            value: String = "", // initial value to prompt
                            inputType: InputType = InputType.Text,
                            inputOptions: Seq[InputOption] = Nil):
    def build: js.Object =
      Dynamic.literal(
        "size" -> size.value,
        "title" -> title,
        "message" -> message,
        "className" -> className,
        "onEscape" -> onEscape,
        "animate" -> animate,
        "closeButton" -> closeButton,
        "buttons" -> buttons.foldRight(Dynamic.literal()) { (btn, obj) =>
          val name = btn.name match
            case n: String => n
            case t: BoxButtonType => t.value
          obj.updateDynamic(name)(Dynamic.literal(
            "label" -> btn.label,
            "className" -> btn.className,
            "callback" -> { (ev: js.Any) =>
              btn.callback match
                case null => ()
                case f => timers.setTimeout(350) { f(ev) }
            }
          ))
          obj
        },
        "callback" -> { (ev: js.Any) =>
          callback match
            case null => ()
            case f => timers.setTimeout(350) { f(ev.asInstanceOf[T]) }
        },
        "value" -> value,
        "inputType" -> inputType.value,
        "inputOptions" -> inputOptions.toJSArray,
      )

  @js.native
  @JSGlobal
  object bootbox extends js.Object:
    def alert(msg: String, callback: js.Function1[js.Any, Unit]): bootbox.type = js.native
    def alert(cfg: js.Object): bootbox.type = js.native
    def prompt(msg: String, callback: js.Function1[js.Any, Unit]): bootbox.type = js.native
    def prompt(cfg: js.Object): bootbox.type = js.native
    def confirm(msg: String, callback: js.Function1[js.Any, Unit]): bootbox.type = js.native
    def confirm(cfg: js.Object): bootbox.type = js.native
    def dialog(cfg: js.Object): bootbox.type = js.native
    def modal(event: String): bootbox.type = js.native

  extension (b: bootbox.type)
    def hide(): bootbox.type  = b.modal("hide")


  def alert(msg: String): Unit = {
    bootbox.alert(msg, null)
  }

  def alert(msg: String)(callback: () => Unit): bootbox.type =
    bootbox.alert(msg, { v =>
      callback match
        case null => ()
        case cb => timers.setTimeout(350) { cb() }
    })

  def alert(cfg: AlertConfig[Unit]): bootbox.type =
    bootbox.alert(cfg.build)

  def prompt(msg: String): bootbox.type =
    bootbox.alert(msg, null)

  def prompt(msg: String)(callback: String => Unit): bootbox.type =
    bootbox.prompt(msg, { v =>
      callback match
        case null => ()
        case cb => timers.setTimeout(350) { cb(v.asInstanceOf[String]) }
    })

  def prompt(cfg: AlertConfig[String]): bootbox.type =
    bootbox.prompt(cfg.build)

  def confirm(msg: String): bootbox.type =
    bootbox.confirm(msg, null)

  def confirm(msg: String)(callback: Boolean => Unit): bootbox.type =
    bootbox.confirm(msg,  { v =>
      callback match
        case null => ()
        case cb => timers.setTimeout(350) { cb(v.asInstanceOf[Boolean]) }
    })

  def confirm(cfg: AlertConfig[Boolean]): bootbox.type =
    bootbox.confirm(cfg.build)

  def dialog(cfg: AlertConfig[Unit]): bootbox.type =
    bootbox.dialog(cfg.build)

  def wait(msg: String): bootbox.type =
    dialog(AlertConfig[Unit](
      message =
        s"""
          |<div class="text-center">
          |<i class="fa fa-spin fa-spinner"></i>
          | $msg
          |</div>""".stripMargin,
      onEscape = false,
      closeButton = false
    ))

private object test:

  import Bootbox.*

  def test =
    Bootbox.dialog(AlertConfig[Unit](
      message = "hey!!",
      buttons = Seq(
        BoxButton(name = "main",
          label = "OK",
          className = "btn btn-success",
          callback = _ => Bootbox.alert("OK")),
        BoxButton(name = "cancel",
          label = "Cancel",
          className = "btn btn-danger",
          callback = _ => Bootbox.alert("CANCEL"))
      )

    ))
