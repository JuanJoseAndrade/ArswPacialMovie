/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.lab7;

import org.springframework.data.annotation.Id;

/**
 *
 * @author JuanJoAndrade
 */
public class Movie {
    @Id
    public String id;
    public String url;
    public String jsonApiAlpha;
    public Movie(){}
    public Movie(String url, String jsonApiAlpha){
        this.url=url;
        this.jsonApiAlpha=jsonApiAlpha;
    }
}
