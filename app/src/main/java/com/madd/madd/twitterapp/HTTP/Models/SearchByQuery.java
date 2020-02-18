package com.madd.madd.twitterapp.HTTP.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchByQuery {

    @SerializedName("statuses")
    public List<Tweet> tweetList;

}
