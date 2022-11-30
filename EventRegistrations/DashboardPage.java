package pageObjects.EventRegistrations;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

/**
 * Created by infoobjects on 8/24/2017.
 */
public class DashboardPage extends CommonActionsPage{


    @FindBy(xpath = "//div[@id='actions']//a[text()='Add Registration']")
    public WebElement ADD_REGISTRATION_BUTTON;


    public DashboardPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }


    /**
     * Method for clicking add registration button
     *
     * @return CreateRegistrationPage
     */
    public CreateRegistrationPage clickAddRegistration() throws Exception{
        VerifyPageReady(30);
        Wait(ADD_REGISTRATION_BUTTON, 30);
        click(ADD_REGISTRATION_BUTTON);
        logReport("Clicked on 'Add registration' button.");
        VerifyPageReady(30);
        return new CreateRegistrationPage(browser);
    }
}
