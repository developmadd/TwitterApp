package com.madd.madd.twitterapp.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
class AppModule {

    private App app;
    AppModule(App app) {
        this.app = app;
    }

    @Provides
    Context provideContext(){
        return app;
    }

}
