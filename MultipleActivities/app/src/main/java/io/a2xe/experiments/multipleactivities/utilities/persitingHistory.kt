package io.a2xe.experiments.multipleactivities.utilities

import android.content.Context
import android.preference.PreferenceManager
import io.a2xe.experiments.multipleactivities.model.WebSite

/**
 * Created by giorgio on 1/25/18.
 */
fun Context.saveURLs (collection: ArrayList<WebSite>) {

    collection.sortedWith(compareBy({ it.timestamp }))

    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
    val editor = sharedPreferences.edit()

    for (i in 0 until collection.size) {
        editor.remove(collection[i].title)
        editor.putString(collection[i].title, collection[i].url)
    }

    editor.apply()
}

fun Context.readURLs(): ArrayList<WebSite> {

    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
    val allEntries = sharedPreferences.all

    val urls = arrayListOf<WebSite>()
    allEntries.entries.mapTo(urls) { WebSite(it.key, it.value.toString()) }

    return urls
}

fun <T>Context.waitForPreferencesToBeUpdated(callback: () -> T) {
    val preferences = PreferenceManager.getDefaultSharedPreferences(this)
    preferences.registerOnSharedPreferenceChangeListener { _, _ ->
        run {
            callback()
        }
    }
}