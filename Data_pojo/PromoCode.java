package pojo;

public class PromoCode {
    private String promoName;
    private String promoCode;
    private String discountName;
    private String uniqueCode;
    private String discountAmount;
    private String codeInventory;
    private String startOption;
    private String endOption;

    public PromoCode(String promoName, String promoCode, String discountName, String uniqueCode, String discountAmount, String codeInventory, String startOption, String endOption) {
        this.promoName = promoName;
        this.promoCode = promoCode;
        this.discountName = discountName;
        this.uniqueCode = uniqueCode;
        this.discountAmount = discountAmount;
        this.codeInventory = codeInventory;
        this.startOption = startOption;
        this.endOption = endOption;
    }

    public String getPromoName() {
        return promoName;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public String getDiscountName() {
        return discountName;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public String getCodeInventory() {
        return codeInventory;
    }

    public String getStartOption() {
        return startOption;
    }

    public String getEndOption() {
        return endOption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromoCode that = (PromoCode) o;

        if (promoName != null ? !promoName.equals(that.promoName) : that.promoName != null) return false;
        if (promoCode != null ? !promoCode.equals(that.promoCode) : that.promoCode != null) return false;
        if (discountName != null ? !discountName.equals(that.discountName) : that.discountName != null) return false;
        if (uniqueCode != null ? !uniqueCode.equals(that.uniqueCode) : that.uniqueCode != null) return false;
        if (discountAmount != null ? !discountAmount.equals(that.discountAmount) : that.discountAmount != null)
            return false;
        if (codeInventory != null ? !codeInventory.equals(that.codeInventory) : that.codeInventory != null)
            return false;
        if (startOption != null ? !startOption.equals(that.startOption) : that.startOption != null) return false;
        return !(endOption != null ? !endOption.equals(that.endOption) : that.endOption != null);

    }

    @Override
    public int hashCode() {
        int result = promoName != null ? promoName.hashCode() : 0;
        result = 31 * result + (promoCode != null ? promoCode.hashCode() : 0);
        result = 31 * result + (discountName != null ? discountName.hashCode() : 0);
        result = 31 * result + (uniqueCode != null ? uniqueCode.hashCode() : 0);
        result = 31 * result + (discountAmount != null ? discountAmount.hashCode() : 0);
        result = 31 * result + (codeInventory != null ? codeInventory.hashCode() : 0);
        result = 31 * result + (startOption != null ? startOption.hashCode() : 0);
        result = 31 * result + (endOption != null ? endOption.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PromoCode{" +
                "promoName='" + promoName + '\'' +
                ", promoCode='" + promoCode + '\'' +
                ", discountName='" + discountName + '\'' +
                ", uniqueCode='" + uniqueCode + '\'' +
                ", discountAmount='" + discountAmount + '\'' +
                ", codeInventory='" + codeInventory + '\'' +
                ", startOption='" + startOption + '\'' +
                ", endOption='" + endOption + '\'' +
                '}';
    }
}


