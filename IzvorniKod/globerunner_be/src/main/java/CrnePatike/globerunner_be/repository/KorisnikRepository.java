package CrnePatike.globerunner_be.repository;

import CrnePatike.globerunner_be.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, String> {
    Optional<Korisnik> findByUsername(String username);
    Optional<Korisnik> findByEmail(String email);
}
