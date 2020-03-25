package com.madd.madd.twitterapp.data.entities.User.Source.Local;


import com.madd.madd.twitterapp.data.entities.DataSource;
import com.madd.madd.twitterapp.data.entities.User.Model.User;
import com.madd.madd.twitterapp.data.entities.User.UserDataSource;

public class UserCacheDataSource implements UserDataSource.Cache {

    private User user;
    private long timeStamp;
    private long CACHE_LIFETIME = 1000 * 60;


    @Override
    public void getUser(DataSource.GetEntity<User> getUser) {
        if( user != null ){
            if( System.currentTimeMillis() - timeStamp < CACHE_LIFETIME ){
                getUser.onSuccess(user);
                return;
            } else {
                user = null;
            }
        }
        getUser.onError("EMPTY");
    }

    @Override
    public void setUser(User user) {
        timeStamp = System.currentTimeMillis();
        this.user = user;
    }
}
