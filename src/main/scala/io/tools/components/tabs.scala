package io.tools.components

import com.raquo.laminar.api.L.*
import com.raquo.laminar.nodes.ReactiveHtmlElement
import io.tools.defs.*
import org.querki.jquery.$
import org.scalajs.dom.HTMLDivElement

object tabs:

  private val activeVar: Var[Option[TabItem]] = Var(None)

  case class TabItem(key: String, title: String, active: Boolean, el: HtmlElement)

  def apply(items: TabItem*): ReactiveHtmlElement[HTMLDivElement] = {
    div(
      onMountCallback { _ =>
        if activeVar.now().isEmpty
        then activeVar.update( _ => items.find(_.active))
      },
      cls := "row",
      div(
        cls := "col-xs-12",
        div(
          cls := "tabs-container",
          ul(
            cls := "nav nav-tabs",
            role := "tablist",
            items.map { item =>
              li(
                cls.toggle("active") <-- activeVar.signal.map(_.exists(_.key == item.key)),
                cls.toggle("") <-- activeVar.signal.map(_.exists(_.key == item.key)).invert,
                a(
                  cls.toggle("nav-link active") <-- activeVar.signal.map(_.exists(_.key == item.key)),
                  cls.toggle("nav-link") <-- activeVar.signal.map(_.exists(_.key == item.key)).invert,
                  href := s"#tab-${item.key}",
                  dataAttr("toggle") := "tab",
                  item.title,
                  onClick.preventDefault --> (_ => activeVar.update(_ => Some(item)))
                )
              )
            }
          ),
          div(
            cls := "tab-content",
            items.map { item =>
              div(
                idAttr := s"tab-${item.key}",
                cls.toggle("tab-pane active") <-- activeVar.signal.map(_.exists(_.key == item.key)),
                cls.toggle("tab-pane") <-- activeVar.signal.map(_.exists(_.key == item.key)).invert,
                role := "tabpanel",
                div(
                  cls := "panel-body",
                  item.el
                )
              )
            }
          )
        )
      )
    )
  }
