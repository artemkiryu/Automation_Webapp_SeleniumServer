package pageObjects.Implementation;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

public class AccountHistoryPage extends CommonActionsPage {

    public AccountHistoryPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }
}
