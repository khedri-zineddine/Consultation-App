package com.example.projettdm.state

import androidx.room.*
import com.example.projettdm.entity.AdviceEntity

@Dao
interface AdviceDeo {

    @Query("select * from advices")
    fun getAdvices():List<AdviceEntity>

    @Query("select * from advices where isSynchronized=0")
    fun getAdvicesToSynchronize():List<AdviceEntity>

    @Insert
    fun addAdvice(vararg advice: AdviceEntity)

    @Update
    fun updateAdvice(advice: AdviceEntity)


}