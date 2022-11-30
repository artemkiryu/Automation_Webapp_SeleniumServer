package pojo;

/**
 * Created by infoobjects on 9/6/2017.
 */
public class AppointmentsColorCodeData {
    private String selfScheduledColorCode;
    private String matchedAppointmentColorCode;
    private String blockedTimeColorCode;
    private String availableTimeColorCode;
    private String agendaSessionColorCode;
    private String ssaRequestSentColorCode;
    private String ssaRequestRecievedColorCode;
    private String primaryButtonColorCode;
    private String secondaryButtonColorCode;

    public AppointmentsColorCodeData(String selfScheduledColorCode, String matchedAppointmentColorCode, String blockedTimeColorCode, String availableTimeColorCode, String agendaSessionColorCode, String ssaRequestSentColorCode, String ssaRequestRecievedColorCode, String primaryButtonColorCode, String secondaryButtonColorCode) {
        this.selfScheduledColorCode = selfScheduledColorCode;
        this.matchedAppointmentColorCode = matchedAppointmentColorCode;
        this.blockedTimeColorCode = blockedTimeColorCode;
        this.availableTimeColorCode = availableTimeColorCode;
        this.agendaSessionColorCode = agendaSessionColorCode;
        this.ssaRequestSentColorCode = ssaRequestSentColorCode;
        this.ssaRequestRecievedColorCode = ssaRequestRecievedColorCode;
        this.primaryButtonColorCode = primaryButtonColorCode;
        this.secondaryButtonColorCode = secondaryButtonColorCode;
    }

    public String getSelfScheduledColorCode() {
        return selfScheduledColorCode;
    }

    public String getMatchedAppointmentColorCode() {
        return matchedAppointmentColorCode;
    }

    public String getBlockedTimeColorCode() {
        return blockedTimeColorCode;
    }

    public String getAvailableTimeColorCode() {
        return availableTimeColorCode;
    }

    public String getAgendaSessionColorCode() {
        return agendaSessionColorCode;
    }

    public String getSsaRequestSentColorCode() {
        return ssaRequestSentColorCode;
    }

    public String getSsaRequestRecievedColorCode() {
        return ssaRequestRecievedColorCode;
    }

    public String getPrimaryButtonColorCode() {
        return primaryButtonColorCode;
    }

    public String getSecondaryButtonColorCode() {
        return secondaryButtonColorCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppointmentsColorCodeData)) return false;

        AppointmentsColorCodeData that = (AppointmentsColorCodeData) o;

        if (selfScheduledColorCode != null ? !selfScheduledColorCode.equals(that.selfScheduledColorCode) : that.selfScheduledColorCode != null)
            return false;
        if (matchedAppointmentColorCode != null ? !matchedAppointmentColorCode.equals(that.matchedAppointmentColorCode) : that.matchedAppointmentColorCode != null)
            return false;
        if (blockedTimeColorCode != null ? !blockedTimeColorCode.equals(that.blockedTimeColorCode) : that.blockedTimeColorCode != null)
            return false;
        if (availableTimeColorCode != null ? !availableTimeColorCode.equals(that.availableTimeColorCode) : that.availableTimeColorCode != null)
            return false;
        if (agendaSessionColorCode != null ? !agendaSessionColorCode.equals(that.agendaSessionColorCode) : that.agendaSessionColorCode != null)
            return false;
        if (ssaRequestSentColorCode != null ? !ssaRequestSentColorCode.equals(that.ssaRequestSentColorCode) : that.ssaRequestSentColorCode != null)
            return false;
        if (ssaRequestRecievedColorCode != null ? !ssaRequestRecievedColorCode.equals(that.ssaRequestRecievedColorCode) : that.ssaRequestRecievedColorCode != null)
            return false;
        if (primaryButtonColorCode != null ? !primaryButtonColorCode.equals(that.primaryButtonColorCode) : that.primaryButtonColorCode != null)
            return false;
        return !(secondaryButtonColorCode != null ? !secondaryButtonColorCode.equals(that.secondaryButtonColorCode) : that.secondaryButtonColorCode != null);

    }

    @Override
    public int hashCode() {
        int result = selfScheduledColorCode != null ? selfScheduledColorCode.hashCode() : 0;
        result = 31 * result + (matchedAppointmentColorCode != null ? matchedAppointmentColorCode.hashCode() : 0);
        result = 31 * result + (blockedTimeColorCode != null ? blockedTimeColorCode.hashCode() : 0);
        result = 31 * result + (availableTimeColorCode != null ? availableTimeColorCode.hashCode() : 0);
        result = 31 * result + (agendaSessionColorCode != null ? agendaSessionColorCode.hashCode() : 0);
        result = 31 * result + (ssaRequestSentColorCode != null ? ssaRequestSentColorCode.hashCode() : 0);
        result = 31 * result + (ssaRequestRecievedColorCode != null ? ssaRequestRecievedColorCode.hashCode() : 0);
        result = 31 * result + (primaryButtonColorCode != null ? primaryButtonColorCode.hashCode() : 0);
        result = 31 * result + (secondaryButtonColorCode != null ? secondaryButtonColorCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AppointmentsColorCodeData{" +
                "selfScheduledColorCode='" + selfScheduledColorCode + '\'' +
                ", matchedAppointmentColorCode='" + matchedAppointmentColorCode + '\'' +
                ", blockedTimeColorCode='" + blockedTimeColorCode + '\'' +
                ", availableTimeColorCode='" + availableTimeColorCode + '\'' +
                ", agendaSessionColorCode='" + agendaSessionColorCode + '\'' +
                ", ssaRequestSentColorCode='" + ssaRequestSentColorCode + '\'' +
                ", ssaRequestRecievedColorCode='" + ssaRequestRecievedColorCode + '\'' +
                ", primaryButtonColorCode='" + primaryButtonColorCode + '\'' +
                ", secondaryButtonColorCode='" + secondaryButtonColorCode + '\'' +
                '}';
    }
}
