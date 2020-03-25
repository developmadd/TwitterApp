package com.madd.madd.twitterapp.di;


import com.madd.madd.twitterapp.data.entities.Tweet.TweetDataModule;
import com.madd.madd.twitterapp.data.entities.User.UserDataModule;
import com.madd.madd.twitterapp.data.http.APIModule;
import com.madd.madd.twitterapp.ui.TweetDetail.TweetDetailActivity;
import com.madd.madd.twitterapp.ui.TweetRegister.TweetRegisterActivity;
import com.madd.madd.twitterapp.ui.TweetSearch.TweetSearchActivity;
import com.madd.madd.twitterapp.ui.UserProfile.UserProfileActivity;
import com.madd.madd.twitterapp.ui.TweetDetail.TweetDetailModule;
import com.madd.madd.twitterapp.ui.TweetRegister.TweetRegisterModule;
import com.madd.madd.twitterapp.ui.TweetSearch.TweetSearchModule;
import com.madd.madd.twitterapp.ui.UserProfile.UserProfileModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component( modules = {
                AppModule.class,
                UserProfileModule.class,
                TweetSearchModule.class,
                TweetDetailModule.class,
                TweetRegisterModule.class,

                APIModule.class,
                UserDataModule.class,
                TweetDataModule.class})
public interface AppComponent {
        void inject(UserProfileActivity target);
        void inject(TweetSearchActivity target);
        void inject(TweetDetailActivity target);
        void inject(TweetRegisterActivity target);
}
