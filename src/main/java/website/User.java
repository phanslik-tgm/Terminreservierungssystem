package website;

public class User
{
    int id;
    boolean organisator;
    String vorname;
    String nachname;
    String email;
    String password;


    User(int id, boolean organisator, String vorname, String nachname, String email, String password)
    {
        this.id=id;
        this.organisator=organisator;
        this.vorname=vorname;
        this.nachname=nachname;
        this.email=email;
        this.password=password;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public boolean isOrganisator()
    {
        return organisator;
    }

    public void setOrganisator(boolean organisator)
    {
        this.organisator = organisator;
    }

    public String getVorname()
    {
        return vorname;
    }

    public void setVorname(String vorname)
    {
        this.vorname = vorname;
    }

    public String getNachname()
    {
        return nachname;
    }

    public void setNachname(String nachname)
    {
        this.nachname = nachname;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
