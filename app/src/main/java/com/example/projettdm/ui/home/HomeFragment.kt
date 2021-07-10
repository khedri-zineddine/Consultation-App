package com.example.projettdm.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projettdm.R
import com.example.projettdm.actions.DoctorActions
import com.example.projettdm.adapters.ListMedecinAdapter
import com.example.projettdm.requests.doctors.DoctorItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchDoctorsTab("My")
        tab_medecintype.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                loadingList?.setVisibility(View.VISIBLE)
                listeMedecin?.setVisibility(View.GONE)
                var tabSelected = "My"
                if(tab.position==1){
                    tabSelected = "all"
                }
                fetchDoctorsTab(tabSelected)
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

    }
    private fun fetchDoctorsTab(pathFetch:String) {
        DoctorActions.fetchDoctors(pathFetch){status, response ->
            loadingList?.setVisibility(View.GONE)
            if(status){
                listeMedecin?.setVisibility(View.VISIBLE)
                val dataList=response as List<DoctorItem>
                listeMedecin.layoutManager = LinearLayoutManager(context)
                listeMedecin.adapter = ListMedecinAdapter(requireContext(),dataList,pathFetch)
            }
        }
    }
}