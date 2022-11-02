package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (DD/MM/YYYY): ");
			LocalDate checkIn = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Check-out date (DD/MM/YYYY): ");
			LocalDate checkOut = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
	
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkIn = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkOut = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	
			reservation.updateDate(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}

}
