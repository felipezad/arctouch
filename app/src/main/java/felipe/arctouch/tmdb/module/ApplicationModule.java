package felipe.arctouch.tmdb.module;

import android.app.Application;

import dagger.Module;

/**
 * Created by felipe on 30/03/17.
 */
@Module
public class ApplicationModule {

    private final Application a;

    public ApplicationModule(Application a) {
        this.a = a;
    }


}
