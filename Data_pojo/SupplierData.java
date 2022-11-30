package pojo;

/**
 * Created by infoobjects on 8/18/2017.
 */
public class SupplierData {

    private String supplierName;
    private String supplierGLAccount;
    private String contractAmount;
    private String actualAmount;


    public SupplierData(String supplierName, String supplierGLAccount, String contractAmount, String actualAmount) {
        this.supplierName = supplierName;
        this.supplierGLAccount = supplierGLAccount;
        this.contractAmount = contractAmount;
        this.actualAmount = actualAmount;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierGLAccount() {
        return supplierGLAccount;
    }

    public String getContractAmount() {
        return contractAmount;
    }

    public String getActualAmount() {
        return actualAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierData)) return false;

        SupplierData that = (SupplierData) o;

        if (supplierName != null ? !supplierName.equals(that.supplierName) : that.supplierName != null) return false;
        if (supplierGLAccount != null ? !supplierGLAccount.equals(that.supplierGLAccount) : that.supplierGLAccount != null)
            return false;
        if (contractAmount != null ? !contractAmount.equals(that.contractAmount) : that.contractAmount != null)
            return false;
        return !(actualAmount != null ? !actualAmount.equals(that.actualAmount) : that.actualAmount != null);

    }

    @Override
    public int hashCode() {
        int result = supplierName != null ? supplierName.hashCode() : 0;
        result = 31 * result + (supplierGLAccount != null ? supplierGLAccount.hashCode() : 0);
        result = 31 * result + (contractAmount != null ? contractAmount.hashCode() : 0);
        result = 31 * result + (actualAmount != null ? actualAmount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SupplierData{" +
                "supplierName='" + supplierName + '\'' +
                ", supplierGLAccount='" + supplierGLAccount + '\'' +
                ", contractAmount='" + contractAmount + '\'' +
                ", actualAmount='" + actualAmount + '\'' +
                '}';
    }
}
