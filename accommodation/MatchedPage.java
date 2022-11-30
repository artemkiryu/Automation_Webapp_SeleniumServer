package pageObjects.Accommodation;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

/**
 * Created by infoobjects on 8/24/2017.
 */
public class MatchedPage extends CommonActionsPage {

    public MatchedPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }
}
