package pageObjects.Registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

public class DataFormatPage extends CommonActionsPage {

    public DataFormatPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }
}
