package pageObjects.Appointments;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddAppointmentBlock;


/**
 * Created by Aditi on 23-06-2015.
 */
public class AddAppointmentBlockPage extends CommonActionsPage {
    @FindBy(xpath = "//input[@id='name']")
    public WebElement BLOCK_TEXTBOX;
    @FindBy(xpath = "//input[@id='startDate']")
    public WebElement START_DATE_TEXTBOX;
    @FindBy(xpath = "//input[@id='startTime']")
    public WebElement FROM_TIME_TEXTBOX;
    @FindBy(xpath = "//input[@id='endTime']")
    public WebElement TO_TIME_TEXTBOX;
    @FindBy(xpath = "//input[@id='duration']")
    public WebElement DURATION_TIME_TEXTBOX;
    @FindBy(xpath = "//input[@id='travel']")
    public WebElement TRAVEL_TIME_TEXTBOX;
    @FindBy(xpath = "//input[@id='appointment-block-save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//input[@id='appointment-block-form-close']")
    public WebElement CLOSE_BUTTON;

    public AddAppointmentBlockPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for entering block name
     *
     * @param blockName value of block name
     */
    private void enterBlockName(String blockName) throws Exception {
        Wait(BLOCK_TEXTBOX, 20);
        type(BLOCK_TEXTBOX, blockName);
        logReport("Entered block name " + blockName);
    }

    /**
     * Method for entering start date of block
     *
     * @throws Exception
     */
    private void enterStartDate() throws Exception {
        type(START_DATE_TEXTBOX, getDateByDays(1), true);
        logReport("Entered start date value " + getDateByDays(1));
    }

    /**
     * Method for entering start time of block
     *
     * @param fromTime value of start time
     */
    private void enterFromTime(String fromTime) {
        type(FROM_TIME_TEXTBOX, fromTime, true);
        logReport("Entered from time " + fromTime);
    }

    /**
     * Method for entering end time of block
     *
     * @param toTime value of end time
     */
    private void enterToTime(String toTime) {
        type(TO_TIME_TEXTBOX, toTime, true);
        logReport("Entered to time " + toTime);
    }

    /**
     * Method for entering duration of block
     *
     * @param duration value of duration in hours or minutes i.e 5h5m
     */
    private void enterDuration(String duration) {
        type(DURATION_TIME_TEXTBOX, duration, true);
        logReport("Entered duration value " + duration);

    }

    /**
     * Method for entering travel time of block
     *
     * @param travelTime value of travel time
     */
    private void enterTravelTime(String travelTime) {
        type(TRAVEL_TIME_TEXTBOX, travelTime, true);
        logReport("Entered travel time " + travelTime);
    }

    /**
     * Method for clicking on save button in block
     */
    public void clickSaveButton() throws Exception {
        click(SAVE_BUTTON);
        VerifyPageReady(20);
        logReport("Save button clicked successfully");
    }

    /**
     * Method for clicking close button
     */
    public void clickCloseButton() throws Exception {
        click(CLOSE_BUTTON);
        VerifyPageReady(20);
        logReport("Close button clicked successfully");
    }

    /**
     * Method for create appointment block
     *
     * @param addAppointmentBlock page object of AddAppointmentBlock
     * @throws Exception
     */
    public void createAppointmentBlock(AddAppointmentBlock addAppointmentBlock) throws Exception {
        enterBlockName(addAppointmentBlock.getBlockName());
        enterStartDate();
        enterFromTime(addAppointmentBlock.getFromTime());
        enterToTime(addAppointmentBlock.getToTime());
        enterDuration(addAppointmentBlock.getDuration());
        enterTravelTime(addAppointmentBlock.getTravelTime());
    }

}
