package pojo;

/**
 * Created by infoobjects on 5/12/2015.
 */
public class CreateRegistrationData {

    //  private String firstName;
    //  private String lastName;
    //  private String email;
    //  private String userName;
    //  private String gender;
    //  private String dob;
    //  private String password;

    private ContactInformation contactInformation;

    private ContactDetails contactDetails;

    // private String phone;
    // private String mobile;
    // private String facebook;
    private boolean ccEmailToAssistant;
    // private String assName;
    // private String assEmail;
    // private String assPhone;
    // private String google;

    private MailingAddress mailingAddress;

    private boolean ccEmailToAdditional;
    private BillingInfo billingInfo;
    private ShippingInfo shippingInfo;

    private String primaryLocation;
    private boolean enableManualOverRide;
    private String fromDate;
    private String untilDate;
    private String fromTime;
    private String untilTime;
    private String attendeeType;
    private String status;
    private String properties;
    private String userNotes;

    public CreateRegistrationData(ContactInformation contactInformation, ContactDetails contactDetails, boolean ccEmailToAssistant,
                                  MailingAddress mailingAddress, boolean ccEmailToAdditional, BillingInfo billingInfo, ShippingInfo shippingInfo,
                                  String primaryLocation, boolean enableManualOverRide, String fromDate, String untilDate,
                                  String fromTime, String untilTime, String attendeeType, String status,
                                  String properties, String userNotes) {
        this.contactInformation = contactInformation;
        this.contactDetails = contactDetails;
        this.ccEmailToAssistant = ccEmailToAssistant;

        this.mailingAddress = mailingAddress;
        this.ccEmailToAdditional = ccEmailToAdditional;

        this.shippingInfo = shippingInfo;
        this.billingInfo = billingInfo;

        this.primaryLocation = primaryLocation;
        this.enableManualOverRide = enableManualOverRide;
        this.fromDate = fromDate;
        this.untilDate = untilDate;
        this.fromTime = fromTime;
        this.untilTime = untilTime;
        this.attendeeType = attendeeType;
        this.status = status;
        this.properties = properties;
        this.userNotes = userNotes;
    }

    @Override
    public String toString() {
        return "CreateRegistrationData{" +
                "contactInformation=" + contactInformation +
                ", contactDetails=" + contactDetails +
                ", ccEmailToAssistant=" + ccEmailToAssistant +
                ", mailingAddress=" + mailingAddress +
                ", billingInfo=" + billingInfo +
                ", shippingInfo=" + shippingInfo +
                ", primaryLocation='" + primaryLocation + '\'' +
                ", enableManualOverRide=" + enableManualOverRide +
                ", fromDate='" + fromDate + '\'' +
                ", untilDate='" + untilDate + '\'' +
                ", fromTime='" + fromTime + '\'' +
                ", untilTime='" + untilTime + '\'' +
                ", attendeeType='" + attendeeType + '\'' +
                ", status='" + status + '\'' +
                ", properties='" + properties + '\'' +
                ", userNotes='" + userNotes + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreateRegistrationData that = (CreateRegistrationData) o;

        if (ccEmailToAssistant != that.ccEmailToAssistant) return false;
        if (enableManualOverRide != that.enableManualOverRide) return false;
        if (contactInformation != null ? !contactInformation.equals(that.contactInformation) : that.contactInformation != null)
            return false;
        if (contactDetails != null ? !contactDetails.equals(that.contactDetails) : that.contactDetails != null)
            return false;
        if (mailingAddress != null ? !mailingAddress.equals(that.mailingAddress) : that.mailingAddress != null)
            return false;
        if (billingInfo != null ? !billingInfo.equals(that.billingInfo) : that.billingInfo != null) return false;
        if (shippingInfo != null ? !shippingInfo.equals(that.shippingInfo) : that.shippingInfo != null) return false;
        if (primaryLocation != null ? !primaryLocation.equals(that.primaryLocation) : that.primaryLocation != null)
            return false;
        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        if (untilDate != null ? !untilDate.equals(that.untilDate) : that.untilDate != null) return false;
        if (fromTime != null ? !fromTime.equals(that.fromTime) : that.fromTime != null) return false;
        if (untilTime != null ? !untilTime.equals(that.untilTime) : that.untilTime != null) return false;
        if (attendeeType != null ? !attendeeType.equals(that.attendeeType) : that.attendeeType != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (properties != null ? !properties.equals(that.properties) : that.properties != null) return false;
        return !(userNotes != null ? !userNotes.equals(that.userNotes) : that.userNotes != null);

    }

    @Override
    public int hashCode() {
        int result = contactInformation != null ? contactInformation.hashCode() : 0;
        result = 31 * result + (contactDetails != null ? contactDetails.hashCode() : 0);
        result = 31 * result + (ccEmailToAssistant ? 1 : 0);
        result = 31 * result + (mailingAddress != null ? mailingAddress.hashCode() : 0);
        result = 31 * result + (billingInfo != null ? billingInfo.hashCode() : 0);
        result = 31 * result + (shippingInfo != null ? shippingInfo.hashCode() : 0);
        result = 31 * result + (primaryLocation != null ? primaryLocation.hashCode() : 0);
        result = 31 * result + (enableManualOverRide ? 1 : 0);
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (untilDate != null ? untilDate.hashCode() : 0);
        result = 31 * result + (fromTime != null ? fromTime.hashCode() : 0);
        result = 31 * result + (untilTime != null ? untilTime.hashCode() : 0);
        result = 31 * result + (attendeeType != null ? attendeeType.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        result = 31 * result + (userNotes != null ? userNotes.hashCode() : 0);
        return result;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public boolean isCcEmailToAssistant() {
        return ccEmailToAssistant;
    }

    public MailingAddress getMailingAddress() {
        return mailingAddress;
    }

    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public String getPrimaryLocation() {
        return primaryLocation;
    }

    public boolean isEnableManualOverRide() {
        return enableManualOverRide;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getUntilDate() {
        return untilDate;
    }

    public String getFromTime() {
        return fromTime;
    }

    public String getUntilTime() {
        return untilTime;
    }

    public String getAttendeeType() {
        return attendeeType;
    }

    public String getStatus() {
        return status;
    }

    public String getProperties() {
        return properties;
    }

    public String getUserNotes() {
        return userNotes;
    }

    public boolean isCcEmailToAdditional() {
        return ccEmailToAdditional;
    }

}