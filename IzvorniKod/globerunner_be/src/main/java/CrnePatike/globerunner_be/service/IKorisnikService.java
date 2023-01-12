package CrnePatike.globerunner_be.service;

import CrnePatike.globerunner_be.model.Korisnik;

import java.util.List;
import java.util.Optional;

public interface IKorisnikService {
    List<Korisnik> findAll();

    Korisnik addNewUser(Korisnik korisnik);

    String checkCredentials(String username, String password);

    Optional<Korisnik> findByUsername(String username);
}
