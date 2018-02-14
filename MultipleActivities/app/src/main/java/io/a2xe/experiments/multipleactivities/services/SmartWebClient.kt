package io.a2xe.experiments.multipleactivities.services

import android.webkit.WebView
import android.webkit.WebViewClient
import io.a2xe.experiments.multipleactivities.model.WebSite

/**
 * Created by giorgio on 1/25/18.
 */
class SmartWebClient : WebViewClient() {

    val history: ArrayList<WebSite> = arrayListOf()

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)

        url?.let {
            history.add(WebSite(view?.title ?: "", it))
        }
    }
}
