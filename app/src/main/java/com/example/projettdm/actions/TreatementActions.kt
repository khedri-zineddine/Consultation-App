package com.example.projettdm.actions

import com.example.projettdm.requests.treatment.TreatmentItem
import com.example.projettdm.requests.treatment.TreatmentCrud
import com.example.projettdm.services.rdvServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object TreatementActions {
    val api: TreatmentCrud by lazy {
        rdvServices.buildService(TreatmentCrud::class.java)
    }
    fun fetchTreatements(onSucessCall:(status:Boolean, response:Any)-> Unit){
        val call= api.fetchTreatements()
        call.enqueue(object: Callback<List<TreatmentItem>> {
            override fun onResponse(
                call: Call<List<TreatmentItem>>,
                response: Response<List<TreatmentItem>>
            ) {
                if(response?.isSuccessful){
                    onSucessCall(true,response.body()!!)
                }else{
                    onSucessCall(false,"error when trying to find user")
                }
            }
            override fun onFailure(call: Call<List<TreatmentItem>>, t: Throwable) {
                onSucessCall(false,"error when trying to find user")
            }
        })
    }
    fun findTreatment(idTreatment:Int?,onSucessCall:(status:Boolean, response:Any)-> Unit){
        val call= api.findTreatment(idTreatment)
        call.enqueue(object: Callback<TreatmentItem> {
            override fun onResponse(
                call: Call<TreatmentItem>,
                response: Response<TreatmentItem>
            ) {
                if(response?.isSuccessful){
                    onSucessCall(true,response.body()!!)
                }else{
                    onSucessCall(false,"error when trying to find user")
                }
            }
            override fun onFailure(call: Call<TreatmentItem>, t: Throwable) {
                onSucessCall(false,"error when trying to find user")
            }
        })
    }
}