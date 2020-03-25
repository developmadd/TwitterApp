package com.madd.madd.twitterapp.ui.TweetRegister;

import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;
import com.madd.madd.twitterapp.data.entities.User.Model.User;

public interface TweetRegisterContract {

    interface View{

        void showLoadingProgress();
        void hideLoadingProgress();
        void disableForm();
        void enableForm();

        void showRegisterSuccess(Tweet entity);
        void showRegisterError();
        void showUserError();

        void showTextFieldMessage(String error,int color);
        String getTextField();

        void showUser(User user);


    }

    interface Presenter{
        void setView(View view);

        void getUser();
        boolean validateTextField();
        void register();
    }


}
