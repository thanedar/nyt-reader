
package com.suswara.newsreader_retro.beans;

import javax.annotation.Generated;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Generated("org.jsonschema2pojo")
@Data
public class AS_Meta {

    @SerializedName("hits")
    @Expose
    public Integer hits;
    @SerializedName("time")
    @Expose
    public Integer time;
    @SerializedName("offset")
    @Expose
    public Integer offset;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
