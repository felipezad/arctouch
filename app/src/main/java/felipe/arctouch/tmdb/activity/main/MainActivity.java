package felipe.arctouch.tmdb.activity.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import felipe.arctouch.tmdb.R;
import felipe.arctouch.tmdb.TMDbApplication;
import felipe.arctouch.tmdb.constants.API;
import felipe.arctouch.tmdb.contract.ApplicationComponent;
import felipe.arctouch.tmdb.contract.DaggerMovieApiComponent;
import felipe.arctouch.tmdb.contract.MovieApiComponent;
import felipe.arctouch.tmdb.module.ApplicationModule;
import felipe.arctouch.tmdb.module.MovieApiModule;

public class MainActivity extends AppCompatActivity {

    private MovieApiComponent movieApiComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        movieApiComponent = DaggerMovieApiComponent.builder()
                .movieApiModule(new MovieApiModule(API.TMBD_BASE_URL_SECURE.getUrl()))
                .applicationModule(new ApplicationModule(getApplicationComponent().provideApplication()))
                .build()
        ;
        setContentView(R.layout.activity_main);
    }


    private ApplicationComponent getApplicationComponent() {
        return (((TMDbApplication) getApplication()).getApplicationComponent());
    }
}
