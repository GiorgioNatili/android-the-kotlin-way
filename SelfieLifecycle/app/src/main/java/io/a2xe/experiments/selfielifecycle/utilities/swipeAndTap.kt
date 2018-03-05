package io.a2xe.experiments.selfielifecycle.utilities

import android.view.View
import io.a2xe.experiments.selfielifecycle.services.OnSwipeTouchListener

/**
 * Created by giorgio on 3/3/18.
 */
fun View.swipeOrTap(swipe: () -> Unit, tap: () -> Unit) {

    this.setOnTouchListener( object : OnSwipeTouchListener(context) {

        override fun onSwipeLeft() {
            super.onSwipeLeft()
            swipe()
        }

        override fun onTap() {
            super.onTap()
            tap()
        }
    })
}