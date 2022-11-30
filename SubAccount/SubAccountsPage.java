package pageObjects.SubAccount;

import globals.WebGlobals;
import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AccountSettings;

import java.util.List;

/**
 * Created by infoobjects on 8/3/2017.
 */
public class SubAccountsPage extends CommonActionsPage {

    public static final By ACCOUNT_OPTIONS_LIST = By.xpath("//div[contains(@ng-repeat,'name in child.accountNameArray')]");
    public static final By SupportValues = By.xpath("//ul[contains(@id,'select2-results')]//li//div");
    public static final By DROPDOWNOPTIONSLIST = By.xpath("//div[@id='select2-drop']//ul[@class='select2-results']//li//div");
    @FindBy(xpath = "//a[@id='accountDropdown']//div[@class='actSelector']")
    public WebElement accountSelector;
    @FindBy(xpath = "//iframe[@id='accountSelectorFrame']")
    public WebElement accountFrame;
    @FindBy(xpath = "//input[@ng-model='searchTerm']")
    public WebElement accountSearchTextbox;
    @FindBy(xpath = "//span[@class='bold underline']")
    public WebElement accountOptionsList;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-xs pull-right']")
    public WebElement ADD_NEW_BUTTON;
    @FindBy(xpath = "//input[@ng-model='subaccountData.code']")
    public WebElement UNIQUE_CODE_TEXTBOX;
    @FindBy(xpath = "//label[text()='Support Rep']//..//div//div[1]//a//span[@class='select2-arrow']")
    public WebElement SUPPORT_REP_DROPDOWN_ARROW;
    @FindBy(xpath = "//div[@class='select2-search']//input[contains(@id,'autogen')]")
    public List<WebElement> INPUT_LIST_DROP_DOWN;
    @FindBy(xpath = "//ul[contains(@id,'select2-results')]//li//div")
    public WebElement SUPPORT_REP_VALUES;
    @FindBy(xpath = "//label[text()='Parent Account']//..//div//div[1]//a//span[@class='select2-arrow']")
    public WebElement PARENT_ACCOUNT_SPAN;
    @FindBy(xpath = "//div[@id='select2-drop']//ul[@class='select2-results']//li//div")
    public WebElement DROP_DOWN_OPTIONS_LIST;
    @FindBy(xpath = "//input[@ng-click='formOptions.customerIdRadio=false']")
    public WebElement CUSTOMERID_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='subaccountData.active']")
    public WebElement ACTIVE_CHKBX;
    @FindBy(xpath = "//input[@ng-model='account.name']")
    public WebElement ACCOUNT_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='account.contactName']")
    public WebElement PRIMARY_CONTACT_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='account.email']")
    public WebElement EMAIL_TEXTBOX;
    @FindBy(xpath = "//input[@id='account-save']")
    public WebElement SAVE_BUTTON;

    public SubAccountsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void selectSubAccount(String accountCode) throws Exception{
       // VerifyAjaxRequestsFinished(30);
        //VerifyAngularHasFinishedProcessing(20);

        accountSelector.click();

        VerifyAjaxRequestsFinished(10);

        switchToAccountFrame();
        VerifyAngularHasFinishedProcessing(5);
        accountSearchTextbox.sendKeys(accountCode);
        VerifyAngularHasFinishedProcessing(5);

        if(!isElementDisplayed(ACCOUNT_OPTIONS_LIST,browser)){
            switchToAccountFrame();
        }
        //  switchToAccountFrame();
        List<WebElement> optionsList = browser.findElements(ACCOUNT_OPTIONS_LIST);
        if (optionsList.size() != 1) {
            VerifyAngularHasFinishedProcessing(30);
            for (WebElement e : optionsList) {
                if (e.getText().trim().equalsIgnoreCase(accountCode)) {
                    e.click();
                    logReport("Selected parentAccount = " + accountCode);
                    break;
                }
            }
        } else {
            VerifyAngularHasFinishedProcessing(5);
            accountOptionsList.click();
            logReport("Selected parentAccount = " + accountCode);
        }
        // VerifyelementsNumberEqual(1,ACCOUNT_OPTIONS_LIST,30);

        VerifyAjaxRequestsFinished(10);
        //  VerifyPageReady(30);
        // browser.switchTo().defaultContent();

    }

    public void switchToAccountFrame() throws Exception{
        VerifyPageReady(30);
        browser.switchTo().frame(accountFrame);
        logReport("Switched to account frame successfully");
        //webDriver.switchTo().defaultContent();
    }

    /**
     * Method to click on Add New Button.
     */
    public void clickAddNew() throws Exception{
        Wait(ADD_NEW_BUTTON,20);
        VerifyAjaxRequestsFinished(20);
        VerifyAngularHasFinishedProcessing(20);
        ADD_NEW_BUTTON.click();
        logReport("Clicked on ADD NEW Button");

    }
    public void fillAccountSettings(AccountSettings accountSettings) throws Exception{
        enterUniqueCode(accountSettings.getUniqueCode());
        selectSupportRep(accountSettings.getSupportRep());
        selectParentAccount(accountSettings.getParentAccount());
        processActive(accountSettings.isActive());
        enterAccountName(accountSettings.getUniqueCode());
        enterPrimaryContact(accountSettings.getPrimaryContact());
        enterEmail(accountSettings.getEmail());
        enterCustomerID(accountSettings.getCustomerID());
    }

    public void fillAccountSettingsByParentAccount(AccountSettings accountSettings, String parentAccount) throws Exception {
        enterUniqueCode(accountSettings.getUniqueCode());
        selectSupportRep(accountSettings.getSupportRep());
        selectParentAccount(parentAccount);
        enterCustomerID(accountSettings.getCustomerID());
        processActive(accountSettings.isActive());
        enterAccountName(accountSettings.getUniqueCode());
        enterPrimaryContact(accountSettings.getPrimaryContact());
        enterEmail(accountSettings.getEmail());
    }

    public void clickSave() throws Exception{
        SAVE_BUTTON.click();
        VerifyAjaxRequestsFinished(30);
        VerifyPageReady(30);

    }

    /**
     * Method to enter unique code.
     *
     * @param uniqueCode : value of unique code.
     */
    private void enterUniqueCode(String uniqueCode)throws Exception {
        Wait(UNIQUE_CODE_TEXTBOX,20);
        VerifyAngularHasFinishedProcessing(20);
        UNIQUE_CODE_TEXTBOX.sendKeys(uniqueCode);
        logReport("Entered uniqueCode = " + uniqueCode);
    }

    /**
     * Method to select Support rep from the dropdown.
     *
     * @param supportRep : value of support rep that need to be select.
     */
    private void selectSupportRep(String supportRep) throws Exception{
        SUPPORT_REP_DROPDOWN_ARROW.click();
        Wait(SUPPORT_REP_VALUES,20);
        for (WebElement element : INPUT_LIST_DROP_DOWN) {
            if(element.isDisplayed()) {
                element.sendKeys(supportRep);
                VerifyAjaxRequestsFinished(20);

                elementsNumberEqual(1,SupportValues,20);
                element.sendKeys(Keys.TAB);
                VerifyAjaxRequestsFinished(20);
            }

        }
        logReport("Selected supportRep = " + supportRep);

    }

    /**
     * Method to select Parent account.
     *
     * @param parentAccount : value of parrent account that need to select.
     */

    public void selectParentAccount(String parentAccount) throws Exception {
        Wait(PARENT_ACCOUNT_SPAN, 20);
        PARENT_ACCOUNT_SPAN.click();
        Wait(DROP_DOWN_OPTIONS_LIST,20);
        for (WebElement element : INPUT_LIST_DROP_DOWN) {
            if(element.isDisplayed()) {
                element.sendKeys(parentAccount);
                VerifyAjaxRequestsFinished(20);
                elementsNumberEqual(1,
                        DROPDOWNOPTIONSLIST,20);
                element.sendKeys(Keys.TAB);
                VerifyAjaxRequestsFinished(20);

            }

        }
        logReport("Selected parentAccount = " + parentAccount);
    }

    /**
     * Method to enter customer id in the text box.
     *
     * @param customerID : value of customer id.
     */
    private void enterCustomerID(String customerID) {
        clickByJavaScript(CUSTOMERID_TEXTBOX);
        type(CUSTOMERID_TEXTBOX, customerID, true);
        logReport("Entered customerID = " + customerID);
    }

    /**
     * Method to check the Active checkbox
     *
     * @param isActive : active state of the checkbox.
     */
    private void processActive(boolean isActive) {
        if (isActive)
            check(ACTIVE_CHKBX);
        logReport("Set Active checkBox = " + isActive);
    }
    private void enterAccountName(String accountName) {
        type(ACCOUNT_NAME_TEXTBOX,accountName,true);
        logReport("Entered accountName = " + accountName);
    }

    /**
     * Method to enter promary contact of sub account.
     *
     * @param primaryContact : primary contact value.
     */
    private void enterPrimaryContact(String primaryContact) {
        type(PRIMARY_CONTACT_TEXTBOX,primaryContact,true);
        logReport("Entered primaryContact = " + primaryContact);
    }

    /**
     * Method to enter email of sub account.
     *
     * @param email : value of email.
     */
    private void enterEmail(String email) {
        type(EMAIL_TEXTBOX,email,true);
        logReport("Entered email = " + email);
    }
}
