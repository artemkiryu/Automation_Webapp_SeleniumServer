package pageObjects.Profiles;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

public class ProfilesSearchPage extends CommonActionsPage {

    @FindBy(xpath = "//a[text()='Add Profile']")
    public WebElement ADD_PROFILE_BUTTON;

    public ProfilesSearchPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public CreateProfilePage clickAddNewProfile() throws Exception {
        VerifyPageReady(30);
        Wait(ADD_PROFILE_BUTTON, 10);
        click(ADD_PROFILE_BUTTON);
        //VerifyAngularHasFinishedProcessing(20);
        logReport("Add new profile clicked successfully.");
        return new CreateProfilePage(browser);
    }
}
