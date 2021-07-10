package com.example.projettdm.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.projettdm.R
import com.example.projettdm.requests.treatment.MedicamentItem

class TableTraitementDetail(val context: Context, var listTable:List<MedicamentItem>): RecyclerView.Adapter<TableTreatHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableTreatHolder {
        return TableTreatHolder(LayoutInflater.from(context).inflate(R.layout.row_item_table, parent, false))
    }
    override fun onBindViewHolder(holder: TableTreatHolder, position: Int) {
        val medicament=listTable[position]
        holder.medicamentName.text=medicament.NameMedicament
        holder.timeUse.text=medicament.timeUse
        holder.qauntity.text=medicament.Qauntity
    }
    override fun getItemCount()=listTable.size
}
class TableTreatHolder(view: View) : RecyclerView.ViewHolder(view) {
    val medicamentName=view.findViewById<TextView>(R.id.medicamentName)
    val timeUse=view.findViewById<TextView>(R.id.timeUse)
    val qauntity=view.findViewById<TextView>(R.id.qauntity)
}