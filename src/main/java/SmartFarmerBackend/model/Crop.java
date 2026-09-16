package SmartFarmerBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "crops")
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cropId;

    private int farmerId;
    private String cropName;
    private double quantity;
    private String harvestDate;
    private int centerId;
    private String status = "REGISTERED";

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(String harvestDate) {
        this.harvestDate = harvestDate;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}