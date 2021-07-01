package com.taxiservice;

import com.taxiservice.exceptions.DriverNotFound;
import com.taxiservice.model.Driver;
import com.taxiservice.model.Rider;
import com.taxiservice.service.RatingsService;
import com.taxiservice.service.RideManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        // data creation start
        List<Rider> riderList = new ArrayList<>();

        riderList.add(new Rider("Ram", "23423"));
        riderList.add(new Rider("Laxman", "2342"));
        riderList.add(new Rider("Bharat", "3424"));

        List<Driver> driverList = new ArrayList<>();
        driverList.add(new Driver("Bheem", "242"));
        driverList.add(new Driver("Nakul", "12313"));
        driverList.add(new Driver("Sahadev", "890"));

        RatingsService ratingsService = new RatingsService(riderList, driverList);
        RideManager rideManager = new RideManager(ratingsService);

        rideManager.addRide(riderList.get(0), driverList.get(0), 3, 5);
        rideManager.addRide(riderList.get(1), driverList.get(1), 5, 2);
        rideManager.addRide(riderList.get(0), driverList.get(2), 4, 2);
        rideManager.addRide(riderList.get(2), driverList.get(0), 3, 5);
        rideManager.addRide(riderList.get(0), driverList.get(0), 3, 1);
        rideManager.addRide(riderList.get(1), driverList.get(2), 5, 3);
        rideManager.addRide(riderList.get(2), driverList.get(1), 5, 5);
        // data creation done

        while (true){

            String name = scan.nextLine();
            Rider rider = null;

            try{
                rider = riderList.stream().filter(rider1 -> rider1.getName().equals(name)).collect(Collectors.toList()).get(0);
            }catch (Exception e){
                System.out.println("Rider not found");
                continue;
            }

            try{
                Driver driver = rideManager.findMostEligibleDriver(rider);
                System.out.println(driver.getName());
            }catch (DriverNotFound e){
                System.out.printf("No driver found for %s%n", rider.getName());
            }
        }

    }
}
