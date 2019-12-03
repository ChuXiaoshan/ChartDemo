package com.cxsplay.chartdemo

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.cxsplay.chartdemo.bean.Simple
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.ValueFormatter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        btn_change.setOnClickListener {
            val data = mutableListOf(
                Simple("1", "40990"),
                Simple("5", "23600"),
                Simple("10", "9999"),
                Simple("15", "7890"),
                Simple("20", "15080"),
                Simple("25", "19246"),
                Simple("30", "22400")
            )
            val entries = mutableListOf<Entry>()
            for (i in data) {
                entries.add(Entry(i.id!!.toFloat(), i.name!!.toFloat()))
            }
            val dataSet = LineDataSet(entries, "")
            val lineData = LineData(dataSet)
            lChart.data = lineData
            lChart.animateX(600)

            val pieEntries = mutableListOf(PieEntry(1f, "40"), PieEntry(2f, "60"))
            val pieDataSet = PieDataSet(pieEntries, "Pie label.")
            pieDataSet.setColors(ContextCompat.getColor(this, R.color.colorPrimary), ContextCompat.getColor(this, R.color.colorAccent))
            val pieData = PieData(pieDataSet)
            pieData.setDrawValues(false)
            piChart1.data = pieData
            piChart2.data = pieData
            piChart3.data = pieData
            piChart1.animateX(600)
            piChart2.animateX(600)
            piChart3.animateX(600)
        }
    }

    private fun init() {
        initLChart(lChart)
        run {
            initPi(piChart1)
            initPi(piChart2)
            initPi(piChart3)
        }
    }

    private fun initLChart(lChart: LineChart) {

        val data = mutableListOf(
            Simple("0", "4090"),
            Simple("3", "2360"),
            Simple("6", "999"),
            Simple("9", "7890"),
            Simple("12", "1580"),
            Simple("15", "1946"),
            Simple("18", "2200"),
            Simple("21", "2200")
        )
        val entries = mutableListOf<Entry>()
        for (i in data) {
            entries.add(Entry(i.id!!.toFloat(), i.name!!.toFloat()))
        }
        val dataSet = LineDataSet(entries, "")
        val lineData = LineData(dataSet)
        lChart.data = lineData

        val xAxis = lChart.xAxis // X轴
        val yAxis = lChart.axisLeft// y轴
        lChart.axisRight.isEnabled = false
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        yAxis.enableGridDashedLine(10f, 5f, 1f)
        lChart.axisRight.isInverted = true
        lChart.xAxis.labelCount = 9
        lChart.isDragEnabled = false
        lChart.setScaleEnabled(false)
        lChart.setNoDataText("暂无数据")
        lChart.description = null
        lChart.legend.isEnabled = false
        xAxis.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return "${value.toInt()}时"
            }
        }
        lChart.animateX(600)
    }

    private fun initPi(pieChart: PieChart) {

        val pieEntries = mutableListOf(PieEntry(1f, "70"), PieEntry(2f, "30"))
        val pieDataSet = PieDataSet(pieEntries, "Pie label.")
        pieDataSet.setColors(ContextCompat.getColor(this, R.color.colorPrimary), ContextCompat.getColor(this, R.color.colorAccent))
        val pieData = PieData(pieDataSet)
        pieData.setDrawValues(false)
        pieChart.data = pieData

        pieChart.legend.isEnabled = false
        pieChart.description = null
        pieChart.centerText = "23456\n26%"
        pieChart.transparentCircleRadius = 0f
        pieChart.isRotationEnabled = false
        pieChart.isHighlightPerTapEnabled = false
        pieChart.animateY(600)
        pieChart.setDrawEntryLabels(false)
        pieChart.setEntryLabelColor(Color.WHITE)

    }
}
