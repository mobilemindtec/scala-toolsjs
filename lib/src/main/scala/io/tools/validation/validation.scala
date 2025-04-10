package io.tools.validation

import com.raquo.laminar.api.L.*

object Validation:

  enum Feedback:
    case Ok, Warn, Err, None

  case class FormValidation(
    feedback: Feedback = Feedback.None,
    message: Option[String] = None,
    key: Option[String] = None,
    messages: Option[List[String]] = None
  ):

    def getMessage =
      message
        .map(s => if s.startsWith("validation") then "Corrija os seguintes problemas:" else s)
        .getOrElse("")

    def isKey(k: String) = if key.isEmpty then false else key.get == k

    def icon = feedback match
      case Feedback.Ok   => span(cls("form-control-feedback glyphicon glyphicon-ok "))
      case Feedback.Err  => span(cls("form-control-feedback glyphicon glyphicon-remove"))
      case Feedback.Warn => span(cls("form-control-feedback glyphicon glyphicon-warning-sign"))
      case _             => span()

    def clz = feedback match
      case Feedback.Ok   => cls("form-group has-success has-feedback")
      case Feedback.Err  => cls("form-group has-error has-feedback")
      case Feedback.Warn => cls("form-group has-warning has-feedback")
      case _             => cls("form-group")

    def display = message.nonEmpty

  object FormValidation:

    def apply(feedback: Feedback): FormValidation = new FormValidation(feedback)

    def apply(message: String): FormValidation = new FormValidation(Feedback.Err, Some(message))

  trait EntityValidator:
    def valid: Boolean

  trait Validator:

    def messages = Map(
      "size" -> "O tamanho do campo %s deve ter entre %s e %s",
      "required" -> "O valor para o campo %s é obrigatório",
      "number" -> "O valor para o campo %s deve estar entre %s e %s",
      "maybe" -> "Informe um valor para %s",
      "rel" -> "Selecione um valor para o campo %s"
    )

    def validators: Seq[ValidatorBase]

    def customs: Seq[() => Option[FormValidation]] = Nil

    def tofeedback(v: ValidatorBase, msg: Option[String]) =
      FormValidation(Feedback.Err, Some(msg.getOrElse(getMessageFor(v.lbl, v))), Some(v.field))

    def validations =
      val forms = customs.map(f => f()).filter(_.nonEmpty).map(_.get)
      forms ++ validators
        .filter(!_.valid)
        .flatMap(x =>
          x match {
            case validator: MaybeValidator =>
              validator.vs.map(v => tofeedback(v, validator.message))
            case _ => List(tofeedback(x, None))
          }
        )

    def validate =
      validations.isEmpty && !customs.map(f => f()).exists(_.nonEmpty)

    def find(fieldKey: String) =
      this.validations.find(x => x.isKey(fieldKey))

    def getMessageFor(label: String, validator: ValidatorBase): String =
      validator match
        case SizeValidator(_, _, min, max, _, msg) =>
          msg.getOrElse(String.format(messages.find((k, v) => k == "size").get._2, label, min, max))
        case EmptyValidator(_, _, _, msg) =>
          msg.getOrElse(String.format(messages.find((k, v) => k == "required").get._2, label))
        case RequiredValidator(_, _, _, msg) =>
          msg.getOrElse(String.format(messages.find((k, v) => k == "required").get._2, label))
        case IntValidator(_, _, max, min, _, msg) =>
          msg.getOrElse(
            String.format(messages.find((k, v) => k == "number").get._2, label, min, max)
          )
        case DoubleValidator(_, _, max, min, _, msg) =>
          msg.getOrElse(
            String.format(messages.find((k, v) => k == "number").get._2, label, min, max)
          )
        case maybe: MaybeValidator =>
          maybe.message.getOrElse(
            String.format(messages.find((k, v) => k == "maybe").get._2, maybe.fields)
          )
        case RelValidator(_, _, _, msg) =>
          msg.getOrElse(
            String.format(messages.find((k, v) => k == "rel").get._2, label)
          )

  trait ValidatorBase(val lbl: String, msg: Option[String]):
    def valid: Boolean
    def field: String

  case class RelValidator[T <: EntityValidator](
    value: T | Option[T],
    label: String,
    fieldKey: Option[String] = None,
    message: Option[String] = None
  ) extends ValidatorBase(label, message):

    def valid: Boolean = value match
      case Some(v)            => v.valid
      case x: EntityValidator => x.valid
      case _                  => false

    def field: String = fieldKey.getOrElse(label)

  case class SizeValidator(
    value: String,
    label: String,
    max: Int,
    min: Int = 0,
    fieldKey: Option[String] = None,
    message: Option[String] = None
  ) extends ValidatorBase(label, message):
    def valid: Boolean =
      value != null && value.length <= max && value.length >= min
    def field: String = fieldKey.getOrElse(label)

  case class EmptyValidator(
    value: String,
    label: String,
    fieldKey: Option[String] = None,
    message: Option[String] = None
  ) extends ValidatorBase(label, message):
    def valid: Boolean = value != null && !value.trim.isEmpty
    def field: String = fieldKey.getOrElse(label)

  case class IntValidator(
    value: Int,
    label: String,
    max: Int,
    min: Int = 0,
    fieldKey: Option[String] = None,
    message: Option[String] = None
  ) extends ValidatorBase(label, message):
    def valid: Boolean = value <= max && value >= min
    def field: String = fieldKey.getOrElse(label)

  case class DoubleValidator(
    value: Double,
    label: String,
    max: Double,
    min: Double = 0,
    fieldKey: Option[String] = None,
    message: Option[String] = None
  ) extends ValidatorBase(label, message):
    def valid: Boolean = value <= max && value >= min
    def field: String = fieldKey.getOrElse(label)

  case class RequiredValidator[T](
    value: Option[T],
    label: String,
    fieldKey: Option[String] = None,
    message: Option[String] = None
  ) extends ValidatorBase(label, message):
    def valid: Boolean = value.nonEmpty
    def field: String = fieldKey.getOrElse(label)

  case class BooleanValidator(
    value: Boolean,
    label: String,
    fieldKey: Option[String] = None,
    message: Option[String] = None
  ) extends ValidatorBase(label, message):
    def valid: Boolean = value
    def field: String = fieldKey.getOrElse(label)

  case class DateValidator(
    value: Option[String],
    label: String,
    fieldKey: Option[String] = None,
    message: Option[String] = None
  ) extends ValidatorBase(label, message):
    def valid: Boolean = value.isEmpty // || DateUtil.isValid(value.get)

    def field: String = fieldKey.getOrElse(label)

  case class MaybeValidator(message: Option[String], vs: ValidatorBase*)
    extends ValidatorBase("", message):

    def valid: Boolean = vs.count(_.valid) == 1

    def field: String = vs.find(!_.valid).map(_.field).getOrElse("")

    def fields: String = vs.map(_.lbl).mkString(" ou ")
