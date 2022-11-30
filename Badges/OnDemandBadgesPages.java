package pageObjects.Badges;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import java.util.List;

/**
 * Created by infoobjects on 22-08-2017.
 */
public class OnDemandBadgesPages extends CommonActionsPage {
    @FindBy(xpath = "//input[@value='Add New']")
    public WebElement ADD_NEW_BUTTON;
    @FindBy(xpath = "//input[@ng-model='modalBadge.name']")
    public WebElement NAME_TEXTBOX;
    @FindBy(xpath = "//button[text()='Next']")
    public WebElement NEXT_BUTTON;
    @FindBy(xpath = "//span[@class='select2-chosen']")
    public WebElement DROPDOWN_ARROW;
    @FindBy(xpath = "//ul[@role='listbox']//li//div")
    public List<WebElement> DROPDOWN_LIST;

    public OnDemandBadgesPages(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for clicking add new button
     */
    public void clickAddNew() throws Exception {
        logReport("Click on Add new Button");
        Wait(ADD_NEW_BUTTON, 20);
        click(ADD_NEW_BUTTON);
        VerifyAngularHasFinishedProcessing(20);
        logReport("Successfully clicked on Add new Button");
    }

    /**
     * Method for entering badge name
     *
     * @param badgeName : badge name
     */
    public void enterBadgeName(String badgeName) throws Exception {
        Wait(NAME_TEXTBOX, 10);
        logReport("Enter : " + badgeName + " into the name textbox");
        NAME_TEXTBOX.sendKeys(badgeName);
        logReport("Successfully entered : " + badgeName + " into name textbox");
    }


    /**
     * Method to click on save button.
     */
    public void clickNextButton() throws Exception {
        Wait(NEXT_BUTTON, 20);
        click(NEXT_BUTTON);
        logReport("Next button clicked successfully");
        VerifyAngularHasFinishedProcessing(20);
    }

    public void selectAttendeeTypeValue(String type) throws Exception {
        Wait(DROPDOWN_ARROW, 10);
        click(DROPDOWN_ARROW);
        for (WebElement e : DROPDOWN_LIST) {
            if (e.getText().trim().equalsIgnoreCase(type)) {
                e.click();
                logReport("Selected attendee type value " + type);
            }
        }
        VerifyAjaxRequestsFinished(20);
    }
}
