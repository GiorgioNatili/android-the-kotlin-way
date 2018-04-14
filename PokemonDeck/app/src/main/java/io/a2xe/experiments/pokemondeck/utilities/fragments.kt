package io.a2xe.experiments.pokemondeck.utilities

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
