package io.a2xe.experiments.pokemondeck.model.vos

import com.google.gson.annotations.SerializedName
import io.a2xe.experiments.pokemondeck.model.vos.responses.CardResponse

/**
 * Created by giorgio on 4/13/18.
 */
class CardsSetResult {

    @SerializedName("cards")
    lateinit var cards: List<CardResponse>
}