package com.madd.madd.twitterapp.Utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.madd.madd.twitterapp.R;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Utilities {

    public static void setImage(ImageView imageView, String url){
        Glide.with(imageView.getContext())
                .load(url)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }

    public static void openFragment(FragmentManager fragmentManager, Fragment fragment){
        fragmentManager.beginTransaction()
                .add(R.id.CTNR_Main,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }
}
