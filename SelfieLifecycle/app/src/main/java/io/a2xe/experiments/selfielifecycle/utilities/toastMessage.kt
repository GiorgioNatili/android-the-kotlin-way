package io.a2xe.experiments.selfielifecycle.utilities

import android.content.Context
import android.widget.Toast

/**
 * Created by giorgio on 3/1/18.
 */
fun Any.toast(context: Context) {

    val duration = when(this.toString().length) {
        0, 20 -> Toast.LENGTH_SHORT
        else -> Toast.LENGTH_LONG
    }

    Toast.makeText(context, this.toString(), duration).show()
}