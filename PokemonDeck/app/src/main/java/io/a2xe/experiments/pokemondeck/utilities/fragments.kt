package io.a2xe.experiments.pokemondeck.utilities

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

/**
 * Created by giorgio on 4/7/18.
 */

inline fun FragmentManager.handleTransaction(callback: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().callback().commit()
}

fun AppCompatActivity.addFragment(fragment: Fragment, target: Int){
    supportFragmentManager.handleTransaction { add(target, fragment) }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, target: Int) {
    supportFragmentManager.handleTransaction { replace(target, fragment) }
}

inline fun <reified T : Fragment>Fragment.waitUntilCreated(crossinline callback: (T) -> Unit) {
    val activationObject: LifecycleOwner = this
    object : LifecycleObserver {
        init {
            activationObject.lifecycle.addObserver(this)
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onCreate() {

            check(activationObject is T) {
                "The activation object and the generic type differs."
            }
            callback(activationObject as T)
        }
    }
}
