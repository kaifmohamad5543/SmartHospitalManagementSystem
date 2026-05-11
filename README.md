# Smart Hospital Management System

## Overview
The Smart Hospital Management System is a Java-based software application developed using Object-Oriented Programming (OOP), MVC architecture, and software design patterns. The system simulates hospital operations such as patient management, appointment booking, billing, notifications, analytics dashboards, and security management.

---

## Features

- Patient Registration
- Doctor Management
- Appointment Scheduling
- Billing Management
- Emergency Billing
- Email Notification Simulation
- SMS Notification Simulation
- Real-Time Dashboard
- Hospital Analytics Graph
- SHA-256 Password Hashing
- JUnit Testing
- Observer Pattern Notifications
- Strategy Pattern Billing
- Factory Pattern User Creation
- Singleton Pattern System Control

---

## Technologies Used

- Java
- Java Swing
- JUnit 5
- MVC Architecture
- Object-Oriented Programming
- Git & GitHub

---

## Design Patterns Implemented

### Singleton Pattern
Used in:
- HospitalManagementSystem

Purpose:
- Ensures only one central hospital management system object exists.

### Factory Pattern
Used in:
- UserFactory

Purpose:
- Dynamically creates Patient, Doctor, and Admin objects.

### Observer Pattern
Used in:
- PatientObserver
- DoctorObserver

Purpose:
- Sends real-time appointment notifications.

### Strategy Pattern
Used in:
- StandardBilling
- InsuranceBilling
- EmergencyBilling

Purpose:
- Implements different hospital billing strategies.

---

## Security Features

- SHA-256 Password Hashing
- Secure Authentication Simulation
- Role-Based User Structure

---

## Testing

The project includes:
- Manual Testing
- JUnit Testing
- Billing Validation
- Security Validation
- Singleton Pattern Testing

---

## Dashboard Features

- Hospital Analytics Dashboard
- Real-Time Graph Visualization
- Admin Panel
- Notification Panel
- Billing Statistics

---

## Project Structure

```text
src/
├── analytics
├── controller
├── dashboard
├── model
├── notification
├── pattern
├── security
├── testing
├── view
└── Main.java
