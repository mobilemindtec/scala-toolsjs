package io.tools.facede

import org.querki.jquery.*
import org.querki.jsext.*
import org.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

@js.native
trait MaskMoneyOpt extends js.Object

class MaskMoneyOpts(
  val prefix: String = "",
  val allowNegative: Boolean = false,
  val thousands: String = ",",
  val decimal: String = ".",
  val affixesStay: Boolean = false
) extends js.Object

@js.native
trait MaskMoney extends JQuery:
  def maskMoney(opts: MaskMoneyOpts): JQuery = js.native
  def maskMoney(s: String): JQuery

object MaskMoney:
  // implicit def jq2maskMoney(jq: JQuery): MaskMoney = jq.asInstanceOf[MaskMoney]
  extension (jq: JQuery)
    def maskMoney(opts: MaskMoneyOpts) = jq.asInstanceOf[MaskMoney].maskMoney(opts)
    def maskMoney() = jq.asInstanceOf[MaskMoney].maskMoney(MaskMoneyOpts())
    def maskMoney(s: String) = jq.asInstanceOf[MaskMoney].maskMoney(s)
    def unmasked: Double = maskMoney("unmasked")(0).asInstanceOf[Double]
