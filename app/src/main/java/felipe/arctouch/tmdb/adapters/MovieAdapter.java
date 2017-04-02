package felipe.arctouch.tmdb.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import felipe.arctouch.tmdb.R;
import felipe.arctouch.tmdb.domain.Configuration;
import felipe.arctouch.tmdb.domain.Genre;
import felipe.arctouch.tmdb.domain.GenreInfo;
import felipe.arctouch.tmdb.domain.MovieInfo;

/**
 * Created by felipe on 02/04/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{
    private Configuration configuration;
    private Genre genre;
    private Context mContext;
    private List<MovieInfo> movies;
    private LayoutInflater mLayoutInflater;

    public MovieAdapter(Context mContext, List<MovieInfo> movies, Configuration configuration, Genre genre) {
        this.mContext = mContext;
        this.movies = movies;
        this.genre = genre;
        this.configuration = configuration;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.movie_card, viewGroup, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MovieInfo movieInfo = movies.get(position);
        List<Integer> genreIds = movieInfo.getGenreIds();
        List<GenreInfo> genreInfos = genre.getGenreInfoById(genreIds);
        movieInfo.setGenres(genreInfos);

        holder.tvMovieName.setText(movieInfo.getTitle());
        holder.tvMovieImage.setText(movieInfo.getBackdropPath());
        holder.tvMovieGenre.setText(movieInfo.getMovieGenres());
        holder.tvMovieReleaseDate.setText(movieInfo.getReleaseDate());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void addListItem(List<MovieInfo> newMovies, int position){
        movies.addAll(newMovies);
        notifyItemInserted(position);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tvMovieName;
        public TextView tvMovieImage;
        public TextView tvMovieGenre;
        public TextView tvMovieReleaseDate;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvMovieName = (TextView) itemView.findViewById(R.id.tvMovieName);
            tvMovieImage = (TextView) itemView.findViewById(R.id.tvMovieImage);
            tvMovieGenre = (TextView) itemView.findViewById(R.id.tvMovieGenre);
            tvMovieReleaseDate = (TextView) itemView.findViewById(R.id.tvMovieReleaseDate);
        }
    }
}
