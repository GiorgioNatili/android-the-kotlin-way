package io.a2xe.experiments.loginandbrowse.utilities

import android.content.SharedPreferences
import android.view.View
import io.a2xe.experiments.loginandbrowse.AUTHENTICATION_PROVIDER

var SharedPreferences.authenticationProvider: String
    get() = getString(AUTHENTICATION_PROVIDER, "").orEmpty()
    set(value){
        val editor = edit()
        editor.putString(AUTHENTICATION_PROVIDER, value)
        editor.apply()
    }