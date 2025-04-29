package io.tools.styles

import com.raquo.laminar.api.L.*
import com.raquo.laminar.modifiers.Modifier
import com.raquo.laminar.nodes.ReactiveHtmlElement
import com.raquo.laminar.tags.HtmlTag
import io.tools.CustomReactiveElement
import org.scalajs.dom
import org.scalajs.dom.HTMLElement

import scala.collection.mutable



/**
 * Exemple
 * {{{
 *
 *  object style:
 *    extension [A <: HTMLElement](el: HtmlTag[A])
 *      def `my-css-class` = elem_(el, "my-css-class")
 *
 *    def useImport(obj: js.Object): Unit = ()
 *
 *  @JSImport("stylesheets/styles.scss", JSImport.Namespace)
 *  @js.native
 *  private object Styles extends js.Object
 *
 *  def importStyles(): Unit = useImport(Styles)
 *
 * }}}
 *
 * So call <code>styles.importStyles()</code> on <code>main</code>
 *
 * @tparam A
 */
trait Style[A <: HTMLElement](element: HtmlTag[A]):
  private val classes: mutable.ListBuffer[String] = mutable.ListBuffer.empty

  type Class <: Style[A]

  def empty =
    val clz = classes.mkString(" ")
    element(cls(clz))

  def add(css: String): Class =
    classes.append(css)
    this.asInstanceOf[Class]

  protected def build(css: String, m: => CustomReactiveElement*): CustomReactiveElement =
    val clz = (css +: classes).mkString(" ")
    element(cls(clz), m)


case class elem_(el: HtmlTag[dom.html.Element], css: String):
  def apply(modifiers: => CustomReactiveElement*): ReactiveHtmlElement[dom.html.Element] =
    el(cls(css), modifiers)




