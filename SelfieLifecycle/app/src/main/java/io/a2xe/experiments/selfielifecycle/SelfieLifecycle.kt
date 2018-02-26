package io.a2xe.experiments.selfielifecycle

import android.app.Application

/**
 * Created by giorgio on 2/25/18.
 */
class SelfieLifecycle : Application() {

    override fun onCreate() {
        super.onCreate()
        println("Creating an app")
    }
}