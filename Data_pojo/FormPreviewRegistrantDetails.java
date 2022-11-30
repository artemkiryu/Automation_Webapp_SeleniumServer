package pojo;

/**
 * Created by Aditi on 12-06-2015.
 */
public class FormPreviewRegistrantDetails {
    private String firstName;
    private String lastName;
    private String email;
    private String occupation;
    private String companyName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String phoneNo;

    public FormPreviewRegistrantDetails(String firstName, String lastName, String email, String occupation, String companyName, String addressLine1, String addressLine2, String city, String state, String zipCode, String country, String phoneNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.occupation = occupation;
        this.companyName = companyName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.phoneNo = phoneNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getCompanyName() {
        return companyName;
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

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormPreviewRegistrantDetails)) return false;

        FormPreviewRegistrantDetails that = (FormPreviewRegistrantDetails) o;

        if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(that.getLastName()) : that.getLastName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        if (getOccupation() != null ? !getOccupation().equals(that.getOccupation()) : that.getOccupation() != null)
            return false;
        if (getCompanyName() != null ? !getCompanyName().equals(that.getCompanyName()) : that.getCompanyName() != null)
            return false;
        if (getAddressLine1() != null ? !getAddressLine1().equals(that.getAddressLine1()) : that.getAddressLine1() != null)
            return false;
        if (getAddressLine2() != null ? !getAddressLine2().equals(that.getAddressLine2()) : that.getAddressLine2() != null)
            return false;
        if (getCity() != null ? !getCity().equals(that.getCity()) : that.getCity() != null) return false;
        if (getState() != null ? !getState().equals(that.getState()) : that.getState() != null) return false;
        if (getZipCode() != null ? !getZipCode().equals(that.getZipCode()) : that.getZipCode() != null) return false;
        if (getCountry() != null ? !getCountry().equals(that.getCountry()) : that.getCountry() != null) return false;
        return !(getPhoneNo() != null ? !getPhoneNo().equals(that.getPhoneNo()) : that.getPhoneNo() != null);

    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getOccupation() != null ? getOccupation().hashCode() : 0);
        result = 31 * result + (getCompanyName() != null ? getCompanyName().hashCode() : 0);
        result = 31 * result + (getAddressLine1() != null ? getAddressLine1().hashCode() : 0);
        result = 31 * result + (getAddressLine2() != null ? getAddressLine2().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getState() != null ? getState().hashCode() : 0);
        result = 31 * result + (getZipCode() != null ? getZipCode().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getPhoneNo() != null ? getPhoneNo().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FormPreviewRegistrantDetails{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", occupation='" + occupation + '\'' +
                ", companyName='" + companyName + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
