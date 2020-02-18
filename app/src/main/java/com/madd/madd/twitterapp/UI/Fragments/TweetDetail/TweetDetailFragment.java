package com.madd.madd.twitterapp.UI.Fragments.TweetDetail;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.madd.madd.twitterapp.DI.App;
import com.madd.madd.twitterapp.HTTP.Models.Tweet;
import com.madd.madd.twitterapp.R;
import com.madd.madd.twitterapp.Utils.Utilities;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TweetDetailFragment extends Fragment implements TweetDetailContract.View {


    @Inject TweetDetailContract.Presenter presenter;


    private PhotoAdapter adapter;

    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.imageView) ImageView imageView;
    @BindView(R.id.textViewName) TextView textViewName;
    @BindView(R.id.textViewDate) TextView textViewDate;
    @BindView(R.id.textViewDescription) TextView textViewDescription;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    public Tweet tweet;


    public TweetDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tweteer_detail, container, false);
        ((App)getActivity().getApplication()).getComponent().inject(this);
        ButterKnife.bind(this,v);

        loadView();

        presenter.setView(this);
        presenter.showEntity(tweet);

        return v;
    }



    private void loadView(){

        adapter = new PhotoAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));

    }



    @Override
    public void showEntity(Tweet entity) {

        Utilities.setImage(imageView,entity.user.photo);
        textViewName.setText(entity.user.name);
        textViewDescription.setText(entity.description);
        textViewDate.setText(entity.date);

        if ( tweet.entities.media != null) {
            for (Tweet.Entity.Media media : tweet.entities.media) {
                adapter.getList().add(media.photo);
            }
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void showLoadingProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingProgress() {
        progressBar.setVisibility(View.GONE);
    }


}
