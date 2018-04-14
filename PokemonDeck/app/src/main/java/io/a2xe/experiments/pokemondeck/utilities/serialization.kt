package io.a2xe.experiments.pokemondeck.utilities

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by giorgio on 4/8/18.
 */

fun <T> List<T>.toJsonString() : String = Gson().toJson(this)
fun <T:Any> String.fromJsonString(dataType: Class<T>) : List<T> = listOf(
        Gson().fromJson<T>(this, dataType::class.java)
)
fun <T:Any> String.fromJsonToListOfAnything(collectionType: TypeToken<List<T>>): List<T> {
    return Gson().fromJson<List<T>>(this, collectionType.type)
}