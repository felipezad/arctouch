package felipe.arctouch.tmdb.constants;

/**
 * Created by felipe on 01/04/17.
 */

public enum API {
    TMBD_BASE_URL("http://api.themoviedb.org/3/"),
    TMBD_BASE_URL_SECURE("https://api.themoviedb.org/3/");

    private String url;

    API(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
