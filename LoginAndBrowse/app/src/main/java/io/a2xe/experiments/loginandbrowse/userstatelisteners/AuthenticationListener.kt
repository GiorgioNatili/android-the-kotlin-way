package io.a2xe.experiments.loginandbrowse.userstatelisteners

import com.google.firebase.auth.FirebaseAuth
import io.a2xe.experiments.loginandbrowse.mediaproviders.UserMedia


class AuthenticationListener(/*private val userMedia: UserMedia*/) : FirebaseAuth.AuthStateListener {

    override fun onAuthStateChanged(authentication: FirebaseAuth) {

        _userMedia?.getUserTweets()
    }

    private var _userMedia: UserMedia? = null
    var userMedia: UserMedia? = null
        set(value) {
            _userMedia = value
        }
}