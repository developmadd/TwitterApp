package com.madd.madd.twitterapp.ui.TweetSearch;


import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;

import java.util.List;

public interface TweetSearchContract {

    interface View{

        void showList(List<Tweet> list);

        void showLoadingProgress();
        void hideLoadingProgress();
        void showEmptyListError();
        void clearList();
        void showInternetError();

        List<Tweet> getList();
    }

    interface Presenter{
        void setView(View view);

        void clearList();
        void requestList(String query);
    }


}
