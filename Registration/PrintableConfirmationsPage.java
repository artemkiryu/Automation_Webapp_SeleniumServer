package pageObjects.Registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

public class PrintableConfirmationsPage extends CommonActionsPage {

    public PrintableConfirmationsPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }
}
