package io.tools.components.bs5

import com.raquo.laminar.api.L.*
import io.tools.CustomReactiveElement
import io.tools.styles.Bootstrap5.*

def content(title: String)(mods: Mod[HtmlElement]*) =
  mainTag(cls := "container", div(cls := "bg-light p-5 rounded", h1(cls := "text-center", title), mods))

def formControl(lbl: String)(modifiers: => CustomReactiveElement*): CustomReactiveElement =
  div.bs.`mb-3`(label.bs.`form-label`(lbl), modifiers)

def inputFormControl(lbl: String, hint: String): CustomReactiveElement =
  formControl(lbl)(input.bs.`form-control`(placeholder(hint)))

def selectFormControl(lbl: String)(options: Mod[HtmlElement]*): CustomReactiveElement =
  formControl(lbl)(select.bs.`form-select`(options))