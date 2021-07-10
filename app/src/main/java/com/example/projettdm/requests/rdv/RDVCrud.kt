package com.example.projettdm.requests.rdv

import com.example.projettdm.entity.AdviceEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RDVCrud {
    @GET("private/rdvp")
    fun fetchDrv(): Call<List<RDVItem>>

    @POST("private/rdv")
    fun addRDV(@Body RDV:RDVItem): Call<ResponseRdv>

    @POST("private/conseil")
    fun addAdvice(@Body Advice:AdviceEntity): Call<ResponseRdv>
}