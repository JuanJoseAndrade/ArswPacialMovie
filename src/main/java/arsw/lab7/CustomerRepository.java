package arsw.lab7;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Costomer, String> {

    public Costomer findByFirstName(String firstName);
    public List<Costomer> findByLastName(String lastName);

}
