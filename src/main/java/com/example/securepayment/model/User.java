// Program-level comment:
// This entity represents valid users allowed to make payments in the system.

package com.example.securepayment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    // Primary key will be the username (assumed to be unique)
    @Id
    private String username;

    // Constructor, getters, setters

    public User() {}

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}