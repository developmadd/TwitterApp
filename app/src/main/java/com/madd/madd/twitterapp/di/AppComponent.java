package com.madd.madd.twitterapp.di;


import com.madd.madd.twitterapp.data.http.APIModule;
import com.madd.madd.twitterapp.ui.Fragments.TweetDetail.TweetDetailActivity;
import com.madd.madd.twitterapp.ui.Fragments.TweetRegister.TweetRegisterActivity;
import com.madd.madd.twitterapp.ui.Fragments.UserProfile.UserProfileActivity;
import com.madd.madd.twitterapp.ui.Fragments.TweetDetail.TweetDetailModule;
import com.madd.madd.twitterapp.ui.Fragments.TweetRegister.TweetRegisterModule;
import com.madd.madd.twitterapp.ui.Fragments.TweetSearch.TweetSearchFragment;
import com.madd.madd.twitterapp.ui.Fragments.TweetSearch.TweetSearchModule;
import com.madd.madd.twitterapp.ui.Fragments.UserProfile.UserProfileModule;

import dagger.Component;

@Component( modules = {
        AppModule.class,
        APIModule.class,
        UserProfileModule.class,
        TweetSearchModule.class,
        TweetDetailModule.class,
        TweetRegisterModule.class
})
public interface AppComponent {
        void inject(UserProfileActivity target);
        void inject(TweetSearchFragment target);
        void inject(TweetDetailActivity target);
        void inject(TweetRegisterActivity target);
}
