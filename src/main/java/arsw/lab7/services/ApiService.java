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
    
    List getAllJSON(String code) throws IOException;
    String getJSONDaily(String code) throws IOException;
    String getJSONWeekly(String code) throws IOException;
    String getJSONMonthly(String code) throws IOException;
    String getJSONIntraDay(String code) throws IOException;
    
}
