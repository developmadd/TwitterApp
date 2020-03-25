package com.madd.madd.twitterapp.data.entities.Tweet;

import com.madd.madd.twitterapp.data.entities.DataSource;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.TweetPost;

import java.util.List;

public class TweetRepository implements TweetDataSource.Repository{

    private TweetDataSource.Remote remote;
    private TweetDataSource.Cache cache;

    public TweetRepository(TweetDataSource.Remote remote, TweetDataSource.Cache cache) {
        this.remote = remote;
        this.cache = cache;
    }


    @Override
    public void register(String tweetText, DataSource.GetEntity<Tweet> getTweet) {
        TweetPost tweetPost = new TweetPost();
        tweetPost.status = tweetText;
        remote.register(tweetPost,getTweet);
    }

    @Override
    public void getTweetListByUser(DataSource.GetList<Tweet> getList) {
        cache.getTweetListByUser(new DataSource.GetList<Tweet>() {
            @Override
            public void onSuccess(List<Tweet> list) {
                getList.onSuccess(list);
            }

            @Override
            public void onError(String error) {
                remote.getTweetListByUser(new DataSource.GetList<Tweet>() {
                    @Override
                    public void onSuccess(List<Tweet> list) {
                        getList.onSuccess(list);
                        cache.setTweetListByUser(list);
                    }

                    @Override
                    public void onError(String error) {
                        getList.onError(error);
                    }
                });
            }
        });
    }

    @Override
    public void getTweetListByQuery(String query, DataSource.GetList<Tweet> getList) {
        remote.getTweetListByQuery(query, getList);
    }
}
