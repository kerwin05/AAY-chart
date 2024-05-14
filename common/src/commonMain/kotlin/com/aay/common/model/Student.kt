package com.aay.common.model

data class Student(
    val studentId: String,
    val name: String,
    val chinese: Double,
    val math: Double,
    val english: Double,
    val biology: Double,
    val history: Double,
    val geography: Double,
    val ethics: Double,
    val totalScore: Double
)

object StudentConstant {

    const val studentId = "学号"
    const val name = "姓名"
    const val chinese = "语文"
    const val math = "数学"
    const val english = "英语"
    const val biology = "生物"
    const val history = "历史"
    const val geography = "地理"
    const val ethics = "道法"
    const val totalScore = "总分"

}