package com.park.entity;

public class Ticket {
	private int ticketNo;
	private Slot slot;

	public Ticket(int ticketNo, Slot slot) {
		this.ticketNo = ticketNo;
		this.slot = slot;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((slot == null) ? 0 : slot.hashCode());
		result = prime * result + ticketNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (slot == null) {
			if (other.slot != null)
				return false;
		} else if (!slot.equals(other.slot))
			return false;
		if (ticketNo != other.ticketNo)
			return false;
		return true;
	}

}
