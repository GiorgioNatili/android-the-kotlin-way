package io.a2xe.experiments.loginandbrowse

class TwitterUserMedia : UserMedia {

    private var _userId = ""

    override var userId: String
        get() = _userId
        set(value) {
            _userId = value
        }

    override fun getUserTweets() {

        println("Get assets from Twitter user $_userId")

        val tweets = TweetsService.create()
        tweets.searchUserTweets(_userId)
    }
}