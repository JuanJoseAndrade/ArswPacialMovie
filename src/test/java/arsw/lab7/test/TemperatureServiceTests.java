
package arsw.lab7.test;

import arsw.lab7.restcontrollers.APIController;
import arsw.lab7.services.ApiService;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author 2107990
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TemperatureServiceTests {

    @LocalServerPort
    private int port;

    @Autowired
    private APIController movieController;
    
    @Autowired
    private ApiService temperatureService;


    

    public TemperatureServiceTests() {
    }



    /**
     * Pruebas unitarias 
     */
    @Test
    public void getJsonApiMovie() throws IOException {
        Assert.assertNotSame(" No se esta obteniendo datos del api ", "", temperatureService.getMovieByTitleAndYear("Batman", "2008"));
        Assert.assertNotSame(" No se esta obteniendo datos del api ", "", temperatureService.getMovieByTitleAndYear("Batman", "2012"));
    }


    /**
     * Pruebas unitarias concurrentes Api.
     *
     * @throws Exception
     */
    @Test
    public void convertions() throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 10; i < 10; i += 10) {
            MovieServiceRunnable convertions = new MovieServiceRunnable("Batman", "2008");
            es.execute(convertions);
        }
        try {
            es.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(TemperatureServiceTests.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Clase MovieServiceRunnable implementa Runnable. Usa el Api de peliculas para su funcionamiento funcionamiento.
     */
    public class MovieServiceRunnable implements Runnable {

        private String title;
        private String year;

        public MovieServiceRunnable(String title, String year) {
            this.title = title;
            this.year = year;
        }

        @Override
        public void run() {
            movieController.GetMovieByTitleAndYear(title, year);
        }

    }
}
