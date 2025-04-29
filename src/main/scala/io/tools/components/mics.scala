package io.tools.components

import com.raquo.airstream.core.Signal
import com.raquo.laminar.api.L.*
import com.raquo.laminar.nodes.ReactiveHtmlElement
import io.tools.validation.Validation.{Feedback, FormValidation}
import org.scalajs.dom
import org.scalajs.dom.{HTMLDivElement, HTMLElement}

def boxTitle(title: Mod[HtmlElement], backButton: Mod[HtmlElement] = span()): HtmlElement =
  boxTitleWithChildren(title, backButton)()
  
def boxTitleWithChildren(title: Mod[HtmlElement], backButton: Mod[HtmlElement] = span()) (children: Mod[HtmlElement]*): HtmlElement =
  div(
    cls("ibox-title"),
    backButton,
    h5(title, cls("text-center")),
    children
  )

def box(title: Mod[HtmlElement])(
  children: Mod[HtmlElement]*
): HtmlElement =
  div(
    cls("row"),
    div(
      cls(List("col-md-12", "col-xs-12")),
      div(
        cls(List("ibox", "float-e-margins")),
        title,
        div(
          cls("ibox-content"),
          children
        )
      )
    )
  )

def formControl(c: Component[?, ?]): ReactiveHtmlElement[HTMLElement] = formControl(span(), c)

def formControl(
  lbl: ReactiveHtmlElement[HTMLElement],
  c: Component[?, ?]
): ReactiveHtmlElement[HTMLElement] =
  div(
    cls("form-group"),
    lbl,
    c.node.amend(
      cls("form-control")
    ),
    validationList(c.validator)
  )

def row(mods: Modifier[ReactiveHtmlElement[HTMLElement]]*): ReactiveHtmlElement[HTMLElement] =
  div(
    cls := "row",
    mods
  )

def rowCol(s: String)(
  mods: Modifier[ReactiveHtmlElement[HTMLElement]]*
): ReactiveHtmlElement[HTMLElement] =
  row(col(s)(mods*))

def rowCol(s: Seq[String])(
  mods: Modifier[ReactiveHtmlElement[HTMLElement]]*
): ReactiveHtmlElement[HTMLElement] =
  row(col(s*)(mods*))

def col(
  list: String*
)(mods: Modifier[ReactiveHtmlElement[HTMLElement]]*): ReactiveHtmlElement[HTMLElement] =
  div(
    cls := list.map(s => s"col-$s"),
    mods
  )

def renderErrors(title: String, msg: Signal[Seq[String]]) =
  child.maybe <-- msg.map {
    case Nil => None
    case items =>
      Some(
        rowCol("xs-12")(
          div(
            cls := "alert alert-danger",
            h4(title),
            ul(
              items.map(s => li(s))
            )
          )
        )
      )
  }

def renderError(msg: Signal[String]) =
  child.maybe <-- msg.map {
    case "" => None
    case str =>
      Some(
        rowCol("xs-12")(
          div(
            cls := "alert alert-danger",
            p(str)
          )
        )
      )
  }

private def validationList(validation: Option[Signal[Option[FormValidation]]]) =
  validation.map(v => {
    List(
      child.maybe <-- v.map(_.map(_.icon)),
      child.maybe <-- v.map(
        _.map(_.message).map(x => x.map(s => span(cls("help-block"), s"$s")).getOrElse(span()))
      ),
      cls.toggle("has-feedback has-feedback") <-- v.map(
        _.exists(_.message.nonEmpty)
      ),
      cls.toggle("has-feedback has-success") <-- v.map(
        _.exists(x => x.feedback == Feedback.Ok)
      ),
      cls.toggle("has-feedback has-error") <-- v.map(
        _.exists(x => x.feedback == Feedback.Err)
      ),
      cls.toggle("has-feedback has-warning") <-- v.map(
        _.exists(x => x.feedback == Feedback.Warn)
      )
    )
  })

def space(sizePx: Int = 10) =
  div(
    cls("row"),
    div(
      cls("col-xs-12"),
      styleAttr(s"height: ${sizePx}px")
    )
  )

def panel[Ref <: dom.html.Element](children: ReactiveHtmlElement[Ref]*): HtmlElement =
  div(cls("panel-bordered"), children)
