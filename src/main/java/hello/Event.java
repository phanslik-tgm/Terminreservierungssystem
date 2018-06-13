package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;
import java.util.*;

/**
 * Diese Klasse wird Benoetigt, damit man ein Objekt davon in das Repository und die H2 Datenbank speichern kann.
 */
@Entity
public class Event
{
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String beschreibung;

    //private Collection<Benutzer> teilnehmer;

    private Date beginn;

    private Date ende;


    //private Benutzer ersteller;

    /**
     * Construktor
     *
     * @param name
     * @param beschreibung
     * @param teilnehmer
     * @param beginn
     * @param ende
     * @param ersteller
     */
    public Event(String name, String beschreibung, Collection<Benutzer> teilnehmer, Date beginn, Date ende, Benutzer ersteller) {
        this.name = name;
        this.beschreibung = beschreibung;
        //this.teilnehmer = teilnehmer;
        this.beginn = beginn;
        this.ende = ende;
        //this.ersteller = ersteller;
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
     * Getter für den Namen des Events
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter für den Namen des Events
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter für die Beschreibung des Events
     * @return beschreibung
     */
    public String getBeschreibung() {
        return beschreibung;
    }

    /**
     * Setter für die Beschreibung des Events
     * @param beschreibung
     */
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    //public Collection<Benutzer> getTeilnehmer() {
    //    return teilnehmer;
    //}

    //public void setTeilnehmer(Collection<Benutzer> teilnehmer) {
    //    this.teilnehmer = teilnehmer;
    //}

    /**
     * Getter für die Startzeit und das Startdatum des Events
     * @return beginn
     */
    public Date getBeginn() {
        return beginn;
    }

    /**
     * Setter für die Startzeit und das Startdatum des Events
     * @param beginn
     */
    public void setBeginn(Date beginn) {
        this.beginn = beginn;
    }

    /**
     * Getter für die Endzeit und das Enddatum des Events
     * @return ende
     */
    public Date getEnde() {
        return ende;
    }

    /**
     * Setter für die Endzeit und das Enddatum des Events
     * @param ende
     */
    public void setEnde(Date ende) {
        this.ende = ende;
    }

    /**
     * toString
     * @return String der alle parameter ausgibt.
     */
    @Override
    public String toString() {
    	return String.format("Event[id=%d, name=%s, beschreibung=%s, beginn=%t, ende=%t]", 
    			id, name, beschreibung, beginn, ende);
    }

    //public Benutzer getErsteller() {
    //    return ersteller;
    //}

    //public void setErsteller(Benutzer ersteller) {
    //    this.ersteller = ersteller;
    //}
}
