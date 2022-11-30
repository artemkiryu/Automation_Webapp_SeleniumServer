package pageObjects.EventRegistrations;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageObjects.CommonActionsPage;
import pageObjects.Forms.VerifyPage;
import pojo.FinancialData;

import java.util.List;

public class FinancialRefundPage extends CommonActionsPage {
    @FindBy(xpath = "//select[@ng-model='payment.transactionTypeCode']")
    public WebElement PAYMENT_TYPE_DROPDOWN;
    @FindBy(xpath = "//input[@ng-model='payment.amount']")
    public WebElement AMOUNT_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='payment.transactionDescription']")
    public WebElement TRANSACTION_DESCRIPTION_TEXTBOX;
    @FindBy(xpath = "//textarea[@ng-model='payment.notes']")
    public WebElement PAYMENT_NOTES_TEXTAREA;
    @FindBy(xpath = "//input[@ng-model='payment.glNumber']")
    public WebElement GLNUMBER_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='payment.print']")
    public WebElement PRINT_CONFIRMATION_CHK;
    @FindBy(xpath = "//input[@ng-model='payment.received']")
    public WebElement PAYMENT_RECEIVED_CHK;
    @FindBy(xpath = "//input[@ng-model='payment.reconciled']")
    public WebElement RECONCILED_CHK;
    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement SUBMIT_BUTTON;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement CANCEL_BUTTON;
    //Credit Card
    //Check
    @FindBy(xpath = "//div[@mode='check']//input[@ng-model='payment.checkNumber']")
    public WebElement CHECKNUMBER_TEXTBOX;
    @FindBy(xpath = "//div[@mode='check']//input[@ng-model='payment.dlNumber']")
    public WebElement IDNUMBER_TEXTBOX;
    @FindBy(xpath = "//div[@mode='check']//input[@ng-model='payment.bankAccountNumber']")
    public WebElement BANKACCOUTNO_TEXTBOX;
    @FindBy(xpath = "//div[@mode='check']//input[@ng-model='payment.routingNumber']")
    public WebElement ROUTINGCODE_TEXTBOX;
    @FindBy(xpath = "//div[@mode='check']//input[@ng-model='payment.poNumber']")
    public WebElement PONO_TEXTBOX;
    @FindBy(xpath = "//div[@mode='check']//input[@ng-model='payment.costCenter']")
    public WebElement COSTCENTER_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='payment.online']")
    public WebElement PROCESS_PAYMENTONLINE_CHK;

    //IPAC
    @FindBy(xpath = "//div[@mode='ipac']//input[@ng-model='payment.checkNumber']")
    public WebElement CHECKNUMBER_TEXTBOX_IPAC;
    @FindBy(xpath = "//div[@mode='ipac']//input[@ng-model='payment.dlNumber']")
    public WebElement IDNUMBER_TEXTBOX_IPAC;
    @FindBy(xpath = "//div[@mode='ipac']//input[@ng-model='payment.iPacNumber']")
    public WebElement IPACNUMBER_TEXTBOX;
    @FindBy(xpath = "//div[@mode='ipac']//input[@ng-model='payment.iPacAlcNumber']")
    public WebElement ALCNUMBER_TEXTBOX;
    @FindBy(xpath = "//div[@mode='ipac']//input[@ng-model='payment.tin']")
    public WebElement TINNUMBER_TEXTBOX;
    @FindBy(xpath = "//div[@mode='ipac']//input[@ng-model='payment.agencyCode']")
    public WebElement AGENCYNUMBER_TEXTBOX;
    //Wire
    @FindBy(xpath = "//div[@mode='wire']//input[@ng-model='payment.checkNumber']")
    public WebElement CHECKNUMBER_TEXTBOX_WIRE;
    @FindBy(xpath = "//div[@mode='wire']//input[@ng-model='payment.dlNumber']")
    public WebElement IDNUMBER_TEXTBOX_WIRE;
    @FindBy(xpath = "//div[@mode='wire']//input[@ng-model='payment.bankAccountNumber']")
    public WebElement BANKACCOUTNO_TEXTBOX_WIRE;
    @FindBy(xpath = "//div[@mode='wire']//input[@ng-model='payment.routingNumber']")
    public WebElement ROUTINGCODE_TEXTBOX_WIRE;

    @FindBy(xpath = "//span[@class='ng-binding']")
    public WebElement DISCOUNT_LABEL;

    @FindBy(xpath = "//input[@ng-model='payment.ccHolder']")
    public WebElement NAMEONACCOUNT_TEXTBOX;

    //ACH
    @FindBy(xpath = "//div[@mode='ach']//input[@ng-model='payment.routingNumber']")
    public WebElement ROUTINGCODE_TEXTBOX_ACH;
    @FindBy(xpath = "//div[@mode='ach']//input[@ng-model='payment.checkNumber']")
    public WebElement CHECKNUMBER_TEXTBOX_ACH;
    @FindBy(xpath = "//div[@mode='ach']//input[@ng-model='payment.bankAccountNumber']")
    public WebElement BANKACCOUTNO_TEXTBOX_ACH;
    @FindBy(xpath = "//select[@ng-model='payment.bankAccountType']")
    public WebElement BANKACCOUTTYPE_DROPDOWN;
    @FindBy(xpath = "//input[@ng-model='payment.online']")
    public WebElement PROCESS_PAYMENTONLINE_CHK_ACH;

    @FindBy(xpath = "//select[@ng-model='payment.card']")
    public WebElement CREDITCARD_FILE_DROPDOWN;

    public FinancialRefundPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public boolean isDiscountText(String text) {
        String actualText = DISCOUNT_LABEL.getText().trim();
        return actualText.equalsIgnoreCase(text);
    }

    public void selectPaymentTypeDropdown(String paymentType) throws Exception {
        Wait(PAYMENT_TYPE_DROPDOWN, 20);
        select(PAYMENT_TYPE_DROPDOWN, paymentType);
        logReport("Selected payment type dropdown value ");
    }

    public void enterAmountTextbox(String amountNo) {
        type(AMOUNT_TEXTBOX, amountNo, true);
        logReport("Entered amount no " + amountNo);
    }

    public void enterTransactionDescription(String name) {
        type(TRANSACTION_DESCRIPTION_TEXTBOX, name, true);
        logReport("Entered transaction description name " + name);
    }

    public void enterGlNumber(String glnumber) {
        type(GLNUMBER_TEXTBOX, glnumber, true);
        logReport("Entered General ledger number " + glnumber);
    }

    public void checkReconciledCheckbox() {
        checkByJavascript(RECONCILED_CHK);
        logReport("Reconciled checkbox checked successfully");
    }

    public void clickSubmitButton() throws Exception {
        click(SUBMIT_BUTTON);
        logReport("Submit button clicked successfully");
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(30);
    }

    public void clickCancelButton() throws Exception {
        click(CANCEL_BUTTON);
        logReport("Cancel button clicked successfully");
        VerifyPageReady(30);
    }

    public void enterNotes(String notes) {
        type(PAYMENT_NOTES_TEXTAREA, notes, true);
        logReport("Entered notes value " + notes);
    }

    public void checkUncheckElementsByValue(WebElement element, boolean value) throws Exception {
        if (verifyElementDisplayed(element, 2)) {
            if (value) {
                checkByJavascript(element);
                logReport("Checkbox checked successfully");
            } else {
                uncheckByJavascript(element);
                logReport("Checkbox unchecked successfully");
            }
        }
        VerifyPageReady(30);
    }

    public void fillCheckDetails(FinancialData financialData) throws Exception {
        Wait(CHECKNUMBER_TEXTBOX, 20);
        type(CHECKNUMBER_TEXTBOX, financialData.getCheckNo(), true);
        type(IDNUMBER_TEXTBOX, financialData.getIdNo(), true);
        type(BANKACCOUTNO_TEXTBOX, financialData.getBankAccountNo(), true);
        type(ROUTINGCODE_TEXTBOX, financialData.getRoutingCode(), true);
        type(PONO_TEXTBOX, financialData.getPoNo(), true);
        type(COSTCENTER_TEXTBOX, financialData.getCostCenter(), true);
    }

    public void fillACHDetails(FinancialData financialData) throws Exception {
        Wait(NAMEONACCOUNT_TEXTBOX, 20);
        type(NAMEONACCOUNT_TEXTBOX, financialData.getNameOnAccount(), true);
        type(CHECKNUMBER_TEXTBOX_ACH, financialData.getCheckNo(), true);
        type(BANKACCOUTNO_TEXTBOX_ACH, financialData.getBankAccountNo(), true);
        type(ROUTINGCODE_TEXTBOX_ACH, financialData.getRoutingCode(), true);
        select(BANKACCOUTTYPE_DROPDOWN, financialData.getBankAccountType());
        checkUncheckElementsByValue(PROCESS_PAYMENTONLINE_CHK_ACH, financialData.isProcessPaymentOnline());
    }

    public void fillIPACDetails(FinancialData financialData) throws Exception {
        Wait(CHECKNUMBER_TEXTBOX_IPAC, 20);
        type(CHECKNUMBER_TEXTBOX_IPAC, financialData.getCheckNo(), true);
        type(IDNUMBER_TEXTBOX_IPAC, financialData.getIdNo(), true);
        type(IPACNUMBER_TEXTBOX, financialData.getIpacNo(), true);
        type(ALCNUMBER_TEXTBOX, financialData.getAlcNo(), true);
        type(TINNUMBER_TEXTBOX, financialData.getTin(), true);
        type(AGENCYNUMBER_TEXTBOX, financialData.getAgencyCode(), true);
    }

    public void fillWireDetails(FinancialData financialData) throws Exception {
        Wait(CHECKNUMBER_TEXTBOX_WIRE, 20);
        type(CHECKNUMBER_TEXTBOX_WIRE, financialData.getCheckNo(), true);
        type(IDNUMBER_TEXTBOX_WIRE, financialData.getIdNo(), true);
        type(BANKACCOUTNO_TEXTBOX_WIRE, financialData.getBankAccountNo(), true);
        type(ROUTINGCODE_TEXTBOX_WIRE, financialData.getRoutingCode(), true);
    }

    public void fillRefundDetails(FinancialData financialData, String paymentType, String cardNo) throws Exception {
        selectPaymentTypeDropdown(financialData.getPaymentType());
        enterTransactionDescription(financialData.getTransactionDesc());
        enterAmountTextbox(financialData.getAmount());
        enterNotes(financialData.getNotes());
        enterGlNumber(financialData.getGlAccount());
        checkUncheckElementsByValue(PRINT_CONFIRMATION_CHK, financialData.isPrintConfirmation());
        checkUncheckElementsByValue(PAYMENT_RECEIVED_CHK, financialData.isPaymentReceived());
        checkUncheckElementsByValue(RECONCILED_CHK, financialData.isReconciled());
        if (paymentType.equalsIgnoreCase("Credit Card")) {
            selectCreditCardOnFile(cardNo);
            checkUncheckElementsByValue(PROCESS_PAYMENTONLINE_CHK, financialData.isProcessPaymentOnline());
        } else if (paymentType.equalsIgnoreCase("Check")) {
            fillCheckDetails(financialData);
        } else if (paymentType.equalsIgnoreCase("ACH")) {
            fillACHDetails(financialData);
        } else if (paymentType.equalsIgnoreCase("IPAC")) {
            fillIPACDetails(financialData);
        } else if (paymentType.equalsIgnoreCase("Wire")) {
            fillWireDetails(financialData);
        }
    }

    public void selectCreditCardOnFile(String cardNo) {
        Select select = new Select(CREDITCARD_FILE_DROPDOWN);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement e : allOptions) {
            if (e.getText().trim().contains(cardNo)) {
                e.click();
                return;
            }
        }
    }

}
