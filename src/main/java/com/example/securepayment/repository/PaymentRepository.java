// Program-level comment:
// Repository interface for Payment entity — Spring Data JPA handles implementation automatically

package com.example.securepayment.repository;

import com.example.securepayment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}