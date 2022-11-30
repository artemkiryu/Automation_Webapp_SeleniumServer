package pageObjects;

import globals.WebGlobals;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.sqlite.util.StringUtils;
import pageObjects.Accommodation.BlocksPage;
import pageObjects.AccountSettings.AccountSettingsPage;
import pageObjects.Appointments.AppointmentsOverviewPage;
import pageObjects.Badges.BadgesPage;
import pageObjects.Communication.EventEmailTemplatePage;
import pageObjects.EventRegistrations.EmailPage;
import pageObjects.EventRegistrations.RegistrationAgendaPage;
import pageObjects.EventSetup.*;
import pageObjects.EventWebsites.WebSitesPage;
import pageObjects.Events.EventDashboardPage;
import pageObjects.Events.EventListPage;
import pageObjects.Events.EventOptionsPage;
import pageObjects.Events.EventSetupPage;
import pageObjects.Forms.FormListPage;
import pageObjects.Forms.FormPreviewHomePage;
import pageObjects.Forms.LogicRulesListPage;
import pageObjects.Groups.AddRegistrationForGroup;
import pageObjects.Groups.GroupListPage;
import pageObjects.SignalDataIntegration.CertainIntegrationsPage;
import pageObjects.Implementation.*;
import pageObjects.Management.*;
import pageObjects.Mobile.BasicSettingsPage;
import pageObjects.Planning.OverviewPage;
import pageObjects.Profiles.ProfilesSearchPage;
import pageObjects.Registration.*;
import pageObjects.Reports.CommonReportsPage;
import pageObjects.Sessions.SessionIndustriesPage;
import pageObjects.Sessions.SessionJobFunctionsPage;
import pageObjects.Sessions.SessionsListPage;
import pageObjects.SpeakerPortal.SpeakerPortalAdminPage;
import pageObjects.Travel.TravelConfigurationPage;
import pageObjects.User.UserInformationPage;
import pojo.SectionHeader;

import java.io.*;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static pageObjects.SubAccount.SubAccountsPage.ACCOUNT_OPTIONS_LIST;

/**
 * Created by infoobjects on 6/28/2017.
 */
public class CommonActionsPage extends WebGlobals {

    public static final By RELEASE_NOTES_DONT_SHOW_BUTTON = By.xpath("//div[@class='panel-footer']//button");
    public static final By NOTIFICATION_DONT_SHOW_BUTTON = By.xpath("//button[@id='userNotification']");
    @FindBy(xpath = "//input[@id='submitForm']")
    public static WebElement SAVE_BUTTON;
    @FindBy(xpath = "//a[@title='Event Dashboard']")
    public WebElement EVENT_DASHBOARD_LINK;
    @FindBy(xpath = "//input[@title='Submit this form and save any changes']")
    public static WebElement SAVE_BUTTON_FORM;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Registration form setup.']")
    public WebElement SETUP_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Form entry page (optional).']")
    public static WebElement ENTRY_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Registrant details section of form.']")
    public static WebElement REGISTRANT_DETAILS_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Attendee type and status section.']")
    public static WebElement ATTENDEE_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Questions']")
    public static WebElement QUESTIONS_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Section to verify/edit registration information.']")
    public static WebElement VERIFY_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Financial setup and payment options section.']")
    public static WebElement PAYMENT_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Registration confirmation page.']")
    public static WebElement CONFIRM_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Settings for attendee appointment preferences.']")
    public static WebElement APPOINTMENTS_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Settings for attendee rotations.']")
    public static WebElement ROTATIONS_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Event accommodations and hotel information section.']")
    public static WebElement ACCOMMODATIONS_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Travel and transportation section.']")
    public static WebElement TRAVEL_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Options for guest registrations on a single form.']")
    public static WebElement ADDL_REGS_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Logic']")
    public WebElement LOGICS_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Custom HTML sections.']")
    public static WebElement CUSTOM_HTML_TAB;
    @FindBy(xpath = "//textarea[@name='instructions']")
    public static WebElement TEXT_ABOVE_HEADER;
    @FindBy(xpath = "//input[@name='headerText']")
    public static WebElement HEADER_TEXT;
    @FindBy(xpath = "//textarea[@name='pageHTML']")
    public static WebElement TEXT_BELOW_HEADER;
    @FindBy(xpath = "//a[@title='Forms']")
    public static WebElement FORMS_LINK;
    //Form's sub tabs
    @FindBy(xpath = "//a[@title='List of online registration forms for this event.']")
    public WebElement FORM_LINK;
    @FindBy(xpath = "//a[@title='User and Account Settings']")
    public WebElement userAccountDropdown;
    @FindBy(xpath = "//a[@class='setup']//i")
    public WebElement accountSettingsLinkTop;

    //Manage Tabs
    @FindBy(xpath = "//a[@title='Manage your event.']")
    public WebElement MANAGE_LINK;
    @FindBy(xpath = "//a[@title='Registration data.']")
    public WebElement REGISTRATIONS_LINK;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Tags']")
    public WebElement tagsTab;
    @FindBy(xpath = "//a[@title='Speakers and Sessions']")
    public WebElement SPEAKER_SESSION_MENUITEM;

    @FindBy(xpath = "//div[@id='drilldown-nav']//a[@title='Speaker Portal']")
    public WebElement SPEAKER_PORTAL_MENUITEM;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Industries']")
    public WebElement INDUSTRY_LIST_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Job Functions']")
    public WebElement JOB_FUNCTION_LIST_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Speaker Types']")
    public WebElement SPEAKER_TYPES_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Tracks']")
    public WebElement TRACK_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Locations']")
    public WebElement LOCATION_TAB;
    @FindBy(xpath = ("//a[@title='Promote your event.']"))
    public WebElement promoteMenuDropDown;
    @FindBy(xpath = ("//a[@title='Create Communication templates .']"))
    public WebElement communicationMenuLink;
    @FindBy(xpath = ("//a[text()='Email Templates']"))
    public WebElement emailTemplateMenu;
    @FindBy(xpath = ("//div[@id='sidebar-wrapper']//a[text()='Speaker Email Templates']"))
    public WebElement emailSpeakerTemplateMenu;
    @FindBy(xpath = ("//div[@id='sidebar-wrapper']//a[text()='Scheduled Emails']"))
    public WebElement scheduleEmailMenu;
    @FindBy(xpath = ("//div[@id='sidebar-wrapper']//a[text()='Personal Documents']"))
    public WebElement personalDocumentsMenu;
    @FindBy(xpath = ("//div[@id='sidebar-wrapper']//a[text()='Upload Document Templates']"))
    public WebElement uploadDocumentTemplatesMenu;
    @FindBy(xpath = ("//div[@id='sidebar-wrapper']//a[text()='Printable Confirmations']"))
    public WebElement printableConfirmationsMenu;
    @FindBy(xpath = ("//div[@id='sidebar-wrapper']//a[text()='Itinerary']"))
    public WebElement itineraryMenu;
    @FindBy(xpath = ("//div[@id='sidebar-wrapper']//a[text()='Invoices']"))
    public WebElement invoicesMenu;
    @FindBy(xpath = ("//div[@id='sidebar-wrapper']//a[text()='Custom Blocks']"))
    public WebElement customBlocksMenu;
    @FindBy(xpath = ("//div[@id='sidebar-wrapper']//a[text()='Display Rules']"))
    public WebElement displayRulesMenu;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Speakers']")
    public WebElement SPEAKER_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Sessions']")
    public WebElement SESSION_TAB;
    @FindBy(xpath = "//a[@title='Grid Scheduler']")
    public WebElement GRID_SCHEDULER_LINK;
    @FindBy(xpath = "//a[@title='Badges and Barcodes']")
    public WebElement BADGE_SUBMENUITEM;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Badges']")
    public WebElement BADGES_TAB;
    @FindBy(xpath = "//a[@title='Plan your event.']")
    public WebElement PLAN_DROPDOWN;
    @FindBy(xpath = "//a[@title='Event Configuration']")
    public WebElement CONFIGURE_LINK_PLAN_DROPDOWN;
    @FindBy(xpath = "//a[@title='List of websites for this event.']")
    public WebElement WEBSITED_DROPDOWN;
    @FindBy(xpath = "//a[@class='survey-module list-group-item ']")
    public WebElement EVENT_QUESTION_TAB;

    @FindBy(xpath = "//label[@ng-if='section.customFieldId == null']")
    public List<WebElement> LAYOUT_CONFIGURED_STANDARDFIELDS_LIST;
    @FindBy(xpath = "//div[@class='ui-pnotify-closer']")
    public WebElement MESSAGE_CLOSE_BUTTON;

    @FindBy(xpath = "//span[@class='close close-modal']")
    public WebElement MESSAGE_CLOSE_ICON;

    @FindBy(xpath = "//label[@ng-if='section.customFieldId != null']")
    public List<WebElement> LAYOUT_CONFIGURED_CUSTOMFIELDS_LIST;

    @FindBy(xpath = ("//input[@value='Preview']"))
    public WebElement PREVIEW_BUTTON;

    @FindBy(xpath = "//div[@role='tabpanel'][@id='main']")
    public WebElement SCROLL_IMAGES;

    @FindBy(xpath = ("//input[@value='Continue']"))
    public WebElement CONTINUE_BUTTON;

    @FindBy(xpath = "//a[@title='Menu']")
    public WebElement MENU_LINK;

    @FindBy(xpath = "//a[@class='events-module']//i")
    public WebElement EVENTS_OPTION;

    @FindBy(xpath = "//a[@class='profiles-module']//i")
    public WebElement PROFILES_OPTION;

    @FindBy(xpath = "//a[@title='Setup event information']")
    public WebElement EVENT_SETUP_MENUITEM;

    @FindBy(xpath = "//button[@ng-click='editEvent()']")
    public WebElement EVENT_DETAILS_BUTTON;

    @FindBy(xpath = "//a[@title='Travel']")
    public WebElement TRAVEL_LINK;

    @FindBy(xpath = "//a[contains(.,'PROMO CODES')]")
    public WebElement PROMO_CODE_LINK;

    @FindBy(xpath = "//a[@title='Engage your attendees.']")
    public WebElement ENGAGE_LINK;

    //Planning Page
    @FindBy(xpath = "//a[@title='Event planning tools']")
    public WebElement PLANNING_LINK;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='View General Ledger data']")
    public WebElement OVERVIEW_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Manage General Ledger data']")
    public WebElement BUDGET_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Event Tasks']")
    public WebElement TASKS_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Documents']")
    public WebElement DOCUMENTS_TAB;

    //Groups Tab
    @FindBy(xpath = "//a[@title='Group management.']")
    public WebElement GROUPS_VIA_PLAN_DROPDOWN;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='List of Groups']")
    public WebElement GROUP_LIST_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Custom Group Fields']")
    public WebElement CUSTOM_FIELDS_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Assign Groups to EventRegistrations']")
    public WebElement ASSIGN_GROUPS_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Group Overview for this event']")
    public WebElement REPORTS_GROUPS_TAB;

    //Management Tab
    @FindBy(xpath = "//a[@title='Management settings for this account.']")
    public WebElement MANAGEMENT_TAB;

    @FindBy(xpath = "//button[contains(text(),'Show Again')]")
    public WebElement SESSION_DONT_SHOW_BUTTON;

    @FindBy(xpath = "//a[@title='Management settings for this account.']")
    public WebElement ManagementDropdownLink;
    @FindBy(xpath = "//a[@title='Create and edit tags for this account']")
    public WebElement ManagementTagsDropdownLink;

    @FindBy(xpath = "//a[@title='Management Overview in the current account.']")
    public WebElement MANAGEMENT_LINK;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Management Overview in the current account.']")
    public WebElement MANAGEMENT_OVERVIEW_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Define the custom data fields to collect for all events in this account']")
    public WebElement EVENT_DATA_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Create and edit custom roles']")
    public WebElement ROLES_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Define general ledger account numbers. names and details for this account']")
    public WebElement GENERAL_LEDGER_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Create and edit tags for this account (to apply to agenda items and sessions)']")
    public WebElement TAGS_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Create and edit a list of job functions for use in Speaker and Session Management in this account']")
    public WebElement JOB_FUNCTIONS_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Industries']")
    public WebElement INDUSTRIES_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Configure single sign-on options for use in this account']")
    public WebElement SINGLE_SIGN_ON_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Assign tags to Standard Registration Statuses']")
    public WebElement REGISTRATION_STATUSES_TAB;

    @FindBy(xpath = "//li[@data-submenu-id='submenu-admin_manage-regStatuses']//a[@title='Assign tags to Standard Registration Statuses']")
    public WebElement REGISTRATION_STATUSES_TAB_NEW;

    @FindBy(xpath = "//a[@title='Appointment management.']")
    public WebElement APPOINTMENTS_LINK;

    @FindBy(xpath = "//div[@class='ui-pnotify stack-custom ui-pnotify-fade-normal ui-pnotify-mobile-able ui-pnotify-in ui-pnotify-fade-in ui-pnotify-move']//div[@class='ui-pnotify-text']")
    public WebElement MESSAGE_TEXT;

    @FindBy(xpath = "//a[@title='Single Sign-On']")
    public WebElement SINGLE_SIGNON_LINK;

    @FindBy(xpath = "//input[@id='mass-action-go']")
    public WebElement GO_BUTTON;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Custom Statuses']")
    public WebElement CUSTOM_STATUS_TAB;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Attendee Types')]")
    public WebElement ATTENDEE_TYPE_TAB;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Packages')]")
    public WebElement PACKAGES_TAB;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Suppliers')]")
    public WebElement SUPPLIER_TAB;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Financials')]")
    public WebElement FINANCIAL_TAB;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Default Confirmation')]")
    public WebElement DEFAULT_CONFIRMATION_TAB;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Agenda')]")
    public WebElement AGENDA_TAB;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Email')]")
    public WebElement EMAIL_TAB;

    @FindBy(xpath = "//a[@title='Engage your attendees.']")
    public WebElement ENGAGE_MENU_ITEM;

    @FindBy(xpath = "//a[@title='Plan your event.']")
    public WebElement PLAN_MENU_LINK;

    @FindBy(xpath = "//a[@title='Accommodation']")
    public WebElement ACCOMMODATION_MENUITEM;

    @FindBy(xpath = "//a[@title='Mobile Dashboard']")
    public WebElement MOBILE_MENU_ITEM;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Speaker Portal']")
    public WebElement SPEAKER_PORTAL_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Sessions']")
    public WebElement SESSIONS_TAB;

    //Administration Tab
    @FindBy(xpath = "//a[@title='User and Account settings for this account.']")
    public WebElement ADMINISTRATION_DROPDOWN;

    @FindBy(xpath = "//ul[@class='dropdown-menu drill-down']//a[@title='Add and edit users for this account']")
    public WebElement ADMINISTRATION_USER_MENU_ITEM;

    //Registration Tab
    @FindBy(xpath = "//a[@title='Registration settings for this account.']")
    public WebElement REGISTRATION_DROPDOWN;
    @FindBy(xpath = "//a[@title='Registration Overview of account setup.']")
    public WebElement REGISTRATION_OVERVIEW_MENU_ITEM;
    @FindBy(xpath = "//a[@title='Define the custom data fields to collect for all profiles in the current account']")
    public WebElement REGISTRATION_PROFILE_DATA_MENU_ITEM;
    @FindBy(xpath = "//a[@title='Configure account financial settings, ecommerce accounts, and tax code settings for this account']")
    public WebElement REGISTRATION_FINANCIAL_DATA_MENU_ITEM;
    @FindBy(xpath = "//a[@title='Configure printable confirmation templates for this account']")
    public WebElement REGISTRATION_PRINTABLE_CONFIRMATIONS_MENU_ITEM;
    @FindBy(xpath = "//a[@title='Configure event-creation modes for this account']")
    public WebElement REGISTRATION_EVENT_CREATION_MENU_ITEM;
    @FindBy(xpath = "//a[@title='Configure invoices for this account']")
    public WebElement REGISTRATION_INVOICES_MENU_ITEM;
    @FindBy(xpath = "//a[@title='Select the fields affected by reformatting options (which are set per event)']")
    public WebElement REGISTRATION_DATA_FORMAT_MENU_ITEM;

    //Reports Tab
    @FindBy(xpath = "//a[@title='View reports for the current account.']")
    public WebElement REPORTS_TAB;

    //Implementation
    @FindBy(xpath = "//a[@title='Implementation settings for this account.']")
    public WebElement IMPLEMENTATION_TAB;
    @FindBy(xpath = "//a[@title='Select the products available to this account']")
    public WebElement IMPLEMENTATION_PRODUCTS_MENU_ITEM;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Configure security and other settings for this account']")
    public WebElement IMPLEMENTATION_SECURITY_MENU_ITEM;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='View or download the history log for this account']")
    public WebElement IMPLEMENTATION_HISTORY_MENU_ITEM;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='1.0 api key generation and usage history for this account']")
    public WebElement IMPLEMENTATION_API_MENU_ITEM;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Configure the Salesforce connection for this account']")
    public WebElement IMPLEMENTATION_SALESFORCE_MENU_ITEM;
    @FindBy(xpath = "//div[@id='drilldown-nav']//a[@title='Configure plugins for Marketo, Eloqua, and multiple SSO providers']")
    public WebElement IMPLEMENTATION_PLUGINS_MENU_ITEM;
    @FindBy(xpath = "//button[@id='navigationHam']")
    public WebElement NAVIGATION_MENU;
    @FindBy(xpath = "//a[@title='configure integration flow for Marketo, Eloqua, Salesforce, and other marketing automation providers']")
    public WebElement IMPLEMENTATION_IF_MENU_ITEM;

    @FindBy(xpath = "//li[@id='module.id']//span")
    public List<WebElement> LIST_MENU_ITEMS;

    @FindBy(xpath = "//a[@id='accountDropdown']//div[@class='actSelector']")
    public WebElement accountSelector;
    @FindBy(xpath = "//iframe[@id='accountSelectorFrame']")
    public WebElement accountFrame;
    @FindBy(xpath = "//input[@ng-model='searchTerm']")
    public WebElement accountSearchTextbox;
    @FindBy(xpath = "//span[@class='bold underline']")
    public WebElement accountOptionsList;

    //Quick search
    @FindBy(xpath = "//a[@title='Search']")
    public WebElement QUICK_SEARCH_ICON;
    @FindBy(xpath = "//a[@value='Registrations']")
    public WebElement REGISTRATIONS_QUICK_SEARCH;
    @FindBy(xpath = "//a[@value='Profiles']")
    public WebElement PROFILES_QUICK_SEARCH;

    //Reports/Analyze
    @FindBy(xpath = "//a[@title='Event level reports.']")
    public WebElement REPORTS_ANALYZE_MENU;

    @FindBy(xpath = "//button[contains(.,'Event Details')]")
    public WebElement EVENT_DETAILS_BUTTON_DASHBOARD;


    public CommonActionsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public CommonActionsPage() {

    }

    /**
     * This method shall scroll up the web page
     */
    public void scrollUp() {
        logReport("Scrolling up till the top of the page");
        executeJavascript("window.scrollTo(document.body.scrollHeight,0); return true");
    }

    public void scrollDown() {
        logReport("Scrolling up till the Down of the page");
        executeJavascript("window.scrollTo(0,document.body.scrollHeight); return true");
    }

    public SpeakerPortalAdminPage clickSpeakerPortalTab() throws Exception {
        Wait(SPEAKER_PORTAL_TAB, 30);
        clickByJavaScript(SPEAKER_PORTAL_TAB);
        logReport("Speaker portal tab clicked successfully");
        VerifyAngularHasFinishedProcessing(30);
        VerifyAjaxRequestsFinished(20);
        return new SpeakerPortalAdminPage(browser);
    }
    public AccountSettingsPage clickAccountSettingFromDropDown() throws Exception{
        Thread.sleep(5000);
        clickByJavaScript(userAccountDropdown);
        accountSettingsLinkTop.click();
        return  new AccountSettingsPage(browser);
    }

    public LogicRulesListPage clickLogicTab() throws Exception {
        Wait(LOGICS_TAB, 20);
        clickByJavaScript(LOGICS_TAB);
        logReport("Logics tab clicked successfully");
        VerifyAjaxRequestsFinished(20);
        VerifyPageReady(20);
        return new LogicRulesListPage(browser);
    }

    public void waitForWindowToDispose() throws Exception {
        int timeIterator = 1;
        while (getWindowHandles().size() > 1 && timeIterator <= 30) {
            logReport("Counter value = " + timeIterator);
            timeIterator++;

        }
        logReport("Window already disposed");
        switchToLatestTabOrWindow();
    }

    public String sortAndConvertString(String name) {
        String a[] = name.split("\\|");
        List<String> tagsList = new ArrayList<>();
        for (String s : a) {
            tagsList.add(s);
        }
        Collections.sort(tagsList);
        String tags = StringUtils.join(tagsList, "|");
        logReport("Tags values " + tags);
        return tags;
    }

    public void clickDontShowButtonIfPresent() throws Exception {
        clickNotificationDontShowButtonIfPresent();
        try {

            if (verifyElementDisplayed(RELEASE_NOTES_DONT_SHOW_BUTTON, 2)) {
                browser.findElement(RELEASE_NOTES_DONT_SHOW_BUTTON).click();
                waitForWindowToDispose();
                switchToLatestTabOrWindow();
            }
        } catch (TimeoutException e) {
        }

    }

    public void clickNotificationDontShowButtonIfPresent() throws Exception {
        try {

            if (verifyElementDisplayed(NOTIFICATION_DONT_SHOW_BUTTON, 2)) {
                WebElement element = browser.findElement(NOTIFICATION_DONT_SHOW_BUTTON);
                clickByJavaScript(element);
                logReport("Notification dont show button clicked successfully");
                waitForWindowToDispose();
                switchToLatestTabOrWindow();
            }
        } catch (TimeoutException e) {
        }
    }

    public static String getDateFromOneZoneToAnother(String date, String destZone, String sourcedateFormat, String destDateFormat) throws Exception {
        //Date date = new Date();

        // String sDate1="01/21/2019 10:30 AM";

        Date date1 = new SimpleDateFormat(sourcedateFormat).parse(date);

        logReport(date1.getTimezoneOffset() + " value of int");
        logReport(date + "\t" + date1);
        return formatDateToString(date1, destDateFormat, destZone);


    }

    public static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }

    /**
     * Method to returns current date by using timezone
     *
     * @return currentDate
     */
    public String getCurrentDate() {
        Date dt = new Date();
        SimpleDateFormat DtFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-8"));
        DtFormat.setTimeZone(cal.getTimeZone());
        String currentDate = DtFormat.format(dt);
        logReport(currentDate);
        return currentDate;
    }

    public String addDaysInDate(String dateValue, Integer days, String pattern) throws Exception {
        String convertedDate;
        SimpleDateFormat DtFormat = new SimpleDateFormat(pattern);
        Calendar cal = Calendar.getInstance();
        cal.setTime(DtFormat.parse(dateValue));
        cal.add(Calendar.DATE, days);
        convertedDate = DtFormat.format(cal.getTime());
        logReport("Current date by no of days " + convertedDate);
        return convertedDate;
    }
    /**
     * Method to returns current time by using timezone
     *
     * @return currentTime
     */

    public String getcurrentTime(){
      /*  SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm a");
      *//* Setting the Timezone *//*
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-8"));
        dateFormat.setTimeZone(cal.getTimeZone());
      *//* Picking the time value in the required Format *//*
        String currentTime = dateFormat.format(cal.getTime());
        logReport("get current time is " + currentTime);*/

        Date date = new Date(System.currentTimeMillis()+2*60*1000);
        date.setDate(date.getDate());
        SimpleDateFormat df = new SimpleDateFormat("HH:mm a");
        String currentTime = df.format(date);
        return currentTime;
    }

    /**
     * Method to get date by adding no of days
     *
     * @param noOfDays value of no of days
     * @return convertedDate
     * @throws Exception
     */
    public String getDateByDays(Integer noOfDays) throws Exception {
        String currentDate, convertedDate;
        Date dt = new Date();
        SimpleDateFormat DtFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-7"));
        DtFormat.setTimeZone(cal.getTimeZone());
        currentDate = DtFormat.format(dt);
        cal.setTime(DtFormat.parse(currentDate));
        cal.add(Calendar.DATE, noOfDays);
        convertedDate = DtFormat.format(cal.getTime());
        logReport("Current date by no of days " + convertedDate);
        return convertedDate;
    }

    public void setElementAttribute(WebElement element, String value) {
        executeJavascript("arguments[0].setAttribute('class', '" + value + "')", element);

    }
    public boolean isAlertPresent() {
        /*WebDriverWait wait = new WebDriverWait(webDriver, 1);
        if(wait.until(ExpectedConditions.alertIsPresent())==null)
            return false;
        else
            return true;*/
        try {
            browser.switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public String getAlertMessageText() {
        Alert alert = browser.switchTo().alert();
        logReport("" + alert.getText().trim());
        return alert.getText().trim();
    }
    public void clickEmailTemplateMenu() throws Exception{
        VerifyAjaxRequestsFinished(30);
        emailTemplateMenu.click();
        logReport("EmailTemplate Menu is clicked successfully in Communication page");


    }

    public void rightClick(WebElement element) {
        Actions builder = new Actions(driver);

        // Perform Right Click on  MEN and  Open "Men" content in a new tab
        builder.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

    }
    public void openTab() {
        browser.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");

    }

    public void closeMessage() {
        if (verifyElementDisplayed(MESSAGE_CLOSE_BUTTON, 2)) {
            click(MESSAGE_CLOSE_BUTTON);
            logReport("Message close button clicked successfully");
        }
    }

    public String reName () {

        String uniqueCode = "File"+String.valueOf(System.currentTimeMillis())+".txt";
        logReport(uniqueCode);
        File folder = new File("src/test/resources/files/");
        logReport(folder.getAbsolutePath());

        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };
        File[] listOfFiles = folder.listFiles(textFilter);
        String file1;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                file1 = listOfFiles[i].toString();
                File oldName = new File(file1);
                File newName = new File("src/test/resources/files/"+uniqueCode);

                if (oldName.renameTo(newName)) {
                    logReport("File Renamed to" +uniqueCode);
                } else {
                    logReport("Error while File Rename");
                }

                break;

            }

        }
        return uniqueCode;

    }

    /**
     * Method to wait for pop up window to appear
     *
     * @throws Exception
     */
    public void waitForWindowToAppear() throws Exception {
        int timeIterator = 1;
        logReport("Current Window Handles : " + browser.getWindowHandles());
        while (browser.getWindowHandles().size() <= 1 && timeIterator <= 30) {
            Thread.sleep(1000);
            timeIterator++;
            logReport("Counter value = " + timeIterator);
            logReport("Current Window Handles : " + browser.getWindowHandles());
        }
        logReport("Window already Opened");
        Thread.sleep(2000);
    }

    public void clickSaveButtonCommon() throws Exception {
        click(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
    }

    public void clickSetupTab() throws Exception {
        Wait(SETUP_TAB, 20);
        click(SETUP_TAB);
        logReport("Setup tab clicked successfully");
        VerifyAjaxRequestsFinished(20);
        VerifyPageReady(20);
    }

    //For Section Header

    public void enterTextAboveHeader(String aboveHeaderText)throws Exception{
        Wait(TEXT_ABOVE_HEADER, 30);
        type(TEXT_ABOVE_HEADER, aboveHeaderText, true);
        logReport("Entered Value: " + aboveHeaderText + " in 'text above header' TextBox");
    }

    public void enterHeaderText(String headerText)throws Exception{
        Wait(HEADER_TEXT, 30);
        type(HEADER_TEXT, headerText, true);
        logReport("Entered Value: " + headerText + " in 'header text' TextBox");
    }

    public void enterTextBelowHeader(String belowHeaderText)throws Exception{
        Wait(TEXT_BELOW_HEADER, 30);
        type(TEXT_BELOW_HEADER, belowHeaderText, true);
        logReport("Entered Value: " + belowHeaderText + " in 'text below header' TextBox");
    }



    // Forms tab
    public void clickOnFormsTab(WebElement webElement) throws Exception{
        Wait(webElement, 30);
        click(webElement);
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
    }


    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) browser);
        js.executeScript(
                "arguments[0].scrollIntoView(true);", element);
        try {
            wait(2);
        } catch (Exception e) {
        }

    }


    public void checkByJavascript(WebElement checkBox) {
        log("Check the checkbox.");
        if (!checkBox.isSelected())
            clickByJavaScript(checkBox);
    }

    public EventOptionsPage clickConfigureFromPlanDropdown() throws Exception {
        Wait(PLAN_DROPDOWN, 30);
        clickByJavaScript(PLAN_DROPDOWN);
        Wait(CONFIGURE_LINK_PLAN_DROPDOWN, 30);
        click(CONFIGURE_LINK_PLAN_DROPDOWN);
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        return new EventOptionsPage(browser);
    }

    public EventSetupPage clickPlanEventSetupMenuItem() throws Exception {
        VerifyPageReady(30);
        Wait(PLAN_DROPDOWN, 30);
        clickByJavaScript(PLAN_DROPDOWN);
        logReport("Clicked on 'Plan' menu item.");
        Wait(EVENT_SETUP_MENUITEM, 30);
        click(EVENT_SETUP_MENUITEM);
        logReport("Clicked on 'Event setup' menu item.");
        VerifyPageReady(30);
        //click(EVENT_DETAILS_BUTTON);
        VerifyAngularHasFinishedProcessing(30);
        VerifyAjaxRequestsFinished(30);
        Wait(EVENT_DETAILS_BUTTON_DASHBOARD, 30);
        click(EVENT_DETAILS_BUTTON_DASHBOARD);
        logReport("Event Details button clicked successfiully");
        VerifyAjaxRequestsFinished(10);
        VerifyAngularHasFinishedProcessing(10);
        return new EventSetupPage(browser);

    }

    public EventListPage clickEvents() throws Exception {
        VerifyPageReady(20);
        VerifyAjaxRequestsFinished(20);
        Wait(MENU_LINK, 20);
        clickByJavaScript(MENU_LINK);
        if (!verifyElementDisplayed(EVENTS_OPTION, 10)) {
            click(MENU_LINK);
            click(EVENTS_OPTION);
        } else {
            click(EVENTS_OPTION);
        }

        logReport("Clicked on Event Option");
        return new EventListPage(browser);
    }

    /**
     * Method for click travel link under plan menu item
     *
     * @return TravelConfigurationPage
     */

    public TravelConfigurationPage clickPlanAndTravelLink() throws Exception {
        VerifyPageReady(30);
        Wait(PLAN_DROPDOWN, 30);
        clickByJavaScript(PLAN_DROPDOWN);
        logReport("Clicked on 'Plan' menu item.");
        Wait(TRAVEL_LINK, 30);
        click(TRAVEL_LINK);
        logReport("Clicked on 'Travel' menu item.");
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(20);
        return new TravelConfigurationPage(browser);
    }

    /**
     * Method for clicking badge link under manage menu item
     *
     * @return BadgeLayoutsPage
     */
    public BadgesPage clickManageAndBadgesLink() throws Exception {
        VerifyAjaxRequestsFinished(20);
        VerifyPageReady(20);
        Wait(MANAGE_LINK, 20);
        click(MANAGE_LINK);
        Wait(BADGE_SUBMENUITEM, 20);
        click(BADGE_SUBMENUITEM);
        VerifyPageReady(20);
        return new BadgesPage(browser);
    }

    public void clickFormSaveButton()throws Exception{
        VerifyPageReady(30);
        Wait(SAVE_BUTTON_FORM, 30);
        click(SAVE_BUTTON_FORM);
        logReport("Successfully clicked on 'Save' button.");
    }

    public void fillSectionHeaderDetails(SectionHeader sectionHeaderData) throws Exception {

        Wait(SAVE_BUTTON_FORM, 30);
        VerifyAjaxRequestsFinished(30);
        if (TEXT_ABOVE_HEADER.isDisplayed() && TEXT_ABOVE_HEADER.getAttribute("value").isEmpty()) {
            enterTextAboveHeader(sectionHeaderData.getTextAboveHeader());

        }
        if (HEADER_TEXT.isDisplayed() && HEADER_TEXT.getAttribute("value").isEmpty()) {
            enterHeaderText(sectionHeaderData.getHeaderText());

        }
        if (TEXT_BELOW_HEADER.isDisplayed() && TEXT_BELOW_HEADER.getAttribute("value").isEmpty()) {
            enterTextBelowHeader(sectionHeaderData.getTextBelowHeader());

        }

    }

    public EventEmailTemplatePage clickCommunicationMenu() throws Exception {
        VerifyAjaxRequestsFinished(30);
        Wait(promoteMenuDropDown, 30);
        logReport("Wait for Promote Menu");
        clickByJavaScript(promoteMenuDropDown);
        logReport("Promote Menu clicked successfully in Communication page");
        Wait(communicationMenuLink, 30);
        logReport("Wait For Communication Menu");
        communicationMenuLink.click();
        logReport("Communication Menu clicked successfully in Communication page");


        return new EventEmailTemplatePage(browser);
    }

    public void uncheckByJavascript(WebElement checkBox) {
        log("Check the checkbox.");
        if (checkBox.isSelected())
            clickByJavaScript(checkBox);

    }

    public WebSitesPage clickWebsitesLinkUnderPromote() throws Exception {
        Wait(promoteMenuDropDown, 30);
        clickByJavaScript(promoteMenuDropDown);
        logReport("Promote link clicked successfully");
        Wait(WEBSITED_DROPDOWN, 10);
        click(WEBSITED_DROPDOWN);
        logReport("Website dropdown clicked successfully");
        return new WebSitesPage(browser);
    }

    /**
     * Method for clicking appointments from engage dropdown
     *
     * @return AppointmentsOverviewPage
     */
    public AppointmentsOverviewPage clickAppointmentsFromEngageDropdown() throws Exception {
        VerifyAjaxRequestsFinished(20);
        Wait(ENGAGE_LINK, 20);
        click(ENGAGE_LINK);
        Wait(APPOINTMENTS_LINK, 20);
        click(APPOINTMENTS_LINK);
        VerifyPageReady(20);
        return new AppointmentsOverviewPage(browser);
    }

    public CustomStatusesPage clickOnCustomStatusTab()throws Exception{
        VerifyPageReady(30);
        Wait(CUSTOM_STATUS_TAB, 20);
        click(CUSTOM_STATUS_TAB);
        logReport("Successfully clicked on 'Custom Status' tab.");
        return new CustomStatusesPage(browser);
    }

    public AttendeeTypePage clickOnAttendeeTypeTab() throws Exception{
        VerifyPageReady(30);
        Wait(ATTENDEE_TYPE_TAB, 30);
        click(ATTENDEE_TYPE_TAB);
        logReport("Successfully clicked on attendee type tab button.");
        return new AttendeeTypePage(browser);
    }

    public PackagesPage clickOnPackagesTab() throws Exception{
        VerifyPageReady(30);
        Wait(PACKAGES_TAB, 30);
        click(PACKAGES_TAB);
        logReport("Successfully clicked on packages tab.");
        return new PackagesPage(browser);
    }

  public CustomQuestionsPage clickOnQuestionsTab()throws Exception{
        VerifyPageReady(30);
        scrollIntoView(QUESTIONS_TAB);
        Wait(QUESTIONS_TAB, 30);
        click(QUESTIONS_TAB);
        logReport("Successfully clicked on questions tab.");
        return new CustomQuestionsPage(browser);
    }

    public EventSuppliersPage clickOnSupplierTab()throws Exception{
        VerifyPageReady(30);
        scrollIntoView(SUPPLIER_TAB);
        Wait(SUPPLIER_TAB, 30);
        click(SUPPLIER_TAB);
        logReport("Successfully clicked on 'Supplier' tab.");
        return new EventSuppliersPage(browser);
    }
    public EventFinancialPage clickOnFinancialsTab()throws Exception{
        VerifyPageReady(30);
        Wait(FINANCIAL_TAB, 30);
        clickByJavaScript(FINANCIAL_TAB);
        logReport("Successfully clicked on 'Finacial' tab.");
        return new EventFinancialPage(browser);
    }

    public DefaultConfirmationPage clickOnDefaultConfirmationTab()throws Exception{
        VerifyPageReady(30);
        scrollIntoView(DEFAULT_CONFIRMATION_TAB);
        Wait(DEFAULT_CONFIRMATION_TAB, 30);
        click(DEFAULT_CONFIRMATION_TAB);
        logReport("Successfully clicked on 'Default Confirmation' tab.");
        return new DefaultConfirmationPage(browser);

    }

    public TravelQuestionsPage clickOnTravelQuestionsTab()throws Exception{
        VerifyPageReady(30);
        scrollIntoView(TRAVEL_TAB);
        Wait(TRAVEL_TAB, 30);
        clickByJavaScript(TRAVEL_TAB);
        logReport("Successfully clicked on 'Travel' tab.");
        return new TravelQuestionsPage(browser);
    }

    public RegistrationAgendaPage clickOnRegistrationAgendaTab()throws Exception{
        VerifyPageReady(30);
        scrollIntoView(AGENDA_TAB);
        Wait(AGENDA_TAB, 30);
        clickByJavaScript(AGENDA_TAB);
        logReport("Successfully clicked on 'Agenda' tab.");
        return new RegistrationAgendaPage(browser);
    }

    public EmailPage clickOnRegistrationEmailTab()throws Exception{
        VerifyPageReady(30);
        scrollIntoView(AGENDA_TAB);
        Wait(AGENDA_TAB, 30);
        clickByJavaScript(AGENDA_TAB);
        logReport("Successfully clicked on 'Email' tab.");
        return new EmailPage(browser);
    }

    public boolean isFileExist(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    public void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    public String getCurrentDate(String pattern) {
        Date dt = new Date();
        SimpleDateFormat DtFormat = new SimpleDateFormat(pattern);
        Calendar cal = Calendar.getInstance();
        String currentDate = DtFormat.format(cal.getTime());
        logReport(currentDate);
        return currentDate;
    }

    /*public void deleteDirectoryContent()throws Exception{
        File dir = new File("Downloads/");
        if(dir.exists()) {
            for (File file : dir.listFiles()) {
                file.delete();
            }
        }
    }
*/
    public String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        return file.getAbsolutePath();
    }

    public List<String> getCsvHeaders(String filePath) throws Exception {
        String pathFile = URLDecoder.decode(filePath, "UTF-8");
        BufferedReader reader = new BufferedReader(new FileReader(pathFile));
        List<String> csvData = new ArrayList<>(Arrays.asList(reader.readLine().split(",")));
        reader.close();
        return csvData;

    }

    public int getCsvRowCount(String filePath) throws Exception {
        Path currentRelativePath = Paths.get("");
        String currentPath = currentRelativePath.toAbsolutePath().toString();
        String csvFile = currentPath + filePath;
        List<String> csvData = new ArrayList<>();
        Reader in = null;

        Iterable<CSVRecord> records = null;
        try {
            in = new FileReader(csvFile);
            records = CSVFormat.EXCEL.withHeader().parse(in); // header will be ignored

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (CSVRecord record : records) {
            String line = "";

            for (int i = 0; i < record.size(); i++) {
                if (line == "")
                    line = line.concat(record.get(i));
                else
                    line = line.concat("," + record.get(i));


            }
            csvData.add(line);


        }
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        //  logReport("List Array of csv data ---" + csvData.size());
        return csvData.size();
    }

    public List<String> readCsvFileAsList(String filePath) {
        Path currentRelativePath = Paths.get("");
        String currentPath = currentRelativePath.toAbsolutePath().toString();
        String csvFile = currentPath + filePath;
        List<String> csvData = new ArrayList<>();
        Reader in;

        Iterable<CSVRecord> records = null;
        try {
            in = new FileReader(csvFile);
            records = CSVFormat.EXCEL.withHeader().parse(in); // header will be ignored
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (CSVRecord record : records) {
            String line = "";

            for (int i = 0; i < record.size(); i++) {
                if (line == "")
                    line = line.concat(record.get(i));
                else
                    line = line.concat("," + record.get(i));


            }
            csvData.add(line);
        }
        return csvData;
    }


    public int getExcelRowCount(String filePath, String fileName, String sheetName) throws Exception {
        File excelFile = new File(filePath + "\\" + fileName);
        FileInputStream excelInputStream = new FileInputStream(excelFile);
        Workbook excelWorkbook = null;

        excelWorkbook = new XSSFWorkbook(excelInputStream);

        Sheet excelSheet = excelWorkbook.getSheet(sheetName);

        // Get the number of rows
        int rowCount = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum();
        log("Row count of excel " + rowCount);
        return rowCount;
    }

    public List<String> getExcelHeaders(String filePath, String fileName, String sheetName) throws Exception {
        File excelFile = new File(filePath + "\\" + fileName);
        FileInputStream excelInputStream = new FileInputStream(excelFile);
        Workbook excelWorkbook = null;
        List<String> excelData = new ArrayList<>();
        // Assuming XLSX here. If XLS use HSSFWorkbook
        excelWorkbook = new XSSFWorkbook(excelInputStream);

        // Read the sheet inside the excel workbook
        Sheet excelSheet = excelWorkbook.getSheet(sheetName);

        // Get the number of rows
        int rowCount = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum();
        log("Row count of excel " + rowCount);
        // Read all the rows
        // for (int i=0;i<=rowCount;i++){
        Row excelRow = excelSheet.getRow(0);
        Row excelSet = excelSheet.getRow(0);

        HashMap<String, String> test = new HashMap<String, String>();
        String value;
        // Now we need to read all the cell (column) values in each row
        for (int j = 0; j < excelRow.getLastCellNum(); j++) {
            // Output value to the console for now
            String key = excelRow.getCell(j).getStringCellValue();
            //logReport("--- " + key);
            excelData.add(key);
        }

        return excelData;
    }

    public BasicSettingsPage clickMobileLinkFromEngageMenuItem()throws Exception{
        VerifyPageReady(30);
        Wait(ENGAGE_LINK, 20);
        clickByJavaScript(ENGAGE_LINK);
        Wait(MOBILE_MENU_ITEM, 20);
        click(MOBILE_MENU_ITEM);
        logReport("Successfully clicked on mobile link from engage menu item.");
        return new BasicSettingsPage(browser);

    }

    public void setElementLength(WebElement element, String length) {
        executeJavascript("arguments[0].setAttribute('maxlength', '" + length + "')", element);
    }

    /**
     * Method for clicking on event dashboard link
     *
     * @return DashboardPage
     */
    public EventDashboardPage clickEventDashboardLink() throws Exception{
        VerifyPageReady(30);
        Wait(EVENT_DASHBOARD_LINK, 30);
        clickByJavaScript(EVENT_DASHBOARD_LINK);
        logReport("Event dashboard link clicked successfully");
        VerifyAjaxRequestsFinished(30);
        VerifyPageReady(30);
        return new EventDashboardPage(browser);
    }
    /**
     * Method for clicking on plan menu
     */
    private void clickPlanMenu() throws Exception{
        Wait(PLAN_MENU_LINK, 30);
        click(PLAN_MENU_LINK);
    }

    /**
     * Method for clicking accommodation menu item
     */
    private void clickAccommodationMenu() throws Exception{
        Wait(ACCOMMODATION_MENUITEM, 30);
        click(ACCOMMODATION_MENUITEM);
    }
    /**
     * Method for clicking accommodation link under plan menu item
     *
     * @return BlocksPage
     */
    public BlocksPage clickAccommodationTab() throws Exception {
        Thread.sleep(4000);
        clickPlanMenu();

        if (!ACCOMMODATION_MENUITEM.isDisplayed()) {
            clickPlanMenu();
            clickAccommodationMenu();
        } else
            clickAccommodationMenu();

        reporter.info("Successfully clicked on 'Accommodation' tab.");
        VerifyAngularHasFinishedProcessing(30);
        return new BlocksPage(browser);
    }

    public OverviewPage clickPlanPlanningMenuItem() throws Exception {
        VerifyPageReady(30);
        Wait(PLAN_DROPDOWN, 30);
        click(PLAN_DROPDOWN);
        logReport("Clicked on 'Plan' menu item.");
        Wait(PLANNING_LINK, 30);
        click(PLANNING_LINK);
        logReport("Clicked on 'Planning' menu item.");
        VerifyPageReady(30);
        return new OverviewPage(browser);

    }

    public FormListPage clickPlanFormMenuItem() throws Exception {
        VerifyPageReady(30);
        Wait(PLAN_DROPDOWN, 30);
        clickByJavaScript(PLAN_DROPDOWN);
        logReport("Clicked on 'Plan' menu item.");
        Wait(FORM_LINK, 30);
        click(FORM_LINK);
        logReport("Clicked on 'Form' menu item.");
        VerifyPageReady(30);
        return new FormListPage(browser);

    }

    public CustomQuestionsPage clickEventQuestionsFromPlanDropdown() throws Exception {
        Wait(PLAN_DROPDOWN, 30);
        click(PLAN_DROPDOWN);
        logReport("Clicked on 'Plan' menu item.");
        Wait(EVENT_SETUP_MENUITEM, 30);
        click(EVENT_SETUP_MENUITEM);
        logReport("Clicked on 'Event setup' menu item.");
        Wait(EVENT_QUESTION_TAB, 30);
        click(EVENT_QUESTION_TAB);
        logReport("Clicked on 'Event Question' menu item.");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        return new CustomQuestionsPage(browser);
    }

    public GroupListPage clickPlanGropusMenuItem() throws Exception {
        VerifyPageReady(30);
        Wait(PLAN_DROPDOWN, 30);
        click(PLAN_DROPDOWN);
        logReport("Clicked on 'Plan' menu item.");
        Wait(GROUPS_VIA_PLAN_DROPDOWN, 30);
        click(GROUPS_VIA_PLAN_DROPDOWN);
        logReport("Clicked on 'Groups' menu item.");
        VerifyPageReady(30);
        return new GroupListPage(browser);

    }

    public AddRegistrationForGroup clickManageRegistrationsMenuItem() throws Exception {
        VerifyAjaxRequestsFinished(20);
        VerifyPageReady(20);
        Wait(MANAGE_LINK, 20);
        clickByJavaScript(MANAGE_LINK);
        Wait(REGISTRATIONS_LINK, 20);
        click(REGISTRATIONS_LINK);
        VerifyPageReady(20);
        return new AddRegistrationForGroup(browser);
    }


    public pageObjects.Management.OverviewPage clickManagementOverviewMenuItem() throws Exception {
        VerifyPageReady(30);
        Wait(MANAGEMENT_TAB, 30);
        click(MANAGEMENT_TAB);
        logReport("Clicked on 'Management' menu item.");
        Wait(MANAGEMENT_LINK, 30);
        click(MANAGEMENT_LINK);
        logReport("Clicked on 'Management > Overview' menu item.");
        VerifyPageReady(30);
        return new pageObjects.Management.OverviewPage(browser);

    }

    public void clickSessionDontShowButtonIfPresent() throws Exception {

        try {
            if (verifyElementDisplayed(SESSION_DONT_SHOW_BUTTON, 1)) {
                click(SESSION_DONT_SHOW_BUTTON);
                //waitForWindowToDispose();
                switchToLatestTabOrWindow();
            }
        } catch (TimeoutException e) {
        }
    }


    public SessionsListPage clickManageSpeakerSessionMenuItem() throws Exception {
        VerifyAjaxRequestsFinished(20);
        // VerifyPageReady(20);
        Wait(MANAGE_LINK, 20);
        clickByJavaScript(MANAGE_LINK);
        Wait(SPEAKER_SESSION_MENUITEM, 20);
        click(SPEAKER_SESSION_MENUITEM);
        VerifyAjaxRequestsFinished(20);
        VerifyAngularHasFinishedProcessing(10);
        VerifyPageReady(20);
        return new SessionsListPage(browser);
    }

    public SpeakerPortalAdminPage clickManageSpeakerPortal() throws Exception {
        VerifyAjaxRequestsFinished(20);
        VerifyPageReady(20);
        Wait(MANAGE_LINK, 20);
        clickByJavaScript(MANAGE_LINK);
        Wait(SPEAKER_PORTAL_MENUITEM, 20);
        clickByJavaScript(SPEAKER_PORTAL_MENUITEM);
        VerifyPageReady(20);
        VerifyAngularHasFinishedProcessing(30);
        return new SpeakerPortalAdminPage(browser);
    }

    public void acceptAlert(){
        Alert alert = browser.switchTo().alert();
        alert.accept();
        logReport("Successfully clicked on Ok button on alert popup.");
    }

    public void cancelAlert() {
        Alert alert = browser.switchTo().alert();
        alert.dismiss();
        logReport("Successfully clicked on Ok button on alert popup.");
    }

    public String getMessageText() {
        String msg = null;
        try {
            msg = MESSAGE_TEXT.getText().trim();
        } catch (Exception e) {

        }
        return msg;
    }

    public void waitForReportResultsPageToLoad() throws Exception {
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
        }
        switchToLatestTabOrWindow();
        int count = 0;
        while (!GO_BUTTON.isDisplayed() && count <= 5) {
            browser.navigate().refresh();
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
            }
            VerifyPageReady(20);
            count = count + 1;
        }

    }

    public String addTimeUsingSpecifiedFormat(String timeValue, int minutes) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("hh:mm a");
        Date d = df.parse(timeValue);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MINUTE, minutes);
        String newTime = df.format(cal.getTime());
        logReport("New Time value after adding " + newTime);
        return newTime;
    }
    public String hoverMessageTitle() {
        try {
            Actions action = new Actions(browser);
            action.moveToElement(MESSAGE_TEXT).perform();
            return MESSAGE_TEXT.getText().trim();
        } catch (Exception e) {
            return null;
        }
    }
    public IndustriesPage clickIndustriesTab() throws Exception {
        Wait(INDUSTRIES_TAB, 20);
        click(INDUSTRIES_TAB);
        log("Industries tab clicked successfully");
        return new IndustriesPage(browser);
    }

    public JobFunctionsPage clickJobFunctionsTab() throws Exception {
        click(JOB_FUNCTIONS_TAB);
        log("Job functions tab clicked successfully");
        return new JobFunctionsPage(browser);
    }

    public SessionJobFunctionsPage clickOnJobFunctionsTab() throws Exception {
        VerifyPageReady(30);
        click(JOB_FUNCTION_LIST_TAB);
        logReport("Successfully clicked on Session Job Functions tab.");
        VerifyAngularHasFinishedProcessing(20);
        VerifyAjaxRequestsFinished(20);
        return new SessionJobFunctionsPage(browser);
    }

    public SessionIndustriesPage clickOnIndustriesTab() throws Exception {
        VerifyPageReady(30);
        clickByJavaScript(INDUSTRY_LIST_TAB);
        logReport("Successfully clicked on Session Industries tab.");
        VerifyAngularHasFinishedProcessing(20);
        VerifyAjaxRequestsFinished(20);
        return new SessionIndustriesPage(browser);
    }

    public SessionsListPage clickSessionsTab() throws Exception {
        Wait(SESSIONS_TAB, 30);
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(30);
        click(SESSIONS_TAB);
        logReport("Sessions tab clicked successfully");
        VerifyAngularHasFinishedProcessing(30);
        VerifyAjaxRequestsFinished(30);
        return new SessionsListPage(browser);
    }

    //To generate random number
    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public List<String> getConfiguredStandardFieldsList() {
        List<String> itemsList = new ArrayList<>();
        for (WebElement e : LAYOUT_CONFIGURED_STANDARDFIELDS_LIST) {
            itemsList.add(e.getText().trim());
        }
        return itemsList;
    }

    public List<String> getConfiguredCustomFieldsList() {
        List<String> itemsList = new ArrayList<>();
        for (WebElement e : LAYOUT_CONFIGURED_CUSTOMFIELDS_LIST) {
            itemsList.add(e.getText().trim());
        }
        return itemsList;
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

    //Administration user tab

    public UserInformationPage clickAdministrationUsersMenuItem() throws Exception {
        VerifyPageReady(30);
        Wait(ADMINISTRATION_DROPDOWN, 30);
        clickByJavaScript(ADMINISTRATION_DROPDOWN);
        logReport("Clicked on Administration tab dropdown.");
        Wait(ADMINISTRATION_USER_MENU_ITEM, 30);
        click(ADMINISTRATION_USER_MENU_ITEM);
        logReport("Clicked on 'Administration User' menu item.");
        VerifyPageReady(30);
        return new UserInformationPage(browser);
    }

    //Registration Tab

    public RegistrationOverviewPage clickRegistrationOverviewMenuItem() throws Exception {
        VerifyPageReady(30);
        Wait(REGISTRATION_DROPDOWN, 30);
        clickByJavaScript(REGISTRATION_DROPDOWN);
        logReport("Clicked on Registration tab dropdown.");
        Wait(REGISTRATION_OVERVIEW_MENU_ITEM, 30);
        click(REGISTRATION_OVERVIEW_MENU_ITEM);
        logReport("Clicked on 'Registration Overview' menu item.");
        VerifyPageReady(30);
        return new RegistrationOverviewPage(browser);
    }

    public CustomProfileDataPage clickRegistrationProfileDataMenuItem() throws Exception {
        VerifyPageReady(30);
        Wait(REGISTRATION_DROPDOWN, 30);
        clickByJavaScript(REGISTRATION_DROPDOWN);
        logReport("Clicked on Registration tab dropdown.");
        Wait(REGISTRATION_PROFILE_DATA_MENU_ITEM, 30);
        click(REGISTRATION_PROFILE_DATA_MENU_ITEM);
        logReport("Clicked on 'Registration Profile Data' menu item.");
        VerifyPageReady(30);
        return new CustomProfileDataPage(browser);
    }

    public FinancialDataSettingPage clickRegistrationFinancialDataMenuItem() throws Exception {
        VerifyPageReady(30);
        Wait(REGISTRATION_DROPDOWN, 30);
        clickByJavaScript(REGISTRATION_DROPDOWN);
        logReport("Clicked on Registration tab dropdown.");
        Wait(REGISTRATION_FINANCIAL_DATA_MENU_ITEM, 30);
        click(REGISTRATION_FINANCIAL_DATA_MENU_ITEM);
        logReport("Clicked on 'Registration Financial Data' menu item.");
        VerifyPageReady(30);
        return new FinancialDataSettingPage(browser);
    }

    public boolean isAttribtuePresent(WebElement element, String attribute) {
        Boolean result = false;
        try {
            String value = element.getAttribute(attribute);
            if (value != null) {
                result = true;
            }
        } catch (Exception e) {
            return false;
        }

        return result;
    }

    public PrintableConfirmationsPage clickRegistrationPrintableConfirmationsMenuItem() throws Exception {
        VerifyPageReady(30);
        Wait(REGISTRATION_DROPDOWN, 30);
        clickByJavaScript(REGISTRATION_DROPDOWN);
        logReport("Clicked on Registration tab dropdown.");
        Wait(REGISTRATION_PRINTABLE_CONFIRMATIONS_MENU_ITEM, 30);
        click(REGISTRATION_PRINTABLE_CONFIRMATIONS_MENU_ITEM);
        logReport("Clicked on 'Registration Printable Confirmations' menu item.");
        VerifyPageReady(30);
        return new PrintableConfirmationsPage(browser);
    }

    public EventCreationPage clickRegistrationEventCreationMenuItem() throws Exception {
        VerifyPageReady(30);
        Wait(REGISTRATION_DROPDOWN, 30);
        clickByJavaScript(REGISTRATION_DROPDOWN);
        logReport("Clicked on Registration tab dropdown.");
        Wait(REGISTRATION_EVENT_CREATION_MENU_ITEM, 30);
        click(REGISTRATION_EVENT_CREATION_MENU_ITEM);
        logReport("Clicked on 'Registration Event Creation' menu item.");
        VerifyPageReady(30);
        return new EventCreationPage(browser);
    }

    public AccountInvoicesPage clickRegistrationInvoicesMenuItem() throws Exception {
        VerifyPageReady(30);
        Wait(REGISTRATION_DROPDOWN, 30);
        clickByJavaScript(REGISTRATION_DROPDOWN);
        logReport("Clicked on Registration tab dropdown.");
        Wait(REGISTRATION_INVOICES_MENU_ITEM, 30);
        click(REGISTRATION_INVOICES_MENU_ITEM);
        logReport("Clicked on 'Registration Invoices' menu item.");
        VerifyPageReady(30);
        return new AccountInvoicesPage(browser);
    }

    public DataFormatPage clickRegistrationDataFormatMenuItem() throws Exception {
        VerifyPageReady(30);
        Wait(REGISTRATION_DROPDOWN, 30);
        clickByJavaScript(REGISTRATION_DROPDOWN);
        logReport("Clicked on Registration tab dropdown.");
        Wait(REGISTRATION_DATA_FORMAT_MENU_ITEM, 30);
        click(REGISTRATION_DATA_FORMAT_MENU_ITEM);
        logReport("Clicked on 'Registration Data Format' menu item.");
        VerifyPageReady(30);
        return new DataFormatPage(browser);
    }

    public EventDataPage clickManagementEventDataPage() throws Exception {
        VerifyPageReady(30);
        Wait(EVENT_DATA_TAB, 30);
        clickByJavaScript(EVENT_DATA_TAB);
        logReport("Clicked on 'Management Event Data' menu item.");
        VerifyPageReady(30);
        return new EventDataPage(browser);
    }

    public RolesPage clickManagementRolesPage() throws Exception {
        VerifyPageReady(30);
        Wait(ROLES_TAB, 30);
        clickByJavaScript(ROLES_TAB);
        logReport("Clicked on 'Management Roles' menu item.");
        VerifyPageReady(30);
        return new RolesPage(browser);
    }

    public GeneralLedgerPage clickManagementGeneralLedgerPage() throws Exception {
        VerifyPageReady(30);
        Wait(GENERAL_LEDGER_TAB, 30);
        click(GENERAL_LEDGER_TAB);
        logReport("Clicked on 'Management General Ledger' menu item.");
        VerifyPageReady(30);
        return new GeneralLedgerPage(browser);
    }

    public TagsPage clickManagementTagsPage() throws Exception {
        clickManagementDropDown();
        Wait(ManagementTagsDropdownLink, 40);
        ManagementTagsDropdownLink.click();
        logReport("Management Tags link clicked successfully");
        VerifyPageReady(30);
        return new TagsPage(browser);
    }

    public void clickManagementDropDown() throws Exception {
        Wait(ManagementDropdownLink, 30);
        clickByJavaScript(ManagementDropdownLink);
        logReport("Clicked on Management dropDwon");
        Thread.sleep(5000);
    }

    public JobFunctionsPage clickManagementJobFunctionsPage() throws Exception {
        VerifyPageReady(30);
        Wait(JOB_FUNCTIONS_TAB, 30);
        click(JOB_FUNCTIONS_TAB);
        logReport("Clicked on 'Management Job Functions' menu item.");
        VerifyPageReady(30);
        return new JobFunctionsPage(browser);
    }

    public IndustriesPage clickManagementIndustriesPage() throws Exception {
        VerifyPageReady(30);
        Wait(INDUSTRIES_TAB, 30);
        click(INDUSTRIES_TAB);
        logReport("Clicked on 'Management Industries' menu item.");
        VerifyPageReady(30);
        return new IndustriesPage(browser);
    }

    public SingleSignOnPage clickManagementSingleSignOnPage() throws Exception {
        VerifyPageReady(30);
        Wait(SINGLE_SIGN_ON_TAB, 30);
        click(SINGLE_SIGN_ON_TAB);
        logReport("Clicked on 'Management Single Sign On' menu item.");
        VerifyPageReady(30);
        return new SingleSignOnPage(browser);
    }

    public SingleSignOnPage clickSingleSignOnLink() throws Exception {
        Wait(SINGLE_SIGNON_LINK, 30);
        clickByJavaScript(SINGLE_SIGNON_LINK);
        logReport("Single sign on link clicked successfully");
        VerifyAjaxRequestsFinished(30);
        VerifyAngularHasFinishedProcessing(30);
        return new SingleSignOnPage(browser);
    }

    public RegistrationStatusesPage clickManagementRegistrationStatusesPage() throws Exception {
        VerifyPageReady(30);
        Wait(REGISTRATION_STATUSES_TAB, 30);
        clickByJavaScript(REGISTRATION_STATUSES_TAB);
        logReport("Clicked on 'Management Registration Statuses' menu item.");
        VerifyPageReady(30);
        return new RegistrationStatusesPage(browser);
    }

    public RegistrationStatusesPage clickManagementRegistrationStatusestab() throws Exception {
        VerifyPageReady(30);
        Wait(REGISTRATION_STATUSES_TAB_NEW, 30);
        clickByJavaScript(REGISTRATION_STATUSES_TAB_NEW);
        logReport("Clicked on 'Management Registration Statuses' menu Tab.");
        VerifyPageReady(30);
        return new RegistrationStatusesPage(browser);
    }


    public CommonReportsPage clickReportsPage() throws Exception {
        VerifyPageReady(30);
        Wait(REPORTS_TAB, 30);
        click(REPORTS_TAB);
        logReport("Clicked on 'Reports' Tab.");
        VerifyPageReady(30);
        return new CommonReportsPage(browser);
    }

    public ProductsPage clickProductsPage() throws Exception {
        VerifyPageReady(30);
        Wait(IMPLEMENTATION_TAB, 30);
        click(IMPLEMENTATION_TAB);
        logReport("Clicked on Implementation tab dropdown.");
        Wait(IMPLEMENTATION_PRODUCTS_MENU_ITEM, 30);
        click(IMPLEMENTATION_PRODUCTS_MENU_ITEM);
        logReport("Clicked on 'Implementation Products' menu item.");
        VerifyPageReady(30);
        return new ProductsPage(browser);
    }

    public SecuritySettingsPage clickSecurityPage() throws Exception {
        VerifyPageReady(30);
        Wait(IMPLEMENTATION_SECURITY_MENU_ITEM, 30);
        click(IMPLEMENTATION_SECURITY_MENU_ITEM);
        logReport("Clicked on 'Implementation Security' menu item.");
        VerifyPageReady(30);
        return new SecuritySettingsPage(browser);
    }

    public AccountHistoryPage clickHistoryPage() throws Exception {
        VerifyPageReady(30);
        Wait(IMPLEMENTATION_HISTORY_MENU_ITEM, 30);
        click(IMPLEMENTATION_HISTORY_MENU_ITEM);
        logReport("Clicked on 'Implementation History' menu item.");
        VerifyPageReady(30);
        return new AccountHistoryPage(browser);
    }

    public APIPage clickAPIPage() throws Exception {
        VerifyPageReady(30);
        Wait(IMPLEMENTATION_API_MENU_ITEM, 30);
        click(IMPLEMENTATION_API_MENU_ITEM);
        logReport("Clicked on 'Implementation API' menu item.");
        VerifyPageReady(30);
        return new APIPage(browser);
    }

    public SalesForceIntegrationPage clickSalesForcePage() throws Exception {
        VerifyPageReady(30);
        Wait(IMPLEMENTATION_SALESFORCE_MENU_ITEM, 30);
        click(IMPLEMENTATION_SALESFORCE_MENU_ITEM);
        logReport("Clicked on 'Implementation Salesforce' menu item.");
        VerifyPageReady(30);
        return new SalesForceIntegrationPage(browser);
    }

    public PluginsPage clickPluginsPage() throws Exception {
        VerifyPageReady(30);
        Wait(IMPLEMENTATION_PLUGINS_MENU_ITEM, 30);
        click(IMPLEMENTATION_PLUGINS_MENU_ITEM);
        logReport("Clicked on 'Implementation Plugins' menu item.");
        VerifyPageReady(30);
        return new PluginsPage(browser);
    }

    public void clickItemsUnderNavigationMenu(String itemName) throws Exception {
        Wait(NAVIGATION_MENU, 10);
        clickByJavaScript(NAVIGATION_MENU);
        for (WebElement e : LIST_MENU_ITEMS) {
            if (e.getText().trim().contains(itemName)) {
                e.click();
                logReport("Menu items selected " + itemName);
                VerifyAngularHasFinishedProcessing(30);
                break;
            }
        }

    }

    public void deleteDirectoryContent(File folder) throws IOException {
        if (folder.isDirectory()) {
            logReport("---------list of files --------------");
            File[] files = folder.listFiles();
            logReport("---------list of files --------------" + files.length);
            try {
                if (files.length == 0) {
                    return;
                } else {
                    for (File file : files) {
                        logReport("---------list of files --------------" + file.isFile());
                        if (file.isFile()) {
                            String fileName = file.getName();
                            boolean del = file.delete();
                            logReport(fileName + " : got deleted ? " + del);

                        } else if (file.isDirectory()) {
                            deleteDirectoryContent(file);
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public String addDurationIntoStartDate(String startDate, String duration) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy h:mm a");

        // replace with your start date string
        Date d = df.parse(startDate);
        Long time = d.getTime();
        time += (Integer.parseInt(duration) * 60 * 1000);
        Date d2 = new Date(time);

        //return d2.toString();

        Calendar c = Calendar.getInstance();
        c.setTime(d2);
        c.add(Calendar.DATE, 0);
        return df.format(c.getTime());
    }

    public void switchToNewTab() throws Exception {
        ((JavascriptExecutor) browser).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(browser.getWindowHandles());
        logReport("Tabs : " + tabs);
        browser.switchTo().window(tabs.get(1));
        browser.get("https://login.eloqua.com");
        logReport("New tab switched successfully");
        VerifyPageReady(30);
    }

    public void clickSearchIconInQuickSearchPage() throws Exception {
        scrollUp();
        Wait(QUICK_SEARCH_ICON, 10);
        click(QUICK_SEARCH_ICON);
        logReport("Quick Search icon clicked successfully");
    }

    public QuickSearchPage clickRegistrationsQuickSearch() throws Exception {
        clickSearchIconInQuickSearchPage();
        //clickSearchIconInQuickSearchPage(); //due to 404
        Wait(REGISTRATIONS_QUICK_SEARCH, 10);
        click(REGISTRATIONS_QUICK_SEARCH);
        logReport("Registrations Quick Search icon clicked successfully");
        return new QuickSearchPage(browser);
    }

    public QuickSearchPage clickProfilesQuickSearch() throws Exception {
        Wait(QUICK_SEARCH_ICON, 20);
        clickSearchIconInQuickSearchPage();
        //clickSearchIconInQuickSearchPage(); //due to 404
        Wait(PROFILES_QUICK_SEARCH, 10);
        click(PROFILES_QUICK_SEARCH);
        logReport("Profiles Quick Search icon clicked successfully");
        return new QuickSearchPage(browser);
    }

    public QuickSearchPage clickProfilesQuickSearchAnonymization() throws Exception {
        Wait(QUICK_SEARCH_ICON, 20);
        clickSearchIconInQuickSearchPage();
        //clickSearchIconInQuickSearchPage(); //due to 404
        Wait(PROFILES_QUICK_SEARCH, 10);
        click(PROFILES_QUICK_SEARCH);
        logReport("Profiles Quick Search icon clicked successfully");
        return new QuickSearchPage(browser);
    }


    public void openNewTab(String url) throws Exception {
        ((JavascriptExecutor) browser).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(browser.getWindowHandles());
        logReport("Tabs : " + tabs);
        browser.switchTo().window(tabs.get(1));
        browser.get(url);
        logReport("New tab switched successfully");

    }

    public void switchToNewTabChromeBrowser() throws Exception {
        ((JavascriptExecutor) browser).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(browser.getWindowHandles());
        logReport("Tabs : " + tabs);
        browser.switchTo().window(tabs.get(1));
        browser.get("chrome://downloads");
        logReport("New tab switched successfully");
        VerifyPageReady(30);
    }

    public void moveFile(String sourcePath, String destinationPath) throws Exception {
        File file = new File(sourcePath);
        File file1 = new File(destinationPath);
        // renaming the file and moving it to a new location
        try {
            logReport("File source path");
            FileUtils.copyDirectory(file, file1);
            logReport("File copied/");
        } catch (Exception e) {

        }
    }

    public ProfilesSearchPage clickProfiles() throws Exception {
        VerifyPageReady(20);
        VerifyAjaxRequestsFinished(20);
        Wait(MENU_LINK, 20);
        click(MENU_LINK);
        if (!verifyElementDisplayed(PROFILES_OPTION, 10)) {
            click(MENU_LINK);
            click(PROFILES_OPTION);
        } else {
            click(PROFILES_OPTION);
        }

        logReport("Clicked on Profiles Option");
        return new ProfilesSearchPage(browser);
    }

    public EventDashboardPage clickOnEventDashboardLink() throws Exception {
        Wait(EVENT_DASHBOARD_LINK, 10);
        click(EVENT_DASHBOARD_LINK);
        logReport("Clicked on 'Event Dashboard' link.");
        VerifyAngularHasFinishedProcessing(20);
        return new EventDashboardPage(browser);

    }

    public CommonReportsPage clickReportsAnalyzeMenu() throws Exception {
        VerifyPageReady(30);
        Wait(REPORTS_ANALYZE_MENU, 30);
        click(REPORTS_ANALYZE_MENU);
        logReport("Clicked on 'Reports/Analyze' Menu.");
        VerifyPageReady(30);
        return new CommonReportsPage(browser);
    }

    public CertainIntegrationsPage clickIFDataIntegrationPage() throws Exception {
        Wait(IMPLEMENTATION_TAB, 30);
        // clickByJavaScript(IMPLEMENTATION_TAB);
        moveToElement(IMPLEMENTATION_TAB);
        logReport("Clicked on Implementation tab dropdown.");
        Wait(IMPLEMENTATION_IF_MENU_ITEM, 30);
        click(IMPLEMENTATION_IF_MENU_ITEM);
        logReport("Clicked on 'Implementation IF-Real-Time Data Integration' menu item.");
        VerifyAngularHasFinishedProcessing(2);
        VerifyPageReady(20);
        return new CertainIntegrationsPage(browser);
    }

    public PluginsPage clickImplementationPluginsPage() throws Exception {
        Wait(IMPLEMENTATION_TAB, 30);
        clickByJavaScript(IMPLEMENTATION_TAB);
        logReport("Clicked on Implementation tab dropdown.");
        Wait(IMPLEMENTATION_PLUGINS_MENU_ITEM, 30);
        click(IMPLEMENTATION_PLUGINS_MENU_ITEM);
        logReport("Clicked on 'Implementation plugins' menu item.");
        VerifyAngularHasFinishedProcessing(40);
        return new PluginsPage(browser);
    }

    public String convert24FormatTo12FormatTime(String time) {
        //Date/time pattern of input date
        DateFormat df = new SimpleDateFormat("HH:mm");
        //Date/time pattern of desired output date
        DateFormat outputformat = new SimpleDateFormat("hh:mm");
        Date date = null;
        String output = null;
        try {
            //Conversion of input String to date
            date = df.parse(time);
            //old date format to new date format
            output = outputformat.format(date);
            logReport("Converted 24 format to 12 hour format " + output);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return output;
    }

    public void clickCloseIcon() throws Exception {
        clickByJavaScript(MESSAGE_CLOSE_ICON);
        logReport("Close icon clicked successfully");
        VerifyPageReady(30);
    }

    public static String formatDateToString(Date date, String format,

                                            String timeZone) {

        // null check

        if (date == null) return null;

        // create SimpleDateFormat object with input format

        SimpleDateFormat sdf = new SimpleDateFormat(format);

        // default system timezone if passed null or empty

        if (timeZone == null || "".equalsIgnoreCase(timeZone.trim())) {

            timeZone = Calendar.getInstance().getTimeZone().getID();

        }

        // set timezone to SimpleDateFormat

        sdf.setTimeZone(TimeZone.getTimeZone(timeZone));

        // return Date in required format with timezone as String

        return sdf.format(date);

    }

    /*public static String getDateFromOneZoneToAnother(String date, String destZone, String sourcedateFormat, String destDateFormat) {

        Date today;
        String PST = null;
        try {
            logReport("destination zone value " + destZone);
            today = new SimpleDateFormat(sourcedateFormat).parse(date);
            DateFormat df = new SimpleDateFormat(destDateFormat);
            df.setTimeZone(TimeZone.getTimeZone(destZone));
            PST = df.format(today);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return PST;

    }*/

    public String convertDateFormatIntoAnother(String dateValue, String format1, String format2) throws Exception {
        String dateStr = null;
        try {
            DateFormat srcDf = new SimpleDateFormat(format1);
            Date date = srcDf.parse(dateValue);
            DateFormat destDf = new SimpleDateFormat(format2);
            dateStr = destDf.format(date);
            logReport("Converted date is : " + dateStr);

        } catch (Exception e) {

        }
        return dateStr;
    }

    public void switchToAccountFrame() throws Exception {
        VerifyPageReady(30);
        browser.switchTo().frame(accountFrame);
        logReport("Switched to account frame successfully");
        //webDriver.switchTo().defaultContent();
    }

    public void selectSubAccount(String accountCode) throws Exception {
        VerifyAjaxRequestsFinished(30);
        //VerifyAngularHasFinishedProcessing(20);

        accountSelector.click();

        VerifyAjaxRequestsFinished(30);

        switchToAccountFrame();
        VerifyAngularHasFinishedProcessing(20);
        accountSearchTextbox.sendKeys(accountCode);
        VerifyAngularHasFinishedProcessing(20);

        if (!isElementDisplayed(ACCOUNT_OPTIONS_LIST, browser)) {
            switchToAccountFrame();
        }
        //  switchToAccountFrame();
        List<WebElement> optionsList = browser.findElements(ACCOUNT_OPTIONS_LIST);
        if (optionsList.size() != 1) {
            VerifyAngularHasFinishedProcessing(30);
            for (WebElement e : optionsList) {
                if (e.getText().trim().equalsIgnoreCase(accountCode)) {
                    e.click();
                    logReport("Selected parentAccount = " + accountCode);
                    break;
                }
            }
        } else {
            VerifyAngularHasFinishedProcessing(30);
            accountOptionsList.click();
            logReport("Selected parentAccount = " + accountCode);
        }
        // VerifyelementsNumberEqual(1,ACCOUNT_OPTIONS_LIST,30);

        VerifyAjaxRequestsFinished(40);
        //  VerifyPageReady(30);
        browser.switchTo().defaultContent();

    }

    public FormPreviewHomePage clickPreviewButton() throws Exception {
        Wait(PREVIEW_BUTTON, 20);
        clickByJavaScript(PREVIEW_BUTTON);
        VerifyPageReady(20);
        reporter.info("Preview Button clicked successfully");
        VerifyAjaxRequestsFinished(20);
        return new FormPreviewHomePage(browser);
    }

    public void parseDateInGivenFormat() throws Exception {
        String dateValue = "2021-12-20T10:53:27.673Z";
        SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date dt_1 = objSDF.parse(dateValue);
        Date dt_2 = new Date();
        objSDF.format(dt_2);
        System.out.println("date value " + dt_1);
        System.out.println("date value " + dt_2);

        if (dt_1.compareTo(dt_2) > 0) {
            System.out.println("Date 1 occurs after Date 2");
        } else if (dt_1.compareTo(dt_2) < 0) {
            System.out.println("Date 1 occurs before Date 2");
        } else if (dt_1.compareTo(dt_2) == 0) {
            System.out.println("Both are same dates");
        } else {
            System.out.println("You seem to be a time traveller !!");
        }
    }
}
