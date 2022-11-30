package pageObjects.Appointments;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

/**
 * Created by Aditi on 23-06-2015.
 */
public class AppointmentTemplatesPage extends CommonActionsPage {
    @FindBy(xpath = "//table[@id='template-table']//tbody//tr//td//b[text()='Default Template']/../..//td//img[@title='Edit']")
    public WebElement EDIT_DEFAULT_TEMPLATES_BUTTON;
    @FindBy(xpath = "//input[@id='save-and-close']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//input[@id='template-add']")
    public WebElement ADD_NEW_BUTTON;
    @FindBy(xpath = "//label[text()='Template Name']/..//input")
    public WebElement TEMPLATE_NAME_TEXTBOX;

    public AppointmentTemplatesPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for edit default templates button
     *
     * @return EditAppointmentTemplatesPage
     */
    public EditAppointmentTemplatesPage clickEditDefaultTemplatesButton() throws Exception {
        Wait(EDIT_DEFAULT_TEMPLATES_BUTTON, 20);
        click(EDIT_DEFAULT_TEMPLATES_BUTTON);
        logReport("Default templates edited successfully");
        VerifyPageReady(20);
        return new EditAppointmentTemplatesPage(browser);

    }

    /**
     * Method for clicking add new button
     */
    public void clickAddNewButton() throws Exception {
        click(ADD_NEW_BUTTON);
        logReport("Add new button clicked successfully");
        VerifyPageReady(20);
        VerifyAjaxRequestsFinished(20);
    }

    /**
     * Method for entering template name
     *
     * @param template value of template
     */
    public void enterTemplateName(String template) {
        type(TEMPLATE_NAME_TEXTBOX, template, true);
        logReport("Entered template name" + template);
    }

    /**
     * Method for clicking save button
     */
    public void clickSaveButton() throws Exception {
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyAjaxRequestsFinished(20);
        //webDriver.waitFor().waitforAngularJS();
    }

    /**
     * Method for click rotations tab
     *
     * @return AppointmentConfigurationPage
     */
    public AppointmentRotationsPage clickRotationsTab() throws Exception {
        Wait(ROTATIONS_TAB, 20);
        click(ROTATIONS_TAB);
        VerifyPageReady(20);

        logReport("Rotations tab clicked successfully");
        return new AppointmentRotationsPage(browser);
    }
}
