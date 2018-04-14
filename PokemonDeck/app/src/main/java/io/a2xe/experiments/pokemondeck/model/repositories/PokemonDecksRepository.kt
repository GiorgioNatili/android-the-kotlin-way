package io.a2xe.experiments.pokemondeck.model.repositories

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.google.gson.reflect.TypeToken
import io.a2xe.experiments.pokemondeck.model.entities.Deck
import io.a2xe.experiments.pokemondeck.utilities.fromJsonToListOfAnything
import io.a2xe.experiments.pokemondeck.utilities.toJsonString

/**
 * Created by giorgio on 4/8/18.
 */
class PokemonDecksRepository(context: Context) : DecksRepository {

    // This is the saved DeckDTO list json string key in shared preferences file
    private val SHARED_PREFERENCES_KEY_DECKS_LIST = "KEY_DECKS_LIST"
    private val FILE_KEY_DECKS_LIST = "keyDecksList"

    // Create SharedPreferences object
    private val sharedPreferences = context.getSharedPreferences(FILE_KEY_DECKS_LIST, MODE_PRIVATE)

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