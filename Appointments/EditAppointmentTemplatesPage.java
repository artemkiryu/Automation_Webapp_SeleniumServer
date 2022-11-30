package pageObjects.Appointments;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AppointmentTemplateDetails;

/**
 * Created by Aditi on 23-06-2015.
 */
public class EditAppointmentTemplatesPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@id='minPreferences']")
    public WebElement TEXTBOX_MINIMUM_PREFERENCE;
    @FindBy(xpath = "//input[@id='maxPreferences']")
    public WebElement TEXTBOX_MAXIMUM_PREFERENCE;
    @FindBy(xpath = "//input[@id='minAppointments']")
    public WebElement TEXTBOX_MINIMUM_APPOINTMENTS;
    @FindBy(xpath = "//input[@id='maxAppointmentsPerOrganization']")
    public WebElement TEXTBOX_MAXIMUM_APPOINTMENTS_PREFERENCE;
    @FindBy(xpath = "//input[@id='maxAppointmentsPerOrg']")
    public WebElement TEXTBOX_MAXIMUM_APPOINTMENTS_PREFERENCE_PER_ORG;
    @FindBy(xpath = "//input[@id='maxAppointmentsPerDay']")
    public WebElement TEXTBOX_MAXIMUM_PRESHEDULED_APPOINTMENTS_PERDAY;
    @FindBy(xpath = "//input[@id='maxAppointmentsPerEvent']")
    public WebElement TEXTBOX_MAXIMUM_PRESHEDULED_APPOINTMENTS_PEREVENT;
    @FindBy(xpath = "//input[@id='maxBlackList']")
    public WebElement TEXTBOX_MAXIMUM_EXCLUSION;
    @FindBy(xpath = "//input[@id='appointment-block-add']")
    public WebElement ADD_BLOCK_BUTTON;
    @FindBy(xpath = "//div[@class='fc-event-inner block']")
    public WebElement EVENT_BLOCK_IN_CALENDER;
    @FindBy(xpath = "//input[@id='appointment-default-save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//input[@id='save-and-close']")
    public WebElement SAVE2_BUTTON;
    @FindBy(xpath = "//input[@id='template-add']")
    public WebElement ADD_NEW_BUTTON;
    @FindBy(xpath = "//label[text()='Template Name']/..//input")
    public WebElement TEMPLATE_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@id='description']")
    public WebElement TEMPLATE_DESCRIPTION_TEXTBOX;

    public EditAppointmentTemplatesPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for click add block button
     *
     * @return AddAppointmentBlockPage
     */
    public AddAppointmentBlockPage clickAddBlockButton() throws Exception {
        VerifyAjaxRequestsFinished(20);
        Wait(ADD_BLOCK_BUTTON, 20);
        click(ADD_BLOCK_BUTTON);
        logReport("Add block button clicked successfully");
        VerifyPageReady(20);
        VerifyAjaxRequestsFinished(20);
        return new AddAppointmentBlockPage(browser);
    }

    public void clickEventBlockInCalender() {
        click(EVENT_BLOCK_IN_CALENDER);
    }


    /**
     * Method for entering minimum preferences
     *
     * @param number value of min number
     */
    public void enterMinimumPreferences(String number) throws Exception {
        Wait(TEXTBOX_MINIMUM_PREFERENCE, 10);
        type(TEXTBOX_MINIMUM_PREFERENCE, number, true);
        logReport("Entered value: '" + number + "' in 'Minimum Preference' textbox.");
        VerifyPageReady(20);
    }

    /**
     * Method for entering maximum preferences
     *
     * @param number value of max number
     */
    public void enterMaximumPreferences(String number) {
        type(TEXTBOX_MAXIMUM_PREFERENCE, number, true);
        logReport("Entered value: '" + number + "' in 'Maximum Preference' textbox.");

    }

    /**
     * Method for entering miniumum appointments
     *
     * @param number value of appointment number
     */
    public void enterMinimumAppointments(String number) {
        type(TEXTBOX_MINIMUM_APPOINTMENTS, number, true);
        logReport("Entered value: '" + number + "' in 'Minimum Appointments' textbox.");

    }

    /**
     * Method for entering maximum exclusion
     *
     * @param number value of max exclusion number
     */
    public void enterMaximumExclusion(String number) {
        type(TEXTBOX_MAXIMUM_EXCLUSION, number, true);
        logReport("Entered value: '" + number + "' in 'Maximum Exclusion' textbox.");

    }

    /**
     * Method for entering max appointment preferences
     *
     * @param number value of max appointment number
     */
    public void enterMaximumAppointmentsPreferences(String number) {
        type(TEXTBOX_MAXIMUM_APPOINTMENTS_PREFERENCE, number, true);
        logReport("Entered value: '" + number + "' in 'Maximum Appointment Preferences' textbox.");

    }

    /**
     * Method for entering max appointment preferences per organization
     *
     * @param number value of max appointment preferences per org
     */
    public void enterMaximumAppointmentsPreferencesPerOrg(String number) {
        type(TEXTBOX_MAXIMUM_APPOINTMENTS_PREFERENCE_PER_ORG, number, true);
        logReport("Entered value: '" + number + "' in 'Maximum Appointment Preferences' textbox.");

    }

    /**
     * Method for entering max pre scheduled appointment
     *
     * @param number value of max pre scheduled per day
     */
    public void enterMaximumPreScheduledAppointmentPerDay(String number) {
        type(TEXTBOX_MAXIMUM_PRESHEDULED_APPOINTMENTS_PERDAY, number, true);
        logReport("Entered value: '" + number + "' in 'Maximum Prescheduled Appointment Per Day' textbox.");

    }

    /**
     * Method for entering max pre scheduled appointment
     *
     * @param number value of max pre scheduled per event
     */
    public void enterMaximumPreScheduledAppointmentPerEvent(String number) {
        type(TEXTBOX_MAXIMUM_PRESHEDULED_APPOINTMENTS_PEREVENT, number, true);
        logReport("Entered value: '" + number + "' in 'Maximum Prescheduled Appointment Per Event' textbox.");

    }

    /**
     * Method for fill appointment default template details
     *
     * @param appointmentTemplateDetails page object of appointmentTemplateDetails
     */
    public void fillAppointmentDefaultTemplateDetails(AppointmentTemplateDetails appointmentTemplateDetails) throws Exception {
        enterMinimumPreferences(appointmentTemplateDetails.getMinimumPreferences());
        enterMaximumPreferences(appointmentTemplateDetails.getMaximumPreferences());
        enterMaximumAppointmentsPreferences(appointmentTemplateDetails.getMaximumAppointmentPreferences());
        enterMinimumAppointments(appointmentTemplateDetails.getMinimumAppointment());
        enterMaximumPreScheduledAppointmentPerDay(appointmentTemplateDetails.getMaximumPrescheduledAppointmentPerDay());
        enterMaximumPreScheduledAppointmentPerEvent(appointmentTemplateDetails.getMaximumPrescheduledAppointmentPerEvent());
        enterMaximumExclusion(appointmentTemplateDetails.getMaximumExclusion());

    }

    /**
     * Method for clicking save button
     */
    public void clickOnSaveButton() throws Exception {
        Wait(SAVE_BUTTON, 10);
        click(SAVE_BUTTON);
        logReport("Clicked on 'Save' button.");
        VerifyAjaxRequestsFinished(20);
        VerifyPageReady(20);
    }

    /**
     * Method for clicking save and close button
     */
    public void clickSaveButton() throws Exception {
        Wait(SAVE2_BUTTON, 10);
        click(SAVE2_BUTTON);
        logReport("Clicked on 'Save' button.");
        VerifyAjaxRequestsFinished(20);
        VerifyPageReady(20);
    }

    /**
     * Method for clicking add new button
     */
    public void clickOnAddNewButton() throws Exception {
        Wait(ADD_NEW_BUTTON, 10);
        click(ADD_NEW_BUTTON);
        logReport("Successfully clicked on 'Add New' button.");
        VerifyAjaxRequestsFinished(20);
        VerifyPageReady(20);
    }

    /**
     * Method for entering appoinment name
     *
     * @param appointmentTemplateName appointment template name
     */
    public void enterAppointmentName(String appointmentTemplateName) throws Exception {
        Wait(TEMPLATE_NAME_TEXTBOX, 10);
        type(TEMPLATE_NAME_TEXTBOX, appointmentTemplateName, true);
        logReport("Entered value: '" + appointmentTemplateName + "' in 'Template Name' textbox.");

    }

    /**
     * Method for entering appointment description
     *
     * @param appointmentTemplateDescription appointment template description
     */
    public void enterAppointmentDescription(String appointmentTemplateDescription) {
        type(TEMPLATE_DESCRIPTION_TEXTBOX, appointmentTemplateDescription, true);
        logReport("Entered value: '" + appointmentTemplateDescription + "' in 'Template Description' textbox.");

    }

    /**
     * Method for create appointment template
     *
     * @param appointmentTemplateDetails page object of appointmentTemplateDetails
     */
    public void createAppointmentTemplate(AppointmentTemplateDetails appointmentTemplateDetails) throws Exception {
        enterAppointmentName(appointmentTemplateDetails.getAppointmentTemplateName());
        enterAppointmentDescription(appointmentTemplateDetails.getAppointmentTemplateDescription());
        enterMinimumPreferences(appointmentTemplateDetails.getMinimumPreferences());
        enterMaximumPreferences(appointmentTemplateDetails.getMaximumPreferences());
        enterMaximumAppointmentsPreferencesPerOrg(appointmentTemplateDetails.getMaximumAppointmentPreferences());
        enterMinimumAppointments(appointmentTemplateDetails.getMinimumAppointment());
        enterMaximumPreScheduledAppointmentPerDay(appointmentTemplateDetails.getMaximumPrescheduledAppointmentPerDay());
        enterMaximumPreScheduledAppointmentPerEvent(appointmentTemplateDetails.getMaximumPrescheduledAppointmentPerEvent());
        enterMaximumExclusion(appointmentTemplateDetails.getMaximumExclusion());

    }


}
