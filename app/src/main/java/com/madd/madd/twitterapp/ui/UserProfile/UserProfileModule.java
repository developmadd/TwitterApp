package com.madd.madd.twitterapp.ui.UserProfile;

import com.madd.madd.twitterapp.data.entities.Tweet.TweetDataSource;
import com.madd.madd.twitterapp.data.entities.User.UserDataSource;

import dagger.Module;
import dagger.Provides;

@Module
public class UserProfileModule {

    @Provides
    UserProfileContract.Presenter providePresenter(
            TweetDataSource.Repository tweetRepository,
            UserDataSource.Repository userRepository){
        return new UserProfilePresenter(tweetRepository,userRepository);
    }


}
