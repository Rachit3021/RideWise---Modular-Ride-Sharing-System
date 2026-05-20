package com.airtribe.ridewise.service;

import com.airtribe.ridewise.model.Rider;

import java.util.HashMap;
import java.util.Map;

public class RiderService {
    private Map<String, Rider> riders;

    public RiderService() {
        riders = new HashMap<>();
    }

    public void registerRider(Rider rider) {
        riders.put(rider.getId(), rider);
    }

    public Rider getRiderById(String riderId) {
        return riders.get(riderId);
    }

    public void displayAllRiders() {

        for (Rider rider : riders.values()) {
            System.out.println(rider);
        }
    }
}
