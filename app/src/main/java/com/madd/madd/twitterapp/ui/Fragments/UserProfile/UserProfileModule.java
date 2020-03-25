package com.madd.madd.twitterapp.ui.Fragments.UserProfile;

import com.madd.madd.twitterapp.data.http.API;

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
