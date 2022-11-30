package pojo;

import java.util.Objects;

public class CreateProfileData {

    private ContactInformation contactInformation;

    private ContactDetails contactDetails;

    private boolean ccEmailToAssistant;

    private MailingAddress mailingAddress;

    private boolean ccEmailToAdditional;
    private BillingInfo billingInfo;
    private ShippingInfo shippingInfo;

    private String userNotes;

    public CreateProfileData(ContactInformation contactInformation, ContactDetails contactDetails, boolean ccEmailToAssistant,
                             MailingAddress mailingAddress, boolean ccEmailToAdditional, BillingInfo billingInfo, ShippingInfo shippingInfo, String userNotes) {
        this.contactInformation = contactInformation;
        this.contactDetails = contactDetails;
        this.ccEmailToAssistant = ccEmailToAssistant;

        this.mailingAddress = mailingAddress;
        this.ccEmailToAdditional = ccEmailToAdditional;

        this.shippingInfo = shippingInfo;
        this.billingInfo = billingInfo;
        this.userNotes = userNotes;

    }

    @Override
    public String toString() {
        return "CreateProfileData{" +
                "contactInformation=" + contactInformation +
                ", contactDetails=" + contactDetails +
                ", ccEmailToAssistant=" + ccEmailToAssistant +
                ", mailingAddress=" + mailingAddress +
                ", ccEmailToAdditional=" + ccEmailToAdditional +
                ", billingInfo=" + billingInfo +
                ", shippingInfo=" + shippingInfo +
                ", userNotes='" + userNotes + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateProfileData that = (CreateProfileData) o;
        return ccEmailToAssistant == that.ccEmailToAssistant &&
                ccEmailToAdditional == that.ccEmailToAdditional &&
                Objects.equals(contactInformation, that.contactInformation) &&
                Objects.equals(contactDetails, that.contactDetails) &&
                Objects.equals(mailingAddress, that.mailingAddress) &&
                Objects.equals(billingInfo, that.billingInfo) &&
                Objects.equals(shippingInfo, that.shippingInfo) &&
                Objects.equals(userNotes, that.userNotes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(contactInformation, contactDetails, ccEmailToAssistant, mailingAddress, ccEmailToAdditional, billingInfo, shippingInfo, userNotes);
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

    public boolean isCcEmailToAdditional() {
        return ccEmailToAdditional;
    }

    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public String getUserNotes() {
        return userNotes;
    }

}
