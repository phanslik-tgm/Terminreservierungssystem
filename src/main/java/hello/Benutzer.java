package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Diese Klasse wird Benoetigt, damit man ein Objekt davon in das Repository und die H2 Datenbank speichern kann.
 *
 */
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


    protected Benutzer(){
    }

    /**
     * Constructor.
     *
     * @param organisator bool ob er events erstellen kann
     * @param firstName String mit dem Vornamen
     * @param lastName String mit dem Nachnamen
     * @param email String mit der Email
     * @param password String mit dem passwort --> Hash wird später implementiert
     */
    public Benutzer(boolean organisator, String firstName, String lastName, String email, String password) {
        this.organisator = organisator;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    /**
     * toString
     * @return String mit id und email
     */
    @Override
    public String toString() {
        return String.format("Benutzer[id=%d, email='%s']", id, email);
    }

    /**
     * Getter Für Id
     * @return long id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter für Id
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter ob Benutzer ein Oraginisator ist
     * @return bool ob organisator oder nicht
     */
    public boolean getOrganisator() {
        return organisator;
    }

    /**
     * Setter ob mer Oragnisator ist
     * @param organisator
     */
    public void setOrganisator(boolean organisator) {
        this.organisator = organisator;
    }

    /**
     * Getter für Vornamen
     * @return String firstname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter für Vornamen
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * Getter für den Nachnamen
     * @return String lastname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter für den Nachnamen
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter für die Email
     * @return String email
     */
    public String getEmail() {
        return email;
    }

    /**
     *Setter für die Email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter für das Passwort
     * @return String Password
     * Noch in Plain Text
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter für das Passwort
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
