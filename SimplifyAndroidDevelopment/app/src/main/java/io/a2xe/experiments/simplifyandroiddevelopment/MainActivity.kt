package io.a2xe.experiments.simplifyandroiddevelopment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        val name = sharedPreferences.getString("name", "")
        hello_message.text = when(name.isNotEmpty()) {
            true -> "Hello $name!"
            else -> "Hello World!"
        }

        save.setOnClickListener {
            sharedPreferences.edit {
                putString("name", name_input.text.toString())
            }

            getString(R.string.name_updated).toast(this)
        }
    }
}