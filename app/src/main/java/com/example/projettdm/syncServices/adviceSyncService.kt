package com.example.projettdm.syncServices

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import androidx.work.impl.utils.futures.SettableFuture
import com.example.projettdm.actions.RDVActions
import com.example.projettdm.entity.AdviceEntity
import com.example.projettdm.services.room.RoomService
import com.google.common.util.concurrent.ListenableFuture
import kotlinx.android.synthetic.main.fragment_dialog_ask_docotr.*

@SuppressLint("RestrictedApi")
class adviceSyncService(val ctx: Context, val workParamters: WorkerParameters):ListenableWorker(ctx, workParamters){

    lateinit var  future:SettableFuture<Result>
    override fun startWork(): ListenableFuture<Result> {
        future = SettableFuture.create()
        val consultation = RoomService.database.getAdviceDeo().getAdvicesToSynchronize()
        addAdvice(consultation)
        return future
    }
    fun addAdvice(advices: List<AdviceEntity>) {
        advices.map { item->
            RDVActions.addAdvice(item){status, response ->
                if(status){
                    item.isSynchronized = 1
                    RoomService.database.getAdviceDeo().updateAdvice(item)
                    future.set(Result.success())
                }else{
                    future.set(Result.retry())
                }
            }
        }
    }
}