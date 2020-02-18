package com.madd.madd.twitterapp.UI.Fragments.UserProfile;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.madd.madd.twitterapp.DI.App;
import com.madd.madd.twitterapp.HTTP.Models.Tweet;
import com.madd.madd.twitterapp.HTTP.Models.User;
import com.madd.madd.twitterapp.R;
import com.madd.madd.twitterapp.UI.Fragments.TweetDetail.TweetDetailFragment;
import com.madd.madd.twitterapp.UI.Fragments.TweetRegister.TweetRegisterFragment;
import com.madd.madd.twitterapp.UI.Fragments.TweetSearch.TweetSearchFragment;
import com.madd.madd.twitterapp.Utils.Utilities;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserProfileFragment extends Fragment implements UserProfileContract.View {


    @Inject
    UserProfileContract.Presenter presenter;

    private TweetAdapter tweetAdapter;
    @BindView(R.id.recyclerView)RecyclerView recyclerView;
    @BindView(R.id.buttonNew)Button buttonNew;
    @BindView(R.id.buttonSearch)Button buttonSearch;
    @BindView(R.id.imageView)ImageView imageView;
    @BindView(R.id.imageViewBack)ImageView imageViewBack;
    @BindView(R.id.textViewName)TextView textViewName;
    @BindView(R.id.textViewDescription)TextView textViewDescription;
    @BindView(R.id.progressBar) ProgressBar progressBar;

    public UserProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user_profile, container, false);
        ((App)getActivity().getApplication()).getComponent().inject(this);
        ButterKnife.bind(this,v);

        loadView();
        presenter.setView(this);
        presenter.getEntity();
        presenter.getList();

        return v;
    }


    private void loadView(){
        tweetAdapter = new TweetAdapter(entity -> {
            TweetDetailFragment tweetDetailFragment = new TweetDetailFragment();
            tweetDetailFragment.tweet = entity;
            Utilities.openFragment(getFragmentManager(), tweetDetailFragment);
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(tweetAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        buttonNew.setOnClickListener(view -> {
            TweetRegisterFragment tweetRegisterFragment = new TweetRegisterFragment();
            tweetRegisterFragment.registerEvents = (entity -> presenter.getList());
            Utilities.openFragment(getFragmentManager(), tweetRegisterFragment);
        });

        buttonSearch.setOnClickListener(view -> {
            TweetSearchFragment tweetSearchFragment = new TweetSearchFragment();
            Utilities.openFragment(getFragmentManager(), tweetSearchFragment);
        });
    }


    @Override
    public void showEntity(User entity) {
        Utilities.setImage(imageView,entity.photo);
        Utilities.setImage(imageViewBack,entity.backPhoto);
        textViewName.setText(entity.name);
        textViewDescription.setText(entity.description);
    }

    @Override
    public void showList( List<Tweet> list) {
        tweetAdapter.getList().addAll(list);
        tweetAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoadingProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showEntityError() {
        Toast.makeText(getContext(),"Error obteniendo la entidad",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showListError() {
        Toast.makeText(getContext(),"Error obteniendo la lista",Toast.LENGTH_LONG).show();
    }


}
