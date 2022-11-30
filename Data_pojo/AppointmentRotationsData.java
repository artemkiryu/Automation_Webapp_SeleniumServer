package pojo;

/**
 * Created by infoobjects on 11/3/2015.
 */
public class AppointmentRotationsData {
    private String rotationName;
    private String rotationDescription;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private String rotationNotes;
    private String appointmentTemplate;
    private String agendaItem;


    public AppointmentRotationsData(String rotationName, String rotationDescription, String startDate, String startTime, String endDate, String endTime, String rotationNotes, String appointmentTemplate, String agendaItem) {
        this.rotationName = rotationName;
        this.rotationDescription = rotationDescription;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.rotationNotes = rotationNotes;
        this.appointmentTemplate = appointmentTemplate;
        this.agendaItem = agendaItem;
    }

    public String getRotationName() {
        return rotationName;
    }

    public String getRotationDescription() {
        return rotationDescription;
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

    public String getRotationNotes() {
        return rotationNotes;
    }

    public String getAppointmentTemplate() {
        return appointmentTemplate;
    }

    public String getAgendaItem() {
        return agendaItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppointmentRotationsData)) return false;

        AppointmentRotationsData that = (AppointmentRotationsData) o;

        if (rotationName != null ? !rotationName.equals(that.rotationName) : that.rotationName != null) return false;
        if (rotationDescription != null ? !rotationDescription.equals(that.rotationDescription) : that.rotationDescription != null)
            return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (rotationNotes != null ? !rotationNotes.equals(that.rotationNotes) : that.rotationNotes != null)
            return false;
        if (appointmentTemplate != null ? !appointmentTemplate.equals(that.appointmentTemplate) : that.appointmentTemplate != null)
            return false;
        return !(agendaItem != null ? !agendaItem.equals(that.agendaItem) : that.agendaItem != null);

    }

    @Override
    public int hashCode() {
        int result = rotationName != null ? rotationName.hashCode() : 0;
        result = 31 * result + (rotationDescription != null ? rotationDescription.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (rotationNotes != null ? rotationNotes.hashCode() : 0);
        result = 31 * result + (appointmentTemplate != null ? appointmentTemplate.hashCode() : 0);
        result = 31 * result + (agendaItem != null ? agendaItem.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AppointmentRotationsData{" +
                "rotationName='" + rotationName + '\'' +
                ", rotationDescription='" + rotationDescription + '\'' +
                ", startDate='" + startDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endDate='" + endDate + '\'' +
                ", endTime='" + endTime + '\'' +
                ", rotationNotes='" + rotationNotes + '\'' +
                ", appointmentTemplate='" + appointmentTemplate + '\'' +
                ", agendaItem='" + agendaItem + '\'' +
                '}';
    }
}
