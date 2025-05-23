package io.tools.components

import com.raquo.laminar.api.L.*
import com.raquo.laminar.nodes.ReactiveElement
import io.tools.components.DataTable.*
import io.tools.util.NumberUtil
import org.scalajs.dom
import org.scalajs.dom.{HTMLTableCellElement, HTMLTableRowElement}

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.collection.mutable

class DataTable[T](val dtVar: Var[DtConfigs[T]]):

  private var onTableChange: (DataTable[T], DtConfigs[T], Int) => Unit = null
  private val emptyVar = Var(false)
  private val pageSizeVar = Var("25")
  private val searchVar = Var("")
  private val configsUpdatedVar = Var(dtVar.now())
  private val pageSizes = List("10", "25", "50", "100")

  def pageSize = dtVar.now().pageSize

  def updateRows(data: Option[List[T]], totalCount: Option[Int], currentIndex: Int = 0) =
    val pageSize = dtVar.now().pageSize

    data.foreach { its => emptyVar.update(_ => its.isEmpty) }

    Option((data, totalCount))
      .filter((x, y) => x.nonEmpty && y.nonEmpty)
      .map((x, y) => (x.get, y.get))
      .map((l, t) => {
        dtVar.update(_ =>
          DtConfigs(
            PageConfig(t, pageSize, currentIndex),
            l.map(x => TableRowEvent(x)),
            pageSize
          )
        )
      })

  private def pageItem(cssClass: String, text: String, pageIdx: Int) =
    li(
      cls(cssClass),
      a(
        href("#"),
        text,
        onClick --> (_ => onTableChange(this, this.dtVar.now(), pageIdx))
      )
    )

  private def paginate(cnf: PageConfig): HtmlElement =
    val ((min, max), pages) = makePagination(cnf)
    div(
      cls := "row",
      div(
        cls := List("col-xs-12", "col-md-6"),
        span(cls("pull-left"), s"Exibindo de ${min + 1} até $max de ${cnf.totalCount}")
      ),
      div(
        cls := List("col-xs-12", "col-md-6"),
        ul(
          cls("pagination pull-right"),
          pages.map(p => pageItem(p.css, p.label, p.page) // go first)
          )
        )
      )
    )
  private def tableActions() =
    div(
      cls := "row",
      styleAttr := "padding: 5px 0",
      div(
        cls := "col-xs-3",
        select(
          cls := "form-control",
          styleAttr := "width: 80px; float: left; margin-right: 10px",
          pageSizes.map {
              case i@"25" => option(i, value := i, selected := true)
              case i => option(value := i, i)
          },
          onChange.mapToValue --> pageSizeVar
        ),
        p(
          styleAttr := "padding: 7px",
          "Registros por página"
        )
      ),
      div(
        cls := "col-xs-3 col-xs-offset-6",
        input(
          cls := "form-control",
          placeholder := "Pesquisar...",
          onInput.mapToValue --> searchVar
        )
      )
    )

  private def makePagination(
    cnf: PageConfig
  ): ((Int, Int), mutable.Buffer[TablePage]) =
    val (totalCount, totalPerPage, currPage) = (cnf.totalCount, cnf.totalPerPage, cnf.currentPage)
    val totalPages = math.ceil(totalCount.toDouble / totalPerPage).toInt
    val maxPages = math.min(5, totalPages)
    val middle = maxPages / 2
    val baseMin = math.max(currPage - middle, 0)
    val baseMax = math.min(baseMin + maxPages, totalPages)
    val rest = maxPages - (baseMax - baseMin)
    val min = math.min(baseMin - rest, baseMin)
    val max = math.min(baseMax + rest, totalPages)

    val (nextIdx, prevIdx) = (currPage + 1, currPage - 1)
    val (hasPrev, hasNext) = (prevIdx >= 0, nextIdx < totalPages)
    val prevState = if hasPrev then "" else "disabled"
    val nextState = if hasNext then "" else "disabled"
    val arrowCls = "footable-page-arrow"
    val pageCls = "footable-page"
    val pageActiveCls = s"$pageCls active"
    val pages = new mutable.ListBuffer[TablePage]()

    pages += TablePage(0, "«", s"$arrowCls $prevState", hasPrev)

    if hasPrev then pages += TablePage(currPage - 1, "‹", arrowCls)

    pages ++= Range(min, max)
      .map(p =>
        TablePage(
          p,
          s"${p + 1}",
          if p == currPage then pageActiveCls else pageCls,
          current = p == currPage
        )
      )

    if hasNext then pages += TablePage(currPage + 1, "›", arrowCls)

    pages += TablePage(totalPages - 1, "»", s"$arrowCls $nextState", hasNext)

    val start = currPage * totalPerPage
    val end = (currPage * totalPerPage) + totalPerPage

    ((start, if end < totalCount then end else totalCount), pages)

  private def node(
    columns: List[String | ReactiveElement[HTMLTableCellElement]],
    onRow: TableRowEvent[T] => ReactiveElement[HTMLTableRowElement] = r => tr(),
    onRowCel: (Int, TableRowEvent[T]) => ReactiveElement[HTMLTableCellElement],
    onChange: (DataTable[T], DtConfigs[T], Int) => Unit,
    onReady: DataTable[T] => Unit
  ): HtmlElement =

    this.onTableChange = onChange
    given Owner = unsafeWindowOwner

    div(
      tableActions(),
      div(
        cls := "row",
        div(
          cls := "col-xs-12",
          table(
            onMountCallback(_ =>
              onReady(this)
              
              pageSizeVar.signal
                .combineWith(searchVar.signal)
                .foreach {
                  case (size, s) =>
                    val newState = dtVar.now().copy(pageSize = size.toInt, search = s)
                    this.dtVar.update(_ => newState)
                    configsUpdatedVar.update(_ => newState)
                }

              configsUpdatedVar.signal.foreach {
                state => onTableChange(this, state, state.pageConfig.currentPage)
              }
            ),
            cls("table table-striped table-bordered"),
            thead(tr(columns.map {
              case str: String => th(cls("text-center"), str)
              case x           => x.asInstanceOf[ReactiveElement[HTMLTableCellElement]]
            })),
            tbody(
              children <-- dtVar.signal.map(
                _.data
                  .map(v =>
                    onRow(v).amend(
                      columns.indices.map(i => onRowCel(i, v))
                    )
                  )
                  .toSeq
              )
            )
          ),
          div(
            child.maybe <-- dtVar.signal.map(p =>
              if p.pageConfig.isEmpty then None else Some(paginate(p.pageConfig))
            )
          )
        ),
        child <-- emptyVar.signal.map(emptyMessage)
      )
    )

  private def emptyMessage(empty: Boolean) =
    if empty
    then div(
      cls := "col-xs-12",
      div(
        cls := "alert alert-info text-center",
        "Nenhum registro encontrado"
      )
    )
    else span()


object DataTable:

  /** {{{
    *   val dtVar = Var(DtConfigs[Model](pageSize = 10))
    *
    *   def onRow(idx: Int, state: TableRowEvent[Model]) =
    *     idx match
    *         case 0 => tdText(state, _.id.toString)
    *         ...
    *
    *   def onChange(dt: DataTable[Model], newPageIdx: Int) =
    *     // get next page
    *     // offset = newPageIdx * dt.pageSize
    *     dt.updateRows(newRows, totalCount, newPageIdx)
    *
    *   def node =
    *     DataTable(
    *          dtVar,
    *         columns,
    *         onRow,
    *         onChange,
    *         (dt) => onChange(dt, 0)
    *       ),
    * }}}
    *
    * @param columns
    *   List of column names
    * @param onRow
    *   Row maker
    * @param onChange
    *   Called when next, last is fired
    * @param onReady
    *   Called when table is ready to be populated
    * @return
    *   A new datatable element
    */
  def apply[T](
    dtVar: Var[DtConfigs[T]],
    columns: List[String | ReactiveElement[HTMLTableCellElement]],
    onRow: TableRowEvent[T] => ReactiveElement[HTMLTableRowElement],
    onRowCel: (Int, TableRowEvent[T]) => ReactiveElement[HTMLTableCellElement],
    onChange: (DataTable[T], DtConfigs[T], Int) => Unit,
    onReady: DataTable[T] => Unit
  ): HtmlElement =
    new DataTable(dtVar).node(columns, onRow, onRowCel, onChange, onReady)

  private case class TablePage(
    page: Int,
    label: String,
    css: String,
    enabled: Boolean = true,
    current: Boolean = false
  )

  case class PageConfig(totalCount: Int = 0, totalPerPage: Int = 0, currentPage: Int = 0):
    def isEmpty = totalCount == 0

  case class TableRowEvent[T](value: T):
    val buss = Var[T](value)

  case class DtConfigs[T](
    pageConfig: PageConfig = PageConfig(),
    data: List[TableRowEvent[T]] = List(),
    pageSize: Int = 0,
    search: String = ""
  )

  def lnk[T](data: T, text: String, icon: String, click: Option[T => Unit] = None) =
    a(
      href(text),
      span(cls(s"fa fa-$icon")),
      inContext { thisNode =>
        thisNode.events(onClick) --> (_ => click.map(f => f(data)))
      }
    )

  def tdText[T](state: TableRowEvent[T], fn: T => String, cssClass: Option[String] = None) =
    td(
      cls(cssClass.getOrElse("")),
      child.text <-- state.buss.signal.map(fn)
    )

  def tdDateTime[T](
    state: TableRowEvent[T],
    fn: T => LocalDateTime | Option[LocalDateTime],
    cssClass: Option[String] = None
  )(using df: DateTimeFormatter) =
    td(
      cls(cssClass.getOrElse("")),
      cls("text-center"),
      child.text <-- state.buss.signal.map { s =>
        fn(s) match
          case d: LocalDateTime => d.format(df)
          case Some(d)          => d.format(df)
          case _                => "-"
      }
    )

  def tdBoolean[T](state: TableRowEvent[T], fn: T => Boolean) =
    td(
      cls("text-center"),
      child.text <-- state.buss.signal.map(s => if fn(s) then "SIM" else "NÃO")
    )

  def tdMoney[T](state: TableRowEvent[T], fn: T => Double) =
    td(
      cls("text-right"),
      child.text <-- state.buss.signal.map(s => NumberUtil.toMoney(fn(s)))
    )

  def tdBooleanLable[T](state: TableRowEvent[T], fn: T => Boolean) =
    td(
      cls("text-center"),
      child <-- state.buss.signal.map(s =>
        if fn(s) then span(cls("label label-primary"), "SIM")
        else span(cls("label label-danger"), "NÃO")
      )
    )

  def tdIcon[T](
    state: TableRowEvent[T],
    fn: T => (String, String),
    click: Option[T => Unit] = None,
    show: Option[T => Boolean] = None
  ) =
    td(
      cls("text-center"),
      child <-- state.buss.signal
        .map(fn)
        .map((path, icon) =>
          if show.getOrElse(_ => true)(state.value) then lnk(state.value, path, icon, click)
          else span()
        )
    )
