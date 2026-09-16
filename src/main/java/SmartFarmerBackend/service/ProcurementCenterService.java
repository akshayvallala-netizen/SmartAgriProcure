package SmartFarmerBackend.service;

import SmartFarmerBackend.model.ProcurementCenter;
import SmartFarmerBackend.repository.ProcurementCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcurementCenterService {

    @Autowired
    private ProcurementCenterRepository centerRepository;

    // Add a new procurement center
    public ProcurementCenter addCenter(ProcurementCenter center) {
        return centerRepository.save(center);
    }

    // Get all procurement centers
    public List<ProcurementCenter> getAllCenters() {
        return centerRepository.findAll();
    }

    // Get center by ID
    public Optional<ProcurementCenter> getCenterById(int centerId) {
        return centerRepository.findById(centerId);
    }

    // Update center
    public ProcurementCenter updateCenter(int centerId, ProcurementCenter center) {

        Optional<ProcurementCenter> existingCenter =
                centerRepository.findById(centerId);

        if (existingCenter.isPresent()) {

            ProcurementCenter oldCenter = existingCenter.get();

            oldCenter.setCenterName(center.getCenterName());
            oldCenter.setLocation(center.getLocation());
            oldCenter.setDistrict(center.getDistrict());
            oldCenter.setCapacity(center.getCapacity());

            return centerRepository.save(oldCenter);
        }

        return null;
    }
}