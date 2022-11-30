package pageObjects.Communication;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

/**
 * Created by infoobjects on 25-05-2017.
 */
public class EventCustomBlockPage extends CommonActionsPage {

    @FindBy(xpath = "//button[@id='create-link']")
    public WebElement ADD_NEW_CUSTOM_BLOCK;

    public EventCustomBlockPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public EventCustomBlockDetailsPage clickCustomBlockAddNewButton() throws Exception {
        VerifyPageReady(30);
        logReport("Verified Page is Ready");
        ADD_NEW_CUSTOM_BLOCK.click();
        logReport("Add New Custom Block button is Clicked");
        return new EventCustomBlockDetailsPage(browser);
    }

}
