package com.example.projettdm.requests.doctors

import java.io.Serializable

data class DoctorItem (
    val idMedcine:Int,
    val nom:String?,
    val prenom:String?,
    val phone:String?,
    val specialite:String?,
    val photo:String?,
    val lang:String?,
    val lat:String?,

): Serializable {
}
