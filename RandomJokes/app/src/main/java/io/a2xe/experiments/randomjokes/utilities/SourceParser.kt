package io.a2xe.experiments.randomjokes.utilities

import android.content.Context
import java.io.BufferedReader
import java.io.InputStream

/**
 * Created by giorgio on 12/15/17.
 */
class SourceParser(private val context: Context) {

    fun readFile(byId: Int): String {

        val resources = context.resources
        val inputStream: InputStream = resources.openRawResource(byId)

        return inputStream.bufferedReader().use(BufferedReader::readText)
    }
}