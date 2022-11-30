package pageObjects.Implementation;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.SalesForceIntegrationConnection;

/**
 * Created by infoobjects on 24-08-2017.
 */
public class SalesForceIntegrationPage extends CommonActionsPage {
    @FindBy(xpath = "//input[@id='txtSalesForceUserName']")
    public WebElement USERNAME_TEXTBOX;
    @FindBy(xpath = "//input[@id='txtSalesForcePassword']")
    public WebElement PASSWORD_TEXTBOX;
    @FindBy(xpath = "//input[@id='txtSalesForceUserName']")
    public WebElement CONFIRM_PASSWORD_TEXTBOX;
    @FindBy(xpath = "//input[@id='txtSalesForceToken']")
    public WebElement SECURITY_TOKEN_TEXTBOX;
    @FindBy(xpath = "//select[@id='txtSalesForceURL']")
    public WebElement URL_DROPDOWN;
    @FindBy(xpath = "//input[@id='bitSalesForceIsActive']")
    public WebElement ACTIVE_CHECKBOX;
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;

    public SalesForceIntegrationPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    private void enterUsername(String username) {
        type(USERNAME_TEXTBOX, username, true);
        logReport("Entered username value " + username);
    }

    private void enterPassword(String password) {
        type(PASSWORD_TEXTBOX, password, true);
        logReport("Entered password value " + password);
    }

    private void enterConfirmPassword(String confirmPassword) {
        type(CONFIRM_PASSWORD_TEXTBOX, confirmPassword, true);
        logReport("Entered confirm password" + confirmPassword);
    }

    private void enterSecurityToken(String securityToken) {
        type(SECURITY_TOKEN_TEXTBOX, securityToken, true);
        logReport("Entered security token value" + securityToken);
    }

    private void selectUrlValue(String url) {
        select(URL_DROPDOWN, url);
        logReport("Selected url value " + url);
    }

    private void checkUncheckActiveCheckbox(boolean state) {
        if (state) {
            check(ACTIVE_CHECKBOX);
            logReport("Active checkbox checked successfully");
        } else {
            unCheck(ACTIVE_CHECKBOX);
            logReport("Active checkbox unchecked successfully");
        }
    }

    public void clickSaveButton() {
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");

    }

    public void createSalesForceConnection(SalesForceIntegrationConnection salesForceIntegrationConnection) {
        enterUsername(salesForceIntegrationConnection.getUsername());
        enterPassword(salesForceIntegrationConnection.getPassword());
        enterConfirmPassword(salesForceIntegrationConnection.getConfirmPassword());
        enterSecurityToken(salesForceIntegrationConnection.getSecurityToken());
        selectUrlValue(salesForceIntegrationConnection.getUrl());
        checkUncheckActiveCheckbox(salesForceIntegrationConnection.isActive());
    }
}
