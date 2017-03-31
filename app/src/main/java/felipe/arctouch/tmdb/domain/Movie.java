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
    public Integer page;
    @SerializedName("results")
    @Expose
    public List<MovieInfo> results;

    private class MovieInfo{
        @SerializedName("poster_path")
        @Expose
        public String posterPath;
        @SerializedName("adult")
        @Expose
        public Boolean adult;
        @SerializedName("overview")
        @Expose
        public String overview;
        @SerializedName("release_date")
        @Expose
        public String releaseDate;
        @SerializedName("genre_ids")
        @Expose
        public List<Integer> genreIds = null;
        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("original_title")
        @Expose
        public String originalTitle;
        @SerializedName("original_language")
        @Expose
        public String originalLanguage;
        @SerializedName("title")
        @Expose
        public String title;
        @SerializedName("backdrop_path")
        @Expose
        public String backdropPath;
        @SerializedName("popularity")
        @Expose
        public Double popularity;
        @SerializedName("vote_count")
        @Expose
        public Integer voteCount;
        @SerializedName("video")
        @Expose
        public Boolean video;
        @SerializedName("vote_average")
        @Expose
        public Double voteAverage;
    }
}
