package felipe.arctouch.tmdb.domain;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by felipe on 30/03/17.
 */

public class Configuration {
    @SerializedName("images")
    @Expose
    public Images images;
    @SerializedName("change_keys")
    @Expose




    public List<String> changeKeys;


}
