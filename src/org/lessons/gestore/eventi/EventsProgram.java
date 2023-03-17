package org.lessons.gestore.eventi;

import java.util.Collections;
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

  /* public List<Event> getEventsByDate(){

       return events.sort((a, b) -> a.getDate().compareTo(b.getDate()));

    }*/

    public int countEvents(){
        return events.size();
    }

  /*  public List<Event> sortEventByDate(){



    }*/

    @Override
    public String toString() {
        return "EventsProgram:" + "\n"+
                "title:" + title + '\n' +
                "events:" + events ;
    }
}
