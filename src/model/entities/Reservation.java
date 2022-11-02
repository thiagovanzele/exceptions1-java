package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException {
		if (!checkOut.isAfter(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date.");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long duration = ChronoUnit.DAYS.between(checkIn, checkOut);
		return duration;
	}
	
	public void updateDate(LocalDate checkIn, LocalDate checkOut) throws DomainException {
		LocalDate now = LocalDate.now();
		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			throw new DomainException("Reservation dates for update must be future dates.");
		}
		if (!checkOut.isAfter(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date.");
		}
		this.checkIn = checkIn; 
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room " 
				+ roomNumber
				+ ", check-in: "
				+ checkIn.format(dtf)
				+ ", check-out: "
				+ checkOut.format(dtf)
				+ ", "
				+ duration()
				+ " nights";
		

	}
	
	
	
	
}
