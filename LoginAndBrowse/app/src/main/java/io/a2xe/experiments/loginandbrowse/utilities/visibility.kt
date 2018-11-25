package io.a2xe.experiments.loginandbrowse.utilities

import android.view.View

var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(visible){
        visibility = if(visible) View.VISIBLE else View.GONE
    }
