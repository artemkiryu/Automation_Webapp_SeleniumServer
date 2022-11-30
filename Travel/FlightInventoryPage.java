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
import pojo.TravelConfigurationData;

import java.util.List;

/**
 * Created by infoobjects on 21-08-2017.
 */
public class FlightInventoryPage extends CommonActionsPage {
    public static final By DROP_DOWN_OPTIONS_LIST = By.xpath("//div[@id='select2-drop']//ul[@class='select2-results']//li//div");
    @FindBy(xpath = "//label[text()='Seat Block ID']//..//div//input")
    public WebElement SEAT_BLOCKID_TEXTBOX;

    @FindBy(xpath = "//label[text()='Reference Number']//..//div//input")
    public WebElement REFERENCE_NUMBER_TEXTBOX;

    @FindBy(xpath = "//label[text()='Inventory']//..//div//input")
    public WebElement INVENTORY_TEXTBOX;

    @FindBy(xpath = "//label[contains(.,'Travel Tax')]//..//div//input")
    public WebElement TRAVEL_TAX_TEXTBOX;

    @FindBy(xpath = "//label[contains(.,'Total Amount')]//..//div//input")
    public WebElement TOTAL_AMOUNT_TEXTBOX;

    @FindBy(xpath = "//label[text()='Flight Class']//..//div//div[1]//a//span[@class='select2-arrow']")
    public WebElement FLIGHT_CLASS_DROPDOWN_ARROW;
    @FindBy(xpath = "//div[@class='select2-search']//input[contains(@id,'autogen')]")
    public List<WebElement> INPUT_LIST_DROP_DOWN;
    @FindBy(xpath = "//label[text()='Travel Type']//..//div//div[1]//a//span[@class='select2-arrow']")
    public WebElement TRAVEL_TYPE_DROPDOWN_ARROW;
    @FindBy(xpath = "//label[text()='Action Code']//..//div//div[1]//a//span[@class='select2-arrow']")
    public WebElement ACTION_CODE_DROPDOWN_ARROW;
    @FindBy(xpath = "//label[text()='Booking Status']//..//div//div[1]//a//span[@class='select2-arrow']")
    public WebElement BOOKING_STATUS_DROPDOWN_ARROW;
    @FindBy(xpath = "//label[text()='Note']//..//div//textarea")
    public WebElement NOTES_TEXTAREA;
    @FindBy(xpath = "//button[text()='Save']")
    public WebElement SAVE_BUTTON;

    public FlightInventoryPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for entering seat block number of flight
     *
     * @param seatNumber value of seat block number
     */
    private void enterSeatBlock(String seatNumber) throws Exception {
        Wait(SEAT_BLOCKID_TEXTBOX, 20);
        type(SEAT_BLOCKID_TEXTBOX, seatNumber, true);
        logReport("entered seat block id " + seatNumber);
    }

    /**
     * Method for entering reference number
     *
     * @param refNumber value of ref number
     */
    private void enterReferenceNumber(String refNumber) {
        type(REFERENCE_NUMBER_TEXTBOX, refNumber, true);
        logReport("entered ref number " + refNumber);
    }

    /**
     * Method for entering inventory
     *
     * @param inventory value of inventory
     */
    private void enterInventory(String inventory) {
        type(INVENTORY_TEXTBOX, inventory, true);
        logReport("entered inventory no " + inventory);
    }

    /**
     * Method for clicking save button
     *
     * @return FlightsTravelPage
     */
    public FlightsTravelPage clickSaveButton() throws Exception {
        click(SAVE_BUTTON);
        VerifyPageReady(30);
        logReport("Save Flight data successfully");
        return new FlightsTravelPage(browser);
    }

    /**
     * Method for edit flight inventory
     *
     * @param importTravel Page object of ImportTravel
     */
    public FlightsTravelPage editFlightInventory(ImportTravel importTravel) throws Exception {
        enterSeatBlock(importTravel.getFlightInventory().getSeatBlockId());
        enterReferenceNumber(importTravel.getFlightInventory().getReferenceNumber());
        enterInventory(importTravel.getFlightInventory().getInventory());
        enterTotalAmount(importTravel.getFlightInventory().getTotalAmount());
        enterTravelTax(importTravel.getFlightInventory().getTravelTax());
        //selectFlightClass(importTravel.getFlightInventory().getFlightClass());
        //selectTravelType(importTravel.getFlightInventory().getTravelType());
        //selectActionCode(importTravel.getFlightInventory().getActionCode());
        // selectBookingStatus(importTravel.getFlightInventory().getBookingStatus());
        enterNote(importTravel.getFlightInventory().getNote());
        clickSaveButton();
        return new FlightsTravelPage(browser);
    }

    public void fillFlightInventory(ImportTravel importTravel, TravelConfigurationData travelConfigurationData) throws Exception {
        enterSeatBlock(importTravel.getFlightInventory().getSeatBlockId());
        enterReferenceNumber(importTravel.getFlightInventory().getReferenceNumber());
        enterInventory(importTravel.getFlightInventory().getInventory());
        enterTotalAmount(importTravel.getFlightInventory().getTotalAmount());
        enterTravelTax(importTravel.getFlightInventory().getTravelTax());
        selectFlightClass(importTravel.getFlightInventory().getFlightClass());
        selectTravelType(travelConfigurationData.getTravelType());
        selectActionCode(travelConfigurationData.getTravelActionCode());
        selectBookingStatus(travelConfigurationData.getBookingStatus());
        enterNote(importTravel.getFlightInventory().getNote());

    }

    /**
     * Method for entering total amount
     *
     * @param totalAmount value of total amount
     */
    private void enterTotalAmount(String totalAmount) {
        type(TOTAL_AMOUNT_TEXTBOX, totalAmount, true);
        logReport("entered total amount " + totalAmount);
    }

    /**
     * Method for entering travel tax
     *
     * @param travelTax value of travel tax
     */
    private void enterTravelTax(String travelTax) {
        type(TRAVEL_TAX_TEXTBOX, travelTax, true);
        logReport("entered travel tax " + travelTax);
    }

    /**
     * Method for entering notes
     *
     * @param note value of notes
     */
    private void enterNote(String note) {
        type(NOTES_TEXTAREA, note);
        logReport("entered note " + note);
    }

    private void selectFlightClass(String flightType) {
        if (flightType == null || flightType == "") {
            return;
        } else {
            click(FLIGHT_CLASS_DROPDOWN_ARROW);
            // String newAirline[] = flightType.split("-");

            // String airlineType = newAirline[0].replace(" ", "");
            List<WebElement> optionsList = browser.findElements(DROP_DOWN_OPTIONS_LIST);

            for (WebElement element : optionsList) {
                if (element.getText().equals(flightType)) {
                    element.click();
                    logReport("Selected flight class = " + flightType);
                    return;
                }
            }

        }
    }

    private void selectTravelType(String travelType) throws Exception {
        if (travelType == null || travelType == "") {
            return;
        } else {
            click(TRAVEL_TYPE_DROPDOWN_ARROW);
            // String newAirline[] = flightType.split("-");

            // String airlineType = newAirline[0].replace(" ", "");
            List<WebElement> inputBoxList = INPUT_LIST_DROP_DOWN;

            for (WebElement element : inputBoxList) {
                if (element.isDisplayed()) {
                    element.sendKeys(travelType);
                    elementsNumberEqual(1, DROP_DOWN_OPTIONS_LIST, 10);
                    VerifyAjaxRequestsFinished(20);
                    element.sendKeys(Keys.TAB);
                }
            }
            logReport("Selected travel type = " + travelType);
        }
    }

    private void selectActionCode(String actionCode) throws Exception {
        if (actionCode == null || actionCode == "") {
            return;
        } else {
            click(ACTION_CODE_DROPDOWN_ARROW);
            // String newAirline[] = flightType.split("-");

            // String airlineType = newAirline[0].replace(" ", "");
            List<WebElement> inputBoxList = INPUT_LIST_DROP_DOWN;

            for (WebElement element : inputBoxList) {
                if (element.isDisplayed()) {
                    element.sendKeys(actionCode);
                    elementsNumberEqual(1, DROP_DOWN_OPTIONS_LIST, 10);
                    VerifyAjaxRequestsFinished(20);
                    element.sendKeys(Keys.TAB);
                }
            }
            logReport("Selected action code = " + actionCode);
        }
    }

    private void selectBookingStatus(String bookingStatus) throws Exception {
        if (bookingStatus == null || bookingStatus == "") {
            return;
        } else {
            click(BOOKING_STATUS_DROPDOWN_ARROW);
            // String newAirline[] = flightType.split("-");

            // String airlineType = newAirline[0].replace(" ", "");
            List<WebElement> inputBoxList = INPUT_LIST_DROP_DOWN;

            for (WebElement element : inputBoxList) {
                if (element.isDisplayed()) {
                    element.sendKeys(bookingStatus);
                    elementsNumberEqual(1, DROP_DOWN_OPTIONS_LIST, 10);
                    VerifyAjaxRequestsFinished(20);
                    element.sendKeys(Keys.TAB);
                }
            }
            logReport("Selected booking status = " + bookingStatus);
        }
    }


}
