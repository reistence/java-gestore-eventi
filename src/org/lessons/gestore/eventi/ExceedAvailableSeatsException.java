package org.lessons.gestore.eventi;

public class ExceedAvailableSeatsException extends Exception{
    public ExceedAvailableSeatsException(String message) {
        super(message);
    }
}
