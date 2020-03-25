package com.madd.madd.twitterapp.ui.TweetDetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.madd.madd.twitterapp.R;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;
import com.madd.madd.twitterapp.di.App;
import com.madd.madd.twitterapp.utils.Utilities;

import javax.inject.Inject;

public class TweetDetailActivity extends AppCompatActivity implements TweetDetailContract.View {

    @Inject    TweetDetailContract.Presenter presenter;

    private PhotoAdapter adapter;

    @BindView(R.id.progressBar)    ProgressBar progressBar;
    @BindView(R.id.imageView)    ImageView imageView;
    @BindView(R.id.textViewName)    TextView textViewName;
    @BindView(R.id.textViewDate) TextView textViewDate;
    @BindView(R.id.textViewDescription) TextView textViewDescription;
    @BindView(R.id.recyclerView)    RecyclerView recyclerView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_detail);

        ((App)getApplication()).getComponent().inject(this);
        ButterKnife.bind(this);

        loadView();

        Tweet tweet = (Tweet) getIntent().getSerializableExtra("tweet");

        presenter.setView(this);
        presenter.getEntity(tweet);
    }


    private void loadView(){

        adapter = new PhotoAdapter();
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

    }



    @Override
    public void showEntity(Tweet entity) {

        Utilities.setImage(imageView,entity.user.photo);
        textViewName.setText(entity.user.name);
        textViewDescription.setText(entity.description);
        textViewDate.setText(entity.date);

        if ( entity.entities.media != null) {
            for (Tweet.Entity.Media media : entity.entities.media) {
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
