package SmartFarmerBackend.service;

import SmartFarmerBackend.model.Officer;
import SmartFarmerBackend.repository.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficerService {

    @Autowired
    private OfficerRepository officerRepository;

    public Officer registerOfficer(Officer officer) {
        return officerRepository.save(officer);
    }

    public Optional<Officer> getOfficerById(int officerId) {
        return officerRepository.findById(officerId);
    }

    public List<Officer> getAllOfficers() {
        return officerRepository.findAll();
    }

    public Optional<Officer> login(String mobile) {
        return officerRepository.findByMobile(mobile);
    }
}