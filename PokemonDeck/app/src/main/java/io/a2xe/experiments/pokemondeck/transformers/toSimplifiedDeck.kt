package io.a2xe.experiments.pokemondeck.transformers

import io.a2xe.experiments.pokemondeck.model.entities.Card
import io.a2xe.experiments.pokemondeck.model.vos.CardsSetResult

/**
 * Created by giorgio on 4/14/18.
 */
fun CardsSetResult.toSimplifiedCardSet(): List<Card> {
    return this.cards.map { Card (it.id ?: "", it.name ?: "", it.imageUrl ?: "") }
}