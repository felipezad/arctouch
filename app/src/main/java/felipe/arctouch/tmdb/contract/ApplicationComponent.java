package felipe.arctouch.tmdb.contract;

import android.app.Application;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;
import felipe.arctouch.tmdb.activity.main.MainActivity;
import felipe.arctouch.tmdb.activity.main.fragments.MovieListFragment;
import felipe.arctouch.tmdb.module.ApplicationModule;

/**
 * Created by felipe on 31/03/17.
 */
@Singleton
@Component(
        modules = {
                ApplicationModule.class
        }
)
public interface ApplicationComponent {

    void inject(MainActivity activity);

    SharedPreferences provideSharedPreferences();

    Application provideApplication();

}
