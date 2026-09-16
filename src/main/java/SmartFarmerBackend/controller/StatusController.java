package SmartFarmerBackend.controller;

import SmartFarmerBackend.model.Crop;
import SmartFarmerBackend.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/status")
@CrossOrigin
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping("/{cropId}")
    public Crop getStatus(@PathVariable int cropId) {
        return statusService.getStatus(cropId);
    }

    @PutMapping("/{cropId}")
    public Crop updateStatus(
            @PathVariable int cropId,
            @RequestParam String status) {

        return statusService.updateStatus(cropId, status);
    }
}