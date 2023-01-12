package CrnePatike.globerunner_be.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vrstaLokacije")
public class VrstaLokacije {
    @Id
    @Column(name = "id")
    private int locationTypeId; // jedinstveni identifikator vrste lokacije
    @Column(name = "type")
    private String locationType; // naziv vrste lokacije

    public VrstaLokacije() {
    }

    public VrstaLokacije(int locationTypeId, String locationType) {
        this.locationTypeId = locationTypeId;
        this.locationType = locationType;
    }

    public int getLocationTypeId() {
        return locationTypeId;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationTypeId(int locationTypeId) {
        this.locationTypeId = locationTypeId;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }
}
