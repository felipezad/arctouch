package felipe.arctouch.tmdb.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by felipe on 31/03/17.
 */


@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
