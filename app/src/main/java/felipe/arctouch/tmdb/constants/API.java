package felipe.arctouch.tmdb.constants;

/**
 * Created by felipe on 01/04/17.
 */

public enum API {
    TMBD_BASE_URL("http://api.themoviedb.org/3/"),
    TMBD_BASE_URL_SECURE("https://api.themoviedb.org/3/"),
    API_KEY("1f54bd990f1cdfb230adb312546d765d");

    private String value;

    API(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
