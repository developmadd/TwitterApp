package com.madd.madd.twitterapp.data.entities.User;

import com.madd.madd.twitterapp.data.entities.DataSource;
import com.madd.madd.twitterapp.data.entities.User.Model.User;

public interface UserDataSource {

    interface Repository{
        void getUser(DataSource.GetEntity<User> getUser);
    }
    interface Remote{
        void getUser(DataSource.GetEntity<User> getUser);
    }
    interface Cache{
        void getUser(DataSource.GetEntity<User> getUser);
        void setUser(User user);
    }



}
