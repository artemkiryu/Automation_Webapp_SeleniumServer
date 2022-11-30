package pojo;

import java.util.Objects;

/**
 * Created by pkapoors on 03/06/15.
 */
public class ContactInformation {
    private String eventCode;
    private String firstName;
    private String lastName;
    private String email;
    private String position;
    private String organization;
    private String username;
    private String externalProfileID;
    private String salesforceID;
    private String prefix;
    private String badgeName;
    private String gender;
    private String dob;
    private String password;
    private String mi;
    private String suffix;

    public ContactInformation(String eventCode, String firstName, String lastName, String email, String position, String organization, String username, String externalProfileID, String salesforceID, String prefix, String mi, String suffix, String badgeName, String gender, String dob, String password) {
        this.eventCode = eventCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.position = position;
        this.organization = organization;
        this.username = username;
        this.externalProfileID = externalProfileID;
        this.salesforceID = salesforceID;
        this.prefix = prefix;
        this.mi = mi;
        this.suffix = suffix;
        this.badgeName = badgeName;
        this.gender = gender;
        this.dob = dob;
        this.password = password;
    }

    public ContactInformation(String firstName, String lastName, String email, String position, String organization, String username, String externalProfileID, String salesforceID, String prefix, String mi, String suffix, String badgeName, String gender, String dob, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.position = position;
        this.organization = organization;
        this.username = username;
        this.externalProfileID = externalProfileID;
        this.salesforceID = salesforceID;
        this.prefix = prefix;
        this.mi = mi;
        this.suffix = suffix;
        this.badgeName = badgeName;
        this.gender = gender;
        this.dob = dob;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getExternalProfileID() {
        return externalProfileID;
    }

    public void setExternalProfileID(String externalProfileID) {
        this.externalProfileID = externalProfileID;
    }

    public String getSalesforceID() {
        return salesforceID;
    }

    public void setSalesforceID(String salesforceID) {
        this.salesforceID = salesforceID;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMi() {
        return mi;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getEventCode() {
        return eventCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInformation that = (ContactInformation) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(position, that.position) &&
                Objects.equals(organization, that.organization) &&
                Objects.equals(username, that.username) &&
                Objects.equals(externalProfileID, that.externalProfileID) &&
                Objects.equals(salesforceID, that.salesforceID) &&
                Objects.equals(prefix, that.prefix) &&
                Objects.equals(badgeName, that.badgeName) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(dob, that.dob) &&
                Objects.equals(password, that.password) &&
                Objects.equals(mi, that.mi) &&
                Objects.equals(suffix, that.suffix) &&
                Objects.equals(eventCode, that.eventCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, email, position, organization, username, externalProfileID, salesforceID, prefix, badgeName, gender, dob, password, mi, suffix, eventCode);
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", organization='" + organization + '\'' +
                ", username='" + username + '\'' +
                ", externalProfileID='" + externalProfileID + '\'' +
                ", salesforceID='" + salesforceID + '\'' +
                ", prefix='" + prefix + '\'' +
                ", badgeName='" + badgeName + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", password='" + password + '\'' +
                ", mi='" + mi + '\'' +
                ", suffix='" + suffix + '\'' +
                ", eventCode='" + eventCode + '\'' +
                '}';
    }

}
