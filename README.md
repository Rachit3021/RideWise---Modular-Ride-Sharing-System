# RideWise - Console Based Ride Sharing System

## Overview
RideWise is a console-based Ride Sharing System built using Core Java.  
The project demonstrates Low-Level Design (LLD), Object-Oriented Programming (OOP), SOLID Principles, and the Strategy Design Pattern.

Users can:
- Register Riders
- Register Drivers
- View Available Drivers
- Request Rides
- Complete Rides
- View Ride Details

---

# Features

- Rider Management
- Driver Management
- Ride Booking
- Driver Matching Strategies
- Fare Calculation Strategies
- Ride Status Tracking
- Exception Handling

---

# Technologies Used

- Core Java
- OOP Concepts
- Java Collections
- Exception Handling
- Strategy Design Pattern
- SOLID Principles

---

# Project Structure

src/
└── com/
    └── airtribe/
        └── ridewise/
            ├── Main.java
            │
            ├── model/
            │   ├── Rider.java
            │   ├── Driver.java
            │   ├── Ride.java
            │   ├── FareReceipt.java
            │   ├── RideStatus.java
            │   └── VehicleType.java
            │
            ├── strategy/
            │   ├── RideMatchingStrategy.java
            │   ├── NearestDriverStrategy.java
            │   ├── LeastActiveDriverStrategy.java
            │   ├── FareStrategy.java
            │   ├── DefaultFareStrategy.java
            │   └── PeakHourFareStrategy.java
            │
            ├── service/
            │   ├── RiderService.java
            │   ├── DriverService.java
            │   └── RideService.java
            │
            ├── exception/
            │   └── NoDriverAvailableException.java
            │
            └── util/
                └── IdGenerator.java

---

# OOP Concepts Used

- Encapsulation
- Abstraction
- Inheritance
- Polymorphism

---

# SOLID Principles Applied

## SRP
Each class has a single responsibility.

## OCP
New strategies can be added without modifying existing code.

## LSP
Any strategy implementation can replace another.

## ISP
Small focused interfaces are used.

## DIP
Services depend on interfaces instead of concrete classes.

---

# Design Pattern Used

## Strategy Pattern

### Ride Matching Strategies
- NearestDriverStrategy
- LeastActiveDriverStrategy

### Fare Strategies
- DefaultFareStrategy
- PeakHourFareStrategy

---

# Ride Lifecycle

REQUESTED → ASSIGNED → COMPLETED → CANCELLED

---

# Menu Options

1. Add Rider
2. Add Driver
3. View Available Drivers
4. Request Ride
5. Complete Ride
6. View All Rides
7. Exit

---

# Sample Input

## Add Rider

1
Rachit
10

## Add Driver

2
Aman
12
3

## Request Ride

4
<rider-id>
15

---

# Future Improvements

- Database Integration
- GPS Coordinates
- Payment Gateway
- Driver Ratings
- REST APIs
- Authentication

---

# Learning Outcomes

- Low-Level Design
- Strategy Pattern
- Dependency Injection
- Layered Architecture
- Clean Code Practices
- Scalable Design

---
