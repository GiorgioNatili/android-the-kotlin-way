package io.a2xe.experiments.pokemondeck.model.vos.responses

import com.google.gson.annotations.SerializedName

class WeaknessResponse {

    @SerializedName("type")
    var type: String? = null

    @SerializedName("value")
    var value: String? = null
}