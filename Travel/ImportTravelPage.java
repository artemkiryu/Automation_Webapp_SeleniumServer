package pageObjects.Travel;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import java.io.File;

/**
 * Created by infoobjects on 21-08-2017.
 */
public class ImportTravelPage extends CommonActionsPage {
    @FindBy(xpath = "//select[@x-ng-model='importType']")
    public WebElement TRAVEL_DATA_DROPDOWN;
    @FindBy(xpath = "//div[@x-ng-include='flightsTemplate']//form[@name='uploadFlightsForm']//div//input[@name='file']")
    public WebElement FLIGHTS_BROWSE_BTN;
    @FindBy(xpath = "//div[@x-ng-include='flightsTemplate']//form[@name='uploadFlightsForm']//div//input[@value='Upload']")
    public WebElement FLIGHTS_UPLOAD_BTN;
    @FindBy(xpath = "//h4[contains(.,'Success')]")
    public WebElement MESSAGE_BOX;
    @FindBy(xpath = "//div[@x-ng-include='flightReservationsTemplate']//form[@name='uploadFlightReservationsForm']//div//input[@name='file']")
    public WebElement FLIGHTSINVEMTORY_BROWSE_BTN;
    @FindBy(xpath = "//div[@x-ng-include='flightReservationsTemplate']//form[@name='uploadFlightReservationsForm']//div//input[@value='Upload']")
    public WebElement FLIGHTSINVENTORY_UPLOAD_BTN;

    @FindBy(xpath = "//div[@x-ng-include='registrationFlightsTemplate']//form[@name='uploadRegistrationFlightsForm']//div//input[@name='file']")
    public WebElement PREBOOKED_BROWSE_BTN;
    @FindBy(xpath = "//div[@x-ng-include='registrationFlightsTemplate']//form[@name='uploadRegistrationFlightsForm']//div//input[@value='Upload']")
    public WebElement PREBOOKED_UPLOAD_BTN;

    @FindBy(xpath = "//div[@x-ng-include='registrationFlightsOneOffTemplate']//form[@name='uploadRegistrationFlightsForm']//div//input[@name='file']")
    public WebElement INDIVIDUAL_BROWSE_BTN;
    @FindBy(xpath = "//div[@x-ng-include='registrationFlightsOneOffTemplate']//form[@name='uploadRegistrationFlightsForm']//div//input[@value='Upload']")
    public WebElement INDIVIDUAL_UPLOAD_BTN;


    public ImportTravelPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to select travel import value
     */
    public void selectTravelImportValue(String importValue) throws Exception {
        Wait(TRAVEL_DATA_DROPDOWN, 30);
        select(TRAVEL_DATA_DROPDOWN, importValue);
        logReport("'" + importValue + "' select successfully");

    }

    /**
     * Method to select image
     *
     * @param  : Page object of ImportTravel.
     * @throws Exception
     */
    public void selectFile(String fileName, WebElement e) throws Exception {
        File file = new File("target/test-classes/files/" + fileName);
        String absolutePath = file.getAbsolutePath();

        e.sendKeys(absolutePath);
        logReport("Absolute Path = " + absolutePath);


    }

    /**
     * Method to click on upload button.
     *
     * @return : ImportPreBookedFlightPage.
     */
    public void clickUploadButton(WebElement e) {
        click(e);
        logReport("Upload button clicked successfully");
        VerifyAngularHasFinishedProcessing(30);
    }

    public ImportPreBookedFlightPage importFlightData(String importValue, String fileName) throws Exception {
        selectTravelImportValue(importValue);
        if (importValue.equalsIgnoreCase("Flights")) {
            selectFile(fileName, FLIGHTS_BROWSE_BTN);
            clickUploadButton(FLIGHTS_UPLOAD_BTN);
        } else if (importValue.equalsIgnoreCase("Flight Inventory")) {
            selectFile(fileName, FLIGHTSINVEMTORY_BROWSE_BTN);
            clickUploadButton(FLIGHTSINVENTORY_UPLOAD_BTN);
        } else if (importValue.equalsIgnoreCase("Attendee Pre-Booked Flight Reservations")) {
            selectFile(fileName, PREBOOKED_BROWSE_BTN);
            clickUploadButton(PREBOOKED_UPLOAD_BTN);
        } else if (importValue.equalsIgnoreCase("Attendee Individual Flight Reservations")) {
            selectFile(fileName, INDIVIDUAL_BROWSE_BTN);
            clickUploadButton(INDIVIDUAL_UPLOAD_BTN);
        }

        return new ImportPreBookedFlightPage(browser);

    }
}
