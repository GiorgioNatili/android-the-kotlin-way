package io.a2xe.experiments.selfielifecycle.utilities

import android.app.Activity

/**
 * Created by giorgio on 2/26/18.
 */
fun Activity.noop() {
    println("${this::javaClass.name}, noting implemented here")
}