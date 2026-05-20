package com.airtribe.ridewise.model;

public class Ride {
    private String id;
    private Rider rider;
    private Driver driver;
    private double distance;
    private RideStatus status;

    public Ride(String id,
                Rider rider,
                Driver driver,
                double distance,
                RideStatus status) {

        this.id = id;
        this.rider = rider;
        this.driver = driver;
        this.distance = distance;
        this.status = status;
    }

    public String getId() {
        return id;
    }
    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public double getDistance() {
        return distance;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id='" + id + '\'' +
                ", rider=" + rider.getName() +
                ", driver=" + (driver != null ? driver.getName() : "Not Assigned") +
                ", distance=" + distance +
                ", status=" + status +
                '}';
    }

}
