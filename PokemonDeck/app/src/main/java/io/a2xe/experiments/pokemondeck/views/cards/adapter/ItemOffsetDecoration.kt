package io.a2xe.experiments.pokemondeck.views.cards.adapter

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by giorgio on 4/14/18.
 */
class ItemOffsetDecoration(private var itemOffset: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView,
                       state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(itemOffset, itemOffset, itemOffset, itemOffset)
    }
}