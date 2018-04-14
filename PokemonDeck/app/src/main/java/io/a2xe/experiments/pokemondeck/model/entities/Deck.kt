package io.a2xe.experiments.pokemondeck.model.entities

/**
 * Created by giorgio on 4/7/18.
 */
data class Deck (val name: String,
                 val cards: List<Card> = listOf()) {

    val id: Int = Math.floor(Math.random() * 100000).toInt()

    val totalCards: Int
        get() = this.cards.size
}