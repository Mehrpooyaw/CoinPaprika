package com.example.coinpaprika.presentation.ui.chart

import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.viewinterop.AndroidView
import com.example.coinpaprika.presentation.ui.theme.DarkNeonPurple
import com.example.coinpaprika.presentation.ui.theme.NeonGreen
import com.example.coinpaprika.presentation.ui.theme.NeonPink
import com.example.coinpaprika.presentation.ui.theme.NeonPurple
import com.github.mikephil.charting.charts.CandleStickChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.CandleData
import com.github.mikephil.charting.data.CandleDataSet
import com.github.mikephil.charting.data.CandleEntry
import java.util.*
import kotlin.collections.ArrayList


@Composable
fun CandleStick(
    modifier: Modifier,
    list : List<List<Double?>?>?
){
    AndroidView(factory =
    {
        val view = LayoutInflater.from(it).inflate(com.example.coinpaprika.R.layout.candle_stick, null, false)
        val candleStickChart: CandleStickChart = view.findViewById(com.example.coinpaprika.R.id.chart1)
        candleStickChart.isHighlightPerDragEnabled = true

        candleStickChart.setDrawBorders(true)

        candleStickChart.axisRight.isEnabled = false
        candleStickChart.setBorderColor(DarkNeonPurple.toArgb())

        val rightAxis = candleStickChart.axisLeft
        rightAxis.setDrawGridLines(false)
        candleStickChart.requestDisallowInterceptTouchEvent(true)

        val xAxis = candleStickChart.xAxis

        xAxis.setDrawGridLines(false)

        xAxis.setDrawLabels(true)
        xAxis.textColor = Color.TRANSPARENT
        xAxis.position = XAxis.XAxisPosition.BOTTOM

        xAxis.setLabelCount(7, false)

        rightAxis.textColor = Color.WHITE
        xAxis.granularity = 1f
        xAxis.isGranularityEnabled = true
        xAxis.setAvoidFirstLastClipping(true)
        val l = candleStickChart.legend
        l.isEnabled = false
        val yValsCandleStick = ArrayList<CandleEntry>()
        list?.subList(0,100)?.forEachIndexed(){ index, item ->

            // OPEN TIME ,  Open High Low Close
            yValsCandleStick.add(CandleEntry(
                    index.toFloat() ,
                item?.get(2)?.toFloat()?:0f, item?.get(3)?.toFloat()?:0f, item?.get(1)?.toFloat()?:0f, item?.get(4)?.toFloat()?:0f
            ))
        }

        val set1 = CandleDataSet(yValsCandleStick, "DataSet 1")

        set1.color = Color.rgb(80, 80, 80)
        set1.shadowColor = NeonPurple.toArgb()
        set1.shadowWidth = 0.8f
        set1.highlightLineWidth = 0f
        set1.increasingPaintStyle = Paint.Style.FILL
        set1.decreasingColor = NeonPink.toArgb()
        set1.decreasingPaintStyle = Paint.Style.FILL
        set1.increasingColor = NeonGreen.toArgb()
        set1.increasingPaintStyle = Paint.Style.FILL
        set1.neutralColor = Color.LTGRAY
        set1.barSpace= 100f
        set1.setDrawValues(false)
        val data = CandleData(set1)
        candleStickChart.data = data
        candleStickChart.invalidate()
        view


    },modifier = modifier
        .fillMaxWidth()
        .aspectRatio(16 / 9f))
}




