package io.a2xe.experiments.pokemondeck.model.vos.responses

import com.google.gson.annotations.SerializedName

/**
 * Created by giorgio on 4/14/18.
 */
class CardResponse {

    @SerializedName("id")
    var id: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("nationalPokedexNumber")
    var nationalPokedexNumber: Int? = null

    @SerializedName("hp")
    var hp: String? = null

    @SerializedName("imageUrl")
    var imageUrl: String? = null

    @SerializedName("imageUrlHiRes")
    var imageUrlHiRes: String? = null

    @SerializedName("types")
    var types: List<String>? = null

    @SerializedName("number")
    var number: String? = null

    @SerializedName("subtype")
    var subtype: String? = null

    @SerializedName("supertype")
    var supertype: String? = null

    @SerializedName("attacks")
    var attacks: List<AttackResponse>? = null

    @SerializedName("text")
    var text: List<Any>? = null

    @SerializedName("weaknesses")
    var weaknesses: List<WeaknessResponse>? = null

    @SerializedName("resistances")
    var resistances: List<ResistanceResponse>? = null

    @SerializedName("retreatCost")
    var retreatCost: List<String>? = null

    @SerializedName("convertedRetreatCost")
    var convertedRetreatCost: Int? = null

    @SerializedName("artist")
    var artist: String? = null

    @SerializedName("set")
    var set: String? = null

    @SerializedName("setCode")
    var setCode: String? = null

    @SerializedName("rarity")
    var rarity: String? = null
}
