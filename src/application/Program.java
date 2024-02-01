package src.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import src.model.enitities.Reservation;

public class Program {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room number: ");
        int rn = sc.nextInt();
        System.out.println("Check-in date (dd/MM/yyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Check-in date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        // checagem das datas de reserva

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after Check-in date");
        } else {
            Reservation reservation = new Reservation(rn, checkIn, checkOut);
            System.out.println(reservation);
            System.out.println("Enter data to uppdate the reservation: ");
            System.out.println("New check-in date: ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-in date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();

            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("ERRO! The updated date must be a future date");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after Check-in date");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println(reservation);
            }

        }
    }
}