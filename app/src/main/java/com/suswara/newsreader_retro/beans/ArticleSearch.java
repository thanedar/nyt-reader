
package com.suswara.newsreader_retro.beans;

import javax.annotation.Generated;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Generated("org.jsonschema2pojo")
@Data
public class ArticleSearch {

    @SerializedName("response")
    @Expose
    public AS_Response response;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("copyright")
    @Expose
    public String copyright;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
