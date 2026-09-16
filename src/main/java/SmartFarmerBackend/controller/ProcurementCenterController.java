package SmartFarmerBackend.controller;

import SmartFarmerBackend.model.ProcurementCenter;
import SmartFarmerBackend.service.ProcurementCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/centers")
@CrossOrigin
public class ProcurementCenterController {

    @Autowired
    private ProcurementCenterService centerService;

    // Add a new procurement center
    @PostMapping
    public ProcurementCenter addCenter(@RequestBody ProcurementCenter center) {
        return centerService.addCenter(center);
    }

    // Get all procurement centers
    @GetMapping
    public List<ProcurementCenter> getAllCenters() {
        return centerService.getAllCenters();
    }

    // Get center by ID
    @GetMapping("/{id}")
    public ProcurementCenter getCenter(@PathVariable int id) {
        return centerService.getCenterById(id).orElse(null);
    }

    // Update procurement center
    @PutMapping("/{id}")
    public ProcurementCenter updateCenter(
            @PathVariable int id,
            @RequestBody ProcurementCenter center) {

        return centerService.updateCenter(id, center);
    }
}