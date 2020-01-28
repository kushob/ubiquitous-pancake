package com.park;

import com.park.entity.Ticket;
import com.park.entity.Vehicle;
import com.park.service.ParkingService;
import com.park.service.ParkingServiceImpl;

public class App {
	
	public static void main(String[] args) {
		ParkingService parkingService = new ParkingServiceImpl();
		parkingService.init(100);
		
		Vehicle maruti_alto = new Vehicle("white", "MH01-23-4566");
		Vehicle maruti_ciaz = new Vehicle("black", "MH02-23-4566");
		Vehicle maruti_ciaz2 = new Vehicle("white", "MH01-23-4664");
		
		Ticket t1 = parkingService.park(maruti_alto);
		Ticket t2 = parkingService.park(maruti_ciaz);
		Ticket t3 = parkingService.park(maruti_ciaz2);

		System.out.println(t1.getTicketNo());
		System.out.println(t2.getTicketNo());
		System.out.println(t3.getTicketNo());
		
		System.out.println(parkingService.getByColor("White"));
		System.out.println(parkingService.getBySlot(1));
		System.out.println(parkingService.getByVehicleID("MH01-23-4664"));
		parkingService.unPark(t3);
		System.out.println(parkingService.getByVehicleID("MH01-23-4664"));
		
		
	}
}
