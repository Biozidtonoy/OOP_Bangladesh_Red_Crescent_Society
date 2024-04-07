/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mehedi.Sponsor;

/**
 *
 * @author Elitebook 830
 */
public class Event {
    private  String eventName;
        private  String eventDate;
        private  String location;
        private  String type;

        public Event(String eventName, String eventDate, String location, String type) {
            this.eventName = eventName;
            this.eventDate = eventDate;
            this.location = location;
            this.type = type;
        }

        public String getEventName() {
            return eventName;
        }

        public String getEventDate() {
            return eventDate;
        }

        public String getLocation() {
            return location;
        }

        public String getType() {
            return type;
        }

    @Override
    public String toString() {
        return "Event{" + "eventName=" + eventName + ", eventDate=" + eventDate + ", location=" + location + ", type=" + type + '}';
    }

}

