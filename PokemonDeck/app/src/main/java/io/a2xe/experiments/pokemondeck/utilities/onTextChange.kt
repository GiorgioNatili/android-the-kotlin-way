package io.a2xe.experiments.pokemondeck.utilities

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * Created by giorgio on 4/17/18.
 */
fun EditText.onChange(callback: (String) -> Unit) {
    this.addTextChangedListener(object: TextWatcher {
        override fun afterTextChanged(s: Editable?) { callback(s.toString()) }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    })
}