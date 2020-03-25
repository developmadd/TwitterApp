package com.madd.madd.twitterapp.ui.TweetRegister;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.madd.madd.twitterapp.R;
import com.madd.madd.twitterapp.data.entities.Tweet.Model.Tweet;
import com.madd.madd.twitterapp.data.entities.User.Model.User;
import com.madd.madd.twitterapp.di.App;
import com.madd.madd.twitterapp.utils.Utilities;

import javax.inject.Inject;

public class TweetRegisterActivity extends AppCompatActivity implements TweetRegisterContract.View{


    public final static int REGISTER_TWEET = 0;
    public final static int TWEET_REGISTERED = 1;

    @Inject
    TweetRegisterContract.Presenter presenter;

    @BindView(R.id.progressBar)    ProgressBar progressBar;
    @BindView(R.id.editText)    EditText editText;
    @BindView(R.id.imageView)    ImageView imageView;
    @BindView(R.id.textViewName)    TextView textViewName;
    @BindView(R.id.textViewCounter) TextView textViewCounter;
    @BindView(R.id.button)    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_register);
        ((App)getApplication()).getComponent().inject(this);
        ButterKnife.bind(this);

        loadView();

        presenter.setView(this);
        presenter.getUser();
    }


    private void loadView(){

        button.setOnClickListener(view -> {
            presenter.register();
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.validateTextField();
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });

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
    public void showRegisterSuccess(Tweet entity) {
        Toast.makeText(this,"Tweet registrado correctamente",Toast.LENGTH_LONG).show();
        setResult(TWEET_REGISTERED);
        finish();
    }

    @Override
    public void showRegisterError() {
        Toast.makeText(this,"Error registrando tweet, intente más tarde",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUserError() {
        Toast.makeText(this,"Error cargando el usuario",Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void showTextFieldMessage(String message, int color) {
        textViewCounter.setText(message);
        textViewCounter.setTextColor(color);
    }

    @Override
    public String getTextField() {
        return editText.getText().toString();
    }

    @Override
    public void showUser(User user) {
        Utilities.setImage(imageView,user.photo);
        textViewName.setText(user.name);
    }


    @Override
    public void disableForm() {
        button.setEnabled(false);
    }

    @Override
    public void enableForm() {
        button.setEnabled(true);
    }




}
