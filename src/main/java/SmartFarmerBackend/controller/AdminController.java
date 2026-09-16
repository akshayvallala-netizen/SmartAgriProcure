package SmartFarmerBackend.controller;

import SmartFarmerBackend.model.Admin;
import SmartFarmerBackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody Admin admin) {
        return adminService.registerAdmin(admin);
    }

    @GetMapping("/{id}")
    public Admin getAdmin(@PathVariable int id) {
        return adminService.getAdminById(id).orElse(null);
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @PostMapping("/login")
    public Admin login(@RequestBody Admin admin) {
        return adminService.login(admin.getMobile())
                .filter(existingAdmin ->
                        existingAdmin.getPassword()
                                .equals(admin.getPassword()))
                .orElse(null);
    }
}