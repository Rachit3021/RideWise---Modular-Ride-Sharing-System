package com.airtribe.ridewise.strategy;

import com.airtribe.ridewise.model.Ride;

public class PeakHourFareStrategy implements FareStrategy{
    private static final double SURGE_MULTIPLIER = 1.5;

    @Override
    public double calculateFare(Ride ride) {

        double normalFare =
                50 + (ride.getDistance() * 10);

        return normalFare * SURGE_MULTIPLIER;
    }
}
