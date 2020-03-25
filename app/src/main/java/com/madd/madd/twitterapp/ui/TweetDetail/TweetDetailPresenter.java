package com.madd.madd.twitterapp.ui.TweetDetail;

import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;

public class TweetDetailPresenter implements TweetDetailContract.Presenter {

    private TweetDetailContract.View view;

    TweetDetailPresenter() {

    }

    @Override
    public void setView(TweetDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void getEntity(Tweet entity) {
        view.showLoadingProgress();
        view.showEntity(entity);
        view.hideLoadingProgress();
    }




}
