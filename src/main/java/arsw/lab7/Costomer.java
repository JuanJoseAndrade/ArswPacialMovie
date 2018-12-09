package arsw.lab7;

import org.springframework.data.annotation.Id;


public class Costomer {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Costomer() {}

    public Costomer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}

