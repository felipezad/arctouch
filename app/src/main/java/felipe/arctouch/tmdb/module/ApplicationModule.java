package felipe.arctouch.tmdb.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by felipe on 30/03/17.
 */
@Module
public class ApplicationModule {

    private static final String PREF_KEY = "tmdb";

    private final Application app;




    public ApplicationModule(Application a) {
        this.app = a;
    }


    @Provides
    @Singleton
    public SharedPreferences providePreferences( ){
        return( this.app.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE) );
    }

    @Provides
    @Singleton
    public Gson provideGson (){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();

    }
    @Provides
    @Singleton
    public Application provideApplication(){
        return this.app;
    }


}
