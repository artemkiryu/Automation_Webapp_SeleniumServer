package pageObjects.Implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

public class APIPage extends CommonActionsPage {

    public APIPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }
}
