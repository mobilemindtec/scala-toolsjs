package io.tools.components

import com.raquo.laminar.api.L.*
import com.raquo.laminar.nodes.ReactiveHtmlElement
import io.tools.defs.*
import org.querki.jquery.$
import org.scalajs.dom.HTMLDivElement

object tabs:

  def apply(titles: String*)(elements: HtmlElement*): ReactiveHtmlElement[HTMLDivElement] =
    div(
      onMountCallback { _ => },
      cls := "row",
      div(
        cls := "col-xs-12",
        div(
          cls := "tabs-container",
          ul(
            cls := "nav nav-tabs",
            role := "tablist",
            titles.mapWithIndex { (i, el) =>
              li(
                cls := (if i == 0 then "active" else ""),
                a(
                  cls := s"nav-link ${if i == 0 then "active" else ""}",
                  href := s"#tab-$i",
                  dataAttr("toggle") := "tab",
                  el
                )
              )
            }
          ),
          div(
            cls := "tab-content",
            elements.mapWithIndex { (i, el) =>
              div(
                idAttr := s"tab-$i",
                cls := s"tab-pane ${if i == 0 then "active" else ""}",
                role := "tabpanel",
                div(
                  cls := "panel-body",
                  el
                )
              )
            }
          )
        )
      )
    )
