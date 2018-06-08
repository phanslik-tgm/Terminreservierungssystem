package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Kommentar
{
    @Id
    @GeneratedValue
    private Long id;

    private String text;

    //private Benutzer benutzer;

    public Kommentar(String text, Benutzer benutzer) {
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
     //   return benutzer;
    //}

    //public void setBenutzer(Benutzer benutzer) {
    //    this.benutzer = benutzer;
    //}
}
