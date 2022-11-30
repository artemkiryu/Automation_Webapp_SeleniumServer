package pageObjects.Accommodation;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageObjects.CommonActionsPage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import pojo.HotelData;

import java.util.List;

/**
 * Created by infoobjects on 8/21/2017.
 */
public class RoomTypesPage extends CommonActionsPage {
    @FindBy(xpath ="//input[@placeholder='Room code' and contains(@class, 'ng-invalid-required')]")
    public WebElement ROOM_TYPE_TEXTBOX;

    @FindBy(xpath ="//input[@placeholder='Description' and contains(@class, 'ng-invalid-required')]")
    public WebElement DESCRIPTION_TEXTBOX;

    @FindBy(xpath ="//select[@data-placeholder='Occupancy' and contains(@class, 'ng-invalid-required')]")
    public WebElement OCCUPANCY_DROPDOWN;

    @FindBy(xpath ="//select[@class='form-control ng-pristine ng-invalid ng-invalid-required']//option[text()='2']")
    public WebElement DROP_DOWN_OPTIONS_LIST;

    @FindBy(xpath ="//i[@class='fa fa-check-square-o ng-scope']")
    public WebElement SAVE_ICON;

    @FindBy(xpath ="//h3[contains(.,'Room Types')]")
    public WebElement PAGE_HEADING;

    @FindBy(xpath ="//ol[@class='breadcrumb']//li//a[text()='Accommodation']")
    public WebElement ACCOMMODATION_LINK;
    public RoomTypesPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to type code of room type in textbox.
     *
     * @param roomType : value of room type code.
     */
    public void enterRoomTypeCode(String roomType) throws Exception{
       Wait(ROOM_TYPE_TEXTBOX, 30);
        String xpath = "//input[@placeholder='Room code' and contains(@class, 'ng-invalid-required')]";
        List<WebElement> roomTypeCodeInputs = browser.findElements(By.xpath(xpath));
        for (WebElement element : roomTypeCodeInputs) {
            if (element.isDisplayed())
                element.sendKeys(roomType);
        }
        logReport("entered room type code " + roomType);
    }

    /**
     * Method to enter description of room type.
     *
     * @param description : value of room type description.
     */
    public void enterDescription(String description) {
        String xpath = "//input[@placeholder='Description' and contains(@class, 'ng-invalid-required')]";
        List<WebElement> descriptionTextBoxes = browser.findElements(By.xpath(xpath));
        for (WebElement element : descriptionTextBoxes) {
            if (element.isDisplayed())
                element.sendKeys(description);
        }
        logReport("entered description " + description);
    }

    /**
     * Method to set occupancy of room.
     *
     * @param occupancy : value of occupancy of room.
     */
    public void setOccupancy(String occupancy) {
        String xpath = "//select[@data-placeholder='Occupancy' and contains(@class, 'ng-invalid-required')]";
        List<WebElement> occupancyDropDowns = browser.findElements(By.xpath(xpath));
        for (WebElement element : occupancyDropDowns) {
            if (element.isDisplayed()) {
                Select select = new Select(element);
                select.selectByVisibleText(occupancy);
            }
        }
        logReport("selecetd occupancy value " + occupancy);
    }

    /**
     * Method to click on save icon.
     */
    public void clickSaveIcon() throws Exception{
        click(SAVE_ICON);
        logReport("Save icon clicked successfully");
        VerifyPageReady(30);
    }

    /**
     * Method to create new room type.
     *
     * @param hotelData : page object of HotelData
     */
    public void createRoomType(HotelData hotelData) throws Exception{
        enterRoomTypeCode(hotelData.getRoomTypeCode());
        enterDescription(hotelData.getRoomTypeCode());
        setOccupancy(hotelData.getOccupancy());
        clickSaveIcon();

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
}
