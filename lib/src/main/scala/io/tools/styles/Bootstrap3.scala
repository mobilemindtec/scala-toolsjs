package io.tools.styles

import com.raquo.laminar.api.L.*
import com.raquo.laminar.tags.HtmlTag
import org.scalajs.dom
import org.scalajs.dom.HTMLElement
import io.tools.CustomReactiveElement

object Bootstrap3:

  extension [A <: HTMLElement](el: HtmlTag[A])
    def bs = new BSElement(el)

  class BSElement[A <: HTMLElement](element: HtmlTag[A]) extends Style(element):

    type Class = BSElement[A]

    def `btn-default` = add("btn-default")

    def `btn-default`(m: => CustomReactiveElement*) = build("btn-default", m)

    def `btn-primary` = add("btn-primary")

    def `btn-primary`(m: => CustomReactiveElement*) = build("btn-primary", m)

    def `btn-success` = add("btn-success")

    def `btn-success`(m: => CustomReactiveElement*) = build("btn-success", m)

    def `btn-info` = add("btn-info")

    def `btn-info`(m: => CustomReactiveElement*) = build("btn-info", m)

    def `btn-warning` = add("btn-warning")

    def `btn-warning`(m: => CustomReactiveElement*) = build("btn-warning", m)

    def `btn-danger` = add("btn-danger")

    def `btn-danger`(m: => CustomReactiveElement*) = build("btn-danger", m)

    def active = add("active")

    def active(m: => CustomReactiveElement*) = build("active", m)

    def disabled = add("disabled")

    def disabled(m: => CustomReactiveElement*) = build("disabled", m)

    def badge = add("badge")

    def badge(m: => CustomReactiveElement*) = build("badge", m)

    def btn = add("btn")

    def btn(m: => CustomReactiveElement*) = build("btn", m)

    def focus = add("focus")

    def focus(m: => CustomReactiveElement*) = build("focus", m)

    def thumbnail = add("thumbnail")

    def thumbnail(m: => CustomReactiveElement*) = build("thumbnail", m)

    def `img-thumbnail` = add("img-thumbnail")

    def `img-thumbnail`(m: => CustomReactiveElement*) = build("img-thumbnail", m)

    def `dropdown-menu` = add("dropdown-menu")

    def `dropdown-menu`(m: => CustomReactiveElement*) = build("dropdown-menu", m)

    def `navbar-default` = add("navbar-default")

    def `navbar-default`(m: => CustomReactiveElement*) = build("navbar-default", m)

    def `navbar-nav` = add("navbar-nav")

    def `navbar-nav`(m: => CustomReactiveElement*) = build("navbar-nav", m)

    def open = add("open")

    def open(m: => CustomReactiveElement*) = build("open", m)

    def `navbar-brand` = add("navbar-brand")

    def `navbar-brand`(m: => CustomReactiveElement*) = build("navbar-brand", m)

    def `navbar-inverse` = add("navbar-inverse")

    def `navbar-inverse`(m: => CustomReactiveElement*) = build("navbar-inverse", m)

    def `navbar-static-top` = add("navbar-static-top")

    def `navbar-static-top`(m: => CustomReactiveElement*) = build("navbar-static-top", m)

    def `navbar-fixed-top` = add("navbar-fixed-top")

    def `navbar-fixed-top`(m: => CustomReactiveElement*) = build("navbar-fixed-top", m)

    def `navbar-fixed-bottom` = add("navbar-fixed-bottom")

    def `navbar-fixed-bottom`(m: => CustomReactiveElement*) = build("navbar-fixed-bottom", m)

    def alert = add("alert")

    def alert(m: => CustomReactiveElement*) = build("alert", m)

    def `alert-success` = add("alert-success")

    def `alert-success`(m: => CustomReactiveElement*) = build("alert-success", m)

    def `alert-info` = add("alert-info")

    def `alert-info`(m: => CustomReactiveElement*) = build("alert-info", m)

    def `alert-warning` = add("alert-warning")

    def `alert-warning`(m: => CustomReactiveElement*) = build("alert-warning", m)

    def `alert-danger` = add("alert-danger")

    def `alert-danger`(m: => CustomReactiveElement*) = build("alert-danger", m)

    def progress = add("progress")

    def progress(m: => CustomReactiveElement*) = build("progress", m)

    def `progress-bar` = add("progress-bar")

    def `progress-bar`(m: => CustomReactiveElement*) = build("progress-bar", m)

    def `progress-bar-success` = add("progress-bar-success")

    def `progress-bar-success`(m: => CustomReactiveElement*) = build("progress-bar-success", m)

    def `progress-bar-info` = add("progress-bar-info")

    def `progress-bar-info`(m: => CustomReactiveElement*) = build("progress-bar-info", m)

    def `progress-bar-warning` = add("progress-bar-warning")

    def `progress-bar-warning`(m: => CustomReactiveElement*) = build("progress-bar-warning", m)

    def `progress-bar-danger` = add("progress-bar-danger")

    def `progress-bar-danger`(m: => CustomReactiveElement*) = build("progress-bar-danger", m)

    def `progress-bar-striped` = add("progress-bar-striped")

    def `progress-bar-striped`(m: => CustomReactiveElement*) = build("progress-bar-striped", m)

    def `list-group` = add("list-group")

    def `list-group`(m: => CustomReactiveElement*) = build("list-group", m)

    def `list-group-item` = add("list-group-item")

    def `list-group-item`(m: => CustomReactiveElement*) = build("list-group-item", m)

    def panel = add("panel")

    def panel(m: => CustomReactiveElement*) = build("panel", m)

    def `panel-default` = add("panel-default")

    def `panel-default`(m: => CustomReactiveElement*) = build("panel-default", m)

    def `panel-heading` = add("panel-heading")

    def `panel-heading`(m: => CustomReactiveElement*) = build("panel-heading", m)

    def `panel-primary` = add("panel-primary")

    def `panel-primary`(m: => CustomReactiveElement*) = build("panel-primary", m)

    def `panel-success` = add("panel-success")

    def `panel-success`(m: => CustomReactiveElement*) = build("panel-success", m)

    def `panel-info` = add("panel-info")

    def `panel-info`(m: => CustomReactiveElement*) = build("panel-info", m)

    def `panel-warning` = add("panel-warning")

    def `panel-warning`(m: => CustomReactiveElement*) = build("panel-warning", m)

    def `panel-danger` = add("panel-danger")

    def `panel-danger`(m: => CustomReactiveElement*) = build("panel-danger", m)

    def well = add("well")

    def well(m: => CustomReactiveElement*) = build("well", m)

    def glyphicon = add("glyphicon")

    def glyphicon(m: => CustomReactiveElement*) = build("glyphicon", m)

    def `glyphicon-asterisk` = add("glyphicon-asterisk")

    def `glyphicon-asterisk`(m: => CustomReactiveElement*) = build("glyphicon-asterisk", m)

    def `glyphicon-plus` = add("glyphicon-plus")

    def `glyphicon-plus`(m: => CustomReactiveElement*) = build("glyphicon-plus", m)

    def `glyphicon-euro` = add("glyphicon-euro")

    def `glyphicon-euro`(m: => CustomReactiveElement*) = build("glyphicon-euro", m)

    def `glyphicon-eur` = add("glyphicon-eur")

    def `glyphicon-eur`(m: => CustomReactiveElement*) = build("glyphicon-eur", m)

    def `glyphicon-minus` = add("glyphicon-minus")

    def `glyphicon-minus`(m: => CustomReactiveElement*) = build("glyphicon-minus", m)

    def `glyphicon-cloud` = add("glyphicon-cloud")

    def `glyphicon-cloud`(m: => CustomReactiveElement*) = build("glyphicon-cloud", m)

    def `glyphicon-envelope` = add("glyphicon-envelope")

    def `glyphicon-envelope`(m: => CustomReactiveElement*) = build("glyphicon-envelope", m)

    def `glyphicon-pencil` = add("glyphicon-pencil")

    def `glyphicon-pencil`(m: => CustomReactiveElement*) = build("glyphicon-pencil", m)

    def `glyphicon-glass` = add("glyphicon-glass")

    def `glyphicon-glass`(m: => CustomReactiveElement*) = build("glyphicon-glass", m)

    def `glyphicon-music` = add("glyphicon-music")

    def `glyphicon-music`(m: => CustomReactiveElement*) = build("glyphicon-music", m)

    def `glyphicon-search` = add("glyphicon-search")

    def `glyphicon-search`(m: => CustomReactiveElement*) = build("glyphicon-search", m)

    def `glyphicon-heart` = add("glyphicon-heart")

    def `glyphicon-heart`(m: => CustomReactiveElement*) = build("glyphicon-heart", m)

    def `glyphicon-star` = add("glyphicon-star")

    def `glyphicon-star`(m: => CustomReactiveElement*) = build("glyphicon-star", m)

    def `glyphicon-star-empty` = add("glyphicon-star-empty")

    def `glyphicon-star-empty`(m: => CustomReactiveElement*) = build("glyphicon-star-empty", m)

    def `glyphicon-user` = add("glyphicon-user")

    def `glyphicon-user`(m: => CustomReactiveElement*) = build("glyphicon-user", m)

    def `glyphicon-film` = add("glyphicon-film")

    def `glyphicon-film`(m: => CustomReactiveElement*) = build("glyphicon-film", m)

    def `glyphicon-th-large` = add("glyphicon-th-large")

    def `glyphicon-th-large`(m: => CustomReactiveElement*) = build("glyphicon-th-large", m)

    def `glyphicon-th` = add("glyphicon-th")

    def `glyphicon-th`(m: => CustomReactiveElement*) = build("glyphicon-th", m)

    def `glyphicon-th-list` = add("glyphicon-th-list")

    def `glyphicon-th-list`(m: => CustomReactiveElement*) = build("glyphicon-th-list", m)

    def `glyphicon-ok` = add("glyphicon-ok")

    def `glyphicon-ok`(m: => CustomReactiveElement*) = build("glyphicon-ok", m)

    def `glyphicon-remove` = add("glyphicon-remove")

    def `glyphicon-remove`(m: => CustomReactiveElement*) = build("glyphicon-remove", m)

    def `glyphicon-zoom-in` = add("glyphicon-zoom-in")

    def `glyphicon-zoom-in`(m: => CustomReactiveElement*) = build("glyphicon-zoom-in", m)

    def `glyphicon-zoom-out` = add("glyphicon-zoom-out")

    def `glyphicon-zoom-out`(m: => CustomReactiveElement*) = build("glyphicon-zoom-out", m)

    def `glyphicon-off` = add("glyphicon-off")

    def `glyphicon-off`(m: => CustomReactiveElement*) = build("glyphicon-off", m)

    def `glyphicon-signal` = add("glyphicon-signal")

    def `glyphicon-signal`(m: => CustomReactiveElement*) = build("glyphicon-signal", m)

    def `glyphicon-cog` = add("glyphicon-cog")

    def `glyphicon-cog`(m: => CustomReactiveElement*) = build("glyphicon-cog", m)

    def `glyphicon-trash` = add("glyphicon-trash")

    def `glyphicon-trash`(m: => CustomReactiveElement*) = build("glyphicon-trash", m)

    def `glyphicon-home` = add("glyphicon-home")

    def `glyphicon-home`(m: => CustomReactiveElement*) = build("glyphicon-home", m)

    def `glyphicon-file` = add("glyphicon-file")

    def `glyphicon-file`(m: => CustomReactiveElement*) = build("glyphicon-file", m)

    def `glyphicon-time` = add("glyphicon-time")

    def `glyphicon-time`(m: => CustomReactiveElement*) = build("glyphicon-time", m)

    def `glyphicon-road` = add("glyphicon-road")

    def `glyphicon-road`(m: => CustomReactiveElement*) = build("glyphicon-road", m)

    def `glyphicon-download-alt` = add("glyphicon-download-alt")

    def `glyphicon-download-alt`(m: => CustomReactiveElement*) = build("glyphicon-download-alt", m)

    def `glyphicon-download` = add("glyphicon-download")

    def `glyphicon-download`(m: => CustomReactiveElement*) = build("glyphicon-download", m)

    def `glyphicon-upload` = add("glyphicon-upload")

    def `glyphicon-upload`(m: => CustomReactiveElement*) = build("glyphicon-upload", m)

    def `glyphicon-inbox` = add("glyphicon-inbox")

    def `glyphicon-inbox`(m: => CustomReactiveElement*) = build("glyphicon-inbox", m)

    def `glyphicon-play-circle` = add("glyphicon-play-circle")

    def `glyphicon-play-circle`(m: => CustomReactiveElement*) = build("glyphicon-play-circle", m)

    def `glyphicon-repeat` = add("glyphicon-repeat")

    def `glyphicon-repeat`(m: => CustomReactiveElement*) = build("glyphicon-repeat", m)

    def `glyphicon-refresh` = add("glyphicon-refresh")

    def `glyphicon-refresh`(m: => CustomReactiveElement*) = build("glyphicon-refresh", m)

    def `glyphicon-list-alt` = add("glyphicon-list-alt")

    def `glyphicon-list-alt`(m: => CustomReactiveElement*) = build("glyphicon-list-alt", m)

    def `glyphicon-lock` = add("glyphicon-lock")

    def `glyphicon-lock`(m: => CustomReactiveElement*) = build("glyphicon-lock", m)

    def `glyphicon-flag` = add("glyphicon-flag")

    def `glyphicon-flag`(m: => CustomReactiveElement*) = build("glyphicon-flag", m)

    def `glyphicon-headphones` = add("glyphicon-headphones")

    def `glyphicon-headphones`(m: => CustomReactiveElement*) = build("glyphicon-headphones", m)

    def `glyphicon-volume-off` = add("glyphicon-volume-off")

    def `glyphicon-volume-off`(m: => CustomReactiveElement*) = build("glyphicon-volume-off", m)

    def `glyphicon-volume-down` = add("glyphicon-volume-down")

    def `glyphicon-volume-down`(m: => CustomReactiveElement*) = build("glyphicon-volume-down", m)

    def `glyphicon-volume-up` = add("glyphicon-volume-up")

    def `glyphicon-volume-up`(m: => CustomReactiveElement*) = build("glyphicon-volume-up", m)

    def `glyphicon-qrcode` = add("glyphicon-qrcode")

    def `glyphicon-qrcode`(m: => CustomReactiveElement*) = build("glyphicon-qrcode", m)

    def `glyphicon-barcode` = add("glyphicon-barcode")

    def `glyphicon-barcode`(m: => CustomReactiveElement*) = build("glyphicon-barcode", m)

    def `glyphicon-tag` = add("glyphicon-tag")

    def `glyphicon-tag`(m: => CustomReactiveElement*) = build("glyphicon-tag", m)

    def `glyphicon-tags` = add("glyphicon-tags")

    def `glyphicon-tags`(m: => CustomReactiveElement*) = build("glyphicon-tags", m)

    def `glyphicon-book` = add("glyphicon-book")

    def `glyphicon-book`(m: => CustomReactiveElement*) = build("glyphicon-book", m)

    def `glyphicon-bookmark` = add("glyphicon-bookmark")

    def `glyphicon-bookmark`(m: => CustomReactiveElement*) = build("glyphicon-bookmark", m)

    def `glyphicon-print` = add("glyphicon-print")

    def `glyphicon-print`(m: => CustomReactiveElement*) = build("glyphicon-print", m)

    def `glyphicon-camera` = add("glyphicon-camera")

    def `glyphicon-camera`(m: => CustomReactiveElement*) = build("glyphicon-camera", m)

    def `glyphicon-font` = add("glyphicon-font")

    def `glyphicon-font`(m: => CustomReactiveElement*) = build("glyphicon-font", m)

    def `glyphicon-bold` = add("glyphicon-bold")

    def `glyphicon-bold`(m: => CustomReactiveElement*) = build("glyphicon-bold", m)

    def `glyphicon-italic` = add("glyphicon-italic")

    def `glyphicon-italic`(m: => CustomReactiveElement*) = build("glyphicon-italic", m)

    def `glyphicon-text-height` = add("glyphicon-text-height")

    def `glyphicon-text-height`(m: => CustomReactiveElement*) = build("glyphicon-text-height", m)

    def `glyphicon-text-width` = add("glyphicon-text-width")

    def `glyphicon-text-width`(m: => CustomReactiveElement*) = build("glyphicon-text-width", m)

    def `glyphicon-align-left` = add("glyphicon-align-left")

    def `glyphicon-align-left`(m: => CustomReactiveElement*) = build("glyphicon-align-left", m)

    def `glyphicon-align-center` = add("glyphicon-align-center")

    def `glyphicon-align-center`(m: => CustomReactiveElement*) = build("glyphicon-align-center", m)

    def `glyphicon-align-right` = add("glyphicon-align-right")

    def `glyphicon-align-right`(m: => CustomReactiveElement*) = build("glyphicon-align-right", m)

    def `glyphicon-align-justify` = add("glyphicon-align-justify")

    def `glyphicon-align-justify`(m: => CustomReactiveElement*) = build("glyphicon-align-justify", m)

    def `glyphicon-list` = add("glyphicon-list")

    def `glyphicon-list`(m: => CustomReactiveElement*) = build("glyphicon-list", m)

    def `glyphicon-indent-left` = add("glyphicon-indent-left")

    def `glyphicon-indent-left`(m: => CustomReactiveElement*) = build("glyphicon-indent-left", m)

    def `glyphicon-indent-right` = add("glyphicon-indent-right")

    def `glyphicon-indent-right`(m: => CustomReactiveElement*) = build("glyphicon-indent-right", m)

    def `glyphicon-facetime-video` = add("glyphicon-facetime-video")

    def `glyphicon-facetime-video`(m: => CustomReactiveElement*) = build("glyphicon-facetime-video", m)

    def `glyphicon-picture` = add("glyphicon-picture")

    def `glyphicon-picture`(m: => CustomReactiveElement*) = build("glyphicon-picture", m)

    def `glyphicon-map-marker` = add("glyphicon-map-marker")

    def `glyphicon-map-marker`(m: => CustomReactiveElement*) = build("glyphicon-map-marker", m)

    def `glyphicon-adjust` = add("glyphicon-adjust")

    def `glyphicon-adjust`(m: => CustomReactiveElement*) = build("glyphicon-adjust", m)

    def `glyphicon-tint` = add("glyphicon-tint")

    def `glyphicon-tint`(m: => CustomReactiveElement*) = build("glyphicon-tint", m)

    def `glyphicon-edit` = add("glyphicon-edit")

    def `glyphicon-edit`(m: => CustomReactiveElement*) = build("glyphicon-edit", m)

    def `glyphicon-share` = add("glyphicon-share")

    def `glyphicon-share`(m: => CustomReactiveElement*) = build("glyphicon-share", m)

    def `glyphicon-check` = add("glyphicon-check")

    def `glyphicon-check`(m: => CustomReactiveElement*) = build("glyphicon-check", m)

    def `glyphicon-move` = add("glyphicon-move")

    def `glyphicon-move`(m: => CustomReactiveElement*) = build("glyphicon-move", m)

    def `glyphicon-step-backward` = add("glyphicon-step-backward")

    def `glyphicon-step-backward`(m: => CustomReactiveElement*) = build("glyphicon-step-backward", m)

    def `glyphicon-fast-backward` = add("glyphicon-fast-backward")

    def `glyphicon-fast-backward`(m: => CustomReactiveElement*) = build("glyphicon-fast-backward", m)

    def `glyphicon-backward` = add("glyphicon-backward")

    def `glyphicon-backward`(m: => CustomReactiveElement*) = build("glyphicon-backward", m)

    def `glyphicon-play` = add("glyphicon-play")

    def `glyphicon-play`(m: => CustomReactiveElement*) = build("glyphicon-play", m)

    def `glyphicon-pause` = add("glyphicon-pause")

    def `glyphicon-pause`(m: => CustomReactiveElement*) = build("glyphicon-pause", m)

    def `glyphicon-stop` = add("glyphicon-stop")

    def `glyphicon-stop`(m: => CustomReactiveElement*) = build("glyphicon-stop", m)

    def `glyphicon-forward` = add("glyphicon-forward")

    def `glyphicon-forward`(m: => CustomReactiveElement*) = build("glyphicon-forward", m)

    def `glyphicon-fast-forward` = add("glyphicon-fast-forward")

    def `glyphicon-fast-forward`(m: => CustomReactiveElement*) = build("glyphicon-fast-forward", m)

    def `glyphicon-step-forward` = add("glyphicon-step-forward")

    def `glyphicon-step-forward`(m: => CustomReactiveElement*) = build("glyphicon-step-forward", m)

    def `glyphicon-eject` = add("glyphicon-eject")

    def `glyphicon-eject`(m: => CustomReactiveElement*) = build("glyphicon-eject", m)

    def `glyphicon-chevron-left` = add("glyphicon-chevron-left")

    def `glyphicon-chevron-left`(m: => CustomReactiveElement*) = build("glyphicon-chevron-left", m)

    def `glyphicon-chevron-right` = add("glyphicon-chevron-right")

    def `glyphicon-chevron-right`(m: => CustomReactiveElement*) = build("glyphicon-chevron-right", m)

    def `glyphicon-plus-sign` = add("glyphicon-plus-sign")

    def `glyphicon-plus-sign`(m: => CustomReactiveElement*) = build("glyphicon-plus-sign", m)

    def `glyphicon-minus-sign` = add("glyphicon-minus-sign")

    def `glyphicon-minus-sign`(m: => CustomReactiveElement*) = build("glyphicon-minus-sign", m)

    def `glyphicon-remove-sign` = add("glyphicon-remove-sign")

    def `glyphicon-remove-sign`(m: => CustomReactiveElement*) = build("glyphicon-remove-sign", m)

    def `glyphicon-ok-sign` = add("glyphicon-ok-sign")

    def `glyphicon-ok-sign`(m: => CustomReactiveElement*) = build("glyphicon-ok-sign", m)

    def `glyphicon-question-sign` = add("glyphicon-question-sign")

    def `glyphicon-question-sign`(m: => CustomReactiveElement*) = build("glyphicon-question-sign", m)

    def `glyphicon-info-sign` = add("glyphicon-info-sign")

    def `glyphicon-info-sign`(m: => CustomReactiveElement*) = build("glyphicon-info-sign", m)

    def `glyphicon-screenshot` = add("glyphicon-screenshot")

    def `glyphicon-screenshot`(m: => CustomReactiveElement*) = build("glyphicon-screenshot", m)

    def `glyphicon-remove-circle` = add("glyphicon-remove-circle")

    def `glyphicon-remove-circle`(m: => CustomReactiveElement*) = build("glyphicon-remove-circle", m)

    def `glyphicon-ok-circle` = add("glyphicon-ok-circle")

    def `glyphicon-ok-circle`(m: => CustomReactiveElement*) = build("glyphicon-ok-circle", m)

    def `glyphicon-ban-circle` = add("glyphicon-ban-circle")

    def `glyphicon-ban-circle`(m: => CustomReactiveElement*) = build("glyphicon-ban-circle", m)

    def `glyphicon-arrow-left` = add("glyphicon-arrow-left")

    def `glyphicon-arrow-left`(m: => CustomReactiveElement*) = build("glyphicon-arrow-left", m)

    def `glyphicon-arrow-right` = add("glyphicon-arrow-right")

    def `glyphicon-arrow-right`(m: => CustomReactiveElement*) = build("glyphicon-arrow-right", m)

    def `glyphicon-arrow-up` = add("glyphicon-arrow-up")

    def `glyphicon-arrow-up`(m: => CustomReactiveElement*) = build("glyphicon-arrow-up", m)

    def `glyphicon-arrow-down` = add("glyphicon-arrow-down")

    def `glyphicon-arrow-down`(m: => CustomReactiveElement*) = build("glyphicon-arrow-down", m)

    def `glyphicon-share-alt` = add("glyphicon-share-alt")

    def `glyphicon-share-alt`(m: => CustomReactiveElement*) = build("glyphicon-share-alt", m)

    def `glyphicon-resize-full` = add("glyphicon-resize-full")

    def `glyphicon-resize-full`(m: => CustomReactiveElement*) = build("glyphicon-resize-full", m)

    def `glyphicon-resize-small` = add("glyphicon-resize-small")

    def `glyphicon-resize-small`(m: => CustomReactiveElement*) = build("glyphicon-resize-small", m)

    def `glyphicon-exclamation-sign` = add("glyphicon-exclamation-sign")

    def `glyphicon-exclamation-sign`(m: => CustomReactiveElement*) = build("glyphicon-exclamation-sign", m)

    def `glyphicon-gift` = add("glyphicon-gift")

    def `glyphicon-gift`(m: => CustomReactiveElement*) = build("glyphicon-gift", m)

    def `glyphicon-leaf` = add("glyphicon-leaf")

    def `glyphicon-leaf`(m: => CustomReactiveElement*) = build("glyphicon-leaf", m)

    def `glyphicon-fire` = add("glyphicon-fire")

    def `glyphicon-fire`(m: => CustomReactiveElement*) = build("glyphicon-fire", m)

    def `glyphicon-eye-open` = add("glyphicon-eye-open")

    def `glyphicon-eye-open`(m: => CustomReactiveElement*) = build("glyphicon-eye-open", m)

    def `glyphicon-eye-close` = add("glyphicon-eye-close")

    def `glyphicon-eye-close`(m: => CustomReactiveElement*) = build("glyphicon-eye-close", m)

    def `glyphicon-warning-sign` = add("glyphicon-warning-sign")

    def `glyphicon-warning-sign`(m: => CustomReactiveElement*) = build("glyphicon-warning-sign", m)

    def `glyphicon-plane` = add("glyphicon-plane")

    def `glyphicon-plane`(m: => CustomReactiveElement*) = build("glyphicon-plane", m)

    def `glyphicon-calendar` = add("glyphicon-calendar")

    def `glyphicon-calendar`(m: => CustomReactiveElement*) = build("glyphicon-calendar", m)

    def `glyphicon-random` = add("glyphicon-random")

    def `glyphicon-random`(m: => CustomReactiveElement*) = build("glyphicon-random", m)

    def `glyphicon-comment` = add("glyphicon-comment")

    def `glyphicon-comment`(m: => CustomReactiveElement*) = build("glyphicon-comment", m)

    def `glyphicon-magnet` = add("glyphicon-magnet")

    def `glyphicon-magnet`(m: => CustomReactiveElement*) = build("glyphicon-magnet", m)

    def `glyphicon-chevron-up` = add("glyphicon-chevron-up")

    def `glyphicon-chevron-up`(m: => CustomReactiveElement*) = build("glyphicon-chevron-up", m)

    def `glyphicon-chevron-down` = add("glyphicon-chevron-down")

    def `glyphicon-chevron-down`(m: => CustomReactiveElement*) = build("glyphicon-chevron-down", m)

    def `glyphicon-retweet` = add("glyphicon-retweet")

    def `glyphicon-retweet`(m: => CustomReactiveElement*) = build("glyphicon-retweet", m)

    def `glyphicon-shopping-cart` = add("glyphicon-shopping-cart")

    def `glyphicon-shopping-cart`(m: => CustomReactiveElement*) = build("glyphicon-shopping-cart", m)

    def `glyphicon-folder-close` = add("glyphicon-folder-close")

    def `glyphicon-folder-close`(m: => CustomReactiveElement*) = build("glyphicon-folder-close", m)

    def `glyphicon-folder-open` = add("glyphicon-folder-open")

    def `glyphicon-folder-open`(m: => CustomReactiveElement*) = build("glyphicon-folder-open", m)

    def `glyphicon-resize-vertical` = add("glyphicon-resize-vertical")

    def `glyphicon-resize-vertical`(m: => CustomReactiveElement*) = build("glyphicon-resize-vertical", m)

    def `glyphicon-resize-horizontal` = add("glyphicon-resize-horizontal")

    def `glyphicon-resize-horizontal`(m: => CustomReactiveElement*) = build("glyphicon-resize-horizontal", m)

    def `glyphicon-hdd` = add("glyphicon-hdd")

    def `glyphicon-hdd`(m: => CustomReactiveElement*) = build("glyphicon-hdd", m)

    def `glyphicon-bullhorn` = add("glyphicon-bullhorn")

    def `glyphicon-bullhorn`(m: => CustomReactiveElement*) = build("glyphicon-bullhorn", m)

    def `glyphicon-bell` = add("glyphicon-bell")

    def `glyphicon-bell`(m: => CustomReactiveElement*) = build("glyphicon-bell", m)

    def `glyphicon-certificate` = add("glyphicon-certificate")

    def `glyphicon-certificate`(m: => CustomReactiveElement*) = build("glyphicon-certificate", m)

    def `glyphicon-thumbs-up` = add("glyphicon-thumbs-up")

    def `glyphicon-thumbs-up`(m: => CustomReactiveElement*) = build("glyphicon-thumbs-up", m)

    def `glyphicon-thumbs-down` = add("glyphicon-thumbs-down")

    def `glyphicon-thumbs-down`(m: => CustomReactiveElement*) = build("glyphicon-thumbs-down", m)

    def `glyphicon-hand-right` = add("glyphicon-hand-right")

    def `glyphicon-hand-right`(m: => CustomReactiveElement*) = build("glyphicon-hand-right", m)

    def `glyphicon-hand-left` = add("glyphicon-hand-left")

    def `glyphicon-hand-left`(m: => CustomReactiveElement*) = build("glyphicon-hand-left", m)

    def `glyphicon-hand-up` = add("glyphicon-hand-up")

    def `glyphicon-hand-up`(m: => CustomReactiveElement*) = build("glyphicon-hand-up", m)

    def `glyphicon-hand-down` = add("glyphicon-hand-down")

    def `glyphicon-hand-down`(m: => CustomReactiveElement*) = build("glyphicon-hand-down", m)

    def `glyphicon-circle-arrow-right` = add("glyphicon-circle-arrow-right")

    def `glyphicon-circle-arrow-right`(m: => CustomReactiveElement*) = build("glyphicon-circle-arrow-right", m)

    def `glyphicon-circle-arrow-left` = add("glyphicon-circle-arrow-left")

    def `glyphicon-circle-arrow-left`(m: => CustomReactiveElement*) = build("glyphicon-circle-arrow-left", m)

    def `glyphicon-circle-arrow-up` = add("glyphicon-circle-arrow-up")

    def `glyphicon-circle-arrow-up`(m: => CustomReactiveElement*) = build("glyphicon-circle-arrow-up", m)

    def `glyphicon-circle-arrow-down` = add("glyphicon-circle-arrow-down")

    def `glyphicon-circle-arrow-down`(m: => CustomReactiveElement*) = build("glyphicon-circle-arrow-down", m)

    def `glyphicon-globe` = add("glyphicon-globe")

    def `glyphicon-globe`(m: => CustomReactiveElement*) = build("glyphicon-globe", m)

    def `glyphicon-wrench` = add("glyphicon-wrench")

    def `glyphicon-wrench`(m: => CustomReactiveElement*) = build("glyphicon-wrench", m)

    def `glyphicon-tasks` = add("glyphicon-tasks")

    def `glyphicon-tasks`(m: => CustomReactiveElement*) = build("glyphicon-tasks", m)

    def `glyphicon-filter` = add("glyphicon-filter")

    def `glyphicon-filter`(m: => CustomReactiveElement*) = build("glyphicon-filter", m)

    def `glyphicon-briefcase` = add("glyphicon-briefcase")

    def `glyphicon-briefcase`(m: => CustomReactiveElement*) = build("glyphicon-briefcase", m)

    def `glyphicon-fullscreen` = add("glyphicon-fullscreen")

    def `glyphicon-fullscreen`(m: => CustomReactiveElement*) = build("glyphicon-fullscreen", m)

    def `glyphicon-dashboard` = add("glyphicon-dashboard")

    def `glyphicon-dashboard`(m: => CustomReactiveElement*) = build("glyphicon-dashboard", m)

    def `glyphicon-paperclip` = add("glyphicon-paperclip")

    def `glyphicon-paperclip`(m: => CustomReactiveElement*) = build("glyphicon-paperclip", m)

    def `glyphicon-heart-empty` = add("glyphicon-heart-empty")

    def `glyphicon-heart-empty`(m: => CustomReactiveElement*) = build("glyphicon-heart-empty", m)

    def `glyphicon-link` = add("glyphicon-link")

    def `glyphicon-link`(m: => CustomReactiveElement*) = build("glyphicon-link", m)

    def `glyphicon-phone` = add("glyphicon-phone")

    def `glyphicon-phone`(m: => CustomReactiveElement*) = build("glyphicon-phone", m)

    def `glyphicon-pushpin` = add("glyphicon-pushpin")

    def `glyphicon-pushpin`(m: => CustomReactiveElement*) = build("glyphicon-pushpin", m)

    def `glyphicon-usd` = add("glyphicon-usd")

    def `glyphicon-usd`(m: => CustomReactiveElement*) = build("glyphicon-usd", m)

    def `glyphicon-gbp` = add("glyphicon-gbp")

    def `glyphicon-gbp`(m: => CustomReactiveElement*) = build("glyphicon-gbp", m)

    def `glyphicon-sort` = add("glyphicon-sort")

    def `glyphicon-sort`(m: => CustomReactiveElement*) = build("glyphicon-sort", m)

    def `glyphicon-sort-by-alphabet` = add("glyphicon-sort-by-alphabet")

    def `glyphicon-sort-by-alphabet`(m: => CustomReactiveElement*) = build("glyphicon-sort-by-alphabet", m)

    def `glyphicon-sort-by-alphabet-alt` = add("glyphicon-sort-by-alphabet-alt")

    def `glyphicon-sort-by-alphabet-alt`(m: => CustomReactiveElement*) = build("glyphicon-sort-by-alphabet-alt", m)

    def `glyphicon-sort-by-order` = add("glyphicon-sort-by-order")

    def `glyphicon-sort-by-order`(m: => CustomReactiveElement*) = build("glyphicon-sort-by-order", m)

    def `glyphicon-sort-by-order-alt` = add("glyphicon-sort-by-order-alt")

    def `glyphicon-sort-by-order-alt`(m: => CustomReactiveElement*) = build("glyphicon-sort-by-order-alt", m)

    def `glyphicon-sort-by-attributes` = add("glyphicon-sort-by-attributes")

    def `glyphicon-sort-by-attributes`(m: => CustomReactiveElement*) = build("glyphicon-sort-by-attributes", m)

    def `glyphicon-sort-by-attributes-alt` = add("glyphicon-sort-by-attributes-alt")

    def `glyphicon-sort-by-attributes-alt`(m: => CustomReactiveElement*) = build("glyphicon-sort-by-attributes-alt", m)

    def `glyphicon-unchecked` = add("glyphicon-unchecked")

    def `glyphicon-unchecked`(m: => CustomReactiveElement*) = build("glyphicon-unchecked", m)

    def `glyphicon-expand` = add("glyphicon-expand")

    def `glyphicon-expand`(m: => CustomReactiveElement*) = build("glyphicon-expand", m)

    def `glyphicon-collapse-down` = add("glyphicon-collapse-down")

    def `glyphicon-collapse-down`(m: => CustomReactiveElement*) = build("glyphicon-collapse-down", m)

    def `glyphicon-collapse-up` = add("glyphicon-collapse-up")

    def `glyphicon-collapse-up`(m: => CustomReactiveElement*) = build("glyphicon-collapse-up", m)

    def `glyphicon-log-in` = add("glyphicon-log-in")

    def `glyphicon-log-in`(m: => CustomReactiveElement*) = build("glyphicon-log-in", m)

    def `glyphicon-flash` = add("glyphicon-flash")

    def `glyphicon-flash`(m: => CustomReactiveElement*) = build("glyphicon-flash", m)

    def `glyphicon-log-out` = add("glyphicon-log-out")

    def `glyphicon-log-out`(m: => CustomReactiveElement*) = build("glyphicon-log-out", m)

    def `glyphicon-new-window` = add("glyphicon-new-window")

    def `glyphicon-new-window`(m: => CustomReactiveElement*) = build("glyphicon-new-window", m)

    def `glyphicon-record` = add("glyphicon-record")

    def `glyphicon-record`(m: => CustomReactiveElement*) = build("glyphicon-record", m)

    def `glyphicon-save` = add("glyphicon-save")

    def `glyphicon-save`(m: => CustomReactiveElement*) = build("glyphicon-save", m)

    def `glyphicon-open` = add("glyphicon-open")

    def `glyphicon-open`(m: => CustomReactiveElement*) = build("glyphicon-open", m)

    def `glyphicon-saved` = add("glyphicon-saved")

    def `glyphicon-saved`(m: => CustomReactiveElement*) = build("glyphicon-saved", m)

    def `glyphicon-import` = add("glyphicon-import")

    def `glyphicon-import`(m: => CustomReactiveElement*) = build("glyphicon-import", m)

    def `glyphicon-export` = add("glyphicon-export")

    def `glyphicon-export`(m: => CustomReactiveElement*) = build("glyphicon-export", m)

    def `glyphicon-send` = add("glyphicon-send")

    def `glyphicon-send`(m: => CustomReactiveElement*) = build("glyphicon-send", m)

    def `glyphicon-floppy-disk` = add("glyphicon-floppy-disk")

    def `glyphicon-floppy-disk`(m: => CustomReactiveElement*) = build("glyphicon-floppy-disk", m)

    def `glyphicon-floppy-saved` = add("glyphicon-floppy-saved")

    def `glyphicon-floppy-saved`(m: => CustomReactiveElement*) = build("glyphicon-floppy-saved", m)

    def `glyphicon-floppy-remove` = add("glyphicon-floppy-remove")

    def `glyphicon-floppy-remove`(m: => CustomReactiveElement*) = build("glyphicon-floppy-remove", m)

    def `glyphicon-floppy-save` = add("glyphicon-floppy-save")

    def `glyphicon-floppy-save`(m: => CustomReactiveElement*) = build("glyphicon-floppy-save", m)

    def `glyphicon-floppy-open` = add("glyphicon-floppy-open")

    def `glyphicon-floppy-open`(m: => CustomReactiveElement*) = build("glyphicon-floppy-open", m)

    def `glyphicon-credit-card` = add("glyphicon-credit-card")

    def `glyphicon-credit-card`(m: => CustomReactiveElement*) = build("glyphicon-credit-card", m)

    def `glyphicon-transfer` = add("glyphicon-transfer")

    def `glyphicon-transfer`(m: => CustomReactiveElement*) = build("glyphicon-transfer", m)

    def `glyphicon-cutlery` = add("glyphicon-cutlery")

    def `glyphicon-cutlery`(m: => CustomReactiveElement*) = build("glyphicon-cutlery", m)

    def `glyphicon-header` = add("glyphicon-header")

    def `glyphicon-header`(m: => CustomReactiveElement*) = build("glyphicon-header", m)

    def `glyphicon-compressed` = add("glyphicon-compressed")

    def `glyphicon-compressed`(m: => CustomReactiveElement*) = build("glyphicon-compressed", m)

    def `glyphicon-earphone` = add("glyphicon-earphone")

    def `glyphicon-earphone`(m: => CustomReactiveElement*) = build("glyphicon-earphone", m)

    def `glyphicon-phone-alt` = add("glyphicon-phone-alt")

    def `glyphicon-phone-alt`(m: => CustomReactiveElement*) = build("glyphicon-phone-alt", m)

    def `glyphicon-tower` = add("glyphicon-tower")

    def `glyphicon-tower`(m: => CustomReactiveElement*) = build("glyphicon-tower", m)

    def `glyphicon-stats` = add("glyphicon-stats")

    def `glyphicon-stats`(m: => CustomReactiveElement*) = build("glyphicon-stats", m)

    def `glyphicon-sd-video` = add("glyphicon-sd-video")

    def `glyphicon-sd-video`(m: => CustomReactiveElement*) = build("glyphicon-sd-video", m)

    def `glyphicon-hd-video` = add("glyphicon-hd-video")

    def `glyphicon-hd-video`(m: => CustomReactiveElement*) = build("glyphicon-hd-video", m)

    def `glyphicon-subtitles` = add("glyphicon-subtitles")

    def `glyphicon-subtitles`(m: => CustomReactiveElement*) = build("glyphicon-subtitles", m)

    def `glyphicon-sound-stereo` = add("glyphicon-sound-stereo")

    def `glyphicon-sound-stereo`(m: => CustomReactiveElement*) = build("glyphicon-sound-stereo", m)

    def `glyphicon-sound-dolby` = add("glyphicon-sound-dolby")

    def `glyphicon-sound-dolby`(m: => CustomReactiveElement*) = build("glyphicon-sound-dolby", m)

    def `glyphicon-sound-5-1` = add("glyphicon-sound-5-1")

    def `glyphicon-sound-5-1`(m: => CustomReactiveElement*) = build("glyphicon-sound-5-1", m)

    def `glyphicon-sound-6-1` = add("glyphicon-sound-6-1")

    def `glyphicon-sound-6-1`(m: => CustomReactiveElement*) = build("glyphicon-sound-6-1", m)

    def `glyphicon-sound-7-1` = add("glyphicon-sound-7-1")

    def `glyphicon-sound-7-1`(m: => CustomReactiveElement*) = build("glyphicon-sound-7-1", m)

    def `glyphicon-copyright-mark` = add("glyphicon-copyright-mark")

    def `glyphicon-copyright-mark`(m: => CustomReactiveElement*) = build("glyphicon-copyright-mark", m)

    def `glyphicon-registration-mark` = add("glyphicon-registration-mark")

    def `glyphicon-registration-mark`(m: => CustomReactiveElement*) = build("glyphicon-registration-mark", m)

    def `glyphicon-cloud-download` = add("glyphicon-cloud-download")

    def `glyphicon-cloud-download`(m: => CustomReactiveElement*) = build("glyphicon-cloud-download", m)

    def `glyphicon-cloud-upload` = add("glyphicon-cloud-upload")

    def `glyphicon-cloud-upload`(m: => CustomReactiveElement*) = build("glyphicon-cloud-upload", m)

    def `glyphicon-tree-conifer` = add("glyphicon-tree-conifer")

    def `glyphicon-tree-conifer`(m: => CustomReactiveElement*) = build("glyphicon-tree-conifer", m)

    def `glyphicon-tree-deciduous` = add("glyphicon-tree-deciduous")

    def `glyphicon-tree-deciduous`(m: => CustomReactiveElement*) = build("glyphicon-tree-deciduous", m)

    def `glyphicon-cd` = add("glyphicon-cd")

    def `glyphicon-cd`(m: => CustomReactiveElement*) = build("glyphicon-cd", m)

    def `glyphicon-save-file` = add("glyphicon-save-file")

    def `glyphicon-save-file`(m: => CustomReactiveElement*) = build("glyphicon-save-file", m)

    def `glyphicon-open-file` = add("glyphicon-open-file")

    def `glyphicon-open-file`(m: => CustomReactiveElement*) = build("glyphicon-open-file", m)

    def `glyphicon-level-up` = add("glyphicon-level-up")

    def `glyphicon-level-up`(m: => CustomReactiveElement*) = build("glyphicon-level-up", m)

    def `glyphicon-copy` = add("glyphicon-copy")

    def `glyphicon-copy`(m: => CustomReactiveElement*) = build("glyphicon-copy", m)

    def `glyphicon-paste` = add("glyphicon-paste")

    def `glyphicon-paste`(m: => CustomReactiveElement*) = build("glyphicon-paste", m)

    def `glyphicon-alert` = add("glyphicon-alert")

    def `glyphicon-alert`(m: => CustomReactiveElement*) = build("glyphicon-alert", m)

    def `glyphicon-equalizer` = add("glyphicon-equalizer")

    def `glyphicon-equalizer`(m: => CustomReactiveElement*) = build("glyphicon-equalizer", m)

    def `glyphicon-king` = add("glyphicon-king")

    def `glyphicon-king`(m: => CustomReactiveElement*) = build("glyphicon-king", m)

    def `glyphicon-queen` = add("glyphicon-queen")

    def `glyphicon-queen`(m: => CustomReactiveElement*) = build("glyphicon-queen", m)

    def `glyphicon-pawn` = add("glyphicon-pawn")

    def `glyphicon-pawn`(m: => CustomReactiveElement*) = build("glyphicon-pawn", m)

    def `glyphicon-bishop` = add("glyphicon-bishop")

    def `glyphicon-bishop`(m: => CustomReactiveElement*) = build("glyphicon-bishop", m)

    def `glyphicon-knight` = add("glyphicon-knight")

    def `glyphicon-knight`(m: => CustomReactiveElement*) = build("glyphicon-knight", m)

    def `glyphicon-baby-formula` = add("glyphicon-baby-formula")

    def `glyphicon-baby-formula`(m: => CustomReactiveElement*) = build("glyphicon-baby-formula", m)

    def `glyphicon-tent` = add("glyphicon-tent")

    def `glyphicon-tent`(m: => CustomReactiveElement*) = build("glyphicon-tent", m)

    def `glyphicon-blackboard` = add("glyphicon-blackboard")

    def `glyphicon-blackboard`(m: => CustomReactiveElement*) = build("glyphicon-blackboard", m)

    def `glyphicon-bed` = add("glyphicon-bed")

    def `glyphicon-bed`(m: => CustomReactiveElement*) = build("glyphicon-bed", m)

    def `glyphicon-apple` = add("glyphicon-apple")

    def `glyphicon-apple`(m: => CustomReactiveElement*) = build("glyphicon-apple", m)

    def `glyphicon-erase` = add("glyphicon-erase")

    def `glyphicon-erase`(m: => CustomReactiveElement*) = build("glyphicon-erase", m)

    def `glyphicon-hourglass` = add("glyphicon-hourglass")

    def `glyphicon-hourglass`(m: => CustomReactiveElement*) = build("glyphicon-hourglass", m)

    def `glyphicon-lamp` = add("glyphicon-lamp")

    def `glyphicon-lamp`(m: => CustomReactiveElement*) = build("glyphicon-lamp", m)

    def `glyphicon-duplicate` = add("glyphicon-duplicate")

    def `glyphicon-duplicate`(m: => CustomReactiveElement*) = build("glyphicon-duplicate", m)

    def `glyphicon-piggy-bank` = add("glyphicon-piggy-bank")

    def `glyphicon-piggy-bank`(m: => CustomReactiveElement*) = build("glyphicon-piggy-bank", m)

    def `glyphicon-scissors` = add("glyphicon-scissors")

    def `glyphicon-scissors`(m: => CustomReactiveElement*) = build("glyphicon-scissors", m)

    def `glyphicon-bitcoin` = add("glyphicon-bitcoin")

    def `glyphicon-bitcoin`(m: => CustomReactiveElement*) = build("glyphicon-bitcoin", m)

    def `glyphicon-btc` = add("glyphicon-btc")

    def `glyphicon-btc`(m: => CustomReactiveElement*) = build("glyphicon-btc", m)

    def `glyphicon-xbt` = add("glyphicon-xbt")

    def `glyphicon-xbt`(m: => CustomReactiveElement*) = build("glyphicon-xbt", m)

    def `glyphicon-yen` = add("glyphicon-yen")

    def `glyphicon-yen`(m: => CustomReactiveElement*) = build("glyphicon-yen", m)

    def `glyphicon-jpy` = add("glyphicon-jpy")

    def `glyphicon-jpy`(m: => CustomReactiveElement*) = build("glyphicon-jpy", m)

    def `glyphicon-ruble` = add("glyphicon-ruble")

    def `glyphicon-ruble`(m: => CustomReactiveElement*) = build("glyphicon-ruble", m)

    def `glyphicon-rub` = add("glyphicon-rub")

    def `glyphicon-rub`(m: => CustomReactiveElement*) = build("glyphicon-rub", m)

    def `glyphicon-scale` = add("glyphicon-scale")

    def `glyphicon-scale`(m: => CustomReactiveElement*) = build("glyphicon-scale", m)

    def `glyphicon-ice-lolly` = add("glyphicon-ice-lolly")

    def `glyphicon-ice-lolly`(m: => CustomReactiveElement*) = build("glyphicon-ice-lolly", m)

    def `glyphicon-ice-lolly-tasted` = add("glyphicon-ice-lolly-tasted")

    def `glyphicon-ice-lolly-tasted`(m: => CustomReactiveElement*) = build("glyphicon-ice-lolly-tasted", m)

    def `glyphicon-education` = add("glyphicon-education")

    def `glyphicon-education`(m: => CustomReactiveElement*) = build("glyphicon-education", m)

    def `glyphicon-option-horizontal` = add("glyphicon-option-horizontal")

    def `glyphicon-option-horizontal`(m: => CustomReactiveElement*) = build("glyphicon-option-horizontal", m)

    def `glyphicon-option-vertical` = add("glyphicon-option-vertical")

    def `glyphicon-option-vertical`(m: => CustomReactiveElement*) = build("glyphicon-option-vertical", m)

    def `glyphicon-menu-hamburger` = add("glyphicon-menu-hamburger")

    def `glyphicon-menu-hamburger`(m: => CustomReactiveElement*) = build("glyphicon-menu-hamburger", m)

    def `glyphicon-modal-window` = add("glyphicon-modal-window")

    def `glyphicon-modal-window`(m: => CustomReactiveElement*) = build("glyphicon-modal-window", m)

    def `glyphicon-oil` = add("glyphicon-oil")

    def `glyphicon-oil`(m: => CustomReactiveElement*) = build("glyphicon-oil", m)

    def `glyphicon-grain` = add("glyphicon-grain")

    def `glyphicon-grain`(m: => CustomReactiveElement*) = build("glyphicon-grain", m)

    def `glyphicon-sunglasses` = add("glyphicon-sunglasses")

    def `glyphicon-sunglasses`(m: => CustomReactiveElement*) = build("glyphicon-sunglasses", m)

    def `glyphicon-text-size` = add("glyphicon-text-size")

    def `glyphicon-text-size`(m: => CustomReactiveElement*) = build("glyphicon-text-size", m)

    def `glyphicon-text-color` = add("glyphicon-text-color")

    def `glyphicon-text-color`(m: => CustomReactiveElement*) = build("glyphicon-text-color", m)

    def `glyphicon-text-background` = add("glyphicon-text-background")

    def `glyphicon-text-background`(m: => CustomReactiveElement*) = build("glyphicon-text-background", m)

    def `glyphicon-object-align-top` = add("glyphicon-object-align-top")

    def `glyphicon-object-align-top`(m: => CustomReactiveElement*) = build("glyphicon-object-align-top", m)

    def `glyphicon-object-align-bottom` = add("glyphicon-object-align-bottom")

    def `glyphicon-object-align-bottom`(m: => CustomReactiveElement*) = build("glyphicon-object-align-bottom", m)

    def `glyphicon-object-align-horizontal` = add("glyphicon-object-align-horizontal")

    def `glyphicon-object-align-horizontal`(m: => CustomReactiveElement*) = build("glyphicon-object-align-horizontal", m)

    def `glyphicon-object-align-left` = add("glyphicon-object-align-left")

    def `glyphicon-object-align-left`(m: => CustomReactiveElement*) = build("glyphicon-object-align-left", m)

    def `glyphicon-object-align-vertical` = add("glyphicon-object-align-vertical")

    def `glyphicon-object-align-vertical`(m: => CustomReactiveElement*) = build("glyphicon-object-align-vertical", m)

    def `glyphicon-object-align-right` = add("glyphicon-object-align-right")

    def `glyphicon-object-align-right`(m: => CustomReactiveElement*) = build("glyphicon-object-align-right", m)

    def `glyphicon-triangle-right` = add("glyphicon-triangle-right")

    def `glyphicon-triangle-right`(m: => CustomReactiveElement*) = build("glyphicon-triangle-right", m)

    def `glyphicon-triangle-left` = add("glyphicon-triangle-left")

    def `glyphicon-triangle-left`(m: => CustomReactiveElement*) = build("glyphicon-triangle-left", m)

    def `glyphicon-triangle-bottom` = add("glyphicon-triangle-bottom")

    def `glyphicon-triangle-bottom`(m: => CustomReactiveElement*) = build("glyphicon-triangle-bottom", m)

    def `glyphicon-triangle-top` = add("glyphicon-triangle-top")

    def `glyphicon-triangle-top`(m: => CustomReactiveElement*) = build("glyphicon-triangle-top", m)

    def `glyphicon-console` = add("glyphicon-console")

    def `glyphicon-console`(m: => CustomReactiveElement*) = build("glyphicon-console", m)

    def `glyphicon-superscript` = add("glyphicon-superscript")

    def `glyphicon-superscript`(m: => CustomReactiveElement*) = build("glyphicon-superscript", m)

    def `glyphicon-subscript` = add("glyphicon-subscript")

    def `glyphicon-subscript`(m: => CustomReactiveElement*) = build("glyphicon-subscript", m)

    def `glyphicon-menu-left` = add("glyphicon-menu-left")

    def `glyphicon-menu-left`(m: => CustomReactiveElement*) = build("glyphicon-menu-left", m)

    def `glyphicon-menu-right` = add("glyphicon-menu-right")

    def `glyphicon-menu-right`(m: => CustomReactiveElement*) = build("glyphicon-menu-right", m)

    def `glyphicon-menu-down` = add("glyphicon-menu-down")

    def `glyphicon-menu-down`(m: => CustomReactiveElement*) = build("glyphicon-menu-down", m)

    def `glyphicon-menu-up` = add("glyphicon-menu-up")

    def `glyphicon-menu-up`(m: => CustomReactiveElement*) = build("glyphicon-menu-up", m)

    def `img-responsive` = add("img-responsive")

    def `img-responsive`(m: => CustomReactiveElement*) = build("img-responsive", m)

    def `carousel-inner` = add("carousel-inner")

    def `carousel-inner`(m: => CustomReactiveElement*) = build("carousel-inner", m)

    def item = add("item")

    def item(m: => CustomReactiveElement*) = build("item", m)

    def `img-rounded` = add("img-rounded")

    def `img-rounded`(m: => CustomReactiveElement*) = build("img-rounded", m)

    def `img-circle` = add("img-circle")

    def `img-circle`(m: => CustomReactiveElement*) = build("img-circle", m)

    def `sr-only` = add("sr-only")

    def `sr-only`(m: => CustomReactiveElement*) = build("sr-only", m)

    def `sr-only-focusable` = add("sr-only-focusable")

    def `sr-only-focusable`(m: => CustomReactiveElement*) = build("sr-only-focusable", m)

    def h1 = add("h1")

    def h1(m: => CustomReactiveElement*) = build("h1", m)

    def h2 = add("h2")

    def h2(m: => CustomReactiveElement*) = build("h2", m)

    def h3 = add("h3")

    def h3(m: => CustomReactiveElement*) = build("h3", m)

    def h4 = add("h4")

    def h4(m: => CustomReactiveElement*) = build("h4", m)

    def h5 = add("h5")

    def h5(m: => CustomReactiveElement*) = build("h5", m)

    def h6 = add("h6")

    def h6(m: => CustomReactiveElement*) = build("h6", m)

    def small = add("small")

    def small(m: => CustomReactiveElement*) = build("small", m)

    def lead = add("lead")

    def lead(m: => CustomReactiveElement*) = build("lead", m)

    def mark = add("mark")

    def mark(m: => CustomReactiveElement*) = build("mark", m)

    def `text-left` = add("text-left")

    def `text-left`(m: => CustomReactiveElement*) = build("text-left", m)

    def `text-right` = add("text-right")

    def `text-right`(m: => CustomReactiveElement*) = build("text-right", m)

    def `text-center` = add("text-center")

    def `text-center`(m: => CustomReactiveElement*) = build("text-center", m)

    def `text-justify` = add("text-justify")

    def `text-justify`(m: => CustomReactiveElement*) = build("text-justify", m)

    def `text-nowrap` = add("text-nowrap")

    def `text-nowrap`(m: => CustomReactiveElement*) = build("text-nowrap", m)

    def `text-lowercase` = add("text-lowercase")

    def `text-lowercase`(m: => CustomReactiveElement*) = build("text-lowercase", m)

    def `text-uppercase` = add("text-uppercase")

    def `text-uppercase`(m: => CustomReactiveElement*) = build("text-uppercase", m)

    def `text-capitalize` = add("text-capitalize")

    def `text-capitalize`(m: => CustomReactiveElement*) = build("text-capitalize", m)

    def `text-muted` = add("text-muted")

    def `text-muted`(m: => CustomReactiveElement*) = build("text-muted", m)

    def `text-primary` = add("text-primary")

    def `text-primary`(m: => CustomReactiveElement*) = build("text-primary", m)

    def `text-success` = add("text-success")

    def `text-success`(m: => CustomReactiveElement*) = build("text-success", m)

    def `text-info` = add("text-info")

    def `text-info`(m: => CustomReactiveElement*) = build("text-info", m)

    def `text-warning` = add("text-warning")

    def `text-warning`(m: => CustomReactiveElement*) = build("text-warning", m)

    def `text-danger` = add("text-danger")

    def `text-danger`(m: => CustomReactiveElement*) = build("text-danger", m)

    def `bg-primary` = add("bg-primary")

    def `bg-primary`(m: => CustomReactiveElement*) = build("bg-primary", m)

    def `bg-success` = add("bg-success")

    def `bg-success`(m: => CustomReactiveElement*) = build("bg-success", m)

    def `bg-info` = add("bg-info")

    def `bg-info`(m: => CustomReactiveElement*) = build("bg-info", m)

    def `bg-warning` = add("bg-warning")

    def `bg-warning`(m: => CustomReactiveElement*) = build("bg-warning", m)

    def `bg-danger` = add("bg-danger")

    def `bg-danger`(m: => CustomReactiveElement*) = build("bg-danger", m)

    def `page-header` = add("page-header")

    def `page-header`(m: => CustomReactiveElement*) = build("page-header", m)

    def `list-unstyled` = add("list-unstyled")

    def `list-unstyled`(m: => CustomReactiveElement*) = build("list-unstyled", m)

    def `list-inline` = add("list-inline")

    def `list-inline`(m: => CustomReactiveElement*) = build("list-inline", m)

    def initialism = add("initialism")

    def initialism(m: => CustomReactiveElement*) = build("initialism", m)

    def `blockquote-reverse` = add("blockquote-reverse")

    def `blockquote-reverse`(m: => CustomReactiveElement*) = build("blockquote-reverse", m)

    def `pre-scrollable` = add("pre-scrollable")

    def `pre-scrollable`(m: => CustomReactiveElement*) = build("pre-scrollable", m)

    def container = add("container")

    def container(m: => CustomReactiveElement*) = build("container", m)

    def `container-fluid` = add("container-fluid")

    def `container-fluid`(m: => CustomReactiveElement*) = build("container-fluid", m)

    def row = add("row")

    def row(m: => CustomReactiveElement*) = build("row", m)

    def `row-no-gutters` = add("row-no-gutters")

    def `row-no-gutters`(m: => CustomReactiveElement*) = build("row-no-gutters", m)

    def `col-xs-1` = add("col-xs-1")

    def `col-xs-1`(m: => CustomReactiveElement*) = build("col-xs-1", m)

    def `col-sm-1` = add("col-sm-1")

    def `col-sm-1`(m: => CustomReactiveElement*) = build("col-sm-1", m)

    def `col-md-1` = add("col-md-1")

    def `col-md-1`(m: => CustomReactiveElement*) = build("col-md-1", m)

    def `col-lg-1` = add("col-lg-1")

    def `col-lg-1`(m: => CustomReactiveElement*) = build("col-lg-1", m)

    def `col-xs-2` = add("col-xs-2")

    def `col-xs-2`(m: => CustomReactiveElement*) = build("col-xs-2", m)

    def `col-sm-2` = add("col-sm-2")

    def `col-sm-2`(m: => CustomReactiveElement*) = build("col-sm-2", m)

    def `col-md-2` = add("col-md-2")

    def `col-md-2`(m: => CustomReactiveElement*) = build("col-md-2", m)

    def `col-lg-2` = add("col-lg-2")

    def `col-lg-2`(m: => CustomReactiveElement*) = build("col-lg-2", m)

    def `col-xs-3` = add("col-xs-3")

    def `col-xs-3`(m: => CustomReactiveElement*) = build("col-xs-3", m)

    def `col-sm-3` = add("col-sm-3")

    def `col-sm-3`(m: => CustomReactiveElement*) = build("col-sm-3", m)

    def `col-md-3` = add("col-md-3")

    def `col-md-3`(m: => CustomReactiveElement*) = build("col-md-3", m)

    def `col-lg-3` = add("col-lg-3")

    def `col-lg-3`(m: => CustomReactiveElement*) = build("col-lg-3", m)

    def `col-xs-4` = add("col-xs-4")

    def `col-xs-4`(m: => CustomReactiveElement*) = build("col-xs-4", m)

    def `col-sm-4` = add("col-sm-4")

    def `col-sm-4`(m: => CustomReactiveElement*) = build("col-sm-4", m)

    def `col-md-4` = add("col-md-4")

    def `col-md-4`(m: => CustomReactiveElement*) = build("col-md-4", m)

    def `col-lg-4` = add("col-lg-4")

    def `col-lg-4`(m: => CustomReactiveElement*) = build("col-lg-4", m)

    def `col-xs-5` = add("col-xs-5")

    def `col-xs-5`(m: => CustomReactiveElement*) = build("col-xs-5", m)

    def `col-sm-5` = add("col-sm-5")

    def `col-sm-5`(m: => CustomReactiveElement*) = build("col-sm-5", m)

    def `col-md-5` = add("col-md-5")

    def `col-md-5`(m: => CustomReactiveElement*) = build("col-md-5", m)

    def `col-lg-5` = add("col-lg-5")

    def `col-lg-5`(m: => CustomReactiveElement*) = build("col-lg-5", m)

    def `col-xs-6` = add("col-xs-6")

    def `col-xs-6`(m: => CustomReactiveElement*) = build("col-xs-6", m)

    def `col-sm-6` = add("col-sm-6")

    def `col-sm-6`(m: => CustomReactiveElement*) = build("col-sm-6", m)

    def `col-md-6` = add("col-md-6")

    def `col-md-6`(m: => CustomReactiveElement*) = build("col-md-6", m)

    def `col-lg-6` = add("col-lg-6")

    def `col-lg-6`(m: => CustomReactiveElement*) = build("col-lg-6", m)

    def `col-xs-7` = add("col-xs-7")

    def `col-xs-7`(m: => CustomReactiveElement*) = build("col-xs-7", m)

    def `col-sm-7` = add("col-sm-7")

    def `col-sm-7`(m: => CustomReactiveElement*) = build("col-sm-7", m)

    def `col-md-7` = add("col-md-7")

    def `col-md-7`(m: => CustomReactiveElement*) = build("col-md-7", m)

    def `col-lg-7` = add("col-lg-7")

    def `col-lg-7`(m: => CustomReactiveElement*) = build("col-lg-7", m)

    def `col-xs-8` = add("col-xs-8")

    def `col-xs-8`(m: => CustomReactiveElement*) = build("col-xs-8", m)

    def `col-sm-8` = add("col-sm-8")

    def `col-sm-8`(m: => CustomReactiveElement*) = build("col-sm-8", m)

    def `col-md-8` = add("col-md-8")

    def `col-md-8`(m: => CustomReactiveElement*) = build("col-md-8", m)

    def `col-lg-8` = add("col-lg-8")

    def `col-lg-8`(m: => CustomReactiveElement*) = build("col-lg-8", m)

    def `col-xs-9` = add("col-xs-9")

    def `col-xs-9`(m: => CustomReactiveElement*) = build("col-xs-9", m)

    def `col-sm-9` = add("col-sm-9")

    def `col-sm-9`(m: => CustomReactiveElement*) = build("col-sm-9", m)

    def `col-md-9` = add("col-md-9")

    def `col-md-9`(m: => CustomReactiveElement*) = build("col-md-9", m)

    def `col-lg-9` = add("col-lg-9")

    def `col-lg-9`(m: => CustomReactiveElement*) = build("col-lg-9", m)

    def `col-xs-10` = add("col-xs-10")

    def `col-xs-10`(m: => CustomReactiveElement*) = build("col-xs-10", m)

    def `col-sm-10` = add("col-sm-10")

    def `col-sm-10`(m: => CustomReactiveElement*) = build("col-sm-10", m)

    def `col-md-10` = add("col-md-10")

    def `col-md-10`(m: => CustomReactiveElement*) = build("col-md-10", m)

    def `col-lg-10` = add("col-lg-10")

    def `col-lg-10`(m: => CustomReactiveElement*) = build("col-lg-10", m)

    def `col-xs-11` = add("col-xs-11")

    def `col-xs-11`(m: => CustomReactiveElement*) = build("col-xs-11", m)

    def `col-sm-11` = add("col-sm-11")

    def `col-sm-11`(m: => CustomReactiveElement*) = build("col-sm-11", m)

    def `col-md-11` = add("col-md-11")

    def `col-md-11`(m: => CustomReactiveElement*) = build("col-md-11", m)

    def `col-lg-11` = add("col-lg-11")

    def `col-lg-11`(m: => CustomReactiveElement*) = build("col-lg-11", m)

    def `col-xs-12` = add("col-xs-12")

    def `col-xs-12`(m: => CustomReactiveElement*) = build("col-xs-12", m)

    def `col-sm-12` = add("col-sm-12")

    def `col-sm-12`(m: => CustomReactiveElement*) = build("col-sm-12", m)

    def `col-md-12` = add("col-md-12")

    def `col-md-12`(m: => CustomReactiveElement*) = build("col-md-12", m)

    def `col-lg-12` = add("col-lg-12")

    def `col-lg-12`(m: => CustomReactiveElement*) = build("col-lg-12", m)

    def `col-xs-pull-12` = add("col-xs-pull-12")

    def `col-xs-pull-12`(m: => CustomReactiveElement*) = build("col-xs-pull-12", m)

    def `col-xs-pull-11` = add("col-xs-pull-11")

    def `col-xs-pull-11`(m: => CustomReactiveElement*) = build("col-xs-pull-11", m)

    def `col-xs-pull-10` = add("col-xs-pull-10")

    def `col-xs-pull-10`(m: => CustomReactiveElement*) = build("col-xs-pull-10", m)

    def `col-xs-pull-9` = add("col-xs-pull-9")

    def `col-xs-pull-9`(m: => CustomReactiveElement*) = build("col-xs-pull-9", m)

    def `col-xs-pull-8` = add("col-xs-pull-8")

    def `col-xs-pull-8`(m: => CustomReactiveElement*) = build("col-xs-pull-8", m)

    def `col-xs-pull-7` = add("col-xs-pull-7")

    def `col-xs-pull-7`(m: => CustomReactiveElement*) = build("col-xs-pull-7", m)

    def `col-xs-pull-6` = add("col-xs-pull-6")

    def `col-xs-pull-6`(m: => CustomReactiveElement*) = build("col-xs-pull-6", m)

    def `col-xs-pull-5` = add("col-xs-pull-5")

    def `col-xs-pull-5`(m: => CustomReactiveElement*) = build("col-xs-pull-5", m)

    def `col-xs-pull-4` = add("col-xs-pull-4")

    def `col-xs-pull-4`(m: => CustomReactiveElement*) = build("col-xs-pull-4", m)

    def `col-xs-pull-3` = add("col-xs-pull-3")

    def `col-xs-pull-3`(m: => CustomReactiveElement*) = build("col-xs-pull-3", m)

    def `col-xs-pull-2` = add("col-xs-pull-2")

    def `col-xs-pull-2`(m: => CustomReactiveElement*) = build("col-xs-pull-2", m)

    def `col-xs-pull-1` = add("col-xs-pull-1")

    def `col-xs-pull-1`(m: => CustomReactiveElement*) = build("col-xs-pull-1", m)

    def `col-xs-pull-0` = add("col-xs-pull-0")

    def `col-xs-pull-0`(m: => CustomReactiveElement*) = build("col-xs-pull-0", m)

    def `col-xs-push-12` = add("col-xs-push-12")

    def `col-xs-push-12`(m: => CustomReactiveElement*) = build("col-xs-push-12", m)

    def `col-xs-push-11` = add("col-xs-push-11")

    def `col-xs-push-11`(m: => CustomReactiveElement*) = build("col-xs-push-11", m)

    def `col-xs-push-10` = add("col-xs-push-10")

    def `col-xs-push-10`(m: => CustomReactiveElement*) = build("col-xs-push-10", m)

    def `col-xs-push-9` = add("col-xs-push-9")

    def `col-xs-push-9`(m: => CustomReactiveElement*) = build("col-xs-push-9", m)

    def `col-xs-push-8` = add("col-xs-push-8")

    def `col-xs-push-8`(m: => CustomReactiveElement*) = build("col-xs-push-8", m)

    def `col-xs-push-7` = add("col-xs-push-7")

    def `col-xs-push-7`(m: => CustomReactiveElement*) = build("col-xs-push-7", m)

    def `col-xs-push-6` = add("col-xs-push-6")

    def `col-xs-push-6`(m: => CustomReactiveElement*) = build("col-xs-push-6", m)

    def `col-xs-push-5` = add("col-xs-push-5")

    def `col-xs-push-5`(m: => CustomReactiveElement*) = build("col-xs-push-5", m)

    def `col-xs-push-4` = add("col-xs-push-4")

    def `col-xs-push-4`(m: => CustomReactiveElement*) = build("col-xs-push-4", m)

    def `col-xs-push-3` = add("col-xs-push-3")

    def `col-xs-push-3`(m: => CustomReactiveElement*) = build("col-xs-push-3", m)

    def `col-xs-push-2` = add("col-xs-push-2")

    def `col-xs-push-2`(m: => CustomReactiveElement*) = build("col-xs-push-2", m)

    def `col-xs-push-1` = add("col-xs-push-1")

    def `col-xs-push-1`(m: => CustomReactiveElement*) = build("col-xs-push-1", m)

    def `col-xs-push-0` = add("col-xs-push-0")

    def `col-xs-push-0`(m: => CustomReactiveElement*) = build("col-xs-push-0", m)

    def `col-xs-offset-12` = add("col-xs-offset-12")

    def `col-xs-offset-12`(m: => CustomReactiveElement*) = build("col-xs-offset-12", m)

    def `col-xs-offset-11` = add("col-xs-offset-11")

    def `col-xs-offset-11`(m: => CustomReactiveElement*) = build("col-xs-offset-11", m)

    def `col-xs-offset-10` = add("col-xs-offset-10")

    def `col-xs-offset-10`(m: => CustomReactiveElement*) = build("col-xs-offset-10", m)

    def `col-xs-offset-9` = add("col-xs-offset-9")

    def `col-xs-offset-9`(m: => CustomReactiveElement*) = build("col-xs-offset-9", m)

    def `col-xs-offset-8` = add("col-xs-offset-8")

    def `col-xs-offset-8`(m: => CustomReactiveElement*) = build("col-xs-offset-8", m)

    def `col-xs-offset-7` = add("col-xs-offset-7")

    def `col-xs-offset-7`(m: => CustomReactiveElement*) = build("col-xs-offset-7", m)

    def `col-xs-offset-6` = add("col-xs-offset-6")

    def `col-xs-offset-6`(m: => CustomReactiveElement*) = build("col-xs-offset-6", m)

    def `col-xs-offset-5` = add("col-xs-offset-5")

    def `col-xs-offset-5`(m: => CustomReactiveElement*) = build("col-xs-offset-5", m)

    def `col-xs-offset-4` = add("col-xs-offset-4")

    def `col-xs-offset-4`(m: => CustomReactiveElement*) = build("col-xs-offset-4", m)

    def `col-xs-offset-3` = add("col-xs-offset-3")

    def `col-xs-offset-3`(m: => CustomReactiveElement*) = build("col-xs-offset-3", m)

    def `col-xs-offset-2` = add("col-xs-offset-2")

    def `col-xs-offset-2`(m: => CustomReactiveElement*) = build("col-xs-offset-2", m)

    def `col-xs-offset-1` = add("col-xs-offset-1")

    def `col-xs-offset-1`(m: => CustomReactiveElement*) = build("col-xs-offset-1", m)

    def `col-xs-offset-0` = add("col-xs-offset-0")

    def `col-xs-offset-0`(m: => CustomReactiveElement*) = build("col-xs-offset-0", m)

    def table = add("table")

    def table(m: => CustomReactiveElement*) = build("table", m)

    def `table-condensed` = add("table-condensed")

    def `table-condensed`(m: => CustomReactiveElement*) = build("table-condensed", m)

    def `table-bordered` = add("table-bordered")

    def `table-bordered`(m: => CustomReactiveElement*) = build("table-bordered", m)

    def `table-striped` = add("table-striped")

    def `table-striped`(m: => CustomReactiveElement*) = build("table-striped", m)

    def `table-hover` = add("table-hover")

    def `table-hover`(m: => CustomReactiveElement*) = build("table-hover", m)

    def success = add("success")

    def success(m: => CustomReactiveElement*) = build("success", m)

    def info = add("info")

    def info(m: => CustomReactiveElement*) = build("info", m)

    def warning = add("warning")

    def warning(m: => CustomReactiveElement*) = build("warning", m)

    def danger = add("danger")

    def danger(m: => CustomReactiveElement*) = build("danger", m)

    def `table-responsive` = add("table-responsive")

    def `table-responsive`(m: => CustomReactiveElement*) = build("table-responsive", m)

    def `form-control` = add("form-control")

    def `form-control`(m: => CustomReactiveElement*) = build("form-control", m)

    def `form-group` = add("form-group")

    def `form-group`(m: => CustomReactiveElement*) = build("form-group", m)

    def radio = add("radio")

    def radio(m: => CustomReactiveElement*) = build("radio", m)

    def checkbox = add("checkbox")

    def checkbox(m: => CustomReactiveElement*) = build("checkbox", m)

    def `radio-inline` = add("radio-inline")

    def `radio-inline`(m: => CustomReactiveElement*) = build("radio-inline", m)

    def `checkbox-inline` = add("checkbox-inline")

    def `checkbox-inline`(m: => CustomReactiveElement*) = build("checkbox-inline", m)

    def `form-control-static` = add("form-control-static")

    def `form-control-static`(m: => CustomReactiveElement*) = build("form-control-static", m)

    def `input-lg` = add("input-lg")

    def `input-lg`(m: => CustomReactiveElement*) = build("input-lg", m)

    def `input-sm` = add("input-sm")

    def `input-sm`(m: => CustomReactiveElement*) = build("input-sm", m)

    def `form-group-sm` = add("form-group-sm")

    def `form-group-sm`(m: => CustomReactiveElement*) = build("form-group-sm", m)

    def `form-group-lg` = add("form-group-lg")

    def `form-group-lg`(m: => CustomReactiveElement*) = build("form-group-lg", m)

    def `has-feedback` = add("has-feedback")

    def `has-feedback`(m: => CustomReactiveElement*) = build("has-feedback", m)

    def `form-control-feedback` = add("form-control-feedback")

    def `form-control-feedback`(m: => CustomReactiveElement*) = build("form-control-feedback", m)

    def `input-group-lg` = add("input-group-lg")

    def `input-group-lg`(m: => CustomReactiveElement*) = build("input-group-lg", m)

    def `input-group-sm` = add("input-group-sm")

    def `input-group-sm`(m: => CustomReactiveElement*) = build("input-group-sm", m)

    def `has-success` = add("has-success")

    def `has-success`(m: => CustomReactiveElement*) = build("has-success", m)

    def `help-block` = add("help-block")

    def `help-block`(m: => CustomReactiveElement*) = build("help-block", m)

    def `control-label` = add("control-label")

    def `control-label`(m: => CustomReactiveElement*) = build("control-label", m)

    def `input-group-addon` = add("input-group-addon")

    def `input-group-addon`(m: => CustomReactiveElement*) = build("input-group-addon", m)

    def `has-warning` = add("has-warning")

    def `has-warning`(m: => CustomReactiveElement*) = build("has-warning", m)

    def `has-error` = add("has-error")

    def `has-error`(m: => CustomReactiveElement*) = build("has-error", m)

    def `form-horizontal` = add("form-horizontal")

    def `form-horizontal`(m: => CustomReactiveElement*) = build("form-horizontal", m)

    def `dropdown-toggle` = add("dropdown-toggle")

    def `dropdown-toggle`(m: => CustomReactiveElement*) = build("dropdown-toggle", m)

    def `btn-link` = add("btn-link")

    def `btn-link`(m: => CustomReactiveElement*) = build("btn-link", m)

    def `btn-lg` = add("btn-lg")

    def `btn-lg`(m: => CustomReactiveElement*) = build("btn-lg", m)

    def `btn-group-lg` = add("btn-group-lg")

    def `btn-group-lg`(m: => CustomReactiveElement*) = build("btn-group-lg", m)

    def `btn-sm` = add("btn-sm")

    def `btn-sm`(m: => CustomReactiveElement*) = build("btn-sm", m)

    def `btn-group-sm` = add("btn-group-sm")

    def `btn-group-sm`(m: => CustomReactiveElement*) = build("btn-group-sm", m)

    def `btn-xs` = add("btn-xs")

    def `btn-xs`(m: => CustomReactiveElement*) = build("btn-xs", m)

    def `btn-group-xs` = add("btn-group-xs")

    def `btn-group-xs`(m: => CustomReactiveElement*) = build("btn-group-xs", m)

    def `btn-block` = add("btn-block")

    def `btn-block`(m: => CustomReactiveElement*) = build("btn-block", m)

    def fade = add("fade")

    def fade(m: => CustomReactiveElement*) = build("fade", m)

    def in = add("in")

    def in(m: => CustomReactiveElement*) = build("in", m)

    def collapse = add("collapse")

    def collapse(m: => CustomReactiveElement*) = build("collapse", m)

    def collapsing = add("collapsing")

    def collapsing(m: => CustomReactiveElement*) = build("collapsing", m)

    def caret = add("caret")

    def caret(m: => CustomReactiveElement*) = build("caret", m)

    def dropup = add("dropup")

    def dropup(m: => CustomReactiveElement*) = build("dropup", m)

    def dropdown = add("dropdown")

    def dropdown(m: => CustomReactiveElement*) = build("dropdown", m)

    def `pull-right` = add("pull-right")

    def `pull-right`(m: => CustomReactiveElement*) = build("pull-right", m)

    def divider = add("divider")

    def divider(m: => CustomReactiveElement*) = build("divider", m)

    def `dropdown-menu-right` = add("dropdown-menu-right")

    def `dropdown-menu-right`(m: => CustomReactiveElement*) = build("dropdown-menu-right", m)

    def `dropdown-menu-left` = add("dropdown-menu-left")

    def `dropdown-menu-left`(m: => CustomReactiveElement*) = build("dropdown-menu-left", m)

    def `dropdown-header` = add("dropdown-header")

    def `dropdown-header`(m: => CustomReactiveElement*) = build("dropdown-header", m)

    def `dropdown-backdrop` = add("dropdown-backdrop")

    def `dropdown-backdrop`(m: => CustomReactiveElement*) = build("dropdown-backdrop", m)

    def `btn-group` = add("btn-group")

    def `btn-group`(m: => CustomReactiveElement*) = build("btn-group", m)

    def `btn-group-vertical` = add("btn-group-vertical")

    def `btn-group-vertical`(m: => CustomReactiveElement*) = build("btn-group-vertical", m)

    def `btn-toolbar` = add("btn-toolbar")

    def `btn-toolbar`(m: => CustomReactiveElement*) = build("btn-toolbar", m)

    def `input-group` = add("input-group")

    def `input-group`(m: => CustomReactiveElement*) = build("input-group", m)

    def `btn-group-justified` = add("btn-group-justified")

    def `btn-group-justified`(m: => CustomReactiveElement*) = build("btn-group-justified", m)

    def `input-group-btn` = add("input-group-btn")

    def `input-group-btn`(m: => CustomReactiveElement*) = build("input-group-btn", m)

    def nav = add("nav")

    def nav(m: => CustomReactiveElement*) = build("nav", m)

    def `nav-divider` = add("nav-divider")

    def `nav-divider`(m: => CustomReactiveElement*) = build("nav-divider", m)

    def `nav-tabs` = add("nav-tabs")

    def `nav-tabs`(m: => CustomReactiveElement*) = build("nav-tabs", m)

    def `nav-justified` = add("nav-justified")

    def `nav-justified`(m: => CustomReactiveElement*) = build("nav-justified", m)

    def `nav-pills` = add("nav-pills")

    def `nav-pills`(m: => CustomReactiveElement*) = build("nav-pills", m)

    def `nav-stacked` = add("nav-stacked")

    def `nav-stacked`(m: => CustomReactiveElement*) = build("nav-stacked", m)

    def `nav-tabs-justified` = add("nav-tabs-justified")

    def `nav-tabs-justified`(m: => CustomReactiveElement*) = build("nav-tabs-justified", m)

    def `tab-content` = add("tab-content")

    def `tab-content`(m: => CustomReactiveElement*) = build("tab-content", m)

    def `tab-pane` = add("tab-pane")

    def `tab-pane`(m: => CustomReactiveElement*) = build("tab-pane", m)

    def navbar = add("navbar")

    def navbar(m: => CustomReactiveElement*) = build("navbar", m)

    def `navbar-collapse` = add("navbar-collapse")

    def `navbar-collapse`(m: => CustomReactiveElement*) = build("navbar-collapse", m)

    def `navbar-header` = add("navbar-header")

    def `navbar-header`(m: => CustomReactiveElement*) = build("navbar-header", m)

    def `navbar-toggle` = add("navbar-toggle")

    def `navbar-toggle`(m: => CustomReactiveElement*) = build("navbar-toggle", m)

    def `icon-bar` = add("icon-bar")

    def `icon-bar`(m: => CustomReactiveElement*) = build("icon-bar", m)

    def `navbar-form` = add("navbar-form")

    def `navbar-form`(m: => CustomReactiveElement*) = build("navbar-form", m)

    def `navbar-btn` = add("navbar-btn")

    def `navbar-btn`(m: => CustomReactiveElement*) = build("navbar-btn", m)

    def `navbar-text` = add("navbar-text")

    def `navbar-text`(m: => CustomReactiveElement*) = build("navbar-text", m)

    def `navbar-link` = add("navbar-link")

    def `navbar-link`(m: => CustomReactiveElement*) = build("navbar-link", m)

    def breadcrumb = add("breadcrumb")

    def breadcrumb(m: => CustomReactiveElement*) = build("breadcrumb", m)

    def pagination = add("pagination")

    def pagination(m: => CustomReactiveElement*) = build("pagination", m)

    def `pagination-lg` = add("pagination-lg")

    def `pagination-lg`(m: => CustomReactiveElement*) = build("pagination-lg", m)

    def `pagination-sm` = add("pagination-sm")

    def `pagination-sm`(m: => CustomReactiveElement*) = build("pagination-sm", m)

    def pager = add("pager")

    def pager(m: => CustomReactiveElement*) = build("pager", m)

    def next = add("next")

    def next(m: => CustomReactiveElement*) = build("next", m)

    def previous = add("previous")

    def previous(m: => CustomReactiveElement*) = build("previous", m)

    def label = add("label")

    def label(m: => CustomReactiveElement*) = build("label", m)

    def `label-default` = add("label-default")

    def `label-default`(m: => CustomReactiveElement*) = build("label-default", m)

    def `label-primary` = add("label-primary")

    def `label-primary`(m: => CustomReactiveElement*) = build("label-primary", m)

    def `label-success` = add("label-success")

    def `label-success`(m: => CustomReactiveElement*) = build("label-success", m)

    def `label-info` = add("label-info")

    def `label-info`(m: => CustomReactiveElement*) = build("label-info", m)

    def `label-warning` = add("label-warning")

    def `label-warning`(m: => CustomReactiveElement*) = build("label-warning", m)

    def `label-danger` = add("label-danger")

    def `label-danger`(m: => CustomReactiveElement*) = build("label-danger", m)

    def jumbotron = add("jumbotron")

    def jumbotron(m: => CustomReactiveElement*) = build("jumbotron", m)

    def caption = add("caption")

    def caption(m: => CustomReactiveElement*) = build("caption", m)

    def `alert-link` = add("alert-link")

    def `alert-link`(m: => CustomReactiveElement*) = build("alert-link", m)

    def `alert-dismissable` = add("alert-dismissable")

    def `alert-dismissable`(m: => CustomReactiveElement*) = build("alert-dismissable", m)

    def `alert-dismissible` = add("alert-dismissible")

    def `alert-dismissible`(m: => CustomReactiveElement*) = build("alert-dismissible", m)

    def close = add("close")

    def close(m: => CustomReactiveElement*) = build("close", m)

    def `progress-striped` = add("progress-striped")

    def `progress-striped`(m: => CustomReactiveElement*) = build("progress-striped", m)

    def media = add("media")

    def media(m: => CustomReactiveElement*) = build("media", m)

    def `media-body` = add("media-body")

    def `media-body`(m: => CustomReactiveElement*) = build("media-body", m)

    def `media-object` = add("media-object")

    def `media-object`(m: => CustomReactiveElement*) = build("media-object", m)

    def `media-right` = add("media-right")

    def `media-right`(m: => CustomReactiveElement*) = build("media-right", m)

    def `media-left` = add("media-left")

    def `media-left`(m: => CustomReactiveElement*) = build("media-left", m)

    def `pull-left` = add("pull-left")

    def `pull-left`(m: => CustomReactiveElement*) = build("pull-left", m)

    def `media-middle` = add("media-middle")

    def `media-middle`(m: => CustomReactiveElement*) = build("media-middle", m)

    def `media-bottom` = add("media-bottom")

    def `media-bottom`(m: => CustomReactiveElement*) = build("media-bottom", m)

    def `media-heading` = add("media-heading")

    def `media-heading`(m: => CustomReactiveElement*) = build("media-heading", m)

    def `media-list` = add("media-list")

    def `media-list`(m: => CustomReactiveElement*) = build("media-list", m)

    def `list-group-item-heading` = add("list-group-item-heading")

    def `list-group-item-heading`(m: => CustomReactiveElement*) = build("list-group-item-heading", m)

    def `list-group-item-text` = add("list-group-item-text")

    def `list-group-item-text`(m: => CustomReactiveElement*) = build("list-group-item-text", m)

    def `list-group-item-success` = add("list-group-item-success")

    def `list-group-item-success`(m: => CustomReactiveElement*) = build("list-group-item-success", m)

    def `list-group-item-info` = add("list-group-item-info")

    def `list-group-item-info`(m: => CustomReactiveElement*) = build("list-group-item-info", m)

    def `list-group-item-warning` = add("list-group-item-warning")

    def `list-group-item-warning`(m: => CustomReactiveElement*) = build("list-group-item-warning", m)

    def `list-group-item-danger` = add("list-group-item-danger")

    def `list-group-item-danger`(m: => CustomReactiveElement*) = build("list-group-item-danger", m)

    def `panel-body` = add("panel-body")

    def `panel-body`(m: => CustomReactiveElement*) = build("panel-body", m)

    def `panel-title` = add("panel-title")

    def `panel-title`(m: => CustomReactiveElement*) = build("panel-title", m)

    def `panel-footer` = add("panel-footer")

    def `panel-footer`(m: => CustomReactiveElement*) = build("panel-footer", m)

    def `panel-collapse` = add("panel-collapse")

    def `panel-collapse`(m: => CustomReactiveElement*) = build("panel-collapse", m)

    def `panel-group` = add("panel-group")

    def `panel-group`(m: => CustomReactiveElement*) = build("panel-group", m)

    def `embed-responsive` = add("embed-responsive")

    def `embed-responsive`(m: => CustomReactiveElement*) = build("embed-responsive", m)

    def `embed-responsive-item` = add("embed-responsive-item")

    def `embed-responsive-item`(m: => CustomReactiveElement*) = build("embed-responsive-item", m)

    def `embed-responsive-16by9` = add("embed-responsive-16by9")

    def `embed-responsive-16by9`(m: => CustomReactiveElement*) = build("embed-responsive-16by9", m)

    def `embed-responsive-4by3` = add("embed-responsive-4by3")

    def `embed-responsive-4by3`(m: => CustomReactiveElement*) = build("embed-responsive-4by3", m)

    def `well-lg` = add("well-lg")

    def `well-lg`(m: => CustomReactiveElement*) = build("well-lg", m)

    def `well-sm` = add("well-sm")

    def `well-sm`(m: => CustomReactiveElement*) = build("well-sm", m)

    def `modal-open` = add("modal-open")

    def `modal-open`(m: => CustomReactiveElement*) = build("modal-open", m)

    def modal = add("modal")

    def modal(m: => CustomReactiveElement*) = build("modal", m)

    def `modal-dialog` = add("modal-dialog")

    def `modal-dialog`(m: => CustomReactiveElement*) = build("modal-dialog", m)

    def `modal-content` = add("modal-content")

    def `modal-content`(m: => CustomReactiveElement*) = build("modal-content", m)

    def `modal-backdrop` = add("modal-backdrop")

    def `modal-backdrop`(m: => CustomReactiveElement*) = build("modal-backdrop", m)

    def `modal-header` = add("modal-header")

    def `modal-header`(m: => CustomReactiveElement*) = build("modal-header", m)

    def `modal-title` = add("modal-title")

    def `modal-title`(m: => CustomReactiveElement*) = build("modal-title", m)

    def `modal-body` = add("modal-body")

    def `modal-body`(m: => CustomReactiveElement*) = build("modal-body", m)

    def `modal-footer` = add("modal-footer")

    def `modal-footer`(m: => CustomReactiveElement*) = build("modal-footer", m)

    def `modal-scrollbar-measure` = add("modal-scrollbar-measure")

    def `modal-scrollbar-measure`(m: => CustomReactiveElement*) = build("modal-scrollbar-measure", m)

    def tooltip = add("tooltip")

    def tooltip(m: => CustomReactiveElement*) = build("tooltip", m)

    def top = add("top")

    def top(m: => CustomReactiveElement*) = build("top", m)

    def right = add("right")

    def right(m: => CustomReactiveElement*) = build("right", m)

    def bottom = add("bottom")

    def bottom(m: => CustomReactiveElement*) = build("bottom", m)

    def left = add("left")

    def left(m: => CustomReactiveElement*) = build("left", m)

    def `tooltip-arrow` = add("tooltip-arrow")

    def `tooltip-arrow`(m: => CustomReactiveElement*) = build("tooltip-arrow", m)

    def `top-left` = add("top-left")

    def `top-left`(m: => CustomReactiveElement*) = build("top-left", m)

    def `top-right` = add("top-right")

    def `top-right`(m: => CustomReactiveElement*) = build("top-right", m)

    def `bottom-left` = add("bottom-left")

    def `bottom-left`(m: => CustomReactiveElement*) = build("bottom-left", m)

    def `bottom-right` = add("bottom-right")

    def `bottom-right`(m: => CustomReactiveElement*) = build("bottom-right", m)

    def `tooltip-inner` = add("tooltip-inner")

    def `tooltip-inner`(m: => CustomReactiveElement*) = build("tooltip-inner", m)

    def popover = add("popover")

    def popover(m: => CustomReactiveElement*) = build("popover", m)

    def arrow = add("arrow")

    def arrow(m: => CustomReactiveElement*) = build("arrow", m)

    def `popover-title` = add("popover-title")

    def `popover-title`(m: => CustomReactiveElement*) = build("popover-title", m)

    def `popover-content` = add("popover-content")

    def `popover-content`(m: => CustomReactiveElement*) = build("popover-content", m)

    def carousel = add("carousel")

    def carousel(m: => CustomReactiveElement*) = build("carousel", m)

    def prev = add("prev")

    def prev(m: => CustomReactiveElement*) = build("prev", m)

    def `carousel-control` = add("carousel-control")

    def `carousel-control`(m: => CustomReactiveElement*) = build("carousel-control", m)

    def `icon-prev` = add("icon-prev")

    def `icon-prev`(m: => CustomReactiveElement*) = build("icon-prev", m)

    def `icon-next` = add("icon-next")

    def `icon-next`(m: => CustomReactiveElement*) = build("icon-next", m)

    def `carousel-indicators` = add("carousel-indicators")

    def `carousel-indicators`(m: => CustomReactiveElement*) = build("carousel-indicators", m)

    def `carousel-caption` = add("carousel-caption")

    def `carousel-caption`(m: => CustomReactiveElement*) = build("carousel-caption", m)

    def clearfix = add("clearfix")

    def clearfix(m: => CustomReactiveElement*) = build("clearfix", m)

    def `dl-horizontal` = add("dl-horizontal")

    def `dl-horizontal`(m: => CustomReactiveElement*) = build("dl-horizontal", m)

    def `center-block` = add("center-block")

    def `center-block`(m: => CustomReactiveElement*) = build("center-block", m)

    def hide = add("hide")

    def hide(m: => CustomReactiveElement*) = build("hide", m)

    def show = add("show")

    def show(m: => CustomReactiveElement*) = build("show", m)

    def invisible = add("invisible")

    def invisible(m: => CustomReactiveElement*) = build("invisible", m)

    def `text-hide` = add("text-hide")

    def `text-hide`(m: => CustomReactiveElement*) = build("text-hide", m)

    def hidden = add("hidden")

    def hidden(m: => CustomReactiveElement*) = build("hidden", m)

    def affix = add("affix")

    def affix(m: => CustomReactiveElement*) = build("affix", m)

    def `visible-xs` = add("visible-xs")

    def `visible-xs`(m: => CustomReactiveElement*) = build("visible-xs", m)

    def `visible-sm` = add("visible-sm")

    def `visible-sm`(m: => CustomReactiveElement*) = build("visible-sm", m)

    def `visible-md` = add("visible-md")

    def `visible-md`(m: => CustomReactiveElement*) = build("visible-md", m)

    def `visible-lg` = add("visible-lg")

    def `visible-lg`(m: => CustomReactiveElement*) = build("visible-lg", m)

    def `visible-xs-block` = add("visible-xs-block")

    def `visible-xs-block`(m: => CustomReactiveElement*) = build("visible-xs-block", m)

    def `visible-xs-inline` = add("visible-xs-inline")

    def `visible-xs-inline`(m: => CustomReactiveElement*) = build("visible-xs-inline", m)

    def `visible-xs-inline-block` = add("visible-xs-inline-block")

    def `visible-xs-inline-block`(m: => CustomReactiveElement*) = build("visible-xs-inline-block", m)

    def `visible-sm-block` = add("visible-sm-block")

    def `visible-sm-block`(m: => CustomReactiveElement*) = build("visible-sm-block", m)

    def `visible-sm-inline` = add("visible-sm-inline")

    def `visible-sm-inline`(m: => CustomReactiveElement*) = build("visible-sm-inline", m)

    def `visible-sm-inline-block` = add("visible-sm-inline-block")

    def `visible-sm-inline-block`(m: => CustomReactiveElement*) = build("visible-sm-inline-block", m)

    def `visible-md-block` = add("visible-md-block")

    def `visible-md-block`(m: => CustomReactiveElement*) = build("visible-md-block", m)

    def `visible-md-inline` = add("visible-md-inline")

    def `visible-md-inline`(m: => CustomReactiveElement*) = build("visible-md-inline", m)

    def `visible-md-inline-block` = add("visible-md-inline-block")

    def `visible-md-inline-block`(m: => CustomReactiveElement*) = build("visible-md-inline-block", m)

    def `visible-lg-block` = add("visible-lg-block")

    def `visible-lg-block`(m: => CustomReactiveElement*) = build("visible-lg-block", m)

    def `visible-lg-inline` = add("visible-lg-inline")

    def `visible-lg-inline`(m: => CustomReactiveElement*) = build("visible-lg-inline", m)

    def `visible-lg-inline-block` = add("visible-lg-inline-block")

    def `visible-lg-inline-block`(m: => CustomReactiveElement*) = build("visible-lg-inline-block", m)

    def `visible-print` = add("visible-print")

    def `visible-print`(m: => CustomReactiveElement*) = build("visible-print", m)

    def `visible-print-block` = add("visible-print-block")

    def `visible-print-block`(m: => CustomReactiveElement*) = build("visible-print-block", m)

    def `visible-print-inline` = add("visible-print-inline")

    def `visible-print-inline`(m: => CustomReactiveElement*) = build("visible-print-inline", m)

    def `visible-print-inline-block` = add("visible-print-inline-block")

    def `visible-print-inline-block`(m: => CustomReactiveElement*) = build("visible-print-inline-block", m)
