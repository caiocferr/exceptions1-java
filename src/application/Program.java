package src.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import src.model.enitities.Reservation;
import src.model.exceptions.DomainException;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
try {
            System.out.println("Room number: ");
            int rn = sc.nextInt();
            System.out.println("Check-in date (dd/MM/yyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("Check-in date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            // checagem das datas de reserva

            
            Reservation reservation = new Reservation(rn, checkIn, checkOut);
            System.out.println(reservation);
            System.out.println("Enter data to uppdate the reservation: ");
            System.out.println("New check-in date: ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut); 
                System.out.println(reservation);


}
catch (ParseException e){
    System.out.println("Invalid date format");
}
catch (DomainException e){
    System.out.println("Error in reservation "+ e.getMessage());
}
        sc.close();
    }
}