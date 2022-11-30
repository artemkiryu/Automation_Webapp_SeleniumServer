package pojo;

public class SessionFeeStructureData {

    private String feeExpirationDate;
    private String feeTimeHrs;
    private String feeTimeMins;
    private String amount;
    private String uniqueFeeCode;
    private String feeLabel;
    private String glAccount;
    private String feeCount;

    public SessionFeeStructureData(String feeExpirationDate, String feeTimeHrs, String feeTimeMins, String amount, String uniqueFeeCode, String feeLabel, String glAccount, String feeCount) {
        this.feeExpirationDate = feeExpirationDate;
        this.feeTimeHrs = feeTimeHrs;
        this.feeTimeMins = feeTimeMins;
        this.amount = amount;
        this.uniqueFeeCode = uniqueFeeCode;
        this.feeLabel = feeLabel;
        this.glAccount = glAccount;
        this.feeCount = feeCount;
    }

    public String getFeeExpirationDate() {
        return feeExpirationDate;
    }

    public String getFeeTimeHrs() {
        return feeTimeHrs;
    }

    public String getFeeTimeMins() {
        return feeTimeMins;
    }

    public String getAmount() {
        return amount;
    }

    public String getUniqueFeeCode() {
        return uniqueFeeCode;
    }

    public String getFeeLabel() {
        return feeLabel;
    }

    public String getGlAccount() {
        return glAccount;
    }

    public String getFeeCount() {
        return feeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SessionFeeStructureData)) return false;

        SessionFeeStructureData that = (SessionFeeStructureData) o;

        if (!getFeeExpirationDate().equals(that.getFeeExpirationDate())) return false;
        if (!getFeeTimeHrs().equals(that.getFeeTimeHrs())) return false;
        if (!getFeeTimeMins().equals(that.getFeeTimeMins())) return false;
        if (!getAmount().equals(that.getAmount())) return false;
        if (!getUniqueFeeCode().equals(that.getUniqueFeeCode())) return false;
        if (!getFeeLabel().equals(that.getFeeLabel())) return false;
        if (!getGlAccount().equals(that.getGlAccount())) return false;
        return getFeeCount().equals(that.getFeeCount());
    }

    @Override
    public int hashCode() {
        int result = getFeeExpirationDate().hashCode();
        result = 31 * result + getFeeTimeHrs().hashCode();
        result = 31 * result + getFeeTimeMins().hashCode();
        result = 31 * result + getAmount().hashCode();
        result = 31 * result + getUniqueFeeCode().hashCode();
        result = 31 * result + getFeeLabel().hashCode();
        result = 31 * result + getGlAccount().hashCode();
        result = 31 * result + getFeeCount().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SessionFeeStructureData{" +
                "feeExpirationDate='" + feeExpirationDate + '\'' +
                ", feeTimeHrs='" + feeTimeHrs + '\'' +
                ", feeTimeMins='" + feeTimeMins + '\'' +
                ", amount='" + amount + '\'' +
                ", uniqueFeeCode='" + uniqueFeeCode + '\'' +
                ", feeLabel='" + feeLabel + '\'' +
                ", glAccount='" + glAccount + '\'' +
                ", feeCount='" + feeCount + '\'' +
                '}';
    }


}
