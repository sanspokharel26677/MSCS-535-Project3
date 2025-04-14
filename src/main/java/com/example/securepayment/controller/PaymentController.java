// Program-level comment:
// This controller handles the web routes for displaying the payment form and processing submissions securely.

package com.example.securepayment.controller;

import com.example.securepayment.model.Payment;
import com.example.securepayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Method-level comment:
    // Displays the payment form
    @GetMapping("/payment")
    public String showPaymentForm(Model model) {
        model.addAttribute("payment", new Payment());
        return "payment-form"; // maps to payment-form.html
    }

    // Method-level comment:
    // Handles form submission and stores the payment securely
    @PostMapping("/payment")
    public String submitPayment(@ModelAttribute Payment payment, Model model) {
        boolean success = paymentService.processPayment(payment);

        if (!success) {
            model.addAttribute("payment", payment);
            model.addAttribute("error", "❌ Username does not exist. Please try again.");
            return "payment-form"; // Re-render form with error
        }

        model.addAttribute("username", payment.getUsername());
        model.addAttribute("amount", payment.getAmount());
        return "payment-success";
    }
}