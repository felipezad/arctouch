package felipe.arctouch.tmdb.api;

import felipe.arctouch.tmdb.domain.Configuration;
import felipe.arctouch.tmdb.domain.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by felipe on 30/03/17.
 */

public interface MovieAPI {

    @GET("movie/upcoming")
    Call<Movie> getUpcomingMovies(@Query("api_key") String apiKey, @Query("language") String language, @Query("page") Integer page);

    @GET("configuration")
    Call<Configuration> getImageConfiguration(@Query("api_key") String apiKey);

    @GET("{baseUrl}/{size}/{filePath}")
    Call<String> getUrlImage(@Path("baseUrl") String baseUrl, @Path("size") String size, @Path("filePath") String filePath);

}
