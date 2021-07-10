package com.example.projettdm.requests.auth

import com.example.projettdm.requests.user.userResponseBody
import java.io.Serializable

data class authRequestBody (
    val phone:String,
    val password:String
    ): Serializable {
}
data class authResponseBody (
    val token:String,
    val message:String,
    val user: userResponseBody
): Serializable {
}