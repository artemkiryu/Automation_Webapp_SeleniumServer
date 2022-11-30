package pojo;

/**
 * Created by pkapoors on 03/06/15.
 */
public class ContactDetails {
    private String phone;
    private String fax;
    private String mobile;
    private String otherPhone;
    private String webAddress;
    private String facebook;
    private String linkedIn;
    private AssistantInfo assistantInfo;
    private String google;
    private String twitter;

    public ContactDetails(String phone, String fax, String mobile, String otherPhone, String webAddress, String facebook, String linkedIn, AssistantInfo assistantInfo, String google, String twitter) {
        this.phone = phone;
        this.fax = fax;
        this.mobile = mobile;
        this.otherPhone = otherPhone;
        this.webAddress = webAddress;
        this.facebook = facebook;
        this.linkedIn = linkedIn;
        this.assistantInfo = assistantInfo;
        this.google = google;
        this.twitter = twitter;
    }

    @Override
    public String toString() {
        return "ContactDetails{" +
                "phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", mobile='" + mobile + '\'' +
                ", otherPhone='" + otherPhone + '\'' +
                ", webAddress='" + webAddress + '\'' +
                ", facebook='" + facebook + '\'' +
                ", linkedIn='" + linkedIn + '\'' +
                ", assistantInfo=" + assistantInfo +
                ", google='" + google + '\'' +
                ", twitter='" + twitter + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactDetails)) return false;

        ContactDetails that = (ContactDetails) o;

        if (getPhone() != null ? !getPhone().equals(that.getPhone()) : that.getPhone() != null) return false;
        if (getFax() != null ? !getFax().equals(that.getFax()) : that.getFax() != null) return false;
        if (getMobile() != null ? !getMobile().equals(that.getMobile()) : that.getMobile() != null) return false;
        if (getOtherPhone() != null ? !getOtherPhone().equals(that.getOtherPhone()) : that.getOtherPhone() != null)
            return false;
        if (getWebAddress() != null ? !getWebAddress().equals(that.getWebAddress()) : that.getWebAddress() != null)
            return false;
        if (getFacebook() != null ? !getFacebook().equals(that.getFacebook()) : that.getFacebook() != null)
            return false;
        if (getLinkedIn() != null ? !getLinkedIn().equals(that.getLinkedIn()) : that.getLinkedIn() != null)
            return false;
        if (getAssistantInfo() != null ? !getAssistantInfo().equals(that.getAssistantInfo()) : that.getAssistantInfo() != null)
            return false;
        if (getGoogle() != null ? !getGoogle().equals(that.getGoogle()) : that.getGoogle() != null) return false;
        return !(getTwitter() != null ? !getTwitter().equals(that.getTwitter()) : that.getTwitter() != null);

    }

    @Override
    public int hashCode() {
        int result = getPhone() != null ? getPhone().hashCode() : 0;
        result = 31 * result + (getFax() != null ? getFax().hashCode() : 0);
        result = 31 * result + (getMobile() != null ? getMobile().hashCode() : 0);
        result = 31 * result + (getOtherPhone() != null ? getOtherPhone().hashCode() : 0);
        result = 31 * result + (getWebAddress() != null ? getWebAddress().hashCode() : 0);
        result = 31 * result + (getFacebook() != null ? getFacebook().hashCode() : 0);
        result = 31 * result + (getLinkedIn() != null ? getLinkedIn().hashCode() : 0);
        result = 31 * result + (getAssistantInfo() != null ? getAssistantInfo().hashCode() : 0);
        result = 31 * result + (getGoogle() != null ? getGoogle().hashCode() : 0);
        result = 31 * result + (getTwitter() != null ? getTwitter().hashCode() : 0);
        return result;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public AssistantInfo getAssistantInfo() {
        return assistantInfo;
    }

    public void setAssistantInfo(AssistantInfo assistantInfo) {
        this.assistantInfo = assistantInfo;
    }

    public String getGoogle() {
        return google;
    }

    public void setGoogle(String google) {
        this.google = google;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
}
