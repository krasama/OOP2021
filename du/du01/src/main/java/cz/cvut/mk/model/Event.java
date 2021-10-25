package cz.cvut.mk.model;

import java.time.LocalDateTime;

public class Event {
    private EventType type;
    private LocalDateTime eventDateTime = LocalDateTime.now();

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }

    @Override
    public String toString() {
        return "Event{" +
                "type=" + type +
                ", čas=" + eventDateTime +
                '}';
    }
    public static void start(){
        Event event = new Event();
        event.setType(EventType.START);
        System.out.println(event);
    }

    public static void stop(){
        Event event = new Event();
        event.setType(EventType.END);
        System.out.println(event);
    }
    public static void goal(){
        Event event = new Event();
        event.setType(EventType.GOAL);
        System.out.println(event);
    }

    public static void penalty(){
        Event event = new Event();
        event.setType(EventType.PENALTY);
        System.out.println(event);
    }

    public static void faul(){
        Event event = new Event();
        event.setType(EventType.FAUL);
        System.out.println(event);
    }
}
