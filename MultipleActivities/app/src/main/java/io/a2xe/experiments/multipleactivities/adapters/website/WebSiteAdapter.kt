package io.a2xe.experiments.multipleactivities.adapters.website

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import io.a2xe.experiments.multipleactivities.R
import io.a2xe.experiments.multipleactivities.model.WebSite

/**
 * Created by giorgio on 1/25/18.
 */
class WebSiteAdapter(private val activity: Activity,
                     private val history: ArrayList<WebSite>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View?
        val viewHolder: WebSiteItemRenderer

        if (convertView == null) {
            view = activity.layoutInflater.inflate(R.layout.web_site, parent, false)
            viewHolder = WebSiteItemRenderer(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as WebSiteItemRenderer
        }

        viewHolder.webSiteTitle.text = history[position].title
        return view
    }
    override fun getItem(position: Int): Any {
        return history[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return history.size
    }
}