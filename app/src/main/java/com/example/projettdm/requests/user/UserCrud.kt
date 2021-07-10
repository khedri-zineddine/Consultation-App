package com.example.projettdm.requests.user

import com.example.projettdm.constants.GlobalUser
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface userCrud {
    @GET("private/user/fetch")
    fun fetchUser(): Call<userResponseBody>
}