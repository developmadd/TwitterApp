package com.madd.madd.twitterapp.data.entities.Tweet.Model;

import com.google.gson.annotations.SerializedName;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;

import java.util.List;

public class TweetSearch {

    @SerializedName("statuses")
    public List<Tweet> tweetList;

}
