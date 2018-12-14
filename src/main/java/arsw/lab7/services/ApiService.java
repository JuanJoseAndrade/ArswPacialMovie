/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.lab7.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author hcadavid
 */
public interface ApiService {
    

    String getMovieByTitleAndYear(String title, String year) throws IOException;

    
}
