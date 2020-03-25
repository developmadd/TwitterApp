package com.madd.madd.twitterapp.di;

import android.app.Application;

import com.madd.madd.twitterapp.data.http.APIModule;
import com.madd.madd.twitterapp.ui.Fragments.TweetDetail.TweetDetailModule;
import com.madd.madd.twitterapp.ui.Fragments.TweetRegister.TweetRegisterModule;
import com.madd.madd.twitterapp.ui.Fragments.TweetSearch.TweetSearchModule;
import com.madd.madd.twitterapp.ui.Fragments.UserProfile.UserProfileModule;

public class App extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .aPIModule(new APIModule())
                .tweetDetailModule(new TweetDetailModule())
                .tweetSearchModule(new TweetSearchModule())
                .userProfileModule(new UserProfileModule())
                .tweetRegisterModule(new TweetRegisterModule())
                .build();
    }

    public AppComponent getComponent(){
        return appComponent;
    }
}
