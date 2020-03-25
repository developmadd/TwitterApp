package com.madd.madd.twitterapp.data.entities.User.Source.Remote;

import com.madd.madd.twitterapp.data.entities.DataSource;
import com.madd.madd.twitterapp.data.entities.User.Model.User;
import com.madd.madd.twitterapp.data.entities.User.UserDataSource;
import com.madd.madd.twitterapp.data.http.TwitterAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRemoteDataSource implements UserDataSource.Remote {

    private TwitterAPI twitterApi;

    public UserRemoteDataSource(TwitterAPI twitterApi) {
        this.twitterApi = twitterApi;
    }

    @Override
    public void getUser(DataSource.GetEntity<User> getUser) {
        twitterApi.getUser().enqueue(new Callback<User>() {
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
