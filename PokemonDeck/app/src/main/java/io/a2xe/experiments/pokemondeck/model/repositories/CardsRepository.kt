package io.a2xe.experiments.pokemondeck.model.repositories

import io.a2xe.experiments.pokemondeck.model.entities.Card

/**
 * Created by giorgio on 4/12/18.
 */
interface CardsRepository {

    fun searchCardsSet(id: String, callback: ((cardSet: List<Card>) -> Unit))
    fun getCardsDetails(id: String, callback: ((card: Card) -> Unit))
}