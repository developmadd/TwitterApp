package com.madd.madd.twitterapp.ui.Fragments.TweetRegister;

import com.madd.madd.twitterapp.data.http.API;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;
import com.madd.madd.twitterapp.data.entities.TweetPost;
import com.madd.madd.twitterapp.data.entities.User.Model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TweetRegisterModel implements TweetRegisterContract.Model {

    private API api;

    TweetRegisterModel(API api) {
        this.api = api;
    }


    @Override
    public void register(TweetPost entity, GetEntity getEntity) {
        api.registerTweet(entity).enqueue(new Callback<Tweet>() {
            @Override
            public void onResponse(Call<Tweet> call, Response<Tweet> response) {
                if( response.body() != null ) {
                    getEntity.onSuccess(response.body());
                } else {
                    getEntity.onError("Error en el servidor");
                }
            }

            @Override
            public void onFailure(Call<Tweet> call, Throwable t) {
                getEntity.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getUser(GetUser getUser) {
        api.getUser().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                getUser.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                getUser.onError(t.getMessage());
            }
        });
    }
}
