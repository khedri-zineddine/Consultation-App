package com.example.projettdm.requests.user

import java.io.Serializable

data class userResponseBody (
    val idPatient:Int,
    val nom:String,
    val prenom:String,
    val Phone:String,
    val Photo:String,
    var token:String
): Serializable {
}