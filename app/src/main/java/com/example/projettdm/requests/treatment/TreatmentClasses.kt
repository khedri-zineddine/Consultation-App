package com.example.projettdm.requests.treatment

import java.io.Serializable

data class TreatmentItem(
    val idTraitement:Int?,
    val date:String?,
    val duree:String?,
    val photo:String?,
    val nom:String,
    val prenom:String,
    val medicament:List<MedicamentItem>?
): Serializable {
}
data class MedicamentItem(
    val idMedicament:Int?,
    val timeUse:String?,
    val NameMedicament:String?,
    val Qauntity:String?,
): Serializable {
}