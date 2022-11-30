package pojo;

/**
 * Created by Palash Kapoor on 3/26/2015.
 */
public class Address {

    private String streetAddress;
    private String addressLine2;
    private String addressLine3;
    private String country;
    private String state;
    private String nonUSProvince;
    private String city;
    private String zipCode;

    public Address(String streetAddress, String addressLine2, String addressLine3, String country, String state, String nonUSProvince, String city, String zipCode) {
        this.streetAddress = streetAddress;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.country = country;
        this.state = state;
        this.nonUSProvince = nonUSProvince;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (addressLine2 != null ? !addressLine2.equals(address.addressLine2) : address.addressLine2 != null)
            return false;
        if (addressLine3 != null ? !addressLine3.equals(address.addressLine3) : address.addressLine3 != null)
            return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        if (nonUSProvince != null ? !nonUSProvince.equals(address.nonUSProvince) : address.nonUSProvince != null)
            return false;
        if (state != null ? !state.equals(address.state) : address.state != null) return false;
        if (streetAddress != null ? !streetAddress.equals(address.streetAddress) : address.streetAddress != null)
            return false;
        if (zipCode != null ? !zipCode.equals(address.zipCode) : address.zipCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = streetAddress != null ? streetAddress.hashCode() : 0;
        result = 31 * result + (addressLine2 != null ? addressLine2.hashCode() : 0);
        result = 31 * result + (addressLine3 != null ? addressLine3.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (nonUSProvince != null ? nonUSProvince.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", addressLine3='" + addressLine3 + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", nonUSProvince='" + nonUSProvince + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getNonUSProvince() {
        return nonUSProvince;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }
}
