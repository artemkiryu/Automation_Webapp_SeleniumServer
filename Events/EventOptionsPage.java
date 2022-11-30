package pageObjects.Events;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pageObjects.EventConfigure.IntegrationLinksPage;
import pageObjects.EventSetup.ConnectorsPage;
import pageObjects.FormPost.FormPostPage;

import java.util.List;

/**
 * Created by infoobjects on 8/3/2017.
 */
public class EventOptionsPage extends CommonActionsPage {

    @FindBy(xpath = "//div[@id='functionalareasneededbythiseventid']//input[@type='checkbox']")
    public List<WebElement> functionalCheckBoxes;

    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement SAVE_BUTTON;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Configure Single Sign-On options for this account.']")
    public WebElement SSO_TAB;

    @FindBy(xpath = "//input[@id='Single Sign-On Module']")
    public WebElement SINGLE_SIGNON_CHK;

    @FindBy(xpath = "//label[text()='Travel Reservations']//..//input")
    public WebElement TRAVEL_RESERVATIONS_CHK;

    @FindBy(xpath = "//label[text()='Travel Connectors']//..//input")
    public WebElement TRAVEL_CONNECTORS_CHK;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Integration']")
    public WebElement INTEGRATION_LINK;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Form Post']")
    public WebElement FORM_POST_TAB;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Options']")
    public WebElement OPTIONS_TAB;

    @FindBy(xpath = "//strong[text()='Conference Sessions']/../input")
    public WebElement CONFERENCE_SESSION_CHK;

    @FindBy(xpath = "//input[@id='Speaker and Session Management Module']")
    public WebElement SESSION_MODULE;

    @FindBy(xpath = "//input[@id='Travel Module']")
    public WebElement TRAVEL_MODULE_CHK;

    @FindBy(xpath = "//label[text()='Travel Packages']//..//input")
    public WebElement TRAVEL_FLIGHT_CHK;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Connectors']")
    public WebElement CONNECTORS_TAB;

    @FindBy(xpath = "//input[@id='allowed_double_booking']")
    public WebElement doubleBookingSpeaker;

    public EventOptionsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void enableSingleSignOnModule() throws Exception {
        scrollIntoView(SINGLE_SIGNON_CHK);
        check(SINGLE_SIGNON_CHK);
        logReport("Successfully clicked on 'Single Sign On Module' checkbox.");

    }

    public void enableAllProducts() throws Exception{
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        List<WebElement> sessionCheckBox = browser.findElements(By.xpath("//input[@id='Speaker and Session Management Module']"));
        List<WebElement> sessionOptionsCheckBox = browser.findElements(By.xpath("//input[@id='allow_overlap_for_all']"));
        List<WebElement> checkInChk = browser.findElements(By.xpath("//strong[text()='Certain Check-In']/../input"));
        String checkBoxId;
        functionalCheckBoxes.removeAll(sessionCheckBox);
        functionalCheckBoxes.removeAll(sessionOptionsCheckBox);
        functionalCheckBoxes.removeAll(checkInChk);
        for (WebElement checkBox : functionalCheckBoxes) {
            if (!checkBox.isSelected()) {
                clickByJavaScript(checkBox);
                //checkBox.click();
                if (isAlertPresent()) {
                    logReport("Alert Present");
                    Alert alert = browser.switchTo().alert();
                    alert.accept();
                }
            }
        }
        if (!sessionCheckBox.get(0).isSelected()) sessionCheckBox.get(0).click();
        if (isAlertPresent()) {
            logReport("Alert Present");
            Alert alert = browser.switchTo().alert();
            alert.accept();
        }
        if (!sessionOptionsCheckBox.get(0).isSelected()) sessionOptionsCheckBox.get(0).click();

        click(SAVE_BUTTON);
        VerifyPageReady(30);
    }

    public IntegrationLinksPage clickIntegrationTab() throws Exception {
        Wait(INTEGRATION_LINK, 30);
        click(INTEGRATION_LINK);
        logReport("Integration tab clicked successfully");
        return new IntegrationLinksPage(browser);
    }

    public void unCheckDoubleBookingSpeaker() throws Exception {
        uncheckByJavascript(doubleBookingSpeaker);
        logReport("Double booking speaker id unchecked");
        VerifyPageReady(30);
    }

    public void enableRegistrationGroupsProduct() throws Exception {
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        List<WebElement> registrationGroupsCheckBox = browser.findElements(By.xpath("//strong[text()='Registration Groups']/../input"));

        for (WebElement checkBox : registrationGroupsCheckBox) {
            if (!checkBox.isSelected()) {
                clickByJavaScript(checkBox);
                //checkBox.click();
                if (isAlertPresent()) {
                    logReport("Alert Present");
                    Alert alert = browser.switchTo().alert();
                    alert.accept();
                }
            }
        }

        click(SAVE_BUTTON);
        VerifyPageReady(30);
    }

    public void disableIntegrationModule() throws Exception {

        WebElement integrationCheckBox = browser.findElement(By.xpath("//input[@id='Integration Module']"));
        clickByJavaScript(integrationCheckBox);
        wait(10);
        click(SAVE_BUTTON);
        VerifyPageReady(30);
    }

    public FormPostPage clickFormPostTab() throws Exception {
        Wait(FORM_POST_TAB, 20);
        clickByJavaScript(FORM_POST_TAB);
        logReport("Form Post tab clicked successfully");
        VerifyAjaxRequestsFinished(20);
        VerifyAngularHasFinishedProcessing(30);
        VerifyPageReady(20);
        return new FormPostPage(browser);
    }

    public void clickOptionsTab() throws Exception {
        Wait(OPTIONS_TAB, 20);
        click(OPTIONS_TAB);
        VerifyPageReady(20);
        logReport("Options tab clicked successfully");
    }

    public void uncheckConferenceSessionCheckbox() {
        uncheckByJavascript(CONFERENCE_SESSION_CHK);
        logReport("Conference session checkbox unchecked successfully");
    }

    public void uncheckSessionModule() {
        uncheckByJavascript(SESSION_MODULE);
        logReport("Session checkbox unchecked successfully");
    }

    public void checkConferenceSessionCheckbox() {
        checkByJavascript(CONFERENCE_SESSION_CHK);
        logReport("Conference session checkbox checked successfully");
    }

    public void clickSaveButton() {
        clickByJavaScript(SAVE_BUTTON);
        logReport("Save button clicked successfully");
    }

    public EventSSOConfigurationPage clickSSOTab() throws Exception {
        Wait(SSO_TAB, 30);
        click(SSO_TAB);
        logReport("Clicked on SSO tab.");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        VerifyAngularHasFinishedProcessing(30);
        return new EventSSOConfigurationPage(browser);
    }

    public void enableTravelProducts() throws Exception {
        //  webDriver.Wait(TRAVEL_MODULE_CHK,10);
        checkByJavascript(TRAVEL_MODULE_CHK);
        VerifyPageReady(30);
        if (verifyElementDisplayed(TRAVEL_CONNECTORS_CHK, 10)) {
            unCheck(TRAVEL_CONNECTORS_CHK);

        }
        uncheckByJavascript(TRAVEL_RESERVATIONS_CHK);
        checkByJavascript(TRAVEL_FLIGHT_CHK);
        click(SAVE_BUTTON);
        VerifyPageReady(30);
    }

    public ConnectorsPage clickConnectorsTab() throws Exception {
        Wait(CONNECTORS_TAB, 30);
        click(CONNECTORS_TAB);
        logReport("Connectors tab clicked");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        VerifyAngularHasFinishedProcessing(30);
        return new ConnectorsPage(browser);

    }
}
