package io.a2xe.experiments.pokemondeck.model.repositories

import io.a2xe.experiments.pokemondeck.model.entities.Deck

/**
 * Created by giorgio on 4/8/18.
 */
interface DecksRepository {

    fun save(decks: List<Deck>, callback: (() -> Unit)? = null)
    var items: List<Deck>
}