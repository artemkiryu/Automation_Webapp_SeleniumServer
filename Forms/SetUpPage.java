package pageObjects.Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddFormData;

import javax.naming.ConfigurationException;
import java.util.List;

/**
 * Created by infoobjects on 18-08-2017.
 */
public class SetUpPage extends CommonActionsPage {

    //Setup Information
    @FindBy(xpath = "//input[@name='form_name']")
    public WebElement FORM_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='form_subtitle']")
    public WebElement FORM_SUBTITLE_TEXTBOX;
    @FindBy(xpath = "//input[@name='form_email_cc_list']")
    public WebElement FORM_EMAIL_CC_TEXTBOX;
    @FindBy(xpath = "//input[@id='form_open_date']")
    public WebElement FORM_OPEN_DATE_TEXTBOX;
    @FindBy(xpath = "//input[@name='form_open_time']")
    public WebElement FORM_OPEN_TIME_TEXTBOX;
    @FindBy(xpath = "//input[@name='form_close_date']")
    public WebElement FORM_CLOSE_DATE_TEXTBOX;
    @FindBy(xpath = "//input[@name='form_close_time']")
    public WebElement FORM_CLOSE_TIME_TEXTBOX;
    @FindBy(xpath = "//div[@class='col-sm-7']//a[contains(text(),'profile')]")
    public WebElement FORM_PROFILE_URL_HYPERLINK;
    @FindBy(xpath = "//input[@name='form_label']")
    public WebElement FORM_HYPERLINK_LABEL_TEXTBOX;
    @FindBy(xpath = "//input[@name='txtFormGoogleAnalyticsToken']")
    public WebElement FORM_GOOGLE_ANALYTICS_TRACKING_ID_TEXTBOX;
    public String FORM_SETTINGS_CHECKBOX = "//div[@id='SetupInformationId']//div[@class='checkbox']//label[contains(.,'+ StringText +')]/input";
   //@FindBy(xpath = "//div[@id='SetupInformationId']//div[@class='checkbox']//label[contains(.,'+ StringText +')]/input")
    //public WebElement FORM_SETTINGS_CHECKBOX;
   @FindBy(xpath = "//select[@id='form_entry_frn_reg_sts_id']")
   public WebElement FORM_REG_STATUS_DROPDOWN;
   @FindBy(xpath = "//textarea[@id='form_notes']")
   public WebElement FORM_NOTES_TEXTAREA ;

   //Page Layout
   @FindBy(xpath = "//select[@id='form_sections']")
   public WebElement FORM_AVAILABLE_SECTIONS_LIST;

   //Page Titles

   //Global Display Settings
   @FindBy(xpath = " //select[@name='labelFont']")
   public WebElement FORM_LABEL_FONT_DROPDOWN;
    @FindBy(xpath = " //select[@name='labelAlign']")
    public WebElement FORM_LABEL_ALIGNMENT_DROPDOWN;
    @FindBy(xpath = " //select[@name='labelVAlign']")
    public WebElement FORM_LABEL_VERTICAL_DROPDOWN;
    @FindBy(xpath = " //select[@name='inputPosition']")
    public WebElement FORM_LAYOUT_DROPDOWN;
    @FindBy(xpath = " //select[@name='inputAlign']")
    public WebElement FORM_INPUT_ALIGNMENT_DROPDOWN;
    @FindBy(xpath = " //select[@name='inputVAlign']")
    public WebElement FORM_INPUT_VERTICAL_DROPDOWN;
    @FindBy(xpath = " //select[@name='instructionsFont']")
    public WebElement FORM_INSTRUCTIONS_FONT_DROPDOWN;
    @FindBy(xpath = " //select[@name='pageHTMLFont']")
    public WebElement FORM_PAGE_FONT_DROPDOWN;
    @FindBy(xpath = " //select[@name='reqFieldFont']")
    public WebElement FORM_REQUIRED_FONT_DROPDOWN;
    @FindBy(xpath = "//input[@id='newTable']")
    public WebElement FORM_NEW_TAB_CHECKBOX;
    @FindBy(xpath = "//input[@id='navBarShowRegForm']")
    public WebElement FORM_NAVIGATION_CHECKBOX;



    //Required Fields Settings
    @FindBy(xpath = "//input[@name='reqImg']")
    public WebElement FORM_REQUIRED_IMAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='reqImgAttributes']")
    public WebElement FORM_REQUIRED_IMAGE_ATTRIBUTES_TEXTBOX;
    @FindBy(xpath = "//input[@name='reqMessage']")
    public WebElement FORM_REQUIRED_IMAGE_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorMessage']")
    public WebElement FORM_ERROR_MESSAGE_TEXTBOX;

    //Required Fields Messages
    @FindBy(xpath = "//input[@name='errorRequired']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorNotValid']")
    public WebElement FORM_REQUIRED_FIELDS_INVALID_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorOptionNotValid']")
    public WebElement FORM_REQUIRED_FIELDS_NOT_VALID_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorOptionNotAvail']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_OPTION_NOT_AVAILABLE_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorOutOfRange']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_OUT_OF_RANGE_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorBadSize']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_BAD_SIZE_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorNumberAnswers']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_NUMBER_ANSWERS_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorRangeSeparator']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_RANGE_SEPARATOR_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorNotInteger']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_NOT_INTEGER_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorNotNumeric']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_NOT_NUMERIC_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorNotPositive']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_NOT_POSITIVE_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorNotEmail']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_NOT_EMAIL_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorEmailsNotMatch']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_EMAILS_NOT_MATCH_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorNotDate']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_NOT_DATE_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorNotTime']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_NOT_TIME_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorNotDateTime']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_NOT_DATE_TIME_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorNotUSPhone']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_NOT_US_PHONE_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorNotUSZip']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_NOT_US_ZIP_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorPINTaken']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_PIN_TAKEN_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorPasswordsNotMatch']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_PASSWORD_MISMATCH_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorPmtTooBig']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_PAYMENT_TOO_BIG_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorOtherFormFieldsNoMatch']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_OTHER_FIELD_NO_MATCH_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorOtherFormFieldRequired']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_OTHER_FIELD_REQUIRED_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorInvalidCCNumber']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_Invalid_CC_NUMBER_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorInvalidCCExpDate']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_Invalid_CC_EXPIRY_DATE_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorInvalidCCFormat']")
    public WebElement FORM_REQUIRED_FIELDS_ERROR_Invalid_CC_Format_MESSAGE_TEXTBOX;

    //Agenda Item Error Messages
    @FindBy(xpath = "//input[@name='errorNoInventory']")
    public WebElement FORM_AGENDA_ITEM_ERROR_NO_INVENTORY_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorSessionExpired']")
    public WebElement FORM_AGENDA_ITEM_ERROR_SESSION_TIMEOUT_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorInvalidRegStatus']")
    public WebElement FORM_AGENDA_ITEM_ERROR_QUESTION_ABOUT_REGISTRATION_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorMinCapacity']")
    public WebElement FORM_AGENDA_ITEM_ERROR_MIN_CAPACITY_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='errorMaxCapacity']")
    public WebElement FORM_AGENDA_ITEM_ERROR_MAX_CAPACITY_MESSAGE_TEXTBOX;
    @FindBy(xpath = "//input[@name='dateConflictMessage']")
    public WebElement FORM_AGENDA_ITEM_ERROR_DATE_CONFLICT_MESSAGE_TEXTBOX;

    //Labels for Registration Assistance Link
    @FindBy(xpath = "//input[@name='instructions']")
    public WebElement FORM_REG_ASSISTANCE_INSTRUCTIONS_LABELS_TEXTBOX;
    @FindBy(xpath = "//input[@name='headerText']")
    public WebElement FORM_REG_ASSISTANCE_HEADER_LABELS_TEXTBOX;
    @FindBy(xpath = "//input[@name='pageHTML']")
    public WebElement FORM_REG_ASSISTANCE_PAGE_LABELS_TEXTBOX;
    @FindBy(xpath = "//input[@name='contactname']")
    public WebElement FORM_REG_ASSISTANCE_NAME_LABELS_TEXTBOX;
    @FindBy(xpath = "//input[@name='contactEmail']")
    public WebElement FORM_REG_ASSISTANCE_EMAIL_LABELS_TEXTBOX;
    @FindBy(xpath = "//input[@name='contactSubject']")
    public WebElement FORM_REG_ASSISTANCE_SUBJECT_LABELS_TEXTBOX;
    @FindBy(xpath = "//input[@name='contactMessage']")
    public WebElement FORM_REG_ASSISTANCE_MESSAGE_LABELS_TEXTBOX;
    @FindBy(xpath = "//input[@name='contactRegAsst']")
    public WebElement FORM_REG_ASSISTANCE_CONTACT_LABELS_TEXTBOX;

    //Labels for Buttons and Links
    @FindBy(xpath = "//input[@name='buttonText']")
    public WebElement FORM_BUTTONS_CONTINUE_LABELS_TEXTBOX;
    @FindBy(xpath = "//input[@name='resetText']")
    public WebElement FORM_BUTTONS_RESET_LABELS_TEXTBOX;
    @FindBy(xpath = "//input[@name='addRegText']")
    public WebElement FORM_LINKS_ADDITIONAL_REGISTRANTS_LABELS_TEXTBOX;;
    @FindBy(xpath = "//input[@name='newRegLink']")
    public WebElement FORM_LINKS_NEW_REG_LABELS_TEXTBOX;;
    @FindBy(xpath = "//input[@name='eventUrlLink']")
    public WebElement FORM_LINKS_LAST_PAGE_URL_LABELS_TEXTBOX;;
    @FindBy(xpath = "//input[@name='eventUrl']")
    public WebElement FORM_LINKS_LAST_PAGE_Url_LABELS_TEXTBOX;;
    @FindBy(xpath = "//input[@name='regAsstLink']")
    public WebElement FORM_LINKS_REG_ASSISTANCE_LABELS_TEXTBOX;;

    private final String NEW_PAGE = "New Page";
    private final String SECURE_PAGE = "Secure Page";
    @FindBy(xpath = "//table[@class='forms']//select[@class='form-control ']/option[contains(@title, 'New Page')]")
    public WebElement NEW_PAGE_AVAILABLE_SECTIONS;
    @FindBy(xpath = "//table[@class='forms']//select[@class='form-control ']/option[contains(@title, 'Secure Page')]")
    public WebElement SECURE_PAGE_AVAILABLE_SECTIONS;
    @FindBy(xpath = "//input[contains(@title, 'Right')]")
    public WebElement MOVE_RIGHT_BUTTON;
    @FindBy(xpath = "//input[contains(@title, 'Left')]")
    public WebElement MOVE_LEFT_BUTTON;
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//select[@id='form_exit_frn_reg_sts_id']")
    public WebElement REG_STATUS_COMPLETION;
    @FindBy(xpath = "//label[text()='URL']//..//a")
    public WebElement URL_LINK;
    @FindBy(xpath = "//input[@value='Preview']")
    public WebElement PREVIEW_BUTTON;
    @FindBy(xpath = "//select[@id='FormSections']/option[@title='Attendee Type']//following-sibling::option")
    public List<WebElement> ATTENDEE_TYPE_FOLLOWING_OPTIONS;
    @FindBy(xpath = ("//div[@id='sidebar-wrapper']//a[text()='Registrant Details']"))
    public WebElement REGISTRATION_DETAILS_TAB;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Payment']")
    public WebElement PAYMENT_TAB;

    public SetUpPage (WebDriver driver) throws ConfigurationException{
     PageFactory.initElements(driver, this);
    }

    public RegistrantDetailsPage clickRegistrantDetailsTab() throws Exception {
        click(REGISTRATION_DETAILS_TAB);
        VerifyPageReady(30);
        return new RegistrantDetailsPage(browser);
    }

    public void arrangeSections(String[] sectionsToInclude) throws Exception {
        removeSectionsFollowingAttendeeType();
        for (String section : sectionsToInclude)
            addSections(section);
    }

    /**
     * Method for add  section in listbox
     *
     * @param sectionName name of section
     */
    private void addSections(String sectionName) {
        if (sectionName.equalsIgnoreCase(NEW_PAGE))
            click(NEW_PAGE_AVAILABLE_SECTIONS);
        else if (sectionName.equalsIgnoreCase(SECURE_PAGE))
            click(SECURE_PAGE_AVAILABLE_SECTIONS);
        else
            click(browser.findElement(By.xpath("//table[@class='forms']//select[@class='form-control ']/option[@title='" + sectionName + "']")));
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        clickMoveRightButton();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        if (sectionName.equalsIgnoreCase(NEW_PAGE))
            click(NEW_PAGE_AVAILABLE_SECTIONS);
        else if (sectionName.equalsIgnoreCase(SECURE_PAGE))
            click(SECURE_PAGE_AVAILABLE_SECTIONS);
        else
            click(browser.findElement(By.xpath("//table[@class='forms']//select[@class='form-control ']/option[@title='" + sectionName + "']")));
    }

    private void clickMoveRightButton() {
        clickByJavaScript(MOVE_RIGHT_BUTTON);
    }

    /**
     * Method for clicking move left button
     */
    private void clickMoveLeftButton() {
        clickByJavaScript(MOVE_LEFT_BUTTON);
    }

    /**
     * Method for remove scetion in listbox
     */
    private void removeSectionsFollowingAttendeeType() throws Exception {
        Wait(ATTENDEE_TYPE_FOLLOWING_OPTIONS.get(0), 10);
        for (WebElement option : ATTENDEE_TYPE_FOLLOWING_OPTIONS) {
            click(option);
            clickMoveLeftButton();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }


    public void editSetupInformationDetails(AddFormData addFormData) throws Exception {
  Wait(SAVE_BUTTON_FORM, 30);
  VerifyAjaxRequestsFinished(30);
  type(FORM_NAME_TEXTBOX, addFormData.getFormName(), true );
  type(FORM_SUBTITLE_TEXTBOX, addFormData.getSubtitle(), true);
  type(FORM_EMAIL_CC_TEXTBOX, addFormData.getCc(), true);
  type(FORM_HYPERLINK_LABEL_TEXTBOX, addFormData.getHyperlinkLabel(), true);
  type(FORM_GOOGLE_ANALYTICS_TRACKING_ID_TEXTBOX, addFormData.getGoogleTrackingID(), true);
  select(FORM_REG_STATUS_DROPDOWN, addFormData.getRegStatus());
  type(FORM_NOTES_TEXTAREA, addFormData.getUserNotes() , true);
 }

    public void clickSaveButton() throws Exception {
        clickByJavaScript(SAVE_BUTTON);
        logReport("Save button clicked successfully");
        VerifyPageReady(30);
    }

    public void selectRegStatusCompletion(String status) throws Exception {
        Wait(REG_STATUS_COMPLETION, 10);
        select(REG_STATUS_COMPLETION, status);
        logReport("Selected reg status completion value " + status);
    }

    public FormPreviewHomePage clickUrlLink() throws Exception {
        Wait(URL_LINK, 20);
        click(URL_LINK);
        VerifyPageReady(20);
        reporter.info("Url link clicked successfully");
        VerifyAjaxRequestsFinished(20);
        return new FormPreviewHomePage(browser);
    }

    public FormPreviewHomePage clickPreviewButton() throws Exception {
        Wait(PREVIEW_BUTTON, 20);
        clickByJavaScript(PREVIEW_BUTTON);
        VerifyPageReady(20);
        reporter.info("Preview Button clicked successfully");
        VerifyAjaxRequestsFinished(20);
        return new FormPreviewHomePage(browser);
    }

    public PaymentPage clickPaymentTab() throws Exception {
        Wait(PAYMENT_TAB, 10);
        clickByJavaScript(PAYMENT_TAB);
        logReport("Payment tab clicked successfully");
        VerifyPageReady(30);
        return new PaymentPage(browser);
    }
 }
