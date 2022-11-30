package pojo;

/**
 * Created by bludshot on 14/7/15.
 */
public class AppointmentForm {
    String attendeeTypes;
    String organization;
    String targetRegistrant;
    String startDate;
    String startTime;
    String location;

    public AppointmentForm(String attendeeTypes, String organization, String targetRegistrant, String startDate, String startTime, String location) {
        this.attendeeTypes = attendeeTypes;
        this.organization = organization;
        this.targetRegistrant = targetRegistrant;
        this.startDate = startDate;
        this.startTime = startTime;
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppointmentForm that = (AppointmentForm) o;

        if (attendeeTypes != null ? !attendeeTypes.equals(that.attendeeTypes) : that.attendeeTypes != null)
            return false;
        if (organization != null ? !organization.equals(that.organization) : that.organization != null) return false;
        if (targetRegistrant != null ? !targetRegistrant.equals(that.targetRegistrant) : that.targetRegistrant != null)
            return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        return !(location != null ? !location.equals(that.location) : that.location != null);

    }

    @Override
    public int hashCode() {
        int result = attendeeTypes != null ? attendeeTypes.hashCode() : 0;
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        result = 31 * result + (targetRegistrant != null ? targetRegistrant.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    public String getAttendeeTypes() {
        return attendeeTypes;
    }

    public void setAttendeeTypes(String attendeeTypes) {
        this.attendeeTypes = attendeeTypes;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getTargetRegistrant() {
        return targetRegistrant;
    }

    public void setTargetRegistrant(String targetRegistrant) {
        this.targetRegistrant = targetRegistrant;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
