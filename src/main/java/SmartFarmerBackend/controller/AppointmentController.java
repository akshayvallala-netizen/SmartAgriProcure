package SmartFarmerBackend.controller;

import SmartFarmerBackend.model.Appointment;
import SmartFarmerBackend.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Create a new appointment
    @PostMapping
    public Appointment createAppointment(
            @RequestBody Appointment appointment) {

        return appointmentService.createAppointment(appointment);
    }

    // Get appointment by ID
    @GetMapping("/{id}")
    public Appointment getAppointment(@PathVariable int id) {

        return appointmentService.getAppointmentById(id).orElse(null);
    }

    // Get all appointments of a farmer
    @GetMapping("/farmer/{farmerId}")
    public List<Appointment> getAppointmentsByFarmer(
            @PathVariable int farmerId) {

        return appointmentService.getAppointmentsByFarmer(farmerId);
    }

    // Get all appointments of a center
    @GetMapping("/center/{centerId}")
    public List<Appointment> getAppointmentsByCenter(
            @PathVariable int centerId) {

        return appointmentService.getAppointmentsByCenter(centerId);
    }

    // Update appointment status
    @PutMapping("/{id}/status")
    public Appointment updateStatus(
            @PathVariable int id,
            @RequestParam String status) {

        return appointmentService.updateStatus(id, status);
    }
}