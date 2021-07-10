package com.example.projettdm.services.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projettdm.entity.AdviceEntity
import com.example.projettdm.state.AdviceDeo

@Database(entities = arrayOf(AdviceEntity::class),version=1)
abstract class roomApp: RoomDatabase() {
    abstract fun getAdviceDeo(): AdviceDeo
}