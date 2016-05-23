package com.suswara.newsreader_retro.rest;

import com.suswara.newsreader_retro.beans.TopStories;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("svc/topstories/v2/home.json")
    Call<TopStories> getTopStories(@Query("api_key") String apiKey);

    /*@GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
    */
}
