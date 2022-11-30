package pageObjects.EventRegistrations;

import dataprovider.TestData;
import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pageObjects.Forms.VerifyPage;
import pojo.CustomQuestionData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AttendeeOverviewPage extends CommonActionsPage {

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Session information.']")
    public WebElement SESSIONS_TAB;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Profile Overview.']")
    public WebElement PROFILE_OVERVIEW_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Contact information for profile.']")
    public WebElement PROFILE_CONTACT_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Answers to custom profile questions.']")
    public WebElement PROFILE_QUESTIONS_TAB;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Attendee profile and registration information.']")
    public WebElement REGISTRATION_PROFILE_OVERVIEW_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Attendee registration overview information.']")
    public WebElement REGISTRATION_OVERVIEW_TAB;
    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Answers to custom profile and registration questions.']")
    public WebElement REGISTRATION_QUESTIONS_TAB;
    @FindBy(xpath = "//a[@title='Event Dashboard']")
    public WebElement EVENT_DASHBOARD_LINK;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[@title='Attendee profile and registration information.']")
    public WebElement PROFILE_TAB;

    @FindBy(xpath = "//button[@title='Show Password']")
    public WebElement PROFILE_PASSWORD_SHOW_BUTTON;

    @FindBy(xpath = "//h1")
    public WebElement PROFILE_OVERVIEW_HEADER;
    @FindBy(xpath = "//h1//small")
    public WebElement REG_CODE_TEXT;
    @FindBy(xpath = "//td[text()='Profile Unique Id:']/..//td[4]")
    public WebElement PROFILE_UNIQUE_ID;

    //Default Standard fields
    @FindBy(xpath = "//input[@id='pro_password']")
    public WebElement PROFILE_PASSWORD_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_add_email']")
    public WebElement ADDITIONAL_EMAIL_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_add_name']")
    public WebElement ADDITIONAL_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_add_phone']")
    public WebElement ADDITIONAL_PHONE_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_asst_email']")
    public WebElement ASSISTANT_EMAIL_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_asst_name']")
    public WebElement ASSISTANT_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_asst_phone']")
    public WebElement ASSISTANT_PHONE_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_badge_name']")
    public WebElement BADGE_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@id='pro_dob']")
    public WebElement DOB_DATEPICKER;
    @FindBy(xpath = "//input[@name='pro_email']")
    public WebElement EMAIL_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_external_frn_key']")
    public WebElement EXTERNAL_PROFILEID_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_fax']")
    public WebElement FAX_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_fname']")
    public WebElement FIRST_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_lname']")
    public WebElement LAST_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_phone']")
    public WebElement PHONE_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_phone2']")
    public WebElement OTHER_PHONE_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_phone_mobile']")
    public WebElement MOBILE_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_pin']")
    public WebElement USERNAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_social_facebook']")
    public WebElement FACEBOOK_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_social_linkedin']")
    public WebElement LINKEDIN_TEXTBOX;

    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement SAVE_BUTTON;

    @FindBy(xpath = "//input[@name='pro_position']")
    public WebElement POSITION_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_organization']")
    public WebElement ORGANIZATION_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_prefix']")
    public WebElement PREFIX_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_mname']")
    public WebElement MI_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_suffix']")
    public WebElement SUFFIX_TEXTBOX;
    @FindBy(xpath = "//select[@name='pro_frn_gender_id']")
    public WebElement GENDER_DROPDOWN;
    @FindBy(xpath = "//input[@id='pro_avatar']")
    public WebElement BROWSE_BUTTON;
    @FindBy(xpath = "//input[@name='pro_password']")
    public WebElement PASSWORD_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_social_google']")
    public WebElement GOOGLE_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_social_twitter']")
    public WebElement TWITTER_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_addr_line1']")
    public WebElement ADDRESS_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_addr_line2']")
    public WebElement ADDRESS_LINE2_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_addr_line3']")
    public WebElement ADDRESS_LINE3_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_addr_line4']")
    public WebElement ADDRESS_LINE4_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_addr_city']")
    public WebElement CITY_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_addr_intl_state']")
    public WebElement REGION_TEXTBOX;
    @FindBy(xpath = "//select[@id='pro_addr_state']")
    public WebElement STATE_DROPDOWN;
    @FindBy(xpath = "//input[@name='pro_addr_postal_code']")
    public WebElement POSTAL_CODE_TEXTBOX;
    @FindBy(xpath = "//select[@id='pro_addr_country']")
    public WebElement COUNTRY_DROPDOWN;
    @FindBy(xpath = "//input[@id='pro_is_user_1']")
    public WebElement WEBSITES_CHECKBOX;
    @FindBy(xpath = "//input[@name='pro_alt_addr_line3']")
    public WebElement BILLTO_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_alt_addr_line4']")
    public WebElement BILLTO_ORGANIZATION_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_alt_addr_line1']")
    public WebElement ADDRESS2_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_alt_addr_line2']")
    public WebElement ADDRESS2_LINE2_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_alt_addr_city']")
    public WebElement CITY2_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_alt_addr_intl_state']")
    public WebElement REGION2_TEXTBOX;
    @FindBy(xpath = "//select[@id='pro_alt_addr_state']")
    public WebElement STATE2_DROPDOWN;
    @FindBy(xpath = "//input[@name='pro_alt_addr_postal_code']")
    public WebElement POSTAL2_CODE_TEXTBOX;
    @FindBy(xpath = "//select[@id='pro_alt_addr_country']")
    public WebElement COUNTRY2_DROPDOWN;
    @FindBy(xpath = "//input[@name='pro_ship_addr_line3']")
    public WebElement SHIPTO_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_ship_addr_line4']")
    public WebElement SHIPTO_ORGANIZATION_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_ship_addr_line1']")
    public WebElement ADDRESS3_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_ship_addr_line2']")
    public WebElement ADDRESS3_LINE2_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_ship_addr_city']")
    public WebElement CITY3_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_ship_addr_intl_state']")
    public WebElement REGION3_TEXTBOX;
    @FindBy(xpath = "//select[@id='pro_ship_addr_state']")
    public WebElement STATE3_DROPDOWN;
    @FindBy(xpath = "//input[@name='pro_ship_addr_postal_code']")
    public WebElement POSTAL3_CODE_TEXTBOX;
    @FindBy(xpath = "//select[@id='pro_ship_addr_country']")
    public WebElement COUNTRY3_DROPDOWN;
    @FindBy(xpath = "//textarea[@id='pro_notes']")
    public WebElement USER_NOTES_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_url']")
    public WebElement WEB_ADDRESS_TEXTBOX;

    @FindBy(xpath = "//div[@class='panel-heading']")
    public List<WebElement> SECTION_HEADER;

    //public static final By PHONE_TEXTBOX = By.xpath("//input[@name='pro_phone']");
    @FindBy(xpath = "//a[text()='Add a new registration']")
    public WebElement ADD_REGISTRATION_BUTTON;


    public AttendeeOverviewPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public SessionInformationPage clickSessionTab() throws Exception {
        Wait(SESSIONS_TAB, 20);
        click(SESSIONS_TAB);
        VerifyAngularHasFinishedProcessing(30);
        reporter.info("Session tab clicked successfully");
        return new SessionInformationPage(browser);
    }

    public AttendeeProfilePage clickProfileTab() throws Exception {
        Wait(PROFILE_TAB, 30);
        click(PROFILE_TAB);
        logReport("Profile tab clicked successfully");
        VerifyAngularHasFinishedProcessing(20);
        VerifyAjaxRequestsFinished(20);
        return new AttendeeProfilePage(browser);
    }
    public boolean getDefaultSpeakerStandardFieldsData(String matchString) {

        List<String> defaultStandardFieldsData = new ArrayList<>();

        String badgeName = BADGE_NAME_TEXTBOX.getAttribute("value").trim();
        String dob = DOB_DATEPICKER.getAttribute("value").trim();
        String firstName = FIRST_NAME_TEXTBOX.getAttribute("value").trim();
        String lastName = LAST_NAME_TEXTBOX.getAttribute("value").trim();
        String email = EMAIL_TEXTBOX.getAttribute("value").trim();
        String phone = PHONE_TEXTBOX.getAttribute("value").trim();
        String fax = FAX_TEXTBOX.getAttribute("value").trim();
        String mobilePhone = MOBILE_TEXTBOX.getAttribute("value").trim();

        defaultStandardFieldsData.add(firstName);
        defaultStandardFieldsData.add(lastName);
        defaultStandardFieldsData.add(lastName);
        defaultStandardFieldsData.add(email);
        defaultStandardFieldsData.add(badgeName);
        defaultStandardFieldsData.add(phone);
        defaultStandardFieldsData.add(fax);
        defaultStandardFieldsData.add(mobilePhone);

        logReport("Actual default standard speaker fields details " + defaultStandardFieldsData);

        return badgeName.equalsIgnoreCase(matchString) && dob.equalsIgnoreCase("") && email.equalsIgnoreCase(matchString)
                && fax.equalsIgnoreCase(matchString) && firstName.equalsIgnoreCase(matchString) && lastName.equalsIgnoreCase(matchString)
                && phone.equalsIgnoreCase(matchString) && mobilePhone.equalsIgnoreCase(matchString);
    }

    public boolean getAllSpeakerStandardFieldsData(String matchString) {

        List<String> allStandardFieldsData = new ArrayList<>();
        // Confirm Email

        //Get password value
        clickByJavaScript(PROFILE_PASSWORD_TEXTBOX);
        clickByJavaScript(PROFILE_PASSWORD_SHOW_BUTTON);

        //Contact information
        String password = PROFILE_PASSWORD_TEXTBOX.getAttribute("value").trim();
        String firstName = FIRST_NAME_TEXTBOX.getAttribute("value").trim();
        String lastName = LAST_NAME_TEXTBOX.getAttribute("value").trim();
        String email = EMAIL_TEXTBOX.getAttribute("value").trim();
        String position = POSITION_TEXTBOX.getAttribute("value").trim();
        String organization = ORGANIZATION_TEXTBOX.getAttribute("value").trim();
        String userName = USERNAME_TEXTBOX.getAttribute("value").trim();
        String prefix = PREFIX_TEXTBOX.getAttribute("value").trim();
        String mi = MI_TEXTBOX.getAttribute("value").trim();
        String suffix = SUFFIX_TEXTBOX.getAttribute("value").trim();
        String badgeName = BADGE_NAME_TEXTBOX.getAttribute("value").trim();
        String gender = GENDER_DROPDOWN.getAttribute("value").trim();
        String dob = DOB_DATEPICKER.getAttribute("value").trim();

        //Contact details
        String phone = PHONE_TEXTBOX.getAttribute("value").trim();
        String fax = FAX_TEXTBOX.getAttribute("value").trim();
        String mobilePhone = MOBILE_TEXTBOX.getAttribute("value").trim();
        String altPhone = OTHER_PHONE_TEXTBOX.getAttribute("value").trim();
        String webAddress = WEB_ADDRESS_TEXTBOX.getAttribute("value").trim();
        String facebookLink = FACEBOOK_TEXTBOX.getAttribute("value").trim();
        String linkedIn = LINKEDIN_TEXTBOX.getAttribute("value").trim();
        String assistantName = ASSISTANT_NAME_TEXTBOX.getAttribute("value").trim();
        String assistantEmail = ASSISTANT_EMAIL_TEXTBOX.getAttribute("value").trim();
        String assistantPhone = ASSISTANT_PHONE_TEXTBOX.getAttribute("value").trim();
        String google = GOOGLE_TEXTBOX.getAttribute("value").trim();
        String twitter = TWITTER_TEXTBOX.getAttribute("value").trim();

        //Mailing Address
        String address = ADDRESS_TEXTBOX.getAttribute("value").trim();
        String addressLine2 = ADDRESS_LINE2_TEXTBOX.getAttribute("value").trim();
        String city = CITY_TEXTBOX.getAttribute("value").trim();
        String region = REGION_TEXTBOX.getAttribute("value").trim();
        String state = STATE_DROPDOWN.getAttribute("value").trim();
        String postalCode = POSTAL_CODE_TEXTBOX.getAttribute("value").trim();
        String country = COUNTRY_DROPDOWN.getAttribute("value").trim();
        String additionalName = ADDITIONAL_NAME_TEXTBOX.getAttribute("value").trim();
        String additionalEmail = ADDITIONAL_EMAIL_TEXTBOX.getAttribute("value").trim();
        String additionalPhone = ADDITIONAL_PHONE_TEXTBOX.getAttribute("value").trim();

        allStandardFieldsData.add(password);
        allStandardFieldsData.add(firstName);
        allStandardFieldsData.add(lastName);
        allStandardFieldsData.add(email);
        allStandardFieldsData.add(position);
        allStandardFieldsData.add(organization);
        allStandardFieldsData.add(userName);
        allStandardFieldsData.add(prefix);
        allStandardFieldsData.add(mi);
        allStandardFieldsData.add(suffix);
        allStandardFieldsData.add(badgeName);
        allStandardFieldsData.add(gender);
        allStandardFieldsData.add(dob);

        allStandardFieldsData.add(phone);
        allStandardFieldsData.add(fax);
        allStandardFieldsData.add(mobilePhone);
        allStandardFieldsData.add(altPhone);
        allStandardFieldsData.add(webAddress);
        allStandardFieldsData.add(facebookLink);
        allStandardFieldsData.add(linkedIn);
        allStandardFieldsData.add(assistantName);
        allStandardFieldsData.add(assistantEmail);
        allStandardFieldsData.add(assistantPhone);
        allStandardFieldsData.add(google);
        allStandardFieldsData.add(twitter);

        allStandardFieldsData.add(address);
        allStandardFieldsData.add(addressLine2);
        allStandardFieldsData.add(city);
        allStandardFieldsData.add(region);
        allStandardFieldsData.add(state);
        allStandardFieldsData.add(postalCode);
        allStandardFieldsData.add(country);
        allStandardFieldsData.add(additionalName);
        allStandardFieldsData.add(additionalEmail);
        allStandardFieldsData.add(additionalPhone);

        logReport("Actual all standard speaker fields details " + allStandardFieldsData);

        return firstName.equalsIgnoreCase(matchString) && lastName.equalsIgnoreCase(matchString) && email.equalsIgnoreCase(matchString) && position.equalsIgnoreCase(matchString)
                && organization.equalsIgnoreCase(matchString) && prefix.equalsIgnoreCase(matchString) && mi.equalsIgnoreCase(matchString)
                && suffix.equalsIgnoreCase(matchString) && badgeName.equalsIgnoreCase(matchString) && gender.equalsIgnoreCase("") && dob.equalsIgnoreCase("")
                && phone.equalsIgnoreCase(matchString) && fax.equalsIgnoreCase(matchString) && mobilePhone.equalsIgnoreCase(matchString) && webAddress.equalsIgnoreCase(matchString)
                && facebookLink.equalsIgnoreCase(matchString) && linkedIn.equalsIgnoreCase(matchString) && google.equalsIgnoreCase(matchString) && twitter.equalsIgnoreCase(matchString)
                && address.equalsIgnoreCase(matchString) && addressLine2.equalsIgnoreCase(matchString) && city.equalsIgnoreCase(matchString) && state.equalsIgnoreCase("")
                && postalCode.equalsIgnoreCase(matchString) && country.equalsIgnoreCase("");

    }

    public boolean getDefaultStandardFieldsData(String matchString) {
        List<String> defaultStandardFieldsData = new ArrayList<>();
        // Confirm Email
        //Get password value
        //clickByJavaScript(PROFILE_PASSWORD_TEXTBOX);
        //clickByJavaScript(PROFILE_PASSWORD_SHOW_BUTTON);

        //String password = PROFILE_PASSWORD_TEXTBOX.getAttribute("value").trim();
        String additionalEmail = ADDITIONAL_EMAIL_TEXTBOX.getAttribute("value").trim();
        String additionalName = ADDITIONAL_NAME_TEXTBOX.getAttribute("value").trim();
        String additionalPhone = ADDITIONAL_PHONE_TEXTBOX.getAttribute("value").trim();

        String assistantEmail = ASSISTANT_EMAIL_TEXTBOX.getAttribute("value").trim();
        String assistantName = ASSISTANT_NAME_TEXTBOX.getAttribute("value").trim();
        String assistantPhone = ASSISTANT_PHONE_TEXTBOX.getAttribute("value").trim();

        String badgeName = BADGE_NAME_TEXTBOX.getAttribute("value").trim();
        String dob = DOB_DATEPICKER.getAttribute("value").trim();
        String email = EMAIL_TEXTBOX.getAttribute("value").trim();
        String externalProfileId = EXTERNAL_PROFILEID_TEXTBOX.getAttribute("value").trim();
        String fax = FAX_TEXTBOX.getAttribute("value").trim();
        String firstName = FIRST_NAME_TEXTBOX.getAttribute("value").trim();
        String lastName = LAST_NAME_TEXTBOX.getAttribute("value").trim();
        String phone = PHONE_TEXTBOX.getAttribute("value").trim();
        String altPhone = OTHER_PHONE_TEXTBOX.getAttribute("value").trim();
        String mobilePhone = MOBILE_TEXTBOX.getAttribute("value").trim();
        //String userName = USERNAME_TEXTBOX.getAttribute("value").trim();

        // defaultStandardFieldsData.add(password);
        defaultStandardFieldsData.add(additionalEmail);
        defaultStandardFieldsData.add(additionalName);
        defaultStandardFieldsData.add(additionalPhone);
        defaultStandardFieldsData.add(assistantEmail);
        defaultStandardFieldsData.add(assistantName);
        defaultStandardFieldsData.add(assistantPhone);
        defaultStandardFieldsData.add(badgeName);
        defaultStandardFieldsData.add(dob);
        defaultStandardFieldsData.add(email);
        defaultStandardFieldsData.add(externalProfileId);
        defaultStandardFieldsData.add(fax);
        defaultStandardFieldsData.add(firstName);
        defaultStandardFieldsData.add(lastName);
        defaultStandardFieldsData.add(phone);
        defaultStandardFieldsData.add(altPhone);
        defaultStandardFieldsData.add(mobilePhone);
        // defaultStandardFieldsData.add(userName);

        logReport("Actual default standard fields details " + defaultStandardFieldsData);

        return additionalEmail.equalsIgnoreCase(matchString) && additionalName.equalsIgnoreCase(matchString) && additionalPhone.equalsIgnoreCase(matchString) && assistantEmail.equalsIgnoreCase(matchString)
                && assistantName.equalsIgnoreCase(matchString) && assistantPhone.equalsIgnoreCase(matchString) && badgeName.equalsIgnoreCase(matchString) && dob.equalsIgnoreCase("")
                && email.equalsIgnoreCase(matchString) && externalProfileId.equalsIgnoreCase(matchString) && fax.equalsIgnoreCase(matchString) && firstName.equalsIgnoreCase(matchString)
                && lastName.equalsIgnoreCase(matchString) && phone.equalsIgnoreCase(matchString) && altPhone.equalsIgnoreCase(matchString) && mobilePhone.equalsIgnoreCase(matchString);
    }

    //Answer for radio, select, checkbox and select multiple type
    public void assignCustomQuestionAnswer(String questionType, String questionTitle, String answer) {
        if (questionType.equalsIgnoreCase("Radio") || questionType.equalsIgnoreCase("Select")) {
            String xpath = "//select[@title='" + questionTitle + "']";
            WebElement element = browser.findElement(By.xpath(xpath));
            select(element, answer);
            logReport("Enter answer : " + answer + " for the question : " + questionTitle);
        } else if (questionType.equalsIgnoreCase("Checkbox") || questionType.equalsIgnoreCase("Select multiple")) {
            String xpath = "//label[text()='" + questionTitle + "']/../../../..//select";
            WebElement element = browser.findElement(By.xpath(xpath));
            select(element, answer);
            logReport("Enter answer : " + answer + " for the question : " + questionTitle);
        } else {
            logReport("Enter answer : " + answer + " for the question : " + questionTitle);
        }
    }

    public void clickSave() throws Exception {
        Wait(SAVE_BUTTON, 20);
        click(SAVE_BUTTON);
        VerifyAngularHasFinishedProcessing(20);
        logReport("Save button clicked successfully.");
    }

    public boolean getAllProfileStandardFieldsData(String matchString) {

        List<String> allStandardFieldsData = new ArrayList<>();
        // Confirm Email

        //Get password value
        // clickByJavaScript(PROFILE_PASSWORD_TEXTBOX);
        // clickByJavaScript(PROFILE_PASSWORD_SHOW_BUTTON);

        //Contact information
        // String password = PROFILE_PASSWORD_TEXTBOX.getAttribute("value").trim();
        String firstName = FIRST_NAME_TEXTBOX.getAttribute("value").trim();
        String lastName = LAST_NAME_TEXTBOX.getAttribute("value").trim();
        String email = EMAIL_TEXTBOX.getAttribute("value").trim();
        String position = POSITION_TEXTBOX.getAttribute("value").trim();
        String organization = ORGANIZATION_TEXTBOX.getAttribute("value").trim();
        String userName = USERNAME_TEXTBOX.getAttribute("value").trim();
        String externalProfileId = EXTERNAL_PROFILEID_TEXTBOX.getAttribute("value").trim();
        String prefix = PREFIX_TEXTBOX.getAttribute("value").trim();
        String mi = MI_TEXTBOX.getAttribute("value").trim();
        String suffix = SUFFIX_TEXTBOX.getAttribute("value").trim();
        String badgeName = BADGE_NAME_TEXTBOX.getAttribute("value").trim();
        String gender = GENDER_DROPDOWN.getAttribute("value").trim();
        String dob = DOB_DATEPICKER.getAttribute("value").trim();

        //Contact details
        String phone = PHONE_TEXTBOX.getAttribute("value").trim();
        String fax = FAX_TEXTBOX.getAttribute("value").trim();
        String mobilePhone = MOBILE_TEXTBOX.getAttribute("value").trim();
        String altPhone = OTHER_PHONE_TEXTBOX.getAttribute("value").trim();
        String webAddress = WEB_ADDRESS_TEXTBOX.getAttribute("value").trim();
        String facebookLink = FACEBOOK_TEXTBOX.getAttribute("value").trim();
        String linkedIn = LINKEDIN_TEXTBOX.getAttribute("value").trim();
        String assistantName = ASSISTANT_NAME_TEXTBOX.getAttribute("value").trim();
        String assistantEmail = ASSISTANT_EMAIL_TEXTBOX.getAttribute("value").trim();
        String assistantPhone = ASSISTANT_PHONE_TEXTBOX.getAttribute("value").trim();
        String google = GOOGLE_TEXTBOX.getAttribute("value").trim();
        String twitter = TWITTER_TEXTBOX.getAttribute("value").trim();

        //Mailing Address
        String address = ADDRESS_TEXTBOX.getAttribute("value").trim();
        String addressLine2 = ADDRESS_LINE2_TEXTBOX.getAttribute("value").trim();
        String addressLine3 = ADDRESS_LINE3_TEXTBOX.getAttribute("value").trim();
        String city = CITY_TEXTBOX.getAttribute("value").trim();
        String region = REGION_TEXTBOX.getAttribute("value").trim();
        String state = STATE_DROPDOWN.getAttribute("value").trim();
        String postalCode = POSTAL_CODE_TEXTBOX.getAttribute("value").trim();
        String country = COUNTRY_DROPDOWN.getAttribute("value").trim();
        String additionalName = ADDITIONAL_NAME_TEXTBOX.getAttribute("value").trim();
        String additionalEmail = ADDITIONAL_EMAIL_TEXTBOX.getAttribute("value").trim();
        String additionalPhone = ADDITIONAL_PHONE_TEXTBOX.getAttribute("value").trim();
        //String userNotes = USER_NOTES_TEXTBOX.getAttribute("value").trim();

        //Billing $ Shipping Address
        String billToName = BILLTO_NAME_TEXTBOX.getAttribute("value").trim();
        String billToOrganization = BILLTO_ORGANIZATION_TEXTBOX.getAttribute("value").trim();
        String billToAddress = ADDRESS2_TEXTBOX.getAttribute("value").trim();
        String billToAddressLine2 = ADDRESS2_LINE2_TEXTBOX.getAttribute("value").trim();
        String billToCity = CITY2_TEXTBOX.getAttribute("value").trim();
        String billToRegion = REGION2_TEXTBOX.getAttribute("value").trim();
        String billToState = STATE2_DROPDOWN.getAttribute("value").trim();
        String billToPostalCode = POSTAL2_CODE_TEXTBOX.getAttribute("value").trim();
        String billToCountry = COUNTRY2_DROPDOWN.getAttribute("value").trim();

        String shipToName = SHIPTO_NAME_TEXTBOX.getAttribute("value").trim();
        String shipToOrganization = SHIPTO_ORGANIZATION_TEXTBOX.getAttribute("value").trim();
        String shipToAddress = ADDRESS3_TEXTBOX.getAttribute("value").trim();
        String shipToAddressLine2 = ADDRESS3_LINE2_TEXTBOX.getAttribute("value").trim();
        String shipToCity = CITY3_TEXTBOX.getAttribute("value").trim();
        String shipToRegion = REGION3_TEXTBOX.getAttribute("value").trim();
        String shipToState = STATE3_DROPDOWN.getAttribute("value").trim();
        String shipToPostalCode = POSTAL3_CODE_TEXTBOX.getAttribute("value").trim();
        String shipToCountry = COUNTRY3_DROPDOWN.getAttribute("value").trim();

        //allStandardFieldsData.add(password);
        allStandardFieldsData.add(firstName);
        allStandardFieldsData.add(lastName);
        allStandardFieldsData.add(email);
        allStandardFieldsData.add(position);
        allStandardFieldsData.add(organization);
        allStandardFieldsData.add(userName);
        allStandardFieldsData.add(externalProfileId);
        allStandardFieldsData.add(prefix);
        allStandardFieldsData.add(mi);
        allStandardFieldsData.add(suffix);
        allStandardFieldsData.add(badgeName);
        allStandardFieldsData.add(gender);
        allStandardFieldsData.add(dob);

        allStandardFieldsData.add(phone);
        allStandardFieldsData.add(fax);
        allStandardFieldsData.add(mobilePhone);
        allStandardFieldsData.add(altPhone);
        allStandardFieldsData.add(webAddress);
        allStandardFieldsData.add(facebookLink);
        allStandardFieldsData.add(linkedIn);
        allStandardFieldsData.add(assistantName);
        allStandardFieldsData.add(assistantEmail);
        allStandardFieldsData.add(assistantPhone);
        allStandardFieldsData.add(google);
        allStandardFieldsData.add(twitter);

        allStandardFieldsData.add(address);
        allStandardFieldsData.add(addressLine2);
        allStandardFieldsData.add(addressLine3);
        allStandardFieldsData.add(city);
        allStandardFieldsData.add(region);
        allStandardFieldsData.add(state);
        allStandardFieldsData.add(postalCode);
        allStandardFieldsData.add(country);
        allStandardFieldsData.add(additionalName);
        allStandardFieldsData.add(additionalEmail);
        allStandardFieldsData.add(additionalPhone);
        //allStandardFieldsData.add(userNotes);

        allStandardFieldsData.add(billToName);
        allStandardFieldsData.add(billToOrganization);
        allStandardFieldsData.add(billToAddress);
        allStandardFieldsData.add(billToAddressLine2);
        allStandardFieldsData.add(billToCity);
        allStandardFieldsData.add(billToRegion);
        allStandardFieldsData.add(billToState);
        allStandardFieldsData.add(billToPostalCode);
        allStandardFieldsData.add(billToCountry);

        allStandardFieldsData.add(shipToName);
        allStandardFieldsData.add(shipToOrganization);
        allStandardFieldsData.add(shipToAddress);
        allStandardFieldsData.add(shipToAddressLine2);
        allStandardFieldsData.add(shipToCity);
        allStandardFieldsData.add(shipToRegion);
        allStandardFieldsData.add(shipToState);
        allStandardFieldsData.add(shipToPostalCode);
        allStandardFieldsData.add(shipToCountry);

        logReport("Actual all standard profile fields details " + allStandardFieldsData);

        return firstName.equalsIgnoreCase(matchString) && lastName.equalsIgnoreCase(matchString) && email.equalsIgnoreCase(matchString) && position.equalsIgnoreCase(matchString)
                && organization.equalsIgnoreCase(matchString) && externalProfileId.equalsIgnoreCase(matchString) && prefix.equalsIgnoreCase(matchString) && mi.equalsIgnoreCase(matchString)
                && suffix.equalsIgnoreCase(matchString) && badgeName.equalsIgnoreCase(matchString) && gender.equalsIgnoreCase("") && dob.equalsIgnoreCase("")
                && phone.equalsIgnoreCase(matchString) && fax.equalsIgnoreCase(matchString) && mobilePhone.equalsIgnoreCase(matchString) && altPhone.equalsIgnoreCase(matchString)
                && webAddress.equalsIgnoreCase(matchString) && facebookLink.equalsIgnoreCase(matchString) && linkedIn.equalsIgnoreCase(matchString) && assistantName.equalsIgnoreCase(matchString)
                && assistantEmail.equalsIgnoreCase(matchString) && assistantPhone.equalsIgnoreCase(matchString) && google.equalsIgnoreCase(matchString) && twitter.equalsIgnoreCase(matchString)
                && address.equalsIgnoreCase(matchString) && addressLine2.equalsIgnoreCase(matchString) && addressLine3.equalsIgnoreCase(matchString) && city.equalsIgnoreCase(matchString)
                && region.equalsIgnoreCase("") && state.equalsIgnoreCase("") && postalCode.equalsIgnoreCase(matchString) && country.equalsIgnoreCase("")
                && additionalName.equalsIgnoreCase(matchString) && additionalEmail.equalsIgnoreCase(matchString) && additionalPhone.equalsIgnoreCase(matchString) && billToName.equalsIgnoreCase(matchString)
                && billToOrganization.equalsIgnoreCase(matchString) && billToAddress.equalsIgnoreCase(matchString) && billToAddressLine2.equalsIgnoreCase(matchString) && billToCity.equalsIgnoreCase(matchString)
                && billToRegion.equalsIgnoreCase("") && billToState.equalsIgnoreCase("") && billToPostalCode.equalsIgnoreCase(matchString) && billToCountry.equalsIgnoreCase("")
                && shipToName.equalsIgnoreCase(matchString) && shipToOrganization.equalsIgnoreCase(matchString) && shipToAddress.equalsIgnoreCase(matchString) && shipToAddressLine2.equalsIgnoreCase(matchString)
                && shipToCity.equalsIgnoreCase(matchString) && shipToRegion.equalsIgnoreCase("") && shipToState.equalsIgnoreCase("") && shipToPostalCode.equalsIgnoreCase(matchString)
                && shipToCountry.equalsIgnoreCase("");

    }

    public boolean getAllProfileCustomFieldsData(List<HashMap<String, String>> customQuestionFieldData) throws Exception {
        List<String> allCustomFieldsData = new ArrayList<>();
        TestData testData = new TestData(customQuestionFieldData);

        for (int i = 0; i < 6; i++) {
            CustomQuestionData customQuestionData = testData.getCustomQuestionDataList().get(i);
            String value = getCustomQuestionAnswer(customQuestionData.getQuestionType().trim(), customQuestionData.getName().trim());
            allCustomFieldsData.add(value);
            logReport("Actual all custom profile questions details " + allCustomFieldsData);
            if (!value.equalsIgnoreCase(customQuestionData.getDefaultAnswer().trim())) {
                return false;
            }
        }

        return true;
    }

    public String getCustomQuestionAnswer(String questionType, String questionTitle) {
        String value = "";
        if (questionType.equalsIgnoreCase("Radio") || questionType.equalsIgnoreCase("Select")) {
            String xpath = "//select[@title='" + questionTitle + "']";
            WebElement element = browser.findElement(By.xpath(xpath));
            value = getSelectedOption(element);
            logReport("Actual Answer : " + value + " for the question : " + questionTitle);
        } else if (questionType.equalsIgnoreCase("Checkbox") || questionType.equalsIgnoreCase("Select multiple")) {
            String xpath = "//label[text()='" + questionTitle + "']/../../../..//select/..//input[@name='flgMultiSelectAnswered']";
            WebElement element = browser.findElement(By.xpath(xpath));
            value = element.getAttribute("value").trim();
            logReport("Actual Answer : " + value + " for the question : " + questionTitle);
        } else if (questionType.equalsIgnoreCase("Text")) {
            String xpath = "//label//font[text()='" + questionTitle + "']/../..//following-sibling::td//input";
            WebElement element = browser.findElement(By.xpath(xpath));
            value = element.getAttribute("value").trim();
            logReport("Actual Answer : " + value + " for the question : " + questionTitle);
        } else if (questionType.equalsIgnoreCase("Textarea")) {
            String xpath = "//label//font[text()='" + questionTitle + "']/../..//following-sibling::td//textarea";
            WebElement element = browser.findElement(By.xpath(xpath));
            value = element.getAttribute("value").trim();
            logReport("Actual Answer : " + value + " for the question : " + questionTitle);
        }
        return value;
    }

    public boolean getAllAnonymizedProfileCustomFieldsData(List<HashMap<String, String>> customQuestionFieldData, String matchString) throws Exception {
        List<String> allCustomFieldsData = new ArrayList<>();
        TestData testData = new TestData(customQuestionFieldData);

        for (int i = 0; i < 6; i++) {
            CustomQuestionData customQuestionData = testData.getCustomQuestionDataList().get(i);
            String value = getCustomQuestionAnswer(customQuestionData.getQuestionType().trim(), customQuestionData.getName().trim());
            allCustomFieldsData.add(value);
            logReport("Actual all custom profile questions details " + allCustomFieldsData);
            if (customQuestionData.getQuestionType().trim().equalsIgnoreCase("Text") || customQuestionData.getQuestionType().trim().equalsIgnoreCase("Textarea") || customQuestionData.getQuestionType().trim().equalsIgnoreCase("Checkbox") || customQuestionData.getQuestionType().trim().equalsIgnoreCase("Select multiple")) {
                if (!value.equalsIgnoreCase(matchString)) {
                    return false;
                }
            } else if (!value.equalsIgnoreCase("")) {
                return false;
            }
        }
        return true;
    }

    public String getAllTypeCustomQuestionAnswer(String questionFor, String questionType, String questionTitle) {
        String value = "";
        String id = "";
        if (questionFor.equalsIgnoreCase("Profile")) {
            id = "CustomProfileInformationId";
        } else if (questionFor.equalsIgnoreCase("Registration")) {
            id = "CustomRegistrationInformationId";
        }

        if (questionType.equalsIgnoreCase("Radio") || questionType.equalsIgnoreCase("Select")) {
            String xpath = "//div[@id='" + id + "']//font[text()='" + questionTitle + "']/following::select[1]";
            WebElement element = browser.findElement(By.xpath(xpath));
            value = getSelectedOption(element);
            logReport("Actual Answer : " + value + " for the profile question : " + questionTitle);
        } else if (questionType.equalsIgnoreCase("Checkbox") || questionType.equalsIgnoreCase("Select multiple")) {
            String xpath = "//div[@id='" + id + "']//font[text()='" + questionTitle + "']/following::input[@name='flgMultiSelectAnswered'][1]";
            WebElement element = browser.findElement(By.xpath(xpath));
            value = element.getAttribute("value").trim();
            logReport("Actual Answer : " + value + " for the profile question : " + questionTitle);
        } else if (questionType.equalsIgnoreCase("Text")) {
            String xpath = "//div[@id='" + id + "']//font[text()='" + questionTitle + "']/following::input[1]";
            WebElement element = browser.findElement(By.xpath(xpath));
            value = element.getAttribute("value").trim();
            logReport("Actual Answer : " + value + " for the profile question : " + questionTitle);
        } else if (questionType.equalsIgnoreCase("Textarea")) {
            String xpath = "//div[@id='" + id + "']//font[text()='" + questionTitle + "']/following::textarea[1]";
            WebElement element = browser.findElement(By.xpath(xpath));
            value = element.getAttribute("value").trim();
            logReport("Actual Answer : " + value + " for the profile question : " + questionTitle);
        }
        return value;
    }

    public boolean getAllTypeAnonymizedCustomFieldsData(List<HashMap<String, String>> customQuestionFieldData, String matchString, String pageTitle) throws Exception {
        List<String> allCustomFieldsData = new ArrayList<>();
        TestData testData = new TestData(customQuestionFieldData);

        for (int i = 0; i < 12; i++) {
            CustomQuestionData customQuestionData = testData.getCustomQuestionDataList().get(i);
            if (pageTitle.equalsIgnoreCase("Questions")) {
                String value = getAllTypeCustomQuestionAnswer(customQuestionData.getQuestionFor().trim(), customQuestionData.getQuestionType().trim(), customQuestionData.getName().trim());
                allCustomFieldsData.add(value);
                logReport("Actual all custom profile questions details " + allCustomFieldsData);
                if (customQuestionData.getQuestionType().trim().equalsIgnoreCase("Text") || customQuestionData.getQuestionType().trim().equalsIgnoreCase("Textarea") || customQuestionData.getQuestionType().trim().equalsIgnoreCase("Checkbox") || customQuestionData.getQuestionType().trim().equalsIgnoreCase("Select multiple")) {
                    if (!value.equalsIgnoreCase(matchString)) {
                        return false;
                    }
                } else if (!value.equalsIgnoreCase("")) {
                    return false;
                }
            } else if (pageTitle.equalsIgnoreCase("Overview")) {
                String value = getAllCustomQuestionAnswerToOverviewpage(customQuestionData.getQuestionFor().trim(), customQuestionData.getName().trim(), customQuestionData.getCode().trim());
                if (!value.equalsIgnoreCase(matchString)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getAllCustomQuestionAnswerToOverviewpage(String questionFor, String questionTitle, String questionCode) {

        String xpathProfile = "//div[@id='ProfileId']//tr//td[text()='" + questionTitle + ":']/..//td[@class='c2 data']";
        String xpathRegistration = "//div[@id='RegistrationId']//tr//td[text()='" + questionCode + ":']/..//td[@class='data']";
        WebElement element;
        String value;
        if (questionFor.equalsIgnoreCase("Profile")) {
            element = browser.findElement(By.xpath(xpathProfile));
        } else {
            element = browser.findElement(By.xpath(xpathRegistration));
        }
        value = element.getText().trim();
        logReport("Actual Answer : " + value + " for the " + questionFor + " question : " + questionTitle);
        return value;
    }

    public boolean getAllCustomFieldsData(List<HashMap<String, String>> customQuestionFieldData) throws Exception {
        List<String> allCustomFieldsData = new ArrayList<>();
        TestData testData = new TestData(customQuestionFieldData);

        for (int i = 0; i < 12; i++) {
            CustomQuestionData customQuestionData = testData.getCustomQuestionDataList().get(i);
            String value = getAllTypeCustomQuestionAnswer(customQuestionData.getQuestionFor().trim(), customQuestionData.getQuestionType().trim(), customQuestionData.getName().trim());
            allCustomFieldsData.add(value);
            logReport("Actual all custom questions details " + allCustomFieldsData);
            if (!value.equalsIgnoreCase(customQuestionData.getDefaultAnswer().trim())) {
                return false;
            }
        }
        return true;
    }

    public boolean isSectionFound(String sectionName) {
        for (WebElement e : SECTION_HEADER) {
            if (e.getText().trim().equalsIgnoreCase(sectionName)) {
                return true;
            }
        }
        return false;
    }

    public CreateRegistrationPage clickAddRegistrationButton() throws Exception {
        Wait(ADD_REGISTRATION_BUTTON, 30);
        clickByJavaScript(ADD_REGISTRATION_BUTTON);
        logReport("Add Registration button clicked successfully");
        VerifyPageReady(30);
        return new CreateRegistrationPage(browser);
    }
}
