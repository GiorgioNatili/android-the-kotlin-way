package io.a2xe.experiments.selfielifecycle.services

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import io.a2xe.experiments.selfielifecycle.utilities.whenNotNullObjects

/**
 * Created by giorgio on 3/4/18.
 */
open class OnSwipeTouchListener (context: Context): View.OnTouchListener {
    
    companion object {
        const val swipeThreshold = 100
        const val velocityThreshold = 100
    }

    init {
        println(context)
    }

    private val gestureDetector: GestureDetector = GestureDetector(context, GestureListener())
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(event)
    }

    inner class GestureListener : GestureDetector.SimpleOnGestureListener()  {

        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            onTap()
            return super.onSingleTapUp(e)
        }

        override fun onFling(e1: MotionEvent?, e2: MotionEvent?,
                             velocityX: Float, velocityY: Float): Boolean {

            whenNotNullObjects(e1, e2) {

                val diffY = e2!!.y - e1!!.y
                val diffX = e2.x - e1.x

                when(Math.abs(diffX) > swipeThreshold && Math.abs(velocityX) > velocityThreshold) {
                    true ->  if (diffX > 0) onSwipeRight() else onSwipeLeft()
                    false -> if (diffY > 0) onSwipeDown() else onSwipeUp()
                }
            }

            return false
        }

        override fun onDown(e: MotionEvent):Boolean {
            return true
        }
    }

    open fun onTap() {
    }

    open fun onSwipeRight() {
    }

    open fun onSwipeLeft() {
    }

    open fun onSwipeUp() {
    }

    open fun onSwipeDown() {
    }
}