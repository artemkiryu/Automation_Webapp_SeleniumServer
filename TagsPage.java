package pageObjects;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pojo.AddTags;

/**
 * Created by infoobjects on 5/15/2017.
 */
public class TagsPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@placeholder='Name']")
    public WebElement NAME_TEXTBOX;
    @FindBy(xpath = "//input[@placeholder='Label']")
    public WebElement LABEL_TEXTBOX;
    @FindBy(xpath = "//input[@title='Add Tag']")
    public WebElement ADD_TAG_BUTTON;

    @FindBy(xpath = "//select[@x-ng-model='newTag.tagObjects']")
    public WebElement TAG_OBJECTS_DROPDOWN;

    @FindBy(xpath = "//input[@id='search-tags']")
    public WebElement TAG_SEARCH_TEXTBOX;
    @FindBy(xpath = "//button[@ng-click='search()']")
    public WebElement TAG_SEARCH_BUTTON;


    public TagsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for entering tag name value
     *
     * @param tagName name of tag
     */
    public void enterTagName(String tagName) throws Exception {
        Wait(NAME_TEXTBOX, 30);
        type(NAME_TEXTBOX, tagName, true);
        logReport("Entered tag name value " + tagName);
    }

    /**
     * Method for entering tag label value
     *
     * @param label label of tag
     */
    public void enterTagLabel(String label) {
        type(LABEL_TEXTBOX, label, true);
        logReport("Entered tag label value" + label);
    }

    /**
     * Method for clicking add button
     */
    public void clickAddButton() throws Exception {
        clickByJavaScript(ADD_TAG_BUTTON);
        // ADD_TAG_BUTTON.click();
        logReport("Add tag button clicked successfully");
        VerifyAngularHasFinishedProcessing(20);
        VerifyPageReady(20);
    }

    /**
     * Method for add tags
     *
     * @param addTags Page object of AddTags
     */
    public void addTags(AddTags addTags) throws Exception {
        String tagName = addTags.getTagName();

        if (searchTag(tagName)) {
            logReport("Tag with name " + tagName + " is already exist.");
        } else {
            enterTagName(addTags.getTagName());
            enterTagLabel(addTags.getTagLabel());
            selectTagObjects(addTags.getTagObject());
            clickAddButton();
        }
    }

    public void selectTagObjects(String objects) {
        String a[] = objects.split(",");
        if (a.length > 1) {
            for (int i = 0; i < a.length; i++) {
                select(TAG_OBJECTS_DROPDOWN, a[i]);
                logReport("Selected tag objects value " + objects);
            }
        } else
            select(TAG_OBJECTS_DROPDOWN, objects);
        logReport("Selected tag objects value " + objects);
    }

    public boolean searchTag(String tagName) throws Exception {
        enterValueInSearchTextBox(tagName);
        clickOnSearchButton();
        String xpath = "//input[@x-ng-model='tag.name']/..//following-sibling::span[text()='" + tagName + "']";
        return verifyElementDisplayed(By.xpath(xpath), 2);
    }

    public void enterValueInSearchTextBox(String value) throws Exception {
        Wait(TAG_SEARCH_TEXTBOX, 20);
        TAG_SEARCH_TEXTBOX.clear();
        type(TAG_SEARCH_TEXTBOX, value);
        logReport("successfully entered value : " + value + " in tag search text box.");
    }

    public void clickOnSearchButton() throws Exception {
        click(TAG_SEARCH_BUTTON);
        logReport("Tag Search button clicked successfully");
        VerifyAngularHasFinishedProcessing(20);
    }
}
