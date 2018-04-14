package io.a2xe.experiments.pokemondeck.model.vos

import com.google.gson.annotations.SerializedName
import io.a2xe.experiments.pokemondeck.model.vos.responses.CardResponse

/**
 * Created by giorgio on 4/14/18.
 */
class CardDetailsResult {

    @SerializedName("card")
    lateinit var card: CardResponse
}