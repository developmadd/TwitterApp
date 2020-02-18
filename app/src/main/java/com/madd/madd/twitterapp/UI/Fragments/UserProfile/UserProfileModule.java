package com.madd.madd.twitterapp.UI.Fragments.UserProfile;

import com.madd.madd.twitterapp.HTTP.API;

import dagger.Module;
import dagger.Provides;

@Module
public class UserProfileModule {

    @Provides
    UserProfileContract.Presenter providePresenter(UserProfileContract.Model model){
        return new UserProfilePresenter(model);
    }

    @Provides
    UserProfileContract.Model provideModel(API api){
        return new UserProfileModel(api);
    }

}
