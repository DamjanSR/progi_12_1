package CrnePatike.globerunner_be.api;


import CrnePatike.globerunner_be.exceptions.NotEnoughParametersException;
import CrnePatike.globerunner_be.exceptions.UserAlreadyExistsException;
import CrnePatike.globerunner_be.exceptions.UserNotFoundException;
import CrnePatike.globerunner_be.model.Korisnik;
import CrnePatike.globerunner_be.service.IKorisnikService;
import CrnePatike.globerunner_be.service.KorisnikService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.plaf.multi.MultiListUI;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(allowedHeaders = {"Authorization", "Origin"})
//@CrossOrigin(origins = "http://localhost:3000",
//@CrossOrigin(allowedHeaders = {"Authorization", "Origin"})
//        exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"},
//        allowCredentials = "true")
public class KorisnikController {

    private final IKorisnikService korisnikService;

    @Autowired
    public KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }

    @CrossOrigin("*")
    @PostMapping("/api/v1/allUsers")
    public void login(@RequestBody Korisnik korisnik) {
        if (korisnik.getUsername() == null ||
                korisnik.getPassword() == null) {
            throw new NotEnoughParametersException("no no");
        }
        String res = korisnikService.checkCredentials(korisnik.getUsername(), korisnik.getPassword());
        if (res.equals("fail")) {
            throw new UserNotFoundException("Pogresno korisnicko ime ili lozinka");
        }
    }

    @CrossOrigin("*")
    @PostMapping("api/v1/addNewPlayer") // http://localhost:8080/api/v1/addNewPlayer
    public void addNewPlayer(@RequestBody Korisnik korisnik) {
        try {
            if (korisnik.getUsername() == null ||
                    korisnik.getPassword() == null ||
                    korisnik.getPhoto() == null ||
                    korisnik.getEmail() == null) {
                throw new NotEnoughParametersException("no no");
            }

            Path path = savePhoto(korisnik, 0);

            Korisnik newUser = new Korisnik(korisnik.getUsername(),
                    korisnik.getPassword(),
                    path.toString(),
                    korisnik.getEmail());
            var res = korisnikService.addNewUser(newUser);
            if (res == null) {
                throw new UserAlreadyExistsException("no-no");
            }
        } catch (Exception e) {
            throw new UserAlreadyExistsException("no-no");
        }
    }

    @CrossOrigin("*")
    @PostMapping("api/v1/addNewCartographer")
    public void addNewCartographer(@RequestBody Korisnik korisnik) {
        try {
            if (korisnik.getUsername() == null ||
                    korisnik.getPassword() == null ||
                    korisnik.getPhoto() == null ||
                    korisnik.getEmail() == null ||
                    korisnik.getIdPhoto() == null ||
                    korisnik.getIban() == null) {
                throw new NotEnoughParametersException("no no");
            }

            Path path0 = savePhoto(korisnik, 0);
            Path path1 = savePhoto(korisnik, 1);

            Korisnik newUser = new Korisnik(korisnik.getUsername(),
                    korisnik.getPassword(),
                    path0.toString(),
                    korisnik.getEmail(),
                    path1.toString(),
                    korisnik.getIban());
            var res = korisnikService.addNewUser(newUser);
            if (res == null) {
                throw new UserAlreadyExistsException("no-no");
            }
        } catch (Exception e) {
            throw new UserAlreadyExistsException("no-no");
        }
    }

    public Path savePhoto(Korisnik korisnik, int uloga) {
        Path path = null;

        try {
            String extension = null;
            byte[] decodedString = null;
            String folder = "src/main/resources/static/";

            if(uloga == 0) {
                extension = korisnik.getPhoto().split("/")[1].split(";")[0];
                decodedString = Base64.getDecoder()
                        .decode(korisnik.getPhoto().substring(korisnik.getPhoto().indexOf(',') + 1)
                                .getBytes("UTF-8"));
                path = Paths.get(folder + korisnik.getUsername() + "." + extension).toAbsolutePath();
            } else {
                extension = korisnik.getIdPhoto().split("/")[1].split(";")[0];
                decodedString = Base64.getDecoder()
                        .decode(korisnik.getIdPhoto().substring(korisnik.getIdPhoto().indexOf(',') + 1)
                                .getBytes("UTF-8"));
                path = Paths.get(folder + korisnik.getUsername() + "ID." + extension).toAbsolutePath();
            }
            Files.write(path, decodedString);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return path;
    }
}
