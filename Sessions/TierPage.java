package pageObjects.Sessions;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

public class TierPage extends CommonActionsPage {
    @FindBy(xpath = "//button[text()='Great, setup the Defaults!']")
    public WebElement DEFAULT_BUTTON;

    @FindBy(xpath = "//a[@aria-label='Manage Reviews']")
    public WebElement MANAGEREVIEWS_TAB;

    @FindBy(xpath = "//a[@aria-label='Reviewers']")
    public WebElement REVIEWERS_TAB;


    public TierPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void setDefaultSetup() throws Exception {
        if (verifyElementDisplayed(DEFAULT_BUTTON, 3)) {
            switchToLatestTabOrWindow();
            click(DEFAULT_BUTTON);
            logReport("Default setup button clicked successfully");
            switchToLatestTabOrWindow();

        }
    }

    public ManageReviewsPage clickManageReviewsTab() throws Exception {
        Wait(MANAGEREVIEWS_TAB, 20);
        click(MANAGEREVIEWS_TAB);
        logReport("Manage reviews tab clicked successfully");
        VerifyPageReady(30);
        return new ManageReviewsPage(browser);
    }

    public ReviewersPage clickReviewersTab() throws Exception {
        Wait(REVIEWERS_TAB, 20);
        clickByJavaScript(REVIEWERS_TAB);
        logReport("Reviewers tab clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        return new ReviewersPage(browser);
    }
}
