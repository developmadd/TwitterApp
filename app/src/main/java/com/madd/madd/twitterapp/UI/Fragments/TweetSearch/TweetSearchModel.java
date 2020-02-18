package com.madd.madd.twitterapp.UI.Fragments.TweetSearch;

import com.madd.madd.twitterapp.HTTP.API;
import com.madd.madd.twitterapp.HTTP.Models.SearchByQuery;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TweetSearchModel implements TweetSearchContract.Model {

    private API api;

    TweetSearchModel(API api) {
        this.api = api;
    }


    @Override
    public void getList(String query, GetList getList) {
        api.getTweetListByQuery(query).enqueue(new Callback<SearchByQuery>() {
            @Override
            public void onResponse(Call<SearchByQuery> call, Response<SearchByQuery> response) {
                getList.onSuccess(response.body().tweetList != null ? response.body().tweetList : new ArrayList<>());
            }

            @Override
            public void onFailure(Call<SearchByQuery> call, Throwable t) {
                getList.onError(t.getMessage());
            }
        });
    }


}
