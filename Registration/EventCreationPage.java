package pageObjects.Registration;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

public class EventCreationPage extends CommonActionsPage {

    public EventCreationPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }
}
