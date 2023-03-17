package org.lessons.gestore.eventi;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Event {
    private String title;
    private LocalDate date;
    private int capacity;

    private int reservedSeats;


    //Constructor
    public Event(String title, LocalDate date, int capacity) throws IllegalArgumentException, DateTimeException {
        if (!title.trim().equals("")){
            this.title = title;
        }else {
            throw new IllegalArgumentException("Invalid title");
        }

        if (date.isAfter(LocalDate.now())){
            this.date = date;
        } else {
            throw new DateTimeException("Invalid date");
        }
        if (capacity <= 0){
            throw new IllegalArgumentException("Invalid capacity");
        } else {
            this.capacity = capacity;
        }
        this.reservedSeats = 0;
    }

    //G/Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }


    //Methods
    public void book() throws ExceedAvailableSeatsException, PastEventException{

        if (date.isBefore(LocalDate.now())){
            throw new PastEventException("Sorry, you cannot book any seats, the event is already occurred");
        }
        if (reservedSeats > (capacity - reservedSeats)){
            throw new ExceedAvailableSeatsException("Sorry, you cannot book any seats, we are already at full capacity");
        }

       /* if (date.isAfter(LocalDate.now()) && capacity > (capacity - reservedSeats)){*/
            reservedSeats++;
    /*    }*/


    }

    public void cancelReservation() throws NoBookingsYet, PastEventException{
        if (date.isAfter(LocalDate.now()) && reservedSeats > 0 && capacity <= reservedSeats ){
            reservedSeats--;
        }
        if (date.isBefore(LocalDate.now())){
            throw new PastEventException("Sorry, you cannot book any seats, the event is already occurred");
        }
        if (reservedSeats == 0){
            throw new NoBookingsYet("Sorry, there are no reservations to cancel");
        }

    }


    @Override
    public String toString() {
        return "Event" + title + '\n' +
                "date: " + date + "\n" +
                "capacity:" + capacity + "\n" +
                "reserved seats: " + reservedSeats + "\n" +
                "available seats: " + (getCapacity() - getReservedSeats()) + "\n";
    }
}
