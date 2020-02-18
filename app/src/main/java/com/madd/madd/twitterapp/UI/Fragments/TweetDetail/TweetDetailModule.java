package com.madd.madd.twitterapp.UI.Fragments.TweetDetail;

import dagger.Module;
import dagger.Provides;

@Module
public class TweetDetailModule {

    @Provides
    TweetDetailContract.Presenter providePresenter(){
        return new TweetDetailPresenter();
    }


}
