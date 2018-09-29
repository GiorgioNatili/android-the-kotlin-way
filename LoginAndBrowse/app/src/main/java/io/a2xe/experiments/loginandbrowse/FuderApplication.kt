package io.a2xe.experiments.loginandbrowse

import android.app.Application
import android.util.Log
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig


class FuderApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val authConfig = TwitterAuthConfig(resources.getString(R.string.twitter_consumer_key),
                resources.getString(R.string.twitter_consumer_secret))

        val config = TwitterConfig.Builder(this)
                .logger(DefaultLogger(Log.DEBUG)) // enable logging when app is in debug mode
                .twitterAuthConfig(authConfig)
                .debug(true) // enable debug mode
                .build()

        Twitter.initialize(config)
    }
}