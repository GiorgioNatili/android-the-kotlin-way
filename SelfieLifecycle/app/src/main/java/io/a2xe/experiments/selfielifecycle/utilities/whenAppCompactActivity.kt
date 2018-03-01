package io.a2xe.experiments.selfielifecycle.utilities

import android.app.Activity
import android.support.v7.app.AppCompatActivity

/**
 * Created by giorgio on 2/26/18.
 */
fun Activity.whenAppCompactActivity (callback: (compactActivity: AppCompatActivity) -> Unit) {
    this?.let {
        when (it) {
            is AppCompatActivity -> it
            else -> null
        }?.let {
            callback(it)
        }
    }
}