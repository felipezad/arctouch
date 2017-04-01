package felipe.arctouch.tmdb.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import felipe.arctouch.tmdb.api.MovieAPI;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by felipe on 01/04/17.
 */

@Module
public class MovieApiModule {

    private String baseUrl;
    private String baseUrlImage;

    public MovieApiModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public MovieApiModule setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }



    @Provides
    @Singleton
    public MovieAPI provideMovieAPI(Gson gson) {
        Retrofit retrofit = new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(this.baseUrl)
                .build();

        return retrofit.create(MovieAPI.class);
    }


}
