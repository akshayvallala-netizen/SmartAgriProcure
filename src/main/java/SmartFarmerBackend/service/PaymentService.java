package SmartFarmerBackend.service;

import SmartFarmerBackend.model.Payment;
import SmartFarmerBackend.repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // Create payment
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Get all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get payment by ID
    public Optional<Payment> getPaymentById(int paymentId) {
        return paymentRepository.findById(paymentId);
    }

    // Get payments by farmer
    public List<Payment> getPaymentsByFarmer(int farmerId) {
        return paymentRepository.findByFarmerId(farmerId);
    }

    // Update payment status
    public Payment updateStatus(int paymentId, String status) {

        Optional<Payment> optionalPayment =
                paymentRepository.findById(paymentId);

        if (optionalPayment.isPresent()) {

            Payment payment = optionalPayment.get();

            payment.setStatus(status);

            return paymentRepository.save(payment);
        }

        return null;
    }
}