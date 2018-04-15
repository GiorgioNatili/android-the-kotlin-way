package io.a2xe.experiments.pokemondeck.model.repositories

import io.a2xe.experiments.pokemondeck.model.entities.Card
import io.a2xe.experiments.pokemondeck.model.vos.CardDetailsResult
import io.a2xe.experiments.pokemondeck.model.vos.CardsSetResult
import io.a2xe.experiments.pokemondeck.services.PokemonCardsService
import io.a2xe.experiments.pokemondeck.transformers.toSimplifiedCard
import io.a2xe.experiments.pokemondeck.transformers.toSimplifiedCardSet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by giorgio on 4/13/18.
 */
class PokemonCardsRepository(private val cardsService: PokemonCardsService) : CardsRepository {

    override fun searchCardsSet(id: String, callback: (cardSet: List<Card>) -> Unit) {

        val call = cardsService.searchCardsSet(id)
        call.enqueue(object : Callback<CardsSetResult> {
            override fun onResponse(call: Call<CardsSetResult>, response: Response<CardsSetResult>) {

                response.body().let {
                    (it as CardsSetResult).let { callback.invoke(it.toSimplifiedCardSet()) }
                }
            }

            override fun onFailure(call: Call<CardsSetResult>, error: Throwable) {
                // Log error here since request failed
                println(error.message)
            }
        })
    }

    override fun getCardsDetails(id: String, callback: (cardSet: Card) -> Unit) {
        val call = cardsService.searchCard(id)
        call.enqueue(object : Callback<CardDetailsResult> {
            override fun onResponse(call: Call<CardDetailsResult>, response: Response<CardDetailsResult>) {

                response.body().let {
                    (it as CardDetailsResult).let { callback.invoke(it.toSimplifiedCard()) }
                }
            }

            override fun onFailure(call: Call<CardDetailsResult>, error: Throwable) {
                // Log error here since request failed
                println(error.message)
            }
        })
    }
}