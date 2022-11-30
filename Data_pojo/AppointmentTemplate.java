package pojo;

/**
 * Created by infoobjects on 1/12/2016.
 */
public class AppointmentTemplate {
    private String templateName;
    private String templateDescription;
    private String atLeastPreferences;
    private String morePreferences;
    private String maxApptPreferences;
    private String maxApptParticipantsPerDay;
    private String maxApptParticipantsForEvent;
    private String notExcludeReg;
    private String minApptParticipants;

    public AppointmentTemplate(String templateName, String templateDescription, String atLeastPreferences, String morePreferences, String maxApptPreferences, String maxApptParticipantsPerDay, String maxApptParticipantsForEvent, String notExcludeReg, String minApptParticipants) {
        this.templateName = templateName;
        this.templateDescription = templateDescription;
        this.atLeastPreferences = atLeastPreferences;
        this.morePreferences = morePreferences;
        this.maxApptPreferences = maxApptPreferences;
        this.maxApptParticipantsPerDay = maxApptParticipantsPerDay;
        this.maxApptParticipantsForEvent = maxApptParticipantsForEvent;
        this.notExcludeReg = notExcludeReg;
        this.minApptParticipants = minApptParticipants;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getTemplateDescription() {
        return templateDescription;
    }

    public String getAtLeastPreferences() {
        return atLeastPreferences;
    }

    public String getMorePreferences() {
        return morePreferences;
    }

    public String getMaxApptPreferences() {
        return maxApptPreferences;
    }

    public String getMaxApptParticipantsPerDay() {
        return maxApptParticipantsPerDay;
    }

    public String getMaxApptParticipantsForEvent() {
        return maxApptParticipantsForEvent;
    }

    public String getNotExcludeReg() {
        return notExcludeReg;
    }

    public String getMinApptParticipants() {
        return minApptParticipants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppointmentTemplate that = (AppointmentTemplate) o;

        if (templateName != null ? !templateName.equals(that.templateName) : that.templateName != null) return false;
        if (templateDescription != null ? !templateDescription.equals(that.templateDescription) : that.templateDescription != null)
            return false;
        if (atLeastPreferences != null ? !atLeastPreferences.equals(that.atLeastPreferences) : that.atLeastPreferences != null)
            return false;
        if (morePreferences != null ? !morePreferences.equals(that.morePreferences) : that.morePreferences != null)
            return false;
        if (maxApptPreferences != null ? !maxApptPreferences.equals(that.maxApptPreferences) : that.maxApptPreferences != null)
            return false;
        if (maxApptParticipantsPerDay != null ? !maxApptParticipantsPerDay.equals(that.maxApptParticipantsPerDay) : that.maxApptParticipantsPerDay != null)
            return false;
        if (maxApptParticipantsForEvent != null ? !maxApptParticipantsForEvent.equals(that.maxApptParticipantsForEvent) : that.maxApptParticipantsForEvent != null)
            return false;
        if (notExcludeReg != null ? !notExcludeReg.equals(that.notExcludeReg) : that.notExcludeReg != null)
            return false;
        return !(minApptParticipants != null ? !minApptParticipants.equals(that.minApptParticipants) : that.minApptParticipants != null);

    }

    @Override
    public int hashCode() {
        int result = templateName != null ? templateName.hashCode() : 0;
        result = 31 * result + (templateDescription != null ? templateDescription.hashCode() : 0);
        result = 31 * result + (atLeastPreferences != null ? atLeastPreferences.hashCode() : 0);
        result = 31 * result + (morePreferences != null ? morePreferences.hashCode() : 0);
        result = 31 * result + (maxApptPreferences != null ? maxApptPreferences.hashCode() : 0);
        result = 31 * result + (maxApptParticipantsPerDay != null ? maxApptParticipantsPerDay.hashCode() : 0);
        result = 31 * result + (maxApptParticipantsForEvent != null ? maxApptParticipantsForEvent.hashCode() : 0);
        result = 31 * result + (notExcludeReg != null ? notExcludeReg.hashCode() : 0);
        result = 31 * result + (minApptParticipants != null ? minApptParticipants.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AppointmentTemplate{" +
                "templateName='" + templateName + '\'' +
                ", templateDescription='" + templateDescription + '\'' +
                ", atLeastPreferences='" + atLeastPreferences + '\'' +
                ", morePreferences='" + morePreferences + '\'' +
                ", maxApptPreferences='" + maxApptPreferences + '\'' +
                ", maxApptParticipantsPerDay='" + maxApptParticipantsPerDay + '\'' +
                ", maxApptParticipantsForEvent='" + maxApptParticipantsForEvent + '\'' +
                ", notExcludeReg='" + notExcludeReg + '\'' +
                ", minApptParticipants='" + minApptParticipants + '\'' +
                '}';
    }
}
