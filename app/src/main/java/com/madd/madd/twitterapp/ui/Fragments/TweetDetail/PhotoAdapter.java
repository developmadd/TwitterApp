package com.madd.madd.twitterapp.ui.Fragments.TweetDetail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.madd.madd.twitterapp.R;
import com.madd.madd.twitterapp.utils.Utilities;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private List<String> list = new ArrayList<>();


    PhotoAdapter() {

    }


    public List<String> getList() {
        return list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_photo, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView) ImageView imageView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        void bind(String entity){
            Utilities.setImage(imageView,entity);
        }
    }



}
