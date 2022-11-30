package pageObjects.Sessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

public class SessionSetupPage extends CommonActionsPage {

    @FindBy(xpath = "//div[@id='sidebar-collapse']//a[@title='Session Layout']")

    public WebElement SESSION_LAYOUT_TAG;

    @FindBy(xpath = "//div[@id='sidebar-collapse']//a[@title='Custom Fields']")

    public WebElement CUSTOM_FIELDS_TAG;

    @FindBy(xpath = "//div[@id='sidebar-collapse']//a[@title='Job Functions']")

    public WebElement JOB_FUNCTIONS_TAG;

    @FindBy(xpath = "//div[@id='sidebar-collapse']//a[@title='Industries']")

    public WebElement INDUSTRIES_TAG;

    public SessionSetupPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public SessionLayoutPage clickOnSessionLayoutTab() throws Exception {
        VerifyPageReady(40);
        click(SESSION_LAYOUT_TAG);
        logReport("Successfully clicked on Session layout tab.");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        return new SessionLayoutPage(browser);
    }

    public SessionCustomFieldsPage clickOnCustomFieldsTab() throws Exception {
        VerifyPageReady(30);
        click(CUSTOM_FIELDS_TAG);
        logReport("Successfully clicked on Session custom fields tab.");
        VerifyAngularHasFinishedProcessing(10);
        VerifyAjaxRequestsFinished(20);
        return new SessionCustomFieldsPage(browser);
    }


}
