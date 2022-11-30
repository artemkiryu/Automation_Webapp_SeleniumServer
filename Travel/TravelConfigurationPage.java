package pageObjects.Travel;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;


/**
 * Created by infoobjects on 21-08-2017.
 */
public class TravelConfigurationPage extends CommonActionsPage {
    @FindBy(xpath = "//input[@x-ng-model='flightBookingStatus.name']")
    public WebElement BOOKING_STATUS_TEXTBOX;
    @FindBy(xpath = "//i[@class='fa fa-check-square-o'][@title='Save Booking Status']")
    public WebElement SAVE_BOOKING_STATUS_ICON;
    @FindBy(xpath = "//input[@x-ng-model='paymentStatus.name']")
    public WebElement PAYMENT_CODE_TEXTBOX;
    @FindBy(xpath = "//i[@class='fa fa-check-square-o'][@title='Save Payment Code']")
    public WebElement SAVE_PAYMENT_CODE_ICON;
    @FindBy(xpath = "//input[@x-ng-model='flightReservationType.name']")
    public WebElement TRAVEL_TYPE_TEXTBOX;
    @FindBy(xpath = "//i[@class='fa fa-check-square-o'][@title='Save Travel Type']")
    public WebElement SAVE_TRAVEL_TYPE_ICON;
    @FindBy(xpath = "//input[@x-ng-model='actionStatus.name']")
    public WebElement TRAVEL_CODE_TEXTBOX;
    @FindBy(xpath = "//i[@class='fa fa-check-square-o'][@title='Save Travel Action Code']")
    public WebElement SAVE_TRAVEL_CODE_ICON;
    @FindBy(xpath = "//input[@x-ng-model='addTransportation.name']")
    public WebElement TRANSPORTATION_TYPE_TEXTBOX;
    @FindBy(xpath = "//input[@title='Add Transportation Type']")
    public WebElement ADD_TRANSPORTATION_TYPE_BUTTON;
    @FindBy(xpath = "//select[@title='Mode of Transport']")
    public WebElement TRANSPORTATION_TYPE_DROPDOWN;
    @FindBy(xpath = "//input[@id='travel-airport-save']")
    public WebElement EVENT_AIRPORTS_SAVE;
    @FindBy(xpath = "//select[@x-ng-model='transport.type']")
    public WebElement TRANSPORTATION_TYPE_DROPDOWN_AFTEREDIT;
    @FindBy(xpath = "//input[@x-ng-model='transport.name']")
    public WebElement TRANSPORTATION_TYPE_TEXTBOX_AFTEREDIT;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Flights']")
    public WebElement FLIGHTS_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Import']")
    public WebElement IMPORT_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Flight Packages']")
    public WebElement FLIGHT_PACKAGES_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Configure']")
    public WebElement CONFIGURE_TAB;

    public TravelConfigurationPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void enterBookingStatusValue(String bookingStatus) throws Exception {
        Wait(BOOKING_STATUS_TEXTBOX, 10);
        type(BOOKING_STATUS_TEXTBOX, bookingStatus, true);
        logReport("Entered booking status value " + bookingStatus);
    }

    public void saveBookingStatus() {
        click(SAVE_BOOKING_STATUS_ICON);
        logReport("Save booking status icon clicked successfully");
        VerifyAngularHasFinishedProcessing(20);
    }

    public void enterPaymentCodeValue(String paymentCode) throws Exception {
        Wait(PAYMENT_CODE_TEXTBOX, 10);
        type(PAYMENT_CODE_TEXTBOX, paymentCode, true);
        logReport("Entered payment code value " + paymentCode);
    }

    public void savePaymentCodeIcon() {
        click(SAVE_PAYMENT_CODE_ICON);
        logReport("Save payment code icon clicked successfully");
        VerifyAngularHasFinishedProcessing(20);
    }

    public void enterTravelTypeValue(String travelType) throws Exception {
        Wait(TRAVEL_TYPE_TEXTBOX, 10);
        type(TRAVEL_TYPE_TEXTBOX, travelType, true);
        logReport("Entered travel type value " + travelType);
    }

    public void saveTravelTypeIcon() {
        click(SAVE_TRAVEL_TYPE_ICON);
        logReport("Save travel type icon clicked successfully");
        VerifyAngularHasFinishedProcessing(20);
    }

    public void enterTravelActionCodeValue(String code) throws Exception {
        Wait(TRAVEL_CODE_TEXTBOX, 10);
        type(TRAVEL_CODE_TEXTBOX, code, true);
        logReport("Entered travel action code value " + code);
    }

    public void saveTravelActionCodeIcon() {
        click(SAVE_TRAVEL_CODE_ICON);
        logReport("Save travel action code icon clicked successfully");
        VerifyAngularHasFinishedProcessing(20);
    }

    public void selectModeOfTransportationType(String modeType) {
        select(TRANSPORTATION_TYPE_DROPDOWN, modeType);
        logReport("Selected mode of transportation type" + modeType);

    }

    public void clickAddTransportationType() {
        click(ADD_TRANSPORTATION_TYPE_BUTTON);
        logReport("Add Transportation type button clicked successfully");
        VerifyAngularHasFinishedProcessing(20);
    }

    public void enterTransportationText(String transportation) {
        type(TRANSPORTATION_TYPE_TEXTBOX, transportation, true);
        logReport("Entered transportation value" + transportation);
    }

    public void clickEditTransportationType(String modeType, String transportationType) {
        String xpath = "//form[@name='editTransportationForm']//table//td[1]/span[text()='" + modeType + "']/../..//td[2]/span[text()='" + transportationType + "']/../..//img[@title='Edit Transportation Type']";
        browser.findElement(By.xpath(xpath)).click();
        logReport("Edit transportation type " + modeType + "transportation type" + transportationType);
    }

    public void clickDeleteTransportationType(String modeType, String transportationType) {
        String xpath = "//form[@name='editTransportationForm']//table//td[1]/span[text()='" + modeType + "']/../..//td[2]/span[text()='" + transportationType + "']/../..//img[@title='Delete Transportation Type']";
        click(browser.findElement(By.xpath(xpath)));
        logReport("Edit transportation type " + modeType + "transportation type" + transportationType);
    }

    public void selectTransportationTypeAfterEdit(String type) {
        select(TRANSPORTATION_TYPE_DROPDOWN_AFTEREDIT, type);
        logReport("Selected transportation type" + type);
    }

    public void editTransportationName(String name) {
        type(TRANSPORTATION_TYPE_TEXTBOX_AFTEREDIT, name, true);
        logReport("Transportation name edited" + name);
    }

    public void saveTransportationType() {
        String xpath = "//img[@title='Save Transportation Type'][@class != 'ng-hide']";
        WebElement element = browser.findElement(By.xpath(xpath));
        click(element);
        logReport("Edited data saved successfully");
        VerifyAngularHasFinishedProcessing(20);
    }

    public boolean isEditTransportationTypePresent(String modeType, String transportationType) {
        String xpath = "//form[@name='editTransportationForm']//table//td[1]/span[text()='" + modeType + "']/../..//td[2]/span[text()='" + transportationType + "']/../..//img[@title='Edit Transportation Type']";
        return isElementDisplayed(By.xpath(xpath), browser);

    }

    public boolean isDeleteTransportationTypePresent(String modeType, String transportationType) {
        String xpath = "//form[@name='editTransportationForm']//table//td[1]/span[text()='" + modeType + "']/../..//td[2]/span[text()='" + transportationType + "']/../..//img[@title='Delete Transportation Type']";
        return isElementDisplayed(By.xpath(xpath), browser);

    }

    public void closeMessageBox() {
        String xpath = "//div[@class='ui-pnotify-closer']//span";
        if (verifyElementDisplayed(browser.findElement(By.xpath(xpath)), 10)) {
            click(browser.findElement(By.xpath(xpath)));
            logReport("Message box closed");
        }
        logReport("Message box not present");
    }

    public void clickEventAirportsSave() throws Exception {
        Wait(EVENT_AIRPORTS_SAVE, 20);
        click(EVENT_AIRPORTS_SAVE);
        logReport("Event Airports button clicked successfully");
        VerifyPageReady(20);
    }

    /**
     * Method to click on flight tab.
     *
     * @return : FlightsTravelPage
     */
    public FlightsTravelPage clickFlightsTab() throws Exception {
        Wait(FLIGHTS_TAB, 20);
        click(FLIGHTS_TAB);
        VerifyAngularHasFinishedProcessing(20);
        return new FlightsTravelPage(browser);
    }

    public TravelConfigurationPage clickConfigureTab() throws Exception {
        Wait(CONFIGURE_TAB, 20);
        click(CONFIGURE_TAB);
        VerifyAngularHasFinishedProcessing(20);
        return new TravelConfigurationPage(browser);
    }

    /**
     * Method to click on flight tab.
     *
     * @return : FlightsTravelPage
     */
    public ImportTravelPage clickImportTab() throws Exception {
        Wait(IMPORT_TAB, 20);
        click(IMPORT_TAB);
        VerifyAjaxRequestsFinished(20);
        VerifyAngularHasFinishedProcessing(20);
        return new ImportTravelPage(browser);
    }

    /**
     * Method for clicking flight packages tab
     *
     * @return FlightPackagesPage
     */
    public FlightPackagesPage clickFlightPackagesTab() throws Exception {
        Wait(FLIGHT_PACKAGES_TAB, 20);
        click(FLIGHT_PACKAGES_TAB);
        VerifyAjaxRequestsFinished(20);
        VerifyAngularHasFinishedProcessing(20);
        return new FlightPackagesPage(browser);
    }
}
