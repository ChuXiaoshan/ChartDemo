package com.cxsplay.chartdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }


    private fun init() {
        val data = mutableListOf(0f, 1.1f, 2.2f, 8.4f, 4f, 5f, 1f, 2f, 5f, 2.9f, 1.5f)
        val entries = mutableListOf<Entry>()
        for (i in data.indices) {
            entries.add(Entry(i.toFloat(), data[i]))
        }
        val dataSet = LineDataSet(entries, "Label1")
        val lineData = LineData(dataSet)
        lChart.data = lineData

        val xAxis = lChart.xAxis // X轴
        val yAxis = lChart.axisLeft// y轴

        lChart.axisRight.isEnabled = false
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.isEnabled = false

        yAxis.granularity = 1f
        yAxis.enableGridDashedLine(20f, 10f, 1f)
    }
}
