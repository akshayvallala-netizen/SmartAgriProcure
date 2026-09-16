package SmartFarmerBackend.controller;

import SmartFarmerBackend.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/queue")
@CrossOrigin
public class QueueController {

    @Autowired
    private QueueService queueService;

    @GetMapping("/{appointmentId}/ahead")
    public int getFarmersAhead(@PathVariable int appointmentId) {
        return queueService.getFarmersAhead(appointmentId);
    }

    @GetMapping("/{appointmentId}/wait-time")
    public int getEstimatedWaitTime(@PathVariable int appointmentId) {
        return queueService.getEstimatedWaitTime(appointmentId);
    }
}