package com.park.entity;

public class Vehicle {

	private String color;
	private String vehicleNo;

	public Vehicle(String color, String vehicleNo) {
		this.color = color;
		this.vehicleNo = vehicleNo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	@Override
	public String toString() {
		return "Vehicle [color=" + color + ", vehicleNo=" + vehicleNo + "]";
	}

	
}
