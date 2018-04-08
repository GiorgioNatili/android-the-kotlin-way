package io.a2xe.experiments.pokemondeck.model.vos

/**
 * Created by giorgio on 4/7/18.
 */
data class Deck (val name: String,
                 val cards: Array<Card> = emptyArray()) {

    val id: Int = Math.floor(Math.random() * 100000).toInt()
}