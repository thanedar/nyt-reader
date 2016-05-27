package com.suswara.newsreader_retro.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.suswara.newsreader_retro.R;
import com.suswara.newsreader_retro.beans.StoryDetail;

public class StoryActivity extends AppCompatActivity {
    public static final String EXTRA_STORY = "story";

    ImageView backdrop;
    ImageView image;
    TextView byline;
    TextView snippet;

    StoryDetail storyDetail;
    String imageString = "";
    String backdropString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_STORY)) {
            storyDetail = (StoryDetail) intent.getSerializableExtra(EXTRA_STORY);
        } else {
            throw new IllegalArgumentException("Detail activity must receive a story parcelable");
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        //toolbarLayout.setTitle(storyDetail.getTitle());

        Log.i("StoryDetail", storyDetail.toString());

        backdrop = (ImageView) findViewById(R.id.backdrop);
        byline = (TextView) findViewById(R.id.story_byline);
        snippet = (TextView) findViewById(R.id.story_snippet);
        image = (ImageView) findViewById(R.id.story_image);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle(storyDetail.getTitle());

        snippet.setText(storyDetail.getSnippet());
        byline.setText(storyDetail.getByline());

        if(imageString != "") {
            Picasso.with(this)
                    .load(imageString)
                    .into(image);
        }
        else {
            Picasso.with(this)
                    .load(R.drawable.article_image)
                    .into(image);
        }

        if(backdropString != "") {
            Picasso.with(this)
                    .load(backdropString)
                    .into(backdrop);
        }
        else {
            Picasso.with(this)
                    .load(R.drawable.ic_arts)
                    .into(backdrop);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
