package com.park.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.park.entity.Slot;
import com.park.entity.Ticket;
import com.park.entity.Vehicle;

public class ParkingServiceImpl implements ParkingService {
	private TreeSet<Slot> availableSlots = new TreeSet<>();
	private Map<Integer,Slot> occupiedSlots = new HashMap<Integer,Slot>();
	private HashSet<Ticket> list = new HashSet<>();
	private int maxSlot = 0;
	Random ticketNo = new Random(1000);

	@Override
	public boolean init(int num) {
		this.maxSlot = num;
		for (int i = 0; i < maxSlot; i++) {
			Slot slot = new Slot(i);
			availableSlots.add(slot);
		}
		
		return true;
	}

	@Override
	public Ticket park(Vehicle v) {
		int tktNo = generateTicketNumber();
		Slot slot = getNewAndUpdateSlot();
		Ticket tkt=null;
		if(null!=slot) {
			slot.setVehicle(v);
			tkt = new Ticket(tktNo, slot);
			list.add(tkt);
		}
	
		return tkt;
	}

	private Slot getNewAndUpdateSlot() {
		Slot slot = availableSlots.pollFirst();
		if(null!=slot) {
			occupiedSlots.put(slot.getSlotNo(),slot);
		}else {
			System.out.println("Attention :: parking full");
		}
		
		return slot;
	}

	
	private Slot removeAndUpdateSlot(Slot slot) {
		availableSlots.add(slot);
		occupiedSlots.remove(slot.getSlotNo());
		return slot;
	}
	
	@Override
	public boolean unPark(Ticket ticket) {
		boolean removed= false;
		if(null!=ticket) {
			list.remove(ticket);
			removeAndUpdateSlot(ticket.getSlot());
			removed=true;
		}
		return removed;
	}

	@Override
	public Slot getByVehicleID(String num) {
		Optional<Ticket> ticket = list.stream().filter(t -> t.getSlot().getVehicle().getVehicleNo().equals(num)).findFirst();
		Slot slot = ticket.map(t->t.getSlot()).orElse(null);
		return slot;
	}

	@Override
	public Vehicle getBySlot(int num) {
		Vehicle v =null;
		if(occupiedSlots.containsKey(num)) {
			v=occupiedSlots.get(num).getVehicle();
		}
		return v;
	}

	@Override
	public List<Vehicle> getByColor(String color) {
		return list.stream().map(t->t.getSlot().getVehicle()).filter(v ->v.getColor().equalsIgnoreCase(color)).collect(Collectors.toList());
	}
	
	private int generateTicketNumber() {
		return ticketNo.nextInt()&Integer.MAX_VALUE; 
	}
}
