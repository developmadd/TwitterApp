package com.madd.madd.twitterapp.UI.Fragments.TweetDetail;

import com.madd.madd.twitterapp.HTTP.Models.Tweet;

public class TweetDetailPresenter implements TweetDetailContract.Presenter {

    private TweetDetailContract.View view;

    TweetDetailPresenter() {

    }

    @Override
    public void setView(TweetDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void showEntity(Tweet tweet) {
        view.showLoadingProgress();
        view.showEntity(tweet);
        view.hideLoadingProgress();
    }


}
