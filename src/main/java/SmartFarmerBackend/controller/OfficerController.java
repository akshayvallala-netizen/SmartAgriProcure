package SmartFarmerBackend.controller;

import SmartFarmerBackend.model.Officer;
import SmartFarmerBackend.service.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/officers")
@CrossOrigin
public class OfficerController {

    @Autowired
    private OfficerService officerService;

    @PostMapping("/register")
    public Officer registerOfficer(@RequestBody Officer officer) {
        return officerService.registerOfficer(officer);
    }

    @GetMapping("/{id}")
    public Officer getOfficer(@PathVariable int id) {
        return officerService.getOfficerById(id).orElse(null);
    }

    @GetMapping
    public List<Officer> getAllOfficers() {
        return officerService.getAllOfficers();
    }

    @PostMapping("/login")
    public Officer login(@RequestBody Officer officer) {
        return officerService.login(officer.getMobile())
                .filter(existingOfficer ->
                        existingOfficer.getPassword()
                                .equals(officer.getPassword()))
                .orElse(null);
    }
}