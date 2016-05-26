
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
public class AS_Response {

    @SerializedName("meta")
    @Expose
    public AS_Meta meta;
    @SerializedName("docs")
    @Expose
    public List<AS_Doc> docs = new ArrayList<AS_Doc>();

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
