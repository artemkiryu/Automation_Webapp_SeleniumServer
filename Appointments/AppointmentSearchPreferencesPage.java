package pageObjects.Appointments;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import java.util.List;


/**
 * Created by Aditi on 25-06-2015.
 */
public class AppointmentSearchPreferencesPage extends CommonActionsPage {
    @FindBy(xpath = "//div[text()='Appointment Preferences']/..//div//input")
    public WebElement ADD_NEW_APPOINTMENT_PREFRENCES_BUTTON;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Search']")
    public WebElement SEARCH_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Pre-Scheduled/AME']")
    public WebElement AME_TAB;
    @FindBy(xpath = "//div[text()='Exclusion List']/..//div//input")
    public WebElement ADD_NEW_APPOINTMENT_EXCLUSION_BUTTON;

    public AppointmentSearchPreferencesPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for click add new appointment preference button
     *
     * @return AppointmentPreferencesFormPage
     */
    public AppointmentPreferencesFormPage clickAddNewAppointmentPreferenceButton() throws Exception {
        Wait(ADD_NEW_APPOINTMENT_PREFRENCES_BUTTON, 20);
        click(ADD_NEW_APPOINTMENT_PREFRENCES_BUTTON);
        logReport("Add new appointment preference button clicked successfully");
        VerifyPageReady(20);
        VerifyAngularHasFinishedProcessing(20);
        return new AppointmentPreferencesFormPage(browser);
    }

    /**
     * Method for click add new appointment exclusion button
     *
     * @return AppointmentPreferencesFormPage
     */
    public AppointmentPreferencesFormPage clickAddNewAppointmentExclusionButton() throws Exception {
        Wait(ADD_NEW_APPOINTMENT_EXCLUSION_BUTTON, 20);
        click(ADD_NEW_APPOINTMENT_EXCLUSION_BUTTON);
        logReport("Add new appointment exclusion button clicked successfully");
        VerifyPageReady(20);
        VerifyAngularHasFinishedProcessing(20);
        return new AppointmentPreferencesFormPage(browser);
    }

    /**
     * Method for check preference target user is found or not
     *
     * @param targetRegistrantName name of target registrant user
     * @return boolean
     */
    public boolean isPreferenceTargetFound(String targetRegistrantName) throws Exception {
        VerifyPageReady(20);
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        String xpath = "//div[text()='Appointment Preferences']/..//div//table//tbody//tr//td";
        List<WebElement> getColumnsList = browser.findElements(By.xpath(xpath));
        int i;
        for (i = 0; i < getColumnsList.size(); i++) {
            if (getColumnsList.get(i).getText().equals(targetRegistrantName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method for clicking search tab
     *
     * @return AppointmentSearchPage
     */
    public void clickSearchTab() throws Exception {
        Wait(SEARCH_TAB, 20);
        click(SEARCH_TAB);
        VerifyPageReady(20);
        logReport("Configure tab clicked successfully");
    }


    /**
     * Method for attendee name present in appointment exclusion list
     *
     * @param attendeeName name of attendee
     * @return boolean - true if attendee present else false
     */
    public boolean isAttendeePresentInAppointmentExclusionList(String attendeeName) {
        String xpath = "//div[text()='Exclusion List']/..//td[contains(.,'" + attendeeName + "')]";
        return isElementDisplayed(By.xpath(xpath), browser);
    }

    /**
     * Method for attendee name present in appointment preferences list
     *
     * @param attendeeName name of attendee
     * @return booelan - true if attendee present else false
     */
    public boolean isAttendeePresentInAppointmentPreferenceList(String attendeeName) {
        String xpath = "//div[text()='Appointment Preferences']/..//td[contains(.,'" + attendeeName + "')]";
        return isElementDisplayed(By.xpath(xpath), browser);
    }

}
