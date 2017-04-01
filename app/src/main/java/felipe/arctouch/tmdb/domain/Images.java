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
    private String baseUrl;
    @SerializedName("secure_base_url")
    @Expose
    private String secureBaseUrl;
    @SerializedName("backdrop_sizes")
    @Expose
    private List<String> backdropSizes ;
    @SerializedName("logo_sizes")
    @Expose
    private List<String> logoSizes;
    @SerializedName("poster_sizes")
    @Expose
    private List<String> posterSizes;
    @SerializedName("profile_sizes")
    @Expose
    private List<String> profileSizes;
    @SerializedName("still_sizes")
    @Expose
    private List<String> stillSizes;


    public String getBaseUrl() {
        return baseUrl;
    }

    public Images setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public String getSecureBaseUrl() {
        return secureBaseUrl;
    }

    public Images setSecureBaseUrl(String secureBaseUrl) {
        this.secureBaseUrl = secureBaseUrl;
        return this;
    }

    public List<String> getBackdropSizes() {
        return backdropSizes;
    }

    public Images setBackdropSizes(List<String> backdropSizes) {
        this.backdropSizes = backdropSizes;
        return this;
    }

    public List<String> getLogoSizes() {
        return logoSizes;
    }

    public Images setLogoSizes(List<String> logoSizes) {
        this.logoSizes = logoSizes;
        return this;
    }

    public List<String> getPosterSizes() {
        return posterSizes;
    }

    public Images setPosterSizes(List<String> posterSizes) {
        this.posterSizes = posterSizes;
        return this;
    }

    public List<String> getProfileSizes() {
        return profileSizes;
    }

    public Images setProfileSizes(List<String> profileSizes) {
        this.profileSizes = profileSizes;
        return this;
    }

    public List<String> getStillSizes() {
        return stillSizes;
    }

    public Images setStillSizes(List<String> stillSizes) {
        this.stillSizes = stillSizes;
        return this;
    }

    @Override
    public String toString() {
        return "Images{" +
                "baseUrl='" + baseUrl + '\'' +
                '}';
    }
}
