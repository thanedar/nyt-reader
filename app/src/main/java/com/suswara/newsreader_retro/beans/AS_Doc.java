
package com.suswara.newsreader_retro.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Generated("org.jsonschema2pojo")
@Data
public class AS_Doc {

    @SerializedName("web_url")
    @Expose
    public String webUrl;
    @SerializedName("snippet")
    @Expose
    public String snippet;
    @SerializedName("headline")
    @Expose
    public Headline headline;
    @SerializedName("multimedia")
    @Expose
    public List<AS_Multimedium> multimedia = new ArrayList<AS_Multimedium>();

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
