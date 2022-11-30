package pageObjects.Appointments;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;


/**
 * Created by Aditi on 24-06-2015.
 */
public class AppointmentConfigurationPage extends CommonActionsPage {
    @FindBy(xpath = "//div[@id='appointment-eligibility']//input[@value='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//img[@class='registrationStatusEdit']")
    public WebElement REGISTRATION_STATUS_EDIT_ICON;
    @FindBy(xpath = "//div[@class='approvalStatusList']//img[@class='attendeeTypeEdit']")
    public WebElement APPROVAL_STATUS_EDIT_ICON;
    @FindBy(xpath = "//input[@id='status-eligibility-save']")
    public WebElement STATUS_ELIGIBILITY_SAVE_BUTTON;
    @FindBy(xpath = "//textarea[@ng-model='row.questionLabel']")
    public WebElement TEXTAREA_QUESTION_LABEL;
    @FindBy(xpath = "//div[text()='Appointment Filters']/..//img[@ng-click!='openNestedDialog(row.question)']")
    public WebElement ICON_EDIT_APPOINTMENT_FILTER_ATTENDEETYPE;
    @FindBy(xpath = "//input[@id='status-eligibility-save']")
    public WebElement APPOINTMENT_FILTERS_SAVE_BUTTON;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Templates']")
    public WebElement TEMPLATES_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Search']")
    public WebElement SEARCH_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Calendar Assignment']")
    public WebElement CALENDAR_ASSIGNMENT_TAB;
    @FindBy(xpath = "//div[text()='Status Eligibility']/..//img[@ng-click='showRegistrationStatusBox=!showRegistrationStatusBox']")
    public WebElement ICON_EDIT_REGISTRATION_STATUS;
    @FindBy(xpath = "//div[text()='Status Eligibility']/..//img[@ng-click='showApprovalStatusBox=!showApprovalStatusBox']")
    public WebElement ICON_EDIT_APPROVAL_STATUS;

    public AppointmentConfigurationPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for click edit icon in table using attendee type
     *
     * @param attendeeType name of attendee type
     */
    public void clickEditIconByAttendeeType(String attendeeType) throws Exception {
        VerifyPageReady(20);
        VerifyAngularHasFinishedProcessing(20);
        VerifyAjaxRequestsFinished(20);
        Thread.sleep(3000);
        //webDriver.waitFor().elementDisplayed(By.xpath("//div[@id='appointment-eligibility']"));
        String xpath = "//div[@id='appointment-eligibility']//table//tbody//tr//td[text()='" + attendeeType + "']/..//td//div//img[@title='Edit']";
        WebElement element = browser.findElement(By.xpath(xpath));
        element.click();
        logReport("Edit icon clicked successfully by attendee type " + attendeeType);
        VerifyPageReady(20);
    }

    /**
     * Method for select attendee type checkbox in table using attendee type
     *
     * @param attendeeType       name of attendee type
     * @param attendeeTypeToMeet name of attendee type which checkbox need to select
     */
    public void selectAttendeeTypeCheckbox(String attendeeType, String attendeeTypeToMeet) throws Exception {
        Thread.sleep(3000);
        String xpath = "//div[@id='appointment-eligibility']//table//tbody//tr//td[text()='" + attendeeType + "']/..//td//ul//li//label[contains(.,'" + attendeeTypeToMeet + "')]/..//input";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 20);
        check(element);
        logReport("checkbox attendee type to meet " + attendeeTypeToMeet + "checked corresponding to attendee " + attendeeType);
        VerifyPageReady(20);

    }

    /**
     * Method for clicking save button under appointment eligibility section
     */
    public void clickSaveButtonInAppointmentEligibility() throws Exception {
        VerifyPageReady(20);
        Wait(SAVE_BUTTON, 20);
        click(SAVE_BUTTON);
        logReport("Save button clicked under appointment eligibility section");
        VerifyPageReady(20);
        //webDriver.waitFor().waitforAngularJS();
    }

    /**
     * Method for check meet attendee type is saved or not corresponds to attendee type
     *
     * @param attendeeType       name of attendee type
     * @param attendeeTypeToMeet attendee type which we want to meet
     * @return boolean
     * @throws Exception
     */
    public boolean isAttendeeTypeSavedByAttendeeType(String attendeeType, String attendeeTypeToMeet) throws Exception {
        VerifyPageReady(20);
        VerifyAngularHasFinishedProcessing(20);
        VerifyAjaxRequestsFinished(20);
        VerifyAngularHasFinishedProcessing(20);
        Thread.sleep(5000);
        String xpath = "//div[@id='appointment-eligibility']//table//tbody//tr//td[text()='" + attendeeType + "']/..//td//div//span";
        WebElement getAttendeeType = browser.findElement(By.xpath(xpath));
        return getAttendeeType.getText().contains(attendeeTypeToMeet);
    }

    /**
     * Method for chcek allow preferences checkbox by attendee type
     *
     * @param attendeeType name of attendee type
     */
    public void checkAllowPreferencesCheckboxByAttendeeType(String attendeeType) throws Exception {
        WebElement element = browser.findElement(By.xpath("//div[@id='appointment-eligibility']"));
        Wait(element, 20);
        VerifyAngularHasFinishedProcessing(20);
        String xpath = "//div[@id='appointment-eligibility']//table//tbody//tr//td[text()='" + attendeeType + "']/..//td//input[@ng-model='row.allowPreScheduled']";
        check(xpath);
        logReport("check allow preferences checked successfully by attendee type " + attendeeType);
        VerifyPageReady(20);
    }

    /**
     * Method for clicking search tab
     *
     * @return AppointmentSearchPage
     */
    public AppointmentSearchPage clickSearchTab() throws Exception {
        Wait(SEARCH_TAB, 20);
        click(SEARCH_TAB);
        VerifyPageReady(20);
        logReport("Search tab clicked successfully");
        return new AppointmentSearchPage(browser);
    }

    /**
     * Method for clicking Calendar Assignment tab
     *
     * @return AppointmentSearchPage
     */
    public AppointmentCalendarAssignmentPage clickCalendarAssignmentTab() throws Exception {
        Wait(CALENDAR_ASSIGNMENT_TAB, 20);
        click(CALENDAR_ASSIGNMENT_TAB);
        VerifyPageReady(20);
        logReport("Calendar Assignment tab clicked successfully");
        return new AppointmentCalendarAssignmentPage(browser);
    }

    /**
     * Method for edit registration status icon
     */
    public void editRegistrationStatusIcon() throws Exception {
        Wait(REGISTRATION_STATUS_EDIT_ICON, 20);
        VerifyAjaxRequestsFinished(20);
        VerifyAngularHasFinishedProcessing(20);
        Thread.sleep(2000);
        click(REGISTRATION_STATUS_EDIT_ICON);
        logReport("Registration status edited successfully");
    }

    /**
     * Method for edit approval status icon
     */
    public void editApprovalStatusIcon() {
        click(APPROVAL_STATUS_EDIT_ICON);
        logReport("Approval status edited successfully");
    }

    /**
     * Method for clicking save button under status eligibility section
     */
    public void clickSaveStatusEligibilityButton() throws Exception {
        click(STATUS_ELIGIBILITY_SAVE_BUTTON);
        VerifyPageReady(20);
        VerifyAngularHasFinishedProcessing(20);
        logReport("Save status eligiblity button clicked successfully");
    }

    /**
     * Method for select reg status type
     *
     * @param regStatusType value of reg status
     */
    public void selectRegistrationStatus(String regStatusType) throws Exception {
        Thread.sleep(3000);
        String xpath = "//ul[@class='preferences attendeeTypeSelection']//li//label[contains(.,'" + regStatusType + "')]/..//input";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 10);
        check(element);
        logReport("Selected reg status type " + regStatusType);
    }

    /**
     * Method for select approval status
     *
     * @param approvalStatus value of approval status
     */
    public void selectApprovalStatus(String approvalStatus) throws Exception {
        Thread.sleep(3000);
        String xpath = "//ul[@class='preferences attendeeTypeSelection']//li//label[contains(.,'" + approvalStatus + "')]/..//input";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 10);
        check(element);
        logReport("Selected approval status type " + approvalStatus);
    }

    /**
     * Method for click templates tab
     *
     * @return AppointmentTemplatesPage
     */
    public AppointmentTemplatesPage clickTemplatesTab() throws Exception {
        Wait(TEMPLATES_TAB, 20);
        //webDriver.waitFor().waitforAngularJS();
        click(TEMPLATES_TAB);
        logReport("Templates tab clicked successfully");
        return new AppointmentTemplatesPage(browser);
    }


    /**
     * Method for entering question label in appointment filter section
     *
     * @param labelText value of label text
     */
    public void enterQuestionLabelInAppointmentFilterSection(String labelText) throws Exception {
        Wait(TEXTAREA_QUESTION_LABEL, 20);
        type(TEXTAREA_QUESTION_LABEL, labelText, true);
        logReport("Entered value: '" + labelText + "' in 'Question Label' textarea.");
        VerifyPageReady(20);
    }

    /**
     * Method for add attendee type in appointment filter section
     *
     * @param attendeType value of attendee type
     */
    public void addAttendeeTypeInAppointmentFilterSection(String attendeType) throws Exception {
        Wait(ICON_EDIT_APPOINTMENT_FILTER_ATTENDEETYPE, 20);
        click(ICON_EDIT_APPOINTMENT_FILTER_ATTENDEETYPE);
        VerifyPageReady(20);
        String xpath = "//label[text()='" + attendeType + "']/..//input[@ng-click='updateSelection(row, attendeeType)']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 10);
        check(element);
        VerifyPageReady(20);
    }

    /**
     * Method for clicking save button in appointment filter section
     */
    public void clickOnSaveButtonInAppointmentFilterSection() throws Exception {
        Wait(APPOINTMENT_FILTERS_SAVE_BUTTON, 20);
        click(APPOINTMENT_FILTERS_SAVE_BUTTON);
        logReport("Clicked on 'Save' button in 'Appointment filter' section.");
    }

    /**
     * Method for add reg status in status eligibility section
     *
     * @param attendeType name of attendee
     */
    public void addRegistrationStatusInStatusEligibilitySection(String attendeType) throws Exception {
        Wait(ICON_EDIT_REGISTRATION_STATUS, 20);
        click(ICON_EDIT_REGISTRATION_STATUS);
        VerifyPageReady(20);
        String xpath = "//label[contains(.,'" + attendeType + "')]/..//input[@ng-click='updateRegistrationStatusSelection(key)']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 10);
        check(element);
        VerifyPageReady(20);
    }

    /**
     * Method for add approval status in status eligibility section
     *
     * @param appravalStatus value of approval status
     */
    public void addApprovalStatusInStatusEligibilitySection(String appravalStatus) throws Exception {
        Wait(ICON_EDIT_APPROVAL_STATUS, 20);
        click(ICON_EDIT_APPROVAL_STATUS);
        VerifyPageReady(20);
        String xpath = "//label[contains(.,'" + appravalStatus + "')]/..//input[@ng-click='updateApprovalStatusSelection(key)']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 10);
        check(element);
        VerifyPageReady(20);
    }
}
