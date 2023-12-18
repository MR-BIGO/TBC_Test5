package com.example.tbc_test5.network

import com.example.tbc_test5.models.CoursesResponse
import retrofit2.Response

class Repository {

    suspend fun getCourses(): Response<CoursesResponse> {
        return RetrofitInstance.api.getCourses()
    }
}