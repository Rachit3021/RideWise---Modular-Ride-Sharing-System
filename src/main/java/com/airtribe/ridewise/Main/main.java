package com.airtribe.ridewise.Main;

import com.airtribe.ridewise.exception.NoDriverAvailableException;
import com.airtribe.ridewise.model.Driver;
import com.airtribe.ridewise.model.Ride;
import com.airtribe.ridewise.model.Rider;
import com.airtribe.ridewise.model.VehicleType;
import com.airtribe.ridewise.service.DriverService;
import com.airtribe.ridewise.service.RideService;
import com.airtribe.ridewise.service.RiderService;
import com.airtribe.ridewise.strategy.DefaultFareStrategy;
import com.airtribe.ridewise.strategy.FareStrategy;
import com.airtribe.ridewise.strategy.NearestDriverStrategy;
import com.airtribe.ridewise.strategy.RideMatchingStrategy;
import com.airtribe.ridewise.util.IdGenerator;

import java.util.Scanner;

public class main {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            RiderService riderService = new RiderService();

            DriverService driverService = new DriverService();

            RideMatchingStrategy matchingStrategy =
                    new NearestDriverStrategy();

            FareStrategy fareStrategy =
                    new DefaultFareStrategy();

            RideService rideService =
                    new RideService(
                            driverService,
                            matchingStrategy,
                            fareStrategy
                    );

            while (true) {

                System.out.println("\n===== RIDEWISE MENU =====");

                System.out.println("1. Add Rider");
                System.out.println("2. Add Driver");
                System.out.println("3. View Available Drivers");
                System.out.println("4. Request Ride");
                System.out.println("5. Complete Ride");
                System.out.println("6. View All Rides");
                System.out.println("7. Exit");

                System.out.print("Enter choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                try {

                    switch (choice) {

                        case 1:

                            System.out.print("Enter rider name: ");
                            String riderName = scanner.nextLine();

                            System.out.print("Enter rider Distance(km): ");
                            double riderLocation = scanner.nextDouble();
                            scanner.nextLine();

                            Rider rider = new Rider(
                                    IdGenerator.generateId(),
                                    riderName,
                                    riderLocation
                            );

                            riderService.registerRider(rider);

                            System.out.println("\nRider Added Successfully!");
                            System.out.println(rider);

                            break;

                        case 2:

                            System.out.print("Enter driver name: ");
                            String driverName = scanner.nextLine();

                            System.out.print("Enter driver Distance(km): ");
                            double driverLocation = scanner.nextDouble();
                            scanner.nextLine();

                            System.out.println("\nSelect Vehicle Type:");
                            System.out.println("1. BIKE");
                            System.out.println("2. AUTO");
                            System.out.println("3. CAR");

                            int vehicleChoice = scanner.nextInt();
                            scanner.nextLine();

                            VehicleType vehicleType;

                            switch (vehicleChoice) {

                                case 1:
                                    vehicleType = VehicleType.BIKE;
                                    break;

                                case 2:
                                    vehicleType = VehicleType.AUTO;
                                    break;

                                case 3:
                                    vehicleType = VehicleType.CAR;
                                    break;

                                default:
                                    System.out.println("Invalid Vehicle Type.");
                                    break;
                            }

                            Driver driver = new Driver(
                                    IdGenerator.generateId(),
                                    driverName,
                                    driverLocation,
                                    true,
                                    VehicleType.CAR
                            );

                            driverService.registerDriver(driver);

                            System.out.println("\nDriver Added Successfully!");
                            System.out.println(driver);

                            break;

                        case 3:

                            System.out.println("\nAvailable Drivers:");

                            driverService.displayAvailableDrivers();

                            break;

                        case 4:

                            System.out.print("Enter rider ID: ");
                            String riderId = scanner.nextLine();

                            Rider existingRider =
                                    riderService.getRiderById(riderId);

                            if (existingRider == null) {

                                System.out.println("Rider Not Found.");
                                break;
                            }

                            System.out.print("Enter ride distance: ");
                            double distance = scanner.nextDouble();
                            scanner.nextLine();

                            Ride ride =
                                    rideService.requestRide(
                                            existingRider,
                                            distance
                                    );

                            System.out.println("\nRide Booked Successfully!");
                            System.out.println(ride);

                            break;

                        case 5:

                            System.out.print("Enter ride ID: ");
                            String rideId = scanner.nextLine();

                            rideService.completeRide(rideId);

                            break;

                        case 6:

                            System.out.println("\nAll Rides:");

                            rideService.displayAllRides();

                            break;

                        case 7:

                            System.out.println("Exiting RideWise...");
                            return;

                        default:

                            System.out.println("Invalid Choice.");
                    }

                } catch (NoDriverAvailableException e) {

                    System.out.println(e.getMessage());

                } catch (Exception e) {

                    System.out.println("Invalid Input.");
                    scanner.nextLine();
                }
            }
        }
    }

