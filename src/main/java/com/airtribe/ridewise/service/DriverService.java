package com.airtribe.ridewise.service;

import com.airtribe.ridewise.model.Driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverService {

    private Map<String, Driver> drivers;

    public DriverService() {
        drivers = new HashMap<>();
    }

    public void registerDriver(Driver driver) {
        drivers.put(driver.getId(), driver);
    }

    public Driver getDriverById(String driverId) {
        return drivers.get(driverId);
    }

    public List<Driver> getAvailableDrivers() {

        List<Driver> availableDrivers = new ArrayList<>();

        for (Driver driver : drivers.values()) {

            if (driver.isAvailable()) {
                availableDrivers.add(driver);
            }
        }

        return availableDrivers;
    }

    public void updateDriverAvailability(String driverId,
                                         boolean available) {

        Driver driver = drivers.get(driverId);

        if (driver != null) {
            driver.setAvailable(available);
        }
    }

    public void displayAvailableDrivers() {

        List<Driver> availableDrivers = getAvailableDrivers();

        for (Driver driver : availableDrivers) {
            System.out.println(driver);
        }
    }
}
