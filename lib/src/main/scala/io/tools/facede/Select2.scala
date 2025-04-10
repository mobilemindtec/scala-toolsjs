package io.tools.facede

import org.querki.jquery.{$, JQuery, JQueryEventObject}
import org.scalajs.dom.window
import upickle.default.{ReadWriter, read, write}

import scala.scalajs.js
import scala.scalajs.js.JSON
import scala.scalajs.js.annotation.{JSExport, JSExportAll, JSName}

object Select2:

  extension (a: js.Any)
    def stringify() = JSON.stringify(a)

  case class Select2Data(id: String, text: String)
    derives ReadWriter:
    def ID: Int = id.toInt

  private case class Select2AjaxParams(term: String, page: Int = 1) extends js.native
  private case class Result(
                                    results: Option[List[Select2Data]] = None,
                                    Results: Option[List[Select2Data]] = None,
                                    data: Option[List[Select2Data]] = None
                                  ) derives ReadWriter
  class Select2Opts(
                     val placeholder: String = "",
                     val allowClear: Boolean = false,
                     val disabled: Boolean = false,
                     val maximumInputLength: Int = 0,
                     val minimumInputLength: Int = 0,
                     val minimumResultsForSearch: Int = 0,
                     val multiple: Boolean = false,
                     val ajax: Select2Ajax
                   ) extends js.Object

  class Select2Ajax(val ajaxFn: () => String, val dataType: String = "json") extends js.Object:

    val url: js.Any = ajaxFn

    val processResults: js.Any = (data: js.Any) =>
      val results = tryParse(data).getOrElse(List())
      js.Dynamic.literal("results" -> toJS(results))

    private def tryParse(data: js.Any) =
      if !js.isUndefined(data) then
        val result = read[Result](data.stringify())
        List(result.Results, result.results, result.data)
          .find(_.nonEmpty)
          .flatten
      else None

    private def toJS(lst: List[Select2Data]) =
      write[List[Select2Data]](lst)

object Select2JQuery:
  import Select2._
  @js.native
  trait Select2 extends JQuery:
    def select2(opts: Select2Opts): JQuery = js.native
    def select2(): JQuery = js.native
    def select2(arg: String): js.Any = js.native
    def select2(data: js.Any): JQuery = js.native
    def trigger(data: js.Any): JQuery = js.native

  extension (jq: JQuery)
    def select2(opts: Select2Opts): JQuery =
      jq.asInstanceOf[Select2].select2(opts)

    def select2(arg: String): Any = jq.asInstanceOf[Select2].select2(arg)

    def select2(): JQuery = jq.asInstanceOf[Select2].select2()

    def select2Data(): Option[List[Select2Data]] =
      val data = jq.asInstanceOf[Select2].select2("data")
      if js.isUndefined(data) then None
      else Some(read[List[Select2Data]](data.stringify()))

    def select2Change(change: Option[List[Select2Data]] => Unit): JQuery =
      jq.on("change", (evt: JQueryEventObject, _) => change($(evt.currentTarget).select2Data()))
