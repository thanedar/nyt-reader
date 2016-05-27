package com.suswara.newsreader_retro.rest;

import com.suswara.newsreader_retro.beans.ArticleSearch;
import com.suswara.newsreader_retro.beans.TopStories;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


public interface ApiInterface {
    @GET("svc/topstories/v2/home.json")
    Call<TopStories> getTopStories(@Query("api_key") String apiKey);

    @GET("svc/search/v2/articlesearch.json")
    Call<ArticleSearch> searchArticles(@QueryMap Map<String, String> params);

    /*@GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
    */
}
