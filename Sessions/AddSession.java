package pageObjects.Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.sqlite.util.StringUtils;
import pageObjects.CommonActionsPage;
import pageObjects.PageHelpPage;
import pojo.*;

import javax.naming.ConfigurationException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class AddSession extends CommonActionsPage {

    @FindBy(xpath = "//h3[text()='Edit Session']")

    public WebElement SESSION_HEADER;

    @FindBy(xpath = "//h4[contains(text(),'Session Instance 1')]")

    public WebElement DEFAULT_INSTANCE_NAME;

    @FindBy(xpath = "//input[@x-ng-model='session.name']")
    public WebElement SESSION_NAME_TEXTBOX;

    @FindBy(xpath = "//button[text()='Help']")

    public WebElement HELP_BUTTON;

    @FindBy(xpath = "//button[@id='publishAttendeeTypesBtn']")
    public WebElement PUBLISH_BUTTON;

    @FindBy(xpath = "//div[@class='speaker-upload-bgcolor']//div//label//strong")
    public List<WebElement> MASTER_SPEAKER_LIST;

    @FindBy(xpath = "//input[@x-ng-model='session.sessionCode']")

    public WebElement SESSION_CODE_TEXTBOX;

    @FindBy(xpath = "//label[text()='Points']/..//following-sibling::div//input[@x-ng-model='session[section.modelKey]']")
    public WebElement POINTS_TEXTBOX;

    @FindBy(xpath = "//label[text()='CEU Credits']/..//following-sibling::div//input[@x-ng-model='session[section.modelKey]']")

    public WebElement CEUCREDITS_TEXTBOX;
    @FindBy(xpath = "//label[text()='No of Instances']/..//following-sibling::div//input[@x-ng-model='session[section.modelKey]']")

    public WebElement INSTANCES_TEXTBOX;
    /* @FindBy(xpath = "//label[text()='No of Instances']")
     public WebElement NO_OF_INSTANCES_LABEL;*/
    public static final By NO_OF_INSTANCES_LABEL = By.xpath("//label[text()='No of Instances']");
    @FindBy(xpath = "//input[@x-ng-model='instance.capacity']")

    public WebElement INSTANCE_CAPACITY_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='instance.waitlistedLimit']")

    public WebElement INSTANCE_WAITLISTEDLIMIT_TEXTBOX;
    @FindBy(xpath = "//label[@title='Session Notes']/..//following-sibling::div//textarea")

    public WebElement SESSION_NOTES_TEXTAREA;
    @FindBy(xpath = "//label[text()='Session Label']/..//following-sibling::div//input[@x-ng-model='session[section.modelKey]']")

    public WebElement SESSION_LABEL_TEXTBOX;
    @FindBy(xpath = "//span[@class='ttu blue-font']")

    public WebElement INSTANCE_DETAILS_CLOSE_BUTTON;
    @FindBy(xpath = "//tbody[@ng-repeat='instance in session.confSessionInstance']")
    public List<WebElement> INSTANCE_CODE_LIST;

    @FindBy(xpath = "//label[text()='Session Type']/..//button[@id='dLabel']")
    public WebElement SESSION_TYPE_BUTTON;

    @FindBy(xpath = "//label[text()='Session Type']/..//following-sibling::div/ul/div[2]//div")
    public List<WebElement> SESSION_TYPE_DROPDOWN_LIST;

    @FindBy(xpath = "//label[text()='Session Type']/..//following-sibling::div//span[@class='track-color-text ng-binding']")

    public WebElement SESSION_TYPE_VALUE;

    @FindBy(xpath = "//label[text()='Track']/..//following-sibling::div//span[@class='track-color-text ng-binding']")

    public WebElement TRACK_VALUE;

    @FindBy(xpath = "//label[text()='Session Level']/..//following-sibling::div//span[@class='track-color-text ng-binding']")

    public WebElement SESSION_LEVEL_VALUE;

    @FindBy(xpath = "//label[text()='Session Type']/..//following-sibling::div/ul//input[@placeholder='Add New']")

    public WebElement SESSION_TYPE_TEXTBOX;
    @FindBy(xpath = "//label[text()='Session Type']/..//following-sibling::div/ul//span[text()='Add New']")

    public WebElement SESSION_TYPE_ADDNEW_BUTTON;

    @FindBy(xpath = "//label[@title='Track']/..//following-sibling::div//button[@id='dLabel']")
    public WebElement TRACK_BUTTON;

    @FindBy(xpath = "//label[@title='Sub-track']/..//following-sibling::div//button[@id='dLabel']")
    public WebElement SUB_TRACK_BUTTON;

    @FindBy(xpath = "//label[text()='Track']/..//following-sibling::div//ul//div[@class='track-color-box']/..//span")
    public List<WebElement> TRACK_DROPDOWN_LIST;

    @FindBy(xpath = "//label[text()='Track']/..//following-sibling::div//ul//input[@x-ng-model='newEntity[section.modelKey]']")
    public WebElement TRACK_TEXTBOX;

    @FindBy(xpath = "//label[text()='Track']/..//following-sibling::div//ul//span[text()='Add New']")
    public WebElement TRACK_ADDNEW_BUTTON;


    @FindBy(xpath = "//label[text()='Sub-track']/..//following-sibling::div//ul//input[@x-ng-model='newEntity[section.modelKey]']")
    public WebElement SUBTRACK_TEXTBOX;

    @FindBy(xpath = "//label[text()='Sub-track']/..//following-sibling::div//ul//span[text()='Add New']")
    public WebElement SUBTRACK_ADDNEW_BUTTON;

    @FindBy(xpath = "//label[@title='Tags']/..//following-sibling::div//select")

    public WebElement TAGS_DRODPOWN;

    @FindBy(xpath = "//label[@title='Session Level']/..//following-sibling::div//button[@id='dLabel']")

    public WebElement SESSION_LEVEL_BUTTON;

    @FindBy(xpath = "//label[@title='Session Level']/..//following-sibling::div//ul//div[@class='track-color-box']/..//span")
    public List<WebElement> SESSION_LEVEL_DROPDOWN_LIST;
    @FindBy(xpath = "//label[@title='Session Level']/..//following-sibling::div//ul//input[@x-ng-model='newEntity[section.modelKey]']")

    public WebElement SESSION_LEVEL_TEXTBOX;
    @FindBy(xpath = "//label[@title='Session Level']/..//following-sibling::div//ul//input[@ng-model='searchSectionDropDown[section.modelKey]']")
    public WebElement SESSION_LEVEL_SEARCH_TEXTBOX;
    @FindBy(xpath = "//label[@title='Session Level']/..//following-sibling::div//ul//span[text()='Add New']")

    public WebElement SESSION_LEVEL_ADDNEW_BUTTON;

    @FindBy(xpath = "//label[text()='Duration']/..//following-sibling::div//select[@x-ng-model='session.durationHours']")

    public WebElement DURATION_HRS_DRODPOWN;
    @FindBy(xpath = "//label[text()='Duration']/..//following-sibling::div//select[@x-ng-model='session.durationMins']")

    public WebElement DURATION_MINS_DRODPOWN;

    @FindBy(xpath = "//input[@x-ng-model='instance.overrideCapacity']")

    public WebElement OVERRIDE_CAPACITY_CHECKBOX;

    @FindBy(xpath = "//div[@class='speaker-upload-bgcolor']//div//label//strong")
    public WebElement INSTANCE_SPEAKER;

    @FindBy(xpath = "//div[@class='speaker-upload-bgcolor']//div//label//strong")
    public List<WebElement> LIST_INSTANCE_SPEAKER;

    @FindBy(xpath = "//div[contains(@ng-click,'removeAssignedSpeaker')]//i[contains(@class,'remove')]")
    public List<WebElement> LIST_INSTANCE_SPEAKER_DELETE;

    @FindBy(xpath = "//div[@class='speaker-upload-bgcolor']//div//label//strong")

    public WebElement SESSION_SPEAKER;

    @FindBy(xpath = "//span[@class='ttu certain-blue']")

    public WebElement CLOSE_INSTANCE;

    @FindBy(xpath = "//input[@name='startDate']")

    public WebElement SESSION_START_DATE;

    @FindBy(xpath = "//div[@class='instance-edit']//table[@role='grid']//button[@class='btn btn-default btn-sm pull-left']")

    public WebElement DATE_PICKER_PREVIOUS_LINK;

    @FindBy(xpath = "//div[@class='instance-edit']//table[@role='grid']//button[@class='btn btn-default btn-sm']")

    public WebElement DATE_PICKER_CENTER_LINK;

    @FindBy(xpath = "//div[@class='instance-edit']//table[@role='grid']//button[@class='btn btn-default btn-sm pull-right']")

    public WebElement DATE_PICKER_NEXT_LINK;

    @FindBy(xpath = "//table[@ng-model='instance.startTime']//input[@ng-model='hours']")
    public WebElement START_TIME_HOURS_TEXTBOX;

    @FindBy(xpath = "//table[@ng-model='instance.startTime']//input[@ng-model='minutes']")
    public WebElement START_TIME_MINUTES_TEXTBOX;

    @FindBy(xpath = "//label[text()='Start Time']/..//following-sibling::input[@ng-model='instance.startTime']")

    public WebElement SESSION_START_TIME;

    @FindBy(xpath = "//a[@id='startTimeLabel']")

    public WebElement START_TIME_CLOCK;

    @FindBy(xpath = "//label[text()='End Time']/..//following-sibling::input[@ng-model='instance.endTime']")

    public WebElement SESSION_END_TIME;

    @FindBy(xpath = "//label[text()='Location:']/..//following-sibling::div//select[@x-ng-model='instance.locationId']")
    public WebElement LOCATION_DROPDOWN;

    @FindBy(xpath = "//label[text()='Job Functions']/..//following-sibling::div//select[@x-ng-model='session[section.modelKey]']")

    public WebElement JOB_FUNCTIONS_DROPDOWN;

    @FindBy(xpath = "//label[text()='Industries']/..//following-sibling::div//select[@x-ng-model='session[section.modelKey]']")

    public WebElement INDUSTRIES_DROPDOWN;

    @FindBy(xpath = "//div[contains(@ng-repeat,'sessionSpeaker in sessionSpeakers')]//strong")
    public List<WebElement> MASTER_SPEAKERS;

    @FindBy(xpath = "//i[@tooltip='Delete']")
    public List<WebElement> DELETE_INSTANCE_ICON;

    @FindBy(xpath = "//tr[@class='sublist ng-scope']//p[@class='ng-binding']")
    public WebElement START_END_TIME;

    @FindBy(xpath = "//button[@x-ng-click='addSessionInstance()']")

    public WebElement ADD_INSTANCE_BUTTON;

    @FindBy(xpath = "//span[contains(@ng-if,'abstractSessionDoc')]/..//button")

    public WebElement ABSTRACT_UPLOAD_FILE;

    @FindBy(xpath = "//span[contains(@ng-if,'abstractSessionDoc')]/a")

    public WebElement ABSTRACT_FILE_VALUE;

    @FindBy(xpath = "//input[contains(@ng-if,'nonAbstractSessionDoc')]//following-sibling::span/button")

    public WebElement SESSION_UPLOAD_FILE;

    @FindBy(xpath = "//tr[@ng-repeat='document in nonAbstractSessionDocs']//a")

    public WebElement SESSION_FILE_VALUE;

    @FindBy(xpath = "//label[text()='Session Fee']/..//following-sibling::div//i[@class='glyphicon glyphicon-plus-sign']")

    public WebElement ADD_SESSION_FEES_BUTTON;

    @FindBy(xpath = "//input[@x-ng-model='session.isFeeDiscountable']")
    public WebElement APPLY_DISCOUNT_CHECKBOX;

    @FindBy(xpath = "//h5[text()='Session Fees']/..//following-sibling::table[@class='table']//tr[@ng-repeat='fee in feeList']//input[@ng-model='fee.datepicker']")

    public WebElement FEES_EXPIRATION_DATE;
    @FindBy(xpath = "//h5[text()='Session Fees']/..//following-sibling::table[@class='table']//tr[@ng-repeat='fee in feeList']//input[@ng-model='fee.hours']")

    public WebElement FEES_TIME_HRS;
    @FindBy(xpath = "//h5[text()='Session Fees']/..//following-sibling::table[@class='table']//tr[@ng-repeat='fee in feeList']//input[@ng-model='fee.minutes']")

    public WebElement FEES_TIME_MINS;
    @FindBy(xpath = "//h5[text()='Session Fees']/..//following-sibling::table[@class='table']//tr[@ng-repeat='fee in feeList']//input[@ng-model='fee.amount']")

    public WebElement FEES_AMOUNT;
    @FindBy(xpath = "//h5[text()='Session Fees']/..//following-sibling::table[@class='table']//tr[@ng-repeat='fee in feeList']//input[@ng-model='fee.code']")

    public WebElement FEES_CODE;
    @FindBy(xpath = "//h5[text()='Session Fees']/..//following-sibling::table[@class='table']//tr[@ng-repeat='fee in feeList']//input[@ng-model='fee.name']")

    public WebElement FEES_LABEL;
    @FindBy(xpath = "//h5[text()='Session Fees']/..//following-sibling::table[@class='table']//tr[@ng-repeat='fee in feeList']//input[@ng-model='fee.glNum']")

    public WebElement FEES_GL_ACCOUNT;
    @FindBy(xpath = "//h5[text()='Session Fees']/..//following-sibling::table[@class='table']//tr[@ng-repeat='fee in feeList']//img[@ng-click='addFee()']")

    public WebElement ADD_FEES_BUTTON;

    @FindBy(xpath = "//h5[text()='Cancellation Fees']//following-sibling::table[@class='table']//input[@ng-model='fee.datepicker']")

    public WebElement FEES_CANCELLATIONS_EXPIRATION_DATE;
    @FindBy(xpath = "//h5[text()='Cancellation Fees']//following-sibling::table[@class='table']//input[@ng-model='fee.hours']")

    public WebElement FEES_CANCELLATIONS_TIME_HRS;
    @FindBy(xpath = "//h5[text()='Cancellation Fees']//following-sibling::table[@class='table']//input[@ng-model='fee.minutes']")

    public WebElement FEES_CANCELLATIONS_TIME_MINS;
    @FindBy(xpath = "//h5[text()='Cancellation Fees']//following-sibling::table[@class='table']//input[@ng-model='fee.amount']")

    public WebElement FEES_CANCELLATIONS_AMOUNT;
    @FindBy(xpath = "//h5[text()='Cancellation Fees']//following-sibling::table[@class='table']//input[@ng-model='fee.code']")

    public WebElement FEES_CANCELLATIONS_CODE;
    @FindBy(xpath = "//h5[text()='Cancellation Fees']//following-sibling::table[@class='table']//input[@ng-model='fee.name']")

    public WebElement FEES_CANCELLATIONS_LABEL;
    @FindBy(xpath = "//h5[text()='Cancellation Fees']//following-sibling::table[@class='table']//input[@ng-model='fee.glNum']")

    public WebElement FEES_CANCELLATIONS_GL_ACCOUNT;
    @FindBy(xpath = "//h5[text()='Cancellation Fees']//following-sibling::table[@class='table']//img[@ng-click='addCancelFee()']")

    public WebElement ADD_CANCELLATIONS_FEES_BUTTON;

    //@FindBy(xpath = "//label[@title='Speakers']/..//following-sibling::div//div[contains(@class,'add-Speaker-button')]")
    @FindBy(xpath = "//label[@title='Speakers']/..//following-sibling::div//div[@class='col-sm-6']//a")
    public WebElement SPEAKERS_BUTTON;


    @FindBy(xpath = "//a[@ng-click='$event.stopPropagation();openSpeakerDrawer(false, session)']")
    public WebElement SPEAKERS_LINK;

    @FindBy(xpath = "//div[@class='instance-edit']//a[@ng-click='$event.stopPropagation();openSpeakerDrawer(true, instance)']")
    public WebElement INSTANCESPEAKERS_LINK;

    @FindBy(xpath = "//button[text()='Add Speaker']")
    public WebElement ADD_SPEAKER_BUTTON_DRAWER;

    @FindBy(xpath = "//button[@ng-click='toggleDrawer(false)']")
    public WebElement CLOSE_SPEAKER_DRAWER;

    @FindBy(xpath = "//input[@ng-model='addedSpeakerFilter']")
    public WebElement SEARCH_SPEAKER_TEXTBOX;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm pull-right ng-binding'][text()='Add Speaker']")
    public WebElement SPEAKERS_LABEL_BUTTON;

    @FindBy(xpath = "//input[@ng-model='addedSpeakerFilter'][@placeholder='Search']")
    public WebElement SPEAKERS_TEXTBOX;

    @FindBy(xpath = "//div[@class='add-speaker-select col-sm-12 pb10']//div[@id='speaker-select-results']//span//span")
    public List<WebElement> SPEAKERS_SELECT;

    @FindBy(xpath = "//a[@class='certain-blue speaker-ttl'][contains(text(),'speakers')]")
    public WebElement INSTANCE_SPEAKERS_BUTTON;

    @FindBy(xpath = "//h4[contains(text(),'Session Instance 2')]//a[@class='certain-blue speaker-ttl'][contains(text(),'speakers')]")
    public WebElement INSTANCE_SPEAKERS_BUTTON1;

    @FindBy(xpath = "//h4[contains(text(),'Session Instance 3')]//a[@class='certain-blue speaker-ttl'][contains(text(),'speakers')]")
    public WebElement INSTANCE_SPEAKERS_BUTTON2;

    @FindBy(xpath = "//h4[contains(text(),'Session Instance 1')]//a[@class='certain-blue speaker-ttl'][contains(text(),'speakers')]")
    public WebElement INSTANCE_SPEAKERS_BUTTON_DEFAULT;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm pull-right ng-binding'][contains(text(),'Add Speaker')]")
    public WebElement INSTANCE_SPEAKERS_LABEL_BUTTON;

    @FindBy(xpath = "//input[@ng-model='addedSpeakerFilter'][@placeholder='Search']")
    public WebElement INSTANCE_SPEAKERS_TEXTBOX;
    //div[@ng-show='!addSpeakerActive[instance.id]']//following-sibling::div[@class='add-speaker-select']//input[@ng-model='addedSpeakerFilter']
    @FindBy(xpath = "//div[@class='add-speaker-select col-sm-12 pb10']//div[@id='speaker-select-results']//span//span")
    public List<WebElement> INSTANCE_SPEAKERS_SELECT;

    @FindBy(xpath = "//select[@ng-change='addSpeakers(instance)']")

    public WebElement INSTANCE_SPEAKERS_DROPDOWN;

    public static final By START_TIME_MERIDIAN_BUTTON = By.xpath("//table[@ng-model='instance.startTime']//button[@ng-click='toggleMeridian()']");
    public static final By END_TIME_MERIDIAN_BUTTON = By.xpath("//table[@ng-model='instance.endTime']//button[@ng-click='toggleMeridian()']");
    @FindBy(xpath = "//a[@id='endTimeLabel']")

    public WebElement END_TIME_CLOCK;
    @FindBy(xpath = "//table[@ng-model='instance.endTime']//input[@ng-model='hours']")
    public WebElement END_TIME_HOURS_TEXTBOX;
    @FindBy(xpath = "//table[@ng-model='instance.endTime']//input[@ng-model='minutes']")
    public WebElement END_TIME_MINUTES_TEXTBOX;

    @FindBy(xpath = "//button[@x-ng-click='saveSession(session)']")
    public WebElement SESSION_SAVE_BUTTON;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement CANCEL_POPUP;

    @FindBy(xpath = "//button[@x-ng-click='cancelEdit()']")

    public WebElement SESSION_CANCEL_BUTTON;

    @FindBy(xpath = "//input[@x-ng-model='searchOn.searchSessionName']")

    public WebElement SESSION_SEARCH_BOX;

    @FindBy(xpath = "//button[@ng-click='filterSearchSession()']")

    public WebElement SESSION_SEARCH_BUTTON;

    @FindBy(xpath = "//input[@type='file'][@class='btn btn-info hidden fileChooser']")
    public WebElement FILE_CHOOSER_BUTTON;

    @FindBy(xpath = "//span[contains(@ng-if,'abstractSessionDoc')]/..//following-sibling::div//input[@type='file']")

    public WebElement FILE_CHOOSER_BUTTON_ABSTRACT;

    @FindBy(xpath = "//input[contains(@ng-if,'nonAbstractSessionDoc')]/..//following-sibling::div//input[@type='file']")

    public WebElement FILE_CHOOSER_BUTTON_SESSION;

    @FindBy(xpath = "//tr[@ng-repeat='document in nonAbstractSessionDocs']/td[1]/a")
    public List<WebElement> SESSION_DOC_NAMES;

    @FindBy(xpath = "//table[@ng-model='instance.startTime']//td//a[@ng-click='incrementHours()']/span")
    public WebElement STARTTIME_HOURS_UP_BUTTON;

    @FindBy(xpath = "//table[@ng-model='instance.startTime']//td//a[@ng-click='decrementHours()']/span")

    public WebElement STARTTIME_HOURS_DOWN_BUTTON;

    @FindBy(xpath = "//table[@ng-model='instance.startTime']//td//a[@ng-click='incrementMinutes()']/span")

    public WebElement STARTTIME_MIN_UP_BUTTON;

    @FindBy(xpath = "//table[@ng-model='instance.startTime']//td//a[@ng-click='decrementMinutes()']/span")

    public WebElement STARTTIME_MIN_DOWN_BUTTON;

    @FindBy(xpath = "//table[@ng-model='instance.endTime']//td//a[@ng-click='incrementHours()']/span")

    public WebElement ENDTIME_HOURS_UP_BUTTON;

    @FindBy(xpath = "//table[@ng-model='instance.endTime']//td//a[@ng-click='decrementHours()']/span")

    public WebElement ENDTIME_HOURS_DOWN_BUTTON;

    @FindBy(xpath = "//table[@ng-model='instance.endTime']//td//a[@ng-click='incrementMinutes()']/span")

    public WebElement ENDTIME_MIN_UP_BUTTON;

    @FindBy(xpath = "//table[@ng-model='instance.endTime']//td//a[@ng-click='decrementMinutes()']/span")

    public WebElement ENDTIME_MIN_DOWN_BUTTON;

    @FindBy(xpath = "//tbody[contains(@ng-repeat,'instance in session.confSessionInstance')]")
    public List<WebElement> INSTANCES_LIST;

    @FindBy(xpath = "//tr[@ng-repeat='fee in feeList']")
    public List<WebElement> SESSION_FEE_LIST;

    @FindBy(xpath = "//tr[@ng-repeat='fee in cancellationFeeList']")
    public List<WebElement> CANCELLATION_FEE_LIST;

    @FindBy(xpath = "//button[contains(@ng-class,'preview')]")

    public WebElement READ_BUTTON;

    @FindBy(xpath = "//button[contains(@ng-class,'edit')]")

    public WebElement EDIT_BUTTON;

    @FindBy(xpath = "//div[@class='col-sm-1 col-md-1 certain-blue sublist-index text-center no-padding']")

    public WebElement EXPANDED_INSTANCE_ARROW;

    @FindBy(xpath = "//div[@class='col-sm-1 col-md-1 certain-blue sublist-index text-center no-padding']")
    public List<WebElement> EXPANDED_INSTANCE_LIST;

    @FindBy(xpath = "//label[text()='Location:']/..//following-sibling::div//a//abbr")

    public WebElement LOCATION_CLOSE_ICON;

    @FindBy(xpath = "//tbody[@ng-repeat='instance in session.confSessionInstance']//div[1]/div[2][contains(@class,'blue')]")

    public WebElement INSTANCE_CODE_LABEL;

    @FindBy(xpath = "//tbody[@ng-repeat='instance in session.confSessionInstance']//div[1]/div[2][contains(@class,'blue')]")

    public List<WebElement> INSTANCE_CODE_LABEL_LIST;

    @FindBy(xpath = "//strong[text()='Date & Time:']")

    public WebElement INSTANCE_DATETIME;

    @FindBy(xpath = "//strong[text()='Location:']")

    public WebElement INSTANCE_LOCATION;

    @FindBy(xpath = "//p[text()='Capacity']/following-sibling::p[text()='Unlimited']")

    public WebElement INSTANCE_CAPACITY;

    @FindBy(xpath = "//p[text()='Registered']")

    public WebElement INSTANCE_REGISTERED;

    @FindBy(xpath = "//p[text()='Waitlisted']")

    public WebElement INSTANCE_WAITLISTED;

    @FindBy(xpath = "//strong[text()='Add Speaker']")

    public WebElement HEADER_ADD_SPEAKER;
    @FindBy(xpath = "//strong[text()='Add Speaker']/..//i")

    public WebElement ADD_SPEAKER_BUTTON;

    @FindBy(xpath = "//label[text()='Speakers']")

    public WebElement HEADER_MASTER_SPEAKER;

    @FindBy(xpath = "//button[contains(text(),'Reviewer Stats')]")

    public WebElement REVIEWER_STATS_BUTTON;

    @FindBy(xpath = "//button[contains(text(),'Session Tasks')]")

    public WebElement SESSION_TASKS_BUTTON;

    @FindBy(xpath = "//button[@id='statusSelectBox']/strong")

    public WebElement SESSION_STATUS_BUTTON;

    @FindBy(xpath = "//li[@ng-repeat='sessionStatus in sessionSpecificStatusList']/a")
    public List<WebElement> SESSION_STATUS_LIST;

    @FindBy(xpath = "//input[@ng-checked='checkSelectAll()']")

    public WebElement SELECTALL_CHK_PUBLISH;

    @FindBy(xpath = "//input[@ng-model='attendeeTypesModel']")
    public List<WebElement> LISTOF_ATTENDEETYPES;

    @FindBy(xpath = "//button[@x-ng-click='publishAttendeeType(session)']")

    public WebElement PUBLISH_ATTENDEETYPES_BTN;

    @FindBy(xpath = "//input[@ng-model='addedConfSessionTask.taskNotes']")
    public WebElement SESSION_TASK_TEXTBOX;

    @FindBy(xpath = "//button[contains(text(),'Add New Task')]")
    public WebElement ADD_NEW_TASK_BUTTON;

    @FindBy(xpath = "//span[@title='Publish to Attendee Type(s)'][@ng-click='changePanelView()']//i[2]")
    public WebElement PUBLISH_ATTENDEETYPE_ICON;

    @FindBy(xpath = "//label[@title='Instances'][contains(text(),'Instances')]")
    public WebElement INSTANCES_LABEL;

    @FindBy(xpath = "//button[@ng-click='closeAddNewSpeakerPopup()']")
    public WebElement CANCEL_SPEAKER;

    public AddSession(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void enterSessionName(String name) throws Exception {
        //String nameWithRandonNo = name + generateRandomNumber(3);
        type(SESSION_NAME_TEXTBOX, name, true);
        logReport("Entered Session Name value " + name);
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
        type(SESSION_TYPE_TEXTBOX, sessionType);
        logReport("Entered session type text value " + sessionType);
        click(SESSION_TYPE_ADDNEW_BUTTON);
        logReport("Session Type add new button clicked successfully");
        click(SESSION_TYPE_BUTTON);
        logReport("Session Type button clicked");


    }

    public void enterSessionCode(String sessionCode) throws Exception {
        //String sessionCodeWithRandomNo = sessionCode + generateRandomNumber(3);
        type(SESSION_CODE_TEXTBOX, sessionCode, true);
        logReport("Entered Session Code value " + sessionCode);
    }

    public boolean isSessionTrackValueFound(String sessionTrack) {
        boolean found = false;
        if (TRACK_DROPDOWN_LIST.size() > 0) {
            for (WebElement e : TRACK_DROPDOWN_LIST) {
                logReport("Get value of dropdown " + e.getText().trim());
                if (e.getText().trim().equalsIgnoreCase(sessionTrack)) {
                    logReport("Session track found and clicked successfully");
                    found = true;
                    break;
                }

            }
        }
        return found;
    }

    public void selectSessionTrack(String track) throws Exception {
        //Wait(TRACK_BUTTON, 10);
        clickByJavaScript(TRACK_BUTTON);
        logReport("click on track dropdown button.");
        for (WebElement e : TRACK_DROPDOWN_LIST) {
            if (e.getText().trim().equalsIgnoreCase(track)) {
                e.click();
                logReport("Session track exist and clicked successfully");
                return;
            }
        }
        type(TRACK_TEXTBOX, track);
        logReport("Entered session track text value " + track);
        click(TRACK_ADDNEW_BUTTON);
        logReport("Session Track add new button clicked successfully");
        click(TRACK_BUTTON);
        logReport("Session Track button clicked");
    }

    public void selectTagsDropdown(String tags) {
        //TAGS_DRODPOWN.clear();
        String a[] = tags.split(",");
        for (int i = 0; i < a.length; i++) {
            select(TAGS_DRODPOWN, a[i]);
            logReport("Selected tags values " + a[i]);
        }
    }

    public boolean isSessionLevelValueFound(String sessionLevel) {
        boolean found = false;
        if (SESSION_LEVEL_DROPDOWN_LIST.size() > 0) {
            for (WebElement e : SESSION_LEVEL_DROPDOWN_LIST) {
                logReport("Get value of dropdown " + e.getText().trim());
                if (e.getText().trim().equalsIgnoreCase(sessionLevel)) {
                    logReport("Session level found and clicked successfully");
                    found = true;
                    break;
                }

            }
        }
        return found;
    }

    public void selectSessionLevel(String sessionLevel) throws Exception {
        // Wait(SESSION_LEVEL_BUTTON, 10);
        click(SESSION_LEVEL_BUTTON);
        logReport("click on Session level dropdown button.");
        for (WebElement e : SESSION_LEVEL_DROPDOWN_LIST) {
            if (e.getText().trim().equalsIgnoreCase(sessionLevel)) {
                e.click();
                logReport("Session level exist and clicked successfully");
                return;
            }

        }
        type(SESSION_LEVEL_TEXTBOX, sessionLevel);
        logReport("Entered session level text value " + sessionLevel);
        click(SESSION_LEVEL_ADDNEW_BUTTON);
        logReport("Session Level add new button clicked successfully");
        click(SESSION_LEVEL_BUTTON);
        logReport("Session Level button clicked");

    }

    public void enterSessionLevel(String sessionLevel) throws Exception {
        clickByJavaScript(SESSION_LEVEL_BUTTON);
        type(SESSION_LEVEL_TEXTBOX, sessionLevel, true);
        logReport("Entered session level text value " + sessionLevel);
        click(SESSION_LEVEL_ADDNEW_BUTTON);
        logReport("Session Level add new button clicked successfully");
        VerifyAngularHasFinishedProcessing(20);
        click(SESSION_LEVEL_BUTTON);

    }

    public void enterTrack(String track) {
        clickByJavaScript(TRACK_BUTTON);
        type(TRACK_TEXTBOX, track, true);
        logReport("Entered session track text value " + track);
        click(TRACK_ADDNEW_BUTTON);
        logReport("Session Track add new button clicked successfully");
        VerifyAngularHasFinishedProcessing(20);
        click(TRACK_BUTTON);
    }

    public void enterSessionType(String sessionType) {
        clickByJavaScript(SESSION_TYPE_BUTTON);
        type(SESSION_TYPE_TEXTBOX, sessionType, true);
        logReport("Entered session type text value " + sessionType);
        click(SESSION_TYPE_ADDNEW_BUTTON);
        logReport("Session Type add new button clicked successfully");
        VerifyAngularHasFinishedProcessing(20);
        click(SESSION_TYPE_BUTTON);
    }

    public void enterPointsValue(String points) throws Exception {
        // Wait(POINTS_TEXTBOX, 10);
        type(POINTS_TEXTBOX, points, true);
        logReport("Entered Points value " + points);
    }

    public void selectDurationHrs(String hrs) throws Exception {
        clickByJavaScript(DURATION_HRS_DRODPOWN);
        //Wait(DURATION_HRS_DRODPOWN, 10);
        select(DURATION_HRS_DRODPOWN, hrs);
        logReport("Selected duration Hrs value " + hrs);
    }

    public void selectDurationMins(String mins) throws Exception {
        //Wait(DURATION_MINS_DRODPOWN, 10);
        select(DURATION_MINS_DRODPOWN, mins);
        logReport("Selected duration Minutes value " + mins);
    }

    public void enterCEUCreditsValue(String ceuCredits) throws Exception {
        // Wait(CEUCREDITS_TEXTBOX, 10);
        type(CEUCREDITS_TEXTBOX, ceuCredits, true);
        logReport("Entered CEU Credits value " + ceuCredits);
    }

    public void enterInstancesValue(String instance) throws Exception {
        //Wait(INSTANCES_TEXTBOX, 10);
        type(INSTANCES_TEXTBOX, instance, true);
        logReport("Entered No of Instances value " + instance);
    }

    public Integer getNoOfInstancesValue() throws Exception {
        //Wait(INSTANCES_TEXTBOX, 10);
        return Integer.parseInt(INSTANCES_TEXTBOX.getAttribute("value").trim());

    }

    public void selectSpeakersDrawer(String speakers) throws Exception {
        Wait(SPEAKERS_LINK, 30);
        String a[] = speakers.split(",");
        click(SPEAKERS_LINK);
        logReport("Speakers link clicked successfully");
        switchToLatestTabOrWindow();
        for (int i = 0; i < a.length; i++) {
            click(ADD_SPEAKER_BUTTON_DRAWER);
            logReport("Add speaker button drawer clicked");
            VerifyPageReady(30);
            type(SEARCH_SPEAKER_TEXTBOX, a[i], true);
            String xpath = "//div[@id='speaker-select-results']//span[text()='" + a[i] + "']";
            click(browser.findElement(By.xpath(xpath)));
            logReport("Selected speakers " + a[i]);

        }
        clickByJavaScript(CLOSE_SPEAKER_DRAWER);
        logReport("Speaker drawer closed successfully");
    }

    public void selectInstanceSpeakersDrawer(String speakers) throws Exception {
        Wait(INSTANCESPEAKERS_LINK, 30);
        String a[] = speakers.split(",");
        click(INSTANCESPEAKERS_LINK);
        switchToLatestTabOrWindow();
        logReport("Instance Speakers link clicked successfully");
        for (int i = 0; i < a.length; i++) {
            click(ADD_SPEAKER_BUTTON_DRAWER);
            logReport("Add speaker button drawer clicked");
            VerifyPageReady(30);
            type(SEARCH_SPEAKER_TEXTBOX, a[i], true);
            String xpath = "//div[@id='speaker-select-results']//span[text()='" + a[i] + "']";
            click(browser.findElement(By.xpath(xpath)));
            logReport("Selected speakers " + a[i]);
            VerifyPageReady(30);
            Thread.sleep(2000);

        }
        Thread.sleep(2000);
        clickByJavaScript(CLOSE_SPEAKER_DRAWER);
        logReport("Speaker drawer closed successfully");
    }

    public void selectSpeakers(String speakers) throws Exception {
        //Wait(SPEAKERS_BUTTON, 10);
       /* String a[] = speakers.split(",");
        for (int i = 0; i < a.length; i++) {
            clickByJavaScript(SPEAKERS_BUTTON);
            logReport("Speaker button clicked successfully");
            VerifyPageReady(20);
            click(SPEAKERS_LABEL_BUTTON);
            type(SPEAKERS_TEXTBOX, a[i], true);
            for (WebElement e : SPEAKERS_SELECT) {
                if (e.getText().equalsIgnoreCase(a[i])) {
                    e.click();
                    browser.findElement(By.xpath("//i[@ng-click='toggleDrawer(false)']")).isDisplayed();
                    Thread.sleep(2000);
                    browser.findElement(By.xpath("//i[@ng-click='toggleDrawer(false)']")).click();
                    VerifyPageReady(20);
                    return;
                }
            }
            logReport("Selected Speakers values " + a[i]);
            // VerifyPageReady(20);
        }*/


        Wait(SPEAKERS_BUTTON, 3);
        clickByJavaScript(SPEAKERS_BUTTON);
        logReport(" Speaker button clicked successfully");
        VerifyPageReady(20);

        clickByJavaScript(INSTANCE_SPEAKERS_LABEL_BUTTON);
        Wait(INSTANCE_SPEAKERS_TEXTBOX, 5);
        type(INSTANCE_SPEAKERS_TEXTBOX, speakers);

        for (WebElement e : INSTANCE_SPEAKERS_SELECT) {
            if (e.getText().equalsIgnoreCase(speakers)) {
                e.click();
                browser.findElement(By.xpath("//i[@ng-click='toggleDrawer(false)']")).isDisplayed();
                Thread.sleep(2000);
                String xpath = "//div[@class='modal-body']//button[text()='CANCEL']";
                if (verifyElementDisplayed(By.xpath(xpath), 5)) {
                    click(browser.findElement(By.xpath(xpath)));
                }
                browser.findElement(By.xpath("//i[@ng-click='toggleDrawer(false)']")).click();
                VerifyPageReady(20);
                return;
            }
        }
        // logReport("Selected Speakers values " + a[i]);
    }

    public void enterStartTime(String startTime) throws Exception {
        SESSION_START_TIME.sendKeys(startTime);
        reporter.info("Entered Value: " + startTime + " in 'Start Time' TextBox");
    }

    public void enterEndTime(String endTime) throws Exception {
        //  Wait(SESSION_END_TIME, 10);
        SESSION_END_TIME.clear();
        SESSION_END_TIME.sendKeys(endTime);
        reporter.info("Entered Value: " + endTime + " in 'End Time' TextBox");
    }

    public void selectLocation(String location) throws Exception {
        // Wait(LOCATION_DROPDOWN, 10);
        select(LOCATION_DROPDOWN, location);
        logReport("Selected Location value " + location);
    }

    public void enterCapacityValue(String capacity) throws Exception {
        // Wait(INSTANCE_CAPACITY_TEXTBOX, 10);
        type(INSTANCE_CAPACITY_TEXTBOX, capacity, true);
        logReport("Entered Instance capacity value " + capacity);
    }

    public void enterWaitListLimitValue(String waitListLimit) throws Exception {
        // Wait(INSTANCE_WAITLISTEDLIMIT_TEXTBOX, 10);
        type(INSTANCE_WAITLISTEDLIMIT_TEXTBOX, waitListLimit, true);
        logReport("Entered Instance WaitList Limit value " + waitListLimit);
    }

    public void selectOverrideCapacity(boolean val) throws Exception {
        if (val) {
            check(OVERRIDE_CAPACITY_CHECKBOX);
            logReport("Checked override capacity checkbox");
        } else {
            unCheck(OVERRIDE_CAPACITY_CHECKBOX);
            logReport("Unchecked override capacity checkbox");
        }
    }

    public void selectInstanceSpeakers(String speakers) throws Exception {
        Wait(INSTANCE_SPEAKERS_BUTTON, 3);
        clickByJavaScript(INSTANCE_SPEAKERS_BUTTON);
        logReport("Instance Speaker button clicked successfully");
        VerifyPageReady(20);

        clickByJavaScript(INSTANCE_SPEAKERS_LABEL_BUTTON);
        Wait(INSTANCE_SPEAKERS_TEXTBOX, 5);
        type(INSTANCE_SPEAKERS_TEXTBOX, speakers);

        for (WebElement e : INSTANCE_SPEAKERS_SELECT) {
            if (e.getText().equalsIgnoreCase(speakers)) {
                e.click();
                browser.findElement(By.xpath("//i[@ng-click='toggleDrawer(false)']")).isDisplayed();
                Thread.sleep(2000);
                clickByJavaScript(browser.findElement(By.xpath("//button[text()='Cancel'][@ng-click='toggleDrawer(false)']")));
                //   browser.findElement(By.xpath("//i[@ng-click='toggleDrawer(false)']")).click();
                VerifyPageReady(20);
                return;
            }
        }


       /* String a[] = speakers.split(",");
        for (int i = 0; i < a.length; i++) {
            logReport("Speaker button clicked successfully");
            VerifyPageReady(20);
            click(INSTANCE_SPEAKERS_LABEL_BUTTON);
            type(INSTANCE_SPEAKERS_TEXTBOX, a[i], true);
            for (WebElement e : INSTANCE_SPEAKERS_SELECT) {
                if (e.getText().equalsIgnoreCase(a[i])) {
                    e.click();
                    return;
                }
            }
        }*/

    }

    public void enterNotesValue(String notes) throws Exception {
        //Wait(SESSION_NOTES_TEXTAREA, 10);
        type(SESSION_NOTES_TEXTAREA, notes, true);
        logReport("Entered Notes value " + notes);
    }

    public void enterAbstractDescription(String abstractDescription) throws Exception {
        enterIFrameText("Abstract Description", abstractDescription);
        logReport("Entered abstract description value " + abstractDescription);
    }

    public void enterSessionDescription(String sessionDescription) throws Exception {

        enterIFrameText("Session Description", sessionDescription);
        logReport("Entered session description value " + sessionDescription);
    }


    public void enterSessionFeeExpirationDate(String expirationDate) throws Exception {
        // Wait(FEES_EXPIRATION_DATE, 10);
        FEES_EXPIRATION_DATE.clear();
        FEES_EXPIRATION_DATE.sendKeys(expirationDate);
        reporter.info("Entered Value: " + expirationDate + " in 'Session fee expiration Date' TextBox");
    }

    public void enterSessionFeeTimeHrs(String expirationTimeHrs) throws Exception {
        //Wait(FEES_TIME_HRS, 10);
        FEES_TIME_HRS.clear();
        FEES_TIME_HRS.sendKeys(expirationTimeHrs);
        reporter.info("Entered Value: " + expirationTimeHrs + " in 'Session fee Time hrs' TextBox");
    }

    public void enterSessionFeeTimeMins(String expirationTimeMins) throws Exception {
        // Wait(FEES_TIME_MINS, 10);
        FEES_TIME_MINS.clear();
        FEES_TIME_MINS.sendKeys(expirationTimeMins);
        reporter.info("Entered Value: " + expirationTimeMins + " in 'Session fee Time mins' TextBox");
    }

    public void enterSessionFeeAmount(String amount) throws Exception {
        // Wait(FEES_AMOUNT, 10);
        type(FEES_AMOUNT, amount, true);
        logReport("Entered Amount value " + amount);
    }

    public void enterSessionFeeCode(String code) throws Exception {
        //  Wait(FEES_CODE, 10);
        type(FEES_CODE, code, true);
        logReport("Entered Fee Code value " + code);
    }

    public void enterSessionFeeLabel(String label) throws Exception {
        //Wait(FEES_LABEL, 10);
        type(FEES_LABEL, label, true);
        logReport("Entered Fee label value " + label);
    }

    public void enterSessionFeeGLAccount(String glAmount) throws Exception {
        // Wait(FEES_GL_ACCOUNT, 10);
        type(FEES_GL_ACCOUNT, glAmount, true);
        logReport("Entered G/L Amount value " + glAmount);
    }

    public void enterCancellationFeeExpirationDate(String expirationDate) throws Exception {
        //Wait(FEES_CANCELLATIONS_EXPIRATION_DATE, 10);
        FEES_CANCELLATIONS_EXPIRATION_DATE.clear();
        FEES_CANCELLATIONS_EXPIRATION_DATE.sendKeys(expirationDate);
        reporter.info("Entered Value: " + expirationDate + " in 'Session Fee Cancellation expiration Date' TextBox");
    }

    public void enterCancellationFeeTimeHrs(String expirationTimeHrs) throws Exception {
        // Wait(FEES_CANCELLATIONS_TIME_HRS, 10);
        FEES_CANCELLATIONS_TIME_HRS.clear();
        FEES_CANCELLATIONS_TIME_HRS.sendKeys(expirationTimeHrs);
        reporter.info("Entered Value: " + expirationTimeHrs + " in 'Session Fee Cancellation Time hrs' TextBox");
    }

    public void enterCancellationFeeTimeMins(String expirationTimeMins) throws Exception {
        // Wait(FEES_CANCELLATIONS_TIME_MINS, 10);
        FEES_CANCELLATIONS_TIME_MINS.clear();
        FEES_CANCELLATIONS_TIME_MINS.sendKeys(expirationTimeMins);
        reporter.info("Entered Value: " + expirationTimeMins + " in 'Session Fee Cancellation Time mins' TextBox");
    }

    public void enterCancellationFeeAmount(String amount) throws Exception {
        //Wait(FEES_CANCELLATIONS_AMOUNT, 10);
        type(FEES_CANCELLATIONS_AMOUNT, amount, true);
        logReport("Entered Fee Cancellation Amount value " + amount);
    }

    public void enterCancellationFeeCode(String code) throws Exception {
        //Wait(FEES_CANCELLATIONS_CODE, 10);
        type(FEES_CANCELLATIONS_CODE, code, true);
        logReport("Entered Fee Cancellation Code value " + code);
    }

    public void enterCancellationFeeLabel(String label) throws Exception {
        //Wait(FEES_CANCELLATIONS_LABEL, 10);
        type(FEES_CANCELLATIONS_LABEL, label, true);
        logReport("Entered Fee Cancellation label value " + label);
    }

    public void enterCancellationFeeGLAccount(String glAmount) throws Exception {
        //Wait(FEES_CANCELLATIONS_GL_ACCOUNT, 10);
        type(FEES_CANCELLATIONS_GL_ACCOUNT, glAmount, true);
        logReport("Entered Fee Cancellation G/L Amount value " + glAmount);
    }

    public void enterSessionLabelValue(String sessionLabel) throws Exception {
        // Wait(SESSION_LABEL_TEXTBOX, 10);
        if (sessionLabel != null) {
            clickByJavaScript(SESSION_LEVEL_TEXTBOX);
            type(SESSION_LABEL_TEXTBOX, sessionLabel, true);
            logReport("Entered Session label value " + sessionLabel);
        }
    }

    public void selectJobFunctionsDropdown(String jobFunction) {
        //JOB_FUNCTIONS_DROPDOWN.clear();
        if (jobFunction != null) {
            String a[] = jobFunction.split(",");
            for (int i = 0; i < a.length; i++) {
                clickByJavaScript(JOB_FUNCTIONS_DROPDOWN);
                select(JOB_FUNCTIONS_DROPDOWN, a[i]);
                logReport("Selected Job Function values " + a[i]);
            }
        }
    }

    public void selectIndustriesDropdown(String industry) {
        // INDUSTRIES_DROPDOWN.clear();
        if (industry != null) {
            String a[] = industry.split(",");
            for (int i = 0; i < a.length; i++) {
                select(INDUSTRIES_DROPDOWN, a[i]);
                logReport("Selected Industry values " + a[i]);
            }
        }
    }

    public void selectAbstractFile(String fileName) throws Exception {
        Wait(ABSTRACT_UPLOAD_FILE, 20);
        clickByJavaScript(ABSTRACT_UPLOAD_FILE);
        logReport("Abstract upload file button clicked successfully");
        selectFile(fileName, FILE_CHOOSER_BUTTON_ABSTRACT);
        click(ABSTRACT_UPLOAD_FILE);
        Thread.sleep(2000);

    }

    public void selectSessionFile(String fileName) throws Exception {
        Wait(SESSION_UPLOAD_FILE, 20);
        clickByJavaScript(SESSION_UPLOAD_FILE);
        logReport("Session upload file button clicked successfully");
        selectFile(fileName, FILE_CHOOSER_BUTTON_SESSION);
        click(SESSION_UPLOAD_FILE);
        Thread.sleep(15000);
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

    public void fillAddNewSessionDetails(AddSessionData addSessionData) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(30);
        enterSessionName(addSessionData.getSessionName());
        selectSessionType(addSessionData.getSessionType());
        enterSessionCode(addSessionData.getSessionCode());
        selectSessionTrack(addSessionData.getSessionTrack());
        selectTagsDropdown(addSessionData.getTags());
        selectSessionLevel(addSessionData.getSessionLevel());
        enterPointsValue(addSessionData.getPoints());
        selectDurationHrs(addSessionData.getDurationHrs());
        selectDurationMins(addSessionData.getDurationMins());
        enterCEUCreditsValue(addSessionData.getCeuCredits());
        enterInstancesValue(addSessionData.getInstances());
        selectSpeakersDrawer(addSessionData.getSpeakers());
        selectAbstractFile(addSessionData.getAbstractFile());
        enterAbstractDescription(addSessionData.getAbstractDescription());
        selectSessionFile(addSessionData.getSessionFile());
        enterSessionDescription(addSessionData.getSessionDescription());
        enterNotesValue(addSessionData.getNotes());
        enterSessionLabelValue(addSessionData.getSessionLabel());
        selectIndustriesDropdown(addSessionData.getIndustry());
        selectJobFunctionsDropdown(addSessionData.getJobFunction());
    }
    public void fillSessionDetailsForUat(AddSessionData addSessionData) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(30);
        enterSessionName(addSessionData.getSessionName());
        selectSessionType(addSessionData.getSessionType());
        enterSessionCode(addSessionData.getSessionCode());
        selectSessionTrack(addSessionData.getSessionTrack());
        selectTagsDropdown(addSessionData.getTags());
        selectSessionLevel(addSessionData.getSessionLevel());
        enterPointsValue(addSessionData.getPoints());
        selectDurationHrs(addSessionData.getDurationHrs());
        selectDurationMins(addSessionData.getDurationMins());
        enterCEUCreditsValue(addSessionData.getCeuCredits());
        enterInstancesValue(addSessionData.getInstances());
       // selectSpeakers(addSessionData.getSpeakers());
        selectAbstractFile(addSessionData.getAbstractFile());
        enterAbstractDescription(addSessionData.getAbstractDescription());
        selectSessionFile(addSessionData.getSessionFile());
        enterSessionDescription(addSessionData.getSessionDescription());
        enterNotesValue(addSessionData.getNotes());
        enterSessionLabelValue(addSessionData.getSessionLabel());
      //  selectJobFunctionsDropdown(addSessionData.getJobFunction());
      //  selectIndustriesDropdown(addSessionData.getIndustry());
    }

    public void selectSubTracksValue(String subtracks) {
        clickByJavaScript(SUB_TRACK_BUTTON);
        logReport("click on sub track dropdown button.");
        String a[] = subtracks.split(",");
        String xpath = "//label[text()='Sub-track']/..//following-sibling::div//ul//input[@name='" + subtracks + "']";
        if (verifyElementDisplayed(By.xpath(xpath), 2)) {
                WebElement element = browser.findElement(By.xpath(xpath));
                checkByJavascript(element);
        } else {
                type(SUBTRACK_TEXTBOX, subtracks);
                logReport("Entered session sub track text value " + subtracks);
                click(SUBTRACK_ADDNEW_BUTTON);
                logReport("Session sub Track add new button clicked successfully");

            }
        click(SUB_TRACK_BUTTON);
        logReport("Session sub Track button clicked");
    }

    public void fillSessionWithDefaultFields(AddSessionData addSessionData) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(30);
        enterSessionName(addSessionData.getSessionName());
        selectSessionType(addSessionData.getSessionType());
        enterSessionCode(addSessionData.getSessionCode());
        selectSessionTrack(addSessionData.getSessionTrack());
        selectTagsDropdown(addSessionData.getTags());
        selectSessionLevel(addSessionData.getSessionLevel());
        enterPointsValue(addSessionData.getPoints());
        selectDurationHrs(addSessionData.getDurationHrs());
        selectDurationMins(addSessionData.getDurationMins());
        enterCEUCreditsValue(addSessionData.getCeuCredits());
        enterInstancesValue(addSessionData.getInstances());
        selectSpeakers(addSessionData.getSpeakers());
        selectAbstractFile(addSessionData.getAbstractFile());
        enterAbstractDescription(addSessionData.getAbstractDescription());
        selectSessionFile(addSessionData.getSessionFile());
        enterSessionDescription(addSessionData.getSessionDescription());
        enterNotesValue(addSessionData.getNotes());


    }

    public PageHelpPage clickHelpButton() throws Exception {
        Wait(HELP_BUTTON, 10);
        clickByJavaScript(HELP_BUTTON);
        logReport("Help button clicked successfully");
        return new PageHelpPage(browser);
    }
    public void fillSessionFeeDetails(SessionFeeStructureData sessionFeeStructureData, int rowNo) throws Exception {

        if (ADD_SESSION_FEES_BUTTON.isDisplayed()) {
            clickByJavaScript(ADD_SESSION_FEES_BUTTON);
            logReport("Add Session Fees button clicked successfully");
            VerifyPageReady(20);
            int count = 0;
            for (int i = 1; i <= rowNo; i++) {
                if (count < rowNo) {

                    WebElement feeDate = browser.findElement(By.xpath("//tr[@ng-repeat='fee in feeList'][" + i + "]//input[@ng-model='fee.datepicker']"));
                    //WebElement durationHours = browser.findElement(By.xpath("//tr[@ng-repeat='fee in feeList'][" + i + "]//input[@ng-model='fee.hours']"));
                    //WebElement durationMinutes = browser.findElement(By.xpath("//tr[@ng-repeat='fee in feeList'][" + i + "]//input[@ng-model='fee.minutes']"));
                    WebElement feeAmount = browser.findElement(By.xpath("//tr[@ng-repeat='fee in feeList'][" + i + "]//input[@ng-model='fee.amount']"));
                    WebElement feeCode = browser.findElement(By.xpath("//tr[@ng-repeat='fee in feeList'][" + i + "]//input[@ng-model='fee.code']"));
                    WebElement feeLabel = browser.findElement(By.xpath("//tr[@ng-repeat='fee in feeList'][" + i + "]//input[@ng-model='fee.name']"));
                    WebElement feeGLAccount = browser.findElement(By.xpath("//tr[@ng-repeat='fee in feeList'][" + i + "]//input[@ng-model='fee.glNum']"));

                    String nextDayFeeDateValue = addDaysInDate(sessionFeeStructureData.getFeeExpirationDate(), i, "MM/dd/yyyy");
                    type(feeDate, nextDayFeeDateValue, true);
                    logReport("Typed session fee expiration date value " + nextDayFeeDateValue);

                    //type(durationHours, sessionFeeStructureData.getFeeTimeHrs(), true);
                    //logReport("Typed session fee duration hours value " + sessionFeeStructureData.getFeeTimeHrs());

                    // type(durationMinutes, sessionFeeStructureData.getFeeTimeMins(), true);
                    //logReport("Typed session fee duration minutes value " + sessionFeeStructureData.getFeeTimeMins());

                    type(feeAmount, sessionFeeStructureData.getAmount() + i, true);
                    logReport("Typed session fee amount value " + sessionFeeStructureData.getAmount() + i);

                    type(feeCode, sessionFeeStructureData.getUniqueFeeCode() + i, true);
                    logReport("Typed session fee code value " + sessionFeeStructureData.getUniqueFeeCode() + i);

                    type(feeLabel, sessionFeeStructureData.getFeeLabel() + i, true);
                    logReport("Typed session fee label text " + sessionFeeStructureData.getFeeLabel() + i);

                    type(feeGLAccount, sessionFeeStructureData.getGlAccount() + i, true);
                    logReport("Typed session fee GL account value " + sessionFeeStructureData.getGlAccount() + i);

                    count = count + 1;

                    if (count < rowNo) {

                        Wait(ADD_FEES_BUTTON, 30);
                        clickByJavaScript(ADD_FEES_BUTTON);

                    }

                }
            }

        }
    }

    public void fillCancellationFeeDetails(SessionFeeStructureData sessionCancellationFeeStructureData, int rowNo) throws Exception {

        int count = 0;
        for (int i = 1; i <= rowNo; i++) {
            if (count < rowNo) {

                WebElement cancellationFeeDate = browser.findElement(By.xpath("//tr[@ng-repeat='fee in cancellationFeeList'][" + i + "]//input[@ng-model='fee.datepicker']"));
                // WebElement cancellationDurationHours = browser.findElement(By.xpath("//tr[@ng-repeat='fee in cancellationFeeList'][" + i + "]//input[@ng-model='fee.hours']"));
                // WebElement cancellationDurationMinutes = browser.findElement(By.xpath("//tr[@ng-repeat='fee in cancellationFeeList'][" + i + "]//input[@ng-model='fee.minutes']"));
                WebElement cancellationFeeAmount = browser.findElement(By.xpath("//tr[@ng-repeat='fee in cancellationFeeList'][" + i + "]//input[@ng-model='fee.amount']"));
                WebElement cancellationFeeCode = browser.findElement(By.xpath("//tr[@ng-repeat='fee in cancellationFeeList'][" + i + "]//input[@ng-model='fee.code']"));
                WebElement cancellationFeeLabel = browser.findElement(By.xpath("//tr[@ng-repeat='fee in cancellationFeeList'][" + i + "]//input[@ng-model='fee.name']"));
                WebElement cancellationFeeGLAccount = browser.findElement(By.xpath("//tr[@ng-repeat='fee in cancellationFeeList'][" + i + "]//input[@ng-model='fee.glNum']"));

                String nextDayCanFeeDateValue = addDaysInDate(sessionCancellationFeeStructureData.getFeeExpirationDate(), i, "MM/dd/yyyy");
                type(cancellationFeeDate, nextDayCanFeeDateValue, true);
                logReport("Typed session cancellation fee expiration date value " + nextDayCanFeeDateValue);

                //type(cancellationDurationHours, sessionCancellationFeeStructureData.getFeeTimeHrs(), true);
                //logReport("Typed session cancellation fee duration hours value " + sessionCancellationFeeStructureData.getFeeTimeHrs());

                // type(cancellationDurationMinutes, sessionCancellationFeeStructureData.getFeeTimeMins(), true);
                // logReport("Typed session cancellation fee duration minutes value " + sessionCancellationFeeStructureData.getFeeTimeMins());

                type(cancellationFeeAmount, sessionCancellationFeeStructureData.getAmount() + i, true);
                logReport("Typed session cancellation fee amount value " + sessionCancellationFeeStructureData.getAmount() + i);

                type(cancellationFeeCode, sessionCancellationFeeStructureData.getUniqueFeeCode() + i, true);
                logReport("Typed session cancellation fee code value " + sessionCancellationFeeStructureData.getUniqueFeeCode() + i);

                type(cancellationFeeLabel, sessionCancellationFeeStructureData.getFeeLabel() + i, true);
                logReport("Typed session cancellation fee label text " + sessionCancellationFeeStructureData.getFeeLabel() + i);

                type(cancellationFeeGLAccount, sessionCancellationFeeStructureData.getGlAccount() + i, true);
                logReport("Typed session cancellation fee GL account value " + sessionCancellationFeeStructureData.getGlAccount() + i);

                count = count + 1;

                if (count < rowNo) {
                    Wait(ADD_CANCELLATIONS_FEES_BUTTON, 10);
                    clickByJavaScript(ADD_CANCELLATIONS_FEES_BUTTON);

                }
            }
        }
    }

    public void selectCustomFieldDropdown(WebElement element, String fieldsValue) {
        String a[] = fieldsValue.split(",");
        for (int i = 0; i < a.length; i++) {
            select(element, a[i]);
            logReport("Selected custom fields  values " + a[i]);
        }
    }

    public void clickSessionSaveButton() throws Exception {
        Wait(SESSION_SAVE_BUTTON, 30);
        click(SESSION_SAVE_BUTTON);
        logReport("Session Save button clicked successfully");
        VerifyAngularHasFinishedProcessing(30);
        //VerifyAjaxRequestsFinished(30);
        VerifyPageReady(30);
    }

    public void clickSessionSaveButtonWithoutAngular() throws Exception {
        Wait(SESSION_SAVE_BUTTON, 30);
        click(SESSION_SAVE_BUTTON);
        logReport("Session Save button clicked successfully");

    }

    public void setElementValue(WebElement element, String value) throws Exception {
        Wait(element, 30);
        executeJavascript("arguments[0].setAttribute('value', '" + value + "')", element);
        logReport("Entered Session Start Date : " + value);
    }

    public void fillSessionWithMandatoryFields(AddSessionData addSessionData) throws Exception {
        enterSessionName(addSessionData.getSessionName());
        selectSessionType(addSessionData.getSessionType());
        enterSessionCode(addSessionData.getSessionCode());

    }

    public void selectDateFromDatePicker(String date) throws Exception {
        //Date to be selected (Format dd_MM_YYYY)
        String dateTime = date;

        clickByJavaScript(SESSION_START_DATE);
        //SESSION_START_DATE.click();

        logReport("----Date time value " + dateTime);

        //Split the date to get only the date part
        String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");


        //get the year difference between current year and year to set in calander
        int Year = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);

        clickByJavaScript(DATE_PICKER_CENTER_LINK);
        //DATE_PICKER_CENTER_LINK.click();

        if (Year != 0) {
            //if you have to move next year
            if (Year > 0) {
                for (int i = 0; i < Year; i++) {
                    clickByJavaScript(DATE_PICKER_NEXT_LINK);
                    // DATE_PICKER_NEXT_LINK.click();
                }
            }
            //if you have to move previous year
            else if (Year < 0) {
                for (int i = 0; i < (Year * (-1)); i++) {
                    clickByJavaScript(DATE_PICKER_PREVIOUS_LINK);
                    //  DATE_PICKER_PREVIOUS_LINK.click();
                }
            }
        }
        Thread.sleep(1000);

        List<WebElement> list_Months = browser.findElements(By.xpath("//div[@class='instance-edit']//table[@role='grid']//tbody/tr/td[@class='text-center ng-scope']"));

        // clickByJavaScript(list_Months.get(Integer.parseInt(date_dd_MM_yyyy[1]) - 1));
        logReport("----------" + list_Months.get(Integer.parseInt(date_dd_MM_yyyy[1]) - 1));
        list_Months.get(Integer.parseInt(date_dd_MM_yyyy[1]) - 1).click();

        Thread.sleep(1000);

        List<WebElement> list_Days = browser.findElements(By.xpath("//input[@name='startDate']//following-sibling::ul[@ng-model='date']//td[@ng-repeat='dt in row track by dt.date'][@aria-disabled='false']//button/span"));
        for (WebElement e : list_Days) {
            if (Integer.parseInt(e.getText().trim()) == Integer.parseInt(date_dd_MM_yyyy[0])) {
                clickByJavaScript(e);
                break;
            }
        }
        //    clickByJavaScript(list_Days.get(Integer.parseInt(date_dd_MM_yyyy[0]) - 1));
        // list_Days.get(Integer.parseInt(date_dd_MM_yyyy[0]) - 1).click();

        Thread.sleep(1000);
        logReport("Selected Session Start Date : " + dateTime);
    }

    public String convertDateIntoMonthFormat(String date, String pattern) throws Exception {
        String dt = date;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

        if (pattern.equalsIgnoreCase("MM/dd/yyyy")) {
            dt = sdf2.format(sdf.parse(dt));
        }
        return dt;
    }
    /*public String addDaysInDate(String date, int days, String pattern) throws Exception {

        String dt = date;  // Start date
        logReport("Parse date : " + dt);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        if (pattern.equalsIgnoreCase("dd/MM/yyyy")) {
            dt = sdf.format(sdf2.parse(dt));
        }
        logReport("formatted date sdf2 to sdf : " + dt);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));
        c.add(Calendar.DATE, +days);  // number of days to add
        dt = sdf.format(c.getTime());  // dt is now the new date
        logReport("Increased date : " + dt);
        if (pattern.equalsIgnoreCase("MM/dd/yyyy")) {
            dt = sdf2.format(sdf.parse(dt));
        }
        logReport("Increased date after pattern modified MM/dd/yyyy to dd/MM/yyyy : " + dt);
        return dt;
    }*/

    // Enter values in IFrame
    public void switchToIframe(String iFrameTitle) {
        browser.switchTo().defaultContent();
        WebElement frame = browser.findElement(By.xpath("//label[@title='" + iFrameTitle + "']/../..//iframe"));
        browser.switchTo().frame(frame);
        reporter.info("Switched into iFrame of " + iFrameTitle);
    }

    /*   private void enterIFrameText(String iFrameName, String iFrameValue) {
           switchToIframe(iFrameName);
       private void enterIFrameText(String iFrameName, String iFrameValue) throws Exception {
           String xpath = "//label[@title='" + iFrameName + "']/..//following-sibling::div//textarea";
           WebElement element = browser.findElement(By.xpath(xpath));
           String value = "display: block;";
           executeJavascript("arguments[0].setAttribute('style', '" + value + "')", element);
           Thread.sleep(1000);
           type(browser.findElement(By.xpath(xpath)), iFrameValue);
           /*switchToIframe(iFrameName);
           browser.findElement(By.cssSelector("body")).clear();
           browser.findElement(By.cssSelector("body")).sendKeys(iFrameValue);
          // WebElement element = browser.findElement(By.xpath("//textarea[@id='uiTinymce0']"));
          // type(element, iFrameValue);
           browser.switchTo().defaultContent();
           String xpath = "//label[@title='" + iFrameName + "']/../..//div[text()='p']";
           WebElement element = browser.findElement(By.xpath(xpath));
           clickByJavaScript(element);


           reporter.info("Entered iFrame value " + iFrameValue);


       }*/
    private void enterIFrameText(String iFrameName, String iFrameValue) throws Exception {
        String xpath = "//label[@title='" + iFrameName + "']/..//following-sibling::div//textarea";
        WebElement element = browser.findElement(By.xpath(xpath));
        String value = "display: block;";
        executeJavascript("arguments[0].setAttribute('style', '" + value + "')", element);
        Thread.sleep(1000);
        type(browser.findElement(By.xpath(xpath)), iFrameValue, true);
       /*switchToIframe(iFrameName);
       browser.findElement(By.cssSelector("body")).clear();
       browser.findElement(By.cssSelector("body")).sendKeys(iFrameValue);
       browser.switchTo().defaultContent();
       */
        reporter.info("Entered iFrame value " + iFrameValue);
    }

    public void setDescriptionEditorValue(String iFrameName, String iFrameValue) throws Exception {
        switchToIframe(iFrameName);
        browser.findElement(By.cssSelector("body")).clear();
        browser.findElement(By.cssSelector("body")).sendKeys(iFrameValue);
        browser.switchTo().defaultContent();
    }
    public void enterTextAreaValue(String textAreaName, String textAreaValue) {
        WebElement element = browser.findElement(By.xpath("//label[@title='" + textAreaName + "']/../..//textarea"));
        type(element, textAreaValue, true);
        logReport("Entered Text area value " + textAreaValue + " in the " + textAreaName);
    }

    public void enterTextValue(String textName, String textValue) {
        //WebElement element = browser.findElement(By.xpath("//label[@title='" + textAreaName + "']/../..//textarea"));
        WebElement element = browser.findElement(By.xpath("//label[@title='" + textName + "']/..//following-sibling::div//input"));
        type(element, textValue, true);
        logReport("Entered Text value " + textValue + " in the " + textName);
    }

    /**
     * Method to enter start time of the agenda
     *
     * @param startTime : starting time of agenda
     */
    private void enterStartTimeValue(String startTime) throws Exception {
        String[] times = startTime.split(":");
        String hours = times[0];
        String minutes = times[1].substring(0, 2);
        String meridian = times[1].substring(2, times[1].length());
        Wait(START_TIME_CLOCK, 10);
        click(START_TIME_CLOCK);
        int hoursVal = Integer.parseInt(hours);
        int min = Integer.parseInt(minutes);
        if (hoursVal < 12) {
            int hr = 12 - hoursVal;
            for (int i = 0; i < hr; i++) {
                click(STARTTIME_HOURS_DOWN_BUTTON);
            }
        }
        if (min > 0) {
            for (int i = 0; i < min / 5; i++) {
                click(ENDTIME_MIN_UP_BUTTON);
            }
        }
        WebElement element = browser.findElement(START_TIME_MERIDIAN_BUTTON);
        if (!element.getText().equalsIgnoreCase(meridian)) {
            element.click();
        }
    }

    public void fillInstanceDetailsSingle(AddSessionData addSessionInstanceData, AddSpeakerData addSpeakerData, AddLocationData addLocationData) throws Exception {
        String speakerName = addSpeakerData.getFirstName() + " " + addSpeakerData.getLastName();
        String location = addLocationData.getLocationName() + " " + "(" + addLocationData.getCapacity() + ")";
        String startDateAsCurrentDate = getCurrentDate("dd/MM/yyyy"); //MM/dd/yyyy
        String nextDayDateValue = addDaysInDate(startDateAsCurrentDate, 0, "dd/MM/yyyy");
        selectDateFromDatePicker(nextDayDateValue);
        enterInstanceStartTime(addSessionInstanceData.getInstanceStartTime());
        selectLocation(location);
        enterCapacityValue(addSessionInstanceData.getCapacity());
        enterWaitListLimitValue(addSessionInstanceData.getWaitListLimit());
        selectOverrideCapacity(addSessionInstanceData.isOverrideCapacity());
        selectInstanceSpeakers(speakerName);

    }

    public void fillInstanceDetailsWithoutSpeaker(AddSessionData addSessionInstanceData, AddLocationData addLocationData) throws Exception {
        String location = addLocationData.getLocationName() + " " + "(" + addLocationData.getCapacity() + ")";
        String startDateAsCurrentDate = getCurrentDate("dd/MM/yyyy"); //MM/dd/yyyy
        String nextDayDateValue = addDaysInDate(startDateAsCurrentDate, 0, "dd/MM/yyyy");
        selectDateFromDatePicker(nextDayDateValue);
        selectLocation(location);
        enterInstanceStartTime(addSessionInstanceData.getInstanceStartTime());
        enterCapacityValue(addSessionInstanceData.getCapacity());
        enterWaitListLimitValue(addSessionInstanceData.getWaitListLimit());
        selectOverrideCapacity(addSessionInstanceData.isOverrideCapacity());


    }
    public String fillInstancesDetails(AddSessionData addSessionInstanceData, int numberOfInstances, AddSpeakerData addSpeakerData, AddLocationData addLocationData) throws Exception {
        String speakerName = addSpeakerData.getFirstName() + " " + addSpeakerData.getLastName();
        String location = addLocationData.getLocationName() + " " + "(" + addLocationData.getCapacity() + ")";
        String startDateAsCurrentDate = getCurrentDate("dd/MM/yyyy"); //MM/dd/yyyy
        String nextDayDateValue = addDaysInDate(startDateAsCurrentDate, 0, "dd/MM/yyyy");
        int count = 0;
        String xpath = "//div[@class='col-sm-1 col-md-1 certain-blue sublist-index text-center no-padding']";
        if (numberOfInstances == 1) {
            if (verifyElementDisplayed(By.xpath(xpath), 2)) {
                clickByJavaScript(EXPANDED_INSTANCE_ARROW);
            }
            //selectDateFromDatePicker(addSessionInstanceData.getInstanceStartDate());
            selectDateFromDatePicker(nextDayDateValue);
            enterInstanceStartTime(addSessionInstanceData.getInstanceStartTime());
            selectLocation(location);
            enterCapacityValue(addSessionInstanceData.getCapacity());
            enterWaitListLimitValue(addSessionInstanceData.getWaitListLimit());
            selectOverrideCapacity(addSessionInstanceData.isOverrideCapacity());
            selectInstanceSpeakersDrawer(speakerName);
        }
        if (numberOfInstances > 1) {
            String addInst = "//button[@x-ng-click='addSessionInstance()']";
            for (int i = 1; i <= numberOfInstances; i++) {
                if (verifyElementDisplayed(By.xpath(xpath), 2)) {
                    clickByJavaScript(EXPANDED_INSTANCE_ARROW);
                }
                if (count < numberOfInstances) {

                    //String startDateFromSheet = addSessionInstanceData.getInstanceStartDate();
                    String nextDaysDateValue = addDaysInDate(startDateAsCurrentDate, i, "MM/dd/yyyy");
                    selectDateFromDatePicker(nextDaysDateValue);
                    enterInstanceStartTime(addSessionInstanceData.getInstanceStartTime());
                    // enterStartTimeValue(addSessionInstanceData.getInstanceStartTime());
                    selectLocation(location);
                    enterCapacityValue(addSessionInstanceData.getCapacity());
                    enterWaitListLimitValue(addSessionInstanceData.getWaitListLimit());
                    selectOverrideCapacity(addSessionInstanceData.isOverrideCapacity());
                    selectInstanceSpeakersDrawer(speakerName);

                    count = count + 1;
                    if (count < numberOfInstances) {
                        if (verifyElementDisplayed(By.xpath(addInst), 2)) {
                            click(ADD_INSTANCE_BUTTON);
                        }
                    }
                }
            }

        }
        return nextDayDateValue;

    }

    public String fillInstancesDetailsWithoutSpeakers(AddSessionData addSessionInstanceData, int numberOfInstances, AddLocationData addLocationData) throws Exception {
        //  String speakerName = addSpeakerData.getFirstName() + " " + addSpeakerData.getLastName();
        String location = addLocationData.getLocationName() + " " + "(" + addLocationData.getCapacity() + ")";
        String startDateAsCurrentDate = getCurrentDate("dd/MM/yyyy"); //MM/dd/yyyy
        String nextDayDateValue = addDaysInDate(startDateAsCurrentDate, 0, "dd/MM/yyyy");
        int count = 0;
        String xpath = "//div[@class='col-sm-1 col-md-1 certain-blue sublist-index text-center no-padding']";
        if (numberOfInstances == 1) {
            if (verifyElementDisplayed(By.xpath(xpath), 2)) {
                clickByJavaScript(EXPANDED_INSTANCE_ARROW);
            }
            //selectDateFromDatePicker(addSessionInstanceData.getInstanceStartDate());
            selectDateFromDatePicker(nextDayDateValue);
            enterInstanceStartTime(addSessionInstanceData.getInstanceStartTime());
            selectLocation(location);
            enterCapacityValue(addSessionInstanceData.getCapacity());
            enterWaitListLimitValue(addSessionInstanceData.getWaitListLimit());
            selectOverrideCapacity(addSessionInstanceData.isOverrideCapacity());
            // selectInstanceSpeakers(speakerName);
        }
        if (numberOfInstances > 1) {
            String addInst = "//button[@x-ng-click='addSessionInstance()']";
            for (int i = 1; i <= numberOfInstances; i++) {
                if (verifyElementDisplayed(By.xpath(xpath), 2)) {
                    clickByJavaScript(EXPANDED_INSTANCE_ARROW);
                }
                if (count < numberOfInstances) {

                    //String startDateFromSheet = addSessionInstanceData.getInstanceStartDate();
                    String nextDaysDateValue = addDaysInDate(startDateAsCurrentDate, i, "MM/dd/yyyy");
                    selectDateFromDatePicker(nextDaysDateValue);
                    enterInstanceStartTime(addSessionInstanceData.getInstanceStartTime());
                    // enterStartTimeValue(addSessionInstanceData.getInstanceStartTime());
                    selectLocation(location);
                    enterCapacityValue(addSessionInstanceData.getCapacity());
                    enterWaitListLimitValue(addSessionInstanceData.getWaitListLimit());
                    selectOverrideCapacity(addSessionInstanceData.isOverrideCapacity());
                    //  selectInstanceSpeakers(speakerName);

                    count = count + 1;
                    if (count < numberOfInstances) {
                        if (verifyElementDisplayed(By.xpath(addInst), 2)) {
                            click(ADD_INSTANCE_BUTTON);
                        }
                    }
                }
            }

        }
        return nextDayDateValue;

    }

    public String fillInstancesDetailsBasedOnTime(AddSessionData addSessionInstanceData, int numberOfInstances, AddSpeakerData addSpeakerData, AddLocationData addLocationData) throws Exception {
        String speakerName = addSpeakerData.getFirstName() + " " + addSpeakerData.getLastName();
        String location = addLocationData.getLocationName() + " " + "(" + addLocationData.getCapacity() + ")";
        String startDateAsCurrentDate = getCurrentDate("dd/MM/yyyy"); //MM/dd/yyyy
        String nextDayDateValue = addDaysInDate(startDateAsCurrentDate, 0, "dd/MM/yyyy");
        int count = 0;
        String xpath = "//div[@class='col-sm-1 col-md-1 certain-blue sublist-index text-center no-padding']";
        String addInst = "//button[@x-ng-click='addSessionInstance()']";
        String startTime = null;
        String newStartTime = null;
        for (int i = 1; i <= numberOfInstances; i++) {
            if (i == 1) {
                startTime = addSessionInstanceData.getInstanceStartTime();
            } else {
                startTime = addTimeUsingSpecifiedFormat(newStartTime, 10);
            }
            if (count < numberOfInstances) {
                String nextDaysDateValue = addDaysInDate(startDateAsCurrentDate, 0, "MM/dd/yyyy");
                selectDateFromDatePicker(nextDaysDateValue);
                enterInstanceStartTime(startTime);
                newStartTime = startTime;
                selectLocation(location);
                enterCapacityValue(addSessionInstanceData.getCapacity());
                enterWaitListLimitValue(addSessionInstanceData.getWaitListLimit());
                selectOverrideCapacity(addSessionInstanceData.isOverrideCapacity());
                selectInstanceSpeakersMultiple(speakerName, count);

                count = count + 1;
                if (count < numberOfInstances) {
                    if (verifyElementDisplayed(By.xpath(addInst), 2)) {
                        clickByJavaScript(ADD_INSTANCE_BUTTON);
                    }
                }
            }
        }

        return nextDayDateValue;

    }

    public String fillInstancesDetailsBasedOnTimeWithoutSpeaker(AddSessionData addSessionInstanceData, int numberOfInstances, AddLocationData addLocationData) throws Exception {
        String location = addLocationData.getLocationName() + " " + "(" + addLocationData.getCapacity() + ")";
        String startDateAsCurrentDate = getCurrentDate("dd/MM/yyyy"); //MM/dd/yyyy
        String nextDayDateValue = addDaysInDate(startDateAsCurrentDate, 0, "dd/MM/yyyy");
        int count = 0;
        String xpath = "//div[@class='col-sm-1 col-md-1 certain-blue sublist-index text-center no-padding']";
        String addInst = "//button[@x-ng-click='addSessionInstance()']";
        String startTime = null;
        String newStartTime = null;
        for (int i = 1; i <= numberOfInstances; i++) {
            if (i == 1) {
                startTime = addSessionInstanceData.getInstanceStartTime();
            } else {
                startTime = addTimeUsingSpecifiedFormat(newStartTime, 10);
            }
            if (count < numberOfInstances) {
                String nextDaysDateValue = addDaysInDate(startDateAsCurrentDate, 0, "MM/dd/yyyy");
                selectDateFromDatePicker(nextDaysDateValue);
                enterInstanceStartTime(startTime);
                newStartTime = startTime;
                selectLocation(location);
                enterCapacityValue(addSessionInstanceData.getCapacity());
                enterWaitListLimitValue(addSessionInstanceData.getWaitListLimit());
                selectOverrideCapacity(addSessionInstanceData.isOverrideCapacity());
                // selectInstanceSpeakers(speakerName);

                count = count + 1;
                if (count < numberOfInstances) {
                    if (verifyElementDisplayed(By.xpath(addInst), 2)) {
                        clickByJavaScript(ADD_INSTANCE_BUTTON);
                    }
                }
            }
        }

        return nextDayDateValue;

    }

    public void fillSelectTypeCustomFieldValue(AddCustomFieldsData addCustomFieldsData) throws Exception {
        String customFieldName = addCustomFieldsData.getFieldName();
        WebElement customField = browser.findElement(By.xpath("//label[@title='" + customFieldName + "']/following::select[@data-placeholder='" + customFieldName + "']"));
        String a[] = addCustomFieldsData.getOptions().split(",");
        // select(customField, addCustomFieldsData.getOptions());
        select(customField, a[0]);
        logReport("Selected select custom field value " + a[0]);

    }

    public void fillMultiSelectTypeCustomFieldValue(AddCustomFieldsData addCustomFieldsData) throws Exception {
        String customFieldName = addCustomFieldsData.getFieldName();
        WebElement customField = browser.findElement(By.xpath("//label[@title='" + customFieldName + "']/following::select[@data-placeholder='" + customFieldName + "']"));
        String a[] = addCustomFieldsData.getOptions().split(",");
        //selectCustomFieldDropdown(customField, addCustomFieldsData.getOptions());
        select(customField, a[0]);
        logReport("Selected multi select custom field value " + a[0]);

    }

    public void fillInputTypeCustomFieldValue(AddCustomFieldsData addCustomFieldsData) throws Exception {
        String customFieldName = addCustomFieldsData.getFieldName();
        WebElement customField = browser.findElement(By.xpath("//label[@title='" + customFieldName + "']/..//following-sibling::div//input"));
        type(customField, addCustomFieldsData.getOptions(), true);
        logReport("Selected input custom field value " + addCustomFieldsData.getOptions());
    }

    public void fillTextAreaTypeCustomFieldValue(AddCustomFieldsData addCustomFieldsData) throws Exception {
        String customFieldName = addCustomFieldsData.getFieldName();
        String customFieldValue = addCustomFieldsData.getOptions();
        // enterIFrameText(customFieldName, customFieldValue);
        enterTextAreaValue(customFieldName, customFieldValue);
        logReport("Entered text area custom field value " + customFieldValue);
    }

    public void fillCustomFieldData(AddCustomFieldsData addCustomFieldsData) throws Exception {
        if (addCustomFieldsData.getFieldType().equalsIgnoreCase("Text")) {
            fillInputTypeCustomFieldValue(addCustomFieldsData);
        } else if (addCustomFieldsData.getFieldType().equalsIgnoreCase("Textarea")) {
            fillTextAreaTypeCustomFieldValue(addCustomFieldsData);
        } else if (addCustomFieldsData.getFieldType().equalsIgnoreCase("Radio") || addCustomFieldsData.getFieldType().equalsIgnoreCase("Select")) {
            fillSelectTypeCustomFieldValue(addCustomFieldsData);
        } else {
            fillMultiSelectTypeCustomFieldValue(addCustomFieldsData);
        }
    }
    public void searchSessionBySessionCode(String sessionCode) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);

        type(SESSION_SEARCH_BOX, sessionCode);
        logReport("Entered session code is " + sessionCode);

        click(SESSION_SEARCH_BUTTON);
        VerifyPageReady(30);

        WebElement sessionEditButton = browser.findElement(By.xpath("//tbody[@ng-repeat='session in sessionList']//td[contains(text(),'" + sessionCode + "')]/..//td[@class='user-action']//i[@class='fa fa-pencil fa-lg']"));
        click(sessionEditButton);
        logReport("Clicked on " + sessionCode + "edit button");
    }

    public void addNewSessionWithEmptySessionName(AddSessionData addSessionData) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        enterSessionName("");
        selectSessionType(addSessionData.getSessionType());
        enterSessionCode(addSessionData.getSessionCode());
    }

    public void addNewSessionWithOutSessionType(AddSessionData addSessionData) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        enterSessionName(addSessionData.getSessionName());
        enterSessionCode(addSessionData.getSessionCode());
    }

    public void addNewSessionWithEmptySessionCode(AddSessionData addSessionData) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        enterSessionName(addSessionData.getSessionName());
        selectSessionType(addSessionData.getSessionType());
        enterSessionCode("");
    }

    public SessionsListPage clickSessionCancelButton() throws Exception {
        Wait(SESSION_CANCEL_BUTTON, 30);
        click(SESSION_CANCEL_BUTTON);
        logReport("Session Cancel button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        return new SessionsListPage(browser);
    }

    public void addNewSessionWithEmptySessionInstance(AddSessionData addSessionData) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        enterSessionName(addSessionData.getSessionName());
        selectSessionType(addSessionData.getSessionType());
        enterSessionCode(addSessionData.getSessionCode());
        enterInstancesValue("");
    }

    public void addNewSessionWithZeroSessionInstance(AddSessionData addSessionData) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        enterSessionName(addSessionData.getSessionName());
        selectSessionType(addSessionData.getSessionType());
        enterSessionCode(addSessionData.getSessionCode());
        enterInstancesValue("0");
    }

    public void addNewSessionWithMaxSessionName(AddSessionData addSessionData) throws Exception {
        String sessionName = "sessionmaxlegth255sessionmaxlegth255sessionmaxlegth255sessionmaxlegth255sessionmaxlegth255sessionmaxlegth255sessionmaxlegth255sessionmaxlegth255sessionmaxlegth255sessionmaxlegth255sessionmaxlegth255sessionmaxlegth255sessionmaxlegth255sessionmaxlegth255sessi";
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        enterSessionName(sessionName);
        selectSessionType(addSessionData.getSessionType());
        enterSessionCode(addSessionData.getSessionCode());
    }

    public List<SessionFeeStructureData> getSessionFeeDetails() throws Exception {
        SessionFeeStructureData sessionFeeStructureData;
        List<SessionFeeStructureData> sessionFeeStructureDataList = new ArrayList<>();
        int count = SESSION_FEE_LIST.size();
        for (int i = 1; i <= count; i++) {

            String feeDate = browser.findElement(By.xpath("//tr[@ng-repeat='fee in feeList'][" + i + "]//input[@ng-model='fee.datepicker']")).getAttribute("value").trim();
            String durationHours = browser.findElement(By.xpath("//tr[@ng-repeat='fee in feeList'][" + i + "]//input[@ng-model='fee.hours']")).getAttribute("value").trim();
            String durationMinutes = browser.findElement(By.xpath("//tr[@ng-repeat='fee in feeList'][" + i + "]//input[@ng-model='fee.minutes']")).getAttribute("value").trim();
            String feeAmount = browser.findElement(By.xpath("//tr[@ng-repeat='fee in feeList'][" + i + "]//input[@ng-model='fee.amount']")).getAttribute("value").trim();
            String feeCode = browser.findElement(By.xpath("//tr[@ng-repeat='fee in feeList'][" + i + "]//input[@ng-model='fee.code']")).getAttribute("value").trim();
            String feeLabel = browser.findElement(By.xpath("//tr[@ng-repeat='fee in feeList'][" + i + "]//input[@ng-model='fee.name']")).getAttribute("value").trim();
            String feeGLAccount = browser.findElement(By.xpath("//tr[@ng-repeat='fee in feeList'][" + i + "]//input[@ng-model='fee.glNum']")).getAttribute("value").trim();

            sessionFeeStructureData = new SessionFeeStructureData(feeDate, durationHours, durationMinutes, feeAmount, feeCode, feeLabel, feeGLAccount, String.valueOf(count));
            sessionFeeStructureDataList.add(sessionFeeStructureData);
        }

        return sessionFeeStructureDataList;
    }

    public List<SessionFeeStructureData> getSessionCancelFeeDetails() throws Exception {
        SessionFeeStructureData sessionFeeStructureData;
        List<SessionFeeStructureData> sessionFeeStructureDataList = new ArrayList<>();
        int count = CANCELLATION_FEE_LIST.size();
        for (int i = 1; i <= count; i++) {

            String feeDate = browser.findElement(By.xpath("//tr[@ng-repeat='fee in cancellationFeeList'][" + i + "]//input[@ng-model='fee.datepicker']")).getAttribute("value").trim();
            String durationHours = browser.findElement(By.xpath("//tr[@ng-repeat='fee in cancellationFeeList'][" + i + "]//input[@ng-model='fee.hours']")).getAttribute("value").trim();
            String durationMinutes = browser.findElement(By.xpath("//tr[@ng-repeat='fee in cancellationFeeList'][" + i + "]//input[@ng-model='fee.minutes']")).getAttribute("value").trim();
            String feeAmount = browser.findElement(By.xpath("//tr[@ng-repeat='fee in cancellationFeeList'][" + i + "]//input[@ng-model='fee.amount']")).getAttribute("value").trim();
            String feeCode = browser.findElement(By.xpath("//tr[@ng-repeat='fee in cancellationFeeList'][" + i + "]//input[@ng-model='fee.code']")).getAttribute("value").trim();
            String feeLabel = browser.findElement(By.xpath("//tr[@ng-repeat='fee in cancellationFeeList'][" + i + "]//input[@ng-model='fee.name']")).getAttribute("value").trim();
            String feeGLAccount = browser.findElement(By.xpath("//tr[@ng-repeat='fee in cancellationFeeList'][" + i + "]//input[@ng-model='fee.glNum']")).getAttribute("value").trim();

            sessionFeeStructureData = new SessionFeeStructureData(feeDate, durationHours, durationMinutes, feeAmount, feeCode, feeLabel, feeGLAccount, String.valueOf(count));
            sessionFeeStructureDataList.add(sessionFeeStructureData);
        }

        return sessionFeeStructureDataList;
    }

    public List<AddSessionData> getSessionInstanceDetails(String instanceSpeaker) throws Exception {
        AddSessionData addSessionData;
        List<AddSessionData> addSessionDataList = new ArrayList<>();
        for (int i = 0; i < INSTANCES_LIST.size(); i++) {
            String xpath = "//tbody[contains(@ng-repeat,'instance in session.confSessionInstance')][" + (i + 1) + "]//div[@class='col-sm-1 col-md-1 certain-blue sublist-index text-center no-padding']";
            if (verifyElementDisplayed(By.xpath(xpath), 6)) {
                clickByJavaScript(browser.findElement(By.xpath(xpath)));
            }
            String startDate = SESSION_START_DATE.getAttribute("value").trim();
            String startTime = SESSION_START_TIME.getAttribute("value").trim();
            String endTime = SESSION_END_TIME.getAttribute("value").trim();
            String location = getSelectedOption(LOCATION_DROPDOWN).split(" ")[0];
            String capacity = INSTANCE_CAPACITY_TEXTBOX.getAttribute("value").trim();
            String waitListLimit = INSTANCE_WAITLISTEDLIMIT_TEXTBOX.getAttribute("value").trim();
            String overrideCapacity = String.valueOf(OVERRIDE_CAPACITY_CHECKBOX.isSelected());
            List<String> speakerList = getInstanceSpeakersList();
            logReport("Instance speaker list " + speakerList);
            String speakers = null;
            for (int j = 0; j < speakerList.size(); j++) {
                if (speakerList.get(j).equalsIgnoreCase(instanceSpeaker)) {
                    speakers = instanceSpeaker;
                    logReport("Instance speaker matched");

                }

            }
            clickByJavaScript(CLOSE_INSTANCE);
            VerifyPageReady(20);
            addSessionData = new AddSessionData(startTime, Boolean.valueOf(overrideCapacity), capacity, convertDateIntoMonthFormat(startDate, "MM/dd/yyyy"), location, waitListLimit, endTime, speakers);
            logReport("Actual instance details " + addSessionData);
            addSessionDataList.add(addSessionData);
        }
        logReport("---Instance details " + addSessionDataList);
        return addSessionDataList;
    }

    public List<AddSessionData> getSessionInstanceDetailsWithoutLocation(String instanceSpeaker) throws Exception {
        AddSessionData addSessionData;
        List<AddSessionData> addSessionDataList = new ArrayList<>();
        for (int i = 0; i < INSTANCES_LIST.size(); i++) {
            String xpath = "//tbody[contains(@ng-repeat,'instance in session.confSessionInstance')][" + (i + 1) + "]//div[@class='col-sm-1 col-md-1 certain-blue sublist-index text-center no-padding']";
            if (verifyElementDisplayed(By.xpath(xpath), 6)) {
                clickByJavaScript(browser.findElement(By.xpath(xpath)));
            }
            String startDate = SESSION_START_DATE.getAttribute("value").trim();
            String startTime = SESSION_START_TIME.getAttribute("value").trim();
            String endTime = SESSION_END_TIME.getAttribute("value").trim();
            //  String location = getSelectedOption(LOCATION_DROPDOWN).split(" ")[0];
            String capacity = INSTANCE_CAPACITY_TEXTBOX.getAttribute("value").trim();
            String waitListLimit = INSTANCE_WAITLISTEDLIMIT_TEXTBOX.getAttribute("value").trim();
            String overrideCapacity = String.valueOf(OVERRIDE_CAPACITY_CHECKBOX.isSelected());
            List<String> speakerList = getInstanceSpeakersList();
            logReport("Instance speaker list " + speakerList);
            String speakers = null;
            for (int j = 0; j < speakerList.size(); j++) {
                if (speakerList.get(j).equalsIgnoreCase(instanceSpeaker)) {
                    speakers = instanceSpeaker;
                    logReport("Instance speaker matched");

                }

            }
            clickByJavaScript(CLOSE_INSTANCE);
            VerifyPageReady(20);
            addSessionData = new AddSessionData(startTime, Boolean.valueOf(overrideCapacity), capacity, convertDateIntoMonthFormat(startDate, "MM/dd/yyyy"), waitListLimit, endTime, speakers);
            logReport("Actual instance details " + addSessionData);
            addSessionDataList.add(addSessionData);
        }
        logReport("---Instance details " + addSessionDataList);
        return addSessionDataList;
    }

    public AddSessionData getActualSessionInstanceDetailsForImport(String instanceCode) throws Exception {
        StringBuilder instanceSpeakers = new StringBuilder();
        AddSessionData addSessionData = null;
        String xpath = "//tbody[@ng-repeat='instance in session.confSessionInstance']//div[contains(text(),'" + instanceCode + "')]";
        if (verifyElementDisplayed(By.xpath(xpath), 2)) {
            WebElement element = browser.findElement(By.xpath(xpath));
            clickByJavaScript(element);
            Thread.sleep(500);

            String startDate = SESSION_START_DATE.getAttribute("value").trim();
            String location = getSelectedOption(LOCATION_DROPDOWN).split(" ")[0];
            String capacity = INSTANCE_CAPACITY_TEXTBOX.getAttribute("value").trim();
            String waitListLimit = INSTANCE_WAITLISTEDLIMIT_TEXTBOX.getAttribute("value").trim();
            String overrideCapacity = String.valueOf(OVERRIDE_CAPACITY_CHECKBOX.isSelected());

            String startTime = SESSION_START_TIME.getAttribute("value").trim();
            String endTime = SESSION_END_TIME.getAttribute("value").trim();

            List<WebElement> instanceSpeakersList = browser.findElements(By.xpath("//div[@ng-repeat='sessionSpeaker in instance.confSpeaker']//strong"));
            List<String> speakersData = new ArrayList<>();
            for (WebElement e : instanceSpeakersList) {
                speakersData.add(e.getText().trim());

            }
            Collections.sort(speakersData);
            for (String s : speakersData) {
                instanceSpeakers.append(s);
                instanceSpeakers.append("|");
            }
            if (instanceSpeakers.length() > 1) {
                instanceSpeakers.setLength(instanceSpeakers.length() - 1);
            }

            addSessionData = new AddSessionData(startTime, Boolean.valueOf(overrideCapacity), capacity, startDate, location, waitListLimit, endTime, instanceSpeakers.toString(), instanceCode);
            logReport("Actual Conference session Instance fields details " + addSessionData);

        } else {
            logReport("No instance found for :" + instanceCode);
        }

        // addSessionData = new AddSessionData(instanceCode, startDate, endDate, location , location, capacity, waitListLimit , overrideCapacity, instanceSpeakers.toString() );


        return addSessionData;
    }

    public AddSessionData getSessionInstanceDetailsForImportStandardSession() throws Exception {
        StringBuilder instanceSpeakers = new StringBuilder();
        AddSessionData addSessionData = null;

        String startDate = SESSION_START_DATE.getAttribute("value").trim();
        //String location = getSelectedOption(LOCATION_DROPDOWN).split(" ")[0];
        String capacity = INSTANCE_CAPACITY_TEXTBOX.getAttribute("value").trim();
        String waitListLimit = INSTANCE_WAITLISTEDLIMIT_TEXTBOX.getAttribute("value").trim();
        String overrideCapacity = String.valueOf(OVERRIDE_CAPACITY_CHECKBOX.isSelected());

        String startTime = SESSION_START_TIME.getAttribute("value").trim();
        String endTime = SESSION_END_TIME.getAttribute("value").trim();

        List<WebElement> instanceSpeakersList = browser.findElements(By.xpath("//div[@ng-repeat='sessionSpeaker in instance.confSpeaker']//strong"));
        List<String> speakersData = new ArrayList<>();
        for (WebElement e : instanceSpeakersList) {
            speakersData.add(e.getText().trim());

        }
        Collections.sort(speakersData);
        for (String s : speakersData) {
            instanceSpeakers.append(s);
            instanceSpeakers.append("|");
        }
        if (instanceSpeakers.length() > 1) {
            instanceSpeakers.setLength(instanceSpeakers.length() - 1);
        }

        addSessionData = new AddSessionData(startTime, Boolean.valueOf(overrideCapacity), capacity, startDate, waitListLimit, endTime, instanceSpeakers.toString());
        logReport("Actual Conference session Instance fields details " + addSessionData);


        return addSessionData;
    }

    public boolean isEmptySessionInstanceForStandardSession() {
        StringBuilder instanceSpeakers = new StringBuilder();
        AddSessionData addSessionData = null;

        String startDate = SESSION_START_DATE.getAttribute("value").trim();
        String location = getSelectedOption(LOCATION_DROPDOWN).split(" ")[0];
        String capacity = INSTANCE_CAPACITY_TEXTBOX.getAttribute("value").trim();
        String waitListLimit = INSTANCE_WAITLISTEDLIMIT_TEXTBOX.getAttribute("value").trim();
        String overrideCapacity = String.valueOf(OVERRIDE_CAPACITY_CHECKBOX.isSelected());

        String startTime = SESSION_START_TIME.getAttribute("value").trim();
        String endTime = SESSION_END_TIME.getAttribute("value").trim();

        List<WebElement> instanceSpeakersList = browser.findElements(By.xpath("//div[@ng-repeat='sessionSpeaker in instance.confSpeaker']//strong"));
        List<String> speakersData = new ArrayList<>();
        for (WebElement e : instanceSpeakersList) {
            speakersData.add(e.getText().trim());

        }
        Collections.sort(speakersData);
        for (String s : speakersData) {
            instanceSpeakers.append(s);
            instanceSpeakers.append("|");
        }
        if (instanceSpeakers.length() > 1) {
            instanceSpeakers.setLength(instanceSpeakers.length() - 1);
        }

        addSessionData = new AddSessionData(startTime, Boolean.valueOf(overrideCapacity), capacity, startDate, location, waitListLimit, endTime, instanceSpeakers.toString());
        logReport("Actual Conference session Instance fields details " + addSessionData);
        return startDate.isEmpty() && location.isEmpty() && capacity.isEmpty() && startTime.isEmpty() && endTime.isEmpty() && instanceSpeakers.toString().isEmpty();
    }

    public String getInstanceEndTime(String startTime, String duration) {
        String[] times = startTime.split(":");
        String hours = times[0];
        String minutes = times[1].substring(0, 2);
        String min = String.valueOf(Integer.parseInt(minutes) + Integer.parseInt(duration));
        String meridian = times[1].substring(2, times[1].length());
        String endTime = hours + ":" + min + "" + meridian;
        logReport("---------End Time value is " + endTime);
        return endTime;

    }
    public AddSessionData getSessionStandardFields() throws Exception {
        AddSessionData addSessionData;
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
        String durationHrs = getSelectedOption(DURATION_HRS_DRODPOWN);
        String durationMins = getSelectedOption(DURATION_MINS_DRODPOWN);
        String ceuCredit = CEUCREDITS_TEXTBOX.getAttribute("value").trim();
        String instances = INSTANCES_TEXTBOX.getAttribute("value").trim();
        click(SPEAKERS_LINK);
        switchToLatestTabOrWindow();
        String speakers = SESSION_SPEAKER.getText().trim();
        click(CLOSE_SPEAKER_DRAWER);
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

        addSessionData = new AddSessionData(sessionName, sessiontype, sessionCode, track, tags, sessionLevel, points, durationHrs, durationMins,
                ceuCredit, instances, speakers, notes, abstractDesc, abstractFile, sessionFile, sessionDesc, sessionLabel, jobFunction, industries);
        logReport("Actual instance details " + addSessionData);
        return addSessionData;
    }

    public List<String> getSessionMandatoryFields() throws Exception {
        List<String> sessionsData = new ArrayList<>();
        Wait(SESSION_NAME_TEXTBOX, 30);
        String sessionName = SESSION_NAME_TEXTBOX.getAttribute("value").trim();
        String sessiontype = SESSION_TYPE_VALUE.getText().trim();
        String sessionCode = SESSION_CODE_TEXTBOX.getAttribute("value").trim();
        sessionsData.add(sessionName);
        sessionsData.add(sessionCode);
        sessionsData.add(sessiontype);

        return sessionsData;
    }
    public AddSessionData getSessionStandardFieldsForImport() throws Exception {
        AddSessionData addSessionData;
        Wait(SESSION_NAME_TEXTBOX, 30);
        String sessionName = SESSION_NAME_TEXTBOX.getAttribute("value").trim();
        String sessiontype = SESSION_TYPE_VALUE.getText().trim();
        String sessionCode = SESSION_CODE_TEXTBOX.getAttribute("value").trim();
        String track = TRACK_VALUE.getText().trim();
        List<String> tagsList = getSelectedOptions(TAGS_DRODPOWN);
        Collections.sort(tagsList);
        String tags = StringUtils.join(tagsList, "|");
        logReport("Tags values " + tags);

        String sessionLevel = SESSION_LEVEL_VALUE.getText().trim();
        String points = POINTS_TEXTBOX.getAttribute("value").trim();
        String durationHrs = getSelectedOption(DURATION_HRS_DRODPOWN);
        String durationMins = getSelectedOption(DURATION_MINS_DRODPOWN);
        String ceuCredit = CEUCREDITS_TEXTBOX.getAttribute("value").trim();
        String instances = INSTANCES_TEXTBOX.getAttribute("value").trim();
        List<WebElement> speakersList = browser.findElements(By.xpath("//div[@ng-repeat='sessionSpeaker in sessionSpeakers']//strong"));
        StringBuilder speakers = new StringBuilder();
        for (WebElement e : speakersList) {
            speakers.append(e.getText().trim());
            speakers.append("|");
        }
        speakers.setLength(speakers.length() - 1);

        String notes = SESSION_NOTES_TEXTAREA.getAttribute("value").trim();
        String abstractFile = null;
        switchToIframe("Abstract Description");
        String abstractDesc = browser.findElement(By.xpath("//p")).getText().trim();
        browser.switchTo().defaultContent();
        String sessionFile = null;
        switchToIframe("Session Description");
        String sessionDesc = browser.findElement(By.xpath("//p")).getText().trim();
        browser.switchTo().defaultContent();
        String sessionLabel = SESSION_LABEL_TEXTBOX.getAttribute("value").trim();
        List<String> jobFunctionList = getSelectedOptions(JOB_FUNCTIONS_DROPDOWN);
        Collections.sort(jobFunctionList);
        String jobFunction = StringUtils.join(jobFunctionList, "|");
        List<String> industryList = getSelectedOptions(INDUSTRIES_DROPDOWN);
        Collections.sort(industryList);
        String industries = StringUtils.join(industryList, "|");

        addSessionData = new AddSessionData(sessionName, sessiontype, sessionCode, track, tags, sessionLevel, points, durationHrs, durationMins,
                ceuCredit, instances, speakers.toString(), notes, abstractDesc, abstractFile, sessionFile, sessionDesc, sessionLabel, jobFunction, industries);
        logReport("Actual instance details " + addSessionData);
        return addSessionData;
    }

    public AddSessionData getSessionStandardFieldsForImportStandardSession() throws Exception {
        AddSessionData addSessionData;
        Wait(SESSION_NAME_TEXTBOX, 30);
        String sessionName = SESSION_NAME_TEXTBOX.getAttribute("value").trim();
        String sessiontype = SESSION_TYPE_VALUE.getText().trim();
        String sessionCode = SESSION_CODE_TEXTBOX.getAttribute("value").trim();
        String track = TRACK_VALUE.getText().trim();
        List<String> tagsList = getSelectedOptions(TAGS_DRODPOWN);
        Collections.sort(tagsList);
        String tags = StringUtils.join(tagsList, "|");
        logReport("Tags values " + tags);

        String sessionLevel = SESSION_LEVEL_VALUE.getText().trim();
        String points = POINTS_TEXTBOX.getAttribute("value").trim();
        String ceuCredit = CEUCREDITS_TEXTBOX.getAttribute("value").trim();
        String notes = SESSION_NOTES_TEXTAREA.getAttribute("value").trim();
        switchToIframe("Abstract Description");
        String abstractDesc = browser.findElement(By.xpath("//p")).getText().trim();
        browser.switchTo().defaultContent();
        switchToIframe("Session Description");
        String sessionDesc = browser.findElement(By.xpath("//p")).getText().trim();
        browser.switchTo().defaultContent();
        String sessionLabel = SESSION_LABEL_TEXTBOX.getAttribute("value").trim();
        List<String> jobFunctionList = getSelectedOptions(JOB_FUNCTIONS_DROPDOWN);
        Collections.sort(jobFunctionList);
        String jobFunction = StringUtils.join(jobFunctionList, "|");
        List<String> industryList = getSelectedOptions(INDUSTRIES_DROPDOWN);
        Collections.sort(industryList);
        String industries = StringUtils.join(industryList, "|");

        addSessionData = new AddSessionData(sessionName, sessiontype, sessionCode, track, tags, sessionLevel, points,
                ceuCredit, notes, abstractDesc, sessionDesc, sessionLabel, jobFunction, industries);
        logReport("Actual instance details " + addSessionData);
        return addSessionData;
    }


    public AddSessionData getDefaultSessionStandardFields() throws Exception {
        AddSessionData addSessionData;
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
        String durationHrs = getSelectedOption(DURATION_HRS_DRODPOWN);
        String durationMins = getSelectedOption(DURATION_MINS_DRODPOWN);
        String ceuCredit = CEUCREDITS_TEXTBOX.getAttribute("value").trim();
        String instances = INSTANCES_TEXTBOX.getAttribute("value").trim();
        // String speakers = SESSION_SPEAKER.getText().trim();

        clickByJavaScript(SPEAKERS_BUTTON);
        Thread.sleep(3000);
        String speakers = SESSION_SPEAKER.getText().trim();
        System.out.println("the session speakers is " + speakers);
        VerifyPageReady(20);
        browser.findElement(By.xpath("//i[@ng-click='toggleDrawer(false)']")).isDisplayed();
        browser.findElement(By.xpath("//i[@ng-click='toggleDrawer(false)']")).click();
        VerifyPageReady(2);
        String notes = SESSION_NOTES_TEXTAREA.getAttribute("value").trim();
        String abstractFile = ABSTRACT_FILE_VALUE.getText().trim();
        switchToIframe("Abstract Description");
        String abstractDesc = browser.findElement(By.xpath("//p")).getText().trim();
        browser.switchTo().defaultContent();
        String sessionFile = SESSION_FILE_VALUE.getText().trim();
        switchToIframe("Session Description");
        String sessionDesc = browser.findElement(By.xpath("//p")).getText().trim();
        browser.switchTo().defaultContent();

        addSessionData = new AddSessionData(sessionName, sessiontype, sessionCode, track, tags, sessionLevel, points, durationHrs, durationMins,
                ceuCredit, instances, speakers, notes, abstractDesc, abstractFile, sessionFile, sessionDesc);
        logReport("Actual instance details " + addSessionData);
        return addSessionData;
    }

    public void deleteElements(String elementList) {
        List<WebElement> element = browser.findElements(By.xpath(elementList));
        while (true) {
            element.get(0).click();
            logReport("Element deleted successfully " + element);
            element = null;
            element = browser.findElements(By.xpath(elementList));
            if (element.size() <= 0)
                break;
        }
        logReport("All elements deleted successfully " + elementList);
    }

    public void clearTags() throws Exception {
        String xpath = "//label[@title='Tags']/..//following-sibling::div//div//ul//li[@class='select2-search-choice']/button";
        deleteElements(xpath);
        VerifyPageReady(20);
        browser.findElement(By.xpath("//label[@title='Tags']")).click();
    }

    public void clearJobFunctions() throws Exception {
        String xpath = "//label[@title='Job Functions']/..//following-sibling::div//div//ul//li[@class='select2-search-choice']/button";
        deleteElements(xpath);
        VerifyPageReady(20);
        browser.findElement(By.xpath("//label[@title='Job Functions']")).click();
        VerifyPageReady(10);
    }

    public void clearIndustries() throws Exception {
        String xpath = "//label[@title='Industries']/..//following-sibling::div//div//ul//li[@class='select2-search-choice']/button";
        deleteElements(xpath);
        VerifyPageReady(20);
        browser.findElement(By.xpath("//label[@title='Industries']")).click();
        VerifyPageReady(10);
    }
    public void editSessionFields(AddSessionData addSessionData) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        enterSessionName(addSessionData.getSessionName());
        selectSessionType(addSessionData.getSessionType());
        enterSessionCode(addSessionData.getSessionCode());
        selectSessionTrack(addSessionData.getSessionTrack());
        clearTags();
        selectTagsDropdown(addSessionData.getTags());
        selectSessionLevel(addSessionData.getSessionLevel());
        enterPointsValue(addSessionData.getPoints());
        enterCEUCreditsValue(addSessionData.getCeuCredits());
        enterAbstractDescription(addSessionData.getAbstractDescription());
        enterSessionDescription(addSessionData.getSessionDescription());
        enterNotesValue(addSessionData.getNotes());
        enterSessionLabelValue(addSessionData.getSessionLabel());
        clearIndustries();
        selectIndustriesDropdown(addSessionData.getIndustry());
        clearJobFunctions();
        selectJobFunctionsDropdown(addSessionData.getJobFunction());

    }

    public void fillAddNewStandardSessionDetails(AddSessionData addSessionData) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        enterSessionName(addSessionData.getSessionName());
        selectSessionType(addSessionData.getSessionType());
        enterSessionCode(addSessionData.getSessionCode());
        selectSessionTrack(addSessionData.getSessionTrack());
        selectTagsDropdown(addSessionData.getTags());
        selectSessionLevel(addSessionData.getSessionLevel());
        enterPointsValue(addSessionData.getPoints());
        enterCEUCreditsValue(addSessionData.getCeuCredits());
        enterAbstractDescription(addSessionData.getAbstractDescription());
        enterSessionDescription(addSessionData.getSessionDescription());
        enterNotesValue(addSessionData.getNotes());
        enterSessionLabelValue(addSessionData.getSessionLabel());
        selectJobFunctionsDropdown(addSessionData.getJobFunction());
        selectIndustriesDropdown(addSessionData.getIndustry());
    }

    public void fillSingleInstancesDetails(AddSessionData addSessionInstanceData, AddSpeakerData addSpeakerData, AddLocationData addLocationData) throws Exception {
        String speakerName = addSpeakerData.getFirstName() + " " + addSpeakerData.getLastName();
        String location = addLocationData.getLocationName() + " " + "(" + addLocationData.getCapacity() + ")";
        String startDateAsCurrentDate = getCurrentDate("dd/MM/yyyy"); //MM/dd/yyyy
        String nextDayDateValue = addDaysInDate(startDateAsCurrentDate, 0, "dd/MM/yyyy");
        logReport("Date : " + nextDayDateValue);
        selectDateFromDatePicker(nextDayDateValue);
        selectLocation(location);
        enterInstanceStartTime(addSessionInstanceData.getInstanceStartTime());
        WebElement element = browser.findElement(By.xpath("//input[@ng-model='instance.endTime']"));
        String elementValue = element.getAttribute("value").trim();
        enterInstanceEndTime(addSessionInstanceData.getInstanceEndTime(), elementValue);
        enterCapacityValue(addSessionInstanceData.getCapacity());
        enterWaitListLimitValue(addSessionInstanceData.getWaitListLimit());
        selectOverrideCapacity(addSessionInstanceData.isOverrideCapacity());
        selectInstanceSpeakers(speakerName);

    }

    public void enterInstanceStartTime(String startTime) throws Exception {
        logReport("Start time from sheet is : " + startTime);
        String[] times = startTime.split(":");
        String hours = times[0];
        String minutes = times[1].substring(0, 2);
        String meridian = times[1].substring(2, times[1].length());
        Wait(START_TIME_CLOCK, 10);
        clickByJavaScript(START_TIME_CLOCK);
        // click(START_TIME_CLOCK);
        int hoursVal = Integer.parseInt(hours);
        int min = Integer.parseInt(minutes);
        logReport("Start time meridian from sheet is : " + meridian);
        //String meridian_value = "PM";
        if (hoursVal < 12) {
            int hr = hoursVal;
                for (int i = 0; i < hoursVal; i++) {
                    click(STARTTIME_HOURS_UP_BUTTON);
                }
            } else {
                //int hr = 12 - hoursVal;
                int hr = hoursVal;
                for (int i = 0; i < hr; i++) {
                    click(STARTTIME_HOURS_UP_BUTTON);
                }
            }
        Thread.sleep(1000);
        if (min > 0) {
            for (int i = 0; i < min / 5; i++) {
                click(STARTTIME_MIN_UP_BUTTON);
            }
        }
        Thread.sleep(1000);
        WebElement element = browser.findElement(START_TIME_MERIDIAN_BUTTON);
        if (!element.getText().equalsIgnoreCase(meridian.trim())) {
            element.click();
        }
        logReport("Entered Value: " + startTime + " in 'Start Time' TextBox");

    }

    public void enterInstanceEndTime(String endTime, String startTime) throws Exception {
        //For start Time
        logReport("Start time from sheet is : " + startTime);
        String[] times_startTime = startTime.split(":");
        String hours_startTime = times_startTime[0];
        String minutes_startTime = times_startTime[1].substring(0, 2);
        String meridian_startTime = times_startTime[1].substring(2, times_startTime[1].length());
        int startTime_hoursVal = Integer.parseInt(hours_startTime);
        int startTime_minVal = Integer.parseInt(minutes_startTime);

        //for end time
        logReport("End time from sheet is : " + endTime);
        String[] times = endTime.split(":");
        String hours = times[0];
        String minutes = times[1].substring(0, 2);
        String meridian = times[1].substring(2, times[1].length());
        Wait(END_TIME_CLOCK, 30);
        //click(END_TIME_CLOCK);
        click(END_TIME_CLOCK);
        int hoursVal = Integer.parseInt(hours);
        int minVal = Integer.parseInt(minutes);

        //Select hrs
        if (hoursVal > startTime_hoursVal) {
            int hrs = hoursVal - startTime_hoursVal;
            for (int i = 0; i < hrs; i++) {
                click(ENDTIME_HOURS_UP_BUTTON);
            }
        }
        if (hoursVal < startTime_hoursVal) {
            int hrs = startTime_hoursVal - hoursVal;
            for (int i = 0; i < hrs; i++) {
                click(ENDTIME_HOURS_DOWN_BUTTON);
            }
        }
        //select min
        Thread.sleep(500);
        if (startTime_minVal == 0 && minVal > 0) {
            for (int i = 0; i < minVal / 5; i++) {
                click(ENDTIME_MIN_UP_BUTTON);
            }
        } else if (minVal > startTime_minVal) {
            //int min = (minVal/startTime_minVal) - 1;
            int min = (minVal - startTime_minVal) / 5;
            for (int i = 0; i < min; i++) {
                click(ENDTIME_MIN_UP_BUTTON);
            }
        } else if (minVal < startTime_minVal) {
            //int min = (startTime_minVal/minVal) - 1;
            int min = (startTime_minVal - minVal) / 5;
            for (int i = 0; i < min; i++) {
                click(ENDTIME_MIN_DOWN_BUTTON);
            }
        }

        //select meridian
        Thread.sleep(1000);
        WebElement element = browser.findElement(END_TIME_MERIDIAN_BUTTON);
        //if(meridian_startTime != meridian){
        if (!meridian_startTime.trim().equalsIgnoreCase(meridian.trim())) {
            element.click();
        }
        /*if (!element.getText().equalsIgnoreCase(meridian)) {
            element.click();
        }*/
        Thread.sleep(700);
        WebElement elementEndTine = browser.findElement(By.xpath("//input[@ng-model='instance.endTime']"));
        String elementValue = elementEndTine.getAttribute("value").trim();
        logReport("Entered Value: " + endTime + " in 'End Time' TextBox");
        logReport("Entered Value: " + elementValue + " in 'End Time' TextBox");

       /* if (hoursVal < 12) {
            int hr = 12 - hoursVal;
            for (int i = 0; i < hr; i++) {
                click(ENDTIME_HOURS_DOWN_BUTTON);
            }
        }
        Thread.sleep(1000);
        if (min > 0) {
            for (int i = 0; i < min / 5; i++) {
                click(ENDTIME_MIN_UP_BUTTON);
            }
        }
        Thread.sleep(1000);
        WebElement element = browser.findElement(END_TIME_MERIDIAN_BUTTON);
        if (!element.getText().equalsIgnoreCase(meridian)) {
            element.click();
        }
        logReport("Entered Value: " + endTime + " in 'End Time' TextBox");*/
    }

    public void editStandardSessionFields(AddSessionData addSessionData) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        enterSessionName(addSessionData.getSessionName());
        selectSessionType(addSessionData.getSessionType());
        enterSessionCode(addSessionData.getSessionCode());
        selectSessionTrack(addSessionData.getSessionTrack());
        clearTags();
        selectTagsDropdown(addSessionData.getTags());
        selectSessionLevel(addSessionData.getSessionLevel());
        enterPointsValue(addSessionData.getPoints());
        enterCEUCreditsValue(addSessionData.getCeuCredits());
        enterAbstractDescription(addSessionData.getAbstractDescription());
        enterSessionDescription(addSessionData.getSessionDescription());
        enterNotesValue(addSessionData.getNotes());
        enterSessionLabelValue(addSessionData.getSessionLabel());
        clearJobFunctions();
        selectJobFunctionsDropdown(addSessionData.getJobFunction());
        clearIndustries();
        selectIndustriesDropdown(addSessionData.getIndustry());

    }

    public void editSessionCodeField(AddSessionData addSessionData) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        enterSessionCode(addSessionData.getSessionCode());
    }

    public AddSessionData getSimpleSessionStandardFields() throws Exception {
        AddSessionData addSessionData;
        Wait(SESSION_NAME_TEXTBOX, 30);
        String sessionName = SESSION_NAME_TEXTBOX.getAttribute("value").trim();
        String sessionType = SESSION_TYPE_VALUE.getText().trim();
        String sessionCode = SESSION_CODE_TEXTBOX.getAttribute("value").trim();
        String track = TRACK_VALUE.getText().trim();
        List<String> tagsList = getSelectedOptions(TAGS_DRODPOWN);
        String tags = StringUtils.join(tagsList, ",");
        logReport("Tags values " + tags);

        String sessionLevel = SESSION_LEVEL_VALUE.getText().trim();
        String points = POINTS_TEXTBOX.getAttribute("value").trim();
        String ceuCredit = CEUCREDITS_TEXTBOX.getAttribute("value").trim();
        Wait(INSTANCE_SPEAKERS_BUTTON, 3);
        clickByJavaScript(INSTANCE_SPEAKERS_BUTTON);
        Thread.sleep(3000);
        String instanceSpeakers = INSTANCE_SPEAKER.getText().trim();
        System.out.println("the instance speakers is " + instanceSpeakers);
        VerifyPageReady(20);
        browser.findElement(By.xpath("//i[@ng-click='toggleDrawer(false)']")).isDisplayed();
        browser.findElement(By.xpath("//i[@ng-click='toggleDrawer(false)']")).click();
        VerifyPageReady(2);
        String notes = SESSION_NOTES_TEXTAREA.getAttribute("value").trim();
        switchToIframe("Abstract Description");
        String abstractDesc = browser.findElement(By.xpath("//p")).getText().trim();
        browser.switchTo().defaultContent();
        switchToIframe("Session Description");
        String sessionDesc = browser.findElement(By.xpath("//p")).getText().trim();
        browser.switchTo().defaultContent();
        String sessionLabel = SESSION_LABEL_TEXTBOX.getAttribute("value").trim();
        List<String> jobFunctionList = getSelectedOptions(JOB_FUNCTIONS_DROPDOWN);
        String jobFunction = StringUtils.join(jobFunctionList, ",");
        List<String> industryList = getSelectedOptions(INDUSTRIES_DROPDOWN);
        String industries = StringUtils.join(industryList, ",");

        addSessionData = new AddSessionData(sessionName, sessionType, sessionCode, track, tags, sessionLevel, points,
                ceuCredit, instanceSpeakers, notes, abstractDesc, sessionDesc, sessionLabel, jobFunction, industries);

        logReport("Actual instance details " + addSessionData);
        return addSessionData;
    }

    public void clickReadButton() throws Exception {
        Wait(READ_BUTTON, 20);
        click(READ_BUTTON);
        logReport("Read Button clicked successfully");
    }

    public void clickEditButton() throws Exception {
        Wait(EDIT_BUTTON, 20);
        click(EDIT_BUTTON);
        logReport("Edit Button clicked successfully");
    }

    public String getSelectedValueDropdown(WebElement element) {
        Select select = new Select(element);
        String val = null;
        List<WebElement> e = select.getOptions();
        logReport("-------------" + e.size());
        for (int i = 1; i < e.size(); i++) {
            if (e.get(i) != null) {
                logReport("" + e.get(i).getText());
                try {
                    val = e.get(i).getAttribute("Selected");
                    logReport("----value of attribute---" + val);
                    return val;
                } catch (Exception e1) {
                    break;
                }
            }

        }
        logReport("---------- " + val);
        return val;
    }

    /*public void getSelectedValUsingSelect2(WebElement element) {

        Object script = "return $()";

        logReport("--------"+ executeJavascript(script,element));
        return executeJavascript(script,element);
          Object s = "$($x("//label[text()='Location:']/..//following-sibling::div//select[@x-ng-model='instance.locationId']").select2("data")";
          Object a = executeJavascript(script,element);
         logReport("------" + a);
    }*/


    public List<AddSessionData> getSimpleSessionInstanceDetails() throws Exception {
        AddSessionData addSessionData;
        List<AddSessionData> addSessionDataList = new ArrayList<>();
        Wait(SESSION_START_DATE, 30);

        String startDate = SESSION_START_DATE.getAttribute("value").trim();
        String startTime = SESSION_START_TIME.getAttribute("value").trim();
        String endTime = SESSION_END_TIME.getAttribute("value").trim();
        String capacity = INSTANCE_CAPACITY_TEXTBOX.getAttribute("value").trim();
        String waitListLimit = INSTANCE_WAITLISTEDLIMIT_TEXTBOX.getAttribute("value").trim();
        String overrideCapacity = String.valueOf(OVERRIDE_CAPACITY_CHECKBOX.isSelected());
        clickByJavaScript(INSTANCE_SPEAKERS_BUTTON);
        Thread.sleep(3000);
        String speakers = INSTANCE_SPEAKER.getText().trim();
        System.out.println("the instance speakers is " + speakers);
        VerifyPageReady(20);
        browser.findElement(By.xpath("//i[@ng-click='toggleDrawer(false)']")).isDisplayed();
        browser.findElement(By.xpath("//i[@ng-click='toggleDrawer(false)']")).click();
        VerifyPageReady(2);

        //  addSessionData = new AddSessionData(startTime, Boolean.valueOf(overrideCapacity), capacity, startDate, waitListLimit, endTime, speakers);
        addSessionData = new AddSessionData(speakers, capacity, waitListLimit, Boolean.valueOf(overrideCapacity), startTime, endTime, startDate);
        logReport("Actual instance details " + addSessionData);
        addSessionDataList.add(addSessionData);
        return addSessionDataList;
    }

    public void removeSessionSpeaker(String speakerEmail) throws Exception {
        clickByJavaScript(INSTANCE_SPEAKERS_BUTTON);
        Thread.sleep(3000);
        VerifyPageReady(20);
        String xpath = "//following-sibling::div//p[contains(text(),'" + speakerEmail + "')]/../..//div[contains(@ng-click,'removeAssignedSpeaker($index, $event)')]";
        if (verifyElementDisplayed(By.xpath(xpath), 1)) {
            clickByJavaScript(browser.findElement(By.xpath(xpath)));
            logReport("Speaker : " + speakerEmail + " from session is removed successfully.");
        }
        browser.findElement(By.xpath("//i[@ng-click='toggleDrawer(false)']")).isDisplayed();
        browser.findElement(By.xpath("//i[@ng-click='toggleDrawer(false)']")).click();
        VerifyPageReady(20);
    }

    public void reassignedRemovedSpeaker(AddSpeakerData addSpeakerData) throws Exception {
        String speakerName = addSpeakerData.getFirstName() + " " + addSpeakerData.getLastName();
        selectInstanceSpeakers(speakerName);

    }

    public String getInputCustomFieldValues(String customFieldName) {
        String xpath = "//label[@title='" + customFieldName + "']/..//following-sibling::div/input";
        return browser.findElement(By.xpath(xpath)).getAttribute("value").trim();
    }

    public String getTextAreaCustomFieldValues(String customFieldName) {
        String xpath = "//label[@title='" + customFieldName + "']/..//following-sibling::div/textarea";
        return browser.findElement(By.xpath(xpath)).getAttribute("value").trim();
    }

    public String getSelectTypeCustomFieldValues(String customFieldName) {
        String xpath = "//label[@title='" + customFieldName + "']/..//following::select[@data-placeholder='" + customFieldName + "']";
        WebElement element = browser.findElement(By.xpath(xpath));
        List<String> tagsList = getSelectedOptions(element);
        Collections.sort(tagsList);
        String selectCustomField = StringUtils.join(tagsList, ",");
        logReport("Select custom field values " + selectCustomField);

        return selectCustomField;
    }

    public String getSelectTypeCustomFieldValuesWithDelimiter(String customFieldName) {
        String xpath = "//label[@title='" + customFieldName + "']/..//following::select[@data-placeholder='" + customFieldName + "']";
        WebElement element = browser.findElement(By.xpath(xpath));
        List<String> tagsList = getSelectedOptions(element);
        Collections.sort(tagsList);
        String selectCustomField = StringUtils.join(tagsList, "|");
        logReport("Select custom field values " + selectCustomField);

        return selectCustomField;
    }

    public String getSessionCustomFields(AddCustomFieldsData addCustomFieldsData) {
        if (addCustomFieldsData.getFieldType().equalsIgnoreCase("Text")) {
            return getInputCustomFieldValues(addCustomFieldsData.getFieldName());
        } else if (addCustomFieldsData.getFieldType().equalsIgnoreCase("Textarea")) {
            return getTextAreaCustomFieldValues(addCustomFieldsData.getFieldName());
        } else {
            return getSelectTypeCustomFieldValuesWithDelimiter(addCustomFieldsData.getFieldName());
        }

    }

    public void clickDeleteInstanceIcon() {
        clickByJavaScript(DELETE_INSTANCE_ICON.get(0));
        logReport("Delete instance icon clicked successfully");
    }

    public void deleteInstanceByInstanceName(String instanceName) throws InterruptedException {
        String xpath1 = "//i[@class='fa fa-angle-double-down certain-blue fs30']";
        scrollIntoView(browser.findElement(By.xpath(xpath1)));
        WebElement element1 = browser.findElement(By.xpath(xpath1));
        Thread.sleep(2000);
        String xpath = "//h4[contains(text(),('" + instanceName + "'))]/..//i";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        logReport("Delete instance icon clicked successfully");
    }

    public List<String> getSessionDocuments() {
        List<String> a = new ArrayList<>();
        for (WebElement e : SESSION_DOC_NAMES) {
            a.add(e.getText().trim());
        }
        return a;
    }

    public String getButtonStatusText() {
        // logReport(""+SESSION_STATUS_BUTTON.getText().trim().split(":")[1]);
        return SESSION_STATUS_BUTTON.getText().trim().split(":")[1].trim();
    }

    public List<String> getListOfSessionStatuses() throws Exception {
        List<String> a = new ArrayList<>();
        for (WebElement e : SESSION_STATUS_LIST) {
            a.add(e.getText().trim());
        }
        return a;
    }

    public void clickStatusButton() throws Exception {
        Wait(SESSION_STATUS_BUTTON, 10);
        clickByJavaScript(SESSION_STATUS_BUTTON);
        logReport("Session status button clicked successfully");
    }


    public void selectStatus(String status) {
        List<String> a = new ArrayList<>();
        for (WebElement e : SESSION_STATUS_LIST) {
            if (e.getText().trim().equalsIgnoreCase(status)) {
                clickByJavaScript(e);
                logReport("Selected status value " + status);
                break;
            }
        }
    }
    public void publishForAllAttendeeTypes() throws Exception {
        Wait(PUBLISH_ATTENDEETYPE_ICON, 10);
        clickByJavaScript(PUBLISH_ATTENDEETYPE_ICON);
        logReport("Publish button clicked successfully");
        checkByJavascript(SELECTALL_CHK_PUBLISH);
        logReport("Select all chk clicked successfully");
        clickByJavaScript(PUBLISH_ATTENDEETYPES_BTN);
        logReport("Publish attndeetypes btn clicked successfully");

    }

    public void publishForSelectedAttendeeTypes(String attendeeTypes) throws Exception {
        Wait(PUBLISH_ATTENDEETYPE_ICON, 10);
        clickByJavaScript(PUBLISH_ATTENDEETYPE_ICON);
        uncheckByJavascript(SELECTALL_CHK_PUBLISH);
        logReport("Publish button clicked successfully");
        String types[] = attendeeTypes.split(",");
        for (int i = 0; i < types.length; i++) {
            String xpath = "//input[@ng-model='attendeeTypesModel'][@name='" + types[i] + "']";
            WebElement element = browser.findElement(By.xpath(xpath));
            checkByJavascript(element);
            logReport("Select attendee type chk clicked successfully" + types[i]);
        }

        click(PUBLISH_ATTENDEETYPES_BTN);
        logReport("Publish attndeetypes btn clicked successfully");

    }

    public List<String> getSelectedAttendeeTypes() throws Exception {
        List<String> selectedAttendees = new ArrayList<>();
        String xpath = "//input[@ng-model='attendeeTypesModel']";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        for (WebElement e : elements) {
            if (e.isSelected()) {
                selectedAttendees.add(e.getAttribute("name").trim());
            }
        }
        return selectedAttendees;
    }

    public void clearLocationDropdown() {
        LOCATION_CLOSE_ICON.click();
        logReport("Location dropdown clear successfully");
    }

    public String getInstanceCode() {
        return INSTANCE_CODE_LABEL.getText().trim();
    }

    public List<String> getMasterSpeakersList() {
        clickByJavaScript(SPEAKERS_LINK);
        switchToLatestTabOrWindow();
        logReport("Speakers link clicked and drawer opened");
        List<String> masterSpeakers = new ArrayList<>();
        for (WebElement e : MASTER_SPEAKER_LIST) {
            masterSpeakers.add(e.getText().trim());
        }
        click(CLOSE_SPEAKER_DRAWER);
        return masterSpeakers;
    }

    public List<String> getInstanceSpeakersList() throws InterruptedException {
        scrollIntoView(INSTANCESPEAKERS_LINK);
        Thread.sleep(2000);
        click(INSTANCESPEAKERS_LINK);
        switchToLatestTabOrWindow();
        logReport("Instance speakers link clicked and drawer opened");
        List<String> masterSpeakers = new ArrayList<>();
        for (WebElement e : LIST_INSTANCE_SPEAKER) {
            masterSpeakers.add(e.getText().trim());
        }
        click(CLOSE_SPEAKER_DRAWER);
        return masterSpeakers;
    }

    public List<String> getInstanceSpeakersListByInstanceNo(String instanceName) throws InterruptedException {
        String insXpath = "//h4[@class='ttu certain-blue ng-binding'][contains(text(),'" + instanceName + "')]//a";
        WebElement element = browser.findElement(By.xpath(insXpath));
        scrollIntoView(element);
        Thread.sleep(2000);
        click(element);
        switchToLatestTabOrWindow();
        logReport("Instance speakers link clicked and drawer opened");
        List<String> masterSpeakers = new ArrayList<>();
        for (WebElement e : LIST_INSTANCE_SPEAKER) {
            masterSpeakers.add(e.getText().trim());
        }
        click(CLOSE_SPEAKER_DRAWER);
        return masterSpeakers;
    }

    public void clickSpeakersIconByInstanceNo(String instanceName) throws Exception {
        String insXpath = "//h4[@class='ttu certain-blue ng-binding'][contains(text(),'" + instanceName + "')]//a";
        WebElement element = browser.findElement(By.xpath(insXpath));
        click(element);

    }

    public void scrollToSession1Instance() throws Exception {

        scrollIntoView(EXPANDED_INSTANCE_ARROW);
        clickByJavaScript(EXPANDED_INSTANCE_ARROW);
        Thread.sleep(2000);
        scrollIntoView(INSTANCES_LABEL);
        Thread.sleep(2000);
        clickByJavaScript(INSTANCE_SPEAKERS_BUTTON);
    }

    public void deleteAllInstanceSpeakers() throws Exception {
        for (WebElement e : LIST_INSTANCE_SPEAKER_DELETE) {
            clickByJavaScript(e);
            logReport("Speaker removed successfully");
            Thread.sleep(1000);

        }
        browser.findElement(By.xpath("//button[@ng-click='toggleDrawer(false)']")).isDisplayed();
        Thread.sleep(3000);
        browser.findElement(By.xpath("//button[@ng-click='toggleDrawer(false)']")).click();
        VerifyPageReady(20);

    }


    public AddSessionData getSessionStandardFieldsForExport() throws Exception {
        AddSessionData addSessionData;
        Wait(SESSION_NAME_TEXTBOX, 30);
        String sessionName = SESSION_NAME_TEXTBOX.getAttribute("value").trim();
        String sessionType = SESSION_TYPE_VALUE.getText().trim();
        String sessionCode = SESSION_CODE_TEXTBOX.getAttribute("value").trim();
        String track = TRACK_VALUE.getText().trim();
        List<String> tagsList = getSelectedOptions(TAGS_DRODPOWN);
        Collections.sort(tagsList);
        String tags = StringUtils.join(tagsList, "|");
        logReport("Tags values " + tags);

        String sessionLevel = SESSION_LEVEL_VALUE.getText().trim();
        String points = POINTS_TEXTBOX.getAttribute("value").trim();
        String startDate = SESSION_START_DATE.getAttribute("value").trim();
        String location = getSelectedOption(LOCATION_DROPDOWN).split(" ")[0];
        String capacity = INSTANCE_CAPACITY_TEXTBOX.getAttribute("value").trim();
        String waitListLimit = INSTANCE_WAITLISTEDLIMIT_TEXTBOX.getAttribute("value").trim();
        String overrideCapacity = String.valueOf(OVERRIDE_CAPACITY_CHECKBOX.isSelected());

        String startTime = SESSION_START_TIME.getAttribute("value").trim();
        String endTime = SESSION_END_TIME.getAttribute("value").trim();

        String endDate = startDate + " " + endTime;
        startDate = startDate + " " + startTime;

        String ceuCredit = CEUCREDITS_TEXTBOX.getAttribute("value").trim();
        ceuCredit = ceuCredit + ".0";
        String speakers = INSTANCE_SPEAKER.getText().trim();
        String notes = SESSION_NOTES_TEXTAREA.getAttribute("value").trim();
        switchToIframe("Abstract Description");
        String abstractDesc = browser.findElement(By.xpath("//p")).getText().trim();
        browser.switchTo().defaultContent();
        switchToIframe("Session Description");
        String sessionDesc = browser.findElement(By.xpath("//p")).getText().trim();
        browser.switchTo().defaultContent();
        String sessionLabel = SESSION_LABEL_TEXTBOX.getAttribute("value").trim();
        List<String> jobFunctionList = getSelectedOptions(JOB_FUNCTIONS_DROPDOWN);
        Collections.sort(jobFunctionList);
        String jobFunction = StringUtils.join(jobFunctionList, "|");
        List<String> industryList = getSelectedOptions(INDUSTRIES_DROPDOWN);
        Collections.sort(industryList);
        String industries = StringUtils.join(industryList, "|");
        clickByJavaScript(INSTANCE_DETAILS_CLOSE_BUTTON);
        String xpath = "//tbody[@ng-repeat='instance in session.confSessionInstance']//div[contains(text(),'" + sessionName + "')]";
        WebElement element = browser.findElement(By.xpath(xpath));
        String instanceCode = element.getText().trim();

        addSessionData = new AddSessionData(sessionName, sessionCode, sessionType, points, instanceCode, startDate, endDate, location, location, capacity, waitListLimit, overrideCapacity, speakers, abstractDesc, notes, sessionDesc, ceuCredit, sessionLabel, sessionLevel,
                track, jobFunction, industries, tags);
        logReport("Actual Simple Session Standard fields details " + addSessionData);
        return addSessionData;

    }

    public boolean isEmptyStandardFields() throws Exception {
        Wait(SESSION_NAME_TEXTBOX, 30);
        String track = TRACK_VALUE.getText().trim();
        boolean flag = false;
        List<String> tagsList = getSelectedOptions(TAGS_DRODPOWN);
        Collections.sort(tagsList);
        String tags = StringUtils.join(tagsList, "|");
        logReport("Tags values " + tags);
        String sessionLevel = SESSION_LEVEL_VALUE.getText().trim();
        String points = POINTS_TEXTBOX.getAttribute("value").trim();
        String durationHrs = "1";
        String durationMins = "0";
        if (verifyElementDisplayed(DURATION_HRS_DRODPOWN, 0)) {
            durationHrs = getSelectedOption(DURATION_HRS_DRODPOWN);
        }
        if (verifyElementDisplayed(DURATION_MINS_DRODPOWN, 0)) {
            durationMins = getSelectedOption(DURATION_MINS_DRODPOWN);
        }

        String ceuCredit = CEUCREDITS_TEXTBOX.getAttribute("value").trim();
        String notes = SESSION_NOTES_TEXTAREA.getAttribute("value").trim();
        switchToIframe("Abstract Description");
        String abstractDesc = browser.findElement(By.xpath("//p")).getText().trim();
        browser.switchTo().defaultContent();
        switchToIframe("Session Description");
        String sessionDesc = browser.findElement(By.xpath("//p")).getText().trim();
        browser.switchTo().defaultContent();
        String sessionLabel = SESSION_LABEL_TEXTBOX.getAttribute("value").trim();
        List<String> jobFunctionList = getSelectedOptions(JOB_FUNCTIONS_DROPDOWN);
        Collections.sort(jobFunctionList);
        String jobFunction = StringUtils.join(jobFunctionList, "|");
        List<String> industryList = getSelectedOptions(INDUSTRIES_DROPDOWN);
        Collections.sort(industryList);
        String industries = StringUtils.join(industryList, "|");
        logReport("----Value of fields " + track + tags + sessionLevel + points + durationHrs + durationMins + ceuCredit + notes + abstractDesc + sessionDesc +
                sessionLabel + jobFunction + industries);
        if (track.equalsIgnoreCase("Select Session Track") && tags.isEmpty() && sessionLevel.equalsIgnoreCase("Select Session Level") && points.isEmpty() && durationHrs.equalsIgnoreCase("1") && durationMins.equalsIgnoreCase("0")
                && ceuCredit.isEmpty() && notes.isEmpty() && abstractDesc.isEmpty() && sessionDesc.isEmpty() && sessionLabel.isEmpty() && jobFunction.isEmpty() && industries.isEmpty()) {
            return true;
        } else return false;
    }

    public AddSessionData getConferenceSessionStandardFieldsForExport() throws Exception {
        AddSessionData addSessionData;
        Wait(SESSION_NAME_TEXTBOX, 30);
        String layoutType = SESSION_NAME_TEXTBOX.getAttribute("value").trim();
        String sessionName = SESSION_NAME_TEXTBOX.getAttribute("value").trim();
        String sessionType = SESSION_TYPE_VALUE.getText().trim();
        String sessionCode = SESSION_CODE_TEXTBOX.getAttribute("value").trim();
        String track = TRACK_VALUE.getText().trim();
        List<String> tagsList = getSelectedOptions(TAGS_DRODPOWN);
        Collections.sort(tagsList);
        String tags = StringUtils.join(tagsList, "|");
        logReport("Tags values " + tags);
        String sessionLevel = SESSION_LEVEL_VALUE.getText().trim();
        String points = POINTS_TEXTBOX.getAttribute("value").trim();
        String ceuCredit = CEUCREDITS_TEXTBOX.getAttribute("value").trim();
        ceuCredit = ceuCredit + ".0";
        String noOfInstances = INSTANCES_TEXTBOX.getAttribute("value").trim();
        String notes = SESSION_NOTES_TEXTAREA.getAttribute("value").trim();
        switchToIframe("Abstract Description");
        String abstractDesc = browser.findElement(By.xpath("//p")).getText().trim();
        browser.switchTo().defaultContent();
        switchToIframe("Session Description");
        String sessionDesc = browser.findElement(By.xpath("//p")).getText().trim();
        browser.switchTo().defaultContent();
        String sessionLabel = SESSION_LABEL_TEXTBOX.getAttribute("value").trim();
        List<String> jobFunctionList = getSelectedOptions(JOB_FUNCTIONS_DROPDOWN);
        Collections.sort(jobFunctionList);
        String jobFunction = StringUtils.join(jobFunctionList, "|");
        List<String> industryList = getSelectedOptions(INDUSTRIES_DROPDOWN);
        Collections.sort(industryList);
        String industries = StringUtils.join(industryList, "|");
        String totalDuration = "60";
        List<WebElement> speakersList = browser.findElements(By.xpath("//div[@ng-repeat='sessionSpeaker in sessionSpeakers']//strong"));
        StringBuilder speakers = new StringBuilder();
        for (WebElement e : speakersList) {
            speakers.append(e.getText().trim());
            speakers.append("|");
        }
        speakers.setLength(speakers.length() - 1);

        addSessionData = new AddSessionData(layoutType, sessionName, sessionCode, sessionType, track, tags, sessionLevel, points, totalDuration, ceuCredit, noOfInstances, speakers.toString(), abstractDesc, sessionDesc, notes, industries, sessionLabel, jobFunction);

        logReport("Actual Conference session Standard fields details " + addSessionData);
        return addSessionData;

    }

    public AddSessionData getConferenceSessionStandardFieldsForExportWithInstances() throws Exception {
        AddSessionData addSessionData;
        Wait(SESSION_NAME_TEXTBOX, 30);
        String sessionName = SESSION_NAME_TEXTBOX.getAttribute("value").trim();
        String sessionType = SESSION_TYPE_VALUE.getText().trim();
        String sessionCode = SESSION_CODE_TEXTBOX.getAttribute("value").trim();
        String track = TRACK_VALUE.getText().trim();
        List<String> tagsList = getSelectedOptions(TAGS_DRODPOWN);
        Collections.sort(tagsList);
        String tags = StringUtils.join(tagsList, "|");
        logReport("Tags values " + tags);
        String sessionLevel = SESSION_LEVEL_VALUE.getText().trim();
        String points = POINTS_TEXTBOX.getAttribute("value").trim();
        String ceuCredit = CEUCREDITS_TEXTBOX.getAttribute("value").trim();
        ceuCredit = ceuCredit + ".0";

        String notes = SESSION_NOTES_TEXTAREA.getAttribute("value").trim();
        switchToIframe("Abstract Description");
        String abstractDesc = browser.findElement(By.xpath("//p")).getText().trim();
        browser.switchTo().defaultContent();
        switchToIframe("Session Description");
        String sessionDesc = browser.findElement(By.xpath("//p")).getText().trim();
        browser.switchTo().defaultContent();
        String sessionLabel = SESSION_LABEL_TEXTBOX.getAttribute("value").trim();
        List<String> jobFunctionList = getSelectedOptions(JOB_FUNCTIONS_DROPDOWN);
        Collections.sort(jobFunctionList);
        String jobFunction = StringUtils.join(jobFunctionList, "|");
        List<String> industryList = getSelectedOptions(INDUSTRIES_DROPDOWN);
        Collections.sort(industryList);
        String industries = StringUtils.join(industryList, "|");
        String totalDuration = "60";
        List<WebElement> speakersList = browser.findElements(By.xpath("//div[@ng-repeat='sessionSpeaker in sessionSpeakers']//strong"));
        StringBuilder speakers = new StringBuilder();
        for (WebElement e : speakersList) {
            speakers.append(e.getText().trim());
            speakers.append("|");
        }
        speakers.setLength(speakers.length() - 1);

     /*   List<WebElement> instanceSpeakersList = browser.findElements(By.xpath("//div[@ng-repeat='sessionSpeaker in instance.confSpeaker']//strong"));
        StringBuilder instanceSpeakers = new StringBuilder();
        for (WebElement e : instanceSpeakersList) {
            instanceSpeakers.append(e.getText().trim());
            instanceSpeakers.append("|");
        }
        instanceSpeakers.setLength(instanceSpeakers.length() - 1);*/

        addSessionData = new AddSessionData(sessionName, sessionCode, sessionType, track, tags, sessionLevel, points, totalDuration, ceuCredit, speakers.toString(), abstractDesc, sessionDesc, notes, industries, sessionLabel, jobFunction);

        logReport("Actual Conference session standard fields for export with instances details " + addSessionData);
        return addSessionData;

    }

    public AddSessionData getConferenceSessionInstanceFieldsForExportWithInstances(String instanceCode) throws Exception {
        String startDate = "", endDate = "", location = "", capacity = "", waitListLimit = "", overrideCapacity = "";
        StringBuilder instanceSpeakers = new StringBuilder();
        AddSessionData addSessionData = new AddSessionData(instanceCode, startDate, endDate, location, location, capacity, waitListLimit, overrideCapacity, instanceSpeakers.toString());

        String xpath = "//tbody[@ng-repeat='instance in session.confSessionInstance']//div[contains(text(),'" + instanceCode + "')]";
        if (verifyElementDisplayed(By.xpath(xpath), 2)) {
            WebElement element = browser.findElement(By.xpath(xpath));
            clickByJavaScript(element);
            Thread.sleep(500);

            startDate = SESSION_START_DATE.getAttribute("value").trim();
            location = getSelectedOption(LOCATION_DROPDOWN).split(" ")[0];
            capacity = INSTANCE_CAPACITY_TEXTBOX.getAttribute("value").trim();
            waitListLimit = INSTANCE_WAITLISTEDLIMIT_TEXTBOX.getAttribute("value").trim();
            overrideCapacity = String.valueOf(OVERRIDE_CAPACITY_CHECKBOX.isSelected());

            String startTime = SESSION_START_TIME.getAttribute("value").trim();
            String endTime = SESSION_END_TIME.getAttribute("value").trim();
            // endTime = "0" + endTime;
            endDate = startDate + " " + endTime;
            startDate = startDate + " " + startTime;

            List<WebElement> instanceSpeakersList = browser.findElements(By.xpath("//div[@ng-repeat='sessionSpeaker in instance.confSpeaker']//strong"));
            // instanceSpeakers = new StringBuilder();
            for (WebElement e : instanceSpeakersList) {
                instanceSpeakers.append(e.getText().trim());
                instanceSpeakers.append("|");
            }
            instanceSpeakers.setLength(instanceSpeakers.length() - 1);

            addSessionData = new AddSessionData(instanceCode, startDate, endDate, location, location, capacity, waitListLimit, overrideCapacity, instanceSpeakers.toString());
            logReport("Actual Conference session Instance fields details " + addSessionData);

        } else {
            logReport("No instance found for :" + instanceCode);
        }

        // addSessionData = new AddSessionData(instanceCode, startDate, endDate, location , location, capacity, waitListLimit , overrideCapacity, instanceSpeakers.toString() );


        return addSessionData;
    }


    public List<String> getInstanceCodeList() {
        List<String> instanceCodes = new ArrayList<>();
        for (WebElement e : INSTANCE_CODE_LABEL_LIST) {
            instanceCodes.add(e.getText().trim());
        }
        return instanceCodes;
    }

    public AddSessionData getSessionInstanceDetailsForImport(List<HashMap<String, String>> sessionInstance, String duration, int rowNo) throws Exception {
        AddSessionData addSessionData;
        String startDate = sessionInstance.get(rowNo).get("Start Date").split(" ")[0].trim();
        String startTime = sessionInstance.get(rowNo).get("Start Date").substring(sessionInstance.get(rowNo).get("Start Date").indexOf(" ") + 1);
        if (startTime.startsWith("0")) {
            startTime = startTime.substring(1);
        }
        String endTime = getInstanceEndTime(startTime, duration);
        String location = sessionInstance.get(rowNo).get("Location Code").trim();
        String capacity = sessionInstance.get(rowNo).get("Capacity").trim();
        String waitListLimit = sessionInstance.get(rowNo).get("Waitlist Limit").trim();
        String overrideCapacity = null;
        try {
            overrideCapacity = sessionInstance.get(rowNo).get("Override Capacity").trim();
            if (!Boolean.valueOf(overrideCapacity)) {
                overrideCapacity = "false";
            }
        } catch (Exception e) {
            overrideCapacity = "false";
        }
        String instanceCode = sessionInstance.get(rowNo).get("Instance Code").trim();
        String speakers = sessionInstance.get(rowNo).get("Speakers").trim();
        String[] speakersData = speakers.split("\\|");
        List<String> a = new ArrayList<>();
        for (String s : speakersData) {
            a.add(s);
        }
        Collections.sort(a);
        StringBuilder instanceSpeakers = new StringBuilder();
        for (String b : a) {
            instanceSpeakers.append(b);
            instanceSpeakers.append("|");
        }
        instanceSpeakers.setLength(instanceSpeakers.length() - 1);

        addSessionData = new AddSessionData(startTime, Boolean.valueOf(overrideCapacity), capacity, startDate, location, waitListLimit, endTime, instanceSpeakers.toString(), instanceCode);
        logReport("Expected instance details " + addSessionData);
        return addSessionData;
    }

    public AddSessionData getSessionInstanceDetailsForImportStandardSession(List<HashMap<String, String>> sessionInstance) throws Exception {
        AddSessionData addSessionData;
        String startDate = sessionInstance.get(0).get("Start Date").split(" ")[0].trim();
        String startTime = sessionInstance.get(0).get("Start Date").substring(sessionInstance.get(0).get("Start Date").indexOf(" ") + 1);
        if (startTime.startsWith("0")) {
            startTime = startTime.substring(1);
        }
        String endTime = sessionInstance.get(0).get("End Date").substring(sessionInstance.get(0).get("End Date").indexOf(" ") + 1);
        if (endTime.startsWith("0")) {
            endTime = endTime.substring(1);
        }
       // String location = sessionInstance.get(0).get("Location Code").trim();
        String capacity = sessionInstance.get(0).get("Capacity").trim();
        String waitListLimit = sessionInstance.get(0).get("Waitlist Limit").trim();
        String overrideCapacity = null;
        try {
            overrideCapacity = sessionInstance.get(0).get("Override Capacity").trim();
            if (!Boolean.valueOf(overrideCapacity)) {
                overrideCapacity = "false";
            }
        } catch (Exception e) {
            overrideCapacity = "false";
        }
        String speakers = sessionInstance.get(0).get("Speakers").trim();
        String[] speakersData = speakers.split("\\|");
        List<String> a = new ArrayList<>();
        for (String s : speakersData) {
            a.add(s);
        }
        Collections.sort(a);
        StringBuilder instanceSpeakers = new StringBuilder();
        for (String b : a) {
            instanceSpeakers.append(b);
            instanceSpeakers.append("|");
        }
        instanceSpeakers.setLength(instanceSpeakers.length() - 1);

        addSessionData = new AddSessionData(startTime, Boolean.valueOf(overrideCapacity), capacity, startDate, waitListLimit, endTime, instanceSpeakers.toString());
        logReport("Expected instance details " + addSessionData);
        return addSessionData;
    }

    public boolean isLocationEmpty(String instanceCode) throws Exception {
        String xpath = "//tbody[@ng-repeat='instance in session.confSessionInstance']//div[contains(text(),'" + instanceCode + "')]";
        if (verifyElementDisplayed(By.xpath(xpath), 2)) {
            WebElement element = browser.findElement(By.xpath(xpath));
            clickByJavaScript(element);

        }
        return getSelectedOption(LOCATION_DROPDOWN).isEmpty() || getSelectedOption(LOCATION_DROPDOWN).equalsIgnoreCase(null);
    }

    public boolean isSessionCodeAutoGenerated() {
        String text = SESSION_CODE_TEXTBOX.getAttribute("value").trim();
        logReport("--------------" + text);
        try {
            Double.parseDouble(text);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<String> getSessionDetailsForSP() throws Exception {
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

        logReport("------------------Values of speaker portal side list is " + sessionDetails);
        return sessionDetails;
    }

    public String getStartTime() {
        String timeV = START_END_TIME.getText().trim();
        String timeV1 = timeV.substring(timeV.lastIndexOf(", ") + 2, timeV.lastIndexOf(", ") + 7);
        return timeV1;
    }

    public String getEndTime() {
        String timeV = START_END_TIME.getText().trim();
        String timeV1 = timeV.substring(timeV.lastIndexOf("- ") + 2, timeV.lastIndexOf("- ") + 7);
        return timeV1;
    }

    public boolean isMasterSpeakersFound(String speakerName) {
        if (MASTER_SPEAKER_LIST.size() > 0) {
            for (WebElement e : MASTER_SPEAKER_LIST) {
                if (e.getText().trim().equalsIgnoreCase(speakerName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void enterTaskAndSave(String task) throws Exception {
        Wait(SESSION_TASKS_BUTTON, 20);
        click(SESSION_TASKS_BUTTON);
        logReport("Session task button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        type(SESSION_TASK_TEXTBOX, task, true);
        logReport("Entered session task value " + task);
        click(ADD_NEW_TASK_BUTTON);
        logReport("Add new task button clicked successfully");
        VerifyAngularHasFinishedProcessing(30);

    }

    public void fillInstanceDetailsSingle1(AddSessionData addSessionInstanceData, AddSpeakerData addSpeakerData, AddLocationData addLocationData) throws Exception {
        String speakerName = addSpeakerData.getFirstName() + " " + addSpeakerData.getLastName();
        String location = addLocationData.getLocationName() + " " + "(" + addLocationData.getCapacity() + ")";
        String startDateAsCurrentDate = getCurrentDate("dd/MM/yyyy"); //MM/dd/yyyy
        String nextDayDateValue = addDaysInDate(startDateAsCurrentDate, 0, "dd/MM/yyyy");
        selectDateFromDatePicker(nextDayDateValue);
        enterInstanceStartTime(addSessionInstanceData.getInstanceStartTime());
        selectLocation(location);
        enterCapacityValue(addSessionInstanceData.getCapacity());
        enterWaitListLimitValue(addSessionInstanceData.getWaitListLimit());
        selectOverrideCapacity(addSessionInstanceData.isOverrideCapacity());
        selectInstanceSpeakers1(speakerName);

    }

    public void fillInstanceDetailsTest(AddSessionData addSessionInstanceData, AddLocationData addLocationData) throws Exception {
        String location = addLocationData.getLocationName() + " " + "(" + addLocationData.getCapacity() + ")";
        String startDateAsCurrentDate = getCurrentDate("dd/MM/yyyy"); //MM/dd/yyyy
        String nextDayDateValue = addDaysInDate(startDateAsCurrentDate, 0, "dd/MM/yyyy");
        selectDateFromDatePicker(nextDayDateValue);
        enterInstanceStartTime(addSessionInstanceData.getInstanceStartTime());
        selectLocation(location);
        enterCapacityValue(addSessionInstanceData.getCapacity());
        enterWaitListLimitValue(addSessionInstanceData.getWaitListLimit());
        selectOverrideCapacity(addSessionInstanceData.isOverrideCapacity());


    }

    public void selectInstanceSpeakers1(String speakers) throws Exception {
        Wait(INSTANCE_SPEAKERS_BUTTON1, 3);
        clickByJavaScript(INSTANCE_SPEAKERS_BUTTON1);
        logReport("Instance Speaker button clicked successfully");
        VerifyPageReady(20);

        clickByJavaScript(INSTANCE_SPEAKERS_LABEL_BUTTON);
        Wait(INSTANCE_SPEAKERS_TEXTBOX, 5);
        type(INSTANCE_SPEAKERS_TEXTBOX, speakers);

        for (WebElement e : INSTANCE_SPEAKERS_SELECT) {
            if (e.getText().equalsIgnoreCase(speakers)) {
                e.click();
                browser.findElement(By.xpath("//i[@ng-click='toggleDrawer(false)']")).isDisplayed();
                Thread.sleep(2000);
                browser.findElement(By.xpath("//i[@ng-click='toggleDrawer(false)']")).click();
                VerifyPageReady(20);
                return;
            }
        }

    }

    public void selectSpeakerAndError(String speakers) throws Exception {
        Wait(INSTANCE_SPEAKERS_BUTTON1, 3);
        clickByJavaScript(INSTANCE_SPEAKERS_BUTTON1);
        logReport("Instance Speaker button clicked successfully");
        VerifyPageReady(20);

        clickByJavaScript(INSTANCE_SPEAKERS_LABEL_BUTTON);
        Wait(INSTANCE_SPEAKERS_TEXTBOX, 5);
        type(INSTANCE_SPEAKERS_TEXTBOX, speakers);

        for (WebElement e : INSTANCE_SPEAKERS_SELECT) {
            if (e.getText().equalsIgnoreCase(speakers)) {
                e.click();

            }
        }
    }

    public void fillInstanceDetailsSingle2(AddSessionData addSessionInstanceData, AddSpeakerData addSpeakerData, AddLocationData addLocationData) throws Exception {
        String speakerName = addSpeakerData.getFirstName() + " " + addSpeakerData.getLastName();
        String location = addLocationData.getLocationName() + " " + "(" + addLocationData.getCapacity() + ")";
        String startDateAsCurrentDate = getCurrentDate("dd/MM/yyyy"); //MM/dd/yyyy
        String nextDayDateValue = addDaysInDate(startDateAsCurrentDate, 0, "dd/MM/yyyy");
        selectDateFromDatePicker(nextDayDateValue);
        enterInstanceStartTime(addSessionInstanceData.getInstanceStartTime());
        selectLocation(location);
        enterCapacityValue(addSessionInstanceData.getCapacity());
        enterWaitListLimitValue(addSessionInstanceData.getWaitListLimit());
        selectOverrideCapacity(addSessionInstanceData.isOverrideCapacity());
        selectInstanceSpeakers2(speakerName);

    }


    public void selectInstanceSpeakersMultiple(String speakers, int sessionInstance) throws Exception {
        Wait(INSTANCE_SPEAKERS_BUTTON, 3);
        int sessionInstance1 = sessionInstance + 1;
        String xpath = "//h4[contains(text(),'Session Instance " + sessionInstance1 + "')]//a[@class='certain-blue speaker-ttl'][contains(text(),'speakers')]";
        WebElement element22 = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element22);
        logReport("Instance Speaker button clicked successfully");
        VerifyPageReady(20);

        clickByJavaScript(INSTANCE_SPEAKERS_LABEL_BUTTON);
        Wait(INSTANCE_SPEAKERS_TEXTBOX, 5);
        type(INSTANCE_SPEAKERS_TEXTBOX, speakers);

        for (WebElement e : INSTANCE_SPEAKERS_SELECT) {
            if (e.getText().equalsIgnoreCase(speakers)) {
                e.click();
                browser.findElement(By.xpath("//i[@ng-click='toggleDrawer(false)']")).isDisplayed();
                Thread.sleep(2000);
                browser.findElement(By.xpath("//i[@ng-click='toggleDrawer(false)']")).click();
                VerifyPageReady(20);
                return;
            }
        }
    }

    public void selectInstanceSpeakers2(String speakers) throws Exception {
        Wait(INSTANCE_SPEAKERS_BUTTON2, 3);
        clickByJavaScript(INSTANCE_SPEAKERS_BUTTON2);
        logReport("Instance Speaker button clicked successfully");
        VerifyPageReady(20);

        clickByJavaScript(INSTANCE_SPEAKERS_LABEL_BUTTON);
        Wait(INSTANCE_SPEAKERS_TEXTBOX, 5);
        type(INSTANCE_SPEAKERS_TEXTBOX, speakers);

        for (WebElement e : INSTANCE_SPEAKERS_SELECT) {
            if (e.getText().equalsIgnoreCase(speakers)) {
                e.click();
                browser.findElement(By.xpath("//button[@ng-click='toggleDrawer(false)']")).isDisplayed();
                Thread.sleep(3000);
                browser.findElement(By.xpath("//button[@ng-click='toggleDrawer(false)']")).click();
                VerifyPageReady(20);
                return;
            }
        }

    }

    public void selectInstanceSpeakersDefault(String speakers) throws Exception {
        // Wait(INSTANCE_SPEAKERS_BUTTON_DEFAULT, 3);
        clickByJavaScript(INSTANCE_SPEAKERS_BUTTON_DEFAULT);
        logReport("Instance Speaker button clicked successfully");
        VerifyPageReady(20);

        clickByJavaScript(INSTANCE_SPEAKERS_LABEL_BUTTON);
        Wait(INSTANCE_SPEAKERS_TEXTBOX, 5);
        type(INSTANCE_SPEAKERS_TEXTBOX, speakers);

        for (WebElement e : INSTANCE_SPEAKERS_SELECT) {
            if (e.getText().equalsIgnoreCase(speakers)) {
                e.click();
                browser.findElement(By.xpath("//button[@ng-click='toggleDrawer(false)']")).isDisplayed();
                Thread.sleep(3000);
                browser.findElement(By.xpath("//button[@ng-click='toggleDrawer(false)']")).click();
                VerifyPageReady(20);
                return;
            }
        }

    }

    public List<String> getInstanceSpeakersListfromUnscheduled() throws InterruptedException {
        scrollIntoView(INSTANCE_SPEAKERS_BUTTON1);
        Thread.sleep(2000);
        click(INSTANCE_SPEAKERS_BUTTON1);
        switchToLatestTabOrWindow();
        logReport("Instance speakers link clicked and drawer opened");
        List<String> masterSpeakers = new ArrayList<>();
        for (WebElement e : LIST_INSTANCE_SPEAKER) {
            masterSpeakers.add(e.getText().trim());
        }
        click(CLOSE_SPEAKER_DRAWER);
        return masterSpeakers;
    }

    public String getHoursDropdownOptionsList() {
        String xpath = "//label[text()='Duration']/..//following-sibling::div//select[@x-ng-model='session.durationHours']//option";
        List<WebElement> options = browser.findElements(By.xpath(xpath));
        String value = "";

        for (int i = 1; i < options.size(); i++) {
            value = value + options.get(i).getAttribute("value");
            options = browser.findElements(By.xpath(xpath));
        }
        logReport("---value of hours dropdown " + value);
        return value;
    }

    public String getMinuteDropdownOptionsList() {
        String xpath = "//label[text()='Duration']/..//following-sibling::div//select[@x-ng-model='session.durationMins']//option";
        List<WebElement> options = browser.findElements(By.xpath(xpath));
        String value = "";

        for (int i = 1; i < options.size(); i++) {
            value = value + options.get(i).getAttribute("value");
            options = browser.findElements(By.xpath(xpath));
        }
        logReport("---value of hours dropdown " + value);
        return value;
    }


}


