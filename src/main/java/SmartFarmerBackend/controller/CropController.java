package SmartFarmerBackend.controller;

import SmartFarmerBackend.model.Crop;
import SmartFarmerBackend.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
@CrossOrigin
public class CropController {

    @Autowired
    private CropService cropService;

    // Register a crop
    @PostMapping
    public Crop registerCrop(@RequestBody Crop crop) {
        return cropService.registerCrop(crop);
    }

    // Get crop by ID
    @GetMapping("/{id}")
    public Crop getCrop(@PathVariable int id) {
        return cropService.getCropById(id).orElse(null);
    }

    // Get all crops of a farmer
    @GetMapping("/farmer/{farmerId}")
    public List<Crop> getCropsByFarmer(@PathVariable int farmerId) {
        return cropService.getCropsByFarmer(farmerId);
    }

    @GetMapping("/center/{centerId}")
public List<Crop> getCropsByCenter(@PathVariable int centerId) {
    return cropService.getCropsByCenter(centerId);
}

    // Update crop status
    @PutMapping("/{id}/status")
    public Crop updateStatus(
            @PathVariable int id,
            @RequestParam String status) {

        return cropService.updateStatus(id, status);
    }
}