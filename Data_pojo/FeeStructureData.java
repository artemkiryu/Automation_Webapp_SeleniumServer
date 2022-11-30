package pojo;

/**
 * Created by infoobjects on 8/3/2017.
 */
public class FeeStructureData {
    private String feeType;
    private String taxRules;
    private String discountRules;
    private String expirationDate;
    private String expirationTime;
    private String uniqueFeeCode;
    private String labelRegForm;
    private String amount;
    private String glAccount;
    private String percentage;
    private String cancellationFeeChk;

    public FeeStructureData(String feeType, String taxRules, String discountRules, String expirationDate, String expirationTime, String uniqueFeeCode, String labelRegForm, String amount, String glAccount, String percentage, String cancellationFeeChk) {
        this.feeType = feeType;
        this.taxRules = taxRules;
        this.discountRules = discountRules;
        this.expirationDate = expirationDate;
        this.expirationTime = expirationTime;
        this.uniqueFeeCode = uniqueFeeCode;
        this.labelRegForm = labelRegForm;
        this.amount = amount;
        this.glAccount = glAccount;
        this.percentage = percentage;
        this.cancellationFeeChk = cancellationFeeChk;
    }

    public FeeStructureData(String feeType, String discountRules, String uniqueFeeCode, String labelRegForm, String amount, String glAccount, String percentage) {
        this.feeType = feeType;
        this.discountRules = discountRules;
        this.uniqueFeeCode = uniqueFeeCode;
        this.labelRegForm = labelRegForm;
        this.amount = amount;
        this.glAccount = glAccount;
        this.percentage = percentage;
    }

    public String getFeeType() {
        return feeType;
    }

    public String getTaxRules() {
        return taxRules;
    }

    public String getDiscountRules() {
        return discountRules;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public String getUniqueFeeCode() {
        return uniqueFeeCode;
    }

    public String getLabelRegForm() {
        return labelRegForm;
    }

    public String getAmount() {
        return amount;
    }

    public String getGlAccount() {
        return glAccount;
    }

    public String getPercentage() {
        return percentage;
    }

    public String getCancellationFeeChk() {
        return cancellationFeeChk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeeStructureData that = (FeeStructureData) o;

        if (feeType != null ? !feeType.equals(that.feeType) : that.feeType != null) return false;
        if (taxRules != null ? !taxRules.equals(that.taxRules) : that.taxRules != null) return false;
        if (discountRules != null ? !discountRules.equals(that.discountRules) : that.discountRules != null)
            return false;
        if (expirationDate != null ? !expirationDate.equals(that.expirationDate) : that.expirationDate != null)
            return false;
        if (expirationTime != null ? !expirationTime.equals(that.expirationTime) : that.expirationTime != null)
            return false;
        if (uniqueFeeCode != null ? !uniqueFeeCode.equals(that.uniqueFeeCode) : that.uniqueFeeCode != null)
            return false;
        if (labelRegForm != null ? !labelRegForm.equals(that.labelRegForm) : that.labelRegForm != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (glAccount != null ? !glAccount.equals(that.glAccount) : that.glAccount != null) return false;
        if (percentage != null ? !percentage.equals(that.percentage) : that.percentage != null) return false;
        return cancellationFeeChk != null ? cancellationFeeChk.equals(that.cancellationFeeChk) : that.cancellationFeeChk == null;
    }

    @Override
    public int hashCode() {
        int result = feeType != null ? feeType.hashCode() : 0;
        result = 31 * result + (taxRules != null ? taxRules.hashCode() : 0);
        result = 31 * result + (discountRules != null ? discountRules.hashCode() : 0);
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        result = 31 * result + (expirationTime != null ? expirationTime.hashCode() : 0);
        result = 31 * result + (uniqueFeeCode != null ? uniqueFeeCode.hashCode() : 0);
        result = 31 * result + (labelRegForm != null ? labelRegForm.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (glAccount != null ? glAccount.hashCode() : 0);
        result = 31 * result + (percentage != null ? percentage.hashCode() : 0);
        result = 31 * result + (cancellationFeeChk != null ? cancellationFeeChk.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FeeStructureData{" +
                "feeType='" + feeType + '\'' +
                ", taxRules='" + taxRules + '\'' +
                ", discountRules='" + discountRules + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", expirationTime='" + expirationTime + '\'' +
                ", uniqueFeeCode='" + uniqueFeeCode + '\'' +
                ", labelRegForm='" + labelRegForm + '\'' +
                ", amount='" + amount + '\'' +
                ", glAccount='" + glAccount + '\'' +
                ", percentage='" + percentage + '\'' +
                ", cancellationFeeChk='" + cancellationFeeChk + '\'' +
                '}';
    }
}
