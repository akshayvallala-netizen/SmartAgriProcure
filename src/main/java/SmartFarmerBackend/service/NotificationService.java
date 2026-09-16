package SmartFarmerBackend.service;

import SmartFarmerBackend.model.Notification;
import SmartFarmerBackend.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Optional<Notification> getNotificationById(int notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public List<Notification> getNotificationsByFarmer(int farmerId) {
        return notificationRepository.findByFarmerId(farmerId);
    }

    public Notification markAsRead(int notificationId) {

        Optional<Notification> optionalNotification =
                notificationRepository.findById(notificationId);

        if (optionalNotification.isPresent()) {

            Notification notification = optionalNotification.get();
            notification.setRead(true);

            return notificationRepository.save(notification);
        }

        return null;
    }
}