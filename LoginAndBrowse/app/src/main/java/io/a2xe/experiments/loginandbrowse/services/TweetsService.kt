package io.a2xe.experiments.loginandbrowse.services

import com.twitter.sdk.android.core.TwitterApiClient
import com.twitter.sdk.android.core.TwitterSession
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


class TweetsServiceApiClient(session: TwitterSession) : TwitterApiClient(session) {

    val tweetsService: TweetsService by lazy { getService(TweetsService::class.java)  }
}

interface TweetsService  {

    /**
     * API references
     * https://developer.twitter.com/en/docs/accounts-and-users/follow-search-get-users/api-reference/get-users-lookup
     * https://developer.twitter.com/en/docs/tweets/data-dictionary/overview/extended-entities-object.html
     * https://developer.twitter.com/en/docs/tweets/data-dictionary/overview/entities-object
     *
     * Hints
     * https://twittercommunity.com/t/missing-extended-entities/97375
     * https://www.raymondcamden.com/2016/03/25/getting-images-from-a-twitter-account
     */

    @GET("/1.1/statuses/user_timeline.json")
    fun searchUserTweets(@Query("user_id") userId: String,
                         @Query("include_entities") includeEntities: Boolean = true,
                         @Query("tweet_mode") tweetMode: String = "extended"): Call<Any>



    @GET("/1.1/statuses/home_timeline.json")
    fun homeTimeline(@Query("count") count: Int = 20,
                     @Query("trim_user") trimUser: Boolean = true,
                     @Query("exclude_replies") excludeReplies: Boolean = true,
                     @Query("contributor_details") contributorDetails: Boolean = true,
                     @Query("include_entities") includeEntities: Boolean = true): Call<Any>
}
