package felipe.arctouch.tmdb.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by felipe on 30/03/17.
 */

public class Movie {

    @SerializedName("page")
    @Expose
    private Integer page;

    @SerializedName("results")
    @Expose
    private List<MovieInfo> results;

    public Integer getPage() {
        return page;
    }

    public Movie setPage(Integer page) {
        this.page = page;
        return this;
    }

    public List<MovieInfo> getResults() {
        return results;
    }

    public Movie setResults(List<MovieInfo> results) {
        this.results = results;
        return this;
    }


}
