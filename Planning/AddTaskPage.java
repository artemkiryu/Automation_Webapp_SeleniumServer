package pageObjects.Planning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.TaskDetailsData;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 25-08-2017.
 */
public class AddTaskPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@id='txtTaskSubject']")
    public WebElement SUBJECT_TEXTBOX;
    @FindBy(xpath = "//input[@id='dteTaskDueDate']")
    public WebElement DUE_DATE_TEXTBOX;
    @FindBy(xpath = "//input[@id='dteTaskDueDateTime']")
    public WebElement DUE_TIME_TEXTBOX;
    @FindBy(xpath = "//input[@id='dteTaskStartDate']")
    public WebElement START_DATE_TEXTBOX;
    @FindBy(xpath = "//select[@id='intTaskFrnStatusId']")
    public WebElement STATUS_DROPDOWN;
    @FindBy(xpath = "//select[@id='intTaskFrnPriorityId']")
    public WebElement PRIORITY_DROPDOWN;
    @FindBy(xpath = "//input[@id='bitTaskReminder']")
    public WebElement REMINDER_CHK;
    @FindBy(xpath = "//input[@id='dteTaskReminderDate']")
    public WebElement REMINDER_DATE_TEXTBOX;
    @FindBy(xpath = "//input[@id='dteTaskReminderDateTime']")
    public WebElement REMINDER_TIME_TEXTBOX;
    @FindBy(xpath = "//input[@id='txtTaskNotes']")
    public WebElement NOTES_TEXTAREA;
    @FindBy(xpath = "//select[@id='intTaskFrnAssignedBy']")
    public WebElement ASSIGNED_BY_EMAIL_DROPDOWN;
    @FindBy(xpath = "//select[@id='intTaskFrnAssignedTo']")
    public WebElement ASSIGNED_TO_EMAIL_DROPODWN;
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BTN;

    public AddTaskPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }
    private void checkUncheckReminderCheckbox(boolean state) {
        if (state) {
            check(REMINDER_CHK);
            reporter.info("Reminder set successfully");
        } else {
            unCheck(REMINDER_CHK);
            reporter.info("Reminder not set successfully");
        }
    }

    public void fillTaskDetails(TaskDetailsData taskDetailsData) throws Exception{
        Wait(SAVE_BUTTON, 30);
        VerifyAjaxRequestsFinished(30);
        type(SUBJECT_TEXTBOX, taskDetailsData.getSubject());
        type(DUE_DATE_TEXTBOX, taskDetailsData.getDueDate());
        type(DUE_TIME_TEXTBOX, taskDetailsData.getDueTime());
        type(START_DATE_TEXTBOX, taskDetailsData.getStartDate());
        select(STATUS_DROPDOWN, taskDetailsData.getStatus());
        select(PRIORITY_DROPDOWN, taskDetailsData.getPriority());
        checkUncheckReminderCheckbox(Boolean.parseBoolean(taskDetailsData.getReminder()));
        type(REMINDER_DATE_TEXTBOX, taskDetailsData.getReminderDate());
        type(REMINDER_TIME_TEXTBOX, taskDetailsData.getReminderTime());
        type(NOTES_TEXTAREA, taskDetailsData.getNotes());
        select(ASSIGNED_BY_EMAIL_DROPDOWN, taskDetailsData.getName());
        select(ASSIGNED_TO_EMAIL_DROPODWN, taskDetailsData.getName());


    }
    /*public void clickSaveButton() throws Exception {
        VerifyPageReady(30);
        Wait(SAVE_BTN, 30);
        click(SAVE_BTN);
        logReport("Successfully clicked on 'Save' button.");
    }*/
}
