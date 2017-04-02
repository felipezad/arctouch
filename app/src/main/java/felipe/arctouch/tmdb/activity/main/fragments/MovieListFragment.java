package felipe.arctouch.tmdb.activity.main.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import javax.inject.Inject;

import felipe.arctouch.tmdb.R;
import felipe.arctouch.tmdb.activity.main.MainActivity;
import felipe.arctouch.tmdb.contract.MovieApiComponent;
import felipe.arctouch.tmdb.domain.Movie;


public class MovieListFragment extends Fragment {

    @Inject
    Gson gson;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        String firstMovies = getArguments().getString("firstPage");
        Movie movie = gson.fromJson(firstMovies, Movie.class);
        return inflater.inflate(R.layout.fragment_movie_list, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
