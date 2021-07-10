package com.example.projettdm.services

import android.app.Application
import com.example.projettdm.services.room.RoomService

class appRoomService:Application() {
    override fun onCreate() {
        super.onCreate()
        RoomService.context=applicationContext
    }
}