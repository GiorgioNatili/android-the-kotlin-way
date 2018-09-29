package io.a2xe.experiments.loginandbrowse

import com.google.firebase.auth.FirebaseAuth


class AuthenticationListener(private val userMedia: UserMedia) : FirebaseAuth.AuthStateListener {

    override fun onAuthStateChanged(auth: FirebaseAuth) {

        val user = auth.currentUser

        when {
            user != null -> userMedia.getUserTweets()
        }
    }
}