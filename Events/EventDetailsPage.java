package pageObjects.Events;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Agenda.AgendaPage;
import pageObjects.CommonActionsPage;
import pojo.Event;
import pojo.EventAttributes;

/**
 * Created by infoobjects on 8/3/2017.
 */
public class EventDetailsPage extends CommonActionsPage {
    public EventDetailsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath= "//input[@name='evt_name']")
    public WebElement eventNameTextbox;

    @FindBy(xpath= "//input[@id='evt_code']")
    public WebElement eventCodeTextbox;

    @FindBy(xpath= "//input[@id='evt_start_date']")
    public WebElement startDateTextbox;

    @FindBy(xpath= "//input[@id='evt_start_time']")
    public WebElement startTimeTextbox;

    @FindBy(xpath= "//input[@id='evt_end_date']")
    public WebElement endDateTextbox;

    @FindBy(xpath= "//input[@id='evt_end_time']")
    public WebElement endTimeTextbox;

    @FindBy(xpath= "//select[@id='evt_frn_tmz_id']")
    public WebElement timezoneDropdown;

    @FindBy(xpath= "//select[@id='evt_frn_evt_sts_id']")
    public WebElement statusDropdown;

    @FindBy(xpath= "//textarea[@id='evt_notes']")
    public WebElement notesTextarea;

    @FindBy(xpath= "//input[@id='evt_external_frn_key']")
    public WebElement externalEventIdTextbox;

    @FindBy(xpath= "//input[@id='evt_max_complete_reg']")
    public WebElement regCapacityTextbox;

    @FindBy(xpath = "//select[@name='currency']")
    public WebElement currencyDropdown;

    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement saveButton;

    @FindBy(xpath = "//select[@id='evt_frn_acnt_id']")
    public WebElement ACCOUNT;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Scheduled items, fees, merchandise and others.']")
    public WebElement AGENDA_TAB;

    @FindBy(xpath = "//select[@id='evt_audience']")
    public WebElement PRIMARY_EVENT_AUDIENCE_DROPDOWN;

    @FindBy(xpath = "//select[@name='evt_delivery']")
    public WebElement EVENT_DELIVERY_DROPDOWN;

    @FindBy(xpath = "//select[@name='evt_type']")
    public WebElement EVENT_TYPE_DROPDOWN;

    @FindBy(xpath = "//select[@name='evt_is_series']")
    public WebElement SESSION_SETUP_DROPDOWN;

    @FindBy(xpath = "//input[@name='evt_num_of_reg']")
    public WebElement REGISTRANT_GOAL_TEXTBOX;

    @FindBy(xpath = "//input[@name='evt_attendance_goal']")
    public WebElement ATTENDANCE_GOAL;

    public void testFillEventDetails(String eventName, String eventCode, String startTime, String endTime, String timezone, String status, String notes, String regInv, String currency, int noOfDays) throws Exception {
        Wait(saveButton, 30);
        VerifyAjaxRequestsFinished(30);
        enterEventName(eventName);
        enterEventCode(eventCode);
        enterStartDate(getCurrentDate());
        enterStartTime(startTime);
        enterEndDate(getDateByDays(noOfDays));
        enterEndTime(endTime);
        selectTimeZone(timezone);
        selectStatus(status);
        enterNotes(notes);
        enterRegInventory(regInv);
        selectCurrency(currency);
    }

    public void testFillEventDetails(Event event, int noOfDays) throws Exception {
        Wait(saveButton,30);
        VerifyAjaxRequestsFinished(30);
        enterEventName(event.getTitle());
        enterEventCode(event.getEventCode());
        enterStartDate(getCurrentDate());
        enterStartTime(event.getStartTime());
        enterEndDate(getDateByDays(noOfDays));
        enterEndTime(event.getEndTime());
        // selectTimeZone(event.getTimeZone());
        selectAccount(event.getAccount());
        selectStatus(event.getStatus());
        enterNotes(event.getNotes());
        enterExtEventID(event.getExternalEventID());
        enterRegInventory(event.getRegistrationInventory());
        selectCurrency(event.getCurrency());
    }

    public void fillBusinessAttributesAndFields(EventAttributes eventAttributes) throws Exception {
        Wait(PRIMARY_EVENT_AUDIENCE_DROPDOWN, 30);
        select(PRIMARY_EVENT_AUDIENCE_DROPDOWN, eventAttributes.getEventAudience());
        select(EVENT_DELIVERY_DROPDOWN, eventAttributes.getEventDelivery());
        select(EVENT_TYPE_DROPDOWN, eventAttributes.getEventType());
        select(SESSION_SETUP_DROPDOWN, eventAttributes.getSessionSetup());
        type(REGISTRANT_GOAL_TEXTBOX, eventAttributes.getRegistrantGoal(), true);
        type(ATTENDANCE_GOAL, eventAttributes.getAttendanceGoal(), true);


    }

    private void selectAccount(String account) {
        if (account == null || account.equalsIgnoreCase("")) {
            logReport("Account value is null");
        } else {
            select(ACCOUNT, account);
            logReport("Selected Value: " + account + " in 'Select Account' dropdown");
        }
    }
    private void enterExtEventID(String extEventID) {
        if (extEventID != null) {
            type(externalEventIdTextbox, extEventID,true);
            logReport("Entered Value: " + extEventID + " in 'External Event Id' TextBox");
        }
    }
    public EventListPage clickSave() throws Exception{
        click(saveButton);
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        return new EventListPage(browser);
    }

    private void enterEventName(String title) throws Exception{
        Wait(eventNameTextbox,30);
        type(eventNameTextbox, title);
        logReport("Entered Value: " + title + " in 'Title' TextBox");
    }

    private void enterEventCode(String eventCode) {
        type(eventCodeTextbox, eventCode,true);
        logReport("Entered Value: " + eventCode + " in 'Event Code' TextBox");
    }


    private void enterStartDate(String startDate) {
        type(startDateTextbox, startDate,true);
        startDateTextbox.sendKeys(Keys.TAB);
        logReport("Entered Value: " + startDate + " in 'Start Date' TextBox");
    }


    private void enterStartTime(String startTime) {
        type(startTimeTextbox, startTime,true);
        logReport("Entered Value: " + startTime + " in 'Start Time' TextBox");
    }


    private void enterEndDate(String endDate) {
        type(endDateTextbox, endDate,true);
        endDateTextbox.sendKeys(Keys.TAB);
        logReport("Entered Value: " + endDate + " in 'End Date' TextBox");
    }


    private void enterEndTime(String endTime) {
        type(endTimeTextbox, endTime,true);
        logReport("Entered Value: " + endTime + " in 'End Time' TextBox");
    }


    private void selectTimeZone(String timezone) {
        select(timezoneDropdown,timezone);
        logReport("Selected Value: " + timezone + " in 'Time Zone' dropdown");
    }

    private void selectStatus(String status) {
        select(statusDropdown,status);
        logReport("Selected Value: " + status + " in 'Status' dropdown");
    }


    private void enterNotes(String notes) {
        type(notesTextarea, notes,true);
        logReport("Entered Value: " + notes + " in 'Notes' TextBox");
    }

    private void enterRegInventory(String regInventory) {
        regCapacityTextbox.sendKeys(regInventory);
        logReport("Entered Value: " + regInventory + " in 'Registration Inventory' TextBox");
    }

    public void selectCurrency(String currency) {
        //webDriver.click(CURRENCY);
        select(currencyDropdown, currency);
        logReport("Selected Value: " + currency + " in 'Currency' dropdown");
    }

    @FindBy(xpath = "//select[@id='lstTagIds']")
    public WebElement TAGS_DROPDOWN;

    private void selectTags(String tag) {
        String a[] = tag.split(",");
        for (int i = 0; i < a.length; i++) {
            select(TAGS_DROPDOWN, a[i].trim());
            logReport("Selected Tag is : " + a[i].trim());
        }
    }

    public void testFillEventDetailsWithTags(Event event, int noOfDays) throws Exception {
        Wait(saveButton, 30);
        VerifyAjaxRequestsFinished(30);
        enterEventName(event.getTitle());
        enterEventCode(event.getEventCode());
        enterStartDate(getCurrentDate());
        enterStartTime(event.getStartTime());
        enterEndDate(getDateByDays(noOfDays));
        enterEndTime(event.getEndTime());
        // selectTimeZone(event.getTimeZone());
        selectAccount(event.getAccount());
        selectStatus(event.getStatus());
        selectTags(event.getEventTags());
        enterNotes(event.getNotes());
        enterExtEventID(event.getExternalEventID());
        enterRegInventory(event.getRegistrationInventory());
        selectCurrency(event.getCurrency());
    }

    public AgendaPage clickOnAgendaTab() throws Exception {
        VerifyPageReady(30);
        Wait(AGENDA_TAB, 30);
        click(AGENDA_TAB);
        logReport("Successfully clicked on agenda tab.");
        VerifyAngularHasFinishedProcessing(2);
        VerifyPageReady(3);
        return new AgendaPage(browser);
    }
}
