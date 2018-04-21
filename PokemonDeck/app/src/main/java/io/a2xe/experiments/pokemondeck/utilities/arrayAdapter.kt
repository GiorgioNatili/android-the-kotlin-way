package io.a2xe.experiments.pokemondeck.utilities

import android.widget.ArrayAdapter

/**
 * Created by giorgio on 4/18/18.
 */

fun <T> ArrayAdapter<T>.refreshItems(items: Collection<T>) {

    val addAll: (Collection<T>) -> Unit = ::addAll

    clear()
    addAll(items)
}

fun <T> ArrayAdapter<T>.getItems(): MutableCollection<T> {

    val items = mutableListOf<T>()
    for (index in 0 until this.count) {
        items.add(this.getItem(index))
    }

    return items
}