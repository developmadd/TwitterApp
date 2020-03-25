package com.madd.madd.twitterapp.data.entities.Tweet.Source.Remote;

import com.madd.madd.twitterapp.data.entities.DataSource;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.TweetSearch;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;
import com.madd.madd.twitterapp.data.entities.Tweet.TweetDataSource;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.TweetPost;
import com.madd.madd.twitterapp.data.http.TwitterAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TweetRemoteDataSource implements TweetDataSource.Remote {


    private TwitterAPI twitterApi;

    public TweetRemoteDataSource(TwitterAPI twitterApi) {
        this.twitterApi = twitterApi;
    }

    @Override
    public void register(TweetPost entity, DataSource.GetEntity getEntity) {
        twitterApi.registerTweet(entity).enqueue(new Callback<Tweet>() {
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
    public void getTweetListByUser(DataSource.GetList<Tweet> getList) {
        twitterApi.getTweetList().enqueue(new Callback<List<Tweet>>() {
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

    @Override
    public void getTweetListByQuery(String query, DataSource.GetList<Tweet> getList) {
        twitterApi.getTweetListByQuery(query).enqueue(new Callback<TweetSearch>() {
            @Override
            public void onResponse(Call<TweetSearch> call, Response<TweetSearch> response) {
                getList.onSuccess(response.body().tweetList != null ? response.body().tweetList : new ArrayList<>());
            }

            @Override
            public void onFailure(Call<TweetSearch> call, Throwable t) {
                getList.onError(t.getMessage());
            }
        });
    }
}
