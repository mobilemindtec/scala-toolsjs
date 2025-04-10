package io.tools.components

import com.raquo.laminar.api.L.*
import io.tools.styles.Bootstrap3.*
import io.tools.validation.Validation.{Feedback, FormValidation}

object alert:

  def apply(message: String, alertType: Feedback) =
    FormValidation(alertType, Some(message))

  def apply(v: FormValidation) =
    val className = v.feedback match
      case Feedback.Err => "danger"
      case Feedback.Ok => "success"
      case Feedback.Warn => "warning"
      case Feedback.None => ""
    show(className, v.getMessage, v.messages)

  def success(message: String) = show("success", message)
  def info(message: String) = show("info", message)
  def warning(message: String) = show("warning", message)
  def primary(message: String) = show("primary", message)
  def danger(message: String) = show("danger", message)

  private def show(className: String, message: String, messages: Option[List[String]] = None) =
    div.bs.row(
      div.bs.`col-xs-12`(
        div.bs.alert(
          cls:= className,
          h4(message),
          messages
            .map(ls =>
              ul(
                styleAttr("padding-top: 10px"),
                ls.map(s => li(s))
              )
            )
            .getOrElse(span())
        )
      )
    )