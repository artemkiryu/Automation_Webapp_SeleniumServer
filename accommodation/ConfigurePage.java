package pageObjects.Accommodation;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import java.util.List;

/**
 * Created by infoobjects on 8/21/2017.
 */
public class ConfigurePage  extends CommonActionsPage{


    @FindBy(xpath = "//input[@title='Accommodation Booking Status']")
    public WebElement ACCOMMODATION_BOOKING_STATUS_TEXTBOX;

    @FindBy(xpath = "//input[@title='Accommodation Action Code']")
    public WebElement ACCOMMODATION_ACTION_CODE_TEXTBOX;

    @FindBy(xpath = "//img[@title='Save Accommodation Booking Status']")
    public WebElement SAVE_ACCOMMODATIONBOOKINGSTATUS_BUTTON;

    @FindBy(xpath = "//img[@title='Cancel Accommodation Booking Status changes']")
    public WebElement CANCEL_ACCOMMODATIONBOOKINGSTATUS_BUTTON;

    @FindBy(xpath = "//img[@title='Save Accommodation Action Code']")
    public WebElement SAVE_ACCOMMODATIONACTIONCODE_BUTTON;

    @FindBy(xpath = "//img[@title='Cancel Accommodation Action Code changes']")
    public WebElement CANCEL_ACCOMMODATIONACTIONCODE_BUTTON;

    public ConfigurePage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    private void enterAccommodationBookingStatus(String bookingStatus) throws Exception{
        VerifyPageReady(30);
        Wait(ACCOMMODATION_BOOKING_STATUS_TEXTBOX,30);
        type(ACCOMMODATION_BOOKING_STATUS_TEXTBOX ,bookingStatus);
        logReport("Successfully entered value: " + bookingStatus + " in accommodation booking status textbox.");
    }

    private void enterAccommodationActionCode(String actionCode) throws Exception{
        VerifyPageReady(30);
        Wait(ACCOMMODATION_ACTION_CODE_TEXTBOX,30);
        type(ACCOMMODATION_ACTION_CODE_TEXTBOX ,actionCode);
        logReport("Successfully entered value: " + actionCode + " in accommodation action code textbox.");
    }

   private void clickSaveBookingStatusButton() throws Exception{
       VerifyPageReady(30);
       Wait(SAVE_ACCOMMODATIONBOOKINGSTATUS_BUTTON,30);
       click(SAVE_ACCOMMODATIONBOOKINGSTATUS_BUTTON);
       logReport("Successfully clicked on save booking status button");
   }

    private void clickCancelBookingStatusButton() throws Exception{
        VerifyPageReady(30);
        Wait(CANCEL_ACCOMMODATIONBOOKINGSTATUS_BUTTON, 30);
        click(CANCEL_ACCOMMODATIONBOOKINGSTATUS_BUTTON);
        logReport("Successfully clicked on cancel booking status button");
    }

    private void clickSaveActionCodeButton() throws Exception{
        VerifyPageReady(30);
        Wait(SAVE_ACCOMMODATIONACTIONCODE_BUTTON,30);
        click(SAVE_ACCOMMODATIONACTIONCODE_BUTTON);
        logReport("Successfully clicked on save action code button");
    }

    private void clickCancelActionCodeButton() throws Exception{
        VerifyPageReady(30);
        Wait(CANCEL_ACCOMMODATIONACTIONCODE_BUTTON, 30);
        click(CANCEL_ACCOMMODATIONACTIONCODE_BUTTON);
        logReport("Successfully clicked on cancel action code button");
    }

}
