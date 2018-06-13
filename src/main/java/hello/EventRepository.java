package hello;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * In dem EventRepository werden die Objekte von Event gespeichert. Diese werden auch automatisch in die H2 Dantenbank gespeichert.
 */
public interface EventRepository extends JpaRepository<Event, Long> {

	//List<Event> findByLastNameStartsWithIgnoreCase(String lastName);
}