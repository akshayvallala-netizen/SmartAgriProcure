package SmartFarmerBackend.controller;

import SmartFarmerBackend.service.AICenterRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin
public class AICenterRecommendationController {

    @Autowired
    private AICenterRecommendationService service;

    @GetMapping("/recommend-center")
    public int recommendCenter() {
        return service.recommendCenter();
    }
}