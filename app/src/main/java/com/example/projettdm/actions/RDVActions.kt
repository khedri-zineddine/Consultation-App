package com.example.projettdm.actions

import com.example.projettdm.entity.AdviceEntity
import com.example.projettdm.requests.rdv.AdviceItem
import com.example.projettdm.requests.rdv.RDVCrud
import com.example.projettdm.requests.rdv.RDVItem
import com.example.projettdm.requests.rdv.ResponseRdv
import com.example.projettdm.services.rdvServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RDVActions {
    val api: RDVCrud by lazy {
        rdvServices.buildService(RDVCrud::class.java)
    }
    fun addRDV(RDV: RDVItem, onSucessCall:(status:Boolean, response:Any)-> Unit){
        val call= api.addRDV(RDV)
        call.enqueue(object: Callback<ResponseRdv> {
            override fun onResponse(
                call: Call<ResponseRdv>,
                response: Response<ResponseRdv>
            ) {
                if(response?.isSuccessful){
                    onSucessCall(true,response.body()!!)
                }else{
                    onSucessCall(false,"error when trying to find user")
                }
            }
            override fun onFailure(call: Call<ResponseRdv>, t: Throwable) {
                onSucessCall(false,"error when trying to find user")
            }
        })
    }
    fun fetchRDV(onSucessCall:(status:Boolean, response:Any)-> Unit){
        val call= api.fetchDrv()
        call.enqueue(object: Callback<List<RDVItem>> {
            override fun onResponse(
                call: Call<List<RDVItem>>,
                response: Response<List<RDVItem>>
            ) {
                if(response?.isSuccessful){
                    onSucessCall(true,response.body()!!)
                }else{
                    onSucessCall(false,"error when trying to find user")
                }
            }
            override fun onFailure(call: Call<List<RDVItem>>, t: Throwable) {
                onSucessCall(false,"error when trying to find user")
            }
        })
    }
    fun addAdvice(Advice: AdviceEntity, onSucessCall:(status:Boolean, response:Any)-> Unit){
        val call= api.addAdvice(Advice)
        call.enqueue(object: Callback<ResponseRdv> {
            override fun onResponse(
                call: Call<ResponseRdv>,
                response: Response<ResponseRdv>
            ) {
                if(response?.isSuccessful){
                    onSucessCall(true,response.body()!!)
                }else{
                    onSucessCall(false,"error when trying to find user")
                }
            }
            override fun onFailure(call: Call<ResponseRdv>, t: Throwable) {
                onSucessCall(false,"error when trying to find user")
            }
        })
    }
}