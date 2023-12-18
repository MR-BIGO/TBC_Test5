package com.example.tbc_test5.models

import com.squareup.moshi.Json

data class ActiveCourse(
    val id: Int,
    @Json(name = "booking_time")
    val bookingTime: String,
    val progress: Int,
    val title: String,
    @Json(name = "main_color")
    val mainColor: String,
    @Json(name = "background_color_present")
    val backgroundColorPresent: Int,
    @Json(name = "play_button_color_present")
    val playButtonColorPresent: Int,
    val image: String
)