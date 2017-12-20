package io.a2xe.experiments.activitylifecycle

import android.content.Context
import android.widget.Toast

/**
 * Created by giorgio on 12/20/17.
 */
fun Any.toast(context: Context) {
    Toast.makeText(context, this.toString(), Toast.LENGTH_SHORT).show()
}
