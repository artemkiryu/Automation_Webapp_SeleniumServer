package pageObjects.Groups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 29-08-2017.
 */
public class AssignGroupsPage extends CommonActionsPage {

    @FindBy(xpath = "//select[@ng-model='filter']")
    public WebElement FILTER_DROPDOWN;
    @FindBy(xpath = "//select[@ng-model='attendeeTypeIds']")
    public WebElement ATTENDEE_TYPES_DROPDOWN;
    @FindBy(xpath = "//input[@ng-model='selectAll']")
    public WebElement SELECT_ALL_CHK;
    @FindBy(xpath = "//span[@class='select2-arrow']")
    public WebElement GROUP_DROPDOWN_ARROW;
    @FindBy(xpath = "//div[@id='select2-drop']//ul[@class='select2-results']//li//div")
    public WebElement DROP_DOWN_OPTIONS_LIST;
    // public static final By INPUT_LIST_DROP_DOWN =  By.xpath("//div[@class='select2-search']//input[contains(@id,'autogen')]");
    @FindBy(xpath = "//input[@id='search']")
    public WebElement SEARCH_BUTTON;
    @FindBy(xpath = "//input[@id='value']")
    public WebElement SEARCH_TEXTBOX;
    @FindBy(xpath = "//button[text()='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//input[@id='s2id_autogen2_search']")
    public WebElement GROUP_INPUT_BOX;
    @FindBy(xpath = "//div[@id='s2id_autogen1']")
    public WebElement GROUP_DROPDOWN;
    @FindBy(xpath = "//div[@class='select2-search']//input[contains(@id,'autogen')]")
    WebElement INPUT_LIST_DROP_DOWN;

    public AssignGroupsPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void fillSaveAssignGroupDetails(String regName, String groupName) throws Exception {
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        Wait(SAVE_BUTTON, 30);
        String xpathReg = "//td[text()='" + regName + "']/preceding-sibling::td/input";
        logReport("Registration div xpath : " + xpathReg);
        WebElement element = browser.findElement(By.xpath(xpathReg));
        Wait(element, 15);
        checkByJavascript(element);
        scrollBottom();
        click(GROUP_DROPDOWN);
        Thread.sleep(5000);
        type(GROUP_INPUT_BOX, groupName);
        Thread.sleep(5000);
        type(GROUP_INPUT_BOX, "{TAB}");
        Thread.sleep(5000);
        click(SAVE_BUTTON);
        logReport("Assign group Save button clicked successfully");
        logReport("Assign group to registration successfully");
    }

}
