package com.example.projettdm.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.projettdm.R
import com.example.projettdm.requests.treatment.TreatmentItem
import com.example.projettdm.ui.treatments.DetailTreatmentActivity

class TraitmentAdapter(val context: Context, var listTreatment:List<TreatmentItem>): RecyclerView.Adapter<TraitmentHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TraitmentHolder {
        return TraitmentHolder(LayoutInflater.from(context).inflate(R.layout.item_treatment_list, parent, false))
    }
    override fun onBindViewHolder(holder: TraitmentHolder, position: Int) {
        val treatment=listTreatment[position]
        holder.dateTreatment.text=treatment.date
        holder.durationText.text=treatment.duree+" Days"
        holder.doctorNameTreat.text="Dr."+treatment.nom+" "+treatment.prenom
        holder.cardViewTreatment.setOnClickListener {
            val treatment=listTreatment[position]
            val intent = Intent(context, DetailTreatmentActivity::class.java)
            intent.putExtra("treatment",treatment)
            context.startActivity(intent)
        }
    }
    override fun getItemCount()=listTreatment.size
}
class TraitmentHolder(view: View) : RecyclerView.ViewHolder(view) {
    val cardViewTreatment=view.findViewById<ConstraintLayout>(R.id.itemTreatement)
    val dateTreatment=view.findViewById<TextView>(R.id.dateTreatment)
    val durationText=view.findViewById<TextView>(R.id.durationText)
    val doctorNameTreat=view.findViewById<TextView>(R.id.doctor_name_treat)
}