package com.madd.madd.twitterapp.DI;

import android.app.Application;

import com.madd.madd.twitterapp.HTTP.APIModule;
import com.madd.madd.twitterapp.UI.Fragments.TweetDetail.TweetDetailModule;
import com.madd.madd.twitterapp.UI.Fragments.TweetRegister.TweetRegisterModule;
import com.madd.madd.twitterapp.UI.Fragments.TweetSearch.TweetSearchModule;
import com.madd.madd.twitterapp.UI.Fragments.UserProfile.UserProfileModule;

public class App extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .aPIModule(new APIModule())
                .tweetDetailModule(new TweetDetailModule())
                .tweeterSearchModule(new TweetSearchModule())
                .userProfileModule(new UserProfileModule())
                .tweeterRegisterModule(new TweetRegisterModule())
                .build();
    }

    public AppComponent getComponent(){
        return appComponent;
    }
}
