package SmartFarmerBackend.service;

import SmartFarmerBackend.model.Appointment;
import SmartFarmerBackend.repository.AppointmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AICenterRecommendationService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public int recommendCenter() {

        List<Appointment> appointments =
                appointmentRepository.findAll();

        int center1Count = 0;
        int center2Count = 0;

        for (Appointment appointment : appointments) {

            if (appointment.getCenterId() == 1) {
                center1Count++;
            }

            if (appointment.getCenterId() == 2) {
                center2Count++;
            }
        }

        if (center1Count <= center2Count) {
            return 1;
        } else {
            return 2;
        }
    }
}