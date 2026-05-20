package com.airtribe.ridewise.strategy;

import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Rider;

import java.util.List;

public class LeastActiveDriverStrategy implements RideMatchingStrategy{
    @Override
    public Driver findDriver(Rider rider, List<Driver> drivers) {

        if (drivers.isEmpty()) {
            return null;
        }

        return drivers.get(0);
    }
}
