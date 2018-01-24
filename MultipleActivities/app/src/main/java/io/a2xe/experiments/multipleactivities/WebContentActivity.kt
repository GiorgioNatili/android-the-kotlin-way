package io.a2xe.experiments.multipleactivities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebSettings
import android.webkit.WebViewClient
import io.a2xe.experiments.multipleactivities.bundles.launchURL
import kotlinx.android.synthetic.main.activity_web_content.*

class WebContentActivity : AppCompatActivity() {

    private val CURRENT_URL: String = "CURRENT_URL"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_content)

        web_page_renderer.webViewClient = WebViewClient()
        // Strongly not recommended, it's a not secure practice used to simplify this example
        web_page_renderer.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

       when(savedInstanceState) {
           null -> openWebPage(intent.launchURL)
           else -> openWebPage(savedInstanceState.getString(CURRENT_URL))
       }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putString(CURRENT_URL, web_page_renderer.url)
        super.onSaveInstanceState(outState)
    }

    private fun openWebPage(url: String?) {
        url.let {
            web_page_renderer.loadUrl(it)
        }
    }
}
