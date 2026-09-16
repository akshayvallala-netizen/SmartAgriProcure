package SmartFarmerBackend.controller;

import SmartFarmerBackend.service.AIPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin
public class AIPredictionController {

    @Autowired
    private AIPredictionService aiPredictionService;

    @GetMapping("/queue/{farmersAhead}")
    public int predictQueueTime(
            @PathVariable int farmersAhead) {

        return aiPredictionService
                .predictWaitingTime(farmersAhead);
    }
}