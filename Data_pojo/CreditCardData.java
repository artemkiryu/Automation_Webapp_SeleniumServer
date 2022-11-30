package pojo;

/**
 * Created by Neha Goyal on 25/05/2016.
 */
public class CreditCardData {
    private String cardType;
    private String cardName;
    private String cardNumber;
    private String cardExpiryMonth;
    private String cardExpiryYear;

    public CreditCardData(String cardType, String cardName, String cardNumber, String cardExpiryMonth, String cardExpiryYear) {
        this.cardType = cardType;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardExpiryMonth = cardExpiryMonth;
        this.cardExpiryYear = cardExpiryYear;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardExpiryMonth() {
        return cardExpiryMonth;
    }

    public String getCardExpiryYear() {
        return cardExpiryYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCardData)) return false;

        CreditCardData that = (CreditCardData) o;

        if (cardType != null ? !cardType.equals(that.cardType) : that.cardType != null) return false;
        if (cardName != null ? !cardName.equals(that.cardName) : that.cardName != null) return false;
        if (cardNumber != null ? !cardNumber.equals(that.cardNumber) : that.cardNumber != null) return false;
        if (cardExpiryMonth != null ? !cardExpiryMonth.equals(that.cardExpiryMonth) : that.cardExpiryMonth != null)
            return false;
        return !(cardExpiryYear != null ? !cardExpiryYear.equals(that.cardExpiryYear) : that.cardExpiryYear != null);

    }

    @Override
    public int hashCode() {
        int result = cardType != null ? cardType.hashCode() : 0;
        result = 31 * result + (cardName != null ? cardName.hashCode() : 0);
        result = 31 * result + (cardNumber != null ? cardNumber.hashCode() : 0);
        result = 31 * result + (cardExpiryMonth != null ? cardExpiryMonth.hashCode() : 0);
        result = 31 * result + (cardExpiryYear != null ? cardExpiryYear.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CreditCardData{" +
                "cardType='" + cardType + '\'' +
                ", cardName='" + cardName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardExpiryMonth='" + cardExpiryMonth + '\'' +
                ", cardExpiryYear='" + cardExpiryYear + '\'' +
                '}';
    }
}
