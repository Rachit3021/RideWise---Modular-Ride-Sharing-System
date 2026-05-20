package com.airtribe.ridewise.service;

import com.airtribe.ridewise.exception.NoDriverAvailableException;
import com.airtribe.ridewise.model.*;

import com.airtribe.ridewise.strategy.FareStrategy;
import com.airtribe.ridewise.strategy.RideMatchingStrategy;
import com.airtribe.ridewise.util.IdGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RideService {

    private List<Ride> rides;

    private DriverService driverService;

    private RideMatchingStrategy rideMatchingStrategy;

    private FareStrategy fareStrategy;

    public RideService(DriverService driverService,
                       RideMatchingStrategy rideMatchingStrategy,
                       FareStrategy fareStrategy) {

        this.rides = new ArrayList<>();

        this.driverService = driverService;
        this.rideMatchingStrategy = rideMatchingStrategy;
        this.fareStrategy = fareStrategy;
    }

    public Ride requestRide(Rider rider,
                            double distance) {

        List<Driver> availableDrivers =
                driverService.getAvailableDrivers();

        if (availableDrivers.isEmpty()) {
            throw new NoDriverAvailableException(
                    "No drivers available currently."
            );
        }

        Driver assignedDriver =
                rideMatchingStrategy.findDriver(
                        rider,
                        availableDrivers
                );

        if (assignedDriver == null) {
            throw new NoDriverAvailableException(
                    "No suitable driver found."
            );
        }

        Ride ride = new Ride(
                IdGenerator.generateId(),
                rider,
                assignedDriver,
                distance,
                RideStatus.ASSIGNED
        );

        rides.add(ride);

        driverService.updateDriverAvailability(
                assignedDriver.getId(),
                false
        );

        double fare =
                fareStrategy.calculateFare(ride);

        FareReceipt receipt =
                new FareReceipt(
                        ride.getId(),
                        fare,
                        LocalDateTime.now()
                );

        System.out.println("Ride Booked Successfully!");
        System.out.println(ride);
        System.out.println(receipt);

        return ride;
    }

    public void completeRide(String rideId) {

        for (Ride ride : rides) {

            if (ride.getId().equals(rideId)) {

                ride.setStatus(RideStatus.COMPLETED);

                driverService.updateDriverAvailability(
                        ride.getDriver().getId(),
                        true
                );

                System.out.println("Ride Completed!");
                return;
            }
        }

        System.out.println("Ride not found.");
    }

    public void displayAllRides() {

        for (Ride ride : rides) {
            System.out.println(ride);
        }
    }
}
