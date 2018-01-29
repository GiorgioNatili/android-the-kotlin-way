package io.a2xe.experiments.multipleactivities.messages

import android.app.Activity
import io.a2xe.experiments.multipleactivities.R

/**
 * Created by giorgio on 1/27/18.
 */
class ActivityBasedMainMessages(private val activity: Activity) : MainMessages {

    override val notValidURL: String
        get() = activity.getString(R.string.not_valid_url)

    override val typeAnURL: String
        get() = activity.getString(R.string.open_content_main_activity)
}