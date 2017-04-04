package felipe.arctouch.tmdb.activity.main.fragments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import felipe.arctouch.tmdb.api.MovieAPI;

import static org.junit.Assert.assertNotNull;

/**
 * Created by felipe on 03/04/17.
 */
public class HomeFragmentTest {


    @Mock
    MovieAPI movieAPI;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void movieApiExists() throws Exception {
        assertNotNull(movieAPI);
    }
}