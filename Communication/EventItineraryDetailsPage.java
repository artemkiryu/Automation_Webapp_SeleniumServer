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
public class EventItineraryDetailsPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement ITINERARY_SAVE_BUTTON;


    public EventItineraryDetailsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void clickItinerarySaveButton() throws Exception {
        VerifyAjaxRequestsFinished(30);
        clickByJavaScript(ITINERARY_SAVE_BUTTON);
        logReport("Save Button is clicked Successfully");

        logReport("Redirected to" + browser.getTitle() + "Page");

    }


}
