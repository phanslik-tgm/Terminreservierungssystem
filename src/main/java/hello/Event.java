package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;
import java.util.*;

@Entity
public class Event
{
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String beschreibung;

    private Collection<Benutzer> teilnehmer;

    private Date beginn;

    private Date ende;

    private Benutzer ersteller;

    public Event(String name, String beschreibung, Collection<Benutzer> teilnehmer, Date beginn, Date ende, Benutzer ersteller) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.teilnehmer = teilnehmer;
        this.beginn = beginn;
        this.ende = ende;
        this.ersteller = ersteller;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Collection<Benutzer> getTeilnehmer() {
        return teilnehmer;
    }

    public void setTeilnehmer(Collection<Benutzer> teilnehmer) {
        this.teilnehmer = teilnehmer;
    }

    public Date getBeginn() {
        return beginn;
    }

    public void setBeginn(Date beginn) {
        this.beginn = beginn;
    }

    public Date getEnde() {
        return ende;
    }

    public void setEnde(Date ende) {
        this.ende = ende;
    }

    public Benutzer getErsteller() {
        return ersteller;
    }

    public void setErsteller(Benutzer ersteller) {
        this.ersteller = ersteller;
    }
}
