package io.a2xe.experiments.loginandbrowse

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.twitter.sdk.android.core.TwitterCore
import io.a2xe.experiments.loginandbrowse.mediaproviders.TwitterUserMedia
import io.a2xe.experiments.loginandbrowse.mediaproviders.UserMedia
import io.a2xe.experiments.loginandbrowse.model.entities.MediaEntity
import io.a2xe.experiments.loginandbrowse.userstatelisteners.AuthenticationListener
import io.a2xe.experiments.loginandbrowse.utilities.authenticationProvider
import io.a2xe.experiments.loginandbrowse.utilities.isVisible
import io.a2xe.experiments.loginandbrowse.utilities.toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val authenticationProviders = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.TwitterBuilder().build())

    val mediaProviders: Map<String, UserMedia> = mapOf("twitter.com" to
            TwitterUserMedia(TwitterCore.getInstance().sessionManager.activeSession))

    val currentUser: FirebaseUser?
        get() = FirebaseAuth.getInstance().currentUser

    val authenticationListener = AuthenticationListener(::displayImagesData)

    lateinit var sharedPreferences: SharedPreferences

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {

            if (resultCode == Activity.RESULT_OK) {

                IdpResponse.fromResultIntent(data)?.takeIf { it.providerType != "" }?.apply {
                    sharedPreferences.authenticationProvider = providerType
                }

                // Successfully signed in
                currentUser?.let { it ->

                    ("User ${it.uid} successfully logged with: " +
                            sharedPreferences.authenticationProvider).toast(this)

                    configureUserMediaProvider(it,
                            sharedPreferences.authenticationProvider,
                            mediaProviders)

                    configureAuthenticationUI(it)
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

        sharedPreferences = getSharedPreferences(USER_INFO, MODE_PRIVATE)

        when(currentUser) {
            null -> launchAuthenticationProviders(authenticationProviders)
            else -> {
                configureAuthenticationUI(currentUser)

                currentUser?.let {
                    authenticationListener.userMedia = configureUserMediaProvider(it,
                            sharedPreferences.authenticationProvider,
                            mediaProviders)

                }
            }
        }

        twitter_logout.setOnClickListener { logoutFromTwitter { configureAuthenticationUI(currentUser) } }
        launch_providers.setOnClickListener { launchAuthenticationProviders(authenticationProviders) }
    }

    override fun onStart() {
        super.onStart()

        FirebaseAuth.getInstance().addAuthStateListener(authenticationListener)
    }

    override fun onStop() {
        super.onStop()

        FirebaseAuth.getInstance().removeAuthStateListener(authenticationListener)
    }

    fun configureAuthenticationUI(user: FirebaseUser?) {

        displayWelcomeMessage(user)
        displayAuthenticationControls(user)
    }

    fun logoutFromTwitter(callback: () -> Unit) {

        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener {
                    callback.invoke()
                }
    }

    fun configureUserMediaProvider(user: FirebaseUser,
                                   providerId: String,
                                   providers: Map<String, UserMedia>) : UserMedia? {

        return providers[providerId]?.also { userMedia ->
            userMedia.userId = user.providerData.first { it.providerId == providerId }.uid
        }
    }

    fun displayAuthenticationControls(user: FirebaseUser?) {

        twitter_logout.isVisible = user != null
        launch_providers.isVisible = !twitter_logout.isVisible
    }

    fun displayWelcomeMessage(user: FirebaseUser?) {

        welcome_message.text = user.let {
            if (it != null) getString(R.string.hello_user, it.uid) else ""
        }
    }

    fun displayImagesData(data: List<MediaEntity>) {

        social_media_images.text = data.fold("") { msg, entity -> msg + entity.url +"\n" }
    }

    fun launchAuthenticationProviders(providers: ArrayList<AuthUI.IdpConfig>) {

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(), RC_SIGN_IN)
    }
}
