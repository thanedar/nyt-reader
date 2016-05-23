
package com.suswara.newsreader_retro.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class TS_Result {

    @SerializedName("section")
    @Expose
    public String section;
    @SerializedName("subsection")
    @Expose
    public String subsection;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("abstract")
    @Expose
    public String _abstract;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("byline")
    @Expose
    public String byline;
    @SerializedName("item_type")
    @Expose
    public String itemType;
    @SerializedName("updated_date")
    @Expose
    public String updatedDate;
    @SerializedName("created_date")
    @Expose
    public String createdDate;
    @SerializedName("published_date")
    @Expose
    public String publishedDate;
    @SerializedName("material_type_facet")
    @Expose
    public String materialTypeFacet;
    @SerializedName("kicker")
    @Expose
    public String kicker;
    @SerializedName("des_facet")
    @Expose
    public List<String> desFacet = new ArrayList<String>();
    @SerializedName("org_facet")
    @Expose
    public List<Object> orgFacet = new ArrayList<Object>();
    @SerializedName("per_facet")
    @Expose
    public List<String> perFacet = new ArrayList<String>();
    @SerializedName("geo_facet")
    @Expose
    public List<Object> geoFacet = new ArrayList<Object>();
    @SerializedName("multimedia")
    @Expose
    public List<TS_Multimedia> multimedia = new ArrayList<TS_Multimedia>();
    @SerializedName("short_url")
    @Expose
    public String shortUrl;

}
