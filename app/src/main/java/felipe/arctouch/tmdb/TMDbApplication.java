package felipe.arctouch.tmdb;

import android.app.Application;

import felipe.arctouch.tmdb.contract.ApplicationComponent;
import felipe.arctouch.tmdb.contract.DaggerApplicationComponent;
import felipe.arctouch.tmdb.module.ApplicationModule;

/**
 * Created by felipe on 30/03/17.
 */

public class TMDbApplication extends Application {

    private ApplicationComponent applicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
