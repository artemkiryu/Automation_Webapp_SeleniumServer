package pageObjects.User;

import org.apache.commons.configuration.ConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.UserInformation;


public class UserInformationPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@name='usr_name']")
    public WebElement NAME_TEXTBOX;

    @FindBy(xpath = "//input[@name='usr_username']")
    public WebElement LOGIN_TEXTBOX;

    @FindBy(xpath = "//input[@name='usr_phone']")
    public WebElement PHONE_TEXTBOX;

    @FindBy(xpath = "//input[@name='usr_email']")
    public WebElement EMAIL_TEXTBOX;

    @FindBy(xpath = "//select[@id='usr_frn_usr_typ_id']")
    public WebElement USER_TYPE_DROPDOWN;

    @FindBy(xpath = "//select[@name='usr_frn_acnt_id']")
    public WebElement ACCOUNT_DROPDOWN;

    @FindBy(xpath = "//input[@id='usr_is_active']")
    public WebElement ACTIVE_CHK;

    @FindBy(xpath = "//input[@id='usr_is_password_generated']")
    public WebElement GENERATE_PWD_CHK;

    @FindBy(xpath = "//table[@class='forms']//tr//td//label[text()='View all events (AdityaTest and Sub-Accounts)']//..//..//../td[1]")
    public String VIEW_ALL_EVENTS_RADIOBUTTON;

    @FindBy(xpath = "//table[@class='forms']//tr//td//label[text()='View only events for which User is assigned a role (Role-based User)']//..//..//../td[1]")
    public WebElement VIEW_ONLY_EVENTS_RADIOBUTTON;

    @FindBy(xpath = "//table[@class='forms']//tr//td//label//strong[text()='Financial Module']//..//..//../td[1]")
    public WebElement FINANCIAL_MODULE_CHK;

    @FindBy(xpath = "//table[@class='forms']//tr//td//label//strong[text()='Housing Module']//..//..//../td[1]")
    public WebElement HOUSING_MODULE_CHK;

    @FindBy(xpath = "//table[@class='forms']//tr//td//label//strong[text()='Allow event template access']//..//..//../td[1]")
    public WebElement TEMPLATE_ACCESS_CHK;

    @FindBy(xpath = "//table[@class='forms']//tr//td//label//strong[text()='Import registration data']//..//..//../td[1]")
    public WebElement REGISTRATION_DATA_CHK;

    @FindBy(xpath = "//input[@id='Classic']")
    public WebElement CLASSIC_CHK;

    @FindBy(xpath = "//input[@id='Wizard']")
    public WebElement WIZARD_CHK;


    @FindBy(xpath = "//select[@name='lstNotAvailableRleIds']")
    public WebElement AVAILABLE_ROLES_LISTBOX;

    @FindBy(xpath = "//select[@name='lstAssignedRoles']")
    public WebElement ASSIGNED_ROLES_LISTBOX;

    @FindBy(xpath = "//input[@value='-»']")
    public WebElement MOVE_RIGHT_BTN;

    @FindBy(xpath = "//input[@value='«-']")
    public WebElement MOVE_LEFT_BTN;

    @FindBy(xpath = "//input[@id ='submitForm']")
    public WebElement SAVE_USER_BUTTON;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-xs pull-right ']")
    public WebElement ADD_NEW_BUTTON;

    public UserInformationPage(WebDriver driver)
        throws ConfigurationException {
            PageFactory.initElements(driver, this);
        }


    public void addNewUser(UserInformation userInformation) throws Exception {
        Wait(ADD_NEW_BUTTON, 20);
        click(ADD_NEW_BUTTON);
        Wait(EMAIL_TEXTBOX, 10);
        Thread.sleep(10000);
        type(NAME_TEXTBOX, userInformation.getName());
        type(LOGIN_TEXTBOX, userInformation.getEmail());
        type(PHONE_TEXTBOX, userInformation.getPhone());
        type(EMAIL_TEXTBOX, userInformation.getEmail());
        select(USER_TYPE_DROPDOWN, userInformation.getUserType());

        if (userInformation.getActive().equalsIgnoreCase("YES"))
            checkByJavascript(ACTIVE_CHK);
        else
            uncheckByJavascript(ACTIVE_CHK);


    }

    public void clickSave() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        click(SAVE_BUTTON);
        // webDriver.waitFor().waitForPageToLoad();
    }
}