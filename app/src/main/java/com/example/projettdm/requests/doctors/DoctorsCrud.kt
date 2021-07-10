package com.example.projettdm.requests.doctors

import com.example.projettdm.requests.user.userResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DoctorsCrud {
    @GET("private/medcines/list/{typeDoctor}")
    fun fetchDoctors(@Path("typeDoctor") typeDoctor : String?): Call<List<DoctorItem>>
}