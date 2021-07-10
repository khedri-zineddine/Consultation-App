package com.example.projettdm.requests.treatment

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TreatmentCrud {
    @GET("private/traitement")
    fun fetchTreatements(): Call<List<TreatmentItem>>
    @GET("private/traitement/{idTreatment}")
    fun findTreatment(@Path("idTreatment") idTreatment : Int?): Call<TreatmentItem>
}