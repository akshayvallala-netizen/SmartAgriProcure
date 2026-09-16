package SmartFarmerBackend.service;

import SmartFarmerBackend.model.Appointment;
import SmartFarmerBackend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueueService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Get queue position of a farmer's appointment
    public int getFarmersAhead(int appointmentId) {

        Appointment appointment =
                appointmentRepository.findById(appointmentId).orElse(null);

        if (appointment == null) {
            return -1;
        }

        List<Appointment> appointments =
                appointmentRepository.findByCenterId(
                        appointment.getCenterId());

        int farmersAhead = 0;

        for (Appointment a : appointments) {

            if (a.getTokenNumber() < appointment.getTokenNumber()
                    && a.getStatus().equals("BOOKED")) {

                farmersAhead++;
            }
        }

        return farmersAhead;
    }

    // Calculate estimated waiting time
    public int getEstimatedWaitTime(int appointmentId) {

        int farmersAhead = getFarmersAhead(appointmentId);

        if (farmersAhead < 0) {
            return -1;
        }

        // Assume 5 minutes per farmer
        return farmersAhead * 5;
    }
}