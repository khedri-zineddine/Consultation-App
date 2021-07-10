package com.example.projettdm.ui.treatments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.projettdm.R
import com.example.projettdm.actions.TreatementActions
import com.example.projettdm.adapters.TableTraitementDetail
import com.example.projettdm.constants.apiConstants
import com.example.projettdm.requests.treatment.MedicamentItem
import com.example.projettdm.requests.treatment.TreatmentItem
import kotlinx.android.synthetic.main.activity_detail_doctor.*
import kotlinx.android.synthetic.main.activity_detail_treatment.*
import kotlinx.android.synthetic.main.activity_detail_treatment.goBackTreatment

class DetailTreatmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_treatment)
        contentDetail?.setVisibility(View.GONE)
        goBackTreatment.setOnClickListener{
            finish()
        }
        setUpUi()
        val treatment=intent.getSerializableExtra("treatment") as TreatmentItem
        TreatementActions.findTreatment(treatment.idTraitement){status, response ->
            loadingList?.setVisibility(View.GONE)
            if(status){
                contentDetail?.setVisibility(View.VISIBLE)
                val dataTreatment=response as TreatmentItem
                val listData= dataTreatment.medicament as List<MedicamentItem>
                list_treatment_table.layoutManager = LinearLayoutManager(this)
                list_treatment_table.adapter = TableTraitementDetail(this,listData)
            }
        }
    }

    private fun setUpUi() {
        val treatment=intent.getSerializableExtra("treatment") as TreatmentItem
        doctorName.text="Dr.${treatment.nom} ${treatment.prenom}"
        start_range.text="Start : ${treatment.date}"
        end_range.text="End in ${treatment.duree} Days"
        Glide.with(this)
            .load(apiConstants.SERVER_URL+treatment.photo)
            .into(image_doctor_treatment)
    }
}