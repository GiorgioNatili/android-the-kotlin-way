package io.a2xe.experiments.multipleactivities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_content.*

class WebContentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_content)

        web_page_renderer.webViewClient = WebViewClient()
        web_page_renderer.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

       when(savedInstanceState) {
           null -> openWebPage()
           else -> { println(savedInstanceState) }
       }
    }

    private fun openWebPage() {

        this.intent.extras.let {
            val launchUrl = it.getString("LAUNCH_URL")
            web_page_renderer.loadUrl(launchUrl)
        }
    }
}
