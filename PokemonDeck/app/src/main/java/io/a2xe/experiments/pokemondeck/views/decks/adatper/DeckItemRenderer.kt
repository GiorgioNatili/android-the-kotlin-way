package io.a2xe.experiments.pokemondeck.views.decks.adatper

import android.view.View
import android.widget.TextView
import io.a2xe.experiments.pokemondeck.R

/**
 * Created by giorgio on 4/7/18.
 */
class DeckItemRenderer (view: View?) {
    val deckName: TextView = view?.findViewById(R.id.deck_name) as TextView
    val totalCards: TextView = view?.findViewById(R.id.total_cards) as TextView
}




