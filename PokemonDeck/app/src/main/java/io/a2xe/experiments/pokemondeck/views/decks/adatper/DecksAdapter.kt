package io.a2xe.experiments.pokemondeck.views.decks.adatper

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import io.a2xe.experiments.pokemondeck.R
import io.a2xe.experiments.pokemondeck.model.entities.Deck


/**
 * Created by giorgio on 4/7/18.
 */
class DecksAdapter(private val activity: Activity,
                   var decks: List<Deck>) : ArrayAdapter<Deck>(activity, 0, decks) {

    val filter = FilterByName(this, decks)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view = when(convertView == null) {
            true -> activity.layoutInflater.inflate(R.layout.deck_item_renderer, parent, false)
            else -> convertView!!
        }

        val viewHolder = when(view.tag != null) {
            true -> view.tag as DeckItemRenderer
            else -> DeckItemRenderer(view)
        }

        view.tag = viewHolder

        viewHolder.deckName.text = decks[position].name
        viewHolder.totalCards.text = decks[position].totalCards.toString()

        return view
    }

    override fun getItem(position: Int): Deck {
        return decks[position]
    }

    override fun getItemId(position: Int): Long {
        return decks[position].id.toLong()
    }

    override fun getCount(): Int {
        return decks.size
    }
}