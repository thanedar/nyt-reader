
package com.suswara.newsreader_retro.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Generated("org.jsonschema2pojo")
@Data
public class TopStories {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("copyright")
    @Expose
    public String copyright;
    @SerializedName("section")
    @Expose
    public String section;
    @SerializedName("last_updated")
    @Expose
    public String lastUpdated;
    @SerializedName("num_results")
    @Expose
    public Integer numResults;
    @SerializedName("results")
    @Expose
    public List<TS_Result> results = new ArrayList<TS_Result>();

}
