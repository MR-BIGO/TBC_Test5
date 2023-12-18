package com.example.tbc_test5.models

import com.squareup.moshi.Json

data class CoursesResponse(
    @Json(name = "new_courses")
    val newCourses: List<NewCourse>,
    @Json(name = "active_courses")
    val activeCourses: List<ActiveCourse>
)