package pojo;

import java.util.Objects;

public class AddReviewer {
    private String prefix;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String gender;
    private String badgeName;
    private String organization;
    private String email;
    private String position;
    private String dob;
    private String username;
    private String password;
    private String track;
    private String subTrack;
    private String tier;
    private String phone;
    private String mobile;
    private String fax;
    private String webAddress;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postalCode;
    private String state;
    private String country;
    private String facebook;
    private String linkedIn;
    private String google;
    private String twitter;
    private String profilePicture;

    public AddReviewer(String firstName, String lastName, String email, String username, String password, String track, String tier) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.track = track;
        this.tier = tier;
    }

    public AddReviewer(String prefix, String firstName, String middleName, String lastName, String suffix, String gender, String badgeName, String organization, String email, String position, String dob, String username, String password, String track, String subTrack, String tier, String phone, String mobile, String fax, String webAddress, String addressLine1, String addressLine2, String city, String postalCode, String state, String country, String facebook, String linkedIn, String google, String twitter, String profilePicture) {
        this.prefix = prefix;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.gender = gender;
        this.badgeName = badgeName;
        this.organization = organization;
        this.email = email;
        this.position = position;
        this.dob = dob;
        this.username = username;
        this.password = password;
        this.track = track;
        this.subTrack = subTrack;
        this.tier = tier;
        this.phone = phone;
        this.mobile = mobile;
        this.fax = fax;
        this.webAddress = webAddress;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postalCode = postalCode;
        this.state = state;
        this.country = country;
        this.facebook = facebook;
        this.linkedIn = linkedIn;
        this.google = google;
        this.twitter = twitter;
        this.profilePicture = profilePicture;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getGender() {
        return gender;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public String getOrganization() {
        return organization;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }

    public String getDob() {
        return dob;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTrack() {
        return track;
    }

    public String getSubTrack() {
        return subTrack;
    }

    public String getTier() {
        return tier;
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

    public String getProfilePicture() {
        return profilePicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddReviewer that = (AddReviewer) o;
        return Objects.equals(prefix, that.prefix) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(suffix, that.suffix) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(badgeName, that.badgeName) &&
                Objects.equals(organization, that.organization) &&
                Objects.equals(email, that.email) &&
                Objects.equals(position, that.position) &&
                Objects.equals(dob, that.dob) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(track, that.track) &&
                Objects.equals(subTrack, that.subTrack) &&
                Objects.equals(tier, that.tier) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(fax, that.fax) &&
                Objects.equals(webAddress, that.webAddress) &&
                Objects.equals(addressLine1, that.addressLine1) &&
                Objects.equals(addressLine2, that.addressLine2) &&
                Objects.equals(city, that.city) &&
                Objects.equals(postalCode, that.postalCode) &&
                Objects.equals(state, that.state) &&
                Objects.equals(country, that.country) &&
                Objects.equals(facebook, that.facebook) &&
                Objects.equals(linkedIn, that.linkedIn) &&
                Objects.equals(google, that.google) &&
                Objects.equals(twitter, that.twitter) &&
                Objects.equals(profilePicture, that.profilePicture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix, firstName, middleName, lastName, suffix, gender, badgeName, organization, email, position, dob, username, password, track, subTrack, tier, phone, mobile, fax, webAddress, addressLine1, addressLine2, city, postalCode, state, country, facebook, linkedIn, google, twitter, profilePicture);
    }

    @Override
    public String toString() {
        return "AddReviewer{" +
                "prefix='" + prefix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", gender='" + gender + '\'' +
                ", badgeName='" + badgeName + '\'' +
                ", organization='" + organization + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", dob='" + dob + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", track='" + track + '\'' +
                ", subTrack='" + subTrack + '\'' +
                ", tier='" + tier + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", fax='" + fax + '\'' +
                ", webAddress='" + webAddress + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", facebook='" + facebook + '\'' +
                ", linkedIn='" + linkedIn + '\'' +
                ", google='" + google + '\'' +
                ", twitter='" + twitter + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                '}';
    }
}
