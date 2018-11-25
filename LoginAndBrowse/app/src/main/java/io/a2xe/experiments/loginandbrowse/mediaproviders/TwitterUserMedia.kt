package io.a2xe.experiments.loginandbrowse.mediaproviders

import com.google.gson.internal.LinkedTreeMap
import com.twitter.sdk.android.core.TwitterApiClient
import com.twitter.sdk.android.core.TwitterSession
import io.a2xe.experiments.loginandbrowse.model.entities.MediaEntity
import io.a2xe.experiments.loginandbrowse.services.TweetsService
import io.a2xe.experiments.loginandbrowse.services.TweetsServiceApiClient
import io.a2xe.experiments.loginandbrowse.transformers.toMediaEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TwitterUserMedia(session: TwitterSession) : TwitterApiClient(session), UserMedia {

    init {
        println(session)
    }

    private var _userId = ""
    private val twitterApi: TweetsService = TweetsServiceApiClient(session).tweetsService

    override var userId: String
        get() = _userId
        set(value) {
            _userId = value
        }

    override fun getUserFeed(callback: (data: List<MediaEntity>) -> Unit) {

        println("Get assets from Twitter user $_userId")

        val call = twitterApi.searchUserTweets(_userId)
        call.enqueue(object : Callback<Any> {
            override fun onFailure(call: Call<Any>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<Any>, response: Response<Any>) {

                val tweets = (response.body() as ArrayList<*>)
                        .filter { (it as LinkedTreeMap<*, *>)["extended_entities"] != null }
                        .map { toMediaEntity (it as LinkedTreeMap<*, *>) }

                callback.invoke(tweets)
            }
        })
    }
}

