package felipe.arctouch.tmdb.contract;

import javax.inject.Singleton;

import dagger.Component;
import felipe.arctouch.tmdb.activity.main.MainActivity;
import felipe.arctouch.tmdb.module.ApplicationModule;
import felipe.arctouch.tmdb.module.MovieApiModule;

/**
 * Created by felipe on 01/04/17.
 */
@Singleton
@Component(

        modules = {ApplicationModule.class, MovieApiModule.class}

)
public interface MovieApiComponent {
    void inject(MainActivity activity);
}
