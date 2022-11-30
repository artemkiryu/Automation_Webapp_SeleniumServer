package pageObjects.Appointments;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;


/**
 * Created by infoobjects on 1/20/2016.
 */
public class AppointmentCalendarAssignmentPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@value='+']")
    public WebElement ADD_CALENDAR_BUTTON;
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Search']")
    public WebElement SEARCH_TAB;

    public AppointmentCalendarAssignmentPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for edit contact
     *
     * @param registrantName name of registrant
     */
    public void editContact(String registrantName) throws Exception {
        String xpath = "//td[text()='" + registrantName + "']/..//img[@title='Edit']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 20);
        element.click();
        logReport("Successfully clicked on edit '" + registrantName + "' contact.");
        VerifyAngularHasFinishedProcessing(20);
        VerifyPageReady(20);
    }

    /**
     * Method for check registrant present or not
     *
     * @param registrantName name of registrant
     * @return boolean - true if registrant found else false
     */
    public boolean isRegistrantPresent(String registrantName) {
        String xpath = "//td[text()='" + registrantName + "']/..//img[@title='Edit']";
        return isElementDisplayed(By.xpath(xpath), browser);
    }

    /**
     * Method for clicking add calendar button
     */
    public void clickOnAddCalendarButton() throws Exception {
        Wait(ADD_CALENDAR_BUTTON, 20);
        click(ADD_CALENDAR_BUTTON);
        logReport("Successfully clicked on 'Add Calendar' button.");
        VerifyPageReady(20);
    }

    /**
     * Method for clicking save button
     */
    public void clickOnSaveButton() throws Exception {
        Wait(SAVE_BUTTON, 20);
        click(SAVE_BUTTON);
        logReport("Successfully clicked on 'Save' button.");
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
        logReport("Configure tab clicked successfully");
        return new AppointmentSearchPage(browser);
    }
}
