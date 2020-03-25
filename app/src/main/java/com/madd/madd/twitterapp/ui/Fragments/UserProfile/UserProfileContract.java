package com.madd.madd.twitterapp.ui.Fragments.UserProfile;


import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;
import com.madd.madd.twitterapp.data.entities.User.Model.User;

import java.util.List;

public interface UserProfileContract {

    interface View{

        void showEntity(User entity);
        void showList(List<Tweet> list);

        void showLoadingProgress();
        void hideLoadingProgress();
        void showEntityError();
        void showListError();
    }

    interface Presenter{
        void setView(View view);

        void getEntity();
        void getList();
    }

    interface Model{

        void getEntity(GetEntity getEntity);
        void getList(GetList getList);


        interface GetEntity{
            void onSuccess(User entity);
            void onError(String error);
        }
        interface GetList{
            void onSuccess(List<Tweet> list);
            void onError(String error);
        }
    }
}
