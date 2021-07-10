package com.example.projettdm

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.projettdm.actions.UserActions
import com.example.projettdm.constants.GlobalUser
import com.example.projettdm.constants.constants
import com.example.projettdm.requests.user.userResponseBody
import com.example.projettdm.services.retroufitServices

class LoadingApp : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_loading_app, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferences = context?.getSharedPreferences(constants.PREFS_NAME, Context.MODE_PRIVATE)
        var token=sharedPreferences?.getString(constants.PREFS_TOKEN,null)
        if(token==null){
            findNavController().navigate(R.id.action_loadingApp_to_loginFragment)
        }else{
            UserActions.fetchUser(){status, response ->
                if(!status){
                    findNavController().navigate(R.id.action_loadingApp_to_loginFragment)
                }else{
                    val intent = Intent(activity, PrivateActivity::class.java)
                    startActivity(intent)
                    GlobalUser.user=response as userResponseBody
                    GlobalUser.user.token=token
                    activity?.finish()
                }
            }
        }
    }
}