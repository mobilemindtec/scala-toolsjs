package io.tools.util

object MaskNumber:

  def round(d: Double) =
    BigDecimal(d).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble

  def mask(d: Double, mk: String) =

    val numPattern = "[0-9]".r
    val text = round(d).toString.replaceAll("[^0-9]", "")
    var newText = ""
    var j = 0

    for i <- 0 to mk.length do
      val m = Character.toString(mk.charAt(i))
      if j >= text.length then
        if m != "?" then newText += m
      else
        val c = Character.toString(text.charAt(j))
        if numPattern.matches(c) then
          if numPattern.matches(m) || m == "" then
            newText += c
            j += 1
          else newText += m

    newText

  def reverse(d: Double, mk: String) =
    val numPattern = "[0-9]".r
    val text = round(d).toString.replaceAll("[^0-9]", "").reverse
    var newText = ""
    var j = 0
    for i <- Range(0, mk.length).reverse do
      var m = Character.toString(mk.charAt(i))
      if j >= text.length then newText += m
      else
        val c = Character.toString(text.charAt(j))
        if numPattern.matches(c) then
          if numPattern.matches(m) || m == "?" then
            newText += c
            j += 1
          else newText += m

    newText = newText.reverse
    if newText.contains("?") then
      newText = newText.split("\\?").last
      if List(".", ",").contains(newText.charAt(0).toString) then
        newText.substring(1, newText.length)
      else
        newText
    else newText
