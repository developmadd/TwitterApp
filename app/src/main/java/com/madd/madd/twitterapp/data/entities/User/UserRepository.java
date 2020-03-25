package com.madd.madd.twitterapp.data.entities.User;

import com.madd.madd.twitterapp.data.entities.DataSource;
import com.madd.madd.twitterapp.data.entities.User.Model.User;

public class UserRepository implements UserDataSource.Repository{

    private UserDataSource.Remote remote;
    private UserDataSource.Cache cache;

    UserRepository(UserDataSource.Remote remote, UserDataSource.Cache cache) {
        this.remote = remote;
        this.cache = cache;
    }


    @Override
    public void getUser(DataSource.GetEntity<User> getUser) {
        cache.getUser(new DataSource.GetEntity<User>() {
            @Override
            public void onSuccess(User user) {
                getUser.onSuccess(user);
            }

            @Override
            public void onError(String error) {
                remote.getUser(new DataSource.GetEntity<User>() {
                    @Override
                    public void onSuccess(User user) {
                        getUser.onSuccess(user);
                        cache.setUser(user);
                    }

                    @Override
                    public void onError(String error) {
                        getUser.onError(error);
                    }
                });
            }
        });
    }
}
