package SmartFarmerBackend.controller;

import SmartFarmerBackend.model.Payment;
import SmartFarmerBackend.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Create payment
    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    // Get all payments
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Get payment by ID
    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable int id) {
        return paymentService.getPaymentById(id).orElse(null);
    }

    // Get payments of a farmer
    @GetMapping("/farmer/{farmerId}")
    public List<Payment> getPaymentsByFarmer(
            @PathVariable int farmerId) {

        return paymentService.getPaymentsByFarmer(farmerId);
    }

    // Update payment status
    @PutMapping("/{id}/status")
    public Payment updateStatus(
            @PathVariable int id,
            @RequestParam String status) {

        return paymentService.updateStatus(id, status);
    }
}
