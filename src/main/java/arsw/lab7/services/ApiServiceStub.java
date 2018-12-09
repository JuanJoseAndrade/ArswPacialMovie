package arsw.lab7.services;



import arsw.lab7.EmpresaRepository;
import arsw.lab7.httpConnection.ApiAlpha;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  arsw.lab7.Empresa;

@Service("Stub")
public class ApiServiceStub implements ApiService {
    @Autowired
    private EmpresaRepository repository;

    public ApiServiceStub() {
    }

    @Override
    public ArrayList<String> getAllJSON(String code) throws IOException {
        ArrayList<String> consultas=new ArrayList();
        consultas.add(getJSONDaily( code));
        consultas.add(getJSONWeekly( code));
        consultas.add(getJSONMonthly( code));
        consultas.add(getJSONIntraDay( code));
        return consultas;
}

    @Override
    public String getJSONDaily(String code) throws IOException {

        Empresa repo=repository.findByUrl(code+"Daily");
        if (repo==null){
            String apiAlpha=ApiAlpha.getJson("TIME_SERIES_DAILY", code);
            repository.save(new Empresa(code+"Daily",apiAlpha));
            return apiAlpha;
        }
        else{
            return repo.jsonApiAlpha;
        }
        
    }

    @Override
    public String getJSONWeekly(String code) throws IOException {
        Empresa repo=repository.findByUrl(code+"Weekly");
        if (repo==null){
            String apiAlpha=ApiAlpha.getJson("TIME_SERIES_WEEKLY", code);
            repository.save(new Empresa(code+"Weekly",apiAlpha));
            return apiAlpha;
        }
        else{
            return repo.jsonApiAlpha;
        }
        }

    @Override
    public String getJSONMonthly(String code) throws IOException {
         Empresa repo=repository.findByUrl(code+"Monthly");
        if (repo==null){
            String apiAlpha=ApiAlpha.getJson("TIME_SERIES_MONTHLY", code);
            repository.save(new Empresa(code+"Monthly",apiAlpha));
            return apiAlpha;
        }
        else{
            return repo.jsonApiAlpha;
        }
    }

    @Override
    public String getJSONIntraDay(String code) throws IOException {
        Empresa repo=repository.findByUrl(code+"IntraDay");
        if (repo==null){
            String apiAlpha=ApiAlpha.getJson("TIME_SERIES_INTRADAY", code);
            repository.save(new Empresa(code+"IntraDay",apiAlpha));
            return apiAlpha;
        }
        else{
            return repo.jsonApiAlpha;
        }
    }
}
