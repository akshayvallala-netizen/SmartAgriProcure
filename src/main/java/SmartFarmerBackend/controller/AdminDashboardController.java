package SmartFarmerBackend.controller;

import SmartFarmerBackend.model.Farmer;
import SmartFarmerBackend.model.Officer;
import SmartFarmerBackend.repository.FarmerRepository;
import SmartFarmerBackend.repository.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import SmartFarmerBackend.model.ProcurementCenter;
import SmartFarmerBackend.repository.ProcurementCenterRepository;
import SmartFarmerBackend.model.Crop;
import SmartFarmerBackend.repository.CropRepository;
import SmartFarmerBackend.model.Appointment;
import SmartFarmerBackend.repository.AppointmentRepository;
import SmartFarmerBackend.model.Payment;
import SmartFarmerBackend.repository.PaymentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/admin/dashboard")
@CrossOrigin
public class AdminDashboardController {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private OfficerRepository officerRepository;

    @GetMapping("/farmers")
    public List<Farmer> getAllFarmers() {
        return farmerRepository.findAll();
    }

    @GetMapping("/officers")
    public List<Officer> getAllOfficers() {
        return officerRepository.findAll();
    }
    @Autowired
private ProcurementCenterRepository centerRepository;

@GetMapping("/centers")
public List<ProcurementCenter> getAllCenters() {
    return centerRepository.findAll();
}
@Autowired
private CropRepository cropRepository;

@GetMapping("/crops")
public List<Crop> getAllCrops() {
    return cropRepository.findAll();
}
@Autowired
private AppointmentRepository appointmentRepository;

@GetMapping("/appointments")
public List<Appointment> getAllAppointments() {
    return appointmentRepository.findAll();
}
@Autowired
private PaymentRepository paymentRepository;

@GetMapping("/payments")
public List<Payment> getAllPayments() {
    return paymentRepository.findAll();
}
}