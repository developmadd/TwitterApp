package com.madd.madd.twitterapp.UI.Fragments.TweetRegister;

import com.madd.madd.twitterapp.HTTP.Models.Tweet;
import com.madd.madd.twitterapp.HTTP.Models.TweetPost;
import com.madd.madd.twitterapp.HTTP.Models.User;

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

        interface RegisterEvents{
            void entityRegistered(Tweet entity);
        }

    }

    interface Presenter{
        void setView(View view);

        void getUser();
        boolean validateTextField();
        void register();
    }

    interface Model{

        void register(TweetPost entity, GetEntity getEntity);
        void getUser(GetUser getUser);

        interface GetEntity{
            void onSuccess(Tweet entity);
            void onError(String error);
        }
        interface GetUser{
            void onSuccess(User entity);
            void onError(String error);
        }

    }
}
