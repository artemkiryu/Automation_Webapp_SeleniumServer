package pojo;

import java.util.Objects;

public class AddSpeakerData {

    private String firstName;
    private String lastName;
    private String prefix;
    private String badgeName;
    private String middleName;
    private String suffix;
    private String speakerType;
    private String email;
    private String username;
    private String password;
    private String gender;
    private String dob;
    private String organization;
    private String position;
    private String phone;
    private String mobile;
    private String fax;
    private String webAddress;
    private String facebook;
    private String linkedIn;
    private String google;
    private String twitter;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postalCode;
    private String state;
    private String country;
    private String profilePicture;
    private String bio;
    private String notes;

    public AddSpeakerData(String firstName, String lastName, String prefix, String middleName, String suffix, String email, String username, String password, String organization, String position, String phone, String facebook, String linkedIn, String google, String twitter, String addressLine1, String addressLine2, String city, String postalCode, String state, String country, String bio, String notes, String gender, String dob, String fax, String webAddress, String mobile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.prefix = prefix;
        this.middleName = middleName;
        this.suffix = suffix;
        this.email = email;
        this.username = username;
        this.password = password;
        this.organization = organization;
        this.position = position;
        this.phone = phone;
        this.facebook = facebook;
        this.linkedIn = linkedIn;
        this.google = google;
        this.twitter = twitter;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postalCode = postalCode;
        this.state = state;
        this.country = country;
        this.bio = bio;
        this.notes = notes;
        this.gender = gender;
        this.dob = dob;
        this.fax = fax;
        this.webAddress = webAddress;
        this.mobile = mobile;
    }

    public AddSpeakerData(String firstName, String lastName, String speakerType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.speakerType = speakerType;
    }

    public AddSpeakerData(String firstName, String lastName, String speakerType, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.speakerType = speakerType;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public AddSpeakerData(String firstName, String lastName, String prefix, String badgeName, String middleName, String suffix, String speakerType, String email, String username, String password, String gender, String dob, String organization, String position, String phone, String mobile, String fax, String webAddress, String facebook, String linkedIn, String google, String twitter, String addressLine1, String addressLine2, String city, String postalCode, String state, String zipcode, String country, String profilePicture, String bio, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.prefix = prefix;
        this.badgeName = badgeName;
        this.middleName = middleName;
        this.suffix = suffix;
        this.speakerType = speakerType;
        this.email = email;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.organization = organization;
        this.position = position;
        this.phone = phone;
        this.mobile = mobile;
        this.fax = fax;
        this.webAddress = webAddress;
        this.facebook = facebook;
        this.linkedIn = linkedIn;
        this.google = google;
        this.twitter = twitter;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postalCode = postalCode;
        this.state = state;
        this.country = country;
        this.profilePicture = profilePicture;
        this.bio = bio;
        this.notes = notes;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getSpeakerType() {
        return speakerType;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getOrganization() {
        return organization;
    }

    public String getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getFax() {
        return fax;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public String getGoogle() {
        return google;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getBio() {
        return bio;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddSpeakerData that = (AddSpeakerData) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(prefix, that.prefix) &&
                Objects.equals(badgeName, that.badgeName) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(suffix, that.suffix) &&
                Objects.equals(speakerType, that.speakerType) &&
                Objects.equals(email, that.email) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(dob, that.dob) &&
                Objects.equals(organization, that.organization) &&
                Objects.equals(position, that.position) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(fax, that.fax) &&
                Objects.equals(webAddress, that.webAddress) &&
                Objects.equals(facebook, that.facebook) &&
                Objects.equals(linkedIn, that.linkedIn) &&
                Objects.equals(google, that.google) &&
                Objects.equals(twitter, that.twitter) &&
                Objects.equals(addressLine1, that.addressLine1) &&
                Objects.equals(addressLine2, that.addressLine2) &&
                Objects.equals(city, that.city) &&
                Objects.equals(postalCode, that.postalCode) &&
                Objects.equals(state, that.state) &&
                Objects.equals(country, that.country) &&
                Objects.equals(profilePicture, that.profilePicture) &&
                Objects.equals(bio, that.bio) &&
                Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, prefix, badgeName, middleName, suffix, speakerType, email, username, password, gender, dob, organization, position, phone, mobile, fax, webAddress, facebook, linkedIn, google, twitter, addressLine1, addressLine2, city, postalCode, state, country, profilePicture, bio, notes);
    }

    @Override
    public String toString() {
        return "AddSpeakerData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", prefix='" + prefix + '\'' +
                ", badgeName='" + badgeName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", speakerType='" + speakerType + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", organization='" + organization + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", fax='" + fax + '\'' +
                ", webAddress='" + webAddress + '\'' +
                ", facebook='" + facebook + '\'' +
                ", linkedIn='" + linkedIn + '\'' +
                ", google='" + google + '\'' +
                ", twitter='" + twitter + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", bio='" + bio + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
