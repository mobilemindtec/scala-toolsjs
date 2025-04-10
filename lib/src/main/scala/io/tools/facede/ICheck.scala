package io.tools.facede

import org.querki.jquery.JQuery

import scala.scalajs.js

class ICheckOpts(
                  val checkboxClass: String = "icheckbox_square-green",
                  val radioClass: String = "iradio_square-green"
                ) extends js.Object

@js.native
trait ICheck extends JQuery:
  def iCheck(opts: ICheckOpts): JQuery = js.native
  def iCheck(s: String): JQuery = js.native

object ICheck:
  extension (jq: JQuery) def iCheck(opts: ICheckOpts = ICheckOpts()) = jq.asInstanceOf[ICheck].iCheck(opts)
  extension (jq: JQuery) def iCheck(s: String) = jq.asInstanceOf[ICheck].iCheck(s)

