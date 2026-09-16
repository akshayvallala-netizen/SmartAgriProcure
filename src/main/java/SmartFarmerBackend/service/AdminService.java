package SmartFarmerBackend.service;

import SmartFarmerBackend.model.Admin;
import SmartFarmerBackend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin registerAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Optional<Admin> getAdminById(int adminId) {
        return adminRepository.findById(adminId);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> login(String mobile) {
        return adminRepository.findByMobile(mobile);
    }
}