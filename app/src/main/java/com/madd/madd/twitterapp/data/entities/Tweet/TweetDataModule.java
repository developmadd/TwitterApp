package com.madd.madd.twitterapp.data.entities.Tweet;

import com.madd.madd.twitterapp.data.entities.Tweet.Source.Local.TweetCacheDataSource;
import com.madd.madd.twitterapp.data.entities.Tweet.Source.Remote.TweetRemoteDataSource;
import com.madd.madd.twitterapp.data.http.TwitterAPI;

import dagger.Module;
import dagger.Provides;

@Module
public class TweetDataModule {

    @Provides
    public TweetDataSource.Repository provideTweetRepository(
            TweetDataSource.Remote remote,
            TweetDataSource.Cache cache){
        return new TweetRepository(remote,cache);
    }

    @Provides
    public TweetDataSource.Remote provideTweetRemoteDataSource(TwitterAPI twitterApi){
        return new TweetRemoteDataSource(twitterApi);
    }

    @Provides
    public TweetDataSource.Cache provideTweetCacheDataSource(){
        return new TweetCacheDataSource();
    }
}
