package org.lessons.gestore.eventi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event{

    private LocalTime schedule;
    private BigDecimal price;

    //Constructor
    public Concert(String title, LocalDate date, int capacity, String schedule, String price) throws IllegalArgumentException, DateTimeException {
        super(title, date, capacity);
        this.price = new BigDecimal(price);
        this.schedule = LocalTime.parse(schedule);
    }
    //G/Setters
    public LocalTime getSchedule() {
        return schedule;
    }

    public BigDecimal getPrice() {
        return price.setScale(2, RoundingMode.HALF_UP);
    }
    //Methods

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "schedule:" + getSchedule() + "\n" +
                "price: €" + getPrice() + "\n";

    }
}
