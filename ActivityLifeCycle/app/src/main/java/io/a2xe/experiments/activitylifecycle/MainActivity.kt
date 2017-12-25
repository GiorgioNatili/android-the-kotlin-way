package io.a2xe.experiments.activitylifecycle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        "Activity:onCreate".toast(this)
    }

    override fun onStart() {
        super.onStart()

        "Activity:onStart".toast(this)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putString("NAME", "Mike")
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        println(savedInstanceState?.getString("NAME"))
    }

    override fun onResume() {
        super.onResume()
        "Activity:onResume".toast(this)
    }

    override fun onPause() {
        super.onPause()
        "Activity:onPause".toast(this)
    }

    override fun onStop() {
        super.onStop()
        "Activity:onStop".toast(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        "Activity:onDestroy".toast(this)
    }
}
