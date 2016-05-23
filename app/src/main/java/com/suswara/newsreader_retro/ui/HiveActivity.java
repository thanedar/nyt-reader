package com.suswara.newsreader_retro.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.suswara.newsreader_retro.R;
import com.suswara.newsreader_retro.adapter.MoviesAdapter;
import com.suswara.newsreader_retro.adapter.TopStoriesAdapter;
import com.suswara.newsreader_retro.beans.Movie;
import com.suswara.newsreader_retro.beans.MoviesResponse;
import com.suswara.newsreader_retro.beans.TS_Result;
import com.suswara.newsreader_retro.beans.TopStories;
import com.suswara.newsreader_retro.rest.ApiClient;
import com.suswara.newsreader_retro.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HiveActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "340fe1949bbc2b893c4a336bb072412a:18:74255139";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hive);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
            return;
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<TopStories> call = apiService.getTopStories(API_KEY);
        call.enqueue(new Callback<TopStories>() {
            @Override
            public void onResponse(Call<TopStories> call, Response<TopStories> response) {
                int statusCode = response.code();
                List<TS_Result> movies = response.body().getResults();
                recyclerView.setAdapter(new TopStoriesAdapter(movies, R.layout.list_item_headline, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<TopStories> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}
