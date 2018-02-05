package io.a2xe.experiments.multipleactivities.utilities

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle

/**
 * Created by giorgio on 1/22/18.
 */

inline fun <reified T> Context.launchActivity(
        options: Bundle? = null,
        noinline init: Intent.() -> Unit = {}) {

    val intent = newIntent<T>(this)
    intent.init()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        startActivity(intent, options)
    } else {
        startActivity(intent)
    }
}

inline fun <reified T> newIntent(context: Context): Intent = Intent(context, T::class.java)

