package pageObjects.Registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

public class RegistrationOverviewPage extends CommonActionsPage {

    public RegistrationOverviewPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }
}
