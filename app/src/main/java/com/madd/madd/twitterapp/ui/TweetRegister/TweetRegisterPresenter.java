package com.madd.madd.twitterapp.ui.TweetRegister;

import android.graphics.Color;

import com.madd.madd.twitterapp.data.entities.DataSource;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;
import com.madd.madd.twitterapp.data.entities.Tweet.TweetDataSource;
import com.madd.madd.twitterapp.data.entities.User.Model.User;
import com.madd.madd.twitterapp.data.entities.User.UserDataSource;

public class TweetRegisterPresenter implements TweetRegisterContract.Presenter {

    private TweetRegisterContract.View view;
    private TweetDataSource.Repository tweetRepository;
    private UserDataSource.Repository userRepository;

    TweetRegisterPresenter(TweetDataSource.Repository tweetRepository,
                           UserDataSource.Repository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void setView(TweetRegisterContract.View view) {
        this.view = view;
    }

    @Override
    public void getUser() {
        view.showLoadingProgress();
        userRepository.getUser(new DataSource.GetEntity<User>() {
            @Override
            public void onSuccess(User entity) {
                view.showUser(entity);
                view.hideLoadingProgress();
            }

            @Override
            public void onError(String error) {
                view.showUserError();
                view.hideLoadingProgress();
            }
        });

    }

    @Override
    public boolean validateTextField() {
        if( view.getTextField().length() > 140 || view.getTextField().isEmpty()){
            view.showTextFieldMessage("Caracteres: " + view.getTextField().length() +"/140",Color.RED);
            return false;
        } else {
            view.showTextFieldMessage("Caracteres: " + view.getTextField().length() +"/140",Color.BLACK);
            return true;
        }
    }

    @Override
    public void register() {

        if(formValidation()) {
            view.showLoadingProgress();
            view.disableForm();
            tweetRepository.register(view.getTextField(), new DataSource.GetEntity<Tweet>() {
                @Override
                public void onSuccess(Tweet entity) {
                    view.showRegisterSuccess(entity);
                    view.hideLoadingProgress();
                    view.enableForm();
                }

                @Override
                public void onError(String error) {
                    view.showRegisterError();
                    view.hideLoadingProgress();
                    view.enableForm();
                }
            });
        }
    }


    private boolean formValidation(){
        boolean validForm = true;
        if( !validateTextField() ){
            validForm = false;
        }
        return validForm;


    }
}
