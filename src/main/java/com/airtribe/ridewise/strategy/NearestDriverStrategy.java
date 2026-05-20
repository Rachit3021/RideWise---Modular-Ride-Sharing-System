package com.airtribe.ridewise.strategy;

import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Rider;

import java.util.List;

public class NearestDriverStrategy implements RideMatchingStrategy {
    @Override
    public Driver findDriver(Rider rider, List<Driver> drivers) {

        Driver nearestDriver = null;
        double minimumDistance = Double.MAX_VALUE;

        for (Driver driver : drivers) {

            double distance = Math.abs(
                    rider.getLocation() - driver.getCurrentLocation()
            );

            if (distance < minimumDistance) {
                minimumDistance = distance;
                nearestDriver = driver;
            }
        }

        return nearestDriver;
    }

}
