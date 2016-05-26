
package com.suswara.newsreader_retro.beans;

import javax.annotation.Generated;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Generated("org.jsonschema2pojo")
@Data
public class AS_Headline {

    @SerializedName("main")
    @Expose
    public String main;
    @SerializedName("content_kicker")
    @Expose
    public String contentKicker;
    @SerializedName("kicker")
    @Expose
    public String kicker;
    @SerializedName("print_headline")
    @Expose
    public String printHeadline;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
