package pageObjects.Locations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddLocationData;

import javax.naming.ConfigurationException;
import java.util.List;

public class AddLocationPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@x-ng-model='location.name']")
    public static WebElement LOCATION_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='location.locationCode']")
    public static WebElement LOCATION_CODE_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='location.capacity']")
    public static WebElement CAPACITY_TEXTBOX;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement LOCATION_SAVE_BUTTON;

    @FindBy(xpath = "//label[text()='*Location Type']/..//button[@id='dLabel']")
    public WebElement LOCATION_TYPE_BUTTON;

    @FindBy(xpath = "//label[text()='*Location Type']/..//following-sibling::div/ul/div[2]//div//span")
    public List<WebElement> LOCATION_TYPE_DROPDOWN_LIST;
    @FindBy(xpath = "//label[text()='*Location Type']/..//following-sibling::div/ul//input[@placeholder='Add New']")
    public WebElement LOCATION_TYPE_TEXTBOX;
    @FindBy(xpath = "//label[text()='*Location Type']/..//following-sibling::div/ul//span[text()='Add New']")
    public WebElement LOCATION_TYPE_ADDNEW_BUTTON;

    @FindBy(xpath = "//label[text()='Venue']/..//button[@id='dLabel']")
    public WebElement VENUE_BUTTON;

    @FindBy(xpath = "//label[text()='Venue']/..//following-sibling::div/ul/div[2]//div//span")
    public List<WebElement> VENUE_DROPDOWN_LIST;
    @FindBy(xpath = "//label[text()='Venue']/..//following-sibling::div/ul//input[@placeholder='Add New']")
    public WebElement VENUE_TEXTBOX;
    @FindBy(xpath = "//label[text()='Venue']/..//following-sibling::div/ul//span[text()='Add New']")
    public WebElement VENUE_ADDNEW_BUTTON;

    public AddLocationPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    private void enterLocationName(String value) throws Exception {
        type(LOCATION_NAME_TEXTBOX, value);
        logReport("entered value " + value + " in location name text box.");
    }

    private void enterLocationCode(String value) throws Exception {
        type(LOCATION_CODE_TEXTBOX, value);
        logReport("entered value " + value + " in location code text box.");
    }

    private void enterLocationCapacity(String value) throws Exception {
        type(CAPACITY_TEXTBOX, value);
        logReport("entered value " + value + " in location capacity text box.");
    }

    public boolean isLocationTypeValueFound(String locationType) {
        boolean found = false;
        if (LOCATION_TYPE_DROPDOWN_LIST.size() > 0) {
            for (WebElement e : LOCATION_TYPE_DROPDOWN_LIST) {
                if (e.getText().trim().equalsIgnoreCase(locationType)) {
                    found = true;
                    break;
                }

            }
        }
        return found;
    }

    public void selectLocationType(String locationType) throws Exception {

        click(LOCATION_TYPE_BUTTON);
        logReport("click on speaker type dropdown button.");
        if (isLocationTypeValueFound(locationType)) {
            for (WebElement e : LOCATION_TYPE_DROPDOWN_LIST) {
                if (e.getText().trim().equalsIgnoreCase(locationType)) {
                    e.click();
                    logReport("Location type exist and clicked successfully");

                }
            }
        } else {
            type(LOCATION_TYPE_TEXTBOX, locationType);
            logReport("Entered location type text value " + locationType);
            click(LOCATION_TYPE_ADDNEW_BUTTON);
            logReport("Location Type add new button clicked successfully");
            click(LOCATION_TYPE_BUTTON);
            logReport("Location Type button clicked");
        }

    }

    public boolean isVenueValueFound(String locationType) {
        boolean found = false;
        if (LOCATION_TYPE_DROPDOWN_LIST.size() > 0) {
            for (WebElement e : LOCATION_TYPE_DROPDOWN_LIST) {
                if (e.getText().trim().equalsIgnoreCase(locationType)) {
                    found = true;
                    break;
                }

            }
        }
        return found;
    }

    public void selectVenue(String venueValue) throws Exception {

        click(VENUE_BUTTON);
        logReport("click on venue dropdown button.");
        if (isVenueValueFound(venueValue)) {
            for (WebElement e : VENUE_DROPDOWN_LIST) {
                if (e.getText().trim().equalsIgnoreCase(venueValue)) {
                    e.click();
                    logReport("Venue exist and clicked successfully");

                }
            }
        } else {
            type(VENUE_TEXTBOX, venueValue);
            logReport("Entered venue text value " + venueValue);
            click(VENUE_ADDNEW_BUTTON);
            logReport("Venue add new button clicked successfully");
            click(VENUE_BUTTON);
            logReport("Venue button clicked");
        }

    }

    public LocationsPage clickLocationSaveButton() throws Exception {
        Wait(LOCATION_SAVE_BUTTON, 30);
        click(LOCATION_SAVE_BUTTON);
        logReport("Location Save button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyAjaxRequestsFinished(10);
        VerifyPageReady(30);
        return new LocationsPage(browser);
    }

    public void fillLocationDetails(AddLocationData addLocationData) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        enterLocationName(addLocationData.getLocationName());
        enterLocationCode(addLocationData.getLocationName());
        selectLocationType(addLocationData.getLocationType());
        enterLocationCapacity(addLocationData.getCapacity());
        selectVenue(addLocationData.getVenue());

    }

}
