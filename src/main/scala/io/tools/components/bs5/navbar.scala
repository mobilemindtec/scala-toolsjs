package io.tools.components.bs5

import com.raquo.laminar.api.L.*
import io.tools.styles.Bootstrap5.*
import io.tools.styles.Style

object navbar:
  def apply() =
    navTag(
      cls := "navbar navbar-expand-md navbar-dark fixed-top bg-dark",
      div(
        cls := "container-fluid",
        a(cls                        := "navbar-brand", href := "#", "Gogs Projects"),
        button(
          cls                        := "navbar-toggler",
          tpe                        := "button",
          dataAttr("data-bs-toggle") := "collapse",
          dataAttr("data-bs-target") := "#navbarCollapse",
          dataAttr("aria-controls")  := "navbarCollapse",
          dataAttr("aria-expanded")  := "false",
          dataAttr("aria-label")     := "Toggle navigation",
          span(cls := "navbar-toggler-icon")
        ),
        div(
          cls                        := "collapse navbar-collapse",
          idAttr                     := "navbarCollapse",
          ul(
            cls := "navbar-nav me-auto mb-2 mb-md-0",
            li(cls := "nav-item", a(cls := "nav-link active", dataAttr("aria-current") := "page", href := "/", "Home")),
            //li(cls := "nav-item", a(cls := "nav-link", href := home", "Projects"))
          ),
          form(
            cls := "d-flex",
            input(
              cls                    := "form-control me-2",
              tpe                    := "search",
              placeholder            := "Search",
              dataAttr("aria-label") := "Search"
            ),
            button(cls               := "btn btn-outline-success", tpe := "submit", "Search")
          )
        )
      )
    )



