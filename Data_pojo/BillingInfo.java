package pojo;

/**
 * Created by bludshot on 3/6/15.
 */
public class BillingInfo {
    private String billToName;
    private String billToOrganization;
    private Address billingAddress;

    public BillingInfo(String billToName, String billToOrganization, Address billingAddress) {
        this.billToName = billToName;
        this.billToOrganization = billToOrganization;
        this.billingAddress = billingAddress;
    }

    public String getBillToName() {
        return billToName;
    }

    public String getBillToOrganization() {
        return billToOrganization;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillingInfo that = (BillingInfo) o;

        if (billToName != null ? !billToName.equals(that.billToName) : that.billToName != null) return false;
        if (billToOrganization != null ? !billToOrganization.equals(that.billToOrganization) : that.billToOrganization != null)
            return false;
        return !(billingAddress != null ? !billingAddress.equals(that.billingAddress) : that.billingAddress != null);

    }

    @Override
    public int hashCode() {
        int result = billToName != null ? billToName.hashCode() : 0;
        result = 31 * result + (billToOrganization != null ? billToOrganization.hashCode() : 0);
        result = 31 * result + (billingAddress != null ? billingAddress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BillingInfo{" +
                "billToName='" + billToName + '\'' +
                ", billToOrganization='" + billToOrganization + '\'' +
                ", billingAddress=" + billingAddress +
                '}';
    }
}
