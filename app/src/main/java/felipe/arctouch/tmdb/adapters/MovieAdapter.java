package felipe.arctouch.tmdb.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import felipe.arctouch.tmdb.R;
import felipe.arctouch.tmdb.domain.Configuration;
import felipe.arctouch.tmdb.domain.Genre;
import felipe.arctouch.tmdb.domain.GenreInfo;
import felipe.arctouch.tmdb.domain.MovieInfo;

/**
 * Created by felipe on 02/04/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> implements Filterable{

    private Configuration configuration;
    private Genre genre;
    private Context mContext;
    private List<MovieInfo> movies;
    private List<MovieInfo> filteredMovies;
    private LayoutInflater mLayoutInflater;

    public MovieAdapter(Context mContext, List<MovieInfo> movies, Configuration configuration, Genre genre) {
        this.mContext = mContext;
        this.movies = movies;
        this.filteredMovies = new ArrayList<>(movies);
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
        MovieInfo movieInfo = filteredMovies.get(position);
        List<Integer> genreIds = movieInfo.getGenreIds();
        if(genre !=null){

            List<GenreInfo> genreInfos = genre.getGenreInfoById(genreIds);
            movieInfo.setGenres(genreInfos);
        }
        String baseUrl = configuration.getImages().getBaseUrl();
        List<String> posterSizes = configuration.getImages().getPosterSizes();
        Drawable drawable = mContext.getResources().getDrawable(R.drawable.ic_default_placeholder_dark,null);

        if(movieInfo.getPosterPath() != null){
            Picasso.with(mContext)
                    .load(baseUrl+posterSizes.get(3)+movieInfo.getPosterPath())
                    .placeholder(drawable)
                    .into(holder.ivMovieImage);

        }else{
            Picasso.with(mContext)
                    .load(R.drawable.ic_default_placeholder_dark)
                    .fit()
                    .centerInside()
                    .placeholder(drawable)
                    .into(holder.ivMovieImage);
        }


        holder.tvMovieName.setText(movieInfo.getTitle());
        holder.tvMovieGenre.setText(movieInfo.getMovieGenres());
        holder.tvMovieReleaseDate.setText(movieInfo.getReleaseDate());
        holder.tvPartialSynopsis.setText(movieInfo.getOverview().substring(0,50).concat("..."));
        holder.tvFullSynopsis.setText(movieInfo.getOverview());
        holder.ivTrailer.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://www.google.com.br/#q="+movieInfo.getTitle()+"&tbm=vid"));
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return filteredMovies.size();
    }

    public void addListItem(List<MovieInfo> newMovies, int position){
        filteredMovies.addAll(newMovies);
        movies.addAll(newMovies);
        notifyItemInserted(position);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String filterString = constraint.toString().toLowerCase();
                FilterResults filterResults = new FilterResults();

                final List<MovieInfo> originalData = MovieAdapter.this.movies;
                List<MovieInfo> collect;
                if(filterString.length() > 0){
                   collect = originalData.stream().filter(movieInfo -> movieInfo.getTitle().toLowerCase().contains(filterString)).collect(Collectors.toList());
                }else{
                    collect = originalData;
                }
                filterResults.values = collect;
                filterResults.count = collect.size();
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredMovies = (ArrayList<MovieInfo>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tvMovieName;
        public ImageView ivMovieImage;
        public TextView tvMovieGenre;
        public TextView tvMovieReleaseDate;
        public TextView tvFullSynopsis;
        public TextView tvPartialSynopsis;
        public TextView tvMoreInfo;
        public ImageView ivTrailer;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvMovieName = (TextView) itemView.findViewById(R.id.tvMovieName);
            ivMovieImage = (ImageView) itemView.findViewById(R.id.ivMovieImage);
            tvMovieGenre = (TextView) itemView.findViewById(R.id.tvMovieGenre);
            tvMovieReleaseDate = (TextView) itemView.findViewById(R.id.tvMovieReleaseDate);
            tvFullSynopsis = (TextView) itemView.findViewById(R.id.tvFullSynopsis);
            tvPartialSynopsis = (TextView) itemView.findViewById(R.id.tvPartialSynopsis);
            tvMoreInfo = (TextView) itemView.findViewById(R.id.tvMoreInfo);
            ivTrailer = (ImageView) itemView.findViewById(R.id.ivTrailer);
            itemView.setOnClickListener(v -> {
                if(tvFullSynopsis.getVisibility() == View.GONE){
                    tvPartialSynopsis.setVisibility(View.GONE);
                    tvMoreInfo.setVisibility(View.GONE);
                    tvFullSynopsis.setVisibility(View.VISIBLE);
                }else{
                    tvPartialSynopsis.setVisibility(View.VISIBLE);
                    tvMoreInfo.setVisibility(View.VISIBLE);
                    tvFullSynopsis.setVisibility(View.GONE);
                }

            });
        }
    }
}
