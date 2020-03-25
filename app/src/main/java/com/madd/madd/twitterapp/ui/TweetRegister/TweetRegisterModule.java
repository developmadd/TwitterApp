package com.madd.madd.twitterapp.ui.TweetRegister;

import com.madd.madd.twitterapp.data.entities.Tweet.TweetDataSource;
import com.madd.madd.twitterapp.data.entities.User.UserDataSource;

import dagger.Module;
import dagger.Provides;

@Module
public class TweetRegisterModule {

    @Provides
    TweetRegisterContract.Presenter providePresenter(
            TweetDataSource.Repository tweetRepository,
            UserDataSource.Repository userRepository){
        return new TweetRegisterPresenter(tweetRepository,userRepository);
    }


}
