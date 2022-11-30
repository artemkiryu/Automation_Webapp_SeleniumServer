package pageObjects.Accommodation;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

/**
 * Created by infoobjects on 8/21/2017.
 */
public class AccommodationImportPage extends CommonActionsPage {

    public AccommodationImportPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }
}
