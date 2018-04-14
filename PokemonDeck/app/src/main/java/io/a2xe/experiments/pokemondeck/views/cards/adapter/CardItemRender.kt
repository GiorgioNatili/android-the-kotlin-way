package io.a2xe.experiments.pokemondeck.views.cards.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import io.a2xe.experiments.pokemondeck.R

/**
 * Created by giorgio on 4/14/18.
 */
internal class CardItemRender(view:View,
                     private val itemClick: (Any) -> Unit) : RecyclerView.ViewHolder(view) {

    val cardName: TextView = view.findViewById(R.id.card_name) as TextView
    val cardThumbnail: ImageView= view.findViewById(R.id.card_thumbnail) as ImageView
}