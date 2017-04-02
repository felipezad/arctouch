package felipe.arctouch.tmdb.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by felipe on 02/04/17.
 */

public class Genre {

    @SerializedName("genres")
    @Expose
    private List<GenreInfo> genreInfos = null;

    public List<GenreInfo> getGenreInfos() {
        return genreInfos;
    }

    public void setGenreInfos(List<GenreInfo> genreInfos) {
        this.genreInfos = genreInfos;
    }

    public List<GenreInfo> getGenreInfoById(List<Integer> id){
       return this.genreInfos.stream().filter(genreInfo -> id.contains(genreInfo.getId())).collect(Collectors.toList());
    }

}
