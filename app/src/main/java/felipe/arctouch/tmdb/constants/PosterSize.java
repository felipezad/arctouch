package felipe.arctouch.tmdb.constants;

/**
 * Created by felipe on 02/04/17.
 */

public enum PosterSize {
    W92("w92"),
    W154("w154"),
    W185("w185"),
    W342("w342"),
    W500("w500"),
    W780("w780"),
    ORIGINAL("original")
    ;

    private String value;

    PosterSize(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public PosterSize setValue(String value) {
        this.value = value;
        return this;
    }
}
