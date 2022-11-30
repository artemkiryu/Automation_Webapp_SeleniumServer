package pageObjects.Locations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;
import java.util.List;

public class LocationsPage extends CommonActionsPage {

    @FindBy(xpath = "//button[@ng-click='addLocation()']")
    public static WebElement ADD_NEW_BUTTON;

    @FindBy(xpath = "//tr[@ng-repeat='location in locationList']")
    public List<WebElement> LOCATION_LIST;

    @FindBy(xpath = "//input[@id='search-locations']")
    public static WebElement SEARCH_TEXTBOX;

    @FindBy(xpath = "//button[@ng-click='search()']")
    public static WebElement SEARCH_BUTTON;

    @FindBy(xpath = "//div[contains(text(),'No Location(s) found.')]")
    public WebElement NO_LOCATION_FOUND_TEXT;


    public LocationsPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void clickOnSearchButton() throws Exception {
        Wait(SEARCH_BUTTON, 20);
        click(SEARCH_BUTTON);
        logReport("Search button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
    }

    public void enterValueInSearchTextBox(String value) throws Exception {
        Wait(SEARCH_TEXTBOX, 20);
        type(SEARCH_TEXTBOX, value);
        logReport("successfully entered value : " + value + " in search text box.");
    }

    public AddLocationPage clickOnAddNewLocationButton() throws Exception {
        Wait(ADD_NEW_BUTTON, 20);
        clickByJavaScript(ADD_NEW_BUTTON);
        logReport("Location's Add new button clicked successfully");
        return new AddLocationPage(browser);
    }

}
