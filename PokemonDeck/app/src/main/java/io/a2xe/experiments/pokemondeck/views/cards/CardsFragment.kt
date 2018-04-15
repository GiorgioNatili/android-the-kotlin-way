package io.a2xe.experiments.pokemondeck.views.cards

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.a2xe.experiments.pokemondeck.R
import io.a2xe.experiments.pokemondeck.model.repositories.CardsRepository
import io.a2xe.experiments.pokemondeck.model.repositories.PokemonCardsRepository
import io.a2xe.experiments.pokemondeck.services.PokemonCardsService
import io.a2xe.experiments.pokemondeck.views.cards.adapter.CardsAdapter
import io.a2xe.experiments.pokemondeck.views.cards.adapter.ItemOffsetDecoration
import kotlinx.android.synthetic.main.fragment_cards.*

class CardsFragment : Fragment() {

    lateinit var cards: CardsRepository
    lateinit var cardsAdapter: CardsAdapter
    lateinit var gridLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val service = PokemonCardsService.create()
        cards = PokemonCardsRepository(service)

        cards.searchCardsSet("sm5") {

            cardsAdapter=  CardsAdapter(activity, it)
            cards_list.adapter = cardsAdapter
        }
        // repo.getCardsDetails("sm5-4")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

        gridLayoutManager = GridLayoutManager(activity, 3)
        cards_list.layoutManager = gridLayoutManager

        cards_list.addItemDecoration(ItemOffsetDecoration(10))
    }

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        println("onCreateView, Inflate the layout for CardsFragment")
        return inflater?.inflate(R.layout.fragment_cards, container, false)
    }
}
