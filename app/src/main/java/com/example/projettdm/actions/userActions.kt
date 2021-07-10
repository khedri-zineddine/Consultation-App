package com.example.projettdm.actions

import android.util.Log
import com.example.projettdm.requests.user.userCrud
import com.example.projettdm.requests.user.userResponseBody
import com.example.projettdm.services.userServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object UserActions {
    val api: userCrud by lazy {
        userServices.buildService(userCrud::class.java)
    }
    fun fetchUser(onSucessCall:(status:Boolean,response:Any)-> Unit){
        val call=api.fetchUser()
        call.enqueue(object:Callback<userResponseBody>{
            override fun onResponse(
                call: Call<userResponseBody>,
                response: Response<userResponseBody>
            ) {
                if(response.isSuccessful){
                    onSucessCall(true,response.body()!!)
                }else{
                    onSucessCall(false,"error when trying to find user")
                }
            }
            override fun onFailure(call: Call<userResponseBody>, t: Throwable) {
                onSucessCall(false,"error when trying to find user")
            }
        })
    }
}
