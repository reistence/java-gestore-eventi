package org.lessons.gestore.eventi;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Concert a = new Concert("Eminem Concert", LocalDate.parse("2023-11-11"), 100, "20:30",  "10");

        Scanner scan = new Scanner(System.in);

        System.out.println("What is the name of the event program?: ");
        String programName = scan.nextLine();

        System.out.println("How many events you want to add?: ");

        int nrEvents = Integer.parseInt(scan.nextLine());

        List<Event> events = new ArrayList<>();

        for (int j = 0; j < nrEvents; j++) {
            System.out.println("Insert a new event title: ");

            String title = scan.nextLine();
            System.out.println("Insert a the event date (yyyy-MM-DD): ");
            LocalDate date = LocalDate.parse(scan.nextLine());


            System.out.println("Insert a the event capacity: ");
            int capacity = Integer.parseInt(scan.nextLine());


            Event usrEvent = null;
            try {
                usrEvent = new Event(title, date, capacity);


            } catch (IllegalArgumentException | DateTimeException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }

            int usrAnswer = 0;
            do {
                System.out.println("Insert: 1 to book a seat/s - 2 to cancel a reservation - 3 Exit");
                 usrAnswer = Integer.parseInt(scan.nextLine());


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
                        System.out.println(usrEvent.toString());
                             break;
                    case 2:
                        System.out.println("How many reservations you want to cancel?");
                        int usrCancellations = Integer.parseInt(scan.nextLine());

                            try {
                                for (int i = 0; i < usrCancellations; i++) {
                                usrEvent.cancelReservation();
                                }
                            } catch (NoBookingsYet | PastEventException e) {
                                System.out.println("Error: " + e.getMessage());;
                            }

                        System.out.println(usrEvent.toString());
                        break;
                }
            } while (usrAnswer != 3);

            events.add(usrEvent);


            System.out.println(usrEvent.toString());
        }

        EventsProgram program = new EventsProgram( programName, events);
        System.out.println(program.toString());


        System.out.println(program.countEvents());
        program.addEvent(new Event("Opera", LocalDate.parse("2023-10-10"), 1000));
        List<Event> todayEvents =  program.getEventsByDate(LocalDate.parse("2023-10-10"));
        System.out.println(todayEvents.toString());
        System.out.println(program.sortEventsByDate());


        program.clearProgram();


        scan.close();
    }
}