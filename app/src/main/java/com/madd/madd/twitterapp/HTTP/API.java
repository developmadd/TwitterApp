package com.madd.madd.twitterapp.HTTP;

import com.madd.madd.twitterapp.HTTP.Models.SearchByQuery;
import com.madd.madd.twitterapp.HTTP.Models.Tweet;
import com.madd.madd.twitterapp.HTTP.Models.TweetPost;
import com.madd.madd.twitterapp.HTTP.Models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {



    @GET("/api/user")
    Call<User> getUser();

    @GET("/api/statuses/user_timeline")
    Call<List<Tweet>> getTweetList();


    @GET("/api/search/{query}")
    Call<SearchByQuery> getTweetListByQuery(@Path("query") String query);


    @POST("/api/statuses/update")
    Call<Tweet> registerTweet(@Body TweetPost tweetPost);



}
