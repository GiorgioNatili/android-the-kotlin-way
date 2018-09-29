package io.a2xe.experiments.loginandbrowse

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface TweetsService {

    @GET("statuses/user_timeline.json")
    fun searchUserTweets(@Query("user_id") userId: String): Call<Any>

    /**
     * Factory class for convenient creation of the Api Service interface
     */
    companion object {

        fun create(): TweetsService {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.twitter.com/1.1/")
                    .build()

            return retrofit.create(TweetsService::class.java)
        }
    }

}