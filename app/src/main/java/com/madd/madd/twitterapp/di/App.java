package com.madd.madd.twitterapp.di;

import android.app.Application;

import com.madd.madd.twitterapp.data.entities.Tweet.TweetDataModule;
import com.madd.madd.twitterapp.data.entities.User.UserDataModule;
import com.madd.madd.twitterapp.data.http.APIModule;
import com.madd.madd.twitterapp.ui.TweetDetail.TweetDetailModule;
import com.madd.madd.twitterapp.ui.TweetRegister.TweetRegisterModule;
import com.madd.madd.twitterapp.ui.TweetSearch.TweetSearchModule;
import com.madd.madd.twitterapp.ui.UserProfile.UserProfileModule;

public class App extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .tweetDetailModule(new TweetDetailModule())
                .tweetSearchModule(new TweetSearchModule())
                .userProfileModule(new UserProfileModule())
                .tweetRegisterModule(new TweetRegisterModule())

                .aPIModule(new APIModule())
                .userDataModule(new UserDataModule())
                .tweetDataModule(new TweetDataModule())
                .build();
    }

    public AppComponent getComponent(){
        return appComponent;
    }
}
