package com.madd.madd.twitterapp.data.http;

import com.madd.madd.twitterapp.data.entities.Tweet.Model.TweetSearch;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.TweetPost;
import com.madd.madd.twitterapp.data.entities.User.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TwitterAPI {

    String BASE_URL = "https://wizetwitterproxy.herokuapp.com";

    @GET("/api/user")
    Call<User> getUser();

    @GET("/api/statuses/user_timeline")
    Call<List<Tweet>> getTweetList();


    @GET("/api/search/{query}")
    Call<TweetSearch> getTweetListByQuery(@Path("query") String query);


    @POST("/api/statuses/update")
    Call<Tweet> registerTweet(@Body TweetPost tweetPost);



}
