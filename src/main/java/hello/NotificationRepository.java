package hello;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    //List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);
}