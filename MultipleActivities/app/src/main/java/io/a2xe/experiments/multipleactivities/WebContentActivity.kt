package io.a2xe.experiments.multipleactivities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import io.a2xe.experiments.multipleactivities.bundles.launchURL
import kotlinx.android.synthetic.main.activity_web_content.*

class WebContentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_content)

        web_page_renderer.webViewClient = WebViewClient()

        // Strongly not recommended, it's a not secure practice used to simplify this example
        web_page_renderer.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

       when(savedInstanceState) {
           null -> openWebPage()
           else -> { println(savedInstanceState) }
       }
    }

    private fun openWebPage() {
        intent.launchURL.let {
            web_page_renderer.loadUrl(it)
        }
    }
}
