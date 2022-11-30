package pageObjects.SpeakerPortal;

import excelFunctions.ExcelDataPool;
import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pageObjects.Communication.EventSpeakerEmailTemplatePage;
import pageObjects.Sessions.SessionsListPage;

import java.util.ArrayList;
import java.util.List;

public class SpeakerPortalAdminPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//a[@title='Pages']")
    public WebElement PAGES_TAB;
    @FindBy(xpath = "//input[@ng-value='eventviews.url']")
    public WebElement WEBURL_TEXTBOX;
    @FindBy(xpath = "//a[@class='actionIcon']")
    public WebElement WEBURL_ICON;

    @FindBy(xpath = "//div[@ng-if='noLayout']//div[@class='fs22 mt40 ng-binding']")
    public WebElement LAYOUT_TITLE;

    @FindBy(xpath = "//button[text()='Go to Session Layout']")
    public WebElement SESSION_LAYOUT_BUTTON;

    public static final By SPEAKER_PORTAL_CLOSE = By.xpath("//button[@ng-click='close()']");

    @FindBy(xpath = "//input[@x-ng-model='eventviews.name']")
    public WebElement NAME_TEXTBOX;

    @FindBy(xpath = "//input[@x-ng-model='eventviews.googleAnalyticTokens']")
    public WebElement GOOGLEANALYTICS_TEXTBOX;

    @FindBy(xpath = "//input[@x-ng-model='eventviews.loginTimeout']")
    public WebElement LOGIN_TIMEOUT_TEXTBOX;

    @FindBy(xpath = "//select[@x-ng-model='eventviews.dateDisplayFormat']")
    public WebElement DATEFORMAT_DROPDOWN;

    @FindBy(xpath = "//select[@x-ng-model='eventviews.timeDisplayFormat']")
    public WebElement TIMEFORMAT_DROPDOWN;

    @FindBy(xpath = "//select[@x-ng-model='emailTriggerOptions.selectedSubmissionEmailTemplate.emailTemplateId']")
    public WebElement SUCCESSFUL_SUBMISSION_DROPDOWN;

    @FindBy(xpath = "//select[@x-ng-model='emailTriggerOptions.selectedSessionApprovalTemplate.emailTemplateId']")
    public WebElement SESSION_APPROVED_DROPDOWN;

    @FindBy(xpath = "//select[@x-ng-model='emailTriggerOptions.selectedSessionTaskAssignTemplate.emailTemplateId']")
    public WebElement SESSION_TASK_ASSIGNED_DROPDOWN;

    @FindBy(xpath = "//span[text()='Email Trigger Event']")
    public WebElement EMAIL_TRIGGER_LABEL;

    @FindBy(xpath = "//span[text()='Email Template Used']")
    public WebElement EMAIL_TEMPLATE_LABEL;

    public static final String[] LAYOUT_ITEMS_LIST = {"An Open Submission Call", "Secured Submission Editing", "Speaker Tasks", "Custom Data Collection for Speakers and Sessions", "Control of Branding and Colors", "Additional HTML Pages"};
    @FindBy(xpath = "//div[@class='fs22 mt40 ng-binding']//ul//li")
    public List<WebElement> LIST_OF_ITEMS;
    @FindBy(xpath = "//h2[text()='Welcome to Speaker Portal Setup']")
    public WebElement HEADER1;
    @FindBy(xpath = "//h3[text()='As part of the Setup you will configure the following:']")
    public WebElement HEADER2;

    @FindBy(xpath = "//strong[text()='Promote >  Communication > Speaker Email Templates']")
    public WebElement LINK_SPEAKEREMAILTEMPLATEPAGE;

    public SpeakerPortalAdminPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void clickSaveButton() throws Exception {
        Wait(SAVE_BUTTON, 20);
        clickByJavaScript(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
    }

    public Pages clickPagesTab() throws Exception {
        Wait(PAGES_TAB, 20);
        clickByJavaScript(PAGES_TAB);
        logReport("Pages Tab clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        return new Pages(browser);
    }

    public String getWebUrlText() {
        return WEBURL_TEXTBOX.getAttribute("value").trim();
    }

    public SpeakerPortalLoginPage clickWebUrlIcon() throws Exception {
        Wait(WEBURL_ICON, 20);
        clickByJavaScript(WEBURL_ICON);
        logReport("WEb url icon clicked successfully");
        switchToLatestTabOrWindow();
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(20);
        return new SpeakerPortalLoginPage(browser);
    }

    public void clickCloseButton() throws Exception {
        try {
            if (VerifyElementPresent(SPEAKER_PORTAL_CLOSE, 1)) {
                browser.findElement(SPEAKER_PORTAL_CLOSE).click();
                logReport("Speaker Portal close layout");
                switchToLatestTabOrWindow();
                VerifyPageReady(10);
            }
        } catch (NoSuchElementException e) {
        }

    }

    public String getLayoutTitleText() {
        String text = LAYOUT_TITLE.getText().trim();
        return text;
    }

    public void clickSessionLayoutButton() throws Exception {
        click(SESSION_LAYOUT_BUTTON);
        logReport("Go to session layout button clicked successfully");
        VerifyPageReady(30);
    }

    public SessionsListPage clickManageSpeakerSessionMenuItem() throws Exception {
        VerifyAjaxRequestsFinished(20);
        VerifyPageReady(20);
        Wait(MANAGE_LINK, 20);
        click(MANAGE_LINK);
        Wait(SPEAKER_SESSION_MENUITEM, 20);
        clickByJavaScript(SPEAKER_SESSION_MENUITEM);
        VerifyPageReady(20);
        VerifyAngularHasFinishedProcessing(10);
        return new SessionsListPage(browser);
    }

    public boolean isWebUrlGenerated() {
        boolean found = false;
        try {
            if (WEBURL_TEXTBOX.getAttribute("value") != null || !WEBURL_TEXTBOX.getAttribute("value").isEmpty()) {
                found = true;
            }
        } catch (Exception e) {
            found = false;
        }
        return found;
    }

    public List<String> getSpeakerPortalItems() {
        List<String> itemsList = new ArrayList<>();
        for (WebElement e : LIST_OF_ITEMS) {
            itemsList.add(e.getText().trim());
        }
        return itemsList;
    }

    public String getSubmissionDropdownValue() {
        return getSelectedOption(SUCCESSFUL_SUBMISSION_DROPDOWN);
    }

    public String getApprovalDropdownValue() {
        return getSelectedOption(SESSION_APPROVED_DROPDOWN);
    }

    public String getSessionTaskAssignedDropdownValue() {
        return getSelectedOption(SESSION_TASK_ASSIGNED_DROPDOWN);
    }

    public EventSpeakerEmailTemplatePage clickSpeakerEmailTemplateLink() throws Exception {
        Wait(LINK_SPEAKEREMAILTEMPLATEPAGE, 30);
        clickByJavaScript(LINK_SPEAKEREMAILTEMPLATEPAGE);
        logReport("Speaker email template link clicked successfully");
        return new EventSpeakerEmailTemplatePage(browser);
    }

    public void selectSubmissionDropdownValue(String template) throws Exception {
        Wait(SUCCESSFUL_SUBMISSION_DROPDOWN, 20);
        select(SUCCESSFUL_SUBMISSION_DROPDOWN, template);
        logReport("Selected submision dropdown value " + template);
    }

    public void selectApprovalDropdownValue(String template) throws Exception {
        Wait(SESSION_APPROVED_DROPDOWN, 20);
        select(SESSION_APPROVED_DROPDOWN, template);
        logReport("Selected session approved dropdown " + template);
    }

    public void selectSessionTaskDropdownValue(String template) throws Exception {
        Wait(SESSION_TASK_ASSIGNED_DROPDOWN, 20);
        select(SESSION_TASK_ASSIGNED_DROPDOWN, template);
        logReport("Selected session task assigned dropdown " + template);
    }
}
