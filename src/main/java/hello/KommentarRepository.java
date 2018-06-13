package hello;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface KommentarRepository extends JpaRepository<Kommentar, Long> {

    //List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);
}