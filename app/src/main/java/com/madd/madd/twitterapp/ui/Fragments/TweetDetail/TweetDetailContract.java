package com.madd.madd.twitterapp.ui.Fragments.TweetDetail;

import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;

public interface TweetDetailContract {

    interface View{

        void showEntity(Tweet entity);

        void showLoadingProgress();
        void hideLoadingProgress();

    }

    interface Presenter{
        void setView(View view);

        void getEntity(Tweet entity);
    }



}
