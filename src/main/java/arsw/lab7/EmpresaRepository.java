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
public interface EmpresaRepository extends MongoRepository<Empresa, String> {
    public Empresa findByUrl(String url);
}
