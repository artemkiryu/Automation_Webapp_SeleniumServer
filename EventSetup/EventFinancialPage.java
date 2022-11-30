package pageObjects.EventSetup;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by infoobjects on 8/18/2017.
 */
public class EventFinancialPage extends CommonActionsPage {

    public EventFinancialPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//button[@id='create-link']")
    public WebElement ADD_NEW_TAXCODE_BUTTON;

    @FindBy(xpath = "//select[@name='taxCodePrepopulate']")
    public WebElement SELECT_TAX_CODE_DROPDOWN;

    @FindBy(xpath = "//input[@id='populateApply']")
    public WebElement APPLY_BUTTON;

    @FindBy(xpath = "//input[@id='txtTaxCodeCode']")
    public WebElement TAX_CODE_TEXTBOX;

    @FindBy(xpath = "//input[@id='txtTaxCodeName']")
    public WebElement TAX_NAME_TEXTBOX;

    @FindBy(xpath = "//input[@id='decTaxCodePercentage']")
    public WebElement TAX_PERCENTAGE_TEXTBOX;

    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement SAVE_BUTTON;

    @FindBy(xpath = "//select[@id='PKProc_AcntID']")
    public WebElement PAYMENT_PROCESSING_ACCOUNT_DROPDOWN;

    @FindBy(xpath = "//input[@id='evt_gl_number']")
    public WebElement GL_ACCOUNT_TEXTBOX;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Travel')]")
    public WebElement TRAVEL_TAB;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Default Confirmation')]")
    public WebElement DEFAULT_CONFIRMATION_TAB;

    @FindBy(xpath = "//td[text()='Select a Payment Processing Account']/..//span[@class='select2-chosen']")
    public WebElement PAYMENT_PROCESSING_ACCOUNT;

    @FindBy(xpath = "//td[text()='Currency:']/..//td[@class='data']")
    public WebElement CURRENCY_DATA;

    @FindBy(xpath = "//td[text()='Exact Business Name on Merchant Account:']/..//td[@class='data']")
    public WebElement MERCHANT_ACCCOUNT_NAME;

    @FindBy(xpath = "//td[text()='Online Processor:']/..//td[@class='data']")
    public WebElement ONLINE_PROCESSOR;

    @FindBy(xpath = "//td[text()='Single Transaction Limit:']/..//td[@class='data']")
    public WebElement TRANSACTION_UNIT;

    @FindBy(xpath = "//input[@id='evt_proc_acnt_limit']")
    public WebElement TRANSACTION_UNIT_TEXTBOX;

    @FindBy(xpath = "//div[@id='proc-option-cc-container']//input")
    public List<WebElement> ONLINE_OPTIONS_LIST;

    @FindBy(xpath = "//div[@id='proc-option-other-container']//input")
    public List<WebElement> OTHER_OPTIONS_LIST;

    @FindBy(xpath = "//div[@id='proc-security-container']//input")
    public List<WebElement> SECURITY_OPTIONS;

    private void selectPaymentOption(String paymentOptions)throws Exception{
        ArrayList checkBoxList= new ArrayList(Arrays.asList(paymentOptions.split(",")));
        for(int i=0; i<checkBoxList.size(); i++){
            String onlinePaymentOptionCheckBox = "//div[text()='Other Payment Options:']/..//label[contains(.,'"+paymentOptions+"')]//input";
            scrollIntoView(browser.findElement(By.xpath(onlinePaymentOptionCheckBox)));
            clickByJavaScript(browser.findElement(By.xpath(onlinePaymentOptionCheckBox)));
            //browser.findElement(By.xpath(onlinePaymentOptionCheckBox)).click();
            VerifyPageReady(30);
            logReport("Successfully clicked on checkbox.");
        }
    }

    private void selectPaymentProcessingAccount(String processingAccount)throws Exception{
        VerifyPageReady(30);
        Wait(PAYMENT_PROCESSING_ACCOUNT_DROPDOWN, 30);
        //scrollIntoView(PAYMENT_PROCESSING_ACCOUNT_DROPDOWN);
        select(PAYMENT_PROCESSING_ACCOUNT_DROPDOWN,processingAccount);
        logReport("Successfully selected value: "+processingAccount+" in payment processing account dropdown.");
    }

    private void enterGLAccount(String glAccount)throws Exception{
        VerifyPageReady(30);
        scrollIntoView(GL_ACCOUNT_TEXTBOX);
        Wait(GL_ACCOUNT_TEXTBOX, 30);
        type(GL_ACCOUNT_TEXTBOX, glAccount);
        logReport("Successfully entered value: "+glAccount+" in GL account textbox.");
    }

    private void enterTransactionUnit(String unit)throws Exception{
        VerifyPageReady(30);
        scrollIntoView(TRANSACTION_UNIT_TEXTBOX);
        Wait(TRANSACTION_UNIT_TEXTBOX,30);
        type(TRANSACTION_UNIT_TEXTBOX, unit, true);
        logReport("Successfully entered value: "+unit+" in Transaction textbox.");
    }

    private void clickOnSaveButton()throws Exception{
        VerifyPageReady(30);
        Wait(SAVE_BUTTON,30);
        click(SAVE_BUTTON);
        logReport("Successfully clicked on save button.");
    }

    public void clickOnAddNewButton()throws Exception{
        VerifyPageReady(30);
        scrollIntoView(ADD_NEW_TAXCODE_BUTTON);
        Wait(ADD_NEW_TAXCODE_BUTTON,30);
        click(ADD_NEW_TAXCODE_BUTTON);
        logReport("Successfully clicked on add new button.");
    }

    private void clickOnApplyButton()throws Exception{
        VerifyPageReady(30);
        Wait(APPLY_BUTTON,30);
        click(APPLY_BUTTON);
        logReport("Successfully clicked on apply button.");
    }

    private void selectTaxCodeTemplateAccount(String template)throws Exception{
        VerifyPageReady(30);
        Wait(SELECT_TAX_CODE_DROPDOWN,30);
        select(SELECT_TAX_CODE_DROPDOWN, template);
        logReport("Successfully selected value: "+template+" in select tax code template dropdown.");
    }

    private void addNewTaxCode(String taxCode)throws Exception{
        clickOnAddNewButton();
        selectTaxCodeTemplateAccount(taxCode);
        clickOnApplyButton();
        clickOnSaveButton();
    }

    /*public void fillFinancialDetail(FinancialData financialData)throws Exception{
        selectPaymentProcessingAccount(financialData.getPaymentProcessingAccount());
        selectPaymentOption(financialData.getPaymentOption());
        enterGLAccount(financialData.getGlAccount());
        enterTransactionUnit(financialData.getTaxCodeTemplate());
        clickOnSaveButton();
    }*/


    public TravelQuestionsPage clickOnTravelQuestionsTab()throws Exception{
        VerifyPageReady(30);
        scrollIntoView(TRAVEL_TAB);
        Wait(TRAVEL_TAB, 30);
        clickByJavaScript(TRAVEL_TAB);
        logReport("Successfully clicked on 'Travel' tab.");
        return new TravelQuestionsPage(browser);
    }

    public List<String> getFinacialDetail(){
        List<String> financialData = new ArrayList<>();
        String accountName = PAYMENT_PROCESSING_ACCOUNT.getText();
        String currency = CURRENCY_DATA.getText();
        String merchantAccountName = MERCHANT_ACCCOUNT_NAME.getText();
        String onlineProcessor = ONLINE_PROCESSOR.getText();
        String singleTransactionUnit = TRANSACTION_UNIT.getText();

        financialData.add(accountName);
        financialData.add(currency);
        financialData.add(merchantAccountName);
        financialData.add(onlineProcessor);
        financialData.add(singleTransactionUnit);

        return financialData;

    }

    public void checkOnlineOptions(String options) {
        String a[] = options.split(",");
        for (String s : a) {
            String xpath = "//label[text()='" + s + "']/preceding-sibling::input";
            WebElement element = browser.findElement(By.xpath(xpath));
            checkByJavascript(element);
        }
    }

    public void checkOtherPaymentOptions(String options) {
        String a[] = options.split(",");
        for (String s : a) {
            String xpath = "//div[@id='proc-option-other-container']//label[contains(.,'" + s + "')]/input";
            WebElement element = browser.findElement(By.xpath(xpath));
            checkByJavascript(element);
        }
    }

    public void checkSecurityOptions(String options) {
        String a[] = options.split(",");
        for (String s : a) {
            String xpath = "//div[@id='proc-security-container']//label[text()='" + s + "']/preceding-sibling::input";
            WebElement element = browser.findElement(By.xpath(xpath));
            checkByJavascript(element);
        }
    }

    public void checkAllOnlineOptions() {
        for (WebElement e : ONLINE_OPTIONS_LIST) {
            checkByJavascript(e);
        }
    }

    public void checkAllOtherOptions() {
        for (WebElement e : OTHER_OPTIONS_LIST) {
            checkByJavascript(e);
        }
    }

    public void checkAllSecurityOptions() {
        for (WebElement e : SECURITY_OPTIONS) {
            checkByJavascript(e);
        }
    }

    public void fillFinancialDetails(String processorName, String unit) throws Exception {
        selectPaymentProcessingAccount(processorName);
        checkAllOnlineOptions();
        checkAllOtherOptions();
        checkAllSecurityOptions();
        enterTransactionUnit(unit);

    }
}

