package pageObjects.SpeakerPortal;

import org.apache.commons.configuration.ConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sqlite.util.StringUtils;
import pageObjects.CommonActionsPage;
import pojo.AddSessionData;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySessionsPage extends CommonActionsPage {
    @FindBy(xpath = "//div[@ng-repeat='session in sessionList']/div")
    public List<WebElement> LIST_SESSIONS_SUBMITTED;

    @FindBy(xpath = "//input[@disabled='disabled']")
    public List<WebElement> FIELDS_READ_ONLY_SESSIONS;

    @FindBy(xpath = "//p[text()='No record found.']")
    public WebElement NO_RECORD_FOUND;

    @FindBy(xpath = "//input[@x-ng-model='session.name']")
    public WebElement SESSION_NAME_TEXTBOX;

    @FindBy(xpath = "//div[@class='typeDropdown dropdown']//button")
    public WebElement SESSION_TYPE_VALUE;

    @FindBy(xpath = "//label[text()='Track']/..//following-sibling::div//div[@class='levelDropdown dropdown']//button")
    public WebElement TRACK_VALUE;

    @FindBy(xpath = "//label[text()='Session Level']/..//following-sibling::div//div[@class='levelDropdown dropdown']//button")
    public WebElement SESSION_LEVEL_VALUE;

    @FindBy(xpath = "//input[@x-ng-model='session.sessionCode']")
    public WebElement SESSION_CODE_TEXTBOX;

    @FindBy(xpath = "//label[text()='Tags']/..//following-sibling::div//select")
    public WebElement TAGS_DRODPOWN;

    @FindBy(xpath = "//label[text()='Points']/..//following-sibling::div//input[@x-ng-model='session[section.modelKey]']")
    public WebElement POINTS_TEXTBOX;

    @FindBy(xpath = "//label[text()='CEU Credits']/..//following-sibling::div//input[@x-ng-model='session[section.modelKey]']")
    public WebElement CEUCREDITS_TEXTBOX;

    @FindBy(xpath = "//label[text()='Job Functions']/..//following-sibling::div//select[@x-ng-model='session[section.modelKey]']")
    public WebElement JOB_FUNCTIONS_DROPDOWN;

    @FindBy(xpath = "//label[text()='Industries']/..//following-sibling::div//select[@x-ng-model='session[section.modelKey]']")
    public WebElement INDUSTRIES_DROPDOWN;

    @FindBy(xpath = "//label[text()='Session Notes']/..//following-sibling::div//textarea")
    public WebElement SESSION_NOTES_TEXTAREA;

    @FindBy(xpath = "//label[text()='Session Label']/..//following-sibling::div//input[@x-ng-model='session[section.modelKey]']")
    public WebElement SESSION_LABEL_TEXTBOX;

    @FindBy(xpath = "//span[contains(@ng-if,'abstractSessionDoc')]/a")
    public WebElement ABSTRACT_FILE_VALUE;

    @FindBy(xpath = "//tr[@ng-repeat='document in nonAbstractSessionDocs']//a")
    public WebElement SESSION_FILE_VALUE;

    @FindBy(xpath = "//div[@ng-repeat='sessionSpeaker in sessionSpeakers']//strong")
    public List<WebElement> MASTER_SPEAKERS;

    @FindBy(xpath = "//div[@ng-repeat='instance in pollingInstance = (session.confSessionInstance | filter:myInstanceFilter)']//p[1]")
    public WebElement START_DATE_TIME;

    @FindBy(xpath = "//div[@ng-repeat='instance in pollingInstance = (session.confSessionInstance | filter:myInstanceFilter)']//p[2]")
    public WebElement END_DATE_TIME;

    @FindBy(xpath = "//div[@title='Instances']//following-sibling::div//p[text()='No record found.']")
    public WebElement INSTANCE_NORECORDS_FOUND;

    @FindBy(xpath = "//label[text()='Session Type']/..//button[@id='dLabel']")
    public WebElement SESSION_TYPE_BUTTON;

    @FindBy(xpath = "//label[text()='Session Type']/..//following-sibling::div/ul/div[2]//div")
    public List<WebElement> SESSION_TYPE_DROPDOWN_LIST;

    @FindBy(xpath = "//input[@x-ng-click='saveEntity()']")
    public WebElement SAVE_SPEAKER_PORTAL;

    @FindBy(xpath = "//input[@x-ng-click='goToListView()']")
    public WebElement CANCEL_SPEAKER_PORTAL;

    @FindBy(xpath = "//span[@ng-click='goToListView()']")
    public WebElement LIST_VIEW;

    @FindBy(xpath = "//span[contains(@ng-if,'abstractSessionDoc')]/..//button")
    public WebElement ABSTRACT_UPLOAD_FILE;

    @FindBy(xpath = "//input[contains(@ng-if,'nonAbstractSessionDoc')]//following-sibling::span/button")
    public WebElement SESSION_UPLOAD_FILE;

    @FindBy(xpath = "//span[contains(@ng-if,'abstractSessionDoc')]/..//following-sibling::div//input[@type='file']")
    public WebElement FILE_CHOOSER_BUTTON_ABSTRACT;

    @FindBy(xpath = "//input[contains(@ng-if,'nonAbstractSessionDoc')]/..//following-sibling::div//input[@type='file']")
    public WebElement FILE_CHOOSER_BUTTON_SESSION;


    private void switchToIframe(String iFrameTitle) {
        browser.switchTo().defaultContent();
        WebElement frame = browser.findElement(By.xpath("//div[@title='" + iFrameTitle + "']//following-sibling::div//iframe"));
        browser.switchTo().frame(frame);
        reporter.info("Switched into iFrame of " + iFrameTitle);
    }

    public MySessionsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public boolean isSessionSubmitted(String sessionName) {
        List<String> sessionList = new ArrayList<>();
        for (WebElement e : LIST_SESSIONS_SUBMITTED) {
            if (e.getAttribute("title").trim().equalsIgnoreCase(sessionName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFieldsReadOnlyModeInMySessionsPage() {
        return FIELDS_READ_ONLY_SESSIONS.size() > 1;
    }

    public boolean isCustomFieldDisplayed(String fieldName) {
        String xpath = "//input[@placeholder='" + fieldName + "']";
        WebElement element = browser.findElement(By.xpath(xpath));
        return verifyElementDisplayed(element, 2);
    }

    public boolean isSessionFoundWithStatus(String sessionName, String sessionStatus) {
        String xpath = "//div[@class='accordion-heading']//div[contains(.,'" + sessionName + "')]/..//a/span[text()='" + sessionStatus + "']";
        return verifyElementDisplayed(By.xpath(xpath), 20);
    }

    public void clickSessionNameByStatus(String sessionName, String sessionStatus) throws Exception {
        String xpath = "//div[@class='accordion-heading']//div[contains(.,'" + sessionName + "')]/..//a/span[text()='" + sessionStatus + "']";
        WebElement element = browser.findElement(By.xpath(xpath));
        click(element);
        logReport("Session Name " + sessionName + "clicked successfully by status " + sessionStatus);
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
    }

    private static final String TIME12HOURS_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";

    public boolean isInstanceNotFoundWithQualifiedStatus() {
        return verifyElementDisplayed(INSTANCE_NORECORDS_FOUND, 10);
    }

    public boolean isSessionMandatoryFields(String sessionTitle) {
        String xpath = "//label[text()='" + sessionTitle + "'][contains(@class,'required')]";
        return verifyElementDisplayed(By.xpath(xpath), 10);
    }

    public void fillSessionDetails(AddSessionData addSessionData) throws Exception {
        Wait(SESSION_NAME_TEXTBOX, 20);
        type(SESSION_NAME_TEXTBOX, addSessionData.getSessionName(), true);
        logReport("Entered session name value " + addSessionData.getSessionName());
        selectSessionType(addSessionData.getSessionType());
        logReport("Selected session type " + addSessionData.getSessionType());
    }

    public void selectSessionType(String sessionType) throws Exception {
        click(SESSION_TYPE_BUTTON);
        logReport("click on session type dropdown button.");
        for (WebElement e : SESSION_TYPE_DROPDOWN_LIST) {
            if (e.getText().trim().equalsIgnoreCase(sessionType)) {
                e.click();
                logReport("Session type exist and clicked successfully");
                return;
            }
        }


    }

    private Pattern pattern;

    public void clickSpeakerPortalCancelButton() {
        click(CANCEL_SPEAKER_PORTAL);
        logReport("Speaker portal button saved successfully");
        VerifyAngularHasFinishedProcessing(10);
    }

    public void clickBackToList() {
        click(LIST_VIEW);
        logReport("Go to list view button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
    }

    private Matcher matcher;

    public List<String> getSessionDetails() throws Exception {
        List<String> sessionDetails = new ArrayList<>();
        StringBuilder instanceSpeakers = new StringBuilder();
        Wait(SESSION_NAME_TEXTBOX, 30);
        String sessionName = SESSION_NAME_TEXTBOX.getAttribute("value").trim();
        String sessiontype = SESSION_TYPE_VALUE.getText().trim();
        String sessionCode = SESSION_CODE_TEXTBOX.getAttribute("value").trim();
        String track = TRACK_VALUE.getText().trim();
        List<String> tagsList = getSelectedOptions(TAGS_DRODPOWN);
        Collections.sort(tagsList);
        String tags = StringUtils.join(tagsList, ",");
        logReport("Tags values " + tags);

        String sessionLevel = SESSION_LEVEL_VALUE.getText().trim();
        String points = POINTS_TEXTBOX.getAttribute("value").trim();
        String ceuCredit = CEUCREDITS_TEXTBOX.getAttribute("value").trim();
        String notes = SESSION_NOTES_TEXTAREA.getAttribute("value").trim();
        String abstractFile = null;
        if (verifyElementDisplayed(ABSTRACT_FILE_VALUE, 0)) {
            abstractFile = ABSTRACT_FILE_VALUE.getText().trim();
        }
        switchToIframe("Abstract Description");
        String abstractDesc = browser.findElement(By.xpath("//p")).getText().trim();
        browser.switchTo().defaultContent();
        String sessionFile = null;
        if (verifyElementDisplayed(SESSION_FILE_VALUE, 0)) {
            sessionFile = SESSION_FILE_VALUE.getText().trim();

        }
        switchToIframe("Session Description");
        String sessionDesc = browser.findElement(By.xpath("//p")).getText().trim();
        browser.switchTo().defaultContent();
        String sessionLabel = SESSION_LABEL_TEXTBOX.getAttribute("value").trim();
        List<String> jobFunctionList = getSelectedOptions(JOB_FUNCTIONS_DROPDOWN);
        Collections.sort(jobFunctionList);
        String jobFunction = StringUtils.join(jobFunctionList, ",");
        List<String> industryList = getSelectedOptions(INDUSTRIES_DROPDOWN);
        Collections.sort(industryList);
        String industries = StringUtils.join(industryList, ",");

        List<String> speakersData = new ArrayList<>();
        for (WebElement e : MASTER_SPEAKERS) {
            speakersData.add(e.getText().trim());

        }
        Collections.sort(speakersData);
        for (String s : speakersData) {
            instanceSpeakers.append(s);
            instanceSpeakers.append(",");
        }
        if (instanceSpeakers.length() > 1) {
            instanceSpeakers.setLength(instanceSpeakers.length() - 1);
        }
        String startDateTime = START_DATE_TIME.getText().trim();
        String endDateTime = END_DATE_TIME.getText().trim();

        String startDate = startDateTime.split(": ")[1].substring(0, 8);
        String startTime = startDateTime.split(": ")[1].split(" ")[1].trim();

        String endDate = endDateTime.split(": ")[1].substring(0, 8);
        String endTime = endDateTime.split(": ")[1].split(" ")[1].trim();

        sessionDetails.add(sessionName);
        sessionDetails.add(sessiontype);
        sessionDetails.add(sessionCode);
        sessionDetails.add(track);
        sessionDetails.add(tags);
        sessionDetails.add(sessionLevel);
        sessionDetails.add(instanceSpeakers.toString());
        sessionDetails.add(abstractFile);
        sessionDetails.add(points);
        sessionDetails.add(abstractDesc);
        sessionDetails.add(sessionFile);
        sessionDetails.add(sessionDesc);
        sessionDetails.add(notes);
        sessionDetails.add(ceuCredit);
        sessionDetails.add(sessionLabel);
        sessionDetails.add(jobFunction);
        sessionDetails.add(industries);
        sessionDetails.add(startDate);
        sessionDetails.add(convert24FormatTo12FormatTime(startTime));
        sessionDetails.add(endDate);
        sessionDetails.add(convert24FormatTo12FormatTime(endTime));

        logReport("------------------Values of speaker portal side list is " + sessionDetails);
        return sessionDetails;
    }

    public void clickSpeakerPortalSaveButton() throws Exception {
        click(SAVE_SPEAKER_PORTAL);
        logReport("Speaker portal button saved successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
    }

    public void deleteMasterSpeakers(String speakerName) {
        for (WebElement e : MASTER_SPEAKERS) {
            if (e.getText().trim().contains(speakerName)) {
                WebElement delete = e.findElement(By.xpath("../..//preceding-sibling::div//i[contains(@class,'fa fa-remove')]"));
                clickByJavaScript(delete);
                logReport("Element deleted successfully " + speakerName);
                return;
            }
        }
    }

    public boolean isInstanceDateFormatValid(String time) {
        pattern = Pattern.compile(TIME12HOURS_PATTERN);
        matcher = pattern.matcher(time);
        return matcher.matches();


    }

    public void selectAbstractFile(String fileName) throws Exception {
        Wait(ABSTRACT_UPLOAD_FILE, 20);
        clickByJavaScript(ABSTRACT_UPLOAD_FILE);
        logReport("Abstract upload file button clicked successfully");
        selectFile(fileName, FILE_CHOOSER_BUTTON_ABSTRACT);
        clickByJavaScript(ABSTRACT_UPLOAD_FILE);
        Thread.sleep(2000);

    }

    public void selectSessionFile(String fileName) throws Exception {
        Wait(SESSION_UPLOAD_FILE, 20);
        clickByJavaScript(SESSION_UPLOAD_FILE);
        logReport("Session upload file button clicked successfully");
        selectFile(fileName, FILE_CHOOSER_BUTTON_SESSION);
        clickByJavaScript(SESSION_UPLOAD_FILE);
        Thread.sleep(2000);
    }

    public void selectFile(String fileName, WebElement element) throws Exception {
        File file = new File("target/test-classes/files/" + fileName);
        String absolutePath = file.getAbsolutePath();
        logReport("file path " + absolutePath);
        //webDriver.type(FILE_CHOOSER_BUTTON,absolutePath);
        if (element.getAttribute("class").contains("hidden")) {
            setElementAttribute(element, "btn btn-info fileChooser");

        }
        Thread.sleep(2000);
        element.sendKeys(absolutePath);
        VerifyAjaxRequestsFinished(20);

    }
}


