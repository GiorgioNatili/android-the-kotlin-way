package io.a2xe.experiments.pokemondeck.model.repositories

import io.a2xe.experiments.pokemondeck.model.vos.Deck

/**
 * Created by giorgio on 4/8/18.
 */
interface DecksRepository {

    fun save(decks: List<Deck>)
    fun load(): List<Deck>
}