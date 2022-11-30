package pageObjects.Login;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

/**
 * Created by infoobjects on 8/3/2017.
 */
public class DashboardPage extends CommonActionsPage {
    public DashboardPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[@class='page-header']")
    public WebElement pageHeader;

    @FindBy(xpath = "//a[@title='Logout']")
    public WebElement ADMIN_LOGOUT_BUTTON;

    @FindBy(xpath = "//a[@title='User and Account Settings']")
    public WebElement USER_ACCOUNT_DROPDOWN;
    //a[@title='Logout']

    public LoginPage clickLogoutAdmin() throws Exception {
        closeMessage();
        VerifyAjaxRequestsFinished(30);
        Wait(USER_ACCOUNT_DROPDOWN, 20);
        clickByJavaScript(USER_ACCOUNT_DROPDOWN);
        //webDriver.waitFor().elementDisplayed(ADMIN_LOGOUT_BUTTON);
        clickByJavaScript(ADMIN_LOGOUT_BUTTON);
        reporter.info("Logout button clicked successfully");
        VerifyPageReady(30);
        return new LoginPage(browser);
    }
}
