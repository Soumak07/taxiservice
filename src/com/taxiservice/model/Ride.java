package com.taxiservice.model;

public class Ride {

    Rider rider;
    Driver driver;
    int driverRating;
    int riderRating;

    public Ride(Rider rider, Driver driver, int driverRating, int riderRating) {
        this.rider = rider;
        this.driver = driver;
        this.driverRating = driverRating;
        this.riderRating = riderRating;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public int getDriverRating() {
        return driverRating;
    }

    public int getRiderRating() {
        return riderRating;
    }
}
