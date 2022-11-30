package pojo;

/**
 * Created by bludshot on 3/6/15.
 */
public class ShippingInfo {
    private String shipToName;
    private String shipToOrganization;
    private Address shippingAddress;

    public ShippingInfo(String shipToName, String shipToOrganization, Address shippingAddress) {
        this.shipToName = shipToName;
        this.shipToOrganization = shipToOrganization;
        this.shippingAddress = shippingAddress;
    }

    public String getShipToName() {
        return shipToName;
    }

    public String getShipToOrganization() {
        return shipToOrganization;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShippingInfo that = (ShippingInfo) o;

        if (shipToName != null ? !shipToName.equals(that.shipToName) : that.shipToName != null) return false;
        if (shipToOrganization != null ? !shipToOrganization.equals(that.shipToOrganization) : that.shipToOrganization != null)
            return false;
        return !(shippingAddress != null ? !shippingAddress.equals(that.shippingAddress) : that.shippingAddress != null);

    }

    @Override
    public int hashCode() {
        int result = shipToName != null ? shipToName.hashCode() : 0;
        result = 31 * result + (shipToOrganization != null ? shipToOrganization.hashCode() : 0);
        result = 31 * result + (shippingAddress != null ? shippingAddress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShippingInfo{" +
                "shipToName='" + shipToName + '\'' +
                ", shipToOrganization='" + shipToOrganization + '\'' +
                ", shippingAddress=" + shippingAddress +
                '}';
    }
}
