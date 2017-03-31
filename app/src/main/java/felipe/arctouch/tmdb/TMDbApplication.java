package felipe.arctouch.tmdb;

import android.app.Application;

import felipe.arctouch.tmdb.module.ApplicationModule;

/**
 * Created by felipe on 30/03/17.
 */

public class TMDbApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
