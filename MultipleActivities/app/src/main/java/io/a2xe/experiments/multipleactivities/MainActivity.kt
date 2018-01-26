package io.a2xe.experiments.multipleactivities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.a2xe.experiments.multipleactivities.adapters.WebSiteAdapter
import io.a2xe.experiments.multipleactivities.bundles.launchURL
import io.a2xe.experiments.multipleactivities.utilities.launchActivity
import io.a2xe.experiments.multipleactivities.utilities.readURLs
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = WebSiteAdapter(this, readURLs())
        local_history.adapter = adapter

        open_new_window.setOnClickListener {

            launchActivity<WebContentActivity>{
                this.launchURL = url_to_open.text.toString()
            }
        }
    }
}
