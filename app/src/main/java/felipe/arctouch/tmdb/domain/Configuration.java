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
    private Images images;
    @SerializedName("change_keys")
    @Expose
    private List<String> changeKeys;

    public Images getImages() {
        return images;
    }

    public Configuration setImages(Images images) {
        this.images = images;
        return this;
    }

    public List<String> getChangeKeys() {
        return changeKeys;
    }

    public Configuration setChangeKeys(List<String> changeKeys) {
        this.changeKeys = changeKeys;
        return this;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "images=" + images +
                '}';
    }
}
