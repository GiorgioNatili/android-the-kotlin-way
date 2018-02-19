package io.a2xe.experiments.multipleactivities.messages

import android.app.Activity
import io.a2xe.experiments.multipleactivities.R

/**
 * Created by giorgio on 1/27/18.
 */
class ActivityBasedURLUserInput(private val activity: Activity) : URLUserInput {

    override val notValidURL: String
        get() = activity.getString(R.string.not_valid_url)

    override val typeValidURL: String
        get() = activity.getString(R.string.type_valid_url)
}