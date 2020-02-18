package com.madd.madd.twitterapp.DI;


import com.madd.madd.twitterapp.HTTP.APIModule;
import com.madd.madd.twitterapp.UI.Activities.MainActivity;
import com.madd.madd.twitterapp.UI.Fragments.TweetDetail.TweetDetailFragment;
import com.madd.madd.twitterapp.UI.Fragments.TweetDetail.TweetDetailModule;
import com.madd.madd.twitterapp.UI.Fragments.TweetRegister.TweetRegisterFragment;
import com.madd.madd.twitterapp.UI.Fragments.TweetRegister.TweetRegisterModule;
import com.madd.madd.twitterapp.UI.Fragments.TweetSearch.TweetSearchFragment;
import com.madd.madd.twitterapp.UI.Fragments.TweetSearch.TweetSearchModule;
import com.madd.madd.twitterapp.UI.Fragments.UserProfile.UserProfileFragment;
import com.madd.madd.twitterapp.UI.Fragments.UserProfile.UserProfileModule;

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
        void inject(MainActivity target);
        void inject(UserProfileFragment target);
        void inject(TweetSearchFragment target);
        void inject(TweetDetailFragment target);
        void inject(TweetRegisterFragment target);
}
