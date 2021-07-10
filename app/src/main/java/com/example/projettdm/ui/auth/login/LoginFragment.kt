package com.example.projettdm.ui.auth.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.projettdm.PrivateActivity
import com.example.projettdm.R
import com.example.projettdm.actions.AuthActions
import com.example.projettdm.constants.GlobalUser
import com.example.projettdm.constants.constants
import com.example.projettdm.requests.auth.authRequestBody
import com.example.projettdm.requests.auth.authResponseBody
import com.example.projettdm.services.retroufitServices
import kotlinx.android.synthetic.main.fragment_login.*
import okhttp3.Interceptor


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submit_rnd.setOnClickListener{
            val username=username.text.toString()
            val password=password.text.toString()
            AuthActions.login(authRequestBody(username,password)){status, response ->
                if(status){
                    val responseBody=response as authResponseBody
                    val sharedPreferences = context?.getSharedPreferences(constants.PREFS_NAME, Context.MODE_PRIVATE)
                    sharedPreferences?.edit()
                        ?.putString(constants.PREFS_TOKEN, responseBody.token)
                        ?.apply();
                    val intent = Intent(activity, PrivateActivity::class.java)
                    startActivity(intent)
                    GlobalUser.user=responseBody.user
                    activity?.finish()
                }else{
                    val responseBody=response as String
                    Toast.makeText(context,responseBody,Toast.LENGTH_LONG).show()
                }
            }
        }

    }

}