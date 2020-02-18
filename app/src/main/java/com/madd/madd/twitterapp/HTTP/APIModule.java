package com.madd.madd.twitterapp.HTTP;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class APIModule {

    private static String BASE_URL = "https://wizetwitterproxy.herokuapp.com";

    @Provides
    Retrofit provideRetrofit(String baseURL){
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    API provideAPI(){
        return provideRetrofit(BASE_URL).create(API.class);
    }


}
