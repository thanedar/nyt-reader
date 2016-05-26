
package com.suswara.newsreader_retro.beans;

import javax.annotation.Generated;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Generated("org.jsonschema2pojo")
@Data
public class AS_Multimedium {

    @SerializedName("width")
    @Expose
    public Integer width;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("height")
    @Expose
    public Integer height;
    @SerializedName("subtype")
    @Expose
    public String subtype;
    @SerializedName("type")
    @Expose
    public String type;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
