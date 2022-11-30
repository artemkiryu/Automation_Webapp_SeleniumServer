package pageObjects.Management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 31-08-2017.
 */
public class GeneralLedgerPage extends CommonActionsPage {

    public GeneralLedgerPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }
}
