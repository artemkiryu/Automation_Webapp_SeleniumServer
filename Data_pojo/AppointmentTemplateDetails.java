package pojo;

/**
 * Created by infoobjects on 1/14/2016.
 */
public class AppointmentTemplateDetails {
    private String appointmentTemplateName;
    private String appointmentTemplateDescription;
    private String minimumPreferences;
    private String maximumPreferences;
    private String maximumAppointmentPreferences;
    private String minimumAppointment;
    private String maximumPrescheduledAppointmentPerDay;
    private String maximumPrescheduledAppointmentPerEvent;
    private String maximumExclusion;

    public AppointmentTemplateDetails(String appointmentTemplateName, String appointmentTemplateDescription, String minimumPreferences, String maximumPreferences, String maximumAppointmentPreferences, String minimumAppointment, String maximumPrescheduledAppointmentPerDay, String maximumPrescheduledAppointmentPerEvent, String maximumExclusion) {
        this.appointmentTemplateName = appointmentTemplateName;
        this.appointmentTemplateDescription = appointmentTemplateDescription;
        this.minimumPreferences = minimumPreferences;
        this.maximumPreferences = maximumPreferences;
        this.maximumAppointmentPreferences = maximumAppointmentPreferences;
        this.minimumAppointment = minimumAppointment;
        this.maximumPrescheduledAppointmentPerDay = maximumPrescheduledAppointmentPerDay;
        this.maximumPrescheduledAppointmentPerEvent = maximumPrescheduledAppointmentPerEvent;
        this.maximumExclusion = maximumExclusion;
    }

    public String getAppointmentTemplateName() {
        return appointmentTemplateName;
    }

    public String getAppointmentTemplateDescription() {
        return appointmentTemplateDescription;
    }

    public String getMinimumPreferences() {
        return minimumPreferences;
    }

    public String getMaximumPreferences() {
        return maximumPreferences;
    }

    public String getMaximumAppointmentPreferences() {
        return maximumAppointmentPreferences;
    }

    public String getMinimumAppointment() {
        return minimumAppointment;
    }

    public String getMaximumPrescheduledAppointmentPerDay() {
        return maximumPrescheduledAppointmentPerDay;
    }

    public String getMaximumPrescheduledAppointmentPerEvent() {
        return maximumPrescheduledAppointmentPerEvent;
    }

    public String getMaximumExclusion() {
        return maximumExclusion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppointmentTemplateDetails)) return false;

        AppointmentTemplateDetails that = (AppointmentTemplateDetails) o;

        if (appointmentTemplateName != null ? !appointmentTemplateName.equals(that.appointmentTemplateName) : that.appointmentTemplateName != null)
            return false;
        if (appointmentTemplateDescription != null ? !appointmentTemplateDescription.equals(that.appointmentTemplateDescription) : that.appointmentTemplateDescription != null)
            return false;
        if (minimumPreferences != null ? !minimumPreferences.equals(that.minimumPreferences) : that.minimumPreferences != null)
            return false;
        if (maximumPreferences != null ? !maximumPreferences.equals(that.maximumPreferences) : that.maximumPreferences != null)
            return false;
        if (maximumAppointmentPreferences != null ? !maximumAppointmentPreferences.equals(that.maximumAppointmentPreferences) : that.maximumAppointmentPreferences != null)
            return false;
        if (minimumAppointment != null ? !minimumAppointment.equals(that.minimumAppointment) : that.minimumAppointment != null)
            return false;
        if (maximumPrescheduledAppointmentPerDay != null ? !maximumPrescheduledAppointmentPerDay.equals(that.maximumPrescheduledAppointmentPerDay) : that.maximumPrescheduledAppointmentPerDay != null)
            return false;
        if (maximumPrescheduledAppointmentPerEvent != null ? !maximumPrescheduledAppointmentPerEvent.equals(that.maximumPrescheduledAppointmentPerEvent) : that.maximumPrescheduledAppointmentPerEvent != null)
            return false;
        return !(maximumExclusion != null ? !maximumExclusion.equals(that.maximumExclusion) : that.maximumExclusion != null);

    }

    @Override
    public int hashCode() {
        int result = appointmentTemplateName != null ? appointmentTemplateName.hashCode() : 0;
        result = 31 * result + (appointmentTemplateDescription != null ? appointmentTemplateDescription.hashCode() : 0);
        result = 31 * result + (minimumPreferences != null ? minimumPreferences.hashCode() : 0);
        result = 31 * result + (maximumPreferences != null ? maximumPreferences.hashCode() : 0);
        result = 31 * result + (maximumAppointmentPreferences != null ? maximumAppointmentPreferences.hashCode() : 0);
        result = 31 * result + (minimumAppointment != null ? minimumAppointment.hashCode() : 0);
        result = 31 * result + (maximumPrescheduledAppointmentPerDay != null ? maximumPrescheduledAppointmentPerDay.hashCode() : 0);
        result = 31 * result + (maximumPrescheduledAppointmentPerEvent != null ? maximumPrescheduledAppointmentPerEvent.hashCode() : 0);
        result = 31 * result + (maximumExclusion != null ? maximumExclusion.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AppointmentTemplateDetails{" +
                "appointmentTemplateName='" + appointmentTemplateName + '\'' +
                ", appointmentTemplateDescription='" + appointmentTemplateDescription + '\'' +
                ", minimumPreferences='" + minimumPreferences + '\'' +
                ", maximumPreferences='" + maximumPreferences + '\'' +
                ", maximumAppointmentPreferences='" + maximumAppointmentPreferences + '\'' +
                ", minimumAppointment='" + minimumAppointment + '\'' +
                ", maximumPrescheduledAppointmentPerDay='" + maximumPrescheduledAppointmentPerDay + '\'' +
                ", maximumPrescheduledAppointmentPerEvent='" + maximumPrescheduledAppointmentPerEvent + '\'' +
                ", maximumExclusion='" + maximumExclusion + '\'' +
                '}';
    }
}
