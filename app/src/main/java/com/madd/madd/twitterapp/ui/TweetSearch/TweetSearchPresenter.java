package com.madd.madd.twitterapp.ui.TweetSearch;

import com.madd.madd.twitterapp.data.entities.DataSource;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;
import com.madd.madd.twitterapp.data.entities.Tweet.TweetDataSource;

import java.util.List;

public class TweetSearchPresenter implements TweetSearchContract.Presenter {

    private TweetSearchContract.View view;
    private TweetDataSource.Repository repository;

    TweetSearchPresenter(TweetDataSource.Repository repository) {
        this.repository = repository;
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
        repository.getTweetListByQuery(query, new DataSource.GetList<Tweet>() {
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
