package io.a2xe.experiments.loginandbrowse

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import toast

class MainActivity : AppCompatActivity() {

    private val RC_SIGN_IN = 123

    lateinit var authentication: FirebaseAuth
    var authenticationProviders = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.TwitterBuilder().build())


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {

            if (resultCode == Activity.RESULT_OK) {

                // Successfully signed in
                val user = FirebaseAuth.getInstance().currentUser
                user?.let {
                    "User ${it.uid} successfully logged in".toast(this)
                    prepareForLogout(it)
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

        authentication = FirebaseAuth.getInstance()
        val currentUser = authentication.currentUser

        when(currentUser) {
            null -> launchAuthenticationProviders(authenticationProviders)
            else -> prepareForLogout(currentUser)
        }

        twitter_logout.setOnClickListener { logoutFromTwitter(::prepareForAuthentication) }
        launch_providers.setOnClickListener { launchAuthenticationProviders(authenticationProviders) }
    }

    fun prepareForLogout(currentUser: FirebaseUser) {

        welcome_message.text = getString(R.string.hello_user, currentUser.uid)

        twitter_logout.visibility = View.VISIBLE
        launch_providers.visibility = View.GONE
    }

    fun prepareForAuthentication() {

        welcome_message.text = ""

        twitter_logout.visibility = View.GONE
        launch_providers.visibility = View.VISIBLE
    }

    fun logoutFromTwitter(callback: ()->Unit) {

        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener {
                    callback.invoke()
                }
    }

    fun launchAuthenticationProviders(providers: ArrayList<AuthUI.IdpConfig>) {

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(), RC_SIGN_IN)
    }
}
