package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * Diese Klasse wird Benoetigt, damit man ein Objekt davon in das Repository und die H2 Datenbank speichern kann.
 *
 */
@Entity
public class Kommentar
{
    @Id
    @GeneratedValue
    private Long id;

    private String text;

    //private Benutzer benutzer;

    /**
     * Constructor
     * @param text
     * @param benutzer
     */
    public Kommentar(String text, Benutzer benutzer) {
        this.text = text;
        //this.benutzer = benutzer;
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
     * Getter für den Textinhalt des Kommentars
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Setter für den Textinhalt des Kommentars
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    //public Benutzer getBenutzer() {
     //   return benutzer;
    //}

    //public void setBenutzer(Benutzer benutzer) {
    //    this.benutzer = benutzer;
    //}
}
