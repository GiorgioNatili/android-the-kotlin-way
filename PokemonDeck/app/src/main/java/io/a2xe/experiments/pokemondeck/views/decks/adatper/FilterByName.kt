package io.a2xe.experiments.pokemondeck.views.decks.adatper

import android.widget.Filter
import io.a2xe.experiments.pokemondeck.model.entities.Deck


/**
 * Created by giorgio on 4/19/18.
 */
class FilterByName(private val adapter: DecksAdapter,
                   private val dataset: List<Deck>) : Filter (){

    override fun performFiltering(constraint: CharSequence?): FilterResults {
        val results = Filter.FilterResults()

        val searchText = constraint.toString().toLowerCase()
        val newList = dataset.filter { it.name.toLowerCase().contains(searchText) }

        results.values = newList
        results.count = newList.size

        return results
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

        results?.values.let {
            adapter.decks = it as List<Deck>
            adapter.notifyDataSetChanged()
        }
    }
}