package felipe.arctouch.tmdb.activity.main.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import javax.inject.Inject;

import felipe.arctouch.tmdb.R;
import felipe.arctouch.tmdb.activity.main.MainActivity;
import felipe.arctouch.tmdb.adapters.MovieAdapter;
import felipe.arctouch.tmdb.api.MovieAPI;
import felipe.arctouch.tmdb.constants.API;
import felipe.arctouch.tmdb.constants.Languages;
import felipe.arctouch.tmdb.contract.MovieApiComponent;
import felipe.arctouch.tmdb.domain.Configuration;
import felipe.arctouch.tmdb.domain.Genre;
import felipe.arctouch.tmdb.domain.Movie;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public class MovieListFragment extends Fragment {

    @Inject
    Gson gson;
    @Inject
    MovieAPI movieApi;

    private RecyclerView mRecyclerView;
    private Movie movie;
    private Configuration configuration;
    private Genre genre;
    private static Integer nextPage = 2;

    public MovieListFragment() {
        // Required empty public constructor
    }

    public static MovieListFragment newInstance() {
        return new MovieListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MovieApiComponent movieApiComponent = ((MainActivity) getActivity()).getMovieApiComponent();
        movieApiComponent.inject(this);

        String firstMovies = getArguments().getString("firstPage");
        String configurationString = getArguments().getString("configuration");
        String genreString = getArguments().getString("genre");
        movie = gson.fromJson(firstMovies, Movie.class);
        configuration = gson.fromJson(configurationString, Configuration.class);
        genre = gson.fromJson(genreString, Genre.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
        if(movie != null){
            if(movie.getResults().size() > 0){
                mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewListMovies);
                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                    }

                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                        LinearLayoutManager layoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                        if(movie.getResults().size() - 3 == layoutManager.findLastCompletelyVisibleItemPosition() ){
                            MovieAdapter movieAdapter = (MovieAdapter) mRecyclerView.getAdapter();
                            Call<Movie> upcomingMovies = movieApi.getUpcomingMovies(API.API_KEY.getValue(), Languages.EN_US.getValue(), (nextPage++));
                            upcomingMovies.enqueue(new Callback<Movie>() {
                                @Override
                                public void onResponse(Response<Movie> response, Retrofit retrofit) {
                                    movieAdapter.addListItem(response.body().getResults(),movie.getResults().size());
                                }

                                @Override
                                public void onFailure(Throwable t) {
                                    Log.i("movieAdapter", t.toString());

                                }
                            });
                        }
                    }
                });

                LinearLayoutManager llm = new LinearLayoutManager(getActivity());
                llm.setOrientation(LinearLayoutManager.VERTICAL);
                //llm.setReverseLayout(true);
                mRecyclerView.setLayoutManager(llm);

                mRecyclerView.setAdapter(new MovieAdapter(getActivity(),movie.getResults(),configuration,genre));
            }
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_search_fragment, menu);
        MenuItem item = menu.findItem(R.id.app_bar_search);
        ActionBar supportActionBar = ((MainActivity) getActivity()).getSupportActionBar();
        SearchView searchView = new SearchView(supportActionBar.getThemedContext());
        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        MenuItemCompat.setActionView(item, searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i("onQueryTextSubmit",query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("onQueryTextChange",newText);
                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
