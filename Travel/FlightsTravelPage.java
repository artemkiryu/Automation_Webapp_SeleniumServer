package pageObjects.Travel;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.ImportTravel;
import java.util.List;

/**
 * Created by infoobjects on 21-08-2017.
 */
public class FlightsTravelPage extends CommonActionsPage {
    public static final By DROP_DOWN_OPTIONS_LIST = By.xpath("//div[@id='select2-drop']//ul[@class='select2-results']//li//div");
    @FindBy(xpath = "//input[@value='Add New']")
    public WebElement ADD_NEW_BTN;
    @FindBy(xpath = "//select[@class='flight-select ng-pristine ng-valid select2-offscreen']")
    public WebElement INBOUND_DROPDOWN;
    @FindBy(xpath = "//label[text()='Flight Code']//..//div//input")
    public WebElement FLIGHT_CODE_TEXTBOX;
    @FindBy(xpath = "//label[text()='Description']//..//div//input")
    public WebElement DESCRIPTION_TEXTBOX;
    @FindBy(xpath = "//label[text()='Airline']//..//div//div[1]//a//span[@class='select2-arrow']")
    public WebElement AIRLINE_DROPDOWN_ARROW;
    @FindBy(xpath = "//div[@class='select2-search']//input[contains(@id,'autogen')]")
    public List<WebElement> INPUT_LIST_DROP_DOWN;
    @FindBy(xpath = "//label[text()='Aircraft Type']//..//div//div[1]//a//span[@class='select2-arrow']")
    public WebElement AIRCRAFT_TYPE_DROPDOWN_ARROW;
    @FindBy(xpath = "//label[text()='Departure Date/Time']//..//div//input[@name='departureDate']")
    public WebElement DEPARTURE_DATE_TEXTBOX;
    @FindBy(xpath = "//label[text()='Departure Date/Time']//..//div//input[@class='form-control ng-pristine ng-valid']")
    public WebElement DEPARTURE_TIME_TEXTBOX;
    @FindBy(xpath = "//label[text()='Departure Terminal']//..//div//input")
    public WebElement DEPARTURE_TERMINAL_TEXTBOX;
    @FindBy(xpath = "//label[text()='Departure Gate']//..//div//input")
    public WebElement DEPARTURE_GATE_TEXTBOX;
    @FindBy(xpath = "//label[text()='Departure Port']//..//div//div[1]//a//span[@class='select2-arrow']")
    public WebElement DEPARTURE_PORT_DROPDOWN_ARROW;
    @FindBy(xpath = "//label[text()='Arrival Port']//..//div//div[1]//a//span[@class='select2-arrow']")
    public WebElement ARRIVAL_PORT_DROPDOWN_ARROW;
    @FindBy(xpath = "//label[text()='Arrival Date/Time']//..//div//input[@x-ng-model='flight.arrival.date']")
    public WebElement ARRIVAL_DATE_TEXTBOX;
    @FindBy(xpath = "//label[text()='Arrival Date/Time']//..//div//input[@class='form-control ng-pristine ng-valid']")
    public WebElement ARRIVAL_TIME_TEXTBOX;
    @FindBy(xpath = "//label[text()='Arrival Terminal']//..//div//input")
    public WebElement ARRIVAL_TERMINAL_TEXTBOX;
    @FindBy(xpath = "//label[text()='Arrival Gate']//..//div//input")
    public WebElement ARRIVAL_GATE_TEXTBOX;
    @FindBy(xpath = "//label[text()='Duration']//..//div//input")
    public WebElement DURATION_TEXTBOX;
    @FindBy(xpath = "//label[text()='Distance']//..//div//input")
    public WebElement DISTANCE_TEXTBOX;
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//input[@value='Save & Close']")
    public WebElement SAVE_AND_CLOSE_BUTTON;
    @FindBy(xpath = "//i[@title='Communication & Change History']")
    public WebElement COMMUNICATION_HISTORY_ICON;
    @FindBy(xpath = "//div[@id='flight-filter']//span[@class='select2-arrow']")
    public WebElement FLIGHTS_FILTER_DROPDOWN_ARROW;
    @FindBy(xpath = "//form/div[3]//span[@class='select2-arrow']")
    public WebElement FILTER_VALUE_DROPDOWN_ARROW;
    @FindBy(xpath = "//form/div[2]/input")
    public WebElement FILTER_VALUE_TEXTBOX;
    @FindBy(xpath = "//table[@id='flight-list-table']//tbody//tr")
    public WebElement FLIGHT_LIST_TABLE_ROW;

    public FlightsTravelPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for clicking add new button
     */
    public void addNewButton() throws Exception {
        Wait(ADD_NEW_BTN, 10);
        click(ADD_NEW_BTN);
        VerifyPageReady(20);
        logReport("Clicked on ADD NEW Button");
    }

    /**
     * Method for select inbound type
     *
     * @param inbound value of inbound
     */
    private void selectInboundType(String inbound) {
        select(INBOUND_DROPDOWN, inbound);
        logReport("selected inbound value " + inbound);
    }

    /**
     * Method for entering flight code
     *
     * @param code value of flight code
     */
    public void enterFlightCode(String code) {
        type(FLIGHT_CODE_TEXTBOX, code, true);
        logReport("entered flight code value " + code);
    }

    /**
     * Method for select airline type
     *
     * @param airline value of airline
     */
    private void selectAirlineType(String airline) throws Exception {
        click(AIRLINE_DROPDOWN_ARROW);
        String newAirline[] = airline.split("-");

        String airlineType = newAirline[0].replace(" ", "");
        List<WebElement> inputBoxList = INPUT_LIST_DROP_DOWN;

        for (WebElement element : inputBoxList) {
            if (element.isDisplayed()) {
                element.sendKeys(airlineType);
                elementsNumberEqual(1, DROP_DOWN_OPTIONS_LIST, 10);
                VerifyAjaxRequestsFinished(20);
                element.sendKeys(Keys.TAB);
            }
        }
        logReport("Selected airline type = " + airline);
    }

    /**
     * Method for select departure date
     *
     * @param dateValue value of date
     */
    private void selectDepartureDate(String dateValue) {
        //webDriver.type(DEPARTURE_DATE_TEXTBOX, dateValue);
        DEPARTURE_DATE_TEXTBOX.sendKeys(dateValue);
        logReport("selected departure date is" + dateValue);
    }

    /**
     * Method for select departure time
     *
     * @param timeValue value of time
     */
    private void selectDepartureTime(String timeValue) {
        type(DEPARTURE_TIME_TEXTBOX, timeValue);
        logReport("selected departure time is" + timeValue);
    }

    /**
     * Method for select departure port type
     *
     * @param departurePort value of port
     */
    private void selectDeparturePort(String departurePort) throws Exception {
        click(DEPARTURE_PORT_DROPDOWN_ARROW);
        String newport[] = departurePort.split("-");
        String portType = newport[0].replace(" ", "");
        List<WebElement> inputBoxList = INPUT_LIST_DROP_DOWN;

        for (WebElement element : inputBoxList) {
            if (element.isDisplayed()) {
                element.sendKeys(portType);
                elementsNumberEqual(1, DROP_DOWN_OPTIONS_LIST, 10);
                VerifyAjaxRequestsFinished(20);
                element.sendKeys(Keys.TAB);
            }
        }
        logReport("Selected departure port = " + departurePort);
    }

    /**
     * Method for select arrival date
     *
     * @param dateValue value of date
     */
    private void selectArrivalDate(String dateValue) {
        //webDriver.type(ARRIVAL_DATE_TEXTBOX, dateValue);
        ARRIVAL_DATE_TEXTBOX.sendKeys(dateValue);
        logReport("selected arrival date is" + dateValue);
    }

    /**
     * Method for select arrival time
     *
     * @param timeValue value of time
     */
    private void selectArrivalTime(String timeValue) {
        type(ARRIVAL_TIME_TEXTBOX, timeValue);
        logReport("selected arrival time is" + timeValue);
    }

    /**
     * Method for select arrival port type
     *
     * @param arrivalPort value of arrival port
     */
    private void selectArrivalPort(String arrivalPort) throws Exception {
        click(ARRIVAL_PORT_DROPDOWN_ARROW);
        String newport[] = arrivalPort.split("-");
        String portType = newport[0].replace(" ", "");
        List<WebElement> inputBoxList = INPUT_LIST_DROP_DOWN;

        for (WebElement element : inputBoxList) {
            if (element.isDisplayed()) {
                element.sendKeys(portType);
                elementsNumberEqual(1, DROP_DOWN_OPTIONS_LIST, 20);
                VerifyAjaxRequestsFinished(20);
                element.sendKeys(Keys.TAB);
            }
        }
        logReport("Selected arrival port = " + arrivalPort);
    }

    /**
     * Method for clicking save button for save flight
     */
    public void clickSaveButton() throws Exception {
        Wait(SAVE_BUTTON, 20);
        click(SAVE_BUTTON);
        VerifyPageReady(20);
        VerifyAngularHasFinishedProcessing(20);
        logReport("Save button clicked successfully");
    }

    public void clickSaveAndCloseButton() throws Exception {
        click(SAVE_AND_CLOSE_BUTTON);
        VerifyPageReady(20);
        VerifyAngularHasFinishedProcessing(20);
        logReport("Save and close button clicked successfully");
    }

    /**
     * Method for clicking save button for save flight
     */
    public void clickSaveButtonWithoutAngular() throws Exception {
        click(SAVE_BUTTON);
        VerifyPageReady(20);
        logReport("Save button clicked successfully");
    }

    /**
     * Method for create flight
     *
     * @param importTravel Page object of ImportTravel
     */
    public void createFlight(ImportTravel importTravel) throws Exception {
        addNewButton();
        selectInboundType(importTravel.getFlight().getInboundType());
        enterFlightCode(importTravel.getFlight().getFlightCode());
        enterDescription(importTravel.getFlight().getDescription());
        selectAirlineType(importTravel.getFlight().getAirline());
        selectAircraftType(importTravel.getFlight().getAircraft());
        selectDepartureDate(importTravel.getFlight().getDepartureDate());
        selectDepartureTime(importTravel.getFlight().getDepartureTime());
        selectDeparturePort(importTravel.getFlight().getDeparturePort());
        enterDepartureTerminal(importTravel.getFlight().getDepartureTerminal());
        enterDepartureGate(importTravel.getFlight().getDepartureGate());
        selectArrivalDate(importTravel.getFlight().getArrivalDate());
        selectArrivalTime(importTravel.getFlight().getArrivalTime());
        selectArrivalPort(importTravel.getFlight().getArrivalPort());
        enterArrivalTerminal(importTravel.getFlight().getArrivalTerminal());
        enterArrivalGate(importTravel.getFlight().getArrivalGate());
        enterDuration(importTravel.getFlight().getDuration());
        enterDistance(importTravel.getFlight().getDistance());
        clickSaveButton();
        editRowByFlightCode(importTravel.getFlight().getFlightCode());

    }

    public void fillFlightData(ImportTravel importTravel) throws Exception {
        selectInboundType(importTravel.getFlight().getInboundType());
        enterFlightCode(importTravel.getFlight().getFlightCode());
        enterDescription(importTravel.getFlight().getDescription());
        selectAirlineType(importTravel.getFlight().getAirline());
        selectAircraftType(importTravel.getFlight().getAircraft());
        selectDepartureDate(importTravel.getFlight().getDepartureDate());
        selectDepartureTime(importTravel.getFlight().getDepartureTime());
        selectDeparturePort(importTravel.getFlight().getDeparturePort());
        enterDepartureTerminal(importTravel.getFlight().getDepartureTerminal());
        enterDepartureGate(importTravel.getFlight().getDepartureGate());
        selectArrivalDate(importTravel.getFlight().getArrivalDate());
        selectArrivalTime(importTravel.getFlight().getArrivalTime());
        selectArrivalPort(importTravel.getFlight().getArrivalPort());
        enterArrivalTerminal(importTravel.getFlight().getArrivalTerminal());
        enterArrivalGate(importTravel.getFlight().getArrivalGate());
        enterDuration(importTravel.getFlight().getDuration());
        enterDistance(importTravel.getFlight().getDistance());
    }

    /**
     * Method for edit flight by flight code
     *
     * @param flightCode value of flight code
     */
    public void editRowByFlightCode(String flightCode) throws Exception {
        VerifyPageReady(20);
        VerifyAjaxRequestsFinished(20);
        VerifyAngularHasFinishedProcessing(20);
        String xpath = "//table[@id='flight-list-table']//tbody//tr//td[text()='" + flightCode + "']//..//td//img[@title='Edit Flight']";
        click(browser.findElement(By.xpath(xpath)));
        VerifyPageReady(20);
        VerifyAngularHasFinishedProcessing(20);
        logReport("Row Edited Successfully by flight code" + flightCode);

    }

    /**
     * Method for click add new inventory button
     *
     * @return FlightInventoryPage
     */
    public FlightInventoryPage clickAddNewFlightInventory() throws Exception {
        Wait(ADD_NEW_BTN, 10);
        click(ADD_NEW_BTN);
        return new FlightInventoryPage(browser);
    }

    /**
     * Method for entering description of flight
     *
     * @param description value of flight description
     */
    private void enterDescription(String description) {
        type(DESCRIPTION_TEXTBOX, description, true);
        logReport("entered description " + description);
    }

    /**
     * Method for select aircraft type
     *
     * @param aircraft value of aircraft type
     */
    private void selectAircraftType(String aircraft) throws Exception {
        click(AIRCRAFT_TYPE_DROPDOWN_ARROW);
        String newAircraft[] = aircraft.split("- ");
        //String aircraftType = newAircraft[0].substring(0, newAircraft[0].length() - 1);
        List<WebElement> inputBoxList = INPUT_LIST_DROP_DOWN;

        for (WebElement element : inputBoxList) {
            if (element.isDisplayed()) {
                element.sendKeys(newAircraft[1]);
                elementsNumberEqual(1, DROP_DOWN_OPTIONS_LIST, 10);
                VerifyAjaxRequestsFinished(20);
                element.sendKeys(Keys.TAB);
            }
        }
        logReport("Selected airline type = " + aircraft);
    }

    /**
     * Method for entering departure terminal of flight
     *
     * @param departureTerminal value of departure terminal
     */
    private void enterDepartureTerminal(String departureTerminal) {
        type(DEPARTURE_TERMINAL_TEXTBOX, departureTerminal, true);
        logReport("entered Departure terminal " + departureTerminal);
    }

    /**
     * Method for entering departure gate of flight
     *
     * @param departureGate value of departure gate
     */
    private void enterDepartureGate(String departureGate) {
        type(DEPARTURE_GATE_TEXTBOX, departureGate, true);
        logReport("entered Departure gate " + departureGate);
    }

    /**
     * Method for entering arrival terminal of flight
     *
     * @param arrivalTerminal value of arrival terminal
     */
    private void enterArrivalTerminal(String arrivalTerminal) {
        type(ARRIVAL_TERMINAL_TEXTBOX, arrivalTerminal, true);
        logReport("entered arrival terminal " + arrivalTerminal);
    }

    /**
     * Method for entering arrival gate of flight
     *
     * @param arrivalGate value of arrival gate
     */
    private void enterArrivalGate(String arrivalGate) {
        type(ARRIVAL_GATE_TEXTBOX, arrivalGate, true);
        logReport("entered arrival gate " + arrivalGate);
    }

    /**
     * Method for entering duration of flight
     *
     * @param flightDuration value of duration i.e. 3h5m
     */
    private void enterDuration(String flightDuration) {
        type(DURATION_TEXTBOX, flightDuration, true);
        logReport("entered flight duration " + flightDuration);
    }

    /**
     * Method for distance of flights
     *
     * @param flightDistance value of flight distance
     */
    private void enterDistance(String flightDistance) {
        type(DISTANCE_TEXTBOX, flightDistance, true);
        logReport("entered distance " + flightDistance);
    }

    public void clickDeleteFlightIcon(String flightCode) throws Exception {
        String xpath = "//td[contains(.,'" + flightCode + "')]/..//td//img[@title='Delete Flight']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 20);
        click(element);
        logReport("Clicked On Flight Delete Icon.");
        switchToLatestTabOrWindow();


    }

    public void selectFilter(String filterName) throws Exception {
        String xpath = "//li//div[contains(text(),'" + filterName + "')]";
        click(FLIGHTS_FILTER_DROPDOWN_ARROW);
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 20);
        element.click();

    }

    public void selectFilterValue(String value) throws Exception {
        click(FILTER_VALUE_DROPDOWN_ARROW);
        String xpath = "//li/div[contains(text(),'" + value + "')]";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 20);
        element.click();
        VerifyAngularHasFinishedProcessing(20);
    }

    public void enterFilterValue(String value) throws Exception {
        type(FILTER_VALUE_TEXTBOX, value, true);
        logReport("Entered text :" + value + " in Flight Code filter");
    }

    public String getFlightCode() throws Exception {
        return browser.findElement(By.xpath("//table[@id='flight-list-table']//tbody//tr/td[7]")).getText().trim();
    }
}
