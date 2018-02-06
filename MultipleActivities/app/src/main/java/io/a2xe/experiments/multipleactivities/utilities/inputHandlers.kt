package io.a2xe.experiments.multipleactivities.utilities

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * Created by giorgio on 1/27/18.
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // Noop
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // Noop
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}
