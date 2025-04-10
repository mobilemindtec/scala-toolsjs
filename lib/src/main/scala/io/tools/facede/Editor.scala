package io.tools.facede

import org.scalajs.dom.Element

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSImport}

class EditorOpts(val element: Element) extends js.Object

object EditorOpts:
  def apply(element: Element): EditorOpts = new EditorOpts(element)

@js.native
trait EditorCodeMirror extends js.Object:
  def getValue(): String = js.native

  def setValue(v: String): Unit = js.native

/**
 * procurar referências em SwarmAdmin
 */
@js.native
@JSGlobal
class Editor extends js.Object:

  def apply(): Editor = js.native

  val codemirror: EditorCodeMirror = js.native

  def render(element: Element): Unit = js.native

  def render(): Unit = js.native
  def markdown(s: String): String = js.native