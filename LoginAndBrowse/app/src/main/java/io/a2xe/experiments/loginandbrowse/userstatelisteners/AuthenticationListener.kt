package io.a2xe.experiments.loginandbrowse.userstatelisteners

import com.google.firebase.auth.FirebaseAuth
import io.a2xe.experiments.loginandbrowse.mediaproviders.UserMedia
import io.a2xe.experiments.loginandbrowse.model.entities.MediaEntity

class AuthenticationListener(private val callback: (data: List<MediaEntity>) -> Unit) : FirebaseAuth.AuthStateListener {

    override fun onAuthStateChanged(authentication: FirebaseAuth) {

        _userMedia?.getUserFeed(callback)
    }

    private var _userMedia: UserMedia? = null
    var userMedia: UserMedia? = null
        set(value) {
            _userMedia = value
        }
}