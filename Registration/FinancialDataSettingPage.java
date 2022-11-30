package pageObjects.Registration;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

/**
 * Created by bludshot on 22/7/15.
 */
public class FinancialDataSettingPage extends CommonActionsPage {

    @FindBy(xpath = "//div[contains(.,'E-commerce Accounts')]//button[@id='create-link-commerce']")
    public WebElement ADD_NEW_E_COMMERCE_ACCOUNT_BUTTON;

    public FinancialDataSettingPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to click add new ecommerce account button
     *
     * @return ECommerceAccountDetailsPage
     */
    public ECommerceAccountDetailsPage clickAddNewECommerceAccountButton() throws Exception {
        Wait(ADD_NEW_E_COMMERCE_ACCOUNT_BUTTON, 10);
        clickByJavaScript(ADD_NEW_E_COMMERCE_ACCOUNT_BUTTON);
        logReport("Add new ecommerce button clicked successfully");
        return new ECommerceAccountDetailsPage(browser);
    }
}
