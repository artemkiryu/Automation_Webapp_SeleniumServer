package pageObjects.Groups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.GroupDetailsData;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 28-08-2017.
 */
public class AddGroupPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@x-ng-model='group.name']")
    public WebElement GROUP_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='group.code']")
    public WebElement GROUP_CODE_TEXTBOX;
    @FindBy(xpath = "//select[@x-ng-model='group.userId']")
    public WebElement ASSOCIATE_USER_DROPDOWN;
    @FindBy(xpath = "//select[@x-ng-model='userId']")
    public WebElement USER_DROPDOWN;
    @FindBy(xpath = "//input[@x-ng-model='group.description']")
    public WebElement DESCRIPTION_TEXTBOX;
    @FindBy(xpath = "//textarea[@x-ng-model='group.notes' or @ng-model='group.notes']")
    public WebElement NOTES_TEXTBOX;
    //@FindBy(xpath = "//input[contains(@id,'s2id_autogen')]")
    //@FindBy(xpath = "//select[contains(@id,'s2id_autogen')]")
    @FindBy(xpath = "//input[@id='s2id_autogen2']//li[text()='Attendee']")
    public WebElement ATTENDEE_TYPE_DROPDOWN;
    @FindBy(xpath = "//input[@id='s2id_autogen2']")
    public WebElement ATTENDEE_TYPE_INPUT_BOX;
    @FindBy(xpath = "//input[@id='group-save']")
    public WebElement GROUP_SAVE_BUTTON;

    public AddGroupPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void fillGroupDetails(GroupDetailsData groupDetailsData) throws Exception{
        Wait(GROUP_SAVE_BUTTON, 40);
        VerifyAjaxRequestsFinished(30);
        type(GROUP_NAME_TEXTBOX, groupDetailsData.getGroupName());
        type(GROUP_CODE_TEXTBOX, groupDetailsData.getGroupCode());
        //select(ASSOCIATE_USER_DROPDOWN, "");
        type(DESCRIPTION_TEXTBOX, groupDetailsData.getDescription());
        type(NOTES_TEXTBOX, groupDetailsData.getNotes());
        //select(ATTENDEE_TYPE_DROPDOWN, groupDetailsData.getAttendeeType());
        type(ATTENDEE_TYPE_INPUT_BOX, groupDetailsData.getAttendeeType());
        type(ATTENDEE_TYPE_INPUT_BOX, "{TAB}");


    }

    public void clickGroupSaveBtn() throws Exception {
        clickByJavaScript(GROUP_SAVE_BUTTON);
        logReport("Group Save button clicked successfully");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        // clickGroupListSideTab();
    }

    public GroupListPage clickGroupListSideTab() throws Exception {
        click(GROUP_LIST_TAB);
        logReport("Group List tab clicked successfully");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        return new GroupListPage(browser);
    }



}
