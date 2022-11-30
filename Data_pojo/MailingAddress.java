package pojo;

/**
 * Created by pkapoors on 03/06/15.
 */
public class MailingAddress {
    private Address address;
    private AdditionalInfo additionalInfo;

    public MailingAddress(Address address, AdditionalInfo additionalInfo) {
        this.address = address;
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "MailingAddress{" +
                "address=" + address +
                ", additionalInfo=" + additionalInfo +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public AdditionalInfo getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(AdditionalInfo additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MailingAddress)) return false;

        MailingAddress that = (MailingAddress) o;

        if (getAddress() != null ? !getAddress().equals(that.getAddress()) : that.getAddress() != null) return false;
        return !(getAdditionalInfo() != null ? !getAdditionalInfo().equals(that.getAdditionalInfo()) : that.getAdditionalInfo() != null);

    }

    @Override
    public int hashCode() {
        int result = getAddress() != null ? getAddress().hashCode() : 0;
        result = 31 * result + (getAdditionalInfo() != null ? getAdditionalInfo().hashCode() : 0);
        return result;
    }
}
