package io.a2xe.experiments.simplifyandroiddevelopment

import android.content.Context
import android.widget.Toast

fun Any.toast (context: Context) {
    val duration = when(this.toString().length) {
        0, 20 -> Toast.LENGTH_SHORT
        else -> Toast.LENGTH_LONG
    }
    Toast.makeText(context, this.toString(), duration).show()
}