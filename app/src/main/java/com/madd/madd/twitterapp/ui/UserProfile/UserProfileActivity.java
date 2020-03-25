package com.madd.madd.twitterapp.ui.UserProfile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.madd.madd.twitterapp.R;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;
import com.madd.madd.twitterapp.data.entities.User.Model.User;
import com.madd.madd.twitterapp.di.App;
import com.madd.madd.twitterapp.ui.TweetDetail.TweetDetailActivity;
import com.madd.madd.twitterapp.ui.TweetRegister.TweetRegisterActivity;
import com.madd.madd.twitterapp.ui.TweetSearch.TweetSearchActivity;
import com.madd.madd.twitterapp.utils.Utilities;

import java.util.List;

import javax.inject.Inject;

public class UserProfileActivity extends AppCompatActivity implements UserProfileContract.View {

    @Inject
    UserProfileContract.Presenter presenter;

    private TweetAdapter tweetAdapter;
    @BindView(R.id.recyclerView)    RecyclerView recyclerView;
    @BindView(R.id.buttonNew)    Button buttonNew;
    @BindView(R.id.buttonSearch)Button buttonSearch;
    @BindView(R.id.imageView)    ImageView imageView;
    @BindView(R.id.imageViewBack)ImageView imageViewBack;
    @BindView(R.id.textViewName)    TextView textViewName;
    @BindView(R.id.textViewDescription)TextView textViewDescription;
    @BindView(R.id.progressBar)    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App)getApplication()).getComponent().inject(this);
        ButterKnife.bind(this);

        loadView();
        presenter.setView(this);
        presenter.getEntity();
        presenter.getList();
    }

    private void loadView(){
        tweetAdapter = new TweetAdapter(entity -> {
            Intent intent = new Intent();
            intent.setClass(this, TweetDetailActivity.class);
            intent.putExtra("tweet",entity);
            startActivity(intent);
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(tweetAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonNew.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(this, TweetRegisterActivity.class);
            startActivityForResult(intent,TweetRegisterActivity.REGISTER_TWEET);
        });

        buttonSearch.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(this, TweetSearchActivity.class);
            startActivity(intent);
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
        Toast.makeText(this,"Error obteniendo la entidad",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showListError() {
        Toast.makeText(this,"Error obteniendo la lista",Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == TweetRegisterActivity.REGISTER_TWEET &&
                resultCode == TweetRegisterActivity.TWEET_REGISTERED ){
            tweetAdapter.getList().clear();
            presenter.getList();
        }
    }
}
