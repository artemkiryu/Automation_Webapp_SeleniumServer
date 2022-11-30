package pageObjects.Appointments;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;


/**
 * Created by Aditi on 25-06-2015.
 */
public class AppointmentSearchPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@id='value']")
    public WebElement SEARCH_TEXTBOX;
    @FindBy(xpath = "//input[@id='search']")
    public WebElement SEARCH_BUTTON;

    public AppointmentSearchPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for entering value in search textbox
     *
     * @param registrantEmail name of user which we want to search
     */
    public void enterValueInSearchTextBox(String registrantEmail) throws Exception {
        Wait(SEARCH_TEXTBOX, 20);
        type(SEARCH_TEXTBOX, registrantEmail, true);
        logReport("entered search field value " + registrantEmail);
    }

    /**
     * Method for clicking search button
     */
    public void clickSearchButton() throws Exception {
        click(SEARCH_BUTTON);
        logReport("Search button clicked successfully");
        VerifyAngularHasFinishedProcessing(20);
        VerifyPageReady(20);
    }

    /**
     * Method for clicking view appointment preferences icon
     *
     * @param registrantName name of registrant user
     * @return AppointmentSearchPreferencesPage
     */
    public AppointmentSearchPreferencesPage clickViewAppointmentPreferencesIcon(String registrantName) throws Exception {
        String xpath = "//table//tbody//tr//td[text()='" + registrantName + "']/..//td//span//img[@title='View Appointment Preferences']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 20);
        element.click();
        logReport("View Appointment Preferences icon clicked successfully by registrant name " + registrantName);
        VerifyPageReady(20);
        return new AppointmentSearchPreferencesPage(browser);
    }

    /**
     * Method for clicking view appointment calendar icon
     *
     * @param registrantName name of registrant user
     * @return AppointmentSearchCalendarPage
     */
    public AppointmentSearchCalendarPage clickViewAppointmentCalendar(String registrantName) throws Exception {
        String xpath = "//table//tbody//tr//td[text()='" + registrantName + "']/..//td//span//img[@title='View Appointment Calendar']";
        WebElement element = browser.findElement(By.xpath(xpath));
        element.click();
        logReport("View Appointment Calendar icon clicked successfully by registrant name " + registrantName);
        VerifyPageReady(20);
        VerifyAngularHasFinishedProcessing(20);
        return new AppointmentSearchCalendarPage(browser);
    }


}
