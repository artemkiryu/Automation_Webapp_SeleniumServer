package pageObjects.Communication;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

/**
 * Created by infoobjects on 25-05-2017.
 */
public class EventPersonalDocumentPage extends CommonActionsPage {

    @FindBy(xpath = "//button[@id='create-link']")
    public WebElement ADD_NEW_PERSONAL_DOCUMENT;

    public EventPersonalDocumentPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public EventPersonalDocumentDetailsPage clickAddNewButton() throws Exception {
        VerifyPageReady(30);
        logReport("Verified Page is Ready");
        ADD_NEW_PERSONAL_DOCUMENT.click();
        logReport("Add New Personal Document button is Clicked");
        return new EventPersonalDocumentDetailsPage(browser);
    }

}
