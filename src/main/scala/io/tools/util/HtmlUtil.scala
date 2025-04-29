package io.tools.util

import org.scalajs.dom
import org.scalajs.dom.HTMLInputElement

object HtmlUtil:

  def getValueById(id: String) =
    dom.document.getElementById(id).asInstanceOf[HTMLInputElement].value

  def getValueByIdAsInt(id: String) = NumberUtil.intFromStr(getValueById(id))

  def getValueByIdAsDouble(id: String) = NumberUtil.doubleFromStr(getValueById(id))

  def getValueByIdAsCheck(id: String) =
    dom.document.getElementById(id).asInstanceOf[HTMLInputElement].checked

