package com.madd.madd.twitterapp.data.entities.Tweet;

import com.madd.madd.twitterapp.data.entities.DataSource;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.TweetPost;

import java.util.List;

public interface TweetDataSource {

    interface Repository{
        void register(String tweetText, DataSource.GetEntity<Tweet> getTweet);
        void getTweetListByUser(DataSource.GetList<Tweet> getList);
        void getTweetListByQuery(String query, DataSource.GetList<Tweet> getList);
    }

    interface Remote{
        void register(TweetPost tweetPost, DataSource.GetEntity<Tweet> getEntity);
        void getTweetListByUser(DataSource.GetList<Tweet> getList);
        void getTweetListByQuery(String query, DataSource.GetList<Tweet> getList);
    }

    interface Cache{
        void getTweetListByUser(DataSource.GetList<Tweet> getList);
        void setTweetListByUser(List<Tweet> tweetList);
    }



}
