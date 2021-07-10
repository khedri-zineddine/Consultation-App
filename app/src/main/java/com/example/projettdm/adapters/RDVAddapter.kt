package com.example.projettdm.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projettdm.R
import com.example.projettdm.requests.rdv.RDVItem
import com.example.projettdm.ui.appointments.QrCodeFragment

class RDVAddapter(val context: Context, var data:List<RDVItem>, var fragmentManager: FragmentManager): RecyclerView.Adapter<RDVHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RDVHolder {
        return RDVHolder(LayoutInflater.from(context).inflate(R.layout.item_list_rdv, parent, false))
    }
    override fun onBindViewHolder(holder: RDVHolder, position: Int) {
        holder.datetime.text = data[position].date+" At "+data[position].heure
        holder.doctorName.text ="Dr."+data[position].nom
        holder.itemCardView.setOnClickListener{
            val qrCodeView= QrCodeFragment()
            val idRDV=data[position].idRDV
            val args = bundleOf("idRDV" to idRDV)
            qrCodeView.arguments=args
            qrCodeView.show(fragmentManager, "bottom_sheet_qrcode")
        }
    }
    override fun getItemCount()=data.size
}
class RDVHolder(view: View) : RecyclerView.ViewHolder(view) {
    val itemCardView=view.findViewById<CardView>(R.id.global_card_item)
    val datetime = view.findViewById<TextView>(R.id.date_time_rdv)
    val doctorName = view.findViewById<TextView>(R.id.doctor_name_rdv)
}