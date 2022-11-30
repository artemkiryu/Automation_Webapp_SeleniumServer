package pojo;

import java.util.Objects;

public class EventAttributes {
    public String eventAudience;
    private String eventDelivery;
    private String eventType;
    private String sessionSetup;
    private String registrantGoal;
    private String attendanceGoal;

    public EventAttributes(String eventAudience, String eventDelivery, String eventType, String sessionSetup, String registrantGoal, String attendanceGoal) {
        this.eventAudience = eventAudience;
        this.eventDelivery = eventDelivery;
        this.eventType = eventType;
        this.sessionSetup = sessionSetup;
        this.registrantGoal = registrantGoal;
        this.attendanceGoal = attendanceGoal;
    }

    public String getEventAudience() {
        return eventAudience;
    }

    public String getEventDelivery() {
        return eventDelivery;
    }

    public String getEventType() {
        return eventType;
    }

    public String getSessionSetup() {
        return sessionSetup;
    }

    public String getRegistrantGoal() {
        return registrantGoal;
    }

    public String getAttendanceGoal() {
        return attendanceGoal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventAttributes that = (EventAttributes) o;
        return Objects.equals(eventAudience, that.eventAudience) && Objects.equals(eventDelivery, that.eventDelivery) && Objects.equals(eventType, that.eventType) && Objects.equals(sessionSetup, that.sessionSetup) && Objects.equals(registrantGoal, that.registrantGoal) && Objects.equals(attendanceGoal, that.attendanceGoal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventAudience, eventDelivery, eventType, sessionSetup, registrantGoal, attendanceGoal);
    }

    @Override
    public String toString() {
        return "EventAttributes{" +
                "eventAudience='" + eventAudience + '\'' +
                ", eventDelivery='" + eventDelivery + '\'' +
                ", eventType='" + eventType + '\'' +
                ", sessionSetup='" + sessionSetup + '\'' +
                ", registrantGoal='" + registrantGoal + '\'' +
                ", attendanceGoal='" + attendanceGoal + '\'' +
                '}';
    }
}
