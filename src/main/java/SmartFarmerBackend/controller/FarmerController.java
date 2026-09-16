package SmartFarmerBackend.controller;

import SmartFarmerBackend.model.Farmer;
import SmartFarmerBackend.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/farmers")
@CrossOrigin
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @PostMapping("/register")
    public Farmer register(@RequestBody Farmer farmer) {
        return farmerService.register(farmer);
    }

    @PostMapping("/login")
    public Farmer login(@RequestBody Farmer farmer) {
        return farmerService.login(farmer.getMobile())
                .filter(existingFarmer ->
                        existingFarmer.getPassword()
                                .equals(farmer.getPassword()))
                .orElse(null);
    }
}