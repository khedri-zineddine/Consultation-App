package com.example.projettdm.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "advices")
data class AdviceEntity(
    val description:String,
    val idMedcine:Int?,
    var isSynchronized:Int =0
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "advice_id")
    var AdviceId:Int?=null
}