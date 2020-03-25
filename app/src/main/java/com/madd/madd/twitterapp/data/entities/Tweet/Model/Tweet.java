package com.madd.madd.twitterapp.data.entities.Tweet.Model;

import com.google.gson.annotations.SerializedName;
import com.madd.madd.twitterapp.data.entities.User.Model.User;

import java.io.Serializable;
import java.util.List;

public class Tweet implements Serializable {

    @SerializedName("text")
    public String description;

    @SerializedName("created_at")
    public String date;

    @SerializedName("user")
    public User user;

    @SerializedName("entities")
    public Entity entities;


    public class Entity implements Serializable{

        @SerializedName("media")
        public List<Media> media;

        public class Media implements Serializable{

            @SerializedName("media_url_https")
            public String photo;

        }

    }
}
