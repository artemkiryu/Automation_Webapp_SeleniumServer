package pojo;

/**
 * Created by infoobjects on 8/18/2017.
 */
public class AddEventContactData {

    private String name;
    private String email;
    private String organization;
    private String url;
    private String phone;
    private String fax;
    private String tollFree;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String state;
    private String zipCode;
    private String nonUsProvince;
    private String country;
    private String account;
    private String userNotes;

    public AddEventContactData(String name, String email, String organization, String url, String phone, String fax, String tollFree, String addressLine1, String addressLine2, String addressLine3, String city, String state, String zipCode, String nonUsProvince, String country, String account, String userNotes) {
        this.name = name;
        this.email = email;
        this.organization = organization;
        this.url = url;
        this.phone = phone;
        this.fax = fax;
        this.tollFree = tollFree;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.nonUsProvince = nonUsProvince;
        this.country = country;
        this.account = account;
        this.userNotes = userNotes;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getOrganization() {
        return organization;
    }

    public String getUrl() {
        return url;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getTollFree() {
        return tollFree;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
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

    public String getNonUsProvince() {
        return nonUsProvince;
    }

    public String getCountry() {
        return country;
    }

    public String getAccount() {
        return account;
    }

    public String getUserNotes() {
        return userNotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddEventContactData)) return false;

        AddEventContactData that = (AddEventContactData) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (organization != null ? !organization.equals(that.organization) : that.organization != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (tollFree != null ? !tollFree.equals(that.tollFree) : that.tollFree != null) return false;
        if (addressLine1 != null ? !addressLine1.equals(that.addressLine1) : that.addressLine1 != null) return false;
        if (addressLine2 != null ? !addressLine2.equals(that.addressLine2) : that.addressLine2 != null) return false;
        if (addressLine3 != null ? !addressLine3.equals(that.addressLine3) : that.addressLine3 != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null) return false;
        if (nonUsProvince != null ? !nonUsProvince.equals(that.nonUsProvince) : that.nonUsProvince != null)
            return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        return !(userNotes != null ? !userNotes.equals(that.userNotes) : that.userNotes != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (tollFree != null ? tollFree.hashCode() : 0);
        result = 31 * result + (addressLine1 != null ? addressLine1.hashCode() : 0);
        result = 31 * result + (addressLine2 != null ? addressLine2.hashCode() : 0);
        result = 31 * result + (addressLine3 != null ? addressLine3.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (nonUsProvince != null ? nonUsProvince.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (userNotes != null ? userNotes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AddEventContactData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", organization='" + organization + '\'' +
                ", url='" + url + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", tollFree='" + tollFree + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", addressLine3='" + addressLine3 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", nonUsProvince='" + nonUsProvince + '\'' +
                ", country='" + country + '\'' +
                ", account='" + account + '\'' +
                ", userNotes='" + userNotes + '\'' +
                '}';
    }
}
