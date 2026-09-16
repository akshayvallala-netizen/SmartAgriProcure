package SmartFarmerBackend.service;

import SmartFarmerBackend.model.Appointment;
import SmartFarmerBackend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Create a new appointment
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Get appointment by ID
    public Optional<Appointment> getAppointmentById(int appointmentId) {
        return appointmentRepository.findById(appointmentId);
    }

    // Get all appointments of a farmer
    public List<Appointment> getAppointmentsByFarmer(int farmerId) {
        return appointmentRepository.findByFarmerId(farmerId);
    }

    // Get all appointments of a center
    public List<Appointment> getAppointmentsByCenter(int centerId) {
        return appointmentRepository.findByCenterId(centerId);
    }

    // Update appointment status
    public Appointment updateStatus(int appointmentId, String status) {

        Optional<Appointment> optionalAppointment =
                appointmentRepository.findById(appointmentId);

        if (optionalAppointment.isPresent()) {

            Appointment appointment = optionalAppointment.get();

            appointment.setStatus(status);

            return appointmentRepository.save(appointment);
        }

        return null;
    }
}