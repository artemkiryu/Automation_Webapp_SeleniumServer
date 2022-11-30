package pageObjects.Management;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddConfig;
import pojo.LinkedInAppMappings;

import javax.naming.ConfigurationException;

public class AddSsoConfigPage extends CommonActionsPage {

    @FindBy(xpath = "//button[text()='Add an SSO Config']")
    public WebElement ADD_SSO_CONFIG_BUTTON;

    @FindBy(xpath = "//input[@id='nameAdd']")
    public WebElement CONFIG_NAME_TEXTBOX;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement SAVE_BUTTON;

    @FindBy(xpath = "//input[@id='appId']")
    public WebElement APP_ID_TEXTBOX;

    @FindBy(xpath = "//select[@id='ssoConfigTypeAdd']")
    public WebElement CONFIG_TYPE_DROPDOWN;

    @FindBy(xpath = "//label[text()='IDP Name']//following-sibling::div//select")
    public WebElement IDP_NAME_DROPDOWN;

    @FindBy(xpath = "//label[text()='Button Label']//following-sibling::div//input")
    public WebElement BUTTON_LABEL_TEXTBOX;

    @FindBy(xpath = "//select[@id='profileLookupFieldAdd']")
    public WebElement profileLookupDropdown;

    @FindBy(xpath = "//label[text()='Button Color']//following-sibling::div//input[@id='buttonLabelAdd']")
    public WebElement BUTTON_COLOR_TEXTBOX;

    @FindBy(xpath = "//label[text()='Button Text Color']//following-sibling::div//input[@id='buttonLabelAdd']")
    public WebElement BUTTON_TEXTCOLOR_TEXTBOX;

    @FindBy(xpath = "//input[@id='buttonClass']")
    public WebElement BUTTON_CLASS_TEXTBOX;

    @FindBy(xpath = "//label[text()='firstName']/..//following-sibling::td//input")
    public WebElement FIRST_NAME_DROPDOWN;

    @FindBy(xpath = "//label[text()='lastName']/..//following-sibling::td//input")
    public WebElement LAST_NAME_DROPDOWN;

    @FindBy(xpath = "//label[text()='emailAddress']/..//following-sibling::td//input")
    public WebElement EMAIL_ADDRESS_DROPDOWN;


    public AddSsoConfigPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void enterConfigName(String appName) throws Exception {
        Wait(CONFIG_NAME_TEXTBOX, 30);
        type(CONFIG_NAME_TEXTBOX, appName, true);
        logReport("Entered config app name " + appName);
    }

    public void enterAppId(String appId) {
        type(APP_ID_TEXTBOX, appId, true);
        logReport("Entered App Id " + appId);
    }

    public void selectConfigType(String configType) {
        select(CONFIG_TYPE_DROPDOWN, configType);
        logReport("Selected config type " + configType);
    }

    public void selectIdpName(String idpName) {
        select(IDP_NAME_DROPDOWN, idpName);
        logReport("Selected Idp Name " + idpName);
    }

    public void enterButtonLabel(String label) {
        type(BUTTON_LABEL_TEXTBOX, label, true);
        logReport("Entered button label textbox value" + label);
    }

    public void selectProfileLookUpValue(String value) {
        select(profileLookupDropdown, value);
        logReport("Selected value " + value);
    }

    public void enterButtonColor(String btnColor) {
        type(BUTTON_COLOR_TEXTBOX, btnColor, true);
        logReport("Entered button color textbox value " + btnColor);
    }

    public void enterButtonTextColor(String btnTextColor) {
        type(BUTTON_TEXTCOLOR_TEXTBOX, btnTextColor, true);
        logReport("Entered button text color textbox value " + btnTextColor);
    }

    public void enterButtonClass(String className) {
        type(BUTTON_CLASS_TEXTBOX, className, true);
        logReport("Entered button class name" + className);
    }

    public SingleSignOnPage clickSaveButton() throws Exception {
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(30);
        return new SingleSignOnPage(browser);
    }

    public void checkEntryPoints(String entryPoints) {
        String apps[] = entryPoints.split(",");
        for (int i = 0; i < apps.length; i++) {
            String xpath = "//label[contains(.,'" + apps[i] + "')]//input";
            checkByJavascript(browser.findElement(By.xpath(xpath)));
            logReport("Entry points checkboxes checked " + apps[i]);
        }
    }

    public void fillConfigAppDetails(AddConfig addConfig, String clientId) throws Exception {
        enterConfigName(addConfig.getConfigName());
        enterAppId(clientId);
        selectConfigType(addConfig.getConfigType());
        selectIdpName(addConfig.getIdpName());
        enterButtonLabel(addConfig.getBtnLabel());
        enterButtonColor(addConfig.getBtnColor());
        enterButtonTextColor(addConfig.getBtnTextColor());
        enterButtonClass(addConfig.getBtnClass());
        checkEntryPoints(addConfig.getEntryPoints());
    }

    public void selectFirstNameMapping(String values) throws Exception {
        Wait(FIRST_NAME_DROPDOWN, 30);
        String val[] = values.split(",");
        for (int i = 0; i < val.length; i++) {
            clickByJavaScript(FIRST_NAME_DROPDOWN);
            type(FIRST_NAME_DROPDOWN, val[i], true);
            FIRST_NAME_DROPDOWN.sendKeys(Keys.ENTER);
            reporter.info("Selected first name values " + val[i]);
        }
    }

    public void selectLastNameMapping(String values) throws Exception {
        Wait(LAST_NAME_DROPDOWN, 30);
        String val[] = values.split(",");
        for (int i = 0; i < val.length; i++) {
            clickByJavaScript(LAST_NAME_DROPDOWN);
            type(LAST_NAME_DROPDOWN, val[i], true);
            LAST_NAME_DROPDOWN.sendKeys(Keys.ENTER);
            reporter.info("Selected last name values " + val[i]);
        }
    }

    public void selectEmailAddressMapping(String values) throws Exception {
        Wait(EMAIL_ADDRESS_DROPDOWN, 30);
        String val[] = values.split(",");
        for (int i = 0; i < val.length; i++) {
            clickByJavaScript(EMAIL_ADDRESS_DROPDOWN);
            type(EMAIL_ADDRESS_DROPDOWN, val[i], true);
            EMAIL_ADDRESS_DROPDOWN.sendKeys(Keys.ENTER);
            reporter.info("Selected email address values " + val[i]);
        }
    }

    public void fillLinkedInMappingData(LinkedInAppMappings linkedInAppMappings) throws Exception {
        selectFirstNameMapping(linkedInAppMappings.getFirstName());
        selectLastNameMapping(linkedInAppMappings.getLastName());
        selectEmailAddressMapping(linkedInAppMappings.getEmailAddress());

    }
}
