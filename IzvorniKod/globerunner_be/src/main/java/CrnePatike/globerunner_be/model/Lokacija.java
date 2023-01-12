package CrnePatike.globerunner_be.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "lokacija")
public class Lokacija {
    @Id
    @Column(name = "id")
    private UUID id; // jedinstveni identifikator lokacije
    @Column(name = "name")
    private String name; // naziv lokacije
    @Column(name = "description")
    private String description; // sazeti opis lokacije
    @Lob
    @Column(name = "photo")
    private byte[] photo; // fotografija lokacije
    @Column(name = "strength")
    private String strength; // podatak za izracun pocetne jacine karte
    @Column(name = "type")
    private String locationType; // jedinstveni identifikator vrste lokacije

    public Lokacija() {
    }

    public Lokacija(UUID id, String name, String description, byte[] photo, String strength, String locationType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.strength = strength;
        this.locationType = locationType;
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

    public String getLocationType() {
        return locationType;
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

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }
}
