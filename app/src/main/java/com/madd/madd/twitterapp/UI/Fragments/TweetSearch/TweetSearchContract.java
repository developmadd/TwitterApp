package com.madd.madd.twitterapp.UI.Fragments.TweetSearch;


import com.madd.madd.twitterapp.HTTP.Models.Tweet;

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

    interface Model{

        void getList(String query, GetList getList);

        interface GetList{
            void onSuccess(List<Tweet> list);
            void onError(String error);
        }
    }

}
