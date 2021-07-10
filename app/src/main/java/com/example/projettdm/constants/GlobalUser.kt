package com.example.projettdm.constants

import android.app.Application
import com.example.projettdm.requests.user.userResponseBody

public class GlobalUser : Application() {
    companion object {
        lateinit var user: userResponseBody
    }
}