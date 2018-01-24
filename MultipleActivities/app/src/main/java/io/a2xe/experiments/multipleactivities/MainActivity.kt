package io.a2xe.experiments.multipleactivities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.a2xe.experiments.multipleactivities.bundles.launchURL
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        open_new_window.setOnClickListener {

            launchActivity<WebContentActivity>{
                this.launchURL = url_to_open.text.toString()
            }
        }
    }
}
