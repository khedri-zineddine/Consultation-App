package com.example.projettdm.ui.home

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.example.projettdm.R
import com.example.projettdm.actions.RDVActions
import com.example.projettdm.constants.apiConstants
import com.example.projettdm.requests.doctors.DoctorItem
import com.example.projettdm.requests.rdv.RDVItem
import com.example.projettdm.ui.appointments.QrCodeFragment
import kotlinx.android.synthetic.main.activity_detail_doctor.*
import java.text.SimpleDateFormat
import java.util.*

class DetailDoctorActivity : AppCompatActivity() {
    val calendar = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_doctor)
        setUpUi()
        submit_rnd.setOnClickListener{
            prendRndv()
        }
        goBackTreatment.setOnClickListener{
            finish()
        }
        dateRndv.setOnDateChangeListener { view, year, month, dayOfMonth ->
            calendar.set(year,month,dayOfMonth)
            dateRndv.date = calendar.timeInMillis
        }
    }

    private fun setUpUi() {
        val doctor=intent.getSerializableExtra("doctor") as DoctorItem
        val typeMedecin=intent.getSerializableExtra("typeMedecin") as String
        doctor_name.text="Dr."+doctor.nom+" "+doctor.prenom
        spiciality_doctor.text=doctor.specialite
        phone_number.text=doctor.phone
        Glide.with(this)
            .load(apiConstants.SERVER_URL+doctor.photo)
            .into(image_doctor)
        if(typeMedecin=="all"){
            adviseCall?.setVisibility(View.GONE)
        }else{
            adviseCall.setOnClickListener{
                val dialogAdvise= DialogAskDocotr()
                val args = bundleOf("idMedcine" to doctor.idMedcine)
                dialogAdvise.arguments=args
                val fragmentManager = (this as FragmentActivity).supportFragmentManager
                dialogAdvise.show(fragmentManager, "fragment_dialog_ask_docotr")
            }
        }
        phoneCall.setOnClickListener{
            val uri = Uri.parse("tel:${doctor.phone}")
            val intent = Intent(Intent.ACTION_DIAL, uri)
            if (intent.resolveActivity(this.packageManager) != null) {
                startActivity(intent)
            }
        }
        mapCall.setOnClickListener{
            val gmmIntentUri = Uri.parse("google.navigation:q=${doctor.lat},${doctor.lang}")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            startActivity(mapIntent)
        }
    }

    private fun prendRndv() {
        val doctor=intent.getSerializableExtra("doctor") as DoctorItem
        val dateFormat = SimpleDateFormat("yyyy-MM-dd");
        val checkedTimeId=groupeTimes.getCheckedRadioButtonId()
        val dateRndvValue=dateFormat.format(dateRndv.date)
        val timeRndv=findViewById<RadioButton>(checkedTimeId)?.getText().toString()
        if(dateRndvValue!=null && timeRndv!=null){
            val rdvInstance= RDVItem(doctor.idMedcine,null,dateRndvValue,timeRndv,null,null)
            RDVActions.addRDV(rdvInstance){ status, response ->
            }
        }
    }

}