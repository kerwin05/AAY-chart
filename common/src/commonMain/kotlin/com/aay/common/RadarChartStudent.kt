package com.aay.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aay.common.model.Student
import com.aay.common.model.StudentConstant
import com.aay.compose.radarChart.RadarChart
import com.aay.compose.radarChart.model.NetLinesStyle
import com.aay.compose.radarChart.model.Polygon
import com.aay.compose.radarChart.model.PolygonStyle

@Composable
fun RadarChartStudent(student: Student) {

    val radarLabels =
        listOf(
            StudentConstant.chinese,
            StudentConstant.math,
            StudentConstant.english,
            StudentConstant.biology,
            StudentConstant.history,
            StudentConstant.geography,
            StudentConstant.ethics,
        )
    val values = listOf(
        student.chinese,
        student.math,
        student.english,
        student.biology,
        student.history,
        student.geography,
        student.ethics,
    )
    val labelsStyle = TextStyle(
        color = Color(0xFF333333),
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    )

    val scalarValuesStyle = TextStyle(
        color = Color(0xFF333333),
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    )

    RadarChart(
        modifier = Modifier.fillMaxSize(),
        radarLabels = radarLabels,
        labelsStyle = labelsStyle,
        netLinesStyle = NetLinesStyle(
            netLineColor = Color(0xFFC0C0C0),
            netLinesStrokeWidth = 2f,
            netLinesStrokeCap = StrokeCap.Butt
        ),
        scalarSteps = 5,
        scalarValue = 120.0,
        scalarValuesStyle = scalarValuesStyle,
        polygons = listOf(
            Polygon(
                values = values,
                unit = "",
                style = PolygonStyle(
                    fillColor = Color(0xFFADD8E6),
                    fillColorAlpha = 0.5f,
                    borderColor = Color(0xFF00008B),
                    borderColorAlpha = 0.5f,
                    borderStrokeWidth = 2f,
                    borderStrokeCap = StrokeCap.Butt,
                )
            ),
        )
    )

}