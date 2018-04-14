package io.a2xe.experiments.pokemondeck.views.decks

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import io.a2xe.experiments.pokemondeck.R
import io.a2xe.experiments.pokemondeck.model.repositories.DecksRepository
import io.a2xe.experiments.pokemondeck.model.repositories.PokemonDecksRepository
import io.a2xe.experiments.pokemondeck.model.entities.Deck
import io.a2xe.experiments.pokemondeck.views.decks.adatpers.DecksAdapter
import kotlinx.android.synthetic.main.fragment_decks.*

class DecksFragment : Fragment() {

    lateinit var decks: DecksRepository
    lateinit var decksListAdapter: DecksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        decks = PokemonDecksRepository(this.context)
        decksListAdapter = DecksAdapter(this.activity, decks.items)
    }

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.fragment_decks, container, false)
    }

    override fun onStart() {
        super.onStart()

        add_deck.setOnClickListener {

            val deckName = EditText(this.activity)
            deckName.hint = getString(R.string.new_deck_hint)

            AlertDialog.Builder(this.activity)
                    .setTitle(getString(R.string.new_deck_title))
                    .setMessage(getString(R.string.new_deck_message))
                    .setView(deckName)
                    .setPositiveButton(getString(R.string.new_deck_ok), { _, _ ->

                        decks.items.toMutableList().let {

                            it.add(Deck(deckName.text.toString()))
                            decks.save(it) {

                                refreshListOfDecks(it)
                            }
                        }
                    })
                    .setNegativeButton(getString(R.string.new_deck_cancel), { _, _ -> })
                    .show()
        }

        list_of_decks.adapter = decksListAdapter
    }

    private fun refreshListOfDecks(decks: MutableList<Deck>) {

        decksListAdapter.clear()
        decksListAdapter.addAll(decks)
        decksListAdapter.notifyDataSetChanged()
    }
}
