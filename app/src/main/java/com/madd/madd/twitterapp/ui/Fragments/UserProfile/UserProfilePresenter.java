package com.madd.madd.twitterapp.ui.Fragments.UserProfile;

import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;
import com.madd.madd.twitterapp.data.entities.User.Model.User;

import java.util.List;

public class UserProfilePresenter implements UserProfileContract.Presenter {

    private UserProfileContract.View view;
    private UserProfileContract.Model model;

    UserProfilePresenter(UserProfileContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(UserProfileContract.View view) {
        this.view = view;
    }

    @Override
    public void getEntity() {
        view.showLoadingProgress();
        model.getEntity(new UserProfileContract.Model.GetEntity() {
            @Override
            public void onSuccess(User entity) {
                view.showEntity(entity);
                view.hideLoadingProgress();
            }

            @Override
            public void onError(String error) {
                view.showEntityError();
                view.hideLoadingProgress();
            }
        });
    }

    @Override
    public void getList() {
        view.showLoadingProgress();
        model.getList(new UserProfileContract.Model.GetList() {
            @Override
            public void onSuccess(List<Tweet> list) {
                if(!list.isEmpty()) {
                    view.showList(list);
                } else{
                    view.showListError();
                }
                view.hideLoadingProgress();

            }

            @Override
            public void onError(String error) {
                view.hideLoadingProgress();
                view.showListError();
            }
        });
    }
}
