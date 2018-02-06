package io.a2xe.experiments.multipleactivities.bundles

import android.content.Intent

/**
 * Created by giorgio on 1/23/18.
 */
private const val LAUNCH_URL = "LAUNCH_URL"

var Intent.launchURL: String?
    set(value) {
        this.putExtra(LAUNCH_URL, value)
    }
    get() {
        this.extras?.let{
            return it.getString(LAUNCH_URL)
        }
        return null
    }