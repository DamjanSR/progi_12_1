package CrnePatike.globerunner_be.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "karta")
public class Karta {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "strength")
    private int strength;
    @Column(name = "username")
    private String username;
    @Column(name = "locationId")
    private UUID locationId;

    public Karta() {
    }

    public Karta(UUID id, int strength, String username, UUID locationId) {
        this.id = id;
        this.strength = strength;
        this.username = username;
        this.locationId = locationId;
    }

    public UUID getId() {
        return id;
    }

    public int getStrength() {
        return strength;
    }

    public String getUsername() {
        return username;
    }

    public UUID getLocationId() {
        return locationId;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLocationId(UUID locationId) {
        this.locationId = locationId;
    }
}
