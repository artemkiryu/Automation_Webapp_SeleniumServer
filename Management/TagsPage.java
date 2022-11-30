package pageObjects.Management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddTags;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 31-08-2017.
 */
public class TagsPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@placeholder='Name']")
    public WebElement TAG_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@placeholder='Label']")
    public WebElement LABEL_TEXTBOX;
    @FindBy(xpath = "//input[@title='Add Tag']")
    public WebElement TAG_ADD_BTN;

    public TagsPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void addNewTag(AddTags addTags) throws Exception {
        Wait(TAG_ADD_BTN, 30);
        type(TAG_NAME_TEXTBOX, addTags.getTagName());
        type(LABEL_TEXTBOX, addTags.getTagLabel());
        click(TAG_ADD_BTN);
        logReport("New Tag added successfully");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
    }
}
