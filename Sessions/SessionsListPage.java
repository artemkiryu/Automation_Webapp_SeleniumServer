package pageObjects.Sessions;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageObjects.CommonActionsPage;
import pageObjects.Locations.LocationsPage;
import pageObjects.Speaker.SpeakerPage;
import pojo.AddCustomFieldsData;
import pojo.AddSessionTypesLevels;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class SessionsListPage extends CommonActionsPage {

    @FindBy(xpath = "//button[text()='Add New']")
    public WebElement ADD_NEW_SESSION_BUTTON;

    @FindBy(xpath = "//button[@ng-click='setChoiceToDoNotShow()']")
    public WebElement DONTSHOWAGAIN_BUTTON;


    //Track Drop Down Xpaths
    @FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle btn-border-white']//span[@class='label ng-binding'][text()='Track']")
    public WebElement TRACK_DROP_DOWN;

    @FindBy(xpath = "//li[text()='Session Tracks']/following-sibling::li")
    public List<WebElement> LIST_OF_TRACKS;

    @FindBy(xpath = "//span[@ng-click='toggleMassAction()']")
    public WebElement MASS_ACTION_BUTTON;

    @FindBy(xpath = "//i[@ng-click='toggleMassAction()']")
    public WebElement MASS_ACTION_CLOSE_BUTTON;

    @FindBy(xpath = "//input[@ng-model='selectAll.selected']")
    public WebElement SELECTALL_CHK;

    @FindBy(xpath = "//button[text()='Publish to Attendee Type(s)'][@ng-click='loadBulkAttendeeTypes()']")
    public WebElement MA_PUBLISHATTENDEETYPE_BTN;

    @FindBy(xpath = "//button[@x-ng-click='bulkPublishAttendeeType()']")
    public WebElement MA_UPDATEATTENDEETYPE_BTN;

    @FindBy(xpath = "//button[contains(text(),'Session Status')]")
    public WebElement MA_SESSIONSTATUS_BTN;

    @FindBy(xpath = "//ul//li[@ng-repeat='allowed in sessions_allowed_status']/a")
    public List<WebElement> MA_SESSIONSTATUS_ITEMS;

    @FindBy(xpath = "//button[contains(text(),'Track')]")
    public WebElement MA_TRACK_BTN;

    @FindBy(xpath = "//ul//li[@ng-repeat='track in eventTrackList']/a")
    public List<WebElement> MA_TRACK_ITEMS;

    @FindBy(xpath = "//button[contains(text(),'Session Level')]/../preceding-sibling::div[1]/button")
    public WebElement MA_TYPE_BTN;

    @FindBy(xpath = "//ul//li[@ng-repeat='type in sessionTypesList']/a")
    public List<WebElement> MA_TYPE_ITEMS;

    @FindBy(xpath = "//button[contains(text(),'Session Level')]")
    public WebElement MA_SESSIONLEVEL_BTN;

    @FindBy(xpath = "//ul//li[@ng-repeat='sessionLevel in SessionLevelList']/a")
    public List<WebElement> MA_SESSIONLEVEL_ITEMS;

    @FindBy(xpath = "//button[contains(text(),'Override Capacity')]")
    public WebElement MA_OVERRIDECAPACITY_BTN;

    @FindBy(xpath = "//ul//li[@ng-repeat='allow in overrideSessions']/a")
    public List<WebElement> MA_OVERRIDECAPACITY_ITEMS;

    @FindBy (xpath = "//input[@ng-model='defaultFilter.searchTrackName']")
    public WebElement SEARCH_TRACK_TEXT_BOX;

    @FindBy(xpath = "//select[@ng-model='pageLimitForScheduledItemList.value']")
    public WebElement ITEMS_PERPAGE_DROPDOWN;

    @FindBy(xpath = "//div[@class='modal-content']//div[1]//div[2]//span[@class='ng-binding'][1]")
    public WebElement DELETE_ALERT_TEXT;

    @FindBy(xpath = "//button[@x-ng-click='ok()']")
    public WebElement DELETE_ALERT_OK;

    @FindBy(xpath = "//div[@class='modal-content']//div[1]//div[2]/div[1]/span")
    public WebElement MA_ALERT_TEXT;

    @FindBy(xpath = "//button[@x-ng-click='ok()']")
    public WebElement MA_ALERT_OK;

    @FindBy (xpath = "//input[@ng-model='defaultFilter.searchTrackName']/../..//span[@title='Reset Filter']")
    public WebElement CLEAR_TRACK_SEARCH;

    //Type Drop Down Xpaths
    @FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle btn-border-white']//span[text()='Type:']")
    public WebElement TYPE_DROP_DOWN;

    @FindBy(xpath = "//li[text()='Session Types']/following-sibling::li//input")
    public List<WebElement> LIST_OF_SESSION_TYPES;

    @FindBy (xpath = "//input[@ng-model='defaultFilter.searchSessionType']")
    public WebElement SEARCH_SESSION_TYPE_TEXT_BOX;

    @FindBy (xpath = "//input[@ng-model='defaultFilter.searchSessionType']/../..//span[@title='Reset Filter']")
    public WebElement CLEAR_SESSION_TYPE_SEARCH;

    //Status Drop Down Xpaths
    @FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle btn-border-white']//span[@class='label ng-binding'][text()='Status']")
    public WebElement SESSION_STATUS_DROP_DOWN;

    @FindBy(xpath = "//li[text()='Session Status']/following-sibling::li//input")
    public List<WebElement> LIST_OF_SESSION_STATUS;

    @FindBy (xpath = "//input[@ng-model='defaultFilter.searchStatusLevel']")
    public WebElement SEARCH_SESSION_STATUS_TEXT_BOX;

    @FindBy (xpath = "//input[@ng-model='defaultFilter.searchStatusLevel']/../..//span[@title='Reset Filter']")
    public WebElement CLEAR_SESSION_STATUS_SEARCH;

    // More Filter
    @FindBy (xpath = "//button[@class='btn btn-default dropdown-toggle']")
    public WebElement MORE_FILTER_DROPDOWN;

    //List of Session Codes
    @FindBy (xpath = "//div[@class='col-sm-12 agendaItembox p0 pt15']//tbody[@ng-repeat='session in sessionList']//td[4]")
    public List<WebElement> LIST_OF_SESSION_CODES;

    //List of Instance Session Codes
    @FindBy(xpath = "//div[@class='col-sm-12 agendaItembox p0 pt15']//tbody[@ng-repeat='sessionInstance in instanceList']//td[3]")
    public List<WebElement> LIST_OF_INSTANCE_SESSION_CODES;
    //List of Instance Session Types
    @FindBy(xpath = "//div[@class='col-sm-12 agendaItembox p0 pt15']//tbody[@ng-repeat='sessionInstance in instanceList']//td[4]")
    public List<WebElement> LIST_OF_INSTANCE_SESSION_TYPES;

    @FindBy(xpath = "//button[@id='statusSelectBox']//strong")
    public WebElement INSTANCE_STATUS_VALUE;

    // List of Status
    @FindBy (xpath = "//div[@class='col-sm-12 agendaItembox p0 pt15']//tbody[@ng-repeat='session in sessionList']//td[6]")
    public List<WebElement> LIST_OF_ASSIGNED_STATUS;

    // List of Types
    @FindBy (xpath = "//div[@class='col-sm-12 agendaItembox p0 pt15']//tbody[@ng-repeat='session in sessionList']//td[5]")
    public List<WebElement> LIST_OF_ASSIGNED_TYPE;

    @FindBy(xpath = "//div[@id='sidebar-collapse']//a[@title='Sessions']")
    public WebElement SESSION_TAG;

    @FindBy(xpath = "//div[@id='sidebar-collapse']//a[@title='Speakers']")
    public WebElement SPEAKER_TAG;

    @FindBy(xpath = "//div[@id='sidebar-collapse']//a[@title='Locations']")
    public WebElement LOCATION_TAG;

    @FindBy(xpath = "//div[@id='sidebar-collapse']//a[@title='Setup']")
    public WebElement SETUP_TAG;

    @FindBy(xpath = "//h2[text()='Sessions']")
    public WebElement SESSION_HEADER;

    public static final By NEXT_BUTTON = By.xpath("//button[text()='Next']");

    @FindBy(xpath = "//button[contains(text(),'Choose Standard')]")
    public WebElement CHOOSE_STANDARD_TYPE;

    @FindBy(xpath = "//button[contains(text(),'Choose User Conference')]")
    public WebElement CHOOSE_USERCONFERENCE_TYPE;

    @FindBy(xpath = "//button[@ng-click='startWorking(selectedSessionType)']")
    public WebElement START_WORKING_LINK;

    @FindBy(xpath = "//a[contains(@ng-class,'view.instanceView')]")
    public WebElement INSTANCES_TAB;

    @FindBy(xpath = "//a[contains(@ng-class,'view.gridView')]")
    public WebElement SCHEDULER_TAB;

    @FindBy(xpath = "//button[text()='today']")
    public WebElement TODAY_BUTTON;

    @FindBy(xpath = "//a[contains(@ng-class,'view.session')]")
    public WebElement SESSIONS_TAB;

    @FindBy(xpath = "//input[@x-ng-model='searchOn.searchSessionName']")
    public WebElement SESSION_SEARCH_BOX;

    @FindBy(xpath = "//button[@ng-click='filterSearchSession()']")
    public WebElement SEARCH_BUTTON;

    @FindBy(xpath = "//input[@x-ng-model='session.sessionCode']")
    public WebElement SESSION_CODE_TEXTBOX;

    @FindBy(xpath = "//button[@ng-click='removeAllFilters()']")
    public WebElement REMOVE_SEARCH_BUTTON;

    @FindBy(xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//td[@class='user-action']//i[2]")
    public WebElement EDIT_SESSION_BUTTON;

    @FindBy(xpath = "//div[@ng-if='instanceList.length > 0 && !instanceItemListLoading && !scheduledItemListLoading']//table//thead//tr//th")
    public List<WebElement> HEADERS_LIST;

    @FindBy(xpath = "//h4[text()='Session List']")
    public WebElement HEADER_SESSION_LIST;

    @FindBy(xpath = "//div[contains(text(),'No Instance(s) found.')]")
    public WebElement NO_INSTANCE_FOUND_TEXT;

    @FindBy(xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//tr//td[2]")
    public List<WebElement> LIST_INSTANCES_SESSION;

    //tbody[@ng-repeat='sessionInstance in instanceList']//tr//td[2]

    @FindBy(xpath = "//h4[text()='Cancelled Sessions']")
    public WebElement HEADER_CANCELLED_SESSION_LIST;

    @FindBy(xpath = "//h4[text()='Session Types And Levels']")
    public WebElement HEADER_SESSION_TYPES_LEVELS;

    @FindBy(xpath = "//h4[text()='New Session Type Name']")
    public WebElement HEADER_SESSION_TYPES;

    @FindBy(xpath = "//h4[text()='New Session Level Name']")
    public WebElement HEADER_SESSION_LEVELS;

    @FindBy(xpath = "//div[@id='sessionTypes']//div[@class='col-sm-12 mb10 p0']//div[@class='col-sm-9 p0']")
    public WebElement SESSION_TYPES_COLOR_LIST;

    @FindBy(xpath = "//div[@id='sessionLevels']//div[@class='col-sm-12']//div[@class='col-sm-7 col-md-9 p0']")
    public WebElement SESSION_LEVELS_COLOR_LIST;

    @FindBy(xpath = "//div[@id='sessionTypes']//input[@placeholder='Session Type']")
    public WebElement SESSION_TYPES_NAME_TEXTBOX;

    @FindBy(xpath = "//input[@title='Add New Type']")
    public WebElement ADD_NEW_TYPES_BUTTON;

    @FindBy(xpath = "//h4[text()='Session Types And Levels']/..//following-sibling::div//i")
    public WebElement SESSION_TYPES_LEVELS_EXPAND_BUTTON;

    @FindBy(xpath = "//h4[text()='Session Custom Fields']/..//following-sibling::div//i")
    public WebElement SESSION_CUSTOM_FIELDS_EXPAND_BUTTON;

    @FindBy(xpath = "//tr[@x-ng-repeat='sessionType in sessionTypesList']")
    public List<WebElement> SESSIONS_TYPES_LIST;

    @FindBy(xpath = "//thead[@class='table-thead table-striped-rows']//th[text()='Session Type']")
    public List<WebElement> HEADER_SESSIONS_TYPES_LIST;

    @FindBy(xpath = "//div[@id='sessionLevels']//input[@placeholder='Session Level']")
    public WebElement SESSION_LEVELS_NAME_TEXTBOX;

    @FindBy(xpath = "//input[@title='Add New Level']")
    public WebElement ADD_NEW_LEVELS_BUTTON;

    @FindBy(xpath = "//tr[@x-ng-repeat='sessionLevel in SessionLevelList']")
    public List<WebElement> SESSIONS_LEVELS_LIST;

    @FindBy(xpath = "//a[contains(text(),'Export')]")
    public WebElement HEADER_EXPORT_BUTTON;

    @FindBy(xpath = "//a[@ng-click='openSessionImportDialog()']")
    public WebElement HEADER_IMPORT_BUTTON;

    @FindBy(xpath = "//span[@ng-click='toggleMassAction()']")
    public WebElement HEADER_BULK_ACTIONS;

    @FindBy(xpath = "//span[text()='Track']")
    public WebElement HEADER_TRACK;

    @FindBy(xpath = "//span[text()='Type:']")
    public WebElement HEADER_TYPES;

    @FindBy(xpath = "//span[text()='Status']")
    public WebElement HEADER_STATUS;

    @FindBy(xpath = "//a[@title='Session Reviews'][@aria-label='Session Reviews']")
    public WebElement SESSIONREVIEW_TAB;

    @FindBy(xpath = "//div[contains(text(),'No Session(s) found.')]")
    public WebElement EMPTY_SESSION_LIST;

    @FindBy(xpath = "//span[text()='More']")
    public WebElement HEADER_MORE;

    @FindBy(xpath = "//button[@ng-click='removeAllFilters()']")
    public WebElement CLEAR_ICON;

    @FindBy(xpath = "//ul[@ng-change='customFieldsFunctions.loadMore()']")
    public WebElement PAGINATION_TAB;

    @FindBy(xpath = "//span[text()='Items Per Page']")
    public WebElement ITEM_PER_PAGE_TEXT;

    @FindBy(xpath = "//table[@class='table table-hover table-striped']//thead/../tbody//td[3]//span[@ng-if='session.scheduled_instance_count']/../i")
    public List<WebElement> SESSIONS_WITH_SCHEDULED_INSTANCE_LIST;

    @FindBy(xpath = "//tr[@ng-repeat='instance in scheduledInstanceList']")
    public WebElement HEADER_SCHEDULED_INSTANCE;

    @FindBy(xpath = "//strong[text()='Date & Time:']/..")
    public WebElement DATETIME_LABEL;

    @FindBy(xpath = "//strong[text()='Location:']/..")
    public WebElement LOCATION_LABEL;

    // Import Session/Instances
    @FindBy (xpath = "//div[@class='col-sm-5 p0 pr5']/a[@class='btn btn-primary btn-sm col-sm-12']")
    public WebElement IMPORT_BUTTON;

    @FindBy (xpath = "//button[@class='btn btn-primary cursor-pointer boldFont ng-binding'][text()='Next ']")
    public WebElement SESSION_NEXT_BUTTON;

    @FindBy(xpath = "//div[contains(@x-ng-click,'session_instances')]")
    public WebElement SESSION_INSTANCE_IMPORT;

    @FindBy (xpath = "//input[@type='file']")
    public WebElement SESSION_IMPORT_CHOOSE_FILE_BUTTON;

    @FindBy (xpath = "//button[@class='btn btn-primary cursor-pointer boldFont ng-binding'][text()='Complete Import ']")
    public WebElement COMPLETE_SESSION_IMPORT;

    @FindBy(xpath = "//span[text()='Close']")
    public WebElement IMPORT_CLOSE_BUTTON;

    @FindBy(xpath = "//a[text()='Download existing sessions to modify content']")
    public WebElement DOWNLOAD_EXISTING_SESSIONS_LINK;

    @FindBy(xpath = "//a[text()='Download existing sessions and occurrence to modify content']")
    public WebElement DOWNLOAD_EXISTING_SESSIONS_OCCURRENCE_LINK;

    // Action Icons Session List
    @FindBy (xpath = "//i[contains(@x-ng-click,'preview')]")
    public List<WebElement> SESSION_PREVIEW_ICON;

    @FindBy (xpath = "//label[text()='Track']/../following-sibling::div[@class='col-sm-7 pl0 setDrop-down ng-scope']//span")
    public WebElement TRACK_VALUE;


    @FindBy (xpath = "//button[@x-ng-click='cancelEdit()']")
    public WebElement CANCEL_SESSION_BUTTON_PREVIEW_MODAL;

    @FindBy(xpath = "//div[@class='col-sm-12 agendaItembox p0 pt15']//table//thead//th")
    public List<WebElement> SESSION_HEADER_LIST;

    //Pagination
    @FindBy(xpath = "//li//a[@ng-click='selectPage(page.number)']")
    public List<WebElement> PAGE_NUMBER_LIST;

    //Delete pop up
    @FindBy(xpath = "//button[@x-ng-click='ok()']")
    public WebElement DELETE_OK_BUTTON;

    @FindBy(xpath = "//h4[text()='Cancelled Sessions']/..//following-sibling::div//i")
    public WebElement CANCELLED_SESSION_EXPAND_BUTTON;

    @FindBy(xpath = "//input[@x-ng-model='cancelledSessions.searchOn.searchSessionName']")
    public WebElement CANCELLED_SESSION_SEARCH_BOX;

    @FindBy(xpath = "//button[@ng-click='searchCancelledSessionsWithPage(true)']")
    public WebElement CANCELLED_SEARCH_BUTTON;

    // Get Schedule Instance Count
    @FindBy (xpath = "//span[@class='ng-scope ng-binding']")
    public List<WebElement> SCHEDULED_INSTANCE_COUNT;

    //Custom Fields
    @FindBy(xpath = "//h4[text()='Session Custom Fields']")
    public WebElement HEADER_SESSION_CUSTOM_FIELDS;

    @FindBy(xpath = "//span[text()='Field Type(s) :']")
    public WebElement HEADER_FIELDS_TYPE;

    @FindBy(xpath = "//span[text()='Used in session layout :']")
    public WebElement HEADER_USED_SESSION_LAYOUT;

    @FindBy(xpath = "//input[@placeholder='Custom Field Name, Code']")
    public WebElement CUSTOM_FIELDS_SEARCH_BOX;

    @FindBy(xpath = "//div[contains(text(),'No Custom Fields')]")
    public WebElement EMPTY_CUSTOM_FIELDS_LIST;

    @FindBy(xpath = "//button[text()='Add Custom Field']")
    public WebElement ADD_NEW_CUSTOM_FIELD_BUTTON;

    // @FindBy(xpath = "//button[@ng-click='customFieldsFunctions.filterSearchSession()']")
    @FindBy(xpath = "//input[@placeholder='Custom Field Name, Code']/../../..//button[(contains(@ng-click,'filterSearchSession()'))]")
    public WebElement SEARCH_CUSTOM_FIELD_BUTTON;

    @FindBy(xpath = "//input[@placeholder='Custom Field Name, Code']/../../..//button[@title='Reset Filter']")
    public WebElement SEARCH_CANCEL_BUTTON;

    @FindBy(xpath = "//tr[@ng-repeat='customField in customFieldsList']")
    public List<WebElement> CUSTOM_FIELD_LIST;

    @FindBy(xpath = "//div[@id='sessionCustomfields']//table//thead//th")
    public List<WebElement> CUSTOM_FIELD_HEADERS_LIST;

    //Export
    @FindBy(xpath = "//p[text()='File Type']")
    public WebElement HEADER_EXPORT_FILE_TYPE;

    @FindBy(xpath = "//a[contains(text(),'Download')]")
    public WebElement EXPORT_DOWNLOAD_BUTTON;

    @FindBy(xpath = "//label[@ng-repeat='option in fileDownloadOptions']")
    public List<WebElement> EXPORT_FILE_TYPE_LIST;

    @FindBy(xpath = "//p[text()='Category Type']")
    public WebElement HEADER_EXPORT_CATEGORY_TYPE;

    @FindBy(xpath = "//label[@class='radio color-gray mtop0']")
    public List<WebElement> EXPORT_CATEGORY_TYPE_LIST;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Catalog List']")
    public WebElement CATALOGLIST_TAB;


    public SessionsListPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void fillSetupSessionLayoutSimple() throws Exception {
        try {
            if (verifyElementDisplayed(NEXT_BUTTON, 6)) {
                browser.findElement(NEXT_BUTTON).click();
                VerifyPageReady(10);
                clickStandardSession();
                clickStartWorking();
                waitForWindowToDispose();
                switchToLatestTabOrWindow();
            }
        } catch (NoSuchElementException e) {
        }

    }

    public void clickDontShowAgainButton() throws Exception {
        try {
            if (verifyElementDisplayed(DONTSHOWAGAIN_BUTTON, 2)) {
                DONTSHOWAGAIN_BUTTON.click();
                VerifyPageReady(10);
                switchToLatestTabOrWindow();
            }
        } catch (NoSuchElementException e) {
        }
    }

    public AddSession editSessionView(String sessionCode) throws Exception {
        searchSessionBySessionCode(sessionCode);
        String xpath = "//tbody[@ng-repeat='session in sessionList']//td[4][text()='" + sessionCode + "']//following-sibling::td/i[2]";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 30);
        clickByJavaScript(element);
        logReport("Session edited successfully by code " + sessionCode);
        VerifyAngularHasFinishedProcessing(30);
        return new AddSession(browser);

    }

    public AddSession editSessionBySessionName(String sessionName) throws Exception {
        searchSessionBySessionCode(sessionName);
        String xpath = "//tbody[@ng-repeat='session in sessionList']//td[2][text()='" + sessionName + "']//following-sibling::td/i[2]";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 30);
        clickByJavaScript(element);
        logReport("Session edited successfully by code " + sessionName);
        VerifyAngularHasFinishedProcessing(10);
        return new AddSession(browser);

    }

    public boolean isSessionFoundBySessionNameWithStatusSubmitted(String sessionName) throws Exception {
        searchSessionBySessionCode(sessionName);
        String xpath = "//tbody[@ng-repeat='session in sessionList']//td[2][text()='" + sessionName + "']//following-sibling::td[text()='Submitted']";
        return verifyElementDisplayed(By.xpath(xpath), 5);
    }
    public void clickTodayButton() {
        if (verifyElementDisplayed(TODAY_BUTTON, 1)) {
            clickByJavaScript(TODAY_BUTTON);
            logReport("Today button clicked successfully");
            VerifyAngularHasFinishedProcessing(10);
        }
    }

    public void deleteSessionView(String sessionCode) throws Exception {
        String xpath = "//tbody[@ng-repeat='session in sessionList']//td[4][text()='" + sessionCode + "']//following-sibling::td/i[3]";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 30);
        clickByJavaScript(element);
        logReport("Session deleted successfully by code " + sessionCode);
        VerifyAngularHasFinishedProcessing(10);

    }

    public AddSession previewSessionView() throws Exception {
        String xpath = "//tbody[@ng-repeat='session in sessionList']//td[7]//i[1]";
        //WebElement element = browser.findElement(By.xpath(xpath));
        //element.click();
        List<WebElement> element = browser.findElements(By.xpath(xpath));
        if (element.size() > 1) {
            element.get(0).click();
        }

        logReport("Session previewed successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        Thread.sleep(2000);
        return new AddSession(browser);

    }

    public AddSession editSessionView() throws Exception {
        String xpath = "//tbody[@ng-repeat='session in sessionList']//td[7]//i[2]";
        // WebElement element = browser.findElement(By.xpath(xpath));
        //element.click();
        List<WebElement> element = browser.findElements(By.xpath(xpath));
        if (element.size() > 1) {
            clickByJavaScript(element.get(0));
        }
        logReport("Session edited successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        return new AddSession(browser);

    }

    public AddSession previewInstanceView() throws Exception {
        String xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//td[10]//i[1]";
        // WebElement element = browser.findElement(By.xpath(xpath));
        //element.click();
        List<WebElement> element = browser.findElements(By.xpath(xpath));
        if (element.size() > 1) {
            element.get(0).click();
        }
        logReport("Session previewed successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        return new AddSession(browser);

    }

    public AddSession previewSimpleSessionInstanceView() throws Exception {
        String xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//td[11]//i[@class='fa fa-eye fa-lg']";
        List<WebElement> element = browser.findElements(By.xpath(xpath));
        if (element.size() > 1) {
            element.get(0).click();
        }
        logReport("Simple Session previewed with read-only mode successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        return new AddSession(browser);

    }

    public AddSession editSimpleSessionInstanceView() throws Exception {
        String xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//td[11]//i[2]";
        List<WebElement> element = browser.findElements(By.xpath(xpath));
        if (element.size() > 1) {
            clickByJavaScript(element.get(0));
            //element.get(0).click();
        }
        logReport("Simple Session previewed with edit mode successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        return new AddSession(browser);

    }

    public AddSession editInstanceView() throws Exception {
        String xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//td[10]//i[2]";
        List<WebElement> element = browser.findElements(By.xpath(xpath));
        if (element.size() > 1) {
            clickByJavaScript(element.get(0));
            //element.get(0).click();
        }
        logReport("Session previewed successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        return new AddSession(browser);

    }

    public void editSchedulerView(String sessionCode) throws Exception {
        /*String xpath_today = "//div[@class='fc-button-group']//button[contains(text(),'today')]";
        WebElement element_today = browser.findElement(By.xpath(xpath_today));
        click(element_today);*/
        //type(SESSION_SEARCH_BOX, sessionCode, true);
        clickTodayButton();
        VerifyPageReady(30);
        Thread.sleep(5000);
        String xpath = "//div[@class='fc-event-container']//div[@class='evt-title-align']//span[text()='" + sessionCode + "']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 30);
        clickByJavaScript(element);
        logReport("Session edited successfully by code " + sessionCode);
    }

    public AddSession clickEditSchedulerButton(String sessionCode) throws Exception {
        String xpath = "//div[@class='popover fade right in']//span[contains(.,'" + sessionCode + "')]/..//following-sibling::div//input[@value='Edit']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 30);
        clickByJavaScript(element);
        logReport("Session edited successfully by code " + sessionCode);
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        return new AddSession(browser);

    }

    public AddSession editInstanceView(String instanceCode) throws Exception {
        searchSessionBySessionCode(instanceCode);
        String xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//td[2][contains(.,'" + instanceCode + "')]//following-sibling::td/i[2]";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 30);
        element.click();
        logReport("Session edited successfully by code " + instanceCode);
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        return new AddSession(browser);

    }

    public AddSession previewSession(String sessionCode) throws Exception {
        String xpath = "//tbody[@ng-repeat='session in sessionList']//td[4][text()='" + sessionCode + "']//following-sibling::td/i[1]";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 30);
        element.click();
        logReport("Session edited successfully by code " + sessionCode);
        return new AddSession(browser);
    }

    public void deleteSession(String sessionCode) throws Exception {
        String xpath = "//tbody[@ng-repeat='session in sessionList']//td[4][text()='" + sessionCode + "']//following-sibling::td/i[3]";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 30);
        element.click();
        logReport("Session deleted successfully by code " + sessionCode);

    }
    public void fillSetupSessionLayoutConference() throws Exception {
        try {
            if (verifyElementDisplayed(NEXT_BUTTON, 1)) {
                browser.findElement(NEXT_BUTTON).click();
                VerifyPageReady(10);
                clickConferenceSession();
                clickStartWorking();
                //waitForWindowToDispose();
                switchToLatestTabOrWindow();
            }
        } catch (NoSuchElementException e) {
        }

    }

    public void fillSetupSessionLayoutStandard() throws Exception {
        try {
            if (verifyElementDisplayed(NEXT_BUTTON, 6)) {
                browser.findElement(NEXT_BUTTON).click();
                VerifyPageReady(10);
                clickStandardSession();
                clickStartWorking();
                // waitForWindowToDispose();
                switchToLatestTabOrWindow();
            }
        } catch (NoSuchElementException e) {
        }

    }

    public void clickNextButton() throws Exception {
        try {

            if (verifyElementDisplayed(NEXT_BUTTON, 6)) {
                browser.findElement(NEXT_BUTTON).click();
                VerifyPageReady(10);
            }
        } catch (TimeoutException e) {
        }
    }

    public AddSession clickAddNewSession() throws Exception {
        Wait(ADD_NEW_SESSION_BUTTON, 30);
        clickByJavaScript(ADD_NEW_SESSION_BUTTON);
        VerifyAngularHasFinishedProcessing(10);
        logReport("Successfully clicked on 'Add New Session' button.");
        return new AddSession(browser);
    }

    public SpeakerPage clickOnSpeakerTab() throws Exception {
        VerifyPageReady(60);
        Wait(SPEAKER_TAG, 30);
        click(SPEAKER_TAG);
        logReport("Successfully clicked on speaker tab.");
        VerifyAjaxRequestsFinished(30);
        VerifyAngularHasFinishedProcessing(10);
        return new SpeakerPage(browser);
    }

    public SessionSetupPage clickOnSetupTab() throws Exception {
        VerifyPageReady(30);
        Wait(SETUP_TAG, 30);
        clickByJavaScript(SETUP_TAG);
        logReport("Successfully clicked on Setup tab.");
        VerifyAngularHasFinishedProcessing(10);
        VerifyAjaxRequestsFinished(30);
        VerifyPageReady(20);
        return new SessionSetupPage(browser);
    }

    public void clickStandardSession() throws Exception {
        VerifyPageReady(20);
        click(CHOOSE_STANDARD_TYPE);
        logReport("Choose standard session clicked successfully");

    }

    public void clickConferenceSession() throws Exception {
        VerifyPageReady(20);
        clickByJavaScript(CHOOSE_USERCONFERENCE_TYPE);
        logReport("Choose conference session clicked successfully");

    }

    public void clickStartWorking() throws Exception {
        VerifyPageReady(20);
        click(START_WORKING_LINK);
        logReport("Start Working link clicked successfully");

    }

    public LocationsPage clickOnLocationTab() throws Exception {

        VerifyPageReady(60);
        Wait(LOCATION_TAG, 60);
        click(LOCATION_TAG);
        logReport("Successfully clicked on locations tab.");
        return new LocationsPage(browser);
    }

    public AddSession clickOnSessionsTab() throws Exception {

        VerifyPageReady(60);
        Wait(SESSION_TAG, 60);
        click(SESSION_TAG);
        logReport("Successfully clicked on session tab.");
        return new AddSession(browser);
    }

    public void clickInstancesTab() throws Exception {
        Wait(INSTANCES_TAB, 30);
        clickByJavaScript(INSTANCES_TAB);
        // click(INSTANCES_TAB);
        logReport("Instances tab clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyAjaxRequestsFinished(30);
    }

    public void selectPerPageItems(String value) throws Exception {
        Wait(ITEMS_PERPAGE_DROPDOWN, 20);
        select(ITEMS_PERPAGE_DROPDOWN, value);
        logReport("Selected item per page value " + value);
        VerifyAngularHasFinishedProcessing(10);
    }

    public int getInstanceCount() throws Exception{

        int size = SCHEDULED_INSTANCE_COUNT.size();
        int sum = 0;
        for (int i= 1; i == size; i++ ) {
            try {
                VerifyPageReady(30);
                VerifyAngularHasFinishedProcessing(10);

                int count = Integer.parseInt(SCHEDULED_INSTANCE_COUNT.get(i).getText());
                sum = count + count;
                logReport("Scheduled Instances" + sum);
            }
            catch(Exception ex) {
                logReport("Exception handled for Now a Number");

            }

        }

        return sum;

    }

    public void clickSchedulerTab() throws Exception {
        Wait(SCHEDULER_TAB, 30);
        //click(SCHEDULER_TAB);
        clickByJavaScript(SCHEDULER_TAB);
        logReport("Scheduler tab clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyAjaxRequestsFinished(30);
    }

    public Integer getScheduledInstancesListBySessionName(String sessionName) {
        String xpath = "//div[@class='evt-title-align']/span[text()='" + sessionName + "']";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        return elements.size();

    }


    public void getSessionCode() throws Exception {
        Wait(SESSIONS_TAB, 30);
        click(SESSIONS_TAB);
        logReport("Sessions tab clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyAjaxRequestsFinished(30);
    }

    public void searchSessionBySessionCode(String sessionCode) throws Exception {
        type(SESSION_SEARCH_BOX, sessionCode, true);
        logReport("Entered session code value " + sessionCode + " in the search box");
        Wait(SEARCH_BUTTON, 20);
        clickByJavaScript(SEARCH_BUTTON);
        logReport("Sessions search button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyAjaxRequestsFinished(30);

    }

    public boolean isSessionFoundInInstanceView(String sessionCode) {
        boolean flag = false;
        if (verifyElementDisplayed(NO_INSTANCE_FOUND_TEXT, 0)) {
            return false;
        } else {
            for (WebElement e : LIST_INSTANCES_SESSION) {
                String acSC = e.getText().split("_")[0].trim();
                if (acSC.equalsIgnoreCase(sessionCode)) {
                    flag = true;
                    break;
                }

            }
        }
        return flag;
    }

    public Integer getSessionInstancesListBySessionCode(String sessionCode) {
        String xpath = "//td[2][contains(text(),'" + sessionCode + "')]";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        return elements.size();
    }
    public AddSession searchAndClickOnEditSessionBySessionCode(String sessionCode) throws Exception {
        type(SESSION_SEARCH_BOX, sessionCode, true);
        logReport("Entered session code value " + sessionCode + " in the search box");
        Wait(SEARCH_BUTTON, 20);
        click(SEARCH_BUTTON);
        logReport("Sessions search button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);

        String xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//tr//td[text()='" + sessionCode + "']/..//following-sibling::td[@class='user-action']//i[2]";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);

        logReport("Sessions edit button clicked successfully");

        VerifyAngularHasFinishedProcessing(10);
        //VerifyAjaxRequestsFinished(30);

        Thread.sleep(1000);

        return new AddSession(browser);
    }

    public void searchAndClickOnDeleteSessionBySessionCode(String sessionCode) throws Exception {
        SESSION_SEARCH_BOX.clear();
        type(SESSION_SEARCH_BOX, sessionCode, true);
        logReport("Entered session code value " + sessionCode + " in the search box");
        Wait(SEARCH_BUTTON, 20);
        click(SEARCH_BUTTON);
        logReport("Sessions search button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);

        String xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//tr//td[text()='" + sessionCode + "']/..//following-sibling::td[@class='user-action']//i[3]";
        click(browser.findElement(By.xpath(xpath)));
        logReport("Sessions delete button clicked successfully");
        switchToLatestTabOrWindow();
        click(DELETE_OK_BUTTON);
        switchToLatestTabOrWindow();
        logReport("Sessions " + sessionCode + "deleted successfully");
    }

    public void searchAndClickOnDeleteConferenceSessionBySessionCode(String sessionCode) throws Exception {
        SESSION_SEARCH_BOX.clear();
        type(SESSION_SEARCH_BOX, sessionCode, true);
        logReport("Entered session code value " + sessionCode + " in the search box");
        Wait(SEARCH_BUTTON, 20);
        click(SEARCH_BUTTON);
        logReport("Sessions search button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);

        //String xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//tr//td[text()='" + sessionCode + "']/..//following-sibling::td[@class='user-action']//i[3]";
        String xpath = "//tbody[@ng-repeat='session in sessionList']//td[4][text()='" + sessionCode + "']//following-sibling::td/i[3]";
        click(browser.findElement(By.xpath(xpath)));
        logReport("Sessions delete button clicked successfully");
        switchToLatestTabOrWindow();
        click(DELETE_OK_BUTTON);
        switchToLatestTabOrWindow();
        logReport("Sessions " + sessionCode + "deleted successfully");
    }

    public boolean searchCancelledSessionsBySessionCode(String sessionCode) throws Exception {
        clickByJavaScript(CANCELLED_SESSION_EXPAND_BUTTON);
        logReport("Cancelled Sessions list expand button clicked successfully");
        type(CANCELLED_SESSION_SEARCH_BOX, sessionCode, true);
        logReport("Entered session code value " + sessionCode + " in the cancelled session search box");
        click(CANCELLED_SEARCH_BUTTON);
        logReport("Cancelled Sessions search button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);

        String xpath = "//tbody[@ng-repeat='session in cancelledSessionList']//tr//td[2][(text()='" + sessionCode + "')]";
        return verifyElementDisplayed(By.xpath(xpath), 1);


    }

    public boolean isListOfSessionStatus(String status) throws Exception {
        boolean found = false;
        for (WebElement e : LIST_OF_ASSIGNED_STATUS) {
            if (!e.getText().trim().equals((status))) {
                found = false;
                break;
            } else {
                found = true;
            }
        }
        return found;
    }

    public boolean isListOfSessionCode(String code) throws Exception {
        boolean found = false;
        for (WebElement e : SESSION_PREVIEW_ICON) {

            clickByJavaScript(e);
            VerifyAngularHasFinishedProcessing(10);
            String xpath = "//label[text()='Session Code']/../div/span";
            WebElement element = browser.findElement(By.xpath(xpath));
            String SessionCode = element.getText().trim();
            click(CANCEL_SESSION_BUTTON_PREVIEW_MODAL);
            if (!SessionCode.contains(code)) {
                found = false;
                break;
            } else {
                found = true;
            }
        }
        return found;
    }

    public void clickSessionPreviewIcon (int i) throws Exception{
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        SESSION_PREVIEW_ICON.get(i).click();
    }

    public boolean isListOfSessionTrackFound(String track) throws Exception {
        boolean found = false;
        for (WebElement e : SESSION_PREVIEW_ICON) {
            clickByJavaScript(e);
            // e.click();
            VerifyAngularHasFinishedProcessing(10);
            VerifyPageReady(30);
            Thread.sleep(2000);
            String trackName = TRACK_VALUE.getText().trim();
            logReport("Track Name : " + trackName);
            click(CANCEL_SESSION_BUTTON_PREVIEW_MODAL);
            if (!trackName.equals(track)) {
                found = false;
                break;
            } else {
                found = true;
            }
        }

        return found;
    }

    public boolean isListOfSessionType(String type) throws Exception {
        boolean found = false;
        for (WebElement e : SESSION_PREVIEW_ICON) {
            clickByJavaScript(e);
            VerifyAngularHasFinishedProcessing(10);
            String xpath = "//label[text()='Session Type']/../div/span";
            WebElement element = browser.findElement(By.xpath(xpath));
            String sessionType = element.getText().trim();
            click(CANCEL_SESSION_BUTTON_PREVIEW_MODAL);
            if (!sessionType.equals(type)) {
                found = false;
                break;
            } else {
                found = true;
            }
        }
        return found;
    }

    public void selectSessionTrackFilter(String track) throws Exception {
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        logReport("Click on track Drop Down");
        click(TRACK_DROP_DOWN);
        type(SEARCH_TRACK_TEXT_BOX,track,true);
        for (WebElement e : LIST_OF_TRACKS) {
            if (!e.isSelected()){
                e.click();
                logReport(e.getText() + "Session Status is checked");
            }
            else
            {
                logReport(e.getText() + "Session status is already checked");
            }
        }
    }

    public void selectSessionStausFilter(String status) throws Exception {

        Wait(SESSION_STATUS_DROP_DOWN, 20);
        click(SESSION_STATUS_DROP_DOWN);
        type(SEARCH_SESSION_STATUS_TEXT_BOX,status,true);
        for (WebElement e : LIST_OF_SESSION_STATUS) {
            if (!e.isSelected()){
                e.click();
                logReport(e.getText() + "Session Status is checked");
            }
            else
            {
                logReport(e.getText() + "Session status is already checked");
            }
        }

    }

    public void clickSearchIcon() throws Exception {
        Wait(SEARCH_BUTTON, 20);
        click(SEARCH_BUTTON);
        VerifyAngularHasFinishedProcessing(10);
        VerifyAjaxRequestsFinished(20);
        logReport("Search button clicked successfully");
    }


    public void selectSessionTypeFilter(String type) throws Exception {
        click(TYPE_DROP_DOWN);
        type(SEARCH_SESSION_TYPE_TEXT_BOX,type,true);
        for (WebElement e : LIST_OF_SESSION_TYPES) {
            if (!e.isSelected()){
                e.click();
                logReport(e.getText() + "Session Type is checked");
            }
            else
            {
                logReport(e.getText() + "Session Type is already checked");
            }

        }

    }

    public void clickSearchButton () throws Exception {
        SEARCH_BUTTON.click();
    }

    public void importSession (String fileName) throws Exception{
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        clickImportButton();
        selectSessionImportSection();
        selectImportFile(fileName);
        clickCompleteSessionImport();
        Thread.sleep(10000);
    }

    public void importSessionInstance(String fileName) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(30);
        clickImportButton();
        selectSessionInstanceImportSection();
        selectImportFile(fileName);
        clickCompleteSessionImport();
        Thread.sleep(10000);
    }

    public void selectImportFile (String fileName) throws Exception{
        File file = new File("target/test-classes/files/" + fileName);
        String absolutePath = file.getAbsolutePath();
        reporter.info("file path " + absolutePath);
        if (SESSION_IMPORT_CHOOSE_FILE_BUTTON.getAttribute("class").contains("hidden")) {
            setElementAttribute(SESSION_IMPORT_CHOOSE_FILE_BUTTON, "btn btn-info fileChooser");
        }
        Thread.sleep(2000);
        SESSION_IMPORT_CHOOSE_FILE_BUTTON.sendKeys(absolutePath);
        VerifyAjaxRequestsFinished(20);
    }

    public void setElementAttribute(WebElement element, String value) {
        executeJavascript("arguments[0].setAttribute('class', '" + value + "')", element);

    }

    public void clickImportButton() throws Exception {

        VerifyAngularHasFinishedProcessing(10);
        Wait(IMPORT_BUTTON, 10);
        clickByJavaScript(IMPORT_BUTTON);
        logReport("Import Button is clicked SuccessFully");

    }

    public void selectSessionImportSection() throws Exception {
        //div[contains(@x-ng-click,'session_instances')]
        VerifyAngularHasFinishedProcessing(10);
        Wait(SESSION_NEXT_BUTTON, 30);
        logReport("NEXT Button Displayed");
        click(SESSION_NEXT_BUTTON);
        logReport("Next Button is clicked SuccessFully");

    }

    public void selectSessionInstanceImportSection() throws Exception {
        Actions action = new Actions(browser);
        action.moveToElement(SESSION_INSTANCE_IMPORT).build().perform();
        clickByJavaScript(SESSION_INSTANCE_IMPORT);
        VerifyAngularHasFinishedProcessing(10);
        logReport("Session Instance Import is selected SuccessFully");

    }

    public void clickCompleteSessionImport () throws Exception {

        VerifyAngularHasFinishedProcessing(10);
        Wait(COMPLETE_SESSION_IMPORT, 30);
        logReport("NEXT Button Displayed");
        click(COMPLETE_SESSION_IMPORT);
        logReport("Complete Session Import Button is clicked SuccessFully");

    }

    public void removeMoreFilter (String moreFilterName, String customFieldType) throws Exception {

        if (customFieldType.equals("Text") || customFieldType.equals("Textarea") || customFieldType.equals("Session Label")) {

            logReport("Clear Text Filter");
            String xpath1 = "//input[contains(@class,'form-control')][@placeholder='" + moreFilterName + "']/../../span";
            WebElement element1 = browser.findElement(By.xpath(xpath1));
            clickByJavaScript(element1);
            // element1.click();
        } else if (customFieldType.equals("Checkbox")) {
            logReport("Clear Drop Down Filter");
            String xpath = "//div[@class='btn-group']//span[text()='GreenU']/../../../../../li//span[@class='fa fa-close close-icon customlabel']";
            WebElement element2 = browser.findElement(By.xpath(xpath));
            clickByJavaScript(element2);
            // element.click();

        } else if (customFieldType.equals("Tags")) {
            logReport("Clear Drop Down Filter");
            String xpath = "//div[@class='btn-group']//span[text()='Tag1']/../../../../../li//span[@class='fa fa-close close-icon']";
            WebElement element2 = browser.findElement(By.xpath(xpath));
            clickByJavaScript(element2);
            // element.click();

        } else if (customFieldType.equals("Level")) {
            logReport("Clear Drop Down Filter");
            String xpath = "//div[@class='btn-group']//span[text()='Advanced']/../../../../../li//span[@class='fa fa-close close-icon']";
            WebElement element2 = browser.findElement(By.xpath(xpath));
            clickByJavaScript(element2);
            // element.click();

        } else if (customFieldType.equals("Select Multiple")) {
            {
                logReport("Clear Drop Down Filter");
                String xpath = "//div[@class='btn-group']//span[text()='FS']/../../../../../li//span[@class='fa fa-close close-icon customlabel']";
                WebElement element2 = browser.findElement(By.xpath(xpath));
                clickByJavaScript(element2);
                // element.click();

            }
        } else {
            logReport("Clear Drop Down Filter");
            String xpath = "//div[@class='btn-group']//span[text()='" + moreFilterName + ":']/../../../../../li//span[@class='fa fa-close close-icon']";
            WebElement element = browser.findElement(By.xpath(xpath));
            clickByJavaScript(element);
            // element.click();
        }


        VerifyAngularHasFinishedProcessing(10);
    }

    public void clearSearchFilter () throws Exception{
        Wait(REMOVE_SEARCH_BUTTON, 20);
        clickByJavaScript(REMOVE_SEARCH_BUTTON);
        VerifyAngularHasFinishedProcessing(10);
        logReport("Clear filter clicked successfully");
        clickByJavaScript(SEARCH_BUTTON);
        logReport("Search filter clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        logReport("Search session filter is Cleared");
    }

    public String getSessionStatusFromList () throws Exception{
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        int size = LIST_OF_ASSIGNED_STATUS.size();
        int randnMumber = ThreadLocalRandom.current().nextInt(0, size);
        String sessionStatus = LIST_OF_ASSIGNED_STATUS.get(randnMumber).getText().trim();
        return  sessionStatus;
    }

    public String getSessionTypeFromList () throws Exception{
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        int size = LIST_OF_ASSIGNED_TYPE.size();
        int randnMumber = ThreadLocalRandom.current().nextInt(0, size);
        String sessionType = LIST_OF_ASSIGNED_TYPE.get(randnMumber).getText().trim();
        return  sessionType;
    }
    public String getSessionCodeFromList () throws Exception{
        int size = LIST_OF_SESSION_CODES.size();
        int randnMumber = ThreadLocalRandom.current().nextInt(0, size);
        String sessionCode = LIST_OF_SESSION_CODES.get(randnMumber).getText();
        return  sessionCode;
    }

    //Methods for instance list
    public String getSessionCodeFromInstanceList() throws Exception {
        int size = LIST_OF_INSTANCE_SESSION_CODES.size();
        int randnMumber = ThreadLocalRandom.current().nextInt(0, size);
        String sessionCode = LIST_OF_INSTANCE_SESSION_CODES.get(randnMumber).getText();
        return sessionCode;
    }

    public String getSessionTypeFromInstanceList() throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        int size = LIST_OF_INSTANCE_SESSION_TYPES.size();
        int randnMumber = ThreadLocalRandom.current().nextInt(0, size);
        String sessionType = LIST_OF_INSTANCE_SESSION_TYPES.get(randnMumber).getText().trim();
        return sessionType;
    }

    public String[] getInstanceSessionStatusFromList() throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        List<WebElement> myElements = SESSION_PREVIEW_ICON;

        String statusName = "";
        String[] statusNameA = {};
        for (int i = 0; i < myElements.size(); i++) {

            {
                clickSessionPreviewIcon(i);
                VerifyAngularHasFinishedProcessing(10);
                VerifyPageReady(30);
                Thread.sleep(2000);
                statusName = INSTANCE_STATUS_VALUE.getText();
                statusNameA = statusName.split(": ");
                logReport("Got Status Name of the Status" + statusName);
                logReport("Got Status Name of the Status after trim" + statusNameA[1]);
                click(CANCEL_SESSION_BUTTON_PREVIEW_MODAL);
                if (!statusName.isEmpty()) {
                    break;

                }

            }

        }
        return statusNameA;
    }

    public boolean isListOfSessionInstanceStatusFound(String status) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        boolean found = false;
        for (WebElement e : SESSION_PREVIEW_ICON) {
            clickByJavaScript(e);
            // e.click();
            VerifyAngularHasFinishedProcessing(10);
            VerifyPageReady(30);
            Thread.sleep(2000);
            //String trackName = TRACK_VALUE.getText();
            String statusName = INSTANCE_STATUS_VALUE.getText();
            String[] statusNameA = statusName.split(": ");
            logReport("Got Status Name of the Status" + statusName);
            logReport("Got Status Name of the Status after trim" + statusNameA[1]);
            click(CANCEL_SESSION_BUTTON_PREVIEW_MODAL);
            if (!statusNameA[1].equals(status)) {
                found = false;
                break;
            } else {
                found = true;
            }
        }

        return found;
    }


    public String getSessionTrackFromList() throws Exception {
        List<WebElement> myElements = SESSION_PREVIEW_ICON;
        String trackName = "";

        for (int i = 0; i < myElements.size(); i++) {

            {
                clickSessionPreviewIcon(i);
                VerifyAngularHasFinishedProcessing(10);
                VerifyPageReady(30);
                Thread.sleep(2000);
                trackName = TRACK_VALUE.getText().trim();
                logReport("Got Track Name of the Track " + trackName);
                click(CANCEL_SESSION_BUTTON_PREVIEW_MODAL);
                if (!trackName.isEmpty()) {
                    break;

                }

            }

        }
        return trackName;
    }

    public String getSessionTrackFromSearchedList (int i ) throws Exception {

        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(30);
        List<WebElement> myElements = SESSION_PREVIEW_ICON;

                clickSessionPreviewIcon(i);
                VerifyAngularHasFinishedProcessing(30);
                VerifyPageReady(30);
                Wait(TRACK_VALUE, 10);
                String  trackName = TRACK_VALUE.getText();
                logReport( "Got Track Name of the Track" +trackName);
                click(CANCEL_SESSION_BUTTON_PREVIEW_MODAL);

        return trackName;

    }

    public String getSessionStatus(String sessionCode) throws Exception {
        searchSessionBySessionCode(sessionCode);
        String xpath = "//tbody[@ng-repeat='session in sessionList']//td[4][text()='" + sessionCode + "']//following-sibling::td[2]";
        return browser.findElement(By.xpath(xpath)).getText().trim();
    }

    public boolean isSessionFoundInSessionsList(String sessionCode) throws Exception {
        searchSessionBySessionCode(sessionCode);
        String xpath = "//tbody[@ng-repeat='session in sessionList']//td[4][text()='" + sessionCode + "']";
        return verifyElementDisplayed(By.xpath(xpath), 0);
    }

    public boolean isSessionFoundInSimpleSessionsList(String sessionCode) throws Exception {
        searchSessionBySessionCode(sessionCode);
        String xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//td[3][text()='" + sessionCode + "']";
        // WebElement element = browser.findElement(By.xpath(xpath));
        return verifyElementDisplayed(By.xpath(xpath), 0);
    }
    public void clickInstancesLink(String sessionCode) throws Exception {
        searchSessionBySessionCode(sessionCode);
        WebElement element = browser.findElement(By.xpath("//tbody[@ng-repeat='session in sessionList']//tr//td[4][text()='" + sessionCode + "']//preceding-sibling::td[1]"));
        click(element);
        logReport("Instances numbers clicked successfully");
        VerifyAngularHasFinishedProcessing(10);

    }

    public String getInstancesCountBySessionCode(String sessionCode) throws Exception {
        searchSessionBySessionCode(sessionCode);
        WebElement element = browser.findElement(By.xpath("//tbody[@ng-repeat='session in sessionList']//tr//td[4][text()='" + sessionCode + "']//preceding-sibling::td[1]"));
        return element.getText().trim().replace(" ", "").trim();
    }

    public boolean isColumnAndValueExist(String column, String value) throws Exception {
        String xpath = "//div[@class='sublist-card']//div//p[text()='" + column + "']/../p[text()='" + value + "']";
        return verifyElementDisplayed(By.xpath(xpath), 0);
    }

    public boolean isLinkClickable(String column, String value) throws Exception {
        String xpath = "//div[@class='sublist-card']//div//p[text()='" + column + "']/../p[text()='" + value + "']";
        WebElement input = browser.findElement(By.xpath(xpath));
        Boolean checked = isAttribtuePresent(input, "x-ng-click");
        return checked;
    }

    public AttendeeListPage clickLinkAndOpenAttendeePopup(String column, String value) throws Exception {
        if (isLinkClickable(column, value)) {
            String xpath = "//div[@class='sublist-card']//div//p[text()='" + column + "']/../p[text()='" + value + "']";
            WebElement input = browser.findElement(By.xpath(xpath));
            click(input);
            logReport("Linked clicked successfully");
            VerifyAngularHasFinishedProcessing(30);
            VerifyPageReady(30);
        }
        return new AttendeeListPage(browser);
    }

    public String getDateTimeText() {
        return DATETIME_LABEL.getText().trim().split(": ")[1];
    }

    public String getLocationText() {
        return LOCATION_LABEL.getText().trim().split(": ")[1];
    }

    public boolean isColumnAndValueExistInInstanceView(String column, String value, String sessionCode) throws Exception {
        if (column.equalsIgnoreCase("Capacity")) {
            column = "Cap";
        } else if (column.equalsIgnoreCase("Registered")) {
            column = "Reg";
        } else if (column.equalsIgnoreCase("Waitlisted")) {
            column = "Wait";
        }
        int i = getColumnIndex(HEADERS_LIST, column);
        String xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//td[2][contains(.,'" + sessionCode + "')]/../td[" + i + "]//span[text()='" + value + "']";
        return verifyElementDisplayed(By.xpath(xpath), 0);
    }

    public boolean isColumnAndValueExistInInstanceViewForStandardLayout(String column, String value, String sessionCode) throws Exception {
        if (column.equalsIgnoreCase("Capacity")) {
            column = "Cap";
        } else if (column.equalsIgnoreCase("Registered")) {
            column = "Reg";
        } else if (column.equalsIgnoreCase("Waitlisted")) {
            column = "Wait";
        }
        int i = getColumnIndex(HEADERS_LIST, column);
        String xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//td[3][contains(.,'" + sessionCode + "')]/../td[" + i + "]//span[text()='" + value + "']";
        return verifyElementDisplayed(By.xpath(xpath), 0);
    }

    public boolean isLinkClickableInInstanceViewStandardLayout(String column, String value, String sessionCode) throws Exception {
        if (column.equalsIgnoreCase("Capacity")) {
            column = "Cap";
        } else if (column.equalsIgnoreCase("Registered")) {
            column = "Reg";
        } else if (column.equalsIgnoreCase("Waitlisted")) {
            column = "Wait";
        }
        int i = getColumnIndex(HEADERS_LIST, column);
        String xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//td[3][contains(.,'" + sessionCode + "')]/../td[" + i + "]//span[text()='" + value + "']";
        WebElement input = browser.findElement(By.xpath(xpath));
        Boolean checked = isAttribtuePresent(input, "x-ng-click");
        return checked;
    }

    public boolean isLinkClickableInInstanceView(String column, String value, String sessionCode) throws Exception {
        if (column.equalsIgnoreCase("Capacity")) {
            column = "Cap";
        } else if (column.equalsIgnoreCase("Registered")) {
            column = "Reg";
        } else if (column.equalsIgnoreCase("Waitlisted")) {
            column = "Wait";
        }
        int i = getColumnIndex(HEADERS_LIST, column);
        String xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//td[2][contains(.,'" + sessionCode + "')]/../td[" + i + "]//span[text()='" + value + "']";
        WebElement input = browser.findElement(By.xpath(xpath));
        Boolean checked = isAttribtuePresent(input, "x-ng-click");
        return checked;
    }

    public boolean isSessionListHeaderDisplayed(String headerName, int i) throws Exception {
        boolean found = false;

        if (i == 0) {
            String xpath = "//table[@class='table table-hover table-striped']//thead//th[text()='" + headerName + "']";
            found = verifyElementDisplayed(By.xpath(xpath), 1);

        }
        if (i == 1) {
            //String xpath = "//table[@class='table table-hover table-striped']//thead//tr//th[contains(text(),'" + headerName + "')]";
            String xpath = "//div[contains(@ng-if,'instanceList')]//table[@class='table table-hover table-striped']//thead//tr//th[contains(text(),'" + headerName + "')]";
            found = verifyElementDisplayed(By.xpath(xpath), 1);
        }
        return found;
    }

    public boolean isCustomFieldsListHeaderDisplayed(String headerName) throws Exception {
        boolean found = false;

        String xpath = "//div[@id='sessionCustomfields']//table//thead//th[text()='" + headerName + "']";
        found = verifyElementDisplayed(By.xpath(xpath), 1);

        return found;
    }

    public boolean isCustomFieldsActionsHeaderDisplayed(int i) throws Exception {
        boolean found = false;
        int k = i + 1;
        String xpath = "//div[@id='sessionCustomfields']//table//tbody//tr[1]//td[@class='user-action']//i[" + k + "]";
        found = verifyElementDisplayed(By.xpath(xpath), 1);
        return found;
    }

    public boolean isCustomFieldsListHeaderSortIconDisplayed(String headerName) throws Exception {
        boolean found = false;

        String xpath = "//div[@id='sessionCustomfields']//table//thead//th[text()='" + headerName + "']//span";
        found = verifyElementDisplayed(By.xpath(xpath), 1);

        return found;
    }

    public boolean isSessionListUserActionsHeaderDisplayed(int i) throws Exception {
        boolean found = false;
        int k = i + 1;
        String xpath = "//table[@class='table table-hover table-striped']//tbody[1]//td[@class='user-action']//i[" + k + "]";
        found = verifyElementDisplayed(By.xpath(xpath), 1);
        return found;
    }

    public AttendeeListPage clickLinkAndOpenAttendeePopupInInstanceView(String column, String value, String sessionCode) throws Exception {
        if (isLinkClickableInInstanceView(column, value, sessionCode)) {
            if (column.equalsIgnoreCase("Capacity")) {
                column = "Cap";
            } else if (column.equalsIgnoreCase("Registered")) {
                column = "Reg";
            } else if (column.equalsIgnoreCase("Waitlisted")) {
                column = "Wait";
            }
            int i = getColumnIndex(HEADERS_LIST, column);

            String xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//td[2][contains(.,'" + sessionCode + "')]/../td[" + i + "]//span[text()='" + value + "']";
            WebElement input = browser.findElement(By.xpath(xpath));
            click(input);
            logReport("Linked clicked successfully");
        }
        return new AttendeeListPage(browser);
    }

    public boolean isItemPerPageDisplayed(String items) throws Exception {
        boolean found = false;
        /*String xpath = "//div[@class='col-sm-4 p0 ng-scope']//div//select";
        clickByJavaScript(ITEMS_PERPAGE_DROPDOWN);
        Select select = new Select(browser.findElement(By.xpath(xpath)));
        WebElement option = select.getFirstSelectedOption();
        */
        String defaultItem = getSelectedOption(ITEMS_PERPAGE_DROPDOWN);
        logReport("Default value : " + defaultItem);
        if (defaultItem.equalsIgnoreCase(items.trim())) {
            found = true;
        }
        return found;
    }

    public void clickToExpandScheduledInstance() throws Exception {
        String xpath = "//table[@class='table table-hover table-striped']//thead/../tbody//td[3]//span[@ng-if='session.scheduled_instance_count']";
        if (verifyElementDisplayed(By.xpath(xpath), 1)) {
            SESSIONS_WITH_SCHEDULED_INSTANCE_LIST.get(0).click();
            logReport("Session with scheduled instance clicked successfully");

        } else {
            logReport("No Session with scheduled instance found");
        }
    }

    public List<String> getValuesBySessionName(String sessionName) throws Exception {
        int i = getColumnIndex(SESSION_HEADER_LIST, sessionName);
        String xpath = "//div[@class='col-sm-12 agendaItembox p0 pt15']//table//tbody//tr/td[" + i + "]";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        List<String> values = new ArrayList<>();
        for (WebElement e : elements) {
            values.add(e.getText().trim());
        }
        return values;
    }

    public List<String> getValuesByCustomFieldName(String customFieldName) throws Exception {
        int i = getColumnIndex(CUSTOM_FIELD_HEADERS_LIST, customFieldName);
        String xpath = "//div[@id='sessionCustomfields']//table//tbody//tr/td[" + i + "]";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        List<String> values = new ArrayList<>();
        for (WebElement e : elements) {
            values.add(e.getText().trim());
        }
        return values;
    }

    public void clickColumnInAscendingOrDescendingForCustomFieldList(String order, String column) {
        List<WebElement> columnHeader = CUSTOM_FIELD_HEADERS_LIST;
        for (int i = 0; i < columnHeader.size(); i++) {
            if (columnHeader.get(i).getText().trim().equals(column)) {
                WebElement element = columnHeader.get(i).findElement(By.xpath("./span"));
                element.click();
                if (!element.getAttribute("class").contains("order")) {
                    element.click();
                    return;
                }
            }
        }
    }

    public List<String> getSessionHeadersList() {
        List<String> headersArray = new ArrayList<>();
        for (WebElement e : SESSION_HEADER_LIST) {
            headersArray.add(e.getText().trim());
        }
        logReport("List of Session headers ------" + headersArray);
        return headersArray;
    }

    public int getColumnIndex(List<WebElement> element, String columnName) {
        List<WebElement> columnHeader = element;
        for (int i = 0; i < columnHeader.size(); i++) {
            if (columnHeader.get(i).getText().trim().equals(columnName)) {
                return i + 1;

            }
        }
        return 0;
    }

    public boolean isSortedInAscendingOrder(List<String> actual) {
        List<String> actualList = actual;
        Collections.sort(actual);
        return actualList.equals(actual);
    }

    public boolean isSortedInDescendingOrder(List<String> actual) {
        List<String> actualList = actual;
        Collections.sort(actual, Collections.reverseOrder());
        return actualList.equals(actual);
    }

    public void clickColumnInAscendingOrDescending(String order, String column) {
        List<WebElement> columnHeader = SESSION_HEADER_LIST;
        for (int i = 0; i < columnHeader.size(); i++) {
            if (columnHeader.get(i).getText().trim().equals(column)) {
                WebElement element = columnHeader.get(i).findElement(By.xpath("./span"));
                element.click();
                if (!element.getAttribute("class").contains("order")) {
                    element.click();
                    return;
                }
            }
        }
    }

    public int getTotalPageCount() throws Exception {
        //List<WebElement> pageList = PAGE_NUMBER_LIST;

        int count = PAGE_NUMBER_LIST.size();

        logReport("Total No of pages in list : " + count);

        return count;
    }

    public void clickOnNext() throws Exception {
        String xpath = "//li[@class='ng-scope']//a[text()='Next']";
        if (verifyElementDisplayed(By.xpath(xpath), 1)) {
            click(browser.findElement(By.xpath(xpath)));
            VerifyAjaxRequestsFinished(30);
            VerifyAngularHasFinishedProcessing(20);
            logReport("Next page button clicked successfully ");
        }
    }

    public void clickOnPrevious() throws Exception {
        String xpath = "//li[@class='ng-scope']//a[text()='Previous']";
        if (verifyElementDisplayed(By.xpath(xpath), 1)) {
            click(browser.findElement(By.xpath(xpath)));

            VerifyAjaxRequestsFinished(30);
            VerifyAngularHasFinishedProcessing(10);
            logReport("Previous page button clicked successfully ");
        }
    }

    public void clickOnFilter(String filterName) throws Exception {
        String xpath = "//span[text()='" + filterName + "']";
        click(browser.findElement(By.xpath(xpath)));
        wait(10);
        logReport("Filter : " + filterName + " is clicked successfully.");

    }

    public List<String> getFilterList(String filterName) {
        String xpath = "//li[text()='" + filterName + "']/..//li[@class='sub-list']//ul//li//span";
        List<WebElement> filtersList = browser.findElements(By.xpath(xpath));
        List<String> filtersArray = new ArrayList<>();
        for (WebElement e : filtersList) {
            filtersArray.add(e.getText().trim());
        }
        //logReport("List of "+ filterName +" filter's value ------" + filtersArray);
        return filtersArray;
    }

    public List<String> getMoreFilterList(String sessionType) {
        String xpath = "//span[text()='More']/..//following-sibling::ul//li[@class='sub-list']//label";
        String xpathLocationFilters = "//span[text()='More']/..//following-sibling::ul//li[@ng-if='locationFilterFlag']//label";
        List<WebElement> moreFiltersList = browser.findElements(By.xpath(xpath));
        List<String> filtersArray = new ArrayList<>();
        for (WebElement e : moreFiltersList) {
            filtersArray.add(e.getText().trim());
        }
        if (sessionType.equalsIgnoreCase("Instance") || sessionType.equalsIgnoreCase("Scheduler")) {
            List<WebElement> moreLocationFiltersList = browser.findElements(By.xpath(xpathLocationFilters));
            for (WebElement e : moreLocationFiltersList) {
                filtersArray.add(e.getText().trim());
            }

        }

        // logReport("List of Session More filter's value ------" + filtersArray);
        return filtersArray;

    }

    // Search using Select  Custom Field  Test Methods

    public String getSessionSelectCustomFieldsFromList(String customFieldName) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        List<WebElement> myElements = SESSION_PREVIEW_ICON;

        String selectCFName = "";

        for (int i = 0; i < myElements.size(); i++) {

            {
                clickSessionPreviewIcon(i);
                VerifyAngularHasFinishedProcessing(10);
                VerifyPageReady(30);
                Thread.sleep(2000);
                String xpath = "//label[contains(text(),'"+customFieldName+"')]/../following-sibling::div//span";
                WebElement element = browser.findElement(By.xpath(xpath));

                selectCFName = element.getText();
                if (selectCFName.contains(","))
                {
                    List<String> value = Arrays.asList(selectCFName.split(","));
                    logReport("Value of tag" + value.get(0));
                    selectCFName = value.get(0);

                }
                else
                 {
                   logReport("Value of does not contain comma");
                 }

                logReport("Got Select Custom Filed Value of the Custom field " + selectCFName);
                click(CANCEL_SESSION_BUTTON_PREVIEW_MODAL);
                if (!selectCFName.isEmpty()) {
                    break;

                }

            }

        }
        return selectCFName;
    }


    public void selectSessionCustomSelectFieldFilter(String selectField) throws Exception {
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        logReport("Click on More Drop Down");
        clickByJavaScript(MORE_FILTER_DROPDOWN);
        String xpath = "//ul[@class='dropdown-menu']//li/label[text()='"+selectField+"']";
        WebElement element = browser.findElement(By.xpath(xpath));

           if (!element.isSelected()){
                element.click();
                logReport(element.getText() + "Session Status is checked");
            }
            else
            {
                logReport(element.getText() + "Session status is already checked");
            }
            clickByJavaScript(MORE_FILTER_DROPDOWN);
    }

    public void selectSessionCustomSelectFieldFilterValue(String customFieldValue, String customfield, String customFieldType) throws Exception {
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        logReport("Click on" +customfield+ "Drop Down");

        logReport(""+customFieldType);

        if (customFieldType.equals("Text") || customFieldType.equals("Textarea")) {
            String xpath1 = "//input[@x-ng-model='optionIds[customField.id]'][@placeholder='" + customfield + "']";
            WebElement element1 = browser.findElement(By.xpath(xpath1));

            element1.sendKeys(customFieldValue);

            logReport(element1.getText() + "Session Custom Field " + customFieldValue + " is Entered");

        } else if (customFieldType.equals("Session Label")) {
            String xpath = "//input[@x-ng-model='searchOn.sessionLabel']";
            WebElement element1 = browser.findElement(By.xpath(xpath));

            element1.sendKeys(customFieldValue);

            logReport(element1.getText() + "Session Custom Field " + customFieldValue + " is Entered");

        } else {

            String xpath1 = "//div[@class='btn-group']//span[text()='" + customfield + ":']";
            WebElement element1 = browser.findElement(By.xpath(xpath1));

            element1.click();
            String xpath = "//li[@class='ng-scope']//span[normalize-space()='" + customFieldValue + "']";
            WebElement element = browser.findElement(By.xpath(xpath));

            if (!element.isSelected()) {
                element.click();
                logReport(element.getText() + "Session Custom Field " + customFieldValue + " is Selected");
            } else {
                logReport(element.getText() + "Session Custom Field " + customFieldValue + " is already Selected");
            }
        }
    }

    public boolean isListOfSessionCustomFound(String customFieldName , String customFieldNameValue) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        boolean found = false;
        for (WebElement e : SESSION_PREVIEW_ICON) {
            clickByJavaScript(e);

            VerifyAngularHasFinishedProcessing(10);
            VerifyPageReady(30);
            Thread.sleep(2000);
            String xpath = "//label[contains(text(),'"+customFieldName+"')]/../following-sibling::div//span";
            WebElement element = browser.findElement(By.xpath(xpath));
            logReport( "Actual" + element.getText()+ "Expected" +customFieldNameValue);
            String csField = element.getText();
            click(CANCEL_SESSION_BUTTON_PREVIEW_MODAL);
            if (!csField.contains(customFieldNameValue)) {
                found = false;
                break;
            } else {
                found = true;
            }
        }

        return found;
    }

    public void expandSessionTypesLevels() throws Exception {
        // String xpath = "//h4[text()='Session Types And Levels']/..//following-sibling::div//i[@class='fa fa-2x pull-right p5 fa-caret-down']";
        String xpath = "//h4[text()='Session Types And Levels']/..//following-sibling::div//i";
        WebElement element = browser.findElement(By.xpath(xpath));
        if (element.getAttribute("class").contains("down")) {
            Wait(SESSION_TYPES_LEVELS_EXPAND_BUTTON, 10);
            click(SESSION_TYPES_LEVELS_EXPAND_BUTTON);
            VerifyAngularHasFinishedProcessing(10);
            logReport("Session Types and Levels expand button clicked successfully");
        } else {
            logReport("Session Types and Levels expand button already clicked ");
        }
    }

    public void expandSessionCustomFields() throws Exception {
        //String xpath = "//h4[text()='Session Custom Fields']/..//following-sibling::div//i[@class='fa fa-2x pull-right p5 fa-caret-down']";
        String xpath = "//h4[text()='Session Custom Fields']/..//following-sibling::div//i";
        WebElement element = browser.findElement(By.xpath(xpath));
        if (element.getAttribute("class").contains("down")) {
            Wait(SESSION_CUSTOM_FIELDS_EXPAND_BUTTON, 10);
            click(SESSION_CUSTOM_FIELDS_EXPAND_BUTTON);
            VerifyAngularHasFinishedProcessing(10);
            logReport("Session Custom Fields expand button clicked successfully");
        } else {
            logReport("Session Custom Fields expand button already clicked ");
        }
    }

    public void addSessionType(AddSessionTypesLevels addSessionTypesLevels) throws Exception {
        expandSessionTypesLevels();
        String typeName = addSessionTypesLevels.getTypeName();
        String xpath = "//div[@id='sessionTypes']//div[@class='col-sm-12 mb10 p0']//div[@ng-repeat='color in eventColors']//div[contains(@style,'rgb(" + addSessionTypesLevels.getColorR() + ", " + addSessionTypesLevels.getColorG() + ", " + addSessionTypesLevels.getColorB() + ")')]";

        if (isSessionTypeValueFound(typeName)) {

            logReport("Session Type : " + typeName + "is already exist.Please provide another session type ");

        } else {
            type(SESSION_TYPES_NAME_TEXTBOX, typeName);
            WebElement element = browser.findElement(By.xpath(xpath));
            click(element);
            click(ADD_NEW_TYPES_BUTTON);
            VerifyAngularHasFinishedProcessing(10);
            VerifyPageReady(30);
            logReport("Session Types : " + typeName + " is added successfully");
        }

    }

    public boolean isSessionTypeValueFound(String sessionType) {
        boolean found = false;
        if (SESSIONS_TYPES_LIST.size() > 0) {
            for (WebElement e : SESSIONS_TYPES_LIST) {
                if (e.getText().trim().equalsIgnoreCase(sessionType)) {
                    found = true;
                    break;
                }

            }
        }
        return found;
    }

    public void addSessionLevel(AddSessionTypesLevels addSessionTypesLevels) throws Exception {
        expandSessionTypesLevels();
        String levelName = addSessionTypesLevels.getLevelName();
        String xpath = "//div[@id='sessionLevels']//div[@class='col-sm-12 mb10 p0']//div[@ng-repeat='color in eventColors']//div[contains(@style,'rgb(" + addSessionTypesLevels.getColorR() + ", " + addSessionTypesLevels.getColorG() + ", " + addSessionTypesLevels.getColorB() + ")')]";

        if (isSessionLevelValueFound(levelName)) {

            logReport("Session Level : " + levelName + " is already exist.Please provide another session level ");

        } else {
            type(SESSION_LEVELS_NAME_TEXTBOX, levelName);
            WebElement element = browser.findElement(By.xpath(xpath));
            click(element);
            click(ADD_NEW_LEVELS_BUTTON);
            VerifyAngularHasFinishedProcessing(30);
            VerifyPageReady(30);
            logReport("Session Level : " + levelName + " is added successfully");
        }

    }

    public boolean isSessionLevelValueFound(String sessionLevel) {
        boolean found = false;
        if (SESSIONS_LEVELS_LIST.size() > 0) {
            for (WebElement e : SESSIONS_LEVELS_LIST) {
                if (e.getText().trim().equalsIgnoreCase(sessionLevel)) {
                    found = true;
                    break;
                }

            }
        }
        return found;
    }

    public boolean isSessionTypesLevelsHeaderDisplayed(String headerName, String listType) throws Exception {
        boolean found = false;

        if (listType.equalsIgnoreCase("Session Type")) {
            String xpath = "//thead[@class='table-thead table-striped-rows']//th[text()='" + headerName + "']";
            found = verifyElementDisplayed(By.xpath(xpath), 1);
        }
        if (listType.equalsIgnoreCase("Session Level")) {
            String xpath = "//thead[@class='table-thead']//th[text()='" + headerName + "']";
            found = verifyElementDisplayed(By.xpath(xpath), 1);
        }
        return found;
    }

    public boolean isSessionTypesLevelsActionHeaderDisplayed(String actionName, String listType) throws Exception {
        boolean found = false;
        if (listType.equalsIgnoreCase("Session Type")) {
            String xpath = "//tr[@x-ng-repeat='sessionType in sessionTypesList']//td//i[@title='" + actionName + "']";
            found = verifyElementDisplayed(By.xpath(xpath), 1);
        }
        if (listType.equalsIgnoreCase("Session Level")) {
            String xpath = "//tr[@x-ng-repeat='sessionLevel in SessionLevelList']//td//i[@title='" + actionName + "']";
            found = verifyElementDisplayed(By.xpath(xpath), 1);
        }
        return found;
    }

    public boolean isSessionTypesLevelsAction(String actionName, String name, String listType) throws Exception {
        boolean found = false;
        if (listType.equalsIgnoreCase("Session Type")) {
            String xpath = "//tr[@x-ng-repeat='sessionType in sessionTypesList']//span[@title='" + name + "']/..//following-sibling::td//i[@title='" + actionName + "']";
            found = verifyElementDisplayed(By.xpath(xpath), 1);
        }
        if (listType.equalsIgnoreCase("Session Level")) {
            String xpath = "//tr[@x-ng-repeat='sessionLevel in SessionLevelList']//span[@title='" + name + "']/..//following-sibling::td//i[@title='" + actionName + "']";
            found = verifyElementDisplayed(By.xpath(xpath), 1);
        }
        return found;
    }

    public void searchAndClickCustomSessionType(String typeName) throws Exception {
        String xpath = "//tr[@x-ng-repeat='sessionType in sessionTypesList']//span[@title='" + typeName + "']/..//following-sibling::td//i[@title='Edit Session Type']";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);

        logReport("Session Type : " + typeName + " is clicked successfully");

    }

    public void searchAndClickCustomSessionLevel(String levelName) throws Exception {
        String xpath = "//tr[@x-ng-repeat='sessionLevel in SessionLevelList']//span[@title='" + levelName + "']/..//following-sibling::td//i[@title='Edit Session Level']";
        logReport("Level path : " + xpath);
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);

        logReport("Session Level : " + levelName + " is clicked successfully");

    }

    public void editSessionType(AddSessionTypesLevels addSessionTypesLevels, AddSessionTypesLevels addSessionTypesLevelsUpdate) throws Exception {

        String typeName = addSessionTypesLevels.getTypeName();
        String updatedTypeName = addSessionTypesLevelsUpdate.getTypeName();
        String xpath_name = "//following-sibling::span[text()='" + typeName + "']/../..//input";
        String xpath_color = "//following-sibling::span[text()='" + updatedTypeName + "']/../..//div[contains(@style,'rgb(" + addSessionTypesLevelsUpdate.getColorR() + ", " + addSessionTypesLevelsUpdate.getColorG() + ", " + addSessionTypesLevelsUpdate.getColorB() + ")')]";
        String xpath_save = "//following-sibling::span[text()='" + updatedTypeName + "']/../..//td//i[@title='Save Session Type']";

        WebElement name = browser.findElement(By.xpath(xpath_name));
        Wait(name, 20);
        name.clear();
        type(name, updatedTypeName);
        clickByJavaScript(browser.findElement(By.xpath(xpath_color)));
        clickByJavaScript(browser.findElement(By.xpath(xpath_save)));
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        logReport("Session Type : " + updatedTypeName + " is updated successfully");
    }

    public void editSessionLevel(AddSessionTypesLevels addSessionTypesLevels, AddSessionTypesLevels addSessionTypesLevelsUpdate) throws Exception {

        String levelName = addSessionTypesLevels.getLevelName();
        String updatedLevelName = addSessionTypesLevelsUpdate.getLevelName();
        String xpath_name = "//following-sibling::span[text()='" + levelName + "']/../..//input";
        String xpath_color = "//following-sibling::span[text()='" + updatedLevelName + "']/../..//div[contains(@style,'rgb(" + addSessionTypesLevelsUpdate.getColorR() + ", " + addSessionTypesLevelsUpdate.getColorG() + ", " + addSessionTypesLevelsUpdate.getColorB() + ")')]";
        String xpath_save = "//following-sibling::span[text()='" + updatedLevelName + "']/../..//td//i[@title='Save Session Level']";

        WebElement name = browser.findElement(By.xpath(xpath_name));
        Wait(name, 20);
        name.clear();
        type(name, updatedLevelName);
        clickByJavaScript(browser.findElement(By.xpath(xpath_color)));
        clickByJavaScript(browser.findElement(By.xpath(xpath_save)));
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        logReport("Session Level : " + updatedLevelName + " is updated successfully");
    }

    public void deleteSessionType(String typeName) throws Exception {
        String xpath = "//tr[@x-ng-repeat='sessionType in sessionTypesList']//span[@title='" + typeName + "']/..//following-sibling::td//i[@title='Delete Type']";
        clickByJavaScript(browser.findElement(By.xpath(xpath)));
        logReport("Sessions type delete button clicked successfully");
        switchToLatestTabOrWindow();
        click(DELETE_OK_BUTTON);
        switchToLatestTabOrWindow();
        logReport("Session Type : " + typeName + " is deleted successfully");
    }

    public void deleteSessionLevel(String levelName) throws Exception {
        String xpath = "//tr[@x-ng-repeat='sessionLevel in SessionLevelList']//span[@title='" + levelName + "']/..//following-sibling::td//i[@title='Delete Session Level']";
        clickByJavaScript(browser.findElement(By.xpath(xpath)));
        logReport("Sessions level delete button clicked successfully");
        switchToLatestTabOrWindow();
        click(DELETE_OK_BUTTON);
        switchToLatestTabOrWindow();
        logReport("Session Level : " + levelName + " is deleted successfully");
    }

    public boolean searchCustomFields(AddCustomFieldsData addCustomFieldsData) throws Exception {
        boolean found = false;
        type(CUSTOM_FIELDS_SEARCH_BOX, addCustomFieldsData.getFieldCode(), true);
        clickByJavaScript(SEARCH_CUSTOM_FIELD_BUTTON);
        Thread.sleep(500);
        int listSize = CUSTOM_FIELD_LIST.size();
        if (listSize >= 1) {
            found = true;
        }
        clickByJavaScript(REMOVE_SEARCH_BUTTON);
        return found;

    }

    public AddNewCustomFields searchAndClickOnEditCustomFieldByCode(String code) throws Exception {
        type(CUSTOM_FIELDS_SEARCH_BOX, code);
        logReport("Entered code value " + code + " in the search box");
        Wait(SEARCH_CUSTOM_FIELD_BUTTON, 20);
        clickByJavaScript(SEARCH_CUSTOM_FIELD_BUTTON);
        logReport("Custom field search button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);

        //String xpath = "//tbody[@ng-repeat='customField in customFieldsList']//tr//td[text()='" + code + "']/..//following-sibling::td[@class='user-action']//i[2]";
        String xpath = "//div[@id='sessionCustomfields']//table//tbody//tr//td[2][text()='" + code + "']/..//td[@class='user-action']//i[1]";
        click(browser.findElement(By.xpath(xpath)));

        logReport("Custom field edit button clicked successfully");

        VerifyAngularHasFinishedProcessing(10);
        VerifyAjaxRequestsFinished(30);

        Thread.sleep(1000);

        return new AddNewCustomFields(browser);
    }

    public AddNewCustomFields searchAndClickOnCopyCustomFieldByCode(String code) throws Exception {
        type(CUSTOM_FIELDS_SEARCH_BOX, code);
        logReport("Entered code value " + code + " in the search box");
        Wait(SEARCH_CUSTOM_FIELD_BUTTON, 20);
        clickByJavaScript(SEARCH_CUSTOM_FIELD_BUTTON);
        logReport("Custom field search button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);

        //String xpath = "//tbody[@ng-repeat='customField in customFieldsList']//tr//td[text()='" + code + "']/..//following-sibling::td[@class='user-action']//i[2]";
        String xpath = "//div[@id='sessionCustomfields']//table//tbody//tr//td[2][text()='" + code + "']/..//td[@class='user-action']//i[3]";
        click(browser.findElement(By.xpath(xpath)));

        logReport("Custom field copy button clicked successfully");

        VerifyAngularHasFinishedProcessing(10);
        VerifyAjaxRequestsFinished(30);

        Thread.sleep(1000);

        return new AddNewCustomFields(browser);
    }

    public void searchAndClickOnDeleteCustomFieldByCode(String code) throws Exception {
        type(CUSTOM_FIELDS_SEARCH_BOX, code, true);
        logReport("Entered code value " + code + " in the search box");
        Wait(SEARCH_CUSTOM_FIELD_BUTTON, 20);
        clickByJavaScript(SEARCH_CUSTOM_FIELD_BUTTON);
        logReport("Custom field search button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);

        String xpath = "//div[@id='sessionCustomfields']//table//tbody//tr//td[2][text()='" + code + "']/..//td[@class='user-action']//i[2]";
        click(browser.findElement(By.xpath(xpath)));

        logReport("Custom field delete button clicked successfully");

        switchToLatestTabOrWindow();
        click(DELETE_OK_BUTTON);
        switchToLatestTabOrWindow();
        logReport("Custom Field " + code + " is deleted successfully");

    }

    public void clickMassActionButton() throws Exception {
        Wait(MASS_ACTION_BUTTON, 20);
        clickByJavaScript(MASS_ACTION_BUTTON);
        logReport("Mass action button clicked successfully");
    }

    public void checkSelectAllSessionsCheckbox() {
        checkByJavascript(SELECTALL_CHK);
        logReport("Select all sessions checkbox checked successfully");
    }

    public void selectSessionBySessionCode(String sessionCode) throws Exception {
        //searchSessionBySessionCode(sessionCode);
        String xpath = "//tbody[@ng-repeat='session in sessionList']//td[4][text()='" + sessionCode + "']//preceding-sibling::td/input";
        WebElement element = browser.findElement(By.xpath(xpath));
        checkByJavascript(element);
        logReport("Select session by session code successfully " + sessionCode);
    }

    public void selectSessionStatusByMassAction(String status) throws Exception {
        Wait(MA_SESSIONSTATUS_BTN, 10);
        clickByJavaScript(MA_SESSIONSTATUS_BTN);
        VerifyAjaxRequestsFinished(20);
        for (WebElement e : MA_SESSIONSTATUS_ITEMS) {
            if (e.getText().trim().equalsIgnoreCase(status)) {
                clickByJavaScript(e);
                logReport("Selected session status by mass action " + status);
                break;
            }
        }
    }

    public String getMassActionAlertText() throws Exception {
       // Thread.sleep(2000);
        Wait(DELETE_ALERT_TEXT, 20);
        String message = DELETE_ALERT_TEXT.getText().trim();
        logReport("---------" + message);
        return message;
    }

    public String getMassActionPartsAlertText() throws Exception {
        Thread.sleep(2000);
        Wait(MA_ALERT_TEXT, 10);
        String message = MA_ALERT_TEXT.getText().trim();
        logReport("---------" + message);
        return message;
    }

    public void clickMassActionOkButton() throws Exception {
        Wait(MA_ALERT_OK, 10);
        clickByJavaScript(MA_ALERT_OK);
        logReport("Mass action alert ok button clicked successfully");
    }

    public void closeMassAction() {
        click(MASS_ACTION_CLOSE_BUTTON);
        logReport("Mass Action close button clicked successfully");
    }

    public void selectTrackByMassAction(String track) throws Exception {
        Wait(MA_TRACK_BTN, 10);
        clickByJavaScript(MA_TRACK_BTN);
        VerifyAjaxRequestsFinished(20);
        for (WebElement e : MA_TRACK_ITEMS) {
            if (e.getText().trim().equalsIgnoreCase(track)) {
                clickByJavaScript(e);
                logReport("Selected session track by mass action " + track);
                break;
            }
        }
    }

    public void selectSessionLevelByMassAction(String sessionLevel) throws Exception {
        Wait(MA_SESSIONLEVEL_BTN, 10);
        clickByJavaScript(MA_SESSIONLEVEL_BTN);
        VerifyAjaxRequestsFinished(20);
        for (WebElement e : MA_SESSIONLEVEL_ITEMS) {
            if (e.getText().trim().equalsIgnoreCase(sessionLevel)) {
                clickByJavaScript(e);
                logReport("Selected session level by mass action " + sessionLevel);
                break;
            }
        }
    }

    public void selectSessionTypeByMassAction(String type) throws Exception {
        Wait(MA_TYPE_BTN, 10);
        clickByJavaScript(MA_TYPE_BTN);
        VerifyAjaxRequestsFinished(20);
        for (WebElement e : MA_TYPE_ITEMS) {
            if (e.getText().trim().equalsIgnoreCase(type)) {
                clickByJavaScript(e);
                logReport("Selected session type by mass action " + type);
                break;
            }
        }
    }

    public void selectOverrideCapacityByMassAction(String capacity) throws Exception {
        Wait(MA_OVERRIDECAPACITY_BTN, 10);
        clickByJavaScript(MA_OVERRIDECAPACITY_BTN);
        VerifyAjaxRequestsFinished(20);
        for (WebElement e : MA_OVERRIDECAPACITY_ITEMS) {
            if (e.getText().trim().equalsIgnoreCase(capacity)) {
                clickByJavaScript(e);
                logReport("Selected override capacity by mass action " + capacity);
                break;
            }
        }
    }

    public void publishAttendeeTypeByMassAction(String attendees) throws Exception {
        Wait(MA_PUBLISHATTENDEETYPE_BTN, 10);
        click(MA_PUBLISHATTENDEETYPE_BTN);
        logReport("Publish attendee type button clicked");
        String xpath = "//input[@ng-checked='areAllPublishedAttendeeTypesSelected']";
        WebElement element = browser.findElement(By.xpath(xpath));
        if (attendees.equalsIgnoreCase("ALL")) {
            checkByJavascript(element);
        } else {
            uncheckByJavascript(element);
            String listAttendee[] = attendees.split(",");
            for (int i = 0; i < listAttendee.length; i++) {
                xpath = "//td[text()='" + listAttendee[i] + "']/..//input";
                element = browser.findElement(By.xpath(xpath));
                clickByJavaScript(element);
                logReport("Attendee type published by mass action " + attendees);
            }
        }
        clickByJavaScript(MA_UPDATEATTENDEETYPE_BTN);
        logReport("Update attendee type button clicked");
    }

    public List<String> getExportFileTypeList() throws Exception {
        List<String> fileTypeArray = new ArrayList<>();
        for (WebElement e : EXPORT_FILE_TYPE_LIST) {
            fileTypeArray.add(e.getText().trim());
        }
        return fileTypeArray;
    }

    public List<String> getExportCategoryTypeList() throws Exception {
        List<String> categoryTypeArray = new ArrayList<>();
        for (WebElement e : EXPORT_CATEGORY_TYPE_LIST) {
            categoryTypeArray.add(e.getText().trim());
        }
        return categoryTypeArray;
    }

    public void exportStandardSession(String fileType) throws Exception {
        selectExportFileType(fileType);
        logReport("File type : " + fileType + " sessions exported successfully.");
    }

    public void exportConferenceSession(String categoryType, String fileType) throws Exception {
        selectExportCategoryType(categoryType);
        selectExportFileType(fileType);
        logReport("Category type : " + categoryType + " and File type : " + fileType + " sessions exported successfully.");
    }

    public void selectExportFileType(String fileType) throws Exception {
        String xpath = "//label[contains(.,'" + fileType + "')]//input";
        WebElement element = browser.findElement(By.xpath(xpath));
        click(element);
        logReport("File type : " + fileType + " radio button clicked successfully ");
    }

    public void selectExportCategoryType(String categoryType) throws Exception {
        String xpath = "//label[contains(.,'" + categoryType + "')]//input";
        WebElement element = browser.findElement(By.xpath(xpath));
        click(element);
        logReport("Category type : " + categoryType + " radio button clicked successfully ");
    }

    public void clickOnExportButton() throws Exception {
        click(HEADER_EXPORT_BUTTON);
        wait(10);
        logReport("Export button clicked successfully");
    }

    public void clickOnExportDownloadButton() throws Exception {
        click(EXPORT_DOWNLOAD_BUTTON);
        wait(10);
        logReport("Export Download button clicked successfully");
    }

    public void closeImportAction() {
        click(IMPORT_CLOSE_BUTTON);
        logReport("Import Action close button clicked successfully");
    }

    public void clickOnDownloadExistingSessionsLink() throws Exception{
        click(DOWNLOAD_EXISTING_SESSIONS_LINK);
        wait(30);
        logReport("DOWNLOAD_EXISTING_SESSIONS button clicked successfully");
    }

    public void clickOnDownloadExistingSessionsOccurrenceLink() throws Exception {
        click(DOWNLOAD_EXISTING_SESSIONS_OCCURRENCE_LINK);
        wait(30);
        logReport("DOWNLOAD_EXISTING_SESSIONS_OCCURRENCE button clicked successfully");
    }

    public SessionImportPage clickImportButtonNew() throws Exception {
        Wait(HEADER_IMPORT_BUTTON, 20);
        clickByJavaScript(HEADER_IMPORT_BUTTON);
        logReport("Import button clicked successfully");
        switchToLatestTabOrWindow();
        return new SessionImportPage(browser);
    }

    public boolean isPipeSignPresent(String value) throws Exception {
        boolean found = false;

        if (value.contains("|")) {
            found = true;
        } else {
            found = false;
        }

        return found;

    }

    public AttendeeListPage clickLinkAndOpenAttendeePopupForStandardSession(String column, String value, String sessionCode) throws Exception {

        if (isLinkClickableInInstanceViewStandardLayout(column, value, sessionCode)) {
            // String xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//tr//td[3][text()='" + sessionCode + "']//following-sibling::td[" + value + "]";
            if (column.equalsIgnoreCase("Capacity")) {
                column = "Cap";
            } else if (column.equalsIgnoreCase("Registered")) {
                column = "Reg";
            } else if (column.equalsIgnoreCase("Waitlisted")) {
                column = "Wait";
            }
            int i = getColumnIndex(HEADERS_LIST, column);
            String xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//td[3][contains(.,'" + sessionCode + "')]/../td[" + i + "]//span[text()='" + value + "']";
            WebElement input = browser.findElement(By.xpath(xpath));
            click(input);
            logReport("Linked clicked successfully");
        }
        return new AttendeeListPage(browser);
    }

    public boolean isLinkClickableForStandardSession(String sessionCode, String value) throws Exception {
        String xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//tr//td[3][text()='" + sessionCode + "']//following-sibling::td[" + value + "]";
        WebElement input = browser.findElement(By.xpath(xpath));
        Boolean checked = isAttribtuePresent(input, "x-ng-click");
        return checked;
    }

    public String getStartDateTimeText(String sessionCode) {
        String xpath = "//tbody[@ng-repeat='sessionInstance in instanceList']//tr//td[3][text()='" + sessionCode + "']//following-sibling::td[2]";
        WebElement input = browser.findElement(By.xpath(xpath));
        return input.getText().trim();
    }

    public void  getFileFromRemoteLocation(String data, String location) throws Exception {


        OutputStream output = null;
        try {
            output = new FileOutputStream(new File(location));
            output.write(data.getBytes(), 0, data.length());
        } catch (Exception e) {

        }finally{
            try {
                output.close();
            } catch (Exception e) {

            }
        }
    }

    public String getDownloadedFileData() throws Exception {
        openNewTab("chrome://downloads");
        Object a = executeJavascript("return downloads.Manager.get().items_[0].file_path");
        browser.get("file:///" + a.toString());
        String result = browser.findElement(By.tagName("body")).getText();
        logReport("Data From Downloaded File" + result);

        return result;
    }

    public SessionReviewsPage clickSessionReviewTab() throws Exception {
        Wait(SESSIONREVIEW_TAB, 30);
        click(SESSIONREVIEW_TAB);
        logReport("Session review tab clicked successfully");
        return new SessionReviewsPage(browser);

    }

    public CatalogListPage clickCatalogListTab() throws Exception {
        Wait(CATALOGLIST_TAB, 30);
        click(CATALOGLIST_TAB);
        logReport("Catalog list tab clicked");
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(30);
        return new CatalogListPage(browser);
    }
}


