package com.suswara.newsreader_retro.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.suswara.newsreader_retro.R;
import com.suswara.newsreader_retro.beans.AS_Doc;
import com.suswara.newsreader_retro.beans.StoryDetail;
import com.suswara.newsreader_retro.beans.TS_Result;
import com.suswara.newsreader_retro.ui.StoryActivity;

import java.util.List;

public class ArticleListingAdapter extends RecyclerView.Adapter<ArticleListingAdapter.StoryViewHolder> {

    private List<AS_Doc> stories;
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

    public ArticleListingAdapter(List<AS_Doc> stories, int rowLayout, Context context) {
        this.stories = stories;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public StoryViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        final Context mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        final StoryViewHolder viewHolder = new StoryViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                Log.i("StoryViewHolder", "Click detected at position " + position );
                AS_Doc story = stories.get(position);
                Log.i("StoryViewHolder", "story at position " + story.toString());
                Intent intent = new Intent(mContext, StoryActivity.class);
                StoryDetail storyDetail = new StoryDetail();
                storyDetail.setTitle(story.getHeadline().toString());
                intent.putExtra(StoryActivity.EXTRA_STORY, storyDetail);
                mContext.startActivity(intent);

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StoryViewHolder holder, final int position) {
        if (getItemCount() >= 0) {
            holder.storyTitle.setText(stories.get(position).getHeadline().toString());
            holder.storySubtitle.setText(stories.get(position).getSnippet());
            //holder.thumbnail.setText(stories.get(position).getPublishedDate());
        }
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }
}