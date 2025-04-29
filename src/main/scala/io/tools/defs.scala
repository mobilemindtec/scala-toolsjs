package io.tools

import com.raquo.laminar.modifiers.Modifier
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

type CustomReactiveElement = Modifier[ReactiveHtmlElement[dom.html.Element]]

object defs:
  extension [A](s: Seq[A])
    def mapWithIndex[B](f: (Int, A) => B): Seq[B] =
      s.indices.map { i => f(i, s(i)) }

  val timestampFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  val dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy")
  val dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

object OptionPickler extends upickle.AttributeTagged:
  override implicit def OptionWriter[T: Writer]: Writer[Option[T]] =
    implicitly[Writer[T]].comap[Option[T]] {
      case None    => null.asInstanceOf[T]
      case Some(x) => x
    }

  override implicit def OptionReader[T: Reader]: Reader[Option[T]] =
    new Reader.Delegate[Any, Option[T]](implicitly[Reader[T]].map(Some(_))) {
      override def visitNull(index: Int) = None
    }

  def camelToSnake(s: String) =
    s.replaceAll("([A-Z])", "#$1").split('#').map(_.toLowerCase).mkString("_")

  def snakeToCamel(s: String) =
    val res = s.split("_", -1).map(x => s"${x.charAt(0).toUpper}${x.drop(1)}").mkString
    s"${s.charAt(0).toLower}${res.drop(1)}"

  override def serializeDefaults: Boolean = true

  override def objectAttributeKeyReadMap(s: CharSequence) =
    snakeToCamel(s.toString)

  override def objectAttributeKeyWriteMap(s: CharSequence) =
    camelToSnake(s.toString)

  override def objectTypeKeyReadMap(s: CharSequence) =
    snakeToCamel(s.toString)

  override def objectTypeKeyWriteMap(s: CharSequence) =
    camelToSnake(s.toString)

  given localDateDateRW: ReadWriter[LocalDateTime] =
    readwriter[String].bimap[LocalDateTime](
      d => d.format(defs.timestampFormat),
      s => LocalDateTime.parse(s, defs.timestampFormat)
    )
