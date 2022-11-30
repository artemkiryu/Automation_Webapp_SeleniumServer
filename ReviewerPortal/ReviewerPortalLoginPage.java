package pageObjects.ReviewerPortal;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pageObjects.SpeakerPortal.MyInformationPage;
import pojo.AddReviewer;

public class ReviewerPortalLoginPage extends CommonActionsPage {
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement USERNAME_TEXTBOX;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement PASSWORD_TEXTBOX;

    @FindBy(xpath = "//input[@value='Sign In']")
    public WebElement SIGNIN_BUTTON;

    public ReviewerPortalLoginPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public ReviewSessionsPage fillLoginDetails(String username, String password) throws Exception {
        Wait(USERNAME_TEXTBOX, 20);
        type(USERNAME_TEXTBOX, username, true);
        logReport("Entered username value " + username);
        type(PASSWORD_TEXTBOX, password, true);
        logReport("Entered password value " + password);
        click(SIGNIN_BUTTON);
        logReport("Sign in button clicked successfully");
        VerifyAngularHasFinishedProcessing(20);
        VerifyAjaxRequestsFinished(20);
        return new ReviewSessionsPage(browser);
    }
}
