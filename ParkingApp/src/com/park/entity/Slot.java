package com.park.entity;

import java.util.Objects;

public class Slot implements Comparable<Slot> {

	 public Slot(int slotNo){
	        this.slotNo=slotNo;
	    }
	
    public Slot(int slotNo, Vehicle vehicle){
        this.slotNo=slotNo;
        this.vehicle=vehicle;
        
    }

    private int slotNo;
    private Vehicle vehicle;

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return slotNo == slot.slotNo &&
                Objects.equals(vehicle, slot.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slotNo, vehicle);
    }

    @Override
    public int compareTo(Slot o) {
        return this.slotNo-o.slotNo;
    }

	@Override
	public String toString() {
		return "Slot [slotNo=" + slotNo + ", vehicle=" + vehicle + "]";
	}
    
    
}
