package io.a2xe.experiments.randomjokes

import android.content.Context

/**
 * Created by giorgio on 12/15/17.
 */
class JokesProvider(private val context: Context) {

    fun getRandomJoke(): String {
        val jokes = context.resources.getStringArray(R.array.jokes_list)
        val random = Math.floor(Math.random() * jokes.size - 1).toInt()

        return jokes[random]
    }
}