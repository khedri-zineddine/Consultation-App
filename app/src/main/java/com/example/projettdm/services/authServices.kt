package com.example.projettdm.services

import com.example.projettdm.constants.GlobalUser


object authServices {

    fun <T> buildService(authCrud : Class<T>) :T {
        return retroufitServices.retrofit.create(authCrud)
    }
}