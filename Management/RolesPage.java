package pageObjects.Management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 31-08-2017.
 */
public class RolesPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@id='acnt_use_parent_roles-false']")
    public WebElement CUSTOMIZE_ROLE_RADIO_BTN;
    @FindBy(xpath = "//div[contains(.,'Current List of Roles')]/button[text()='Add New']")
    public WebElement ROLES_ADD_NEW_BTN;

    public RolesPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void selectCustomizeRoles() throws Exception {
        Wait(CUSTOMIZE_ROLE_RADIO_BTN, 15);
        click(CUSTOMIZE_ROLE_RADIO_BTN);
        logReport("Customize roles for this account is enabled.");
    }

    public AddRolesPage clickOnAddNew() throws Exception {
        selectCustomizeRoles();
        Thread.sleep(500);
        Wait(ROLES_ADD_NEW_BTN, 15);
        click(ROLES_ADD_NEW_BTN);
        return new AddRolesPage(browser);
    }
}
