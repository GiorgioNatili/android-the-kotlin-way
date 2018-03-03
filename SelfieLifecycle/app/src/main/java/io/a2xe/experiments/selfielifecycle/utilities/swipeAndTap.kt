package io.a2xe.experiments.selfielifecycle.utilities

import android.view.MotionEvent
import android.view.View
import com.jakewharton.rxbinding2.view.RxView

/**
 * Created by giorgio on 3/3/18.
 */
fun View.swipeOrTap(swipe: () -> Unit, tap: () -> Unit) {

    var isMoving = false

    RxView.touches(this)
            .subscribe {
                when (it.action) {
                    MotionEvent.ACTION_MOVE -> {
                        swipe()
                        isMoving = true
                    }
                    MotionEvent.ACTION_UP -> {
                        if (!isMoving) {
                            tap()
                        }
                        isMoving = false
                    }
                }
            }
}