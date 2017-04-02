package felipe.arctouch.tmdb.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created by felipe on 02/04/17.
 */
public class MovieInfo {
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("adult")
    @Expose
    private Boolean adult;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds = null;

    private String movieGenres;

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;
    @SerializedName("video")
    @Expose
    private Boolean video;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;

    public String getPosterPath() {
        return posterPath;
    }

    public MovieInfo setPosterPath(String posterPath) {
        this.posterPath = posterPath;
        return this;
    }

    public Boolean getAdult() {
        return adult;
    }

    public MovieInfo setAdult(Boolean adult) {
        this.adult = adult;
        return this;
    }

    public String getOverview() {
        return overview;
    }

    public MovieInfo setOverview(String overview) {
        this.overview = overview;
        return this;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public MovieInfo setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public MovieInfo setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public MovieInfo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public MovieInfo setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
        return this;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public MovieInfo setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MovieInfo setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public MovieInfo setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
        return this;
    }

    public Double getPopularity() {
        return popularity;
    }

    public MovieInfo setPopularity(Double popularity) {
        this.popularity = popularity;
        return this;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public MovieInfo setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
        return this;
    }

    public Boolean getVideo() {
        return video;
    }

    public MovieInfo setVideo(Boolean video) {
        this.video = video;
        return this;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public MovieInfo setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
        return this;
    }

    public MovieInfo setGenres(List<GenreInfo> genres){

        StringJoiner sj = new StringJoiner(", ");
        genres.forEach( gen -> sj.add(gen.getName()));
        this.movieGenres = sj.toString();
        return this;
    }

    public String getMovieGenres() {
        return movieGenres;
    }
}
