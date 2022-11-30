package pageObjects.SpeakerPortal;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

public class SpeakerPortalLoginPage extends CommonActionsPage {
    @FindBy(xpath = "//button[text()='Submit A Proposal']")
    public WebElement SUBMIT_PROPOSAL_BUTTON;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement USERNAME_TEXTBOX;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement PASSWORD_TEXTBOX;

    @FindBy(xpath = "//input[@value='Sign In']")
    public WebElement SIGNIN_BUTTON;

    @FindBy(xpath = "//p")
    public WebElement LOGIN_CONTENT;

    @FindBy(xpath = "//button[contains(.,'Login')]")
    public WebElement BUTTON_LOGIN;

    @FindBy(xpath = "//div[@ng-repeat='item in loginContent.ssoAllowedConnection']//button")
    public WebElement SSO_BUTTON;

    public SpeakerPortalLoginPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public SubmitProposalPage clickSubmitProposalButton() throws Exception {
        Wait(SUBMIT_PROPOSAL_BUTTON, 20);
        click(SUBMIT_PROPOSAL_BUTTON);
        logReport("Submit Proposal button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        return new SubmitProposalPage(browser);
    }

    public MyInformationPage fillLoginDetails(String username, String password) throws Exception {
        Wait(USERNAME_TEXTBOX, 20);
        type(USERNAME_TEXTBOX, username, true);
        logReport("Entered username value " + username);
        type(PASSWORD_TEXTBOX, password, true);
        logReport("Entered password value " + password);
        click(SIGNIN_BUTTON);
        logReport("Sign in button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyAjaxRequestsFinished(20);
        return new MyInformationPage(browser);
        //
    }

    public void clickSingleSignOnButton(String buttonName) throws Exception {
        String xpath = "//button[text()='" + buttonName + "']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 30);
        click(element);
        logReport("Single sign on button clicked successfully");
        VerifyPageReady(30);
    }


}
