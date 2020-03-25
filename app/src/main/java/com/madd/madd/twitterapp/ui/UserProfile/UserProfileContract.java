package com.madd.madd.twitterapp.ui.UserProfile;


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


}
