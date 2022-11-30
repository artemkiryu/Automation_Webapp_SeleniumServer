package pageObjects.Profiles;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pageObjects.EventRegistrations.AttendeeOverviewPage;
import pojo.*;

public class CreateProfilePage extends CommonActionsPage {

    public static final String CCEMAIL_CHECKBOX = "//input[@name='pro_asst_cc_email']";
    public static final String ADDITIONAL_INFO_CHECKBOX = "//input[@name='pro_add_cc_email']";
    public static final String ENABLE_MANUAL_OVERRIDE_CHECKBOX = "//input[@id='reg_is_availability_generated']";
    public static final String COMPLETE_CHECKBOX = "//label[text()[contains(.,'Complete')]]//../input";
    public static final String BADGE_PRINTED_CHECKBOX = "//label[text()[contains(.,'Badge Printed')]]//../input";
    public static final String ON_TODO_LIST_CHECKBOX = "//label[text()[contains(.,'On To Do List')]]//../input";
    public static final String INVOICE_GENERATED_CHECKBOX = "//label[text()[contains(.,'Invoice Generated')]]//../input";
    public static final String TEST_CHECKBOX = "//label[text()[contains(.,'Test')]]//../input";
    private final String COMPLETE = "Complete";
    private final String INCOMPLETE = "Incomplete";
    private final String BADGE_PRINTED = "Badge Printed";
    private final String ON_TO_DO_LIST = "On To Do List";
    private final String INVOICE_GENERATED = "Invoice Generated";
    private final String TEST = "Test";
    @FindBy(xpath = "//input[@name='pro_fname']")
    public WebElement FIRST_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_lname']")
    public WebElement LAST_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_email']")
    public WebElement EMAIL_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_position']")
    public WebElement POSITION_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_organization']")
    public WebElement ORGANIZATION_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_pin']")
    public WebElement USERNAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_external_frn_key']")
    public WebElement EXTERNAL_PROFILEID_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_prefix']")
    public WebElement PREFIX_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_mname']")
    public WebElement MI_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_suffix']")
    public WebElement SUFFIX_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_badge_name']")
    public WebElement BADGE_NAME_TEXTBOX;
    @FindBy(xpath = "//select[@name='pro_frn_gender_id']")
    public WebElement GENDER_DROPDOWN;
    @FindBy(xpath = "//input[@id='pro_dob']")
    public WebElement DOB_DATEPICKER;
    @FindBy(xpath = "//input[@id='pro_avatar']")
    public WebElement BROWSE_BUTTON;
    @FindBy(xpath = "//input[@name='pro_password']")
    public WebElement PASSWORD_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_asst_name']")
    public WebElement ASSISTANT_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_asst_email']")
    public WebElement ASSISTANT_EMAIL_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_asst_phone']")
    public WebElement ASSISTANT_PHONE_TEXTBOX;
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
    @FindBy(xpath = "//input[@name='pro_add_name']")
    public WebElement ADDITIONAL_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_add_email']")
    public WebElement ADDITIONAL_EMAIL_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_add_phone']")
    public WebElement ADDITIONAL_PHONE_TEXTBOX;
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
    @FindBy(xpath = "//input[@name='pro_ship_addr_state']")
    public WebElement REGION3_TEXTBOX;
    @FindBy(xpath = "//select[@id='pro_ship_addr_state']")
    public WebElement STATE3_DROPDOWN;
    @FindBy(xpath = "//input[@name='pro_ship_addr_postal_code']")
    public WebElement POSTAL3_CODE_TEXTBOX;
    @FindBy(xpath = "//select[@id='pro_ship_addr_country']")
    public WebElement COUNTRY3_DROPDOWN;
    @FindBy(xpath = "//textarea[@id='pro_notes']")
    public WebElement USER_NOTES_TEXTBOX;
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//input[@name='pro_phone']")
    public WebElement PHONE_TEXTBOX;

    //public static final By PHONE_TEXTBOX = By.xpath("//input[@name='pro_phone']");
    @FindBy(xpath = "//input[@name='pro_fax']")
    public WebElement FAX_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_phone_mobile']")
    public WebElement MOBILE_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_phone2']")
    public WebElement OTHER_PHONE_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_url']")
    public WebElement WEB_ADDRESS_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_social_facebook']")
    public WebElement FACEBOOK_TEXTBOX;
    @FindBy(xpath = "//input[@name='pro_social_linkedin']")
    public WebElement LINKEDIN_TEXTBOX;
    @FindBy(xpath = "//h1//small")
    public WebElement REG_CODE_TEXT;
    @FindBy(xpath = "//a[@title='Event Dashboard']")
    public WebElement EVENT_DASHBOARD_LINK;
    private String title = "Certain: Create a Profile";


    public CreateProfilePage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for entering contact information
     *
     * @param firstName         : first name of user
     * @param lastName          :last name of user
     * @param email             : email id of user
     * @param position          : position of user
     * @param organization      : organization name of user
     * @param userName          : unique user id
     * @param externalProfileId : value of external profile id
     * @param gender            : value of gender
     * @param prefix            : prefix of user
     * @param badgeName         : badge name of user
     * @param dob               : date of birth of user
     * @param password          : password of user
     */
    private void enterContactInformation(String firstName, String lastName, String email, String position,
                                         String organization, String userName, String externalProfileId,
                                         String gender, String prefix, String mi, String suffix,
                                         String badgeName, String dob,
                                         String password) throws Exception {
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        Wait(FIRST_NAME_TEXTBOX, 30);
        //type(FIRST_NAME_TEXTBOX, firstName);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        type(FIRST_NAME_TEXTBOX, firstName);
        type(LAST_NAME_TEXTBOX, lastName);
        type(EMAIL_TEXTBOX, email);
        type(POSITION_TEXTBOX, position);
        type(ORGANIZATION_TEXTBOX, organization);
        type(USERNAME_TEXTBOX, userName);
        type(EXTERNAL_PROFILEID_TEXTBOX, externalProfileId);
        type(PREFIX_TEXTBOX, prefix);
        type(MI_TEXTBOX, mi);
        type(SUFFIX_TEXTBOX, suffix);
        type(BADGE_NAME_TEXTBOX, badgeName);
        select(GENDER_DROPDOWN, gender);
        type(DOB_DATEPICKER, dob);
        // uploadProfilePicture(profilePictureFileName);
        type(PASSWORD_TEXTBOX, password);
        logReport("Entered required contact information Successfully");
    }

    /**
     * Method for entering contact details of user
     *
     * @param phone                : value of phone no
     * @param fax                  : fax id
     * @param mobile               : value of mobile no
     * @param otherPhone           : value of other phone no
     * @param webAddress           : value of web address
     * @param facebook             : link of facebook id
     * @param linkedIn             : link of linked In id
     * @param ccState              : value of cc state
     * @param assistantName        :value of assistant username
     * @param assistantEmail:value of assistant email
     * @param assistantPhone:value of assistant phone no
     * @param google               : link of google
     * @param twitter              :link of twitter id
     */
    private void enterContactDetails(String phone, String fax, String mobile, String otherPhone,
                                     String webAddress, String facebook, String linkedIn,
                                     boolean ccState, String assistantName, String assistantEmail,
                                     String assistantPhone, String google, String twitter) {
        type(PHONE_TEXTBOX, phone, true);
        type(FAX_TEXTBOX, fax);
        type(MOBILE_TEXTBOX, mobile);
        type(OTHER_PHONE_TEXTBOX, otherPhone);
        type(WEB_ADDRESS_TEXTBOX, webAddress);
        type(FACEBOOK_TEXTBOX, facebook);
        type(LINKEDIN_TEXTBOX, linkedIn);
        if (ccState) {
            check(CCEMAIL_CHECKBOX);
            type(ASSISTANT_NAME_TEXTBOX, assistantName);
            type(ASSISTANT_EMAIL_TEXTBOX, assistantEmail);
            type(ASSISTANT_PHONE_TEXTBOX, assistantPhone);
            type(GOOGLE_TEXTBOX, google);
            type(TWITTER_TEXTBOX, twitter);
        }
        logReport("Entered required contact details Successfully");
    }

    /**
     * Method for entering mailing address of user
     *
     * @param address            :value of address
     * @param addressLine2:value of address2
     * @param addressLine3:value of address3
     * @param city               :value of city
     * @param state              :value of state
     * @param postalCode         :value of postal code
     * @param country            :value of country
     * @param ccEmail            : value of ccEmail user id
     * @param additionalName     : value of additional user name
     * @param additionalEmail    :value of additional email id
     * @param additionalPhone    : value of additional phone no
     */
    private void enterMailingAddress(String address, String addressLine2, String addressLine3, String city,
                                     String state, String postalCode, String country, boolean ccEmail,
                                     String additionalName, String additionalEmail, String additionalPhone) throws Exception {
        type(ADDRESS_TEXTBOX, address);
        type(ADDRESS_LINE2_TEXTBOX, addressLine2);
        type(ADDRESS_LINE3_TEXTBOX, addressLine3);
        select(COUNTRY_DROPDOWN, country);
        VerifyAjaxRequestsFinished(30);
        type(CITY_TEXTBOX, city);
        type(POSTAL_CODE_TEXTBOX, postalCode);
        select(STATE_DROPDOWN, state);
        if (ccEmail) {
            //check(ADDITIONAL_INFO_CHECKBOX);
            clickByJavaScript(browser.findElement(By.xpath(ADDITIONAL_INFO_CHECKBOX)));
            type(ADDITIONAL_NAME_TEXTBOX, additionalName);
            type(ADDITIONAL_EMAIL_TEXTBOX, additionalEmail);
            type(ADDITIONAL_PHONE_TEXTBOX, additionalPhone);
        }
        logReport("Entered required mailing details Successfully");
    }

    /**
     * Method for filling billing information in registration page
     *
     * @param billToName         : value of billing in username
     * @param billToOrganization :value of billing in user organization
     * @param address            : value of billing address
     * @param addressLine2       : value of billing address2
     * @param city               :value of billing city
     * @param state              :value of billing state
     * @param postalCode:value   of billing postal code
     * @param country:value      of billing country
     */
    private void enterBillingInfo(String billToName, String billToOrganization, String address, String addressLine2,
                                  String city, String state, String postalCode, String country) throws Exception {
        type(BILLTO_NAME_TEXTBOX, billToName);
        type(BILLTO_ORGANIZATION_TEXTBOX, billToOrganization);
        type(ADDRESS2_TEXTBOX, address);
        type(ADDRESS2_LINE2_TEXTBOX, addressLine2);
        select(COUNTRY2_DROPDOWN, country);
        VerifyAjaxRequestsFinished(30);
        logReport("City values " + city);
        type(CITY2_TEXTBOX, city);
        type(POSTAL2_CODE_TEXTBOX, postalCode);
        select(STATE2_DROPDOWN, state);
        logReport("Entered required billing details Successfully");
    }

    /**
     * Method for filling shipping information in registration page
     *
     * @param shipToName         : value of shipping in user name
     * @param shipToOrganization : value of shipping in user organization
     * @param address            : value of shipping address
     * @param addressLine2       : value of shipping address2
     * @param city               :value of shipping city
     * @param state              :value of shipping state
     * @param postalCode:value   of shipping postal code
     * @param country:value      of shipping country
     */
    private void enterShippingInfo(String shipToName, String shipToOrganization, String address, String addressLine2,
                                   String city, String state, String postalCode, String country) throws Exception {
        type(SHIPTO_NAME_TEXTBOX, shipToName);
        type(SHIPTO_ORGANIZATION_TEXTBOX, shipToOrganization);
        type(ADDRESS3_TEXTBOX, address);
        type(ADDRESS3_LINE2_TEXTBOX, addressLine2);
        select(COUNTRY3_DROPDOWN, country);
        VerifyAjaxRequestsFinished(30);
        type(CITY3_TEXTBOX, city);
        type(POSTAL3_CODE_TEXTBOX, postalCode);
        select(STATE3_DROPDOWN, state);

        logReport("Entered required shipping details Successfully");
    }

    public void enterUserNotes(String userNotes) throws Exception {
        Wait(USER_NOTES_TEXTBOX, 30);
        type(USER_NOTES_TEXTBOX, userNotes);
        logReport("Entered UserNotes : " + userNotes);
    }

    /**
     * Method for clicking on save button in profile form
     */
    private void clickSave() throws Exception {
        click(SAVE_BUTTON);
        VerifyPageReady(30);
    }

    /**
     * Method for add new registration
     *
     * @param createProfileData : page object of CreateProfileData
     */
    public AttendeeOverviewPage addNewProfile(CreateProfileData createProfileData) throws Exception {
        ContactInformation contactInformation = createProfileData.getContactInformation();
        ContactDetails contactDetails = createProfileData.getContactDetails();
        MailingAddress mailingAddress = createProfileData.getMailingAddress();
        BillingInfo billingInfo = createProfileData.getBillingInfo();
        ShippingInfo shippingInfo = createProfileData.getShippingInfo();

        enterContactInformation(contactInformation.getFirstName(), contactInformation.getLastName(),
                contactInformation.getEmail(), contactInformation.getPosition(),
                contactInformation.getOrganization(), contactInformation.getUsername(),
                contactInformation.getExternalProfileID(), contactInformation.getGender(), contactInformation.getPrefix(),
                contactInformation.getMi(), contactInformation.getSuffix(), contactInformation.getBadgeName(),
                contactInformation.getDob(), contactInformation.getPassword()
        );

        enterContactDetails(contactDetails.getPhone(), contactDetails.getFax(), contactDetails.getMobile(),
                contactDetails.getOtherPhone(), contactDetails.getWebAddress(), contactDetails.getFacebook(),
                contactDetails.getLinkedIn(), createProfileData.isCcEmailToAssistant(), contactDetails.getAssistantInfo().getAssistantName(),
                contactDetails.getAssistantInfo().getAssistantEmail(), contactDetails.getAssistantInfo().getAssistantPhone(),
                contactDetails.getGoogle(), contactDetails.getTwitter());

        enterMailingAddress(mailingAddress.getAddress().getStreetAddress(), mailingAddress.getAddress().getAddressLine2(),
                mailingAddress.getAddress().getAddressLine3(), mailingAddress.getAddress().getCity(),
                mailingAddress.getAddress().getState(), mailingAddress.getAddress().getZipCode(),
                mailingAddress.getAddress().getCountry(), createProfileData.isCcEmailToAdditional(),
                mailingAddress.getAdditionalInfo().getAdditionalName(), mailingAddress.getAdditionalInfo().getAdditionalEmail(),
                mailingAddress.getAdditionalInfo().getAdditionalPhone());

        enterUserNotes(createProfileData.getUserNotes());

        enterBillingInfo(billingInfo.getBillToName(), billingInfo.getBillToOrganization(),
                billingInfo.getBillingAddress().getStreetAddress(), billingInfo.getBillingAddress().getAddressLine2(),
                billingInfo.getBillingAddress().getCity(), billingInfo.getBillingAddress().getState(),
                billingInfo.getBillingAddress().getZipCode(), billingInfo.getBillingAddress().getCountry());

        enterShippingInfo(shippingInfo.getShipToName(), shippingInfo.getShipToOrganization(),
                shippingInfo.getShippingAddress().getStreetAddress(), shippingInfo.getShippingAddress().getAddressLine2(),
                shippingInfo.getShippingAddress().getCity(), shippingInfo.getShippingAddress().getState(),
                shippingInfo.getShippingAddress().getZipCode(), shippingInfo.getShippingAddress().getCountry());

        clickSave();
        clickSave();
        logReport("Profile information saved Successfully");

        return new AttendeeOverviewPage(browser);

    }
}
