package com.example.projettdm.requests.auth

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface authCrud {
    @POST("patient/login")
    fun login(@Body credentials: authRequestBody): Call<authResponseBody>
}