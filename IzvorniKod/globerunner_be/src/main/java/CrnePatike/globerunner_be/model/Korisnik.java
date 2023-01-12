package CrnePatike.globerunner_be.model;

import org.apache.el.parser.AstFalse;
import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "Korisnik")
public class Korisnik {

    @Id
    @NonNull
    @Column(name = "username")
    private String username; // korisnicko ime
    @NonNull
    @Column(name = "password")
    private String password; // lozinka
    // @NonNull
    // @Lob
    @Column(name = "photo")
    private String photo; // fotografija
    @NonNull
    @Column(name = "email", unique = true)
    private String email; // email
    @Column(name = "role")
    private String role; // uloga - player, cartographer ili admin
    @Column(name = "iban")
    private String iban; // iban
    // @Lob
    @Column(name = "idPhoto")
    private String idPhoto; // fotografija osobne iskaznice
    @Column(name = "rating")
    private int rating; // rating - broj bodova
    @Column(name = "banned")
    private boolean banned = true; // je li igrač trenutno isključen  iz igre

    public Korisnik() {
    }

    // konstruktor za obicnog igraca
    public Korisnik(String username,
                    String password,
                    String photo,
                    String email) {
        this.username = username;
        this.password = password;
        this.photo = photo;
        this.email = email;
        this.role = "player";
        this.rating = 1000;
        this.banned = true;
    }

    // konstruktor za kartografa
    public Korisnik(String username,
                    String password,
                    String photo,
                    String email,
                    String idPhoto,
                    String iban) {
        this.username = username;
        this.password = password;
        this.photo = photo;
        this.email = email;
        this.iban = iban;
        this.idPhoto = idPhoto;
        this.role = "player"; // nakon sto ga admin potvrdi, role se mijenja u "cartographer"
        this.rating = 1000;
        this.banned = true;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoto() {
        return photo;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getIban() {
        return iban;
    }

    public String getIdPhoto() {
        return idPhoto;
    }

    public int getRating() {
        return rating;
    }

    public boolean isBanned() {
        return banned;
    }
}
