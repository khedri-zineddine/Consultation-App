package com.example.projettdm.actions

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.projettdm.requests.auth.authCrud
import com.example.projettdm.requests.auth.authRequestBody
import com.example.projettdm.requests.auth.authResponseBody
import com.example.projettdm.services.userServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object AuthActions {
    val api: authCrud by lazy {
        userServices.buildService(authCrud::class.java)
    }
    fun login(userAuth:authRequestBody,onSucessCall:(status:Boolean,response:Any)-> Unit){
        val call= api.login(userAuth)
        call.enqueue(object: Callback<authResponseBody> {
            override fun onResponse(
                call: Call<authResponseBody>,
                response: Response<authResponseBody>
            ) {

                if(response.isSuccessful){
                    onSucessCall(true,response.body()!!)
                }else{
                    onSucessCall(false,"error when trying to find user")
                }
            }
            override fun onFailure(call: Call<authResponseBody>, t: Throwable) {
                onSucessCall(false,"error when trying to find user")
            }
        })
    }
}