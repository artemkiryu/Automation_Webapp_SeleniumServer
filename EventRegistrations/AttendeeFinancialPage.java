package pageObjects.EventRegistrations;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageObjects.CommonActionsPage;
import pageObjects.Forms.VerifyPage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class AttendeeFinancialPage extends CommonActionsPage {
    @FindBy(xpath = "//div[@id='payment_actions']//button[text()='Payment']")
    public WebElement PAYMENT_BUTTON;
    @FindBy(xpath = "//div[@id='payment_actions']//button[text()='Refund']")
    public WebElement REFUND_BUTTON;
    @FindBy(xpath = "//div[@id='payment_actions']//button[text()='Discount']")
    public WebElement DISCOUNT_BUTTON;
    @FindBy(xpath = "//div[@id='payment_actions']//button[text()='Adjustment']")
    public WebElement ADJUSTMENT_BUTTON;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Attendee profile and registration information.']")
    public WebElement PROFILE_TAB;
    @FindBy(xpath = "//span[text()='Balance']/..//following-sibling::div[1]")
    public WebElement BALANCE_DUE_AMOUNT;

    @FindBy(xpath = "//input[@ng-model='purchase.quantity']")
    public WebElement FEE_QUANTITY;

    public static final String[] PURCHASE_COLUMN_LIST = {"Purchases & Other Fees", "Qty", "Item Cost", "Line Total"};

    public static final String[] DISCOUNT_COLUMN_LIST = {"Discounts, Refunds, & Adjustments", "Amount", "Line Total"};

    public static final String[] PAYMENT_COLUMN_LIST = {"Payments", "Received", "Reporting"};

    public static final String[] TRANSACTION_COLUMN_LIST = {"Transaction Type", "Date", "Transaction Description", "Qty", "Debit", "Credit"};

    @FindBy(xpath = "//div[text()='Transaction History']//following-sibling::div//th")
    public List<WebElement> TRANSACTION_COLUMN_HISTORY;

    @FindBy(xpath = "//tr[@ng-repeat='transaction in transactions']//td[1]")
    public List<WebElement> TRANSACTION_TYPE_LIST;

    @FindBy(xpath = "//select[@ng-model='transactionTypeCode']")
    public WebElement SHOWME_TRANSACTION_DROPDOWN;

    @FindBy(xpath = "//tr[@ng-repeat='transaction in transactions']")
    public List<WebElement> TRANSACTION_ROW_LIST;

    @FindBy(xpath = "//div[@ng-repeat[contains(.,'purchase in purchases')]]")
    public List<WebElement> PURCHASES_ROW_LIST;


    public static final String[] TRANSACTION_TYPE_OPTIONS = {"All Transactions", "Check", "Credit Card", "Cash", "Wire", "Transfer In", "Transfer Out", "Refund", "Adjust Charge", "Fee", "Optional Fees", "Discount", "Tax", "Adjust Payment", "IPAC", "Shipping and Handling", "Percentage Fees", "ACH"};
    public static final String[] TRANSACTION_MONTH_OPTIONS = {"All", "30 days", "60 days", "90 days"};
    public static final String[] INVOICE_COLUMN_NAMES = {"Date", "Invoice Template", "Mark for Reporting", "Invoice Number", "Amount"};
    @FindBy(xpath = "//div[text()='Transaction History']//a[@ng-click='togglePanel()']")
    public WebElement EXCEL_ICON_TRANSACTION;
    @FindBy(xpath = "//select[@ng-model='transactionMonth']")
    public WebElement TRANSACTION_MONTH_DROPDOWN;
    @FindBy(xpath = "//input[@ng-model='transactionDesc']")
    public WebElement DESCRIPTION_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='amount']")
    public WebElement AMOUNT_TEXTBOX;
    @FindBy(xpath = "//input[@value='Generate New Invoice']")
    public WebElement GENERATE_NEW_INVOICE;
    @FindBy(xpath = "//select[@ng-model='registrationInvoice.invoiceId']")
    public WebElement INVOICE_TEMPLATE_DROPDOWN;
    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement SUBMIT_BUTTON;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement CANCEL_BUTTON;
    @FindBy(xpath = "//div[@header='Invoices']//th[@class='row tablesorter-header ng-binding']")
    public List<WebElement> INVOICE_COLUMN_LIST;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Overview']")
    public WebElement OVERVIEW_TAB;

    @FindBy(xpath = "//h1//small[1]")
    public WebElement REGISTRATION_CODE;


    public AttendeeFinancialPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public static List<String> convertToUpperCase(List<String> inList) {
        return inList.stream().map(String::toUpperCase).collect(toList());
    }

    public AttendeeOverviewPage clickAttendeeOverviewPage() throws Exception {
        VerifyPageReady(30);
        Wait(OVERVIEW_TAB, 30);
        click(OVERVIEW_TAB);
        logReport("Successfully clicked on 'Overview' tab.");
        VerifyAjaxRequestsFinished(30);
        //VerifyAngularHasFinishedProcessing(30);
        return new AttendeeOverviewPage(browser);
    }

    public FinancialRefundPage clickRefundButton() throws Exception {
        Wait(REFUND_BUTTON, 30);
        click(REFUND_BUTTON);
        logReport("Refund button clicked successfully");
        VerifyPageReady(30);
        return new FinancialRefundPage(browser);
    }

    public FinancialDiscountPage clickDiscountButton() throws Exception {
        Wait(DISCOUNT_BUTTON, 30);
        clickByJavaScript(DISCOUNT_BUTTON);
        logReport("Discount button clicked successfully");
        VerifyAngularHasFinishedProcessing(30);
        return new FinancialDiscountPage(browser);
    }

    public FinancialPaymentPage clickPaymentButton() throws Exception {
        Wait(PAYMENT_BUTTON, 30);
        clickByJavaScript(PAYMENT_BUTTON);
        logReport("Payment button clicked successfully");
        VerifyPageReady(30);
        return new FinancialPaymentPage(browser);
    }

    public AttendeeProfilePage clickProfileTab() throws Exception {
        Wait(PROFILE_TAB, 20);
        clickByJavaScript(PROFILE_TAB);
        logReport("Profile tab clicked successfully");
        VerifyPageReady(30);
        return new AttendeeProfilePage(browser);
    }

    public FinancialAdjustmentPage clickAdjustmentButton() throws Exception {
        Wait(ADJUSTMENT_BUTTON, 30);
        clickByJavaScript(ADJUSTMENT_BUTTON);
        logReport("Adjustment button clicked successfully");
        VerifyPageReady(30);
        return new FinancialAdjustmentPage(browser);
    }

    public boolean isBalanceDueAmountNegative() {
        String balance = BALANCE_DUE_AMOUNT.getText().trim();
        if (balance.contains("(") && balance.contains(")"))
            return true;
        return false;
    }

    public float getBalanceDueAmountLabel(String currency) {
        String balance = BALANCE_DUE_AMOUNT.getText().trim();
        float f = 0;
        if (balance.contains("(")) {
            balance = balance.substring(balance.indexOf("(") + 1, balance.indexOf(")") - 1);
            f = -Float.parseFloat(balance);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("\\");
            stringBuffer.append(currency);

            balance = balance.split(stringBuffer.toString())[1].trim();
            f = Float.parseFloat(balance);
        }
        logReport("--Value of get balance amount due is " + f);
        return f;
    }

    public boolean isSectionFoundWithColumns(List<String> actualColumns, String sectionName) {
        String xpath = "//div[contains(@class,'payment_table')]//div[contains(text(),'" + sectionName + "')]/../..//div[@class='row table-header']//div[contains(@class,'text-uppercase ng-binding')]";
        List<WebElement> columnsList = browser.findElements(By.xpath(xpath));
        List<String> expectedColumns = new ArrayList<>();
        for (WebElement e : columnsList) {
            expectedColumns.add(e.getText().trim());
        }
        List<String> actualColumnsNew = convertToUpperCase(actualColumns);
        logReport("Actual columns list " + actualColumnsNew + "not matched with expected columns " + expectedColumns);
        //List<String> actualColumnsNew = convertToUpperCase(actualColumns);
        return expectedColumns.containsAll(convertToUpperCase(actualColumns));
        // return actualColumns.stream().map(String::toUpperCase()).collect(toList()).equals(expectedColumns);
    }


    public List<String> getTransactionHistoryColumns() {
        List<String> columnsList = new ArrayList<>();
        for (WebElement e : TRANSACTION_COLUMN_HISTORY) {
            columnsList.add(e.getText().trim());
        }
        return columnsList;
    }

    public void selectShowMeTransactionDropdown(String value) {
        select(SHOWME_TRANSACTION_DROPDOWN, value);
        logReport("Selected show me transaction type dropdown value " + value);
        VerifyAngularHasFinishedProcessing(30);
    }

    public boolean isSearchedTransactionTypeFound(String value) {
        boolean found = false;
        for (WebElement e : TRANSACTION_TYPE_LIST) {
            found = false;
            if (e.getText().trim().equalsIgnoreCase(value)) {
                found = true;
            }
        }
        return found;
    }

    public boolean isTransactionHistoryFound(List<String> actualItems) {
        List<String> transactionList = new ArrayList<>();
        for (int i = 1; i <= TRANSACTION_ROW_LIST.size(); i++) {
            String transactionType = browser.findElement(By.xpath("//tr[@ng-repeat='transaction in transactions'][" + i + "]//td[1]")).getText().trim();
            String date = browser.findElement(By.xpath("//tr[@ng-repeat='transaction in transactions'][" + i + "]//td[2]")).getText().trim();
            String transactionDesc = browser.findElement(By.xpath("//tr[@ng-repeat='transaction in transactions'][" + i + "]//td[3]")).getText().trim();
            String quantity = browser.findElement(By.xpath("//tr[@ng-repeat='transaction in transactions'][" + i + "]//td[4]")).getText().trim();
            String debit = browser.findElement(By.xpath("//tr[@ng-repeat='transaction in transactions'][" + i + "]//td[5]")).getText().trim();
            String credit = browser.findElement(By.xpath("//tr[@ng-repeat='transaction in transactions'][" + i + "]//td[6]")).getText().trim();
            String val = "";
            String debitVal = "";
            if (credit != null && !credit.isEmpty()) {
                val = String.valueOf(Float.parseFloat(credit));
            }
            if (debit != null && !debit.isEmpty()) {
                debitVal = String.valueOf(Float.parseFloat(debit));
            }
            transactionList.add(transactionType);
            transactionList.add(transactionDesc);
            transactionList.add(quantity);
            transactionList.add(debitVal);
            transactionList.add(val);
            logReport("Actual transaction list " + transactionList);
            logReport("Expected actual items list " + actualItems);
            if (transactionList.containsAll(actualItems)) {
                logReport("Actual transaction list " + transactionList + "matched with expected transaction list " + actualItems);
                return true;
            }
            transactionList.clear();
        }
        return false;

    }

    public boolean isTransactionHistoryFoundForAll(List<String> actualItems) {
        List<String> transactionList = new ArrayList<>();
        for (int i = 1; i <= TRANSACTION_ROW_LIST.size(); i++) {
            String transactionType = browser.findElement(By.xpath("//tr[@ng-repeat='transaction in transactions'][" + i + "]//td[1]")).getText().trim();
            String date = browser.findElement(By.xpath("//tr[@ng-repeat='transaction in transactions'][" + i + "]//td[2]")).getText().trim();
            String transactionDesc = browser.findElement(By.xpath("//tr[@ng-repeat='transaction in transactions'][" + i + "]//td[3]")).getText().trim();
            String quantity = browser.findElement(By.xpath("//tr[@ng-repeat='transaction in transactions'][" + i + "]//td[4]")).getText().trim();
            String debit = browser.findElement(By.xpath("//tr[@ng-repeat='transaction in transactions'][" + i + "]//td[5]")).getText().trim();
            String credit = browser.findElement(By.xpath("//tr[@ng-repeat='transaction in transactions'][" + i + "]//td[6]")).getText().trim();
            String val = "";
            String debitVal = "";
            if (credit != null && !credit.isEmpty()) {
                val = String.valueOf(Float.parseFloat(credit));
            }
            if (debit != null && !debit.isEmpty()) {
                debitVal = String.valueOf(Float.parseFloat(debit));
            }
            transactionList.add(transactionType);
            transactionList.add(date);
            transactionList.add(transactionDesc);
            transactionList.add(quantity);
            transactionList.add(debitVal);
            transactionList.add(val);
            logReport("Actual transaction list " + transactionList);
            logReport("Expected actual items list " + actualItems);
            if (transactionList.equals(actualItems)) {
                logReport("Actual transaction list " + transactionList + "matched with expected transaction list " + actualItems);
                return true;
            }
            transactionList.clear();
        }
        return false;
    }

    public boolean isCurrencyFound(String currency) {
        String text = BALANCE_DUE_AMOUNT.getText().trim();
        return text.contains(currency);
    }

    public void exportExcelIconTransactionHistory() throws Exception {
        Wait(EXCEL_ICON_TRANSACTION, 20);
        clickByJavaScript(EXCEL_ICON_TRANSACTION);
        logReport("Export to excel icon for transaction history");
        VerifyPageReady(30);
    }

    public List<String> getTransactionTypeOptionsList() {
        List<String> typesList = new ArrayList<>();
        Select selectList = new Select(SHOWME_TRANSACTION_DROPDOWN);
        List<WebElement> options = selectList.getOptions();
        for (WebElement e : options) {
            typesList.add(e.getText().trim());
        }
        return typesList;
    }

    public List<String> getTransactionMonthOptions() {
        List<String> typesList = new ArrayList<>();
        Select selectList = new Select(TRANSACTION_MONTH_DROPDOWN);
        List<WebElement> options = selectList.getOptions();
        for (WebElement e : options) {
            typesList.add(e.getText().trim());
        }
        return typesList;
    }

    public void clickGenerateNewInvoice() {
        clickByJavaScript(GENERATE_NEW_INVOICE);
        logReport("Generate new invoice clicked successfully");
        VerifyAngularHasFinishedProcessing(30);
    }

    public void selectInvoiceTemplate(String temp) {
        select(INVOICE_TEMPLATE_DROPDOWN, temp);
        logReport("selected generate invoice template dropdown " + temp);
    }

    public void clickSubmitButton() throws Exception {
        Wait(SUBMIT_BUTTON, 10);
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

    public void clickDownloadInvoiceByTemplateName(String templateName) {
        String xpath = "//tr[@ng-repeat='invoice in invoices']//td[2][text()='" + templateName + "']//following-sibling::td//i[@tooltip='Download Invoice']";
        clickByJavaScript(browser.findElement(By.xpath(xpath)));
        logReport("Download invoice clicked successfully by template name " + templateName);
    }

    public void clickViewInvoiceByTemplateName(String templateName) {
        String xpath = "//tr[@ng-repeat='invoice in invoices']//td[2][text()='" + templateName + "']//following-sibling::td//i[@tooltip='View Invoice']";
        clickByJavaScript(browser.findElement(By.xpath(xpath)));
        logReport("View invoice clicked successfully by template name " + templateName);
    }

    public boolean isInvoiceTemplateGenerated(String templateName) {
        String xpath = "//tr[@ng-repeat='invoice in invoices']//td[2][text()='" + templateName + "']";
        return verifyElementDisplayed(By.xpath(xpath), 2);
    }

    public boolean isFileDownloadedFormatPdf() {
        String xpath = "//embed[@type='application/pdf']";
        return verifyElementDisplayed(By.xpath(xpath), 2);
    }

    public boolean isInvoiceMarkedPrimary(String templateName, int rowNo) {
        String xpath = "//tr[@ng-repeat='invoice in invoices'][" + rowNo + "]//td[2][text()='" + templateName + "']//following-sibling::td//i[@tooltip='Primary Invoice']";
        return verifyElementDisplayed(By.xpath(xpath), 2);
    }

    public List<String> getInvoicesColumnNames() {
        List<String> invoicesList = new ArrayList<>();
        for (WebElement e : INVOICE_COLUMN_LIST) {
            invoicesList.add(e.getText().trim());
        }
        return invoicesList;
    }

    public String getRegistrationCode() {
        String xpath = "//div[@class='fs18 text-shadow texttruncate']";
        WebElement getRegText = browser.findElement(By.xpath(xpath));
        String getIndex = getRegText.getText().trim();
        reporter.info("Registration Code : " + getIndex);
        return getIndex;
    }

    public void editPaymentByTransactionDesc(String transDesc) {
        String xpath = "//div[@ng-repeat='payment in payments']//div[1]//p[text()='" + transDesc + "']/..//following-sibling::div//span[@tooltip='Edit']";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        logReport("Edit payment transaction description " + transDesc);

    }

    public void editDiscountByFeeName(String displayFee) throws Exception {
        String xpath = "//div[@ng-repeat[contains(.,'discount in dra')]]//div[1]//p[contains(text(),'" + displayFee + "')]/../..//div[5]//span[@tooltip='Edit']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 30);
        clickByJavaScript(element);
        logReport("Edit payment transaction description " + displayFee);
        VerifyPageReady(30);
    }

    public void enterQuantityAgenda(String qty) throws Exception {
        type(FEE_QUANTITY, qty, true);
        logReport("Entered fee quantity " + qty);
        Thread.sleep(2000);
    }

    public boolean isPurchasesDetailsFound(List<String> actualItems, String currency) {
        List<String> purchasesList = new ArrayList<>();
        for (int i = 1; i <= PURCHASES_ROW_LIST.size(); i++) {
            String purchasesFee = browser.findElement(By.xpath("//div[@ng-repeat[contains(.,'purchase in purchases')]][" + i + "]//div[1][@class='topic col-sm-2']")).getText().trim();
            String registrantName = browser.findElement(By.xpath("//div[@ng-repeat[contains(.,'purchase in purchases')]][" + i + "]//div[2]//p")).getText().trim();
            String qty = browser.findElement(By.xpath("//div[@ng-repeat[contains(.,'purchase in purchases')]][" + i + "]//div[3]//span")).getText().trim();
            String itemCost = browser.findElement(By.xpath("//div[@ng-repeat[contains(.,'purchase in purchases')]][" + i + "]//div[4]//span")).getText().trim();
            String lineTotal = browser.findElement(By.xpath("//div[@ng-repeat[contains(.,'purchase in purchases')]][" + i + "]//div[6]")).getText().trim();
            String itemCostVal = null;
            String lineTotalVal = null;

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("\\");
            stringBuffer.append(currency);

            if (itemCost != null && !itemCost.isEmpty()) {
                itemCostVal = String.valueOf(Float.parseFloat(itemCost.split(stringBuffer.toString())[1]));
            }
            if (lineTotal != null && !lineTotal.isEmpty()) {
                lineTotalVal = String.valueOf(Float.parseFloat(lineTotal.split(stringBuffer.toString())[1]));
            }
            purchasesList.add(purchasesFee.replaceAll("\n", "").trim());
            purchasesList.add(registrantName);
            purchasesList.add(qty);
            purchasesList.add(itemCostVal);
            purchasesList.add(lineTotalVal);
            logReport("Actual transaction list " + purchasesList);
            logReport("Expected actual items list " + actualItems);
            if (purchasesList.containsAll(actualItems)) {
                logReport("Actual transaction list " + purchasesList + "matched with expected transaction list " + actualItems);
                return true;
            }
            purchasesList.clear();
        }
        return false;
    }

}
