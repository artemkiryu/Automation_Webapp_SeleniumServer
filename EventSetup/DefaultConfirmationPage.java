package pageObjects.EventSetup;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

/**
 * Created by infoobjects on 8/21/2017.
 */
public class DefaultConfirmationPage extends CommonActionsPage {
    public DefaultConfirmationPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }


}
