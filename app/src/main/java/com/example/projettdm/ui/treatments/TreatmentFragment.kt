package com.example.projettdm.ui.treatments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projettdm.R
import com.example.projettdm.actions.TreatementActions
import com.example.projettdm.adapters.TraitmentAdapter
import com.example.projettdm.requests.treatment.TreatmentItem
import kotlinx.android.synthetic.main.fragment_treatment.*
import kotlinx.android.synthetic.main.fragment_treatment.loadingList

class TreatmentFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_treatment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TreatementActions.fetchTreatements{status, response ->
            loadingList?.setVisibility(View.GONE)
            if(status){
                val listTreatment = response as List<TreatmentItem>
                list_traitement.layoutManager = LinearLayoutManager(context)
                list_traitement.adapter = TraitmentAdapter(requireContext(),listTreatment)
            }
        }
    }
}