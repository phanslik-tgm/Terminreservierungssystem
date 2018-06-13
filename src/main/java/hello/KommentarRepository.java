package hello;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
/**
 * In dem KommentarRepository werden die Objekte von Kommentar gespeichert. Diese werden auch automatisch in die H2 Dantenbank gespeichert.
 */
public interface KommentarRepository extends JpaRepository<Kommentar, Long> {

    //List<Kommentar> findByLastNameStartsWithIgnoreCase(String lastName);
}