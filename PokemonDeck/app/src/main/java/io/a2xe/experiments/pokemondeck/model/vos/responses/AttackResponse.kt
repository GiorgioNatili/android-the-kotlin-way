package io.a2xe.experiments.pokemondeck.model.vos.responses

import com.google.gson.annotations.SerializedName

class AttackResponse {

    @SerializedName("cost")
    var cost: List<String>? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("text")
    var text: String? = null

    @SerializedName("damage")
    var damage: String? = null

    @SerializedName("convertedEnergyCost")
    var convertedEnergyCost: Int? = null
}