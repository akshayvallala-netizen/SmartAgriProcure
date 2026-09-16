package SmartFarmerBackend.service;

import SmartFarmerBackend.model.Crop;
import SmartFarmerBackend.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Autowired
    private CropRepository cropRepository;

    public Crop getStatus(int cropId) {

        return cropRepository.findById(cropId).orElse(null);
    }

    public Crop updateStatus(int cropId, String status) {

        Crop crop = cropRepository.findById(cropId).orElse(null);

        if (crop != null) {
            crop.setStatus(status);
            return cropRepository.save(crop);
        }

        return null;
    }
}