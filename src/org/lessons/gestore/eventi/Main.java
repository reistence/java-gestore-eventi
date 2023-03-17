package org.lessons.gestore.eventi;

import java.sql.SQLOutput;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Insert a new event title: ");

        String title = scan.nextLine();
        System.out.println("Insert a the event date (yyyy-MM-DD): ");
        LocalDate date = LocalDate.parse(scan.nextLine());


        System.out.println("Insert a the event capacity: ");
        int capacity = Integer.parseInt(scan.nextLine());

       /* try {*/

        Event usrEvent = null;
        try {
            usrEvent = new Event(title, date, capacity);
        } catch (IllegalArgumentException | DateTimeException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        System.out.println("Insert: 1 to book a seat/s - 2 to cancel a reservation");
             int usrAnswer = Integer.parseInt(scan.nextLine());


            switch (usrAnswer){
                case 1:
                    System.out.println("How many seats you want to book?");
                    int usrReservations = Integer.parseInt(scan.nextLine());

                        try {
                            for (int i = 0; i < usrReservations; i++) {
                            usrEvent.book();
                            }
                        } catch (ExceedAvailableSeatsException | PastEventException e) {
                            System.out.println("Error: " + e.getMessage());
                        }


                    break;
                case 2:
                    System.out.println("How many reservations you want to cancel?");
                    int usrCancellations = Integer.parseInt(scan.nextLine());
                    for (int i = 0; i < usrCancellations; i++) {
                        try {
                            usrEvent.cancelReservation();
                        } catch (NoBookingsYet | PastEventException e) {
                            System.out.println("Error: " + e.getMessage());;
                        }
                    }
                    break;
            }

                System.out.println(usrEvent.toString());

         /*   } catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }*/










    }
}