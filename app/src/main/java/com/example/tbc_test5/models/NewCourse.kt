package com.example.tbc_test5.models

import com.squareup.moshi.Json

data class NewCourse(
    val id: Int,
    @Json(name = "icon_type")
    val iconType: String,
    val duration: Int,
    val title: String,
    val question: String,
    @Json(name = "main_color")
    val mainColor: String
)