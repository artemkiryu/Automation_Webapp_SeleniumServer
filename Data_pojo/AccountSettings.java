package pojo;

/**
 * Created by infoobjects on 6/28/2017.
 */
public class AccountSettings {
    private String uniqueCode;
    private String supportRep;
    private String parentAccount;
    private String customerID;
    private boolean active;
    private String accountName;
    private String primaryContact;
    private String email;

    public AccountSettings(String uniqueCode, String supportRep, String parentAccount, String customerID, boolean active, String accountName, String primaryContact, String email) {
        this.uniqueCode = uniqueCode;
        this.supportRep = supportRep;
        this.parentAccount = parentAccount;
        this.customerID = customerID;
        this.active = active;
        this.accountName = accountName;
        this.primaryContact = primaryContact;
        this.email = email;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public String getSupportRep() {
        return supportRep;
    }

    public String getParentAccount() {
        return parentAccount;
    }

    public String getCustomerID() {
        return customerID;
    }

    public boolean isActive() {
        return active;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPrimaryContact() {
        return primaryContact;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountSettings that = (AccountSettings) o;

        if (active != that.active) return false;
        if (uniqueCode != null ? !uniqueCode.equals(that.uniqueCode) : that.uniqueCode != null) return false;
        if (supportRep != null ? !supportRep.equals(that.supportRep) : that.supportRep != null) return false;
        if (parentAccount != null ? !parentAccount.equals(that.parentAccount) : that.parentAccount != null)
            return false;
        if (customerID != null ? !customerID.equals(that.customerID) : that.customerID != null) return false;
        if (accountName != null ? !accountName.equals(that.accountName) : that.accountName != null) return false;
        if (primaryContact != null ? !primaryContact.equals(that.primaryContact) : that.primaryContact != null)
            return false;
        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        int result = uniqueCode != null ? uniqueCode.hashCode() : 0;
        result = 31 * result + (supportRep != null ? supportRep.hashCode() : 0);
        result = 31 * result + (parentAccount != null ? parentAccount.hashCode() : 0);
        result = 31 * result + (customerID != null ? customerID.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (accountName != null ? accountName.hashCode() : 0);
        result = 31 * result + (primaryContact != null ? primaryContact.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AccountSettings{" +
                "uniqueCode='" + uniqueCode + '\'' +
                ", supportRep='" + supportRep + '\'' +
                ", parentAccount='" + parentAccount + '\'' +
                ", customerID='" + customerID + '\'' +
                ", active=" + active +
                ", accountName='" + accountName + '\'' +
                ", primaryContact='" + primaryContact + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
