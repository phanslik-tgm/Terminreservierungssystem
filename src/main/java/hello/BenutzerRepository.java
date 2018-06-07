package hello;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BenutzerRepository extends JpaRepository<Benutzer, Long> {

    List<Benutzer> findByEmailStartsWithIgnoreCase(String email);
    //List<Benutzer> checkEmailAndPassword(String email,String password);
}

