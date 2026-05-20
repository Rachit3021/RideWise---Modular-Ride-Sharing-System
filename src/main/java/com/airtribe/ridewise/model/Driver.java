package com.airtribe.ridewise.model;

public class Driver {

        private String id;
        private String name;
        private double currentLocation;
        private boolean available;
        private VehicleType vehicleType;

        public Driver(String id,
                      String name,
                      double currentLocation,
                      boolean available,
                      VehicleType vehicleType) {

            this.id = id;
            this.name = name;
            this.currentLocation = currentLocation;
            this.available = available;
            this.vehicleType = vehicleType;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCurrentLocation() {
            return currentLocation;
        }

        public boolean isAvailable() {
            return available;
        }

        public VehicleType getVehicleType() {
            return vehicleType;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        @Override
        public String toString() {
            return "Driver{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", currentLocation=" + currentLocation +
                    ", available=" + available +
                    ", vehicleType=" + vehicleType +
                    '}';
        }
    }
