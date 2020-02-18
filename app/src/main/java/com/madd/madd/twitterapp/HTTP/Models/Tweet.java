package com.madd.madd.twitterapp.HTTP.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tweet {

    @SerializedName("text")
    public String description;

    @SerializedName("created_at")
    public String date;

    @SerializedName("user")
    public User user;

    @SerializedName("entities")
    public Entity entities;


    public class Entity{

        @SerializedName("media")
        public List<Media> media;

        public class Media{

            @SerializedName("media_url_https")
            public String photo;

        }

    }
}
