package pojo;

import java.util.Objects;

/**
 * Created by infoobjects on 6/28/2017.
 */
public class Event {
    private String title;
    private String eventCode;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private String timeZone;
    private String account;
    private String status;
    private String notes;
    private String externalEventID;
    private String registrationInventory;
    private String currency;
    private String eventTags;

    public Event(String title, String eventCode, String startDate, String startTime, String endDate, String endTime, String timeZone, String account, String status, String eventTags, String notes, String externalEventID, String registrationInventory, String currency) {
        this.title = title;
        this.eventCode = eventCode;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.timeZone = timeZone;
        this.account = account;
        this.status = status;
        this.eventTags = eventTags;
        this.notes = notes;
        this.externalEventID = externalEventID;
        this.registrationInventory = registrationInventory;
        this.currency = currency;
    }

    public String getEventTags() {
        return eventTags;
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", eventCode='" + eventCode + '\'' +
                ", startDate='" + startDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endDate='" + endDate + '\'' +
                ", endTime='" + endTime + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", account='" + account + '\'' +
                ", status='" + status + '\'' +
                ", notes='" + notes + '\'' +
                ", externalEventID='" + externalEventID + '\'' +
                ", registrationInventory='" + registrationInventory + '\'' +
                ", currency='" + currency + '\'' +
                ", eventTags='" + eventTags + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(title, event.title) &&
                Objects.equals(eventCode, event.eventCode) &&
                Objects.equals(startDate, event.startDate) &&
                Objects.equals(startTime, event.startTime) &&
                Objects.equals(endDate, event.endDate) &&
                Objects.equals(endTime, event.endTime) &&
                Objects.equals(timeZone, event.timeZone) &&
                Objects.equals(account, event.account) &&
                Objects.equals(status, event.status) &&
                Objects.equals(notes, event.notes) &&
                Objects.equals(externalEventID, event.externalEventID) &&
                Objects.equals(registrationInventory, event.registrationInventory) &&
                Objects.equals(currency, event.currency) &&
                Objects.equals(eventTags, event.eventTags);
    }



    public Event(String title, String eventCode, String startDate, String startTime, String endDate, String endTime, String timeZone, String account, String status, String notes, String externalEventID, String registrationInventory, String currency) {
        this.title = title;
        this.eventCode = eventCode;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.timeZone = timeZone;
        this.account = account;
        this.status = status;
        this.notes = notes;
        this.externalEventID = externalEventID;
        this.registrationInventory = registrationInventory;
        this.currency = currency;
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, eventCode, startDate, startTime, endDate, endTime, timeZone, account, status, notes, externalEventID, registrationInventory, currency, eventTags);
    }

    public String getTitle() {
        return title;
    }

    public String getEventCode() {
        return eventCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public String getAccount() {
        return account;
    }

    public String getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

    public String getExternalEventID() {
        return externalEventID;
    }

    public String getRegistrationInventory() {
        return registrationInventory;
    }

    public String getCurrency() {
        return currency;
    }

}
