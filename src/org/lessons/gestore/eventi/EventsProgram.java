package org.lessons.gestore.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EventsProgram {
    private String title;
    private List<Event> events;


    //Constructor
    public EventsProgram(String title, List<Event> events) {
        this.title = title;
        this.events = events;
    }

    //G/Setters


    //Methods
    public void addEvent(Event e){
        events.add(e);
    }



    public int countEvents(){
        return events.size();
    }

    public void clearProgram(){
         events.clear();
    }

    public List<Event> getEventsByDate(LocalDate d){
        List<Event> e = new ArrayList<>();
        for (int i = 0; i < events.size(); i++) {
            Event current = events.get(i);
            if (current.getDate().equals(d)){
                e.add(current);
            }
        }
        return e;
    }

    public String sortEventsByDate(){
        StringBuilder s = new StringBuilder("Program:" + title + "\n" + "Scheduled events: " + "\n");
        Collections.sort(events, new Comparator<Event>() {
            @Override
            public int compare(Event event1, Event event2) {
                return event1.getDate().compareTo(event2.getDate());
            }
        });
        for (Event e : events){
            s.append("\n").append(e.getDate()).append(" ").append(e.getTitle()).append("\n");
        }
        return s.toString();

    }

    @Override
    public String toString() {
        return "EventsProgram:" + "\n"+
                "title:" + title + '\n' +
                "events:" + "\n"  + events ;
    }
}
