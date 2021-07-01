package com.taxiservice.service;

import com.taxiservice.model.Driver;
import com.taxiservice.model.Ride;
import com.taxiservice.model.Rider;

import java.util.List;
import java.util.stream.Collectors;

public class RatingsService {

    List<Rider> riderList;
    List<Driver> driverList;

    public RatingsService(List<Rider> riderList, List<Driver> driverList) {
        this.riderList = riderList;
        this.driverList = driverList;
    }

    public double getAvgRiderRating(Rider rider){
        int sum = 0;
        List<Ride> rides = rider.getRides();
        for(Ride ride: rides){
            sum += ride.getRiderRating();
        }

        return (double) sum/rides.size();
    }

    public List<Driver> getDriversWithCertainMinimumRating(double rating){
        return driverList.stream().filter(driver -> getAvgDriverRating(driver)>rating).collect(Collectors.toList());
    }

    public boolean hasDriverRatedRider1(Rider rider, Driver driver){
        for(Ride ride: driver.getRides()){
            if(ride.getRider().equals(rider)){
                if(ride.getRiderRating()<=1) return true;
            }
        }
        return false;
    }

    public boolean hasRiderRatedDriver1(Driver driver, Rider rider){
        for(Ride ride: rider.getRides()){
            if(ride.getDriver().equals(driver)){
                if(ride.getDriverRating()<=1) return true;
            }
        }
        return false;
    }

    public List<Driver> getDriverList() {
        return driverList;
    }

    public double getAvgDriverRating(Driver driver){
        int sum = 0;
        List<Ride> rides = driver.getRides();
        for(Ride ride: rides){
            sum += ride.getDriverRating();
        }

        return (double) sum/rides.size();
    }

}
