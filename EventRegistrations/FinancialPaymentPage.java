package pageObjects.EventRegistrations;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.FinancialData;

public class FinancialPaymentPage extends CommonActionsPage {

    @FindBy(xpath = "//span[text()='A payment cannot be applied unless the registration has a balance due.']")
    public WebElement PAYMENT_TEXT_VALIDATION;

    @FindBy(xpath = "//select[@ng-model='payment.transactionTypeCode']")
    public WebElement PAYMENT_TYPE_DROPDOWN;
    @FindBy(xpath = "//input[@ng-model='payment.amount']")
    public WebElement AMOUNT_TEXTBOX;
    @FindBy(xpath = "//input[@id='transactionDescriptionName']")
    public WebElement TRANSACTION_DESCRIPTION_TEXTBOX;
    @FindBy(xpath = "//textarea[@ng-model='payment.notes']")
    public WebElement PAYMENT_NOTES_TEXTAREA;
    @FindBy(xpath = "//input[@id='glNumberName']")
    public WebElement GLNUMBER_TEXTBOX;
    @FindBy(xpath = "//input[@name='datePosted']")
    public WebElement DATE_TEXTBOX;
    @FindBy(xpath = "//div[@class='form-group']//input[@ng-model='payment.datePosted']")
    public WebElement TIME_TEXTBOX;
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
    @FindBy(xpath = "//input[@value='newCreditCard']")
    public WebElement NEWCREDITCARD_RADIOBUTTON;

    //credit card
    @FindBy(xpath = "//input[@value='useExistingCard']")
    public WebElement EXISTINGCARD_RADIOBUTTON;
    @FindBy(xpath = "//label[text()='Cardholder']/../input")
    public WebElement CARDHOLDER_TEXTBOX;
    @FindBy(xpath = "//label[text()='Credit Card Number']/..//input")
    public WebElement CREDITCARDNUMBER_TEXTBOX;
    @FindBy(xpath = "//input[@ng-init='payment.online=true']")
    public WebElement PROCESS_PAYMENTONLINE_CHK;
    @FindBy(xpath = "//select[@ng-model='payment.expMonth']")
    public WebElement MONTH_DROPDOWN;
    @FindBy(xpath = "//select[@ng-model='payment.expYear']")
    public WebElement YEAR_DROPDOWN;
    @FindBy(xpath = "//button[text()='Swipe Credit Card']")
    public WebElement SWIPE_CREDITCARD_BUTTON;
    @FindBy(xpath = "//div[contains(@ng-show,'newCreditCard')]//input[@ng-model='payment.cvc']")
    public WebElement CVC_CVVNUMBER;
    @FindBy(xpath = "//div[contains(@ng-show,'newCreditCard')]//input[@ng-model='paymentOpt.byPassCSC']")
    public WebElement BYPASS_CSC;
    @FindBy(xpath = "//div[contains(@ng-show,'newCreditCard')]//input[@ng-model='paymentOpt.byPassAVS']")
    public WebElement BYPASS_AVS;

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
    //PO
    @FindBy(xpath = "//div[@mode='po']//input[@ng-model='payment.poNumber']")
    public WebElement PONO_TEXTBOX_PO;
    @FindBy(xpath = "//div[@mode='po']//input[@ng-model='payment.costCenter']")
    public WebElement COSTCENTER_TEXTBOX_PO;
    //Wire
    @FindBy(xpath = "//div[@mode='wire']//input[@ng-model='payment.checkNumber']")
    public WebElement CHECKNUMBER_TEXTBOX_WIRE;
    @FindBy(xpath = "//div[@mode='wire']//input[@ng-model='payment.dlNumber']")
    public WebElement IDNUMBER_TEXTBOX_WIRE;
    @FindBy(xpath = "//div[@mode='wire']//input[@ng-model='payment.bankAccountNumber']")
    public WebElement BANKACCOUTNO_TEXTBOX_WIRE;
    @FindBy(xpath = "//div[@mode='wire']//input[@ng-model='payment.routingNumber']")
    public WebElement ROUTINGCODE_TEXTBOX_WIRE;

    public static final By TIME_MERIDIAN_BUTTON = By.xpath("//button[@ng-click='toggleMeridian()']");
    @FindBy(xpath = "//a[@ng-click='incrementHours()']")
    public WebElement HOURS_UP_BUTTON;
    @FindBy(xpath = "//a[@ng-click='decrementHours()']")
    public WebElement HOURS_DOWN_BUTTON;
    @FindBy(xpath = "//a[@ng-click='incrementMinutes()']")
    public WebElement MIN_UP_BUTTON;
    @FindBy(xpath = "//a[@ng-click='decrementMinutes()']")
    public WebElement MIN_DOWN_BUTTON;
    @FindBy(xpath = "//a[@id='dLabel']")
    public WebElement TIME_CLOCK;

    @FindBy(xpath = "//div[@id='formSteps']//div[starts-with(text(),'Reconciled by')]")
    public WebElement RECONCILEDBY_LABEL;

    @FindBy(xpath = "//div[@id='formSteps']//div[contains(text(),'Last Modified Reconciled by')]")
    public WebElement LAST_MODIFIED_RECONCILEDBY_LABEL;

    @FindBy(xpath = "//div[@id='formSteps']//div[starts-with(text(),'Date/Time - Reconciled')]")
    public WebElement DATETIMERECONCILED_LABEL;

    @FindBy(xpath = "//div[@id='formSteps']//div[contains(text(),'Modified Date/Time - Reconciled')]")
    public WebElement MODIFIEDDATETIME_RECONCILED_LABEL;


    public FinancialPaymentPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
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

    public void selectDateValue(String dateValue) {
        if (dateValue != null && !dateValue.isEmpty())
            type(DATE_TEXTBOX, dateValue, true);
        logReport("Selected date value " + dateValue);
    }
    public void checkReconciledCheckbox() {
        checkByJavascript(RECONCILED_CHK);
        logReport("Reconciled checkbox checked successfully");
    }

    public void selectTimeValue(String startTime) throws Exception {
        if (startTime != null && !startTime.isEmpty()) {
            logReport("Start time from sheet is : " + startTime);
            String[] times = startTime.split(":");
            String hours = times[0];
            String minutes = times[1].substring(0, 2);
            String meridian = times[1].substring(2, times[1].length());
            Wait(TIME_CLOCK, 10);
            clickByJavaScript(TIME_CLOCK);
            int hoursVal = Integer.parseInt(hours);
            int min = Integer.parseInt(minutes);
            logReport("Start time meridian from sheet is : " + meridian);
            //String meridian_value = "PM";
            if (hoursVal < 12) {
                int hr = 12 - hoursVal;
                for (int i = 0; i < hr; i++) {
                    click(HOURS_DOWN_BUTTON);
                }
            } else {
                //int hr = 12 - hoursVal;
                int hr = 12 + hoursVal;
                for (int i = 0; i < hr; i++) {
                    click(HOURS_UP_BUTTON);
                }
            }
            Thread.sleep(1000);
            if (min > 0) {
                for (int i = 0; i < min / 15; i++) {
                    click(MIN_UP_BUTTON);
                }
            }
            Thread.sleep(1000);
            WebElement element = browser.findElement(TIME_MERIDIAN_BUTTON);
            if (!element.getText().equalsIgnoreCase(meridian.trim())) {
                element.click();
            }
            clickByJavaScript(TIME_CLOCK);
            logReport("Entered Value: " + startTime + " in 'Start Time' TextBox");
        }

    }

    public void clickSubmitButton() throws Exception {
        click(SUBMIT_BUTTON);
        logReport("Submit button clicked successfully");
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(30);
    }

    public void clickSubmitButtonWithoutAngular() throws Exception {
        click(SUBMIT_BUTTON);
        logReport("Submit button clicked successfully");

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

    public void checkUncheckElementsByValue(WebElement element, boolean value) {
        if (verifyElementDisplayed(element, 2)) {
            if (value)
                checkByJavascript(element);
            else
                uncheckByJavascript(element);
        }
    }

    public void fillCreditCardDetails(FinancialData financialData) throws Exception {
        Wait(CARDHOLDER_TEXTBOX, 10);
        type(CARDHOLDER_TEXTBOX, financialData.getCardHolder(), true);
        type(CREDITCARDNUMBER_TEXTBOX, financialData.getCreditCardNumber(), true);
        checkUncheckElementsByValue(PROCESS_PAYMENTONLINE_CHK, financialData.isProcessPaymentOnline());
        select(MONTH_DROPDOWN, financialData.getMonth());
        select(YEAR_DROPDOWN, financialData.getYear());
        type(CVC_CVVNUMBER, financialData.getCvc(), true);
        checkUncheckElementsByValue(BYPASS_CSC, financialData.isBypassCSC());
        checkUncheckElementsByValue(BYPASS_AVS, financialData.isBypassAVS());

    }

    public void fillCreditCardDetailsTouchNet(FinancialData financialData) throws Exception {
        Wait(CARDHOLDER_TEXTBOX, 10);
        type(CARDHOLDER_TEXTBOX, financialData.getCardHolder(), true);
        type(CREDITCARDNUMBER_TEXTBOX, financialData.getCreditCardNumber(), true);
        checkUncheckElementsByValue(PROCESS_PAYMENTONLINE_CHK, financialData.isProcessPaymentOnline());
        select(MONTH_DROPDOWN, financialData.getMonth());
        select(YEAR_DROPDOWN, financialData.getYear());
        // type(CVC_CVVNUMBER, financialData.getCvc(), true);
        checkUncheckElementsByValue(BYPASS_CSC, financialData.isBypassCSC());
        checkUncheckElementsByValue(BYPASS_AVS, financialData.isBypassAVS());

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

    public void fillPaymentDetails(FinancialData financialData, String paymentType) throws Exception {
        selectPaymentTypeDropdown(financialData.getPaymentType());
        enterTransactionDescription(financialData.getTransactionDesc());
        enterAmountTextbox(financialData.getAmount());
        enterNotes(financialData.getNotes());
        enterGlNumber(financialData.getGlAccount());
        selectDateValue(financialData.getDate());
        selectTimeValue(financialData.getTime());
        checkUncheckElementsByValue(PRINT_CONFIRMATION_CHK, financialData.isPrintConfirmation());
        checkUncheckElementsByValue(PAYMENT_RECEIVED_CHK, financialData.isPaymentReceived());
        checkUncheckElementsByValue(RECONCILED_CHK, financialData.isReconciled());
        if (paymentType.equalsIgnoreCase("Credit Card")) {
            fillCreditCardDetails(financialData);
        } else if (paymentType.equalsIgnoreCase("Check")) {
            fillCheckDetails(financialData);
        } else if (paymentType.equalsIgnoreCase("ACH")) {
            fillACHDetails(financialData);
        } else if (paymentType.equalsIgnoreCase("IPAC")) {
            fillIPACDetails(financialData);
        } else if (paymentType.equalsIgnoreCase("PO")) {
            type(PONO_TEXTBOX_PO, financialData.getPoNo(), true);
            type(COSTCENTER_TEXTBOX_PO, financialData.getCostCenter(), true);
        } else if (paymentType.equalsIgnoreCase("Wire")) {
            fillWireDetails(financialData);
        }
    }

    public void fillPaymentDetailsForCreditCard(FinancialData financialData, String paymentType) throws Exception {
        selectPaymentTypeDropdown(financialData.getPaymentType());
        enterTransactionDescription(financialData.getTransactionDesc());
        enterAmountTextbox(financialData.getAmount());
        enterNotes(financialData.getNotes());
        enterGlNumber(financialData.getGlAccount());
        selectDateValue(financialData.getDate());
        selectTimeValue(financialData.getTime());
        checkUncheckElementsByValue(PRINT_CONFIRMATION_CHK, financialData.isPrintConfirmation());
        checkUncheckElementsByValue(PAYMENT_RECEIVED_CHK, financialData.isPaymentReceived());
        checkUncheckElementsByValue(RECONCILED_CHK, financialData.isReconciled());
        Wait(CARDHOLDER_TEXTBOX, 10);
        type(CARDHOLDER_TEXTBOX, financialData.getCardHolder(), true);
        type(CREDITCARDNUMBER_TEXTBOX, financialData.getCreditCardNumber(), true);
        checkUncheckElementsByValue(PROCESS_PAYMENTONLINE_CHK, financialData.isProcessPaymentOnline());
        select(MONTH_DROPDOWN, financialData.getMonth());
        select(YEAR_DROPDOWN, financialData.getYear());

    }
    public void fillPaymentDetailsTouchNet(FinancialData financialData, String paymentType) throws Exception {
        selectPaymentTypeDropdown(financialData.getPaymentType());
        enterTransactionDescription(financialData.getTransactionDesc());
        enterAmountTextbox(financialData.getAmount());
        enterNotes(financialData.getNotes());
        enterGlNumber(financialData.getGlAccount());
        selectDateValue(financialData.getDate());
        selectTimeValue(financialData.getTime());
        checkUncheckElementsByValue(PRINT_CONFIRMATION_CHK, financialData.isPrintConfirmation());
        checkUncheckElementsByValue(PAYMENT_RECEIVED_CHK, financialData.isPaymentReceived());
        checkUncheckElementsByValue(RECONCILED_CHK, financialData.isReconciled());
        if (paymentType.equalsIgnoreCase("Credit Card")) {
            fillCreditCardDetailsTouchNet(financialData);
        } else if (paymentType.equalsIgnoreCase("Check")) {
            fillCheckDetails(financialData);
        } else if (paymentType.equalsIgnoreCase("ACH")) {
            fillACHDetails(financialData);
        } else if (paymentType.equalsIgnoreCase("IPAC")) {
            fillIPACDetails(financialData);
        } else if (paymentType.equalsIgnoreCase("PO")) {
            type(PONO_TEXTBOX_PO, financialData.getPoNo(), true);
            type(COSTCENTER_TEXTBOX_PO, financialData.getCostCenter(), true);
        } else if (paymentType.equalsIgnoreCase("Wire")) {
            fillWireDetails(financialData);
        }
    }

    public boolean isDateTimeReconciledFound() {
        try {
            String text = DATETIMERECONCILED_LABEL.getText().trim();
            return StringUtils.isNotBlank(text);
        } catch (Exception e) {

        }
        return false;
    }

    public boolean isModifiedDateTimeReconciledFound() {
        try {
            String text = MODIFIEDDATETIME_RECONCILED_LABEL.getText().trim();
            return StringUtils.isNotBlank(text);
        } catch (Exception e) {

        }
        return false;
    }

    public boolean isReconciledByFound() {
        String text = RECONCILEDBY_LABEL.getText().trim();
        return StringUtils.isNotBlank(text);
    }

    public boolean isModifiedReconciledByFound() {
        String text = LAST_MODIFIED_RECONCILEDBY_LABEL.getText().trim();
        return StringUtils.isNotBlank(text);
    }

}
