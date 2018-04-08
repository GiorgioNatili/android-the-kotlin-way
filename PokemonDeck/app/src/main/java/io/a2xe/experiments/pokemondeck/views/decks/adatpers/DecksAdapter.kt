package io.a2xe.experiments.pokemondeck.views.decks.adatpers

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import io.a2xe.experiments.pokemondeck.R
import io.a2xe.experiments.pokemondeck.model.vos.Deck


/**
 * Created by giorgio on 4/7/18.
 */
class DecksAdapter(private val activity: Activity,
                   private val decks: Array<Deck>) : ArrayAdapter<Deck>(activity, 0, decks) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        val view: View?
        val viewHolder: DeckItemRenderer

        if (convertView == null) {
            view = activity.layoutInflater.inflate(R.layout.deck_item_renderer, parent, false)
            viewHolder = DeckItemRenderer(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as DeckItemRenderer
        }

        viewHolder.deckName.text = decks[position].name
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