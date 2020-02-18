package com.madd.madd.twitterapp.UI.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.madd.madd.twitterapp.R;
import com.madd.madd.twitterapp.UI.Fragments.UserProfile.UserProfileFragment;

public class MainActivity extends AppCompatActivity {

    UserProfileFragment userProfileFragment = new UserProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.CTNR_Main,userProfileFragment)
                .addToBackStack(null)
                .commit();

    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }
}
