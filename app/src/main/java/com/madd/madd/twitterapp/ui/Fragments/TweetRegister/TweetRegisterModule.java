package com.madd.madd.twitterapp.ui.Fragments.TweetRegister;

import com.madd.madd.twitterapp.data.http.API;

import dagger.Module;
import dagger.Provides;

@Module
public class TweetRegisterModule {

    @Provides
    TweetRegisterContract.Presenter providePresenter(TweetRegisterContract.Model model){
        return new TweetRegisterPresenter(model);
    }

    @Provides
    TweetRegisterContract.Model provideModel(API api){
        return new TweetRegisterModel(api);
    }

}
