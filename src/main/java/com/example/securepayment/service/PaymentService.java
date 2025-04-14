// Program-level comment:
// This service now checks if the username exists before processing the payment securely.

package com.example.securepayment.service;

import com.example.securepayment.model.Payment;
import com.example.securepayment.repository.PaymentRepository;
import com.example.securepayment.repository.UserRepository;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    // Method-level comment:
    // Processes payment only if username exists; escapes inputs to prevent XSS
    public boolean processPayment(Payment payment) {
        // Check if the username exists in the database
        if (!userRepository.existsByUsername(payment.getUsername())) {
            return false; // User not found
        }

        // Escape inputs to prevent XSS
        payment.setUsername(StringEscapeUtils.escapeHtml4(payment.getUsername()));
        payment.setCardNumber(StringEscapeUtils.escapeHtml4(payment.getCardNumber()));
        payment.setCvv(StringEscapeUtils.escapeHtml4(payment.getCvv()));

        // Save securely using JPA (safe from SQL injection)
        paymentRepository.save(payment);
        return true; // Payment processed
    }
}