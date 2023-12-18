package com.example.tbc_test5.network

import com.example.tbc_test5.models.CoursesResponse
import retrofit2.Response
import retrofit2.http.GET

interface IApiService {

    @GET("83160a49-fe85-46ba-bcf8-3cf5aa09f92b")
    suspend fun getCourses(): Response<CoursesResponse>
}