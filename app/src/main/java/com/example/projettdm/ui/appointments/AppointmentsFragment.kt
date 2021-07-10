package com.example.projettdm.ui.appointments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projettdm.R
import com.example.projettdm.actions.RDVActions
import com.example.projettdm.adapters.RDVAddapter
import com.example.projettdm.requests.rdv.RDVItem
import kotlinx.android.synthetic.main.fragment_appointments.*
import kotlinx.android.synthetic.main.fragment_appointments.loadingList

class AppointmentsFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_appointments, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RDVActions.fetchRDV{status, response ->
            loadingList?.setVisibility(View.GONE)
            if(status){
                val fragmentManager = (activity as FragmentActivity).supportFragmentManager
                val dataList=response as List<RDVItem>
                list_rdv_encours.layoutManager = GridLayoutManager(context,2)
                list_rdv_encours.adapter = RDVAddapter(requireContext(),dataList,fragmentManager)
            }
        }
    }
}