package com.madd.madd.twitterapp.ui.UserProfile;

import com.madd.madd.twitterapp.data.entities.DataSource;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;
import com.madd.madd.twitterapp.data.entities.Tweet.TweetDataSource;
import com.madd.madd.twitterapp.data.entities.User.Model.User;
import com.madd.madd.twitterapp.data.entities.User.UserDataSource;

import java.util.List;

public class UserProfilePresenter implements UserProfileContract.Presenter {

    private UserProfileContract.View view;
    private TweetDataSource.Repository tweetRepository;
    private UserDataSource.Repository userRepository;

    UserProfilePresenter(TweetDataSource.Repository tweetRepository,
                         UserDataSource.Repository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void setView(UserProfileContract.View view) {
        this.view = view;
    }

    @Override
    public void getEntity() {
        view.showLoadingProgress();
        userRepository.getUser(new DataSource.GetEntity<User>() {
            @Override
            public void onSuccess(User user) {
                view.showEntity(user);
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
        tweetRepository.getTweetListByUser(new DataSource.GetList<Tweet>() {
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
