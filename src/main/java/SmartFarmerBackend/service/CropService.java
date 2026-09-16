package SmartFarmerBackend.service;

import SmartFarmerBackend.model.Crop;
import SmartFarmerBackend.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    // Register a new crop
    public Crop registerCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    // Get crop by ID
    public Optional<Crop> getCropById(int cropId) {
        return cropRepository.findById(cropId);
    }

    // Get all crops of a farmer
    public List<Crop> getCropsByFarmer(int farmerId) {
        return cropRepository.findByFarmerId(farmerId);
    }

    public List<Crop> getCropsByCenter(int centerId) {
    return cropRepository.findByCenterId(centerId);
}

    // Update crop status
    public Crop updateStatus(int cropId, String status) {

        Optional<Crop> optionalCrop = cropRepository.findById(cropId);

        if (optionalCrop.isPresent()) {
            Crop crop = optionalCrop.get();
            crop.setStatus(status);
            return cropRepository.save(crop);
        }

        return null;
    }
}
