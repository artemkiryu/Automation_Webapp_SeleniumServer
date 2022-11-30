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
public class AppointmentsOverviewPage extends CommonActionsPage {
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Templates']")
    public WebElement TEMPLATES_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Configure']")
    public WebElement CONFIGURE_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Rotations']")
    public WebElement ROTATIONS_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Search']")
    public WebElement SEARCH_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Calendar Assignment']")
    public WebElement CALENDAR_ASSIGNMENT_TAB;

    public AppointmentsOverviewPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
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
     * Method for click configure tab
     *
     * @return AppointmentConfigurationPage
     */
    public AppointmentConfigurationPage clickConfigureTab() throws Exception {
        Wait(CONFIGURE_TAB, 20);
        VerifyAjaxRequestsFinished(20);
        VerifyAngularHasFinishedProcessing(20);
        Thread.sleep(10000);
        click(CONFIGURE_TAB);
        VerifyPageReady(20);
        Thread.sleep(3000);
        //webDriver.click(CONFIGURE_TAB);
        logReport("Configure tab clicked successfully");
        return new AppointmentConfigurationPage(browser);
    }

    /**
     * Method for click rotations tab
     *
     * @return AppointmentConfigurationPage
     */
    public AppointmentRotationsPage clickRotationsTab() throws Exception {
        Wait(ROTATIONS_TAB, 20);
        VerifyAjaxRequestsFinished(20);
        VerifyAngularHasFinishedProcessing(20);
        Thread.sleep(10000);
        click(ROTATIONS_TAB);
        VerifyPageReady(20);
        Thread.sleep(3000);
        //webDriver.click(CONFIGURE_TAB);
        logReport("Rotations tab clicked successfully");
        return new AppointmentRotationsPage(browser);
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

}
