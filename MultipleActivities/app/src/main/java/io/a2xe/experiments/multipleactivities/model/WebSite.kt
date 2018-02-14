package io.a2xe.experiments.multipleactivities.model

/**
 * Created by giorgio on 1/25/18.
 */
data class WebSite(val title: String,
                   val url: String) {
    val timestamp: Long = System.currentTimeMillis()
}
