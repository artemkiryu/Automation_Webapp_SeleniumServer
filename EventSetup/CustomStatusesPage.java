package pageObjects.EventSetup;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.CustomStatusData;

/**
 * Created by infoobjects on 8/18/2017.
 */
public class CustomStatusesPage extends CommonActionsPage{

    public CustomStatusesPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//button[@id='create-link']")
    public WebElement ADD_NEW_BUTTON;

    @FindBy(xpath = "//input[@name='txtRegStsLabel']")
    public WebElement NAME_TEXTBOX;

    @FindBy(xpath = "//input[@name='intRegStsSequence']")
    public WebElement SORT_ORDER_TEXTBOX;

    @FindBy(xpath = "//select[@title='Custom Status Group']")
    public WebElement CUSTOM_STATUS_GROUP_DROPDOWN;

    @FindBy(xpath = "//input[@name='txtRegStsGroupName']")
    public WebElement ADD_NEW_GROUP_TEXTBOX;

    @FindBy(xpath = "//input[@name='txtRegStsDesc']")
    public WebElement DESCRIPTION_TEXTBOX;

    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement SAVE_BUTTON;




    public void clickOnAddNewButton()throws  Exception{
        VerifyPageReady(30);
        Wait(ADD_NEW_BUTTON,30);
        click(ADD_NEW_BUTTON);
        logReport("Successfully clicked on 'add new' button.");
    }

    public void enterName (String name) throws Exception {
        VerifyPageReady(30);
        Wait(NAME_TEXTBOX, 30);
        type(NAME_TEXTBOX, name);
        logReport("Entered Name" + name + "Successfully");
    }

    private void enterSortOrder (String order) throws Exception {
        VerifyPageReady(30);
        Wait(SORT_ORDER_TEXTBOX,30);
        type(SORT_ORDER_TEXTBOX, order);
        logReport("Entered sort order"+ order + "Successfully");
    }

    private void selectCustomStatus (String status) throws Exception {
        VerifyPageReady(30);
        Wait(CUSTOM_STATUS_GROUP_DROPDOWN,30);
        select(CUSTOM_STATUS_GROUP_DROPDOWN, status);
        logReport("select status"+ status + "Successfully");
    }

    private void enterAddNewGroup (String groupName) throws Exception {
        VerifyPageReady(30);
        Wait(ADD_NEW_GROUP_TEXTBOX, 30);
        type(ADD_NEW_GROUP_TEXTBOX, groupName);
        logReport("Entered group name" + groupName + "Successfully");
    }

    private void enterDescription (String text) throws Exception {
        VerifyPageReady(30);
        Wait(DESCRIPTION_TEXTBOX,30);
        type(DESCRIPTION_TEXTBOX, text);
        logReport("Entered description"+ text + "Successfully");
    }

    private void selectRegistrationStatus(String status){
        String xpath = "//span[text()='"+status+"']";
        browser.findElement(By.xpath(xpath)).click();
        logReport("Successfully clicked on registration status");
    }

    public void clickOnSaveButton()throws Exception{
        VerifyPageReady(30);
        Wait(SAVE_BUTTON, 30);
        click(SAVE_BUTTON);
        logReport("Successfully clicked on save button.");
    }

    public void fillCustomStatusDetails(CustomStatusData customStatusData) throws Exception{
        enterName(customStatusData.getName());
        enterSortOrder(customStatusData.getSortOrder());
        selectCustomStatus(customStatusData.getStatusGroup());
        enterAddNewGroup(customStatusData.getGroupName());
        enterDescription(customStatusData.getDescription());
        selectCustomStatus(customStatusData.getStatus());
        clickOnSaveButton();
    }


}
