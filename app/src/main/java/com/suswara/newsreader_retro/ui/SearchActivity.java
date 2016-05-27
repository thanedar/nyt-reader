package com.suswara.newsreader_retro.ui;

import android.app.FragmentManager;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.suswara.newsreader_retro.R;

public class SearchActivity extends AppCompatActivity {

    private static final String TAG = ListingFragment.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction ft;
            ft = fragmentManager.beginTransaction();
            ft.replace(R.id.search_container, SearchFragment.newInstance(query), SearchFragment.TAG);
            ft.commit();

        }
    }


}
