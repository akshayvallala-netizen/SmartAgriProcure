package SmartFarmerBackend.controller;

import SmartFarmerBackend.model.Notification;
import SmartFarmerBackend.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public Notification createNotification(
            @RequestBody Notification notification) {
        return notificationService.createNotification(notification);
    }

    @GetMapping("/{id}")
    public Notification getNotification(@PathVariable int id) {
        return notificationService.getNotificationById(id).orElse(null);
    }

    @GetMapping("/farmer/{farmerId}")
    public List<Notification> getNotificationsByFarmer(
            @PathVariable int farmerId) {
        return notificationService.getNotificationsByFarmer(farmerId);
    }

    @PutMapping("/{id}/read")
    public Notification markAsRead(@PathVariable int id) {
        return notificationService.markAsRead(id);
    }
}