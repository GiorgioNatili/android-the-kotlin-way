package io.a2xe.experiments.loginandbrowse.mediaproviders

interface UserMedia {

    var userId: String

    fun getUserTweets()
}