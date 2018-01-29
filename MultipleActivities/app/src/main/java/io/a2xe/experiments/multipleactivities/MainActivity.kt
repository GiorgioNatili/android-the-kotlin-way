package io.a2xe.experiments.multipleactivities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.a2xe.experiments.multipleactivities.adapters.website.WebSiteAdapter
import io.a2xe.experiments.multipleactivities.bundles.launchURL
import io.a2xe.experiments.multipleactivities.messages.ActivityBasedMainMessages
import io.a2xe.experiments.multipleactivities.messages.MainMessages
import io.a2xe.experiments.multipleactivities.utilities.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val userInputErrors: MainMessages = ActivityBasedMainMessages(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadHistory()

        url_to_open.afterTextChanged {
            when (it.isValidURL) {
                true ->  url_to_open.error = null
                false -> url_to_open.error = userInputErrors.notValidURL
            }
            open_new_window.isEnabled = it.isValidURL
        }

        open_new_window.setOnClickListener {

            launchActivity<WebContentActivity>{
                this.launchURL = url_to_open.text.toString()
            }
        }
    }

    private fun loadHistory() {

        val urls = readURLs()
        val adapter = WebSiteAdapter(this, urls)

        local_history.adapter = adapter
    }

    override fun onRestart() {
        super.onRestart()
        loadHistory()
    }
}
