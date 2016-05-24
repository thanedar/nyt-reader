package com.suswara.newsreader_retro.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.suswara.newsreader_retro.R;
import com.suswara.newsreader_retro.beans.TS_Result;

import java.util.List;

public class StoryListingAdapter extends RecyclerView.Adapter<StoryListingAdapter.StoryViewHolder> {

    private List<TS_Result> stories;
    private int rowLayout;
    private Context context;


    public static class StoryViewHolder extends RecyclerView.ViewHolder {
        LinearLayout storyLayout;
        TextView storyTitle;
        TextView storySubtitle;
        TextView thumbnail;

        public StoryViewHolder(View v) {
            super(v);
            storyLayout = (LinearLayout) v.findViewById(R.id.stories_layout);
            storyTitle = (TextView) v.findViewById(R.id.title);
            storySubtitle = (TextView) v.findViewById(R.id.subtitle);
        }
    }

    public StoryListingAdapter(List<TS_Result> stories, int rowLayout, Context context) {
        this.stories = stories;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public StoryViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        final StoryViewHolder viewHolder = new StoryViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                Log.i("StoryViewHolder", "Click detected at position " + position );
                Log.i("StoryViewHolder", "story at position " + stories.get(position).toString() );
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StoryViewHolder holder, final int position) {
        if (getItemCount() >= 0) {
            holder.storyTitle.setText(stories.get(position).getTitle());
            holder.storySubtitle.setText(stories.get(position).getByline());
            //holder.thumbnail.setText(stories.get(position).getPublishedDate());
        }
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }
}