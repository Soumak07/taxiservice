package com.taxiservice.model;

import java.util.ArrayList;
import java.util.List;

public class Rider {

    String name;
    String phoneNumber;
    List<Ride> rideList;

    public Rider(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.rideList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addRide(Ride ride){
        rideList.add(ride);
    }

    public List<Ride> getRides(){
        return rideList;
    }

    @Override
    public boolean equals(Object rider){
        return this.name == ((Rider) rider).getName();
    }
}
