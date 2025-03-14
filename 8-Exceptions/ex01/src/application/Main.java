package application;

import models.entities.Reservation;
import models.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Reservation> reservationsList = new ArrayList<>();
        Reservation reservation01 = new Reservation();
        try {
            System.out.println("*** BOOKING ***");
            System.out.print("Room Number: ");
            Integer roomNumber = input.nextInt();
            input.nextLine();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            String checkinDateString = input.nextLine();
            System.out.print("Check-out date (dd/MM/yyyy): ");
            String checkoutDateString = input.nextLine();

            LocalDate checkinDate = LocalDate.parse(checkinDateString, dateTimeFormatter);
            LocalDate checkoutDate = LocalDate.parse(checkoutDateString, dateTimeFormatter);

            reservation01 = new Reservation(roomNumber, checkinDate, checkoutDate);
            reservationsList.add(reservation01);

            for (Reservation r : reservationsList) {
                System.out.println(r);
            }
        } catch (IllegalArgumentException | DomainException e) {
            System.out.println(e.getMessage());
        }

        // update the reservation
        try {
            System.out.println("\nUPDATE DATES");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            String checkinDateString = input.nextLine();
            System.out.print("Check-out date (dd/MM/yyyy): ");
            String checkoutDateString = input.nextLine();
            LocalDate checkinDate= LocalDate.parse(checkinDateString, dateTimeFormatter);
            LocalDate checkoutDate = LocalDate.parse(checkoutDateString, dateTimeFormatter);
            reservation01.updateDates(checkinDate, checkoutDate);
            for (Reservation r : reservationsList) {
                System.out.println(r);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (DomainException e) {
            throw new RuntimeException(e);
        }

        input.close();
    }
}


