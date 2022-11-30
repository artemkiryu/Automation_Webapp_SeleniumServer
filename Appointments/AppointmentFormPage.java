package pageObjects.Appointments;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddAppointmentBlock;
import pojo.AppointmentForm;


/**
 * Created by bludshot on 13/7/15.
 */
public class AppointmentFormPage extends CommonActionsPage {

    @FindBy(xpath = "//select[@ng-model='attendeeType']")
    public WebElement ATTENDEE_TYPE_SELECT;
    @FindBy(xpath = "//select[@ng-model='organization']")
    public WebElement ORGANIZATION_SELECT;
    @FindBy(xpath = "//select[@ng-model='appointment.targetRegistration.id']")
    public WebElement TARGET_REGISTRANT_SELECT;
    @FindBy(xpath = "//select[@ng-model='startDate']")
    public WebElement START_DATE_SELECT;
    @FindBy(xpath = "//select[@ng-model='startTime']")
    public WebElement START_TIME_SELECT;
    @FindBy(xpath = "//input[@ng-model='appointment.location']")
    public WebElement LOCATION_TEXTBOX;
    @FindBy(id = "appointment-save")
    public WebElement APPOINTMENT_SAVE_BUTTON;
    @FindBy(xpath = "//input[@value='Cancel']")
    public WebElement APPOINTMENT_CANCEL_BUTTON;
    @FindBy(xpath = "//input[@value='Delete']")
    public WebElement APPOINTMENT_DELETE_BUTTON;
    @FindBy(xpath = "//select[@ng-model='appointment.targetCalendarId']")
    public WebElement CALENDAR_SELECT;

    public AppointmentFormPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for select attendee types
     *
     * @param attendeeType value of attendee type
     */
    public void selectAttendeeTypes(String attendeeType) throws Exception {
        Wait(ATTENDEE_TYPE_SELECT, 10);
        select(ATTENDEE_TYPE_SELECT, attendeeType);
    }

    /**
     * Method for select organization
     *
     * @param organization value of organization
     */
    public void selectOrganization(String organization) throws Exception {
        Wait(ORGANIZATION_SELECT, 10);
        select(ORGANIZATION_SELECT, organization);
    }

    /**
     * Method for select calendar
     *
     * @param calendarName value of calendar
     */
    public void selectCalendar(String calendarName) throws Exception {
        Wait(CALENDAR_SELECT, 10);
        select(CALENDAR_SELECT, calendarName);
    }

    /**
     * Method for select target registrant name
     *
     * @param targetRegistrant name of target registrant
     */
    public void selectTargetRegistrant(String targetRegistrant) throws Exception {
        Wait(TARGET_REGISTRANT_SELECT, 10);
        select(TARGET_REGISTRANT_SELECT, targetRegistrant);
    }

    /**
     * Method for select start date
     *
     * @param startDate value of start date
     */
    public void selectStartDate(String startDate) throws Exception {
        Wait(START_DATE_SELECT, 10);
        select(START_DATE_SELECT, startDate);
        //    webDriver.element().selectOptionByValue(START_DATE_SELECT, "0");
    }

    /**
     * Method for select start time
     *
     * @param startTime value of start time
     */
    public void selectStartTime(String startTime) throws Exception {
        Wait(START_TIME_SELECT, 10);
        select(START_TIME_SELECT, startTime);
    }

    /**
     * Method for entering location
     *
     * @param location value of location
     */
    public void enterLocation(String location) throws Exception {
        Wait(LOCATION_TEXTBOX, 10);
        LOCATION_TEXTBOX.clear();
        LOCATION_TEXTBOX.sendKeys(location);
    }

    /**
     * Method for filling appointment form details
     *
     * @param appointmentForm     Page object of AppointmentForm
     * @param addAppointmentBlock page object of AddAppointmentBlock
     * @throws Exception
     */
    public void fillAppointmentForm(AppointmentForm appointmentForm, AddAppointmentBlock addAppointmentBlock) throws Exception {
        selectAttendeeTypes(appointmentForm.getAttendeeTypes());
        VerifyAngularHasFinishedProcessing(20);
        selectOrganization(appointmentForm.getOrganization());
        VerifyAngularHasFinishedProcessing(20);
        selectTargetRegistrant(appointmentForm.getTargetRegistrant());
        VerifyAngularHasFinishedProcessing(20);
        selectStartDate(getDateByDays(1));
        VerifyAngularHasFinishedProcessing(20);
        selectStartTime(addAppointmentBlock.getFromTime());
        enterLocation(appointmentForm.getLocation());
    }

    /**
     * Method for clicking appointment save button
     *
     * @return AppointmentSearchCalendarPage
     */
    public AppointmentSearchCalendarPage clickAppointmentSaveButton() throws Exception {
        Wait(APPOINTMENT_SAVE_BUTTON, 20);
        click(APPOINTMENT_SAVE_BUTTON);
        return new AppointmentSearchCalendarPage(browser);
    }

    /**
     * Method for clicking appointment cancel button
     *
     * @return AppointmentSearchCalendarPage
     */
    public AppointmentSearchCalendarPage clickAppointmentCancelButton() throws Exception {
        click(APPOINTMENT_CANCEL_BUTTON);
        return new AppointmentSearchCalendarPage(browser);
    }

    /**
     * Method for clicking delete button
     */
    public void clickOnDeleteButton() throws Exception {
        Wait(APPOINTMENT_DELETE_BUTTON, 10);
        click(APPOINTMENT_DELETE_BUTTON);
        logReport("Successfully clicked on 'Delete' button.");
    }

    /**
     * Method for checking target reg present
     *
     * @param registrantName name of registrant user
     * @return boolean : true if reg found else return false
     */
    public boolean isTargetRegistrantPresent(String registrantName) {
        String xpath = "//select[@ng-model='appointment.targetRegistration.id']//option[text()='" + registrantName + "']";
        return isElementDisplayed(By.xpath(xpath), browser);
    }
}
