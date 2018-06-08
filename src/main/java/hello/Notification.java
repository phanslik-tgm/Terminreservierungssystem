package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Diese Klasse bird Benoetigt, damit man ein Objekt davon in das Repository und die H2 Datenbank speichern kann.
 *
 * !!!!!!!!Benutzer benutzer musste ich auskommentieren da es einen Entity fehler gab. hibernate konnte anscheinend die Tabelle in der Datenbank nicht anlegen!!!!!!!!!
 */
@Entity
public class Notification
{
    @Id
    @GeneratedValue
    private Long id;

    private String text;

    //private Benutzer benutzer;

    /**
     * Constructor.
     *
     * @param text      In diesem String steht die Benachrichtigung.
     * @param benutzer  Dieser Parameter bestimmt für wen die Benachrichtigung ist.
     */
    public Notification(String text, Benutzer benutzer) {
        this.text = text;
        //this.benutzer = benutzer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //public Benutzer getBenutzer() {
    //    return benutzer;
    //}

    //public void setBenutzer(Benutzer benutzer) {
    //   this.benutzer = benutzer;
    //}
}
