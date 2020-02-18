package com.madd.madd.twitterapp.UI.Fragments.TweetRegister;

import android.graphics.Color;

import com.madd.madd.twitterapp.HTTP.Models.Tweet;
import com.madd.madd.twitterapp.HTTP.Models.TweetPost;
import com.madd.madd.twitterapp.HTTP.Models.User;

public class TweetRegisterPresenter implements TweetRegisterContract.Presenter {

    private TweetRegisterContract.View view;
    private TweetRegisterContract.Model model;

    TweetRegisterPresenter(TweetRegisterContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(TweetRegisterContract.View view) {
        this.view = view;
    }

    @Override
    public void getUser() {
        view.showLoadingProgress();
        model.getUser(new TweetRegisterContract.Model.GetUser() {
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
            TweetPost tweet = new TweetPost();
            tweet.status = view.getTextField();
            model.register(tweet, new TweetRegisterContract.Model.GetEntity() {
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
