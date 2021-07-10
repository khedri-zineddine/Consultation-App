package com.example.projettdm.requests.rdv

import java.io.Serializable

data class RDVItem (
    val idMedcine:Int,
    val idPatient:Int?,
    val date:String,
    val heure:String,
    val idRDV:Int?,
    val nom:String?

): Serializable {
}
data class  ResponseRdv(
    val message:String
): Serializable {
}

data class  AdviceItem(
    val idMedcine:Int?,
    val description:String
): Serializable {
}