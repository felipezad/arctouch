package felipe.arctouch.tmdb.activity.main;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.google.gson.Gson;

import javax.inject.Inject;

import felipe.arctouch.tmdb.R;
import felipe.arctouch.tmdb.TMDbApplication;
import felipe.arctouch.tmdb.activity.main.fragments.HomeFragment;
import felipe.arctouch.tmdb.activity.main.fragments.MovieListFragment;
import felipe.arctouch.tmdb.constants.API;
import felipe.arctouch.tmdb.contract.ApplicationComponent;
import felipe.arctouch.tmdb.contract.DaggerMovieApiComponent;
import felipe.arctouch.tmdb.contract.MovieApiComponent;
import felipe.arctouch.tmdb.domain.Configuration;
import felipe.arctouch.tmdb.domain.Genre;
import felipe.arctouch.tmdb.domain.Movie;
import felipe.arctouch.tmdb.module.ApplicationModule;
import felipe.arctouch.tmdb.module.MovieApiModule;

public class MainActivity extends AppCompatActivity
 implements HomeFragment.OnCallMovieList{

    private MovieApiComponent movieApiComponent;

    @Inject
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        movieApiComponent = DaggerMovieApiComponent.builder()
                .movieApiModule(new MovieApiModule(API.TMBD_BASE_URL_SECURE.getValue()))
                .applicationModule(new ApplicationModule(getApplicationComponent().provideApplication()))
                .build()
        ;
        movieApiComponent.inject(this);

        setContentView(R.layout.activity_main);
        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            HomeFragment firstFragment = HomeFragment.newInstance();
            firstFragment.setArguments(getIntent().getExtras());

            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }

    }


    @Override
    public void onCallMovieList(Movie movie, Configuration configuration, Genre genre) {
        if(movie != null && configuration != null && genre != null){
            MovieListFragment newFragment = new MovieListFragment();
            Bundle args = new Bundle();
            args.putString("firstPage", gson.toJson(movie));
            args.putString("configuration", gson.toJson(configuration));
            args.putString("genre", gson.toJson(genre));
            newFragment.setArguments(args);
            newFragment.setHasOptionsMenu(true);

            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }

    private ApplicationComponent getApplicationComponent() {
        return (((TMDbApplication) getApplication()).getApplicationComponent());
    }

    public MovieApiComponent getMovieApiComponent(){
        return movieApiComponent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
