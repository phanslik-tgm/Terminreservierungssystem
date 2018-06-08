package hello;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * In dem BenutzerRepository werden die Objekte von Benutzer gespeichert. Diese werden auch automatisch in die H2 Dantenbank gespeichert.
 */
public interface BenutzerRepository extends JpaRepository<Benutzer, Long> {

    List<Benutzer> findByEmailStartsWithIgnoreCase(String email);
    //List<Benutzer> checkEmailAndPassword(String email,String password);
}

