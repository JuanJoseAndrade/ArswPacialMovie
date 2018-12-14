/*
 * Copyright (C) 2016 Pivotal Software, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package arsw.lab7.restcontrollers;


import arsw.lab7.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan
 */

@RestController
@RequestMapping(value = "/movie") 
 public class APIController {
    
        @Autowired
        @Qualifier("Stub")
        ApiService apiservice;
        
        @GetMapping("/{title}/{year}")
 	public ResponseEntity<?> GetMovieByTitleAndYear(@PathVariable String title, @PathVariable String year){
 		try {
 			//obtener datos que se enviarán a través del API
 			return new ResponseEntity<>(apiservice.getMovieByTitleAndYear(title,year),HttpStatus.ACCEPTED);
 		} catch (Exception ex) {
 			return new ResponseEntity<>("Error 404"+ex,HttpStatus.NOT_FOUND);
 		}  
 	}

        
}       
 

