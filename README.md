# Secure Online Payment System

This is a Spring Boot application built to demonstrate a secure online payment system that protects against common web vulnerabilities, specifically:

- **SQL Injection**
- **Cross-Site Scripting (XSS)**

---

## 🔐 Features

- ✅ Validates if a user exists before allowing payment
- ✅ Escapes user input to prevent cross-site scripting
- ✅ Stores payments securely using Spring Data JPA (prevents SQL Injection)
- ✅ Displays escaped values in the UI (XSS demo)
- ✅ Friendly error handling and feedback messages

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Thymeleaf (for HTML frontend)
- MySQL
- Apache Commons Text (for XSS protection)

---

## 🚀 How to Run the Project

### 1. **Create the MySQL Database**

Before running the app, please make sure to:

- Create a database named `payment_db` in your local MySQL instance.
- Use the following SQL to create the necessary tables and preload user data:

```sql
CREATE DATABASE IF NOT EXISTS payment_db;
USE payment_db;

CREATE TABLE IF NOT EXISTS user (
  username VARCHAR(255) PRIMARY KEY
);

INSERT IGNORE INTO user (username) VALUES ('alice'), ('bob'), ('charlie');

CREATE TABLE IF NOT EXISTS payment (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255),
  card_number VARCHAR(20),
  cvv VARCHAR(10),
  amount DOUBLE
);
```

### 2. Update application.properties
Ensure the following is set in src/main/resources/application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/payment_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=false

Replace yourpassword with your actual MySQL root password.

### 3. Build and Run
From your terminal:
./gradlew bootRun
Or use IntelliJ: Right-click the SecurePaymentAppApplication.java file and choose Run.

### 4. How to Test
1.	Open your browser and go to:
http://localhost:8080/payment
2.	Use the following test cases:
•	Username: alice → should show success message.
•	Username: <script>alert(1)</script> → should show escaped HTML (not executed).
•	Username: randomUser → should show error message.
3.	Check the database to confirm that records are stored securely.

### 5. Notes for Instructor
	•	The system does not use raw SQL and all inputs are sanitized.
	•	You can manually test XSS by typing a script tag in the username.
	•	You can also observe the backend console log or use the database to validate stored inputs.

### 6. 📞 Contact

Sandesh Pokharel
Graduate Student — MSCS 535
University of the Cumberlands