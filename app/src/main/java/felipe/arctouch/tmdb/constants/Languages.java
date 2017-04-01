package felipe.arctouch.tmdb.constants;

/**
 * Created by felipe on 01/04/17.
 */


public enum Languages {
    //https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes
    EN_US("en-US")
    ;

    private String value;

    Languages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
