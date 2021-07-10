package com.example.projettdm.services

import com.example.projettdm.constants.GlobalUser


object doctorServices {

    fun <T> buildService(DoctorsCrud : Class<T>) :T {
        return retroufitServices.retrofit.create(DoctorsCrud)
    }
}