package pojo;

import java.util.Objects;

/**
 * Created by infoobjects on 8/18/2017.
 */
public class FinancialData {
    private String paymentType;
    private String amount;
    private String transactionDesc;
    private String notes;
    private String glAccount;
    private String date;
    private String time;
    private boolean paymentReceived;
    private boolean reconciled;
    private boolean printConfirmation;
    private String cardHolder;
    private String creditCardNumber;
    private boolean processPaymentOnline;
    private String month;
    private String year;
    private String cvc;
    private boolean bypassCSC;
    private boolean bypassAVS;
    private String checkNo;
    private String idNo;
    private String bankAccountNo;
    private String routingCode;
    private String poNo;
    private String costCenter;
    private String bankAccountType;
    private String nameOnAccount;
    private String ipacNo;
    private String alcNo;
    private String tin;
    private String agencyCode;

    public FinancialData(String paymentType, String amount, String transactionDesc, String notes, String glAccount, String date, String time, boolean paymentReceived, boolean reconciled, boolean printConfirmation, String cardHolder, String creditCardNumber, boolean processPaymentOnline, String month, String year, String cvc, boolean bypassCSC, boolean bypassAVS, String checkNo, String idNo, String bankAccountNo, String routingCode, String poNo, String costCenter, String bankAccountType, String nameOnAccount, String ipacNo, String alcNo, String tin, String agencyCode) {
        this.paymentType = paymentType;
        this.amount = amount;
        this.transactionDesc = transactionDesc;
        this.notes = notes;
        this.glAccount = glAccount;
        this.date = date;
        this.time = time;
        this.paymentReceived = paymentReceived;
        this.reconciled = reconciled;
        this.printConfirmation = printConfirmation;
        this.cardHolder = cardHolder;
        this.creditCardNumber = creditCardNumber;
        this.processPaymentOnline = processPaymentOnline;
        this.month = month;
        this.year = year;
        this.cvc = cvc;
        this.bypassCSC = bypassCSC;
        this.bypassAVS = bypassAVS;
        this.checkNo = checkNo;
        this.idNo = idNo;
        this.bankAccountNo = bankAccountNo;
        this.routingCode = routingCode;
        this.poNo = poNo;
        this.costCenter = costCenter;
        this.bankAccountType = bankAccountType;
        this.nameOnAccount = nameOnAccount;
        this.ipacNo = ipacNo;
        this.alcNo = alcNo;
        this.tin = tin;
        this.agencyCode = agencyCode;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getAmount() {
        return amount;
    }

    public String getTransactionDesc() {
        return transactionDesc;
    }

    public String getNotes() {
        return notes;
    }

    public String getGlAccount() {
        return glAccount;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public boolean isPaymentReceived() {
        return paymentReceived;
    }

    public boolean isReconciled() {
        return reconciled;
    }

    public boolean isPrintConfirmation() {
        return printConfirmation;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public boolean isProcessPaymentOnline() {
        return processPaymentOnline;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getCvc() {
        return cvc;
    }

    public boolean isBypassCSC() {
        return bypassCSC;
    }

    public boolean isBypassAVS() {
        return bypassAVS;
    }

    public String getCheckNo() {
        return checkNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public String getRoutingCode() {
        return routingCode;
    }

    public String getPoNo() {
        return poNo;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public String getBankAccountType() {
        return bankAccountType;
    }

    public String getNameOnAccount() {
        return nameOnAccount;
    }

    public String getIpacNo() {
        return ipacNo;
    }

    public String getAlcNo() {
        return alcNo;
    }

    public String getTin() {
        return tin;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinancialData that = (FinancialData) o;
        return paymentReceived == that.paymentReceived &&
                reconciled == that.reconciled &&
                printConfirmation == that.printConfirmation &&
                processPaymentOnline == that.processPaymentOnline &&
                bypassCSC == that.bypassCSC &&
                bypassAVS == that.bypassAVS &&
                Objects.equals(paymentType, that.paymentType) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(transactionDesc, that.transactionDesc) &&
                Objects.equals(notes, that.notes) &&
                Objects.equals(glAccount, that.glAccount) &&
                Objects.equals(date, that.date) &&
                Objects.equals(time, that.time) &&
                Objects.equals(cardHolder, that.cardHolder) &&
                Objects.equals(creditCardNumber, that.creditCardNumber) &&
                Objects.equals(month, that.month) &&
                Objects.equals(year, that.year) &&
                Objects.equals(cvc, that.cvc) &&
                Objects.equals(checkNo, that.checkNo) &&
                Objects.equals(idNo, that.idNo) &&
                Objects.equals(bankAccountNo, that.bankAccountNo) &&
                Objects.equals(routingCode, that.routingCode) &&
                Objects.equals(poNo, that.poNo) &&
                Objects.equals(costCenter, that.costCenter) &&
                Objects.equals(bankAccountType, that.bankAccountType) &&
                Objects.equals(nameOnAccount, that.nameOnAccount) &&
                Objects.equals(ipacNo, that.ipacNo) &&
                Objects.equals(alcNo, that.alcNo) &&
                Objects.equals(tin, that.tin) &&
                Objects.equals(agencyCode, that.agencyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(paymentType, amount, transactionDesc, notes, glAccount, date, time, paymentReceived, reconciled, printConfirmation, cardHolder, creditCardNumber, processPaymentOnline, month, year, cvc, bypassCSC, bypassAVS, checkNo, idNo, bankAccountNo, routingCode, poNo, costCenter, bankAccountType, nameOnAccount, ipacNo, alcNo, tin, agencyCode);
    }

    @Override
    public String toString() {
        return "FinancialData{" +
                "paymentType='" + paymentType + '\'' +
                ", amount='" + amount + '\'' +
                ", transactionDesc='" + transactionDesc + '\'' +
                ", notes='" + notes + '\'' +
                ", glAccount='" + glAccount + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", paymentReceived=" + paymentReceived +
                ", reconciled=" + reconciled +
                ", printConfirmation=" + printConfirmation +
                ", cardHolder='" + cardHolder + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", processPaymentOnline=" + processPaymentOnline +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", cvc='" + cvc + '\'' +
                ", bypassCSC=" + bypassCSC +
                ", bypassAVS=" + bypassAVS +
                ", checkNo='" + checkNo + '\'' +
                ", idNo='" + idNo + '\'' +
                ", bankAccountNo='" + bankAccountNo + '\'' +
                ", routingCode='" + routingCode + '\'' +
                ", poNo='" + poNo + '\'' +
                ", costCenter='" + costCenter + '\'' +
                ", bankAccountType='" + bankAccountType + '\'' +
                ", nameOnAccount='" + nameOnAccount + '\'' +
                ", ipacNo='" + ipacNo + '\'' +
                ", alcNo='" + alcNo + '\'' +
                ", tin='" + tin + '\'' +
                ", agencyCode='" + agencyCode + '\'' +
                '}';
    }
}
