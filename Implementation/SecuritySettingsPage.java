package pageObjects.Implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

public class SecuritySettingsPage extends CommonActionsPage {

    public SecuritySettingsPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }
}
