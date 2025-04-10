package io.tools.util

object NumberUtil:

  def toMoney(d: Double): String =
    String.format("%,.2f", d)

  def doubleFromStr(str: String): Double =
    try str.toDouble
    catch _ => 0

  def intFromStr(str: String): Int =
    try str.toInt
    catch _ => 0
