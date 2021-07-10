package com.example.projettdm.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.work.*
import com.example.projettdm.R
import com.example.projettdm.actions.RDVActions
import com.example.projettdm.entity.AdviceEntity
import com.example.projettdm.requests.rdv.AdviceItem
import com.example.projettdm.services.room.RoomService
import com.example.projettdm.syncServices.adviceSyncService
import kotlinx.android.synthetic.main.fragment_dialog_ask_docotr.*

class DialogAskDocotr : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialog_ask_docotr,container,false)
    }

    @SuppressLint("ResourceType", "UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submit_advice.setOnClickListener{
            val textAdviceSent=textAdvice.text.toString()
            val idMedcine=arguments?.getInt("idMedcine")
            addConsultation(AdviceEntity(textAdviceSent,idMedcine))
        }
    }
    private fun addConsultation(advice:AdviceEntity) {
        RoomService.database.getAdviceDeo().addAdvice(advice)
        textAdvice.text.clear()
        loading_actions.visibility=View.VISIBLE
        scsheduleSycn()
    }
    private fun scsheduleSycn() {
        val constraints = Constraints.Builder().
        setRequiredNetworkType(NetworkType.UNMETERED).
        build()
        val req= OneTimeWorkRequest.Builder (adviceSyncService::class.java).
        setConstraints(constraints).addTag("id1").
        build()
        val workManager = WorkManager.getInstance(requireContext())
        workManager.enqueueUniqueWork("work", ExistingWorkPolicy.REPLACE,req)
    }
}