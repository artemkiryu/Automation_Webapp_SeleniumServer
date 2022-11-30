package pageObjects.Appointments;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;


/**
 * Created by bludshot on 13/7/15.
 */
public class AppointmentSearchCalendarPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@id='appointmentBtn']")
    public WebElement ADD_APPOINTMENT_BUTTON;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Search']")
    public WebElement SEARCH_TAB;
    @FindBy(xpath = "//input[@x-ng-model='searchCriteria.term']")
    public WebElement SEARCH_FIELD;
    @FindBy(xpath = "//input[@x-ng-model='searchCriteria.hasAppointment']")
    public WebElement HAS_APPOINTMENT_CHECKBOX;
    @FindBy(xpath = "//input[@id='search']")
    public WebElement SEARCH_BUTTON;

    public AppointmentSearchCalendarPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for clicking add appointment button
     *
     * @return AppointmentFormPage
     */
    public AppointmentFormPage clickAddAppointmentButton() throws Exception {
        Wait(ADD_APPOINTMENT_BUTTON, 10);
        click(ADD_APPOINTMENT_BUTTON);
        VerifyAngularHasFinishedProcessing(20);
        logReport("Clicked on Add Appointment Button");
        return new AppointmentFormPage(browser);
    }

    /**
     * Method for clicking search tab
     */
    public void clickSearchTab() throws Exception {
        Wait(SEARCH_TAB, 20);
        click(SEARCH_TAB);
        VerifyAngularHasFinishedProcessing(20);
        logReport("Clicked on 'Search' Tab.");
    }


    /**
     * Method for clicking appointment slot
     *
     * @param registrantName name of registrant
     * @return AppointmentFormPage
     */
    public AppointmentFormPage clickOnAppointmentSlot(String registrantName) throws Exception {
        String xpath = "//div[@class='fc-event-title'][contains(.,'" + registrantName + "')]";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 20);
        element.click();
        logReport("Successfully clicked on '" + registrantName + "' appointment slot.");
        VerifyAngularHasFinishedProcessing(20);
        VerifyPageReady(20);
        return new AppointmentFormPage(browser);
    }

    /**
     * Method for entering value in search field
     *
     * @param value value which need to be search
     */
    public void enterValueInSearchField(String value) throws Exception {
        Wait(SEARCH_FIELD, 10);
        type(SEARCH_FIELD, value, true);
        logReport("Entered value '" + value + "' in search field.");
        VerifyPageReady(20);
    }

    /**
     * Method for check has appointment checkbox
     */
    public void checkHasAppointmentCheckBox() throws Exception {
        Wait(HAS_APPOINTMENT_CHECKBOX, 10);
        check(HAS_APPOINTMENT_CHECKBOX);
        logReport("Successfully checked 'Has Appointment' checkbox.");
        VerifyPageReady(20);
    }

    /**
     * Method for clicking search button
     */
    public void clickOnSearchButton() throws Exception {
        Wait(SEARCH_BUTTON, 10);
        click(SEARCH_BUTTON);
        logReport("Clicked on 'Search' button.");
        VerifyAngularHasFinishedProcessing(20);
        VerifyPageReady(20);
    }

    /**
     * Method for get background color code
     *
     * @param registrantName name of registrant
     * @return String - color code of name
     */
    public String getBackGroundColorCode(String registrantName) {
        String xpath = "//div[@class='fc-event-title'][contains(.,'" + registrantName + "')]";
        WebElement element = browser.findElement(By.xpath(xpath));
        logReport(element.getCssValue("background-color"));
        return element.getCssValue("background-color");
    }

    /**
     * Method for checking appointment slot exist
     *
     * @param registrantName name of registrant
     * @return boolean - true if slot exist else false
     */
    public boolean isAppointmentSlotExists(String registrantName) {
        String xpath = "//div[@class='fc-event-title'][contains(.,'" + registrantName + "')]";
        // Wait(By.xpath(xpath));
        return isElementDisplayed(By.xpath(xpath), browser);
    }
}
