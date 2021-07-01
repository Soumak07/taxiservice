package com.taxiservice.service;

import com.taxiservice.exceptions.DriverNotFound;
import com.taxiservice.model.Driver;
import com.taxiservice.model.Ride;
import com.taxiservice.model.Rider;

import java.util.List;
import java.util.stream.Collectors;

public class RideManager {

    RatingsService ratingsService;

    public RideManager(RatingsService ratingsService){
        this.ratingsService = ratingsService;
    }

    public void addRide(Rider rider, Driver driver, int riderRating, int driverRating){
        Ride ride = new Ride(rider,driver,driverRating, riderRating);
        rider.addRide(ride);
        driver.addRide(ride);
    }

    public Driver findMostEligibleDriver(Rider rider){
        double avgRiderRating = ratingsService.getAvgRiderRating(rider);

        List<Driver> initialEligibleDrivers = ratingsService.getDriversWithCertainMinimumRating(avgRiderRating);

        List<Driver> secondaryDriverList = initialEligibleDrivers.stream().
                                            filter(driver -> ((!ratingsService.hasDriverRatedRider1(rider, driver)) && (!ratingsService.hasRiderRatedDriver1(driver,rider)))).
                                            collect(Collectors.toList());

        if(!secondaryDriverList.isEmpty()){
            return findDriverWithMaxRating(secondaryDriverList);
        }

        List<Driver> finalDriverList = ratingsService.getDriverList().stream().
                                        filter(driver -> ((!ratingsService.hasDriverRatedRider1(rider, driver)) && (!ratingsService.hasRiderRatedDriver1(driver,rider)))).
                                        collect(Collectors.toList());

        if(!finalDriverList.isEmpty()){
            return findDriverWithMaxRating(finalDriverList);
        }else{
            throw new DriverNotFound("No matching driver found");
        }
    }

    private Driver findDriverWithMaxRating(List<Driver> driverList){
        Driver foundDriver = null;
        double maxRating = Double.MIN_VALUE;
        for(Driver driver: driverList){

            double avgDriverRating = ratingsService.getAvgDriverRating(driver);

            if(avgDriverRating>maxRating){
                foundDriver = driver;
                maxRating = avgDriverRating;
            }
        }
        return foundDriver;
    }
}
