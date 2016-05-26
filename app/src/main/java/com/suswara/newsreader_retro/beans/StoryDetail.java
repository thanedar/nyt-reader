package com.suswara.newsreader_retro.beans;

/**
 * Created by sudhanshut on 5/24/16.
 */
import javax.annotation.Generated;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Data;

@Data
public class StoryDetail implements Serializable {
    @Expose
    public String title;
    @Expose
    public String snippet;
    @Expose
    public String image;
    @Expose
    public String byline;
    @Expose
    public String backdrop;
}
