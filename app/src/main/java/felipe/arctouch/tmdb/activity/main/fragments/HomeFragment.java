package felipe.arctouch.tmdb.activity.main.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import javax.inject.Inject;

import felipe.arctouch.tmdb.R;
import felipe.arctouch.tmdb.activity.main.MainActivity;
import felipe.arctouch.tmdb.api.MovieAPI;
import felipe.arctouch.tmdb.constants.API;
import felipe.arctouch.tmdb.constants.Languages;
import felipe.arctouch.tmdb.contract.MovieApiComponent;
import felipe.arctouch.tmdb.domain.Movie;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class HomeFragment extends Fragment {

    private OnCallMovieList mListener;
    @Inject
    MovieAPI movieAPI;
    Movie firstMovies;


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MovieApiComponent movieApiComponent = ((MainActivity) getActivity()).getMovieApiComponent();
        movieApiComponent.inject(this);
        Call<Movie> upcomingMovies = movieAPI.getUpcomingMovies(API.API_KEY.getValue(), Languages.EN_US.getValue(), 1);
        upcomingMovies.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Response<Movie> response, Retrofit retrofit) {
                firstMovies = response.body();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("movieAPI",t.toString());

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        callMovieList((ImageView) view.findViewById(R.id.upComingButton));

        return view;
    }

    public void onButtonPressed(Movie movie){
        if (mListener != null) {
            mListener.onCallMovieList(movie);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnCallMovieList) {
            mListener = (OnCallMovieList) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnCallMovieList {
        // TODO: Update argument type and name
        void onCallMovieList(Movie movie);
    }

    private void callMovieList(ImageView imageView){
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed(firstMovies);
            }
        });
    }


}
