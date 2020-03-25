package com.madd.madd.twitterapp.ui.TweetSearch;

import com.madd.madd.twitterapp.data.entities.Tweet.TweetDataSource;

import dagger.Module;
import dagger.Provides;

@Module
public class TweetSearchModule {

    @Provides
    TweetSearchContract.Presenter providePresenter(TweetDataSource.Repository repository){
        return new TweetSearchPresenter(repository);
    }


}
