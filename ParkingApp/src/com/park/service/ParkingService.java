package com.park.service;

import java.util.List;

import com.park.entity.Slot;
import com.park.entity.Ticket;
import com.park.entity.Vehicle;

public interface ParkingService {

    boolean init(int num);
    Ticket park(Vehicle v);
    boolean unPark(Ticket ticket);
    Slot getByVehicleID(String num);
    Vehicle getBySlot(int num);
    List<Vehicle> getByColor(String color);

}
