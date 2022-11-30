package pageObjects.EventRegistrations;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

public class AttendeeProfilePage extends CommonActionsPage {

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Session information.']")
    public WebElement SESSIONS_TAB;

    @FindBy(xpath = "//select[@id='reg_frn_reg_sts_id']")
    public WebElement STATUS_DROPDOWN;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;

    @FindBy(xpath = "//h1//small")
    public WebElement REG_CODE_HEADER_TEXT;

    @FindBy(xpath = "//select[@id='regCatFee']")
    public WebElement ATENDEE_TYPE_DROPDOWN;

    @FindBy(xpath = "//input[@id='pro_pin']")
    public WebElement USERNAME_TEXTBOX;

    @FindBy(xpath = "//input[@id='pro_password']")
    public WebElement PASSWORD_TEXTBOX;


    public AttendeeProfilePage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public SessionInformationPage clickSessionTab() throws Exception {
        Wait(SESSIONS_TAB, 20);
        click(SESSIONS_TAB);
        VerifyAngularHasFinishedProcessing(30);
        reporter.info("Session tab clicked successfully");
        return new SessionInformationPage(browser);
    }

    public void selectStatusValue(String status) throws Exception {
        Wait(STATUS_DROPDOWN, 20);
        select(STATUS_DROPDOWN, status);
        logReport("Selected status value " + status);
    }

    public void clickSave() throws Exception {
        click(SAVE_BUTTON);
        VerifyPageReady(30);
    }

    public AttendeeFinancialPage clickAttendeeFinancialTab() throws Exception {
        VerifyPageReady(30);
        Wait(FINANCIAL_TAB, 30);
        click(FINANCIAL_TAB);
        logReport("Successfully clicked on 'Finacial' tab.");
        VerifyAjaxRequestsFinished(30);
        VerifyAngularHasFinishedProcessing(30);
        return new AttendeeFinancialPage(browser);
    }

    public void selectAttendeeType(String attendeeType) {
        select(ATENDEE_TYPE_DROPDOWN, attendeeType);
        logReport("Selected attendee type " + attendeeType);
    }

    public void setUserPwdCreds(String username, String pwd) {
        type(USERNAME_TEXTBOX, username, true);
        type(PASSWORD_TEXTBOX, pwd, true);
        logReport("Enter username " + username + "password " + pwd);
    }
}
