package com.example.projettdm.actions

import com.example.projettdm.requests.doctors.DoctorItem
import com.example.projettdm.requests.doctors.DoctorsCrud
import com.example.projettdm.services.doctorServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DoctorActions {
    val api: DoctorsCrud by lazy {
        doctorServices.buildService(DoctorsCrud::class.java)
    }
    fun fetchDoctors(typeDoctor:String,onSucessCall:(status:Boolean,response:Any)-> Unit){
        val call= api.fetchDoctors(typeDoctor)
        call.enqueue(object: Callback<List<DoctorItem>> {
            override fun onResponse(
                call: Call<List<DoctorItem>>,
                response: Response<List<DoctorItem>>
            ) {
                if(response?.isSuccessful){
                    onSucessCall(true,response.body()!!)
                }else{
                    onSucessCall(false,"error when trying to find user")
                }
            }
            override fun onFailure(call: Call<List<DoctorItem>>, t: Throwable) {
                onSucessCall(false,"error when trying to find user")
            }
        })
    }

}