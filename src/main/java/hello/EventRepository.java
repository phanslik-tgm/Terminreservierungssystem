package hello;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Customer, Long> {

	//List<Event> findByLastNameStartsWithIgnoreCase(String lastName);
}