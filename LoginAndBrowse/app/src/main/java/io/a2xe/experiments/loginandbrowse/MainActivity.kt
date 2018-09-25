package io.a2xe.experiments.loginandbrowse

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import toast

class MainActivity : AppCompatActivity() {

    lateinit var authentication: FirebaseAuth

    private val RC_SIGN_IN = 123
    var providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.TwitterBuilder().build())


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {

            if (resultCode == Activity.RESULT_OK) {

                // Successfully signed in
                val user = FirebaseAuth.getInstance().currentUser
                user?.let {
                    "User ${it.uid} succesfully logged in".toast(this)
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
            null -> launchAuthenticationProviders()
            else -> {
                welcome_message.text = getString(R.string.hello_user, currentUser.uid)
                twitter_logout.visibility = View.VISIBLE
            }
        }

        twitter_logout.setOnClickListener {

            AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener {
                        welcome_message.text = ""
                        twitter_logout.visibility = View.GONE
                        launch_providers.visibility = View.VISIBLE
                    }
        }

        launch_providers.setOnClickListener { launchAuthenticationProviders() }
    }

    fun launchAuthenticationProviders() {

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(), RC_SIGN_IN)
    }
}
