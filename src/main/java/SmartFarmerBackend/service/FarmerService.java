package SmartFarmerBackend.service;

import SmartFarmerBackend.model.Farmer;
import SmartFarmerBackend.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    public Farmer register(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    public Optional<Farmer> login(String mobile) {
        return farmerRepository.findByMobile(mobile);
    }
}