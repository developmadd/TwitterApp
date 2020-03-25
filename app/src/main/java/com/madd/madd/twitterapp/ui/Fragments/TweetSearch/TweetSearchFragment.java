package com.madd.madd.twitterapp.ui.Fragments.TweetSearch;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.madd.madd.twitterapp.di.App;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;
import com.madd.madd.twitterapp.R;
import com.madd.madd.twitterapp.ui.Fragments.TweetDetail.TweetDetailActivity;
import com.madd.madd.twitterapp.ui.Fragments.UserProfile.TweetAdapter;
import com.madd.madd.twitterapp.utils.Utilities;

import java.util.List;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TweetSearchFragment extends Fragment implements TweetSearchContract.View {

    @Inject
    TweetSearchContract.Presenter presenter;

    private TweetAdapter adapter;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.searchView) SearchView searchView;
    @BindView(R.id.progressBar) ProgressBar progressBar;

    public TweetSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tweteer_search, container, false);
        ((App)getActivity().getApplication()).getComponent().inject(this);
        ButterKnife.bind(this,v);
        loadView();

        presenter.setView(this);

        return v;
    }



    private CountDownTimer countDownTimer;
    private void loadView(){
        adapter = new TweetAdapter(entity -> {
            /*Intent intent = new Intent();
            intent.setClass(this, TweetDetailActivity.class);
            intent.putExtra("tweet",entity);
            startActivity(intent);*/
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                countDownTimer = new CountDownTimer(400, 100) {
                    public void onTick(long millisUntilFinished) {}
                    public void onFinish() {
                        presenter.clearList();
                        presenter.requestList(searchView.getQuery().toString());
                    }
                }.start();

                return false;
            }
        });

    }

    @Override
    public void showList(List<Tweet> list) {
        adapter.getList().addAll(list);
        adapter.notifyDataSetChanged();
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
    public void showEmptyListError() {
        Toast.makeText(getContext(),"Lista vacia",Toast.LENGTH_LONG).show();
    }

    @Override
    public void clearList() {
        adapter.getList().clear();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showInternetError() {
        Toast.makeText(getContext(),"Sin internet",Toast.LENGTH_LONG).show();
    }



    @Override
    public List<Tweet> getList() {
        return adapter.getList();
    }
}
