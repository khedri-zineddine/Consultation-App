package com.example.projettdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.projettdm.constants.GlobalUser
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_private.*

class PrivateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_private)
        val navView: BottomNavigationView =findViewById(R.id.nav_view_private)
        val navController = findNavController(R.id.nav_host_fragment_private)
        navView.setupWithNavController(navController)
        title_app.text="Good morning , "+GlobalUser.user.prenom
    }
}