package com.example.projettdm.services

import com.example.projettdm.constants.GlobalUser

object rdvServices {
    fun <T> buildService(RDVCrud : Class<T>) :T {
        return retroufitServices.retrofit.create(RDVCrud)
    }
}