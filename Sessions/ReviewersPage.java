package pageObjects.Sessions;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

public class ReviewersPage extends CommonActionsPage {
    @FindBy(xpath = "//button[@ng-click='addReviewer()']")
    public WebElement ADD_NEW_BUTTON;

    @FindBy(xpath = "//a[@aria-label='Manage Reviews']")
    public WebElement MANAGEREVIEWS_TAB;

    @FindBy(xpath = "//button[@ng-click='addReviewer()']")
    public WebElement ADDREVIEWER_BUTTON;

    public ReviewersPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public AddReviewerPage clickAddReviewerButton() throws Exception {
        Wait(ADDREVIEWER_BUTTON, 30);
        clickByJavaScript(ADDREVIEWER_BUTTON);
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        return new AddReviewerPage(browser);
    }

    public ManageReviewsPage clickManageReviewsTab() throws Exception {
        Wait(MANAGEREVIEWS_TAB, 20);
        clickByJavaScript(MANAGEREVIEWS_TAB);
        logReport("Manage reviews tab clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        return new ManageReviewsPage(browser);
    }

}
