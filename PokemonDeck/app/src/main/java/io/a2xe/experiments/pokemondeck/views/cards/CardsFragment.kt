package io.a2xe.experiments.pokemondeck.views.cards

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.a2xe.experiments.pokemondeck.R
import io.a2xe.experiments.pokemondeck.model.entities.Card
import io.a2xe.experiments.pokemondeck.model.repositories.CardsRepository
import io.a2xe.experiments.pokemondeck.model.repositories.PokemonCardsRepository
import io.a2xe.experiments.pokemondeck.services.PokemonCardsService
import io.a2xe.experiments.pokemondeck.views.cards.adapter.CardsAdapter
import io.a2xe.experiments.pokemondeck.views.cards.adapter.ItemOffsetDecoration
import kotlinx.android.synthetic.main.fragment_cards.*

class CardsFragment : Fragment() {

    lateinit var pockemonCards: CardsRepository
    lateinit var cardsAdapter: CardsAdapter

    private val gridLayoutManager: GridLayoutManager by lazy {
        GridLayoutManager(activity, 3)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        pockemonCards = PokemonCardsRepository(PokemonCardsService.create())
        pockemonCards.searchCardsSet("sm5") {

            cardsAdapter = CardsAdapter(activity, it, ::fetchCardDetails)
            cards_list.adapter = cardsAdapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

        cards_list.layoutManager = gridLayoutManager
        cards_list.addItemDecoration(ItemOffsetDecoration(10))
    }

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.fragment_cards, container, false)
    }

    private fun fetchCardDetails(card: Card) {

        pockemonCards.getCardsDetails(card.id) {

            println(it)
        }
    }
}
