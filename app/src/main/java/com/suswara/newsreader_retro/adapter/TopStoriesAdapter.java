package com.suswara.newsreader_retro.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.suswara.newsreader_retro.R;
import com.suswara.newsreader_retro.beans.TS_Result;

import java.util.List;

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.StoryViewHolder> {

    private List<TS_Result> stories;
    private int rowLayout;
    private Context context;


    public static class StoryViewHolder extends RecyclerView.ViewHolder {
        LinearLayout storyLayout;
        TextView movieTitle;
        TextView data;
        TextView rating;


        public StoryViewHolder(View v) {
            super(v);
            storyLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
        }
    }

    public TopStoriesAdapter(List<TS_Result> stories, int rowLayout, Context context) {
        this.stories = stories;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public StoryViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new StoryViewHolder(view);
    }


    @Override
    public void onBindViewHolder(StoryViewHolder holder, final int position) {
        holder.movieTitle.setText(stories.get(position).getTitle());
        holder.data.setText(stories.get(position).getByline());
        holder.rating.setText(stories.get(position).getPublishedDate());
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }
}