package io.a2xe.experiments.loginandbrowse.mediaproviders

import io.a2xe.experiments.loginandbrowse.model.entities.MediaEntity

interface UserMedia {

    var userId: String

    fun getUserFeed(callback: (data: List<MediaEntity>) -> Unit)
}