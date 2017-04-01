package felipe.arctouch.tmdb.activity.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import felipe.arctouch.tmdb.R;
import felipe.arctouch.tmdb.TMDbApplication;
import felipe.arctouch.tmdb.api.MovieAPI;
import felipe.arctouch.tmdb.constants.API;
import felipe.arctouch.tmdb.constants.Languages;
import felipe.arctouch.tmdb.contract.ApplicationComponent;
import felipe.arctouch.tmdb.contract.DaggerMovieApiComponent;
import felipe.arctouch.tmdb.contract.MovieApiComponent;
import felipe.arctouch.tmdb.domain.Configuration;
import felipe.arctouch.tmdb.domain.Movie;
import felipe.arctouch.tmdb.module.ApplicationModule;
import felipe.arctouch.tmdb.module.MovieApiModule;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    private MovieApiComponent movieApiComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        movieApiComponent = DaggerMovieApiComponent.builder()
                .movieApiModule(new MovieApiModule(API.TMBD_BASE_URL_SECURE.getValue()))
                .applicationModule(new ApplicationModule(getApplicationComponent().provideApplication()))
                .build()
        ;
        movieApiComponent.inject(this);
        MovieAPI movieAPI = movieApiComponent.provideMovieApi();
        /*Call<Configuration> imageConfiguration = movieAPI.getImageConfiguration(API.API_KEY.getValue());
        imageConfiguration.enqueue(new Callback<Configuration>() {

            @Override
            public void onResponse(Response<Configuration> response, Retrofit retrofit) {
                Configuration body = response.body();
                Log.i("movieAPI",body.toString());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("movieAPI",t.toString());
            }
        });
*/
        Call<Movie> upcomingMovies = movieAPI.getUpcomingMovies(API.API_KEY.getValue(), Languages.EN_US.getValue(), 2);
        upcomingMovies.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Response<Movie> response, Retrofit retrofit) {
                Movie body = response.body();
                Log.i("movieAPI",body.toString());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("movieAPI",t.toString());

            }
        });
        setContentView(R.layout.activity_main);
    }


    private ApplicationComponent getApplicationComponent() {
        return (((TMDbApplication) getApplication()).getApplicationComponent());
    }
}
