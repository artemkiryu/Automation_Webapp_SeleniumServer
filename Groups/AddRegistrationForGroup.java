package pageObjects.Groups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pageObjects.EventRegistrations.RegistrationImportPage;
import pojo.AddNewRegistrationDataForGroup;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 26-09-2017.
 */
public class AddRegistrationForGroup extends CommonActionsPage {

    @FindBy(xpath = "//input[@name='pro_fname']")
    public WebElement FIRST_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_lname']")
    public WebElement LAST_NAME_TEXTBOX;
    @FindBy(xpath = "//select[@id='regCatFee']")
    public WebElement ATENDEE_TYPE_DROPDOWN;
    @FindBy(xpath = "//div[@id='actions']//a[text()='Add Registration']")
    public WebElement ADD_REGISTRATION_FOR_GROUP_BUTTON;

    @FindBy(xpath = "//div[@id='actions']//a[text()='Import']")
    public WebElement IMPORT_TAB;

    public AddRegistrationForGroup(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public RegistrationImportPage clickImportTab() throws Exception {
        Wait(IMPORT_TAB, 30);
        VerifyAjaxRequestsFinished(30);
        click(IMPORT_TAB);
        return new RegistrationImportPage(browser);
    }

    public void clickAddNewRegistrationBtn() throws Exception {
        Wait(ADD_REGISTRATION_FOR_GROUP_BUTTON, 15);
        click(ADD_REGISTRATION_FOR_GROUP_BUTTON);
        logReport("Add registrations button clicked successfully");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
    }

    public void fillNewRegistrationDetailsForGroup(AddNewRegistrationDataForGroup addNewRegistrationDataForGroup) throws Exception {
        Wait(SAVE_BUTTON, 30);
        type(FIRST_NAME_TEXTBOX, addNewRegistrationDataForGroup.getFirstName());
        type(LAST_NAME_TEXTBOX, addNewRegistrationDataForGroup.getLastName());
        select(ATENDEE_TYPE_DROPDOWN, addNewRegistrationDataForGroup.getAttendeeType());

    }


}
