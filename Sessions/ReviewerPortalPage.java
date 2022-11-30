package pageObjects.Sessions;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pageObjects.ReviewerPortal.ReviewerPortalLoginPage;
import pageObjects.SpeakerPortal.SpeakerPortalLoginPage;

public class ReviewerPortalPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement saveButton;
    @FindBy(xpath = "//a[@class='actionIcon']")
    public WebElement WEBURL_ICON;

    public ReviewerPortalPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void clickSaveButton() throws Exception {
        Wait(saveButton, 30);
        click(saveButton);
        logReport("Save button clicked");
        VerifyPageReady(30);

    }

    public ReviewerPortalLoginPage clickWebUrlIcon() throws Exception {
        Thread.sleep(3000);
        Wait(WEBURL_ICON, 20);
        clickByJavaScript(WEBURL_ICON);
        logReport("WEb url icon clicked successfully");
        switchToLatestTabOrWindow();
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(20);
        return new ReviewerPortalLoginPage(browser);
    }
}
