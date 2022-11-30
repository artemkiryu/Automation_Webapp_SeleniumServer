package pageObjects.Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;
import java.util.List;

public class SessionLayoutPage extends CommonActionsPage {

    @FindBy(xpath = "//div//label[text()='Automatically Publish Sessions']/..//following-sibling::div//input[@id='myonoffswitch']")

    public WebElement TOGGLE_BTN;
    @FindBy(xpath = "//div//label[text()='Automatically Publish Sessions']/..//following-sibling::div//input/..//following-sibling::div[@class='onoffswitch-switch']")

    public WebElement MINIMAL_FIELD_SET_TOGGLE_BUTTON;

    @FindBy(xpath = "//input[@ng-model='confSessionPageLayout.autoPublishAttendeeTypes']")
    public WebElement PUBLISH_FOR_ALL_CHECKBOX;

    @FindBy(xpath = "//div[@id='add-section']//span")
    public WebElement ADD_FIELDS_BUTTON;

    @FindBy(xpath = "//span//i[@aria-label='Add field']")
    public List<WebElement> ADD_FIELDS_BUTTON_LIST;

    @FindBy(xpath = "//div[@class='hidden-div']")
    public WebElement MOUSE_MOVE;

    @FindBy(xpath = "//div[@class='modal-content']//button[@class='custom-field-button']")

    public WebElement EXISTING_CUSTOM_FIELD_BUTTON;

    @FindBy(xpath = "//button[@x-ng-click='saveSessionLayout()']")
    public WebElement SAVE_SESSION_LAYOUT_BUTTON;

    public static final By STANDARD_SESSION_BOX = By.xpath("//strong[text()='Standard Sessions']");

    public static final By CONFERENCE_SESSION_BOX = By.xpath("//strong[text()='Conference Sessions']");

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Sessions']")

    public WebElement SESSIONS_TAB;

    @FindBy(xpath = "//label[text()='Speakers']")

    public WebElement HEADER_MASTER_SPEAKER;

    public SessionLayoutPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public SessionsListPage clickSessionsTab() throws Exception {
        Wait(SESSIONS_TAB, 20);
        clickByJavaScript(SESSIONS_TAB);
        logReport("Sessions tab clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyAjaxRequestsFinished(20);
        VerifyPageReady(20);
        return new SessionsListPage(browser);
    }

    public AddCustomFieldsPage clickOnExistingCustomFields() throws Exception {
        //VerifyPageReady(30);
        //  scrollCenter();
        Actions action = new Actions(browser);
        action.moveToElement(MOUSE_MOVE).build().perform();
        int size = ADD_FIELDS_BUTTON_LIST.size();
        logReport("size of add field button list " + size);
        WebElement element = ADD_FIELDS_BUTTON_LIST.get(ADD_FIELDS_BUTTON_LIST.size() - 1);
        clickByJavaScript(element);
        Thread.sleep(3000);
        Wait(EXISTING_CUSTOM_FIELD_BUTTON, 30);
        clickByJavaScript(EXISTING_CUSTOM_FIELD_BUTTON);
        logReport("Successfully clicked on Existing custom fields button.");
        VerifyAngularHasFinishedProcessing(30);
        return new AddCustomFieldsPage(browser);
    }

    public AddCustomFieldsPage clickOnExistingCustomFieldsForStandardSession() throws Exception {
        //VerifyPageReady(30);
        //  scrollCenter();
        Actions action = new Actions(browser);
        action.moveToElement(MOUSE_MOVE).build().perform();
        WebElement element = browser.findElement(By.xpath("//span[@data-target='#myModal']//i"));
        clickByJavaScript(element);
        Thread.sleep(2000);
        Wait(EXISTING_CUSTOM_FIELD_BUTTON, 30);
        clickByJavaScript(EXISTING_CUSTOM_FIELD_BUTTON);
        logReport("Successfully clicked on Existing custom fields button.");
        VerifyAngularHasFinishedProcessing(30);
        return new AddCustomFieldsPage(browser);
    }

    public void saveLayout() throws Exception {
        VerifyPageReady(30);
        //autoPublishSession();
        Wait(SAVE_SESSION_LAYOUT_BUTTON, 30);
        clickByJavaScript(SAVE_SESSION_LAYOUT_BUTTON);
        VerifyAngularHasFinishedProcessing(30);
    }

    public void clickStandardSessionLink() throws Exception {
        try {
            if (verifyElementDisplayed(STANDARD_SESSION_BOX, 6)) {
                browser.findElement(STANDARD_SESSION_BOX).click();
            }
        } catch (TimeoutException e) {
        }
    }

    public void clickConferenceSessionLink() throws Exception {
        try {
            if (verifyElementDisplayed(CONFERENCE_SESSION_BOX, 6)) {
                browser.findElement(CONFERENCE_SESSION_BOX).click();
            }
        } catch (TimeoutException e) {
        }
    }

    public void autoPublishSession() throws Exception {
        scrollBottom();
        boolean iconStatus = isToggleOnOff();
        logReport("Icon status in starting " + iconStatus);
        if (!iconStatus) {
            clickByJavaScript(MINIMAL_FIELD_SET_TOGGLE_BUTTON);
            Wait(PUBLISH_FOR_ALL_CHECKBOX, 10);
            if (!PUBLISH_FOR_ALL_CHECKBOX.isSelected()) {
                clickByJavaScript(PUBLISH_FOR_ALL_CHECKBOX);
                logReport("Successfully clicked on Publish for all checkbox.");
            }
        }
        logReport("Icon status in ending " + isToggleOnOff());

    }

    public void autoPublishOff() throws Exception {
        scrollBottom();
        boolean iconStatus = isToggleOnOff();
        logReport("Icon status in starting " + iconStatus);
        if (iconStatus) {
            clickByJavaScript(MINIMAL_FIELD_SET_TOGGLE_BUTTON);
            logReport("Toggle button off successfully");
        }
        logReport("Icon status in ending " + isToggleOnOff());

    }
    public boolean isToggleOnOff() throws Exception {
        String id = TOGGLE_BTN.getAttribute("id");
        return (boolean) executeJavascript("return $(document).find('[id=" + id + "]')[0].checked");
    }


}
