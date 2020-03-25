package com.madd.madd.twitterapp.data.entities.User.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    @SerializedName("name")
    public String name;
    @SerializedName("screen_name")
    public String screenName;
    @SerializedName("description")
    public String description;
    @SerializedName("profile_image_url_https")
    public String photo;
    @SerializedName("profile_background_image_url_https")
    public String backPhoto;

}
