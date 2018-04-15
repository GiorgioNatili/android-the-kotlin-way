package io.a2xe.experiments.pokemondeck.views.cards.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import io.a2xe.experiments.pokemondeck.R
import io.a2xe.experiments.pokemondeck.model.entities.Card

/**
 * Created by giorgio on 4/14/18.
 */
class CardsAdapter(private val context: Context,
                   private val cards: List<Card>,
                   private val callback: (Card) -> Unit) : RecyclerView.Adapter<CardItemRender>() {

    override fun onBindViewHolder(holder: CardItemRender?, position: Int) {

        holder?.apply {

            cardName.text = cards[position].name
            Picasso.with(context).load(cards[position].imageUrl).into(cardThumbnail)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CardItemRender? {

        val view = LayoutInflater.from(context).inflate(R.layout.card_item_renderer, parent, false)
        val cardItemRender = CardItemRender(view)

        view.setOnClickListener {
            callback(cards[cardItemRender.adapterPosition])
        }

        return cardItemRender
    }

    override fun getItemId(position: Int): Long {
        return cards[position].id.toBigInteger().toLong()
    }

    override fun getItemCount(): Int {
        return cards.size
    }
}