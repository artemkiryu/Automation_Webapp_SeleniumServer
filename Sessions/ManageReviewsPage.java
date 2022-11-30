package pageObjects.Sessions;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

public class ManageReviewsPage extends CommonActionsPage {
    @FindBy(xpath = "//a[@aria-label='Reviewer Portal']")
    public WebElement REVIEWERPORTAL_TAB;

    @FindBy(xpath = "//button[@x-ng-click='ok()']")
    public WebElement ALERT_OK;

    @FindBy(xpath = "//button[text()='Great, setup the Defaults!']")
    public WebElement GREAT_DEFAULT_BUTTON;


    public ManageReviewsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void sendToReviewSession(String sessionCode) throws Exception {
        Thread.sleep(2000);
        String xpath = "//td[text()='" + sessionCode + "']//following-sibling::td/i[@title='Send to Review']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 30);
        click(element);
        logReport("Session send to review " + sessionCode);
        Thread.sleep(1000);
        click(ALERT_OK);
        VerifyPageReady(30);

    }

    public ReviewerPortalPage clickReviewerPortalTab() throws Exception {
        Wait(REVIEWERPORTAL_TAB, 30);
        clickByJavaScript(REVIEWERPORTAL_TAB);
        logReport("Reviewer portal tab clicked");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        return new ReviewerPortalPage(browser);
    }

    public void clickGreatDefaultButton() throws Exception {
        if (verifyElementDisplayed(GREAT_DEFAULT_BUTTON, 5)) {
            switchToLatestTabOrWindow();
            //Wait(GREAT_DEFAULT_BUTTON, 30);
            click(GREAT_DEFAULT_BUTTON);
            logReport("Great setup default button clicked successfully");
            switchToLatestTabOrWindow();
        }
    }
}
