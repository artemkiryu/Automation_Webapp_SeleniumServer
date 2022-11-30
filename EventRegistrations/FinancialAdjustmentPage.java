package pageObjects.EventRegistrations;

import excelFunctions.ExcelDataPool;
import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.FinancialData;

public class FinancialAdjustmentPage extends CommonActionsPage {
    @FindBy(xpath = "//input[@id='amountName']")
    public WebElement AMOUNT_TEXTBOX;
    @FindBy(xpath = "//input[@id='transactionDescriptionName']")
    public WebElement TRANSACTION_DESCRIPTION_TEXTBOX;
    @FindBy(xpath = "//input[@id='glNumberName']")
    public WebElement GLNUMBER_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='payment.reconciled']")
    public WebElement RECONCILED_CHK;
    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement SUBMIT_BUTTON;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement CANCEL_BUTTON;

    @FindBy(xpath = "//span[contains(text(),'Debit')]/..")
    public WebElement DEBIT_TOOLTIP;

    @FindBy(xpath = "//span[contains(text(),'Credit')]/..")
    public WebElement CREDIT_TOOLTIP;

    @FindBy(xpath = "//textarea[@ng-model='payment.notes']")
    public WebElement PAYMENT_NOTES_TEXTAREA;

    public FinancialAdjustmentPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
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

    public void enterNotes(String notes) {
        type(PAYMENT_NOTES_TEXTAREA, notes, true);
        logReport("Entered notes value " + notes);
    }

    public void clickSubmitButtonWithoutAngular() throws Exception {
        click(SUBMIT_BUTTON);
        logReport("Submit button clicked successfully");
        VerifyPageReady(30);

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

    public String getDebitTooltip() {
        return DEBIT_TOOLTIP.getAttribute("tooltip").trim();
    }

    public String getCreditTooltip() {
        return CREDIT_TOOLTIP.getAttribute("tooltip").trim();
    }

    public void checkUncheckElementsByValue(WebElement element, boolean value) {
        if (verifyElementDisplayed(element, 2)) {
            if (value)
                checkByJavascript(element);
            else
                uncheckByJavascript(element);
        }
    }

    public void selectCreditDebitRadioButton(String value) {
        String xpath = "//span[contains(text(),'" + value + "')]/../input";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        logReport("Selected credit debit radiobutton value " + value);
    }

    public void fillAdjustmentDetails(FinancialData financialData, String value) {
        enterTransactionDescription(financialData.getTransactionDesc());
        enterAmountTextbox(financialData.getAmount());
        enterGlNumber(financialData.getGlAccount());
        checkUncheckElementsByValue(RECONCILED_CHK, financialData.isReconciled());
        selectCreditDebitRadioButton(value);
        if (value.equalsIgnoreCase("Credit")) {
            enterNotes(financialData.getNotes());
        }

    }

    public boolean isRadioButtonSelected(String value) {
        String xpath = "//span[contains(text(),'" + value + "')]/../input";
        WebElement element = browser.findElement(By.xpath(xpath));
        return element.isSelected();
    }
}
