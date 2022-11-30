package pojo;

/**
 * Created by infoobjects on 12/24/2015.
 */
public class TravelConfigurationData {
    private String maxTransferTime;
    private String bookingStatus;
    private String paymentCode;
    private String travelType;
    private String travelActionCode;
    private String modeOfTransport;
    private String transportationType;
    private String eventAirports;

    public TravelConfigurationData(String maxTransferTime, String bookingStatus, String paymentCode, String travelType, String travelActionCode, String modeOfTransport, String transportationType, String eventAirports) {
        this.maxTransferTime = maxTransferTime;
        this.bookingStatus = bookingStatus;
        this.paymentCode = paymentCode;
        this.travelType = travelType;
        this.travelActionCode = travelActionCode;
        this.modeOfTransport = modeOfTransport;
        this.transportationType = transportationType;
        this.eventAirports = eventAirports;
    }

    public String getMaxTransferTime() {
        return maxTransferTime;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public String getTravelType() {
        return travelType;
    }

    public String getTravelActionCode() {
        return travelActionCode;
    }

    public String getModeOfTransport() {
        return modeOfTransport;
    }

    public String getTransportationType() {
        return transportationType;
    }

    public String getEventAirports() {
        return eventAirports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TravelConfigurationData that = (TravelConfigurationData) o;

        if (maxTransferTime != null ? !maxTransferTime.equals(that.maxTransferTime) : that.maxTransferTime != null)
            return false;
        if (bookingStatus != null ? !bookingStatus.equals(that.bookingStatus) : that.bookingStatus != null)
            return false;
        if (paymentCode != null ? !paymentCode.equals(that.paymentCode) : that.paymentCode != null) return false;
        if (travelType != null ? !travelType.equals(that.travelType) : that.travelType != null) return false;
        if (travelActionCode != null ? !travelActionCode.equals(that.travelActionCode) : that.travelActionCode != null)
            return false;
        if (modeOfTransport != null ? !modeOfTransport.equals(that.modeOfTransport) : that.modeOfTransport != null)
            return false;
        if (transportationType != null ? !transportationType.equals(that.transportationType) : that.transportationType != null)
            return false;
        return !(eventAirports != null ? !eventAirports.equals(that.eventAirports) : that.eventAirports != null);

    }

    @Override
    public int hashCode() {
        int result = maxTransferTime != null ? maxTransferTime.hashCode() : 0;
        result = 31 * result + (bookingStatus != null ? bookingStatus.hashCode() : 0);
        result = 31 * result + (paymentCode != null ? paymentCode.hashCode() : 0);
        result = 31 * result + (travelType != null ? travelType.hashCode() : 0);
        result = 31 * result + (travelActionCode != null ? travelActionCode.hashCode() : 0);
        result = 31 * result + (modeOfTransport != null ? modeOfTransport.hashCode() : 0);
        result = 31 * result + (transportationType != null ? transportationType.hashCode() : 0);
        result = 31 * result + (eventAirports != null ? eventAirports.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TravelConfigurationData{" +
                "maxTransferTime='" + maxTransferTime + '\'' +
                ", bookingStatus='" + bookingStatus + '\'' +
                ", paymentCode='" + paymentCode + '\'' +
                ", travelType='" + travelType + '\'' +
                ", travelActionCode='" + travelActionCode + '\'' +
                ", modeOfTransport='" + modeOfTransport + '\'' +
                ", transportationType='" + transportationType + '\'' +
                ", eventAirports='" + eventAirports + '\'' +
                '}';
    }
}
