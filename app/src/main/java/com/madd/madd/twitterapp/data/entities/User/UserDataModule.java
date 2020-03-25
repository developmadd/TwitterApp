package com.madd.madd.twitterapp.data.entities.User;

import com.madd.madd.twitterapp.data.entities.User.Source.Local.UserCacheDataSource;
import com.madd.madd.twitterapp.data.entities.User.Source.Remote.UserRemoteDataSource;
import com.madd.madd.twitterapp.data.http.TwitterAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserDataModule {

    @Provides
    public UserDataSource.Repository provideUserRepository(
            UserDataSource.Remote remote,
            UserDataSource.Cache cache){
        return new UserRepository(remote,cache);
    }

    @Singleton
    @Provides
    public UserDataSource.Remote provideUserRemoteDataSource(TwitterAPI twitterApi){
        return new UserRemoteDataSource(twitterApi);
    }

    @Singleton
    @Provides
    public UserDataSource.Cache provideUserCacheDataSource(){
        return new UserCacheDataSource();
    }
}
