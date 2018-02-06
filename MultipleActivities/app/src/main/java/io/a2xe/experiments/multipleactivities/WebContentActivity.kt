package io.a2xe.experiments.multipleactivities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebSettings
import io.a2xe.experiments.multipleactivities.bundles.launchURL
import io.a2xe.experiments.multipleactivities.model.WebSite
import io.a2xe.experiments.multipleactivities.services.SmartWebClient
import io.a2xe.experiments.multipleactivities.utilities.readURLs
import io.a2xe.experiments.multipleactivities.utilities.saveURLs
import kotlinx.android.synthetic.main.activity_web_content.*

class WebContentActivity : AppCompatActivity() {

    private val CURRENT_URL: String = "CURRENT_URL"
    private val smartWebClient = SmartWebClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_content)

        web_page_renderer.webViewClient = smartWebClient
        // Strongly not recommended, it's a not secure practice used to simplify this example
        web_page_renderer.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

        intent.launchURL?.let {
            web_page_renderer.loadUrl(it)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putString(CURRENT_URL, web_page_renderer.url)
        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        super.onStop()
        saveURLs(smartWebClient.history)
    }
}
