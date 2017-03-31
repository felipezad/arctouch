package felipe.arctouch.tmdb.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by felipe on 30/03/17.
 */

public class Images {

    @SerializedName("base_url")
    @Expose
    public String baseUrl;
    @SerializedName("secure_base_url")
    @Expose
    public String secureBaseUrl;
    @SerializedName("backdrop_sizes")
    @Expose
    public List<String> backdropSizes ;
    @SerializedName("logo_sizes")
    @Expose
    public List<String> logoSizes;
    @SerializedName("poster_sizes")
    @Expose
    public List<String> posterSizes;
    @SerializedName("profile_sizes")
    @Expose
    public List<String> profileSizes;
    @SerializedName("still_sizes")
    @Expose
    public List<String> stillSizes;

}
