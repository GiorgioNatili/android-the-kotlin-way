package io.a2xe.experiments.pokemondeck.services

import io.a2xe.experiments.pokemondeck.model.vos.CardDetailsResult
import io.a2xe.experiments.pokemondeck.model.vos.CardsSetResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by giorgio on 4/12/18.
 */

interface PokemonCardsService {

    @GET("cards")
    fun searchCardsSet(@Query("setCode") cardsSetId: String): Call<CardsSetResult>

    @GET("cards/{id}")
    fun searchCard(@Path("id") cardId: String): Call<CardDetailsResult>


    /**
     * Factory class for convenient creation of the Api Service interface
     */
    companion object {

        fun create(): PokemonCardsService {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.pokemontcg.io/v1/")
                    .build()

            return retrofit.create(PokemonCardsService::class.java)
        }
    }
}
