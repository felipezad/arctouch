package felipe.arctouch.tmdb.activity.main;

import android.content.Context;

import com.google.gson.Gson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import felipe.arctouch.tmdb.TMDbApplication;
import felipe.arctouch.tmdb.contract.DaggerMovieApiComponent;
import felipe.arctouch.tmdb.contract.MovieApiComponent;
import felipe.arctouch.tmdb.domain.Configuration;
import felipe.arctouch.tmdb.domain.Images;
import felipe.arctouch.tmdb.domain.Movie;
import felipe.arctouch.tmdb.domain.MovieInfo;
import felipe.arctouch.tmdb.module.ApplicationModule;
import felipe.arctouch.tmdb.module.MovieApiModule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by felipe on 03/04/17.
 */
public class MainActivityTest {

    @Inject
    Gson gson;

    @Mock
    Context mMockContext;

    @Mock
    TMDbApplication mMockApplication;

    MovieApiComponent movieApiComponent;

    @Before
    public void setUp() throws Exception {
        MovieApiModule movieApiModule = mock(MovieApiModule.class);
        ApplicationModule applicationModule = mock(ApplicationModule.class);
        movieApiComponent = DaggerMovieApiComponent.builder()
                .movieApiModule(movieApiModule)
                .applicationModule(applicationModule)
                .build();
    }



    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void validateMovie() throws Exception {
        Movie fakeMovie = new Movie();
        MovieInfo fakeMovieInfo = new MovieInfo();
        fakeMovieInfo.setTitle("fakeMovie");
        fakeMovieInfo.setId(1);
        List<MovieInfo> fakeMovieInfos = new ArrayList<>();
        fakeMovieInfos.add(fakeMovieInfo);
        fakeMovie.setResults(fakeMovieInfos);
        fakeMovie.setPage(1);
        assertNotNull(fakeMovie);
        assertEquals(1,fakeMovie.getResults().size());
        assertEquals("fakeMovie",fakeMovie.getResults().get(0).getTitle());
        assertEquals(Integer.valueOf(1),fakeMovie.getResults().get(0).getId());
    }

    @Test
    public void validateConfiguration() throws Exception {
        Configuration fakeConfiguration = new Configuration();


        Images image = new Images();
        image.setBaseUrl("fakeBaseUrl");

        fakeConfiguration.setImages(image);

        assertNotNull(image);
        assertNotNull(fakeConfiguration);


    }

    @Test
    public void etMovieApiComponent() throws Exception {
        assertNotNull(movieApiComponent);
    }

}