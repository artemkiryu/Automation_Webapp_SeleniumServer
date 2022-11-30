package pageObjects.Accommodation;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.HotelData;

import java.util.List;


/**
 * Created by infoobjects on 8/21/2017.
 */
public class HotelsPage extends CommonActionsPage {

    @FindBy(xpath = "//label[text()='Country']//../div/div/a/span[@class='select2-arrow']")
    public WebElement COUNTRY_ELEMENT;
    @FindBy(xpath = "//div[@id='select2-drop']//ul[@class='select2-results']//li//div")
    public WebElement DROP_DOWN_OPTIONS_LIST;
    @FindBy(xpath = "//div[@class='select2-search']//input[contains(@id,'autogen')]")
    public WebElement INPUT_LIST_DROP_DOWN;
    @FindBy(xpath = "//label[text()='State']//../div/div/a/span[@class='select2-arrow']")
    public WebElement STATE_ELEMENT;
    @FindBy(xpath = "//h3[@class='page-header ng-binding']")
    public WebElement PAGE_HEADING;
    @FindBy(xpath = "//button[text()='Add New']")
    public WebElement ADD_NEW_BUTTON;
    @FindBy(xpath = "//input[@name='locationName']")
    public WebElement NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='locationCode']")
    public WebElement UNIQUE_CODE_TEXTBOX;
    @FindBy(xpath = "//input[@name='locationAddressLine1']")
    public WebElement STREET_ADDRESS_TEXTBOX;
    @FindBy(xpath = "//button[text()='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement CANCEL_BUTTON;
    @FindBy(xpath = "//label[text()='Preferred Supplier']/..//input")
    public WebElement PREFERRED_SUPPLIER_CHECKBOX;
    @FindBy(xpath = "//input[@name='locationUrl']")
    public WebElement WEB_URL_TEXTBOX;
    @FindBy(xpath = "//input[@name='locationEmail']")
    public WebElement EMAIL_TEXTBOX;
    @FindBy(xpath = "//input[@name='locationCity']")
    public WebElement CITY_TEXTBOX;
    @FindBy(xpath = "//input[@name='locationPostalCode']")
    public WebElement ZIPCODE_TEXTBOX;
    @FindBy(xpath = "//label[text()='Non-US Province']//..//input[@class='form-control ng-pristine ng-valid']")
    public WebElement NONUS_PROVINCE_TEXTBOX;
    @FindBy(xpath = "//input[@name='locationPhone']")
    public WebElement PHONE_TEXTBOX;
    @FindBy(xpath = "//input[@name='locationFax']")
    public WebElement FAX_TEXTBOX;
    @FindBy(xpath = "//input[@name='locationTollFree']")
    public WebElement TOLL_FREE_TEXTBOX;
    @FindBy(xpath = "//textarea[@name='locationNotes']")
    public WebElement USER_NOTES_TEXTBOX;
    @FindBy(xpath = "//input[@name='numberOfRooms']")
    public WebElement SLEEPING_ROOM_TEXTBOX;
    @FindBy(xpath = "//input[@name='registrationFormlabel']")
    public WebElement REG_LABEL_TEXTBOX;
    @FindBy(xpath = "//textarea[@name='hotelDescription']")
    public WebElement HOTEL_DESCRIPTION_TEXTBOX;
    @FindBy(xpath = "//input[@name='largestMeetingSpace']")
    public WebElement LARGEST_SPACE_TEXTBOX;
    @FindBy(xpath = "//input[@name='totalMeetingSpace']")
    public WebElement TOTAL_SPACE_TEXTBOX;
    @FindBy(xpath = "//input[@name='numberOfMeetingRooms']")
    public WebElement MEETING_ROOMS_TEXTBOX;
    @FindBy(xpath = "//ol[@class='breadcrumb']//li//a[text()='Accommodation']")
    public WebElement ACCOMMODATION_LINK;
    @FindBy(xpath = "//h3[text()='Hotel Detail Information']")
    public WebElement HOTEL_DETAIL_INFORMATION;
    @FindBy(xpath = "//input[contains(@id,'autogen') and contains(@class,'select2-input')]")
    public List<WebElement> DROP_DOWN_INPUT;


    public HotelsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to click on Add New button.
     */
    public void clickAddNew() throws Exception {
        waitForWindowToAppear();
        Wait(ADD_NEW_BUTTON, 30);
        click(ADD_NEW_BUTTON);
        VerifyAngularHasFinishedProcessing(30);
    }

    /**
     * Method to enter hotel name in the text box.
     *
     * @param hotelName : name of hotel.
     */
    private void enterHotelName(String hotelName) throws Exception{
      
        VerifyAjaxRequestsFinished(30);
        type(NAME_TEXTBOX, hotelName);
        logReport("Entered Value: " + hotelName + " in 'Name' textbox.");
    }

    /**
     * Method to enter unique code in unique code textbox.
     *
     * @param uniqueCode : value of unique code for hotel
     */
    private void enterUniqueCode(String uniqueCode) {
       type(UNIQUE_CODE_TEXTBOX, uniqueCode);
        logReport("Entered Value: " + uniqueCode + " in 'Unique Code' textbox.");
    }

    /**
     * Method to enter address of the hotel
     *
     * @param address : value of address of hotel.
     */
    private void enterAddress(String address) {
        type(STREET_ADDRESS_TEXTBOX, address);
        logReport("Entered Value: " + address + " in 'Address' textbox.");
    }

    private void selectCountry(String country) throws Exception{
        type(CITY_TEXTBOX, "Alaska", true);
        Wait(COUNTRY_ELEMENT, 20);
        COUNTRY_ELEMENT.click();
        VerifyAjaxRequestsFinished(20);
        //  type(COUNTRY_ELEMENT,country,true);

        for (WebElement element : DROP_DOWN_INPUT) {
            if (element.isDisplayed()) {
                element.sendKeys(country);
                VerifyAngularHasFinishedProcessing(30);
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    reporter.info("Exception thrown " + e.getMessage());
                }
                element.sendKeys(Keys.ENTER);
                VerifyPageReady(30);
                wait(10);
                VerifyAjaxRequestsFinished(30);
                VerifyAngularHasFinishedProcessing(30);
            } else {
                //  click(COUNTRY_ELEMENT);
            }
        }
        reporter.info("Selected country value " + country);
    }

    private void selectState(String state) throws Exception{
        Wait(STATE_ELEMENT,30);
        STATE_ELEMENT.click();
        VerifyAjaxRequestsFinished(20);
        // STATE_ELEMENT.click();
        for (WebElement element : DROP_DOWN_INPUT) {
            if (element.isDisplayed()) {
                element.sendKeys(state);
                VerifyAngularHasFinishedProcessing(30);
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    reporter.info("Exception thrown " + e.getMessage());
                }
                element.sendKeys(Keys.ENTER);
                VerifyPageReady(30);
                wait(10);
                VerifyAjaxRequestsFinished(30);
                VerifyAngularHasFinishedProcessing(30);
            }
        }
        reporter.info("Selected state value " + state);
    }

    /**
     * Method to click on save button.
     */
    public void clickSave() throws Exception{
        Wait(SAVE_BUTTON,30);
        click(SAVE_BUTTON);
        VerifyAngularHasFinishedProcessing(30);

    }

    /**
     * Method to click on cancel button.
     */
    public void clickCancelButton() throws Exception{
        Wait(CANCEL_BUTTON, 30);
        click(CANCEL_BUTTON);
        VerifyAngularHasFinishedProcessing(30);

    }

    /**
     * Method to check Preferred supplier checkbox.
     */
    private void checkPreferedSuplierCheckBox() {
        if (!PREFERRED_SUPPLIER_CHECKBOX.isSelected()) {
            PREFERRED_SUPPLIER_CHECKBOX.click();
        }
    }

    /**
     * Method to uncheck Preferred supplier checkbox.
     */
    public void uncheckPreferedSuplierCheckBox() {
        if (PREFERRED_SUPPLIER_CHECKBOX.isSelected()) {
            PREFERRED_SUPPLIER_CHECKBOX.click();
        }
    }

    /**
     * Method to enter web url of hotel.
     *
     * @param url : value of url of the hotel.
     */

    private void enterWebUrl(String url) {
        type(WEB_URL_TEXTBOX, url);
        logReport("Entered Value: " + url + " in 'Web URL' textbox.");
    }

    /**
     * Method to enter the email id of hotel
     *
     * @param email : value of email id of the hotel.
     */
    private void enterEmail(String email) {
        type(EMAIL_TEXTBOX, email);
        logReport("Entered Value: " + email + " in 'Email' textbox.");
    }

    /**
     * Method to enter city of the hotel
     *
     * @param city : value of city of the hotel
     */
    private void enterCity(String city) {
        type(CITY_TEXTBOX, city);
        logReport("Entered Value: " + city + " in 'City' textbox.");
    }

    /**
     * Method to enter zip code of the hotel.
     *
     * @param zipCode : value of zip code for the hotel.
     */
    private void enterZipCode(String zipCode) {
        type(ZIPCODE_TEXTBOX, zipCode);
        logReport("Entered Value: " + zipCode + " in 'Zip Code' textbox.");
    }

    /**
     * Method to enter province of the hotel.
     *
     * @param province : value of province for the hotel.
     */
    private void enterProvince(String province) {
        type(NONUS_PROVINCE_TEXTBOX, province);
        logReport("Entered Value: " + province + " in 'Non-US Province' textbox.");
    }

    /**
     * Method to enter phone number of hotel.
     *
     * @param phone : value of phone number for the hotel.
     */
    private void enterPhone(String phone) {
        type(PHONE_TEXTBOX, phone);
        logReport("Entered Value: " + phone + " in 'Phone' textbox.");
    }

    /**
     * Method to enter fax number of the hotel.
     *
     * @param fax : value of fax number for the hotel.
     */
    private void enterFax(String fax) {
        type(FAX_TEXTBOX, fax);
        logReport("Entered Value: " + fax + " in 'FAX' textbox.");
    }

    /**
     * Method to enter user notes of hotel.
     *
     * @param notes : value of user notes.
     */

    private void enterUserNotes(String notes) {
        type(USER_NOTES_TEXTBOX, notes);
        logReport("Entered Value: " + notes + " in 'User Notes' textbox.");
    }

    /**
     * Method to enter tool free number of user
     *
     * @param number : toll free number of user
     */
    private void enterTollFreeNumber(String number) {
        type(TOLL_FREE_TEXTBOX, number);
        logReport("Entered Value: " + number + " in 'Toll Free No.' textbox.");
    }

    /**
     * Method to enter value of sleeping rooms of hotel.
     *
     * @param number : value of sleeping rooms.
     */
    private void enterSleepingRooms(String number) {
        type(SLEEPING_ROOM_TEXTBOX, number);
        logReport("Entered Value: " + number + " in 'No. Of Sleeping Rooms' textbox.");
    }

    /**
     * Method to enter Reg Label of hotel
     *
     * @param label : value of Reg label
     */
    private void enterRegLabel(String label) {
        type(REG_LABEL_TEXTBOX, label);
        logReport("Entered Value: " + label + " in 'Reg Form Label' textbox.");
    }

    /**
     * Method to enter description of the hotel.
     *
     * @param description : hotel description.
     */
    private void enterHotelDescription(String description) {
        type(HOTEL_DESCRIPTION_TEXTBOX, description);
        logReport("Entered Value: " + description + " in 'Hotel Description' textbox.");
    }

    /**
     * Method to enter largest space in the hotel
     *
     * @param largestSpace : value of largest space in the hotel.
     */
    private void enterLargestSpace(String largestSpace) {
        type(LARGEST_SPACE_TEXTBOX, largestSpace);
        logReport("Entered Value: " + largestSpace + " in 'Largest Meeting Space' textbox.");
    }

    /**
     * Method to enter total space of the hotel
     *
     * @param totalSpace : value of total space
     */
    private void enterTotalSpace(String totalSpace) {
        type(TOTAL_SPACE_TEXTBOX, totalSpace);
        logReport("Entered Value: " + totalSpace + " in 'Total Meeting Space' textbox.");
    }

    /**
     * Method to enter number of meeting rooms in a hotel.
     *
     * @param rooms : value of number of meeting rooms.
     */
    private void enterMeetingRooms(String rooms) {
        type(MEETING_ROOMS_TEXTBOX, rooms);
        logReport("Entered Value: " + rooms + " in 'No. of Meeting Rooms' textbox.");
    }

    /**
     * Method to click on Accommodation link
     *
     * @return : BlocksPage
     */
    public BlocksPage clickAccommodationLink() throws Exception{
        click(ACCOMMODATION_LINK);
        return new BlocksPage(browser);
    }

    /**
     * Method to create new hotel.
     *
     * @param hotelData : page object of HotelData.
     */
    public void createHotel(HotelData hotelData) throws Exception {
        clickAddNew();
        enterHotelName(hotelData.getHotelCode());
        enterUniqueCode(hotelData.getHotelCode());
        checkPreferedSuplierCheckBox();
        enterWebUrl(hotelData.getWebURL());
        enterEmail(hotelData.getEmail());
        enterAddress(hotelData.getHotelCode());
        selectCountry(hotelData.getHotelCountry());
        selectState(hotelData.getHotelState());
        enterCity(hotelData.getCity());
        enterZipCode(hotelData.getZipCode());
        enterProvince(hotelData.getProvince());
        enterPhone(hotelData.getPhone());
        enterFax(hotelData.getFax());
        enterTollFreeNumber(hotelData.getTollFree());
        enterUserNotes(hotelData.getUserNotes());
        enterSleepingRooms(hotelData.getSleepingRooms());
        enterRegLabel(hotelData.getRegLabel());
        enterHotelDescription(hotelData.getDescription());
        enterLargestSpace(hotelData.getLargestSpace());
        enterTotalSpace(hotelData.getTotalSpace());
        enterMeetingRooms(hotelData.getMeetingRooms());
        clickSave();

    }

    /**
     * Method for filling hotel information detail
     *
     * @param hotelData page object of HotelData
     */
    public void fillHotelInformationDetail(HotelData hotelData) throws Exception{
        enterHotelName(hotelData.getHotelCode());
        enterUniqueCode(hotelData.getHotelCode());
        checkPreferedSuplierCheckBox();
        enterWebUrl(hotelData.getWebURL());
        enterEmail(hotelData.getEmail());
        enterAddress(hotelData.getHotelCode());
        selectCountry(hotelData.getHotelCountry());
        selectState(hotelData.getHotelState());
        enterCity(hotelData.getCity());
        enterZipCode(hotelData.getZipCode());
        enterProvince(hotelData.getProvince());
        enterPhone(hotelData.getPhone());
        enterFax(hotelData.getFax());
        enterTollFreeNumber(hotelData.getTollFree());
        enterUserNotes(hotelData.getUserNotes());
        enterSleepingRooms(hotelData.getSleepingRooms());
        enterRegLabel(hotelData.getRegLabel());
        enterHotelDescription(hotelData.getDescription());
        enterLargestSpace(hotelData.getLargestSpace());
        enterTotalSpace(hotelData.getTotalSpace());
        enterMeetingRooms(hotelData.getMeetingRooms());
    }

    /**
     * Method for edit hotel detail
     *
     * @param hotelName name of hotel
     */
    public void editHotelDetail(String hotelName) {
        String xpath = "//div[@x-ng-include='listSection']//table[@id='supplier-list-table']//td[text()='" + hotelName + "']/..//td[@class='user-action']//span//img[@x-tooltip='Edit Hotel']";
        isElementDisplayed(By.xpath(xpath),browser);
        browser.findElement(By.xpath(xpath)).click();
        logReport("Successfully clicked on edit button of " + hotelName + " hotel.");
        VerifyAngularHasFinishedProcessing(30);
    }



}
