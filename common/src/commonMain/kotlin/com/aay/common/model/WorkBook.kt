package com.aay.common.model

data class WorkBook(
    var name: String = "",
    var students: MutableList<Student> = ArrayList()
)