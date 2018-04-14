package io.a2xe.experiments.pokemondeck.transformers

import io.a2xe.experiments.pokemondeck.model.entities.Card
import io.a2xe.experiments.pokemondeck.model.vos.CardDetailsResult

/**
 * Created by giorgio on 4/14/18.
 */
fun CardDetailsResult.toSimplifiedCard(): Card {
    return Card (this.card.id ?: "", this.card.name ?: "", this.card.imageUrl ?: "")
}