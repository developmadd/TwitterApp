package com.madd.madd.twitterapp.HTTP.Models;

import com.google.gson.annotations.SerializedName;

public class User {

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
