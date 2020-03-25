package com.madd.madd.twitterapp.ui.Fragments.TweetSearch;

import com.madd.madd.twitterapp.data.http.API;

import dagger.Module;
import dagger.Provides;

@Module
public class TweetSearchModule {

    @Provides
    TweetSearchContract.Presenter providePresenter(TweetSearchContract.Model model){
        return new TweetSearchPresenter(model);
    }

    @Provides
    TweetSearchContract.Model provideModel(API api){
        return new TweetSearchModel(api);
    }

}
