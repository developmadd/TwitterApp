package com.madd.madd.twitterapp.ui.Fragments.UserProfile;

import com.madd.madd.twitterapp.data.http.API;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;
import com.madd.madd.twitterapp.data.entities.User.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserProfileModel implements UserProfileContract.Model {

    private API api;

    UserProfileModel(API api) {
        this.api = api;
    }


    @Override
    public void getEntity( GetEntity getEntity) {
        api.getUser().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                getEntity.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                getEntity.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getList( GetList getList) {
        api.getTweetList().enqueue(new Callback<List<Tweet>>() {
            @Override
            public void onResponse(Call<List<Tweet>> call, Response<List<Tweet>> response) {
                getList.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Tweet>> call, Throwable t) {
                getList.onError(t.getMessage());
            }
        });
    }
}
