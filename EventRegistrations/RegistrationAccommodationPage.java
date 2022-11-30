package pageObjects.EventRegistrations;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

/**
 * Created by infoobjects on 8/31/2017.
 */
public class RegistrationAccommodationPage extends CommonActionsPage {

    @FindBy(xpath = "//select[@name='numberOfRoomsRequested']")
    public WebElement NUMBER_OF_ROOM_REQUESTED_DROPDOWN;

    public RegistrationAccommodationPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }


}
