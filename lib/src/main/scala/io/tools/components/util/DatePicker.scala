package io.tools.components.util

import org.querki.facades.bootstrap.datepicker.*
import org.querki.jquery.{JQuery, JQueryEventObject}

import java.time.{LocalDate, LocalDateTime, LocalTime, ZoneId, ZonedDateTime}
import scala.scalajs.js

object DatePicker:

  extension (d: js.Date)
    def toLocalDate =
      LocalDate.of(d.getFullYear().toInt, d.getMonth().toInt + 1, d.getDate().toInt)

  extension (ldt: LocalDate) def atTimeNow = ldt.atTime(LocalTime.now())

  extension (jq: JQuery)
    def dtpicker(format: String = "dd/mm/yyyy", startDate: Option[LocalDate] = None)(
      changeDate: LocalDate => Unit
    ): JQuery =

      val builder = BootstrapDatepickerOptions
        .autoclose(true)
        .todayHighlight(true)
        .todayBtnLinked()
        .disableTouchKeyboard(true)
        .orientation(Orientation.Auto)
        .format(format)
        // .startDate(js.Date())
        .clearBtn(true)

      val opts =
        startDate match
          case Some(date) =>
            val zdt = date.atStartOfDay(ZoneId.systemDefault)
            builder.startDate(new js.Date(zdt.toInstant.toEpochMilli))
          case _ => builder

      // val element = dom.document.getElementsByName(name)

      jq.datepicker(opts)

      jq.on(
        "changeDate",
        (rawEvt: JQueryEventObject) =>
          if changeDate.nonEmpty then
            val dt = rawEvt.asInstanceOf[DatepickerEventObject].date.toLocalDate
            changeDate.get(dt)
      )
