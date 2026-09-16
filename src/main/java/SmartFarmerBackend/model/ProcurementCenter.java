package SmartFarmerBackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "procurement_centers")
public class ProcurementCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int centerId;

    private String centerName;
    private String location;
    private String district;
    private int capacity;

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}