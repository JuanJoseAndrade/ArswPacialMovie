package arsw.lab7.services;



import arsw.lab7.httpConnection.ApiAlpha;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  arsw.lab7.Movie;
import arsw.lab7.MovieRepository;

@Service("Stub")
public class ApiServiceStub implements ApiService {
    @Autowired
    private MovieRepository repository;

    public ApiServiceStub() {
    }

    @Override
    public String getMovieByTitleAndYear(String title, String year) throws IOException {

        Movie repo=repository.findByUrl(title+year);
        if (repo==null){
            String apiAlpha=ApiAlpha.getJson(title, year);
            repository.save(new Movie(title+year,apiAlpha));
            return apiAlpha;
        }
        else{
            return repo.jsonApiAlpha;
        }
        
    }

}
