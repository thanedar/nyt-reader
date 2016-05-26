
package com.suswara.newsreader_retro.beans;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class ArticleSearch {

    @SerializedName("response")
    @Expose
    public Response response;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("copyright")
    @Expose
    public String copyright;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
