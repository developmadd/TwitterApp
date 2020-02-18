package com.madd.madd.twitterapp.UI.Fragments.TweetRegister;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.madd.madd.twitterapp.DI.App;
import com.madd.madd.twitterapp.HTTP.Models.Tweet;
import com.madd.madd.twitterapp.HTTP.Models.User;
import com.madd.madd.twitterapp.R;
import com.madd.madd.twitterapp.Utils.Utilities;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TweetRegisterFragment extends Fragment implements TweetRegisterContract.View {

    @Inject TweetRegisterContract.Presenter presenter;

    @BindView(R.id.progressBar) ProgressBar progressBar;
    @BindView(R.id.editText) EditText editText;
    @BindView(R.id.imageView) ImageView imageView;
    @BindView(R.id.textViewName) TextView textViewName;
    @BindView(R.id.textViewCounter) TextView textViewCounter;
    @BindView(R.id.button) Button button;

    public TweetRegisterContract.View.RegisterEvents registerEvents;


    public TweetRegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tweteer_register, container, false);
        ((App)getActivity().getApplication()).getComponent().inject(this);
        ButterKnife.bind(this,v);

        loadView();

        presenter.setView(this);
        presenter.getUser();

        return v;
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
        Toast.makeText(getContext(),"Tweet registrado correctamente",Toast.LENGTH_LONG).show();
        registerEvents.entityRegistered(entity);
        getFragmentManager().popBackStack();
    }

    @Override
    public void showRegisterError() {
        Toast.makeText(getContext(),"Error registrando tweet, intente más tarde",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUserError() {
        Toast.makeText(getContext(),"Error cargando el usuario",Toast.LENGTH_LONG).show();
        getFragmentManager().popBackStack();
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
