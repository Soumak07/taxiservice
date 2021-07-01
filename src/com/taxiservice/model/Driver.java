package com.taxiservice.model;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    String name;
    String phonenumber;
    List<Ride> rideList;

    public Driver(String name, String phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.rideList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void addRide(Ride ride) {
        rideList.add(ride);
    }

    public List<Ride> getRides(){
        return rideList;
    }

    @Override
    public boolean equals(Object driver){
        return this.name == ((Driver) driver).getName();
    }

}
