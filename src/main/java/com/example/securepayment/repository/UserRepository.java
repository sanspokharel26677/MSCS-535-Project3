// Program-level comment:
// Repository interface for managing user validation — checks if a user is allowed to make payments

package com.example.securepayment.repository;

import com.example.securepayment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // Custom method to check if username exists
    boolean existsByUsername(String username);
}