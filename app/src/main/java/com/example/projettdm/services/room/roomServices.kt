package com.example.projettdm.services.room

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room

@SuppressLint("StaticFieldLeak")
object RoomService {
    lateinit var context:Context
    val database by lazy {
        Room.databaseBuilder(context, roomApp::class.java,"dbProject")
            .allowMainThreadQueries().build()
    }
}