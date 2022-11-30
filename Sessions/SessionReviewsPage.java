package pageObjects.Sessions;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

public class SessionReviewsPage extends CommonActionsPage {
    @FindBy(xpath = "//a[@aria-label='Tiers']")
    public WebElement TIER_TAB;

    public SessionReviewsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public TierPage clickTierTab() throws Exception {
        Wait(TIER_TAB, 30);
        click(TIER_TAB);
        logReport("Tier tab clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        return new TierPage(browser);
    }
}
