package com.madd.madd.twitterapp.UI.Fragments.UserProfile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.madd.madd.twitterapp.HTTP.Models.Tweet;
import com.madd.madd.twitterapp.R;
import com.madd.madd.twitterapp.Utils.Utilities;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder> {

    private List<Tweet> list = new ArrayList<>();

    private AdapterEvents adapterEvents;

    public TweetAdapter(AdapterEvents adapterEvents) {
        this.adapterEvents = adapterEvents;
    }


    public List<Tweet> getList() {
        return list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_tweeter, parent, false);
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
        @BindView(R.id.textViewName) TextView textViewName;
        @BindView(R.id.textViewDate) TextView textViewDate;
        @BindView(R.id.textViewDescription) TextView textViewDescription;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        void bind(Tweet entity){

            Utilities.setImage(imageView,entity.user.photo);
            textViewName.setText(entity.user.name);
            textViewDescription.setText(entity.description);
            textViewDate.setText(entity.date);


            itemView.setOnClickListener(view ->
                adapterEvents.onElementClick(entity)
            );

        }
    }

    public interface AdapterEvents{
        void onElementClick(Tweet entity);
    }

}
