package com.madd.madd.twitterapp.data.entities.Tweet.Source.Local;

import com.madd.madd.twitterapp.data.entities.DataSource;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;
import com.madd.madd.twitterapp.data.entities.Tweet.TweetDataSource;

import java.util.ArrayList;
import java.util.List;

public class TweetCacheDataSource implements TweetDataSource.Cache {

    private List<Tweet> tweetList = new ArrayList<>();
    private long timeStamp;
    private long CACHE_LIFETIME = 1000 * 60;

    @Override
    public void getTweetListByUser(DataSource.GetList<Tweet> getList) {
        if( !tweetList.isEmpty() ){
            if( System.currentTimeMillis() - timeStamp > CACHE_LIFETIME ){
                getList.onSuccess(tweetList);
                return;
            } else {
                tweetList.clear();
            }
        }
        getList.onError("ERROR");
    }

    @Override
    public void setTweetListByUser(List<Tweet> tweetList) {
        timeStamp = System.currentTimeMillis();
        this.tweetList.clear();
        this.tweetList.addAll(tweetList);
    }
}
