package com.madd.madd.twitterapp.ui.Fragments.TweetSearch;

import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;

import java.util.List;

public class TweetSearchPresenter implements TweetSearchContract.Presenter {

    private TweetSearchContract.View view;
    private TweetSearchContract.Model model;

    TweetSearchPresenter(TweetSearchContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(TweetSearchContract.View view) {
        this.view = view;
    }

    @Override
    public void clearList() {
        view.clearList();
    }

    @Override
    public void requestList(String query) {
        view.showLoadingProgress();
        model.getList(query, new TweetSearchContract.Model.GetList() {
            @Override
            public void onSuccess(List<Tweet> list) {

                if( list.isEmpty() ){
                    view.showEmptyListError();
                } else {
                    view.showList(list);
                }
                view.hideLoadingProgress();
            }

            @Override
            public void onError(String error) {
                view.hideLoadingProgress();
                view.showInternetError();
            }
        });
    }


}
