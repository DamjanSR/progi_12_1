package CrnePatike.globerunner_be.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "lokacijaZaPotvrdu")
public class LokacijaZaPotvrdu {
    @Id
    @Column(name = "id")
    private UUID id; // jedinstveni identifikator lokacije za potvrdu
    @Column(name = "name")
    private String name; // naziv lokacije
    @Column(name = "description")
    private String description; // opis lokacije
    @Lob
    @Column(name = "photo")
    private byte[] photo; // fotografija lokacije
    @Column(name = "strength")
    private String strength;
    // ne treba oznaka je li potrebna potvrda s terena jer se nakon potvrde
    // lokacija brise iz ove tablice i premjesta se u tablicu lokacija
    @Column(name = "cartographer")
    private String cartographerUsername; // korisnicko ime kartografa koji ce izvrsiti potvrdu s terena
    @Column(name = "type_id")
    private int locationTypeId; // jedinstveni identifikator vrste lokacije
    @Column(name = "reporter")
    private String reporterUsername; // korisnicko ime korisnika koji je prijavio lokaciju za potvrdu

    public LokacijaZaPotvrdu() {
    }

    public LokacijaZaPotvrdu(UUID id, String name, String description, byte[] photo, String strength, String cartographerUsername, int locationTypeId, String reporterUsername) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.strength = strength;
        this.cartographerUsername = cartographerUsername;
        this.locationTypeId = locationTypeId;
        this.reporterUsername = reporterUsername;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public String getStrength() {
        return strength;
    }

    public String getCartographerUsername() {
        return cartographerUsername;
    }

    public int getLocationTypeId() {
        return locationTypeId;
    }

    public String getReporterUsername() {
        return reporterUsername;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public void setCartographerUsername(String cartographerUsername) {
        this.cartographerUsername = cartographerUsername;
    }

    public void setLocationTypeId(int locationTypeId) {
        this.locationTypeId = locationTypeId;
    }

    public void setReporterUsername(String reporterUsername) {
        this.reporterUsername = reporterUsername;
    }
}
