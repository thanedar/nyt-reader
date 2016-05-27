package com.suswara.newsreader_retro.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suswara.newsreader_retro.R;
import com.suswara.newsreader_retro.adapter.ArticleListingAdapter;
import com.suswara.newsreader_retro.adapter.TopStoryListingAdapter;
import com.suswara.newsreader_retro.beans.AS_Doc;
import com.suswara.newsreader_retro.beans.ArticleSearch;
import com.suswara.newsreader_retro.beans.TopStories;
import com.suswara.newsreader_retro.rest.ApiClient;
import com.suswara.newsreader_retro.rest.ApiInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A placeholder fragment containing a simple view.
 */
public class SearchFragment extends Fragment {

    public static final String TAG = SearchFragment.class.getSimpleName();

    private static final String ARG_PARAM1 = "param1";
    private String searchString;

    private ArticleListingAdapter articleListingAdapter;
    private RecyclerView recyclerView;

    private final static String TS_API_KEY = "a8457610b68381085a3fff38d6a36337:6:74255139";

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ListingFragment.
     */
    public static SearchFragment newInstance(String query) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, query);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            searchString = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listing, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.news_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("api_key", TS_API_KEY);
        queryMap.put("q", searchString);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<ArticleSearch> call = apiService.searchArticles(queryMap);
        call.enqueue(new Callback<ArticleSearch>() {
            @Override
            public void onResponse(Call<ArticleSearch> call, Response<ArticleSearch> response) {
                List<AS_Doc> results;
                if(response != null) {
                    results = response.body().getResponse().getDocs();
                }
                else {
                    results = new ArrayList<>();
                }
                articleListingAdapter = new ArticleListingAdapter(results, R.layout.list_item_headline, getActivity().getApplicationContext());
                recyclerView.setAdapter(articleListingAdapter);
            }

            @Override
            public void onFailure(Call<ArticleSearch> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

        return view;
    }
}
