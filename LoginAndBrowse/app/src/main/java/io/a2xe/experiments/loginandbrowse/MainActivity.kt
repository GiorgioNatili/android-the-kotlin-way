package io.a2xe.experiments.loginandbrowse

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import io.a2xe.experiments.loginandbrowse.utilities.toast
import kotlinx.android.synthetic.main.activity_main.*
import isVisible

const val RC_SIGN_IN = 123

class MainActivity : AppCompatActivity() {

    val authenticationProviders = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.TwitterBuilder().build())

    val currentUser: FirebaseUser?
        get() = FirebaseAuth.getInstance().currentUser


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {

            if (resultCode == Activity.RESULT_OK) {

                // Successfully signed in
                currentUser?.let {
                    "User ${it.uid} successfully logged in".toast(this)
                    prepareAuthentication(it)
                }

            } else {

                // Authentication error
                val response = IdpResponse.fromResultIntent(data)
                response?.error?.toast(this)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        when(currentUser) {
            null -> launchAuthenticationProviders(authenticationProviders)
            else -> prepareAuthentication(currentUser)
        }

        twitter_logout.setOnClickListener { logoutFromTwitter { prepareAuthentication(currentUser) } }
        launch_providers.setOnClickListener { launchAuthenticationProviders(authenticationProviders) }
    }

    fun logoutFromTwitter(callback: () -> Unit) {

        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener {
                    callback.invoke()
                }
    }

    fun prepareAuthentication(currentUser: FirebaseUser?) {

        welcome_message.text = currentUser.let {
            if(it != null) getString(R.string.hello_user, it.uid) else ""
        }

        twitter_logout.isVisible = currentUser != null
        launch_providers.isVisible = !twitter_logout.isVisible
    }

    fun launchAuthenticationProviders(providers: ArrayList<AuthUI.IdpConfig>) {

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(), RC_SIGN_IN)
    }
}
