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
public class AppointmentPreferencesFormPage extends CommonActionsPage {
    @FindBy(xpath = "//label[text()='Attendee Types']/..//select")
    public WebElement ATTENDEE_TYPE_DROPDOWN;
    @FindBy(xpath = "//label[text()='Organization']/..//select")
    public WebElement ORGANIZATION_DROPDOWN;
    @FindBy(xpath = "//label[text()='Target Registrant']/..//select")
    public WebElement TARGET_REGISTRANT_DROPDOWN;
    @FindBy(xpath = "//label[text()='Rank']/..//select")
    public WebElement RANK_DROPDOWN;
    @FindBy(xpath = "//input[@value='Cancel']")
    public WebElement CANCEL_BUTTON;
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;

    public AppointmentPreferencesFormPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for select attendee type
     *
     * @param attendeeType name of attendee type
     */
    public void selectAttendeeType(String attendeeType) throws Exception {
        VerifyAngularHasFinishedProcessing(20);
        VerifyAjaxRequestsFinished(20);
        Wait(ATTENDEE_TYPE_DROPDOWN, 10);
        select(ATTENDEE_TYPE_DROPDOWN, attendeeType);
        logReport("selected attendee type " + attendeeType);
        VerifyAngularHasFinishedProcessing(20);
    }

    /**
     * Method for select organization name
     *
     * @param organization value of organization
     */
    public void selectOrganization(String organization) throws Exception {
        VerifyAngularHasFinishedProcessing(20);
        VerifyAjaxRequestsFinished(20);
        Wait(ORGANIZATION_DROPDOWN, 10);
        select(ORGANIZATION_DROPDOWN, organization);
        logReport("selected organization type " + organization);
        VerifyAngularHasFinishedProcessing(20);
    }

    /**
     * Method for select target registrant user
     *
     * @param targetRegistrant name of target registrant user
     */
    public void selectTargetRegistrant(String targetRegistrant) throws Exception {
        VerifyAngularHasFinishedProcessing(20);
        VerifyAjaxRequestsFinished(20);
        select(TARGET_REGISTRANT_DROPDOWN, targetRegistrant);
        logReport("selected target registrant user " + targetRegistrant);
        //webDriver.waitFor().waitForPageToLoad();
    }

    /**
     * Method for select rank
     *
     * @param rank value of rank
     */
    public void selectRank(String rank) throws Exception {
        VerifyAngularHasFinishedProcessing(20);
        VerifyAjaxRequestsFinished(20);
        select(RANK_DROPDOWN, rank);
        logReport("selected rank " + rank);
    }

    /**
     * Method for click save button under appointment preferences page
     *
     * @return AppointmentSearchPreferencesPage
     */
    public AppointmentSearchPreferencesPage clickSaveButton() throws Exception {
        SAVE_BUTTON.click();
        logReport("Save button clicked successfully");
        //webDriver.waitFor().waitForPageToLoad();
        return new AppointmentSearchPreferencesPage(browser);
    }

    /**
     * Method for check organization value is filtered or not
     *
     * @param organizationType value of organization type
     * @return boolean
     */
    public boolean isOrganizationFiltered(String organizationType) throws Exception {
        int i, j;
        WebElement getOrganizationText = ORGANIZATION_DROPDOWN;
        List<WebElement> getOrganizationLists = getOrganizationText.findElements(By.tagName("option"));
        for (i = 0; i < getOrganizationLists.size(); i++) {
            String elementText = getOrganizationLists.get(i).getText();
            if (elementText.equalsIgnoreCase(organizationType)) {
                return true;
            }

        }
        return false;

    }

    /**
     * Method for check target registrant users is filtered or not
     *
     * @param targetRegistrantName name of user
     * @return boolean
     */
    public boolean isTargetRegistrantFiltered(String targetRegistrantName) {
        int i, j;
        WebElement getRegistrantText = TARGET_REGISTRANT_DROPDOWN;
        List<WebElement> getRegistrantLists = getRegistrantText.findElements(By.tagName("option"));
        for (i = 0; i < getRegistrantLists.size(); i++) {
            String elementText = getRegistrantLists.get(i).getText();
            if (elementText.contains(targetRegistrantName)) {
                return true;
            }

        }
        return false;

    }


}
