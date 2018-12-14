/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.lab7;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author JuanJoAndrade
 */
public interface MovieRepository extends MongoRepository<Movie, String> {
    public Movie findByUrl(String url);
}
