package io.a2xe.experiments.pokemondeck.utilities

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.a2xe.experiments.pokemondeck.model.vos.Deck

/**
 * Created by giorgio on 4/8/18.
 */

fun <T> List<T>.toJsonString() : String = Gson().toJson(this)
inline fun <reified T:Any> String.fromJsonString(dataType: Class<T>) : List<T> = listOf(
        Gson().fromJson<T>(this, dataType::class.java)
)

fun String.fromJsonToListOfDecks(): List<Deck> {

    val collectionType = object : TypeToken<List<Deck>>(){}.type
    return Gson().fromJson<List<Deck>>(this, collectionType)
}

fun <T:Any> String.fromJsonToListOfAnything(collectionType: TypeToken<List<T>>): List<T> {
    return Gson().fromJson<List<T>>(this, collectionType.type)
}
