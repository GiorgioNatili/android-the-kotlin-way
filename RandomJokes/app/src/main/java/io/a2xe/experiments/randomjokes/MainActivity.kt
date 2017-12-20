package io.a2xe.experiments.randomjokes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jokesProvider = JokesProvider(this)
        joke_content.text = jokesProvider.getRandomJoke()

        show_source_code.setOnCheckedChangeListener {_, isChecked ->

            when(isChecked) {
                true -> code_sample.visibility = View.VISIBLE
                else -> code_sample.visibility = View.GONE
            }
        }
    }
}