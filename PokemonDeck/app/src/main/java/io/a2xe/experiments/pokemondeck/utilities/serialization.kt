package io.a2xe.experiments.pokemondeck.utilities

import com.google.gson.Gson



/**
 * Created by giorgio on 4/8/18.
 */

fun <T> List<T>.toJsonString() : String = Gson().toJson(this)
inline fun <reified T:Any> String.fromJsonString(dataType: Class<T>) : List<T> = listOf(
        Gson().fromJson<T>(this, dataType::class.java)
)

