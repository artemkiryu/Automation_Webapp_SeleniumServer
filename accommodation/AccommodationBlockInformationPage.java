package pageObjects.Accommodation;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AccommodationBlockInformation;
import pojo.HotelData;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.List;
/**
 * Created by infoobjects on 8/23/2017.
 */
public class AccommodationBlockInformationPage extends CommonActionsPage {
    public static final By HOTEL_DROPDOWN_OPTIONS = By.xpath("//ul[contains(@id,'select2-results-2')]//li//div");
    public static final By ROOMTYPE_DROPDOWN_LIST = By.xpath("//input[@id='s2id_autogen4_search']");
    @FindBy(xpath = "//h3[text()='Accommodation Block Information']")
     public WebElement PAGE_ELEMENT;
    @FindBy(xpath = "//h3[text()='Accommodation Block Information']")
    public  WebElement PAGE_HEADER ;

    @FindBy(xpath = "//label[contains(.,'Start Date')]")
    public  WebElement LABEL_STARTDATE_TEXTBOX ;

    @FindBy(xpath = "//label[contains(.,'End Date')]")
    public  WebElement LABEL_ENDDATE_TEXTBOX ;

    @FindBy(xpath = "//label[text()='Inventory']")
    public  WebElement LABEL_INVENTORY_TEXTBOX ;

    @FindBy(xpath = "//label[text()='Room Rate $']")
    public  WebElement LABEL_ROOMRATE_TEXTBOX ;

    @FindBy(xpath = "//label[text()='Room Type']")
    public  WebElement LABEL_ROOMTYPE_TEXTBOX ;

    @FindBy(xpath = "//label[text()='Contracted']")
    public  WebElement LABEL_CONTRACTED_TEXTBOX ;

    @FindBy(xpath = "//label[text()='Show Block Online']")
    public  WebElement LABEL_SHOWBLOCKONLINE_CHECKBOX ;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']")
    public  WebElement DATE_CALENDAR ;

    @FindBy(xpath = "//strong[@class='ng-binding']")
    public  WebElement HOTEL_CODE_LABEL ;

    @FindBy(xpath = "//span[contains(.,'Room Type')]")
    public  WebElement ROOM_TYPE_DETAILS ;

    @FindBy(xpath = "//label[text()='Override Info']")
    public  WebElement LABEL_OVERRIDE_CHECKBOX ;

    @FindBy(xpath = "//div[@id='s2id_autogen1']//a//span[@class='select2-arrow']")
    public  WebElement HOTEL_DROPDOWN_ARROW ;



    @FindBy(xpath = "//input[@id='s2id_autogen2_search']")
    public  WebElement HOTEL_DROPDOWN_LIST ;

    @FindBy(xpath = "//div[@id='s2id_autogen3']//a//span[@class='select2-arrow']")
    public  WebElement ROOMTYPE_DROPDOWN_ARROW ;

    public static final By ROOMTYPE_DROPDOWN_OPTION = By.xpath("//ul[contains(@id,'select2-results-4')]//li//div");

    @FindBy(xpath = "//input[@name='startDate']")
    public  WebElement START_DATE_TEXTBOX ;

    @FindBy(xpath = "//input[@name='endDate']")
    public  WebElement END_DATE_TEXTBOX ;

    @FindBy(xpath = "//input[@x-ng-model='blockInfo.defaultInventory']")
    public  WebElement INVENTORY_TEXTBOX ;

    @FindBy(xpath = "//input[@x-ng-model='blockInfo.defaultOriginalInv']")
    public  WebElement CONTRACTED_TEXTBOX ;

    @FindBy(xpath = "//input[@x-ng-model='blockInfo.defaultRate']")
    public  WebElement ROOM_RATE_TEXTBOX ;

    @FindBy(xpath = "//input[@x-ng-model='blockInfo.showOnline']")
    public WebElement SHOW_ONLINE_CHECKBOX ;

    @FindBy(xpath = "//button[text()='Save']")
    public  WebElement SAVE_BUTTON ;

    @FindBy(xpath = "//label[contains(@class,'requiredField')]")
    public  WebElement REQUIRED_FIELD ;

    @FindBy(xpath = "//label[contains(.,'Hotel')]")
    public  WebElement LABEL_HOTEL_TEXTBOX ;

    @FindBy(xpath = "//input[@x-ng-model='blockInfo.overwriteUpdate']")
    public  WebElement OVERRIDE_CHECKBOX ;

    @FindBy(xpath = "//label[contains(.,'Room Rate')]")
    public  WebElement ROOM_RATE_LABEL ;

    @FindBy(xpath = "//button[text()='Cancel']")
    public  WebElement CANCEL_BUTTON ;

    @FindBy(xpath = "//div[@class='col-sm-12 well']//li/../..//div")
    public  WebElement ATTENDEE_TYPE_TAG ;
    @FindBy(xpath = "//label[text()=' Start Date']//i[@class='fa fa-calendar']")
    public  WebElement START_DATE_CALANDER ;

    @FindBy(xpath = "//label[contains(text(),'End Date')]//i[@class='fa fa-calendar']")
    public  WebElement END_DATE_CALANDER ;
    public AccommodationBlockInformationPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for selecting hotel in hotel dropdown.
     *
     * @param hotelName : name of the hotel which we need to select
     */

    private void selectHotel(String hotelName) throws Exception{
        Wait(HOTEL_DROPDOWN_ARROW, 30);
        click(HOTEL_DROPDOWN_ARROW);
        //  webDriver.waitFor().elementsAreMoreThan(5, HOTEL_DROPDOWN_OPTIONS);

        List<WebElement> inputBoxList = browser.findElements(By.xpath("//input[@id='s2id_autogen2_search']"));

        for (WebElement element : inputBoxList) {
            if (element.isDisplayed()) {
                element.sendKeys(hotelName);
                elementsNumberEqual(1, HOTEL_DROPDOWN_OPTIONS,10);
                VerifyAjaxRequestsFinished(30);
                element.sendKeys(Keys.TAB);
            }
        }
        reporter.info("Selected room type code = " + hotelName);
    }


    /**
     * Method for selecting room type in room type dropdown.
     *
     * @param roomType : name of the room which we need to select.
     */
    private void selectRoomType(String roomType)throws Exception{
        click(ROOMTYPE_DROPDOWN_ARROW);
        //    webDriver.waitFor().elementsAreMoreThan(5, ROOMTYPE_DROPDOWN_OPTION);

        List<WebElement> inputBoxList = browser.findElements(ROOMTYPE_DROPDOWN_LIST);

        for (WebElement element : inputBoxList) {
            if (element.isDisplayed()) {
                element.sendKeys(roomType);
                elementsNumberEqual(1, ROOMTYPE_DROPDOWN_OPTION, 10);
               VerifyAjaxRequestsFinished(30);
                element.sendKeys(Keys.TAB);
            }
        }
        reporter.info("Selected room type code = " + roomType);
    }

    /**
     * Method for selecting start date from start date datepicker.
     *
     * @param startDate : start date of accommodation block.
     */
    private void enterStartDate(String startDate) {
        type(START_DATE_TEXTBOX, startDate);
        reporter.info("Entered Value: " + startDate + " in 'Start Date' TextBox");
    }

    /**
     * Method for clicking on start date textbox.
     */

    public void clickOnStartDateTextBox() throws Exception{
        click(START_DATE_TEXTBOX);
        VerifyPageReady(30);
    }

    /**
     * Method for clicking on end date textbox.
     */
    public void clickOnEndDateTextBox() throws Exception{
        click(END_DATE_TEXTBOX);
        VerifyPageReady(30);
    }

    /**
     * Method for selecting end date from end date datepicker.
     *
     * @param endDate :  end date of accommodation block.
     */
    public void enterEndDate(String endDate) {
        type(END_DATE_TEXTBOX, endDate);
        reporter.info("Entered Value: " + endDate + " in 'End Date' TextBox");
    }

    /**
     * Method for entering inventory in inventory textbox.
     *
     * @param inventory : value of workin inventory
     */
    public void enterInventory(String inventory) {
        type(INVENTORY_TEXTBOX, inventory);
        reporter.info("Entered Value: " + inventory + " in 'Inventory' TextBox");
    }

    /**
     * Method for entering contracted inventory in contracted textbox.
     *
     * @param contracted : value of contracted inventory.
     */

    private void enterContracted(String contracted) {
        type(CONTRACTED_TEXTBOX, contracted);
        reporter.info("Entered Value: " + contracted + " in 'Contracted' TextBox");
    }

    /**
     * Method for entering rate in room rate textbox.
     *
     * @param roomRate : rate of the room.
     */
    private void enterRoomRate(String roomRate) {
        type(ROOM_RATE_TEXTBOX, roomRate);
        reporter.info("Entered Value: " + roomRate + " in 'Room Rate' TextBox");
    }

    /**
     * Method to check Show online checkbox.
     */

    public void checkShowOnlineCheckBox() {
        check(SHOW_ONLINE_CHECKBOX);
        reporter.info("'Show Online' checkbox is checked successfully.");
    }

    /**
     * Method to check Override Info checkbox.
     */
    public void checkOverrideInfoCheckBox() {
        check(OVERRIDE_CHECKBOX);
        reporter.info("'Show Online' checkbox is checked successfully.");
    }

    /**
     * Method to uncheck Show online checkbox.
     */
    public void unCheckShowOnlineCheckBox() {
        unCheck(SHOW_ONLINE_CHECKBOX);
        reporter.info("'Show Online' checkbox is unchecked successfully.");
    }

    /**
     * Method to click on save button.
     *
     * @return BlocksPage
     */
    public BlocksPage clickOnSaveButton() throws Exception{
        click(SAVE_BUTTON);
        VerifyAngularHasFinishedProcessing(20);
        reporter.info("'Save' button is clicked successfully.");
       return new BlocksPage(browser);
    }

    public void clickSaveButton() throws Exception {
         click(SAVE_BUTTON);
        VerifyAngularHasFinishedProcessing(30);
        reporter.info("'Save' button is clicked successfully.");

    }

    /**
     * Method to fill accommodation inventory block details.
     *
     * @param accommodationBlockInformation : page object of AccommodationBlockInformation page.
     */


    public void enterBlocksDetails(AccommodationBlockInformation accommodationBlockInformation) throws Exception{
        selectHotel(accommodationBlockInformation.getHotelName());
        selectRoomType(accommodationBlockInformation.getRoomType());
        enterStartDate(accommodationBlockInformation.getStartDate());
        enterEndDate(accommodationBlockInformation.getEndDate());
        enterInventory(accommodationBlockInformation.getInventory());
        enterContracted(accommodationBlockInformation.getContracted());
        enterRoomRate(accommodationBlockInformation.getRoomRate());
        checkShowOnlineCheckBox();
    }


    /**
     * Method to fill accommodation inventory block details.
     *
     * @param accommodationBlockInformation : page object of AccommodationBlockInformation page.
     * @param noOfDays                      : value of days.
     * @return BlocksPage
     * @throws Exception
     */

    public BlocksPage testCreateBlocks(AccommodationBlockInformation accommodationBlockInformation, int noOfDays) throws Exception {
        selectHotel(accommodationBlockInformation.getHotelName());
        selectRoomType(accommodationBlockInformation.getRoomType());
        enterStartDate(getCurrentDate());
        enterEndDate(getDateByDays(noOfDays));
        enterInventory(accommodationBlockInformation.getInventory());
        enterContracted(accommodationBlockInformation.getContracted());
        enterRoomRate(accommodationBlockInformation.getRoomRate());
        checkShowOnlineCheckBox();
        clickSaveButton();
        return new BlocksPage(browser);
    }

    /**
     * Method to verify required fields are mandatory.
     *
     * @param requiredFieldLabel : label of required field
     * @return boolean
     */
    public boolean isRequiredFieldContainsAsterisk(String requiredFieldLabel) throws Exception{
        VerifyPageReady(30);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        Wait(REQUIRED_FIELD, 30);
        String requiredFieldLabelArray[] = requiredFieldLabel.split(",");
        int count = 0;
        List<WebElement> requiredFieldList = browser.findElements(By.xpath("//label[contains(@class,'requiredField')]"));
        for (int i = 0; i < requiredFieldLabelArray.length; i++) {
            for (WebElement element : requiredFieldList) {
                if (element.getText().equals(requiredFieldLabelArray[i])) {
                    count = count + 1;
                }
            }
        }
        return count == requiredFieldLabelArray.length;

    }

    /**
     * Method to verify attendee in allow section are mandatory.
     *
     * @param attendeeType : attendee value.
     * @return boolean
     */
    public boolean isAllowedSectionContainsAttendeeType(String attendeeType) {
        String xpath = "//ul[@class='panel attendeeTypeList ng-pristine ng-valid ui-sortable']//li[text()='" + attendeeType + "']//..//..//div[text()='Allowed:']";
        //WebElement attendee = webDriver.findElementWithoutWait(By.xpath(xpath));

        boolean isAttendeeDisplayed = browser.findElement(By.xpath(xpath)).isDisplayed();
        return isAttendeeDisplayed;
    }

    /**
     * Method to drag and drop the attendee type from Allow section to not allowed section.
     *
     * @param attendeeType : attendee value which we need to drag and drop.
     */

    public void draganddropFromAllowedSectionToNotAllowedSection(String attendeeType) {
        String xpathFrom = "//div[text()='Allowed:']/..//ul//li[text()='" + attendeeType + "']";
        String xpathTo = "//div[text()='Not Allowed:']/..//ul";
        WebElement From = browser.findElement(By.xpath(xpathFrom));
        WebElement To = browser.findElement(By.xpath(xpathTo));
        //WebDriver driver = webDriver;
        Actions builder = new Actions(browser);
        builder.clickAndHold(From).moveToElement(To).release(From).build().perform();
        reporter.info("Successfully drag and drop the item.");

    }

    /**
     * Method to drag and drop the attendee type from Not allow section to allow section.
     *
     * @param attendeeType : attendee value which we need to drag and drop.
     */

    public void draganddropFromNotAllowedSectionToAllowedSection(String attendeeType) {
        String xpathFrom = "//div[text()='Not Allowed:']/..//ul//li[text()='" + attendeeType + "']";
        String xpathTo = "//div[text()='Allowed:']/..//ul";
        WebElement From = browser.findElement(By.xpath(xpathFrom));
        WebElement To = browser.findElement(By.xpath(xpathTo));
        //WebDriver driver = (WebDriver)webDriver;
        Actions builder = new Actions(browser);
        builder.clickAndHold(From).moveToElement(To).release(From).build().perform();
        reporter.info("Successfully drag and drop the item.");
    }

    /**
     * Method to verify hotel name is present or not on the window
     *
     * @param hotelName : value of hotel which need to be verify
     * @return boolean
     */
    public boolean isHotelNamePresent(String hotelName) {
        WebElement hotel = browser.findElement(By.xpath("//strong[@class='ng-binding']"));
        return hotel.getText().equals(hotelName);
    }

    /**
     * Method to verify room type is present or not on the window
     *
     * @param roomDetail : value of room type which need to be verify
     * @return boolean
     */
    public boolean isRoomDetailPresent(String roomDetail) {
        WebElement room = browser.findElement(By.xpath("//span[contains(.,'Room Type')]"));
        return room.getText().contains(roomDetail);
    }



    /**
     * Method for clicking cancel button
     *
     * @return BlocksPage
     */
    public BlocksPage clickCancelButton() throws Exception{
        click(CANCEL_BUTTON);
        reporter.info("Clicked Cancel button");
        return new BlocksPage(browser);
    }


    /**
     * Method for clicking cancel button
     */
    public void clickOnCancelButton()throws Exception{
        VerifyPageReady(30);
        click(CANCEL_BUTTON);
    }
}
