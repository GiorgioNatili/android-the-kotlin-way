package io.a2xe.experiments.pokemondeck.views.cards

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.a2xe.experiments.pokemondeck.R
import io.a2xe.experiments.pokemondeck.model.repositories.PokemonCardsRepository
import io.a2xe.experiments.pokemondeck.services.PokemonCardsService

class CardsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("onCreate CardsFragment")

        val service = PokemonCardsService.create()

        val pokemonCards = PokemonCardsRepository(service)
        pokemonCards.searchCardsSet("sm5") {
            println(it)
        }
        // repo.getCardsDetails("sm5-4")
    }

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        println("onCreateView, Inflate the layout for CardsFragment")
        return inflater?.inflate(R.layout.fragment_cards, container, false)
    }
}
