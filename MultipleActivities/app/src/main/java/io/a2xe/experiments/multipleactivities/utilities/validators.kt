package io.a2xe.experiments.multipleactivities.utilities

/**
 * Created by giorgio on 1/27/18.
 */
val String.isValidURL: Boolean
    get() {
        return this.matches(Regex("^http(s?)://[a-zA-Z0-9_/\\-.]+\\.([A-Za-z/]{2,5})[a-zA-Z0-9_/&?=\\-.~%]*"))
    }
