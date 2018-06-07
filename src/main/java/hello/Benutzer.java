package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Benutzer{

    @Id
    @GeneratedValue
    private Long id;

    private boolean organisator;

    private String firstName;

    private String lastName;

    private String email;

    private String password;


    protected Benutzer() {
    }

    public Benutzer(boolean organisator, String firstName, String lastName, String email, String password) {
        this.organisator = organisator;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("Benutzer[id=%d, email='%s']", id, email);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isOrganisator() {
        return organisator;
    }

    public void setOrganisator(boolean organisator) {
        this.organisator = organisator;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
