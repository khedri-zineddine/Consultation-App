package com.example.projettdm.services

import com.example.projettdm.constants.GlobalUser

object userServices {

    fun <T> buildService(userCrud : Class<T>) :T {
        return retroufitServices.retrofit.create(userCrud)
    }
}