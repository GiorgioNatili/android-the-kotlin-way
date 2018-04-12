package io.a2xe.experiments.pokemondeck.model.repositories

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.preference.PreferenceManager
import com.google.gson.reflect.TypeToken
import io.a2xe.experiments.pokemondeck.model.vos.Deck
import io.a2xe.experiments.pokemondeck.utilities.fromJsonToListOfAnything
import io.a2xe.experiments.pokemondeck.utilities.toJsonString

/**
 * Created by giorgio on 4/8/18.
 */

// This is the saved UserInfoDTO list json string key in sharedpreferences file..
const val SHARED_PREFERENCES_KEY_DECKS_LIST = "KEY_DECKS_LIST"
const val FILE_KEY_DECKS_LIST = "keyDecksList"

class LocalDecksRepository(context: Context) : DecksRepository {

    // Create SharedPreferences object
    val sharedPreferences = context.getSharedPreferences(FILE_KEY_DECKS_LIST, MODE_PRIVATE)

    override fun save(decks: List<Deck>, callback: (() -> Unit)?) {

        sharedPreferences.registerOnSharedPreferenceChangeListener { _, _ ->
            callback?.invoke()
        }

        // Put the json format string to SharedPreferences object
        sharedPreferences.edit().apply {
            putString(SHARED_PREFERENCES_KEY_DECKS_LIST, decks.toJsonString())
            apply()
        }
    }

    override var items: List<Deck> = listOf()
        get() {

            val json = sharedPreferences.getString(SHARED_PREFERENCES_KEY_DECKS_LIST, "[]")

            val collectionType = object : TypeToken<List<Deck>>(){}
            return json.fromJsonToListOfAnything(collectionType)
    }
}