package hello;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * In dem NotificationRepository werden die Objekte von Notification gespeichert. Diese werden auch automatisch in die H2 Dantenbank gespeichert.
 */
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    //List<Notification> findByLastNameStartsWithIgnoreCase(String lastName);
}