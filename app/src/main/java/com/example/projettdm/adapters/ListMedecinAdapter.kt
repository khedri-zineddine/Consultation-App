package com.example.projettdm.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import com.example.projettdm.requests.doctors.DoctorItem
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projettdm.R
import com.example.projettdm.constants.apiConstants
import com.example.projettdm.ui.home.DetailDoctorActivity


class ListMedecinAdapter (val context: Context, var data:List<DoctorItem>,var typeData:String): RecyclerView.Adapter<MedecinHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedecinHolder {
        return MedecinHolder(LayoutInflater.from(context).inflate(R.layout.item_list_medecin, parent, false))
    }

    override fun onBindViewHolder(holder: MedecinHolder, position: Int) {
        val doctor=data[position]
        holder.fullName.text="Dr."+doctor.nom+" "+doctor.prenom
        holder.workSpiciality.text=doctor.specialite
        holder.phoneNumber.text=doctor.phone
        Glide.with(context)
            .load(apiConstants.SERVER_URL+doctor.photo)
            .into(holder.iamgeDocotor)
        holder.itemMedecin.setOnClickListener {
            val intent = Intent(context, DetailDoctorActivity::class.java)
            intent.putExtra("doctor", doctor)
            intent.putExtra("typeMedecin", typeData)
            context.startActivity(intent)
        }
        holder.phone_btn.setOnClickListener {it->
            val uri = Uri.parse("tel:${doctor.phone}")
            val intent = Intent(Intent.ACTION_DIAL, uri)
            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
            }
        }
        holder.map_btn.setOnClickListener {it->
            val gmmIntentUri = Uri.parse("google.navigation:q=${doctor.lat},${doctor.lang}")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            context.startActivity(mapIntent)
        }

    }

    override fun getItemCount()=data.size
}
class MedecinHolder(view: View) : RecyclerView.ViewHolder(view) {
    val itemMedecin=view.findViewById<ConstraintLayout>(R.id.itemTreatement)
    val phone_btn=view.findViewById<LinearLayout>(R.id.phone_item)
    val map_btn=view.findViewById<LinearLayout>(R.id.map_item)
    val fullName=view.findViewById<TextView>(R.id.fullName)
    val workSpiciality=view.findViewById<TextView>(R.id.workSpiciality)
    val phoneNumber=view.findViewById<TextView>(R.id.phoneNumber)
    val iamgeDocotor = view.findViewById<ImageView>(R.id.picture_medecin)
}