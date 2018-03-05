package io.a2xe.experiments.selfielifecycle.utilities

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat

/**
 * Created by giorgio on 3/4/18.
 */
fun Activity.setupPermissions(permission: String, requestCode: Int, callback: () -> Unit) {

    val allowed = this.applicationContext.checkSelfPermission(permission)

    when(allowed == PackageManager.PERMISSION_GRANTED) {
        true -> callback()
        else -> ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
    }
}