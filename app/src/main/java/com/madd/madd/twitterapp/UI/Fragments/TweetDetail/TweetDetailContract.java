package com.madd.madd.twitterapp.UI.Fragments.TweetDetail;

import com.madd.madd.twitterapp.HTTP.Models.Tweet;

public interface TweetDetailContract {

    interface View{

        void showEntity(Tweet entity);

        void showLoadingProgress();
        void hideLoadingProgress();

    }

    interface Presenter{
        void setView(View view);

        void showEntity(Tweet tweet);
    }


}
