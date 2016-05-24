package com.suswara.newsreader_retro.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suswara.newsreader_retro.R;
import com.suswara.newsreader_retro.adapter.TopStoriesAdapter;
import com.suswara.newsreader_retro.beans.TS_Result;
import com.suswara.newsreader_retro.beans.TopStories;
import com.suswara.newsreader_retro.rest.ApiClient;
import com.suswara.newsreader_retro.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListingFragment extends Fragment {

    private TopStoriesAdapter topStoriesAdapter;
    private RecyclerView recyclerView;

    private static final String TAG = ListingFragment.class.getSimpleName();

    private final static String TS_API_KEY = "340fe1949bbc2b893c4a336bb072412a:18:74255139";

    public ListingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ListingFragment.
     */
    public static ListingFragment newInstance() {
        return new ListingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listing, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.news_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ApiInterface apiService =
                ApiClient.getNYTClient().create(ApiInterface.class);

        Call<TopStories> call = apiService.getTopStories(TS_API_KEY);
        call.enqueue(new Callback<TopStories>() {
            @Override
            public void onResponse(Call<TopStories> call, Response<TopStories> response) {
                List<TS_Result> results = response.body().getResults();
                topStoriesAdapter = new TopStoriesAdapter(results, R.layout.list_item_headline, getActivity().getApplicationContext());
                recyclerView.setAdapter(topStoriesAdapter);
            }

            @Override
            public void onFailure(Call<TopStories> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

        return view;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
