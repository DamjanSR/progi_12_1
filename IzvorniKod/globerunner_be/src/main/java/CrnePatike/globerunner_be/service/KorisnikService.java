package CrnePatike.globerunner_be.service;

import CrnePatike.globerunner_be.model.Korisnik;
import CrnePatike.globerunner_be.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KorisnikService implements IKorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public KorisnikService(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    private List<Korisnik> findByEmail(String email) {
        List<Korisnik> allUsers = findAll();
        List<Korisnik> retVal = new ArrayList<>();
        for (Korisnik k : allUsers) {
            if (email == k.getEmail()) {
                retVal.add(k);
            }
        }
        System.out.println(retVal);
        return retVal;
    }

    @Override
    public Optional<Korisnik> findByUsername(String username) {
        return korisnikRepository.findByUsername(username);
    }


    @Override
    public List<Korisnik> findAll() {
        var korisnici = (List<Korisnik>) korisnikRepository.findAll();
        return korisnici;
    }

    @Override
    public Korisnik addNewUser(Korisnik korisnik) {
        if (korisnikRepository.findById(korisnik.getUsername()).isEmpty() &&
            findByEmail(korisnik.getEmail()).size() == 0) {
            korisnikRepository.save(korisnik);
            return korisnik;
        }
        return null;
    }

    @Override
    public String checkCredentials(String username, String password) {
        Optional<Korisnik> k = findByUsername(username);
        if(!k.isEmpty()) {
            String passwordKorisnik = k.get().getPassword();
            if(passwordKorisnik.contentEquals(password)) {
                return "success";
            }
        }
        return "fail";
    }
}
