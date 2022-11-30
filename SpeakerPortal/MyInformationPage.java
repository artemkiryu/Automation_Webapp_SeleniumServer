package pageObjects.SpeakerPortal;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sqlite.util.StringUtils;
import pageObjects.CommonActionsPage;
import pojo.AddCustomFieldsData;
import pojo.AddSpeakerData;
import pojo.SpeakerInformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyInformationPage extends CommonActionsPage {
    @FindBy(xpath = "//h2[text()='My Information']")
    public WebElement MYINFORMATION_HEADER;
    @FindBy(xpath = "//span[text()='Logout']/..")
    public WebElement LOGOUT_BUTTON;
    @FindBy(xpath = "//button[@id='navigationHam']")
    public WebElement NAVIGATION_MENU;
    @FindBy(xpath = "//li[@id='module.id']//span")
    public List<WebElement> LIST_MENU_ITEMS;
    @FindBy(xpath = "//input[@x-ng-model='speakerJson.prefix']")
    public WebElement PREFIX_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='speakerJson.firstName']")
    public WebElement FIRST_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='speakerJson.lastName']")
    public WebElement LAST_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='speakerJson.middleName']")
    public WebElement MIDDLE_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='speakerJson.suffix']")
    public WebElement SUFFIX_TEXTBOX;
    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement EMAIL_TEXTBOX;
    @FindBy(xpath = "//input[@placeholder='Phone']")
    public WebElement PHONE_TEXTBOX;
    @FindBy(xpath = "//input[@placeholder='Organization']")
    public WebElement ORGANIZATION_TEXTBOX;
    @FindBy(xpath = "//input[@placeholder='Position']")
    public WebElement POSITION_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='speakerJson.pin']")
    public WebElement USERNAME_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='speakerJson.speakerPassword']")
    public WebElement PASSWORD_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='speakerJson.confirmPassword']")
    public WebElement CONFIRMPASSWORD_TEXTBOX;

    @FindBy(xpath = "//input[@placeholder='Web Link']")
    public WebElement WEBLINK_TEXTBOX;

    @FindBy(xpath = "//label[text()='Gender']/..//following-sibling::div[1]//select")
    public WebElement GENDER_DROPDOWN;

    @FindBy(xpath = "//input[@placeholder='Mobile']")
    public WebElement MOBILE_TEXTBOX;

    @FindBy(xpath = "//input[@placeholder='Date of Birth']")
    public WebElement DOB_TEXTBOX;

    @FindBy(xpath = "//input[@placeholder='Fax']")
    public WebElement FAX_TEXTBOX;

    @FindBy(xpath = "//input[@placeholder='Address Line 1']")
    public WebElement ADDRESS_LINE1_TEXTBOX;
    @FindBy(xpath = "//input[@placeholder='Address Line 2']")
    public WebElement ADDRESS_LINE2_TEXTBOX;
    @FindBy(xpath = "//input[@placeholder='City']")
    public WebElement CITY_TEXTBOX;
    @FindBy(xpath = "//input[@placeholder='Postal Code']")
    public WebElement POSTAL_CODE_TEXTBOX;
    @FindBy(xpath = "//input[@placeholder='State']")
    public WebElement STATE_TEXTBOX;
    @FindBy(xpath = "//input[@placeholder='Country']")
    public WebElement COUNTRY_TEXTBOX;
    @FindBy(xpath = "//input[@placeholder='Facebook']")
    public WebElement FACEBOOK_TEXTBOX;
    @FindBy(xpath = "//input[@placeholder='Google+']")
    public WebElement GOOGLE_TEXTBOX;
    @FindBy(xpath = "//input[@placeholder='LinkedIn']")
    public WebElement LINKEDIN_TEXTBOX;
    @FindBy(xpath = "//input[@placeholder='Twitter']")
    public WebElement TWITTER_TEXTBOX;

    @FindBy(xpath = "//input[@placeholder='TestSpeak']")
    public WebElement TESTSPEAK_CUSTOMFIELD;

    @FindBy(xpath = "//input[@x-ng-click='updateSpeaker()']")
    public WebElement SPEAKER_SAVE_BUTTON;

    @FindBy(xpath = "//span[@class='non-editable-span col-sm-7 p0 ng-scope ng-binding']")
    public List<WebElement> FIELDS_READ_ONLY;

    @FindBy(xpath = "//label[text()='Notes']/..//following-sibling::div//textarea")
    public WebElement SPEAKER_NOTES;

    @FindBy(xpath = "//div[@title='Speaker Agreement']/..//following-sibling::div//a")
    public WebElement SPEAKER_AGREEMENT;

    @FindBy(xpath = "//div[contains(@ng-repeat,'section in speakerSections')]//span[@class='ng-scope ng-binding']")
    public List<WebElement> SPEAKER_DETAILS_INFO_STANDARD;

    @FindBy(xpath = "//div[@class='session-layout-page ng-scope']//label[@for='customFieldType']")
    public List<WebElement> SPEAKER_DETAILS_INFO_MINIMAL;

    //div[@class='session-layout-page ng-scope']//label[@for='customFieldType']

    public MyInformationPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public SpeakerPortalLoginPage logoutSpeakerPortal() throws Exception {
        Wait(NAVIGATION_MENU, 10);
        clickByJavaScript(NAVIGATION_MENU);
        logReport("Navigation menu clicked successfully");
        Wait(LOGOUT_BUTTON, 10);
        clickByJavaScript(LOGOUT_BUTTON);
        logReport("Logout button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        return new SpeakerPortalLoginPage(browser);
    }

    public String getBioValue() {
        WebElement frame = browser.findElement(By.xpath("//label[text()='Bio']/..//following-sibling::div//div/iframe"));
        browser.switchTo().frame(frame);
        String bio = browser.findElement(By.cssSelector("body")).getText().trim();
        browser.switchTo().defaultContent();
        return bio;

    }

    public List<String> getMyInformationDetails() {
        List<String> myInfoList = new ArrayList<>();
        String prefix = PREFIX_TEXTBOX.getAttribute("value").trim();
        String firstName = FIRST_NAME_TEXTBOX.getAttribute("value").trim();
        String mi = MIDDLE_NAME_TEXTBOX.getAttribute("value").trim();
        String lastName = LAST_NAME_TEXTBOX.getAttribute("value").trim();
        String suffix = SUFFIX_TEXTBOX.getAttribute("value").trim();
        String email = EMAIL_TEXTBOX.getAttribute("value").trim();
        String webLink = WEBLINK_TEXTBOX.getAttribute("value").trim();
        String gender = getSelectedOption(GENDER_DROPDOWN);
        String notes = SPEAKER_NOTES.getAttribute("value").trim();
        String mobile = MOBILE_TEXTBOX.getAttribute("value").trim();
        String phone = PHONE_TEXTBOX.getAttribute("value").trim();
        String organization = ORGANIZATION_TEXTBOX.getAttribute("value").trim();
        String position = POSITION_TEXTBOX.getAttribute("value").trim();
        String username = USERNAME_TEXTBOX.getAttribute("value").trim();
        String addressLine1 = ADDRESS_LINE1_TEXTBOX.getAttribute("value").trim();
        String addressLine2 = ADDRESS_LINE2_TEXTBOX.getAttribute("value").trim();
        String city = CITY_TEXTBOX.getAttribute("value").trim();
        String postalCode = POSTAL_CODE_TEXTBOX.getAttribute("value").trim();
        String state = STATE_TEXTBOX.getAttribute("value").trim();
        String country = COUNTRY_TEXTBOX.getAttribute("value").trim();
        String facebook = FACEBOOK_TEXTBOX.getAttribute("value").trim();
        String google = GOOGLE_TEXTBOX.getAttribute("value").trim();
        String linkedIn = LINKEDIN_TEXTBOX.getAttribute("value").trim();
        String twitter = TWITTER_TEXTBOX.getAttribute("value").trim();
        String bioNotes = getBioValue();
        String dob = DOB_TEXTBOX.getAttribute("value").trim();
        String fax = FAX_TEXTBOX.getAttribute("value").trim();
        myInfoList.add(firstName);
        myInfoList.add(lastName);
        myInfoList.add(prefix);
        myInfoList.add(mi);
        myInfoList.add(suffix);
        myInfoList.add(email);
        myInfoList.add(username);
        myInfoList.add(organization);
        myInfoList.add(position);
        myInfoList.add(phone);
        myInfoList.add(facebook);
        myInfoList.add(linkedIn);
        myInfoList.add(google);
        myInfoList.add(twitter);
        myInfoList.add(addressLine1);
        myInfoList.add(addressLine2);
        myInfoList.add(city);
        myInfoList.add(postalCode);
        myInfoList.add(state);
        myInfoList.add(country);
        myInfoList.add(bioNotes);
        myInfoList.add(notes);
        myInfoList.add(gender);
        myInfoList.add(dob);
        myInfoList.add(fax);
        myInfoList.add(webLink);
        myInfoList.add(mobile);
        return myInfoList;
    }

    public SpeakerInformation getDefaultMyInformationLayout() {
        SpeakerInformation speakerInformation;
        String prefix = PREFIX_TEXTBOX.getAttribute("value").trim();
        String firstName = FIRST_NAME_TEXTBOX.getAttribute("value").trim();
        String mi = MIDDLE_NAME_TEXTBOX.getAttribute("value").trim();
        String lastName = LAST_NAME_TEXTBOX.getAttribute("value").trim();
        String suffix = SUFFIX_TEXTBOX.getAttribute("value").trim();
        String email = EMAIL_TEXTBOX.getAttribute("value").trim();
        String phone = PHONE_TEXTBOX.getAttribute("value").trim();
        String organization = ORGANIZATION_TEXTBOX.getAttribute("value").trim();
        String position = POSITION_TEXTBOX.getAttribute("value").trim();
        String username = USERNAME_TEXTBOX.getAttribute("value").trim();
        String addressLine1 = ADDRESS_LINE1_TEXTBOX.getAttribute("value").trim();
        String addressLine2 = ADDRESS_LINE2_TEXTBOX.getAttribute("value").trim();
        String city = CITY_TEXTBOX.getAttribute("value").trim();
        String postalCode = POSTAL_CODE_TEXTBOX.getAttribute("value").trim();
        String state = STATE_TEXTBOX.getAttribute("value").trim();
        String country = COUNTRY_TEXTBOX.getAttribute("value").trim();
        String facebook = FACEBOOK_TEXTBOX.getAttribute("value").trim();
        String google = GOOGLE_TEXTBOX.getAttribute("value").trim();
        String linkedIn = LINKEDIN_TEXTBOX.getAttribute("value").trim();
        String twitter = TWITTER_TEXTBOX.getAttribute("value").trim();
        String bioNotes = getBioValue();
        speakerInformation = new SpeakerInformation(firstName, lastName, prefix, mi, suffix, email, username, null, null, organization, position, phone,
                facebook, linkedIn, google, twitter, addressLine1, addressLine2, city, postalCode, state, country, null, bioNotes);
        return speakerInformation;
    }

    public void fillPasswordDetails(String username, String password) throws Exception {
        type(USERNAME_TEXTBOX, username, true);
        type(PASSWORD_TEXTBOX, password, true);
        type(CONFIRMPASSWORD_TEXTBOX, password, true);
        clickSpeakerSaveButton();
    }

    public void clickSpeakerSaveButton() throws Exception {
        Wait(SPEAKER_SAVE_BUTTON, 30);
        click(SPEAKER_SAVE_BUTTON);
        logReport("Speaker Save button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        //VerifyAjaxRequestsFinished(30);
        // VerifyPageReady(30);
        //return  new SpeakerPage(browser);
    }

    public boolean isFieldsReadOnlyModeInMyInformationPage() {
        return FIELDS_READ_ONLY.size() > 0;
    }

    public boolean isCustomFieldDisplayed(String fieldName) {
        String xpath = "//input[@placeholder='" + fieldName + "']";
        WebElement element = browser.findElement(By.xpath(xpath));
        return verifyElementDisplayed(element, 2);
    }

    public List<String> getListOfSidebarTabs() throws Exception {
        Thread.sleep(5000);
        List<String> sidebarTabs = new ArrayList<>();
        Wait(NAVIGATION_MENU, 10);
        clickByJavaScript(NAVIGATION_MENU);
        for (WebElement e : LIST_MENU_ITEMS) {
            sidebarTabs.add(e.getText().trim());

        }
        return sidebarTabs;
    }

    public void fillSelectTypeCustomFieldValue(AddCustomFieldsData addCustomFieldsData) throws Exception {
        String customFieldName = addCustomFieldsData.getFieldName();
        WebElement customField = browser.findElement(By.xpath("//label[text()='" + customFieldName + "']/..//following-sibling::div[1]//select"));
        String a[] = addCustomFieldsData.getOptions().split(",");
        // select(customField, addCustomFieldsData.getOptions());
        select(customField, a[0]);
        logReport("Selected select custom field value " + a[0]);

    }

    public void fillMultiSelectTypeCustomFieldValue(AddCustomFieldsData addCustomFieldsData) throws Exception {
        String customFieldName = addCustomFieldsData.getFieldName();
        WebElement customField = browser.findElement(By.xpath("//label[text()='" + customFieldName + "']/..//following-sibling::div[1]//select"));
        String a[] = addCustomFieldsData.getOptions().split(",");
        //selectCustomFieldDropdown(customField, addCustomFieldsData.getOptions());
        select(customField, a[0]);
        logReport("Selected multi select custom field value " + a[0]);

    }

    public void fillInputTypeCustomFieldValue(AddCustomFieldsData addCustomFieldsData) throws Exception {
        String customFieldName = addCustomFieldsData.getFieldName();
        WebElement customField = browser.findElement(By.xpath("//label[text()='" + customFieldName + "']/..//following-sibling::div//input"));
        type(customField, addCustomFieldsData.getOptions(), true);
        logReport("Selected input custom field value " + addCustomFieldsData.getOptions());
    }

    public void enterTextAreaValue(String textAreaName, String textAreaValue) {
        WebElement element = browser.findElement(By.xpath("//label[text()='" + textAreaName + "']/../..//textarea"));
        type(element, textAreaValue, true);
        logReport("Entered Text area value " + textAreaValue + " in the " + textAreaName);
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

    public String getNotesValue() {
        return SPEAKER_NOTES.getText().trim();
    }

    public String getSpeakerAgreementText() {
        return SPEAKER_AGREEMENT.getText().trim();
    }

    public String getInputCustomFieldValues(String customFieldName) {
        String xpath = "//label[text()='" + customFieldName + "']/..//following-sibling::div/input";
        return browser.findElement(By.xpath(xpath)).getAttribute("value").trim();
    }

    public String getTextAreaCustomFieldValues(String customFieldName) {
        String xpath = "//label[text()='" + customFieldName + "']/..//following-sibling::div/textarea";
        return browser.findElement(By.xpath(xpath)).getAttribute("value").trim();
    }

    public String getSelectTypeCustomFieldValues(String customFieldName, String separator) {
        String xpath = "//label[text()='" + customFieldName + "']/..//following-sibling::div[1]//select";
        WebElement element = browser.findElement(By.xpath(xpath));
        List<String> tagsList = getSelectedOptions(element);
        Collections.sort(tagsList);
        String selectCustomField = StringUtils.join(tagsList, separator);
        logReport("Select custom field values " + selectCustomField);

        return selectCustomField;
    }

    public String getSessionCustomFields(AddCustomFieldsData addCustomFieldsData, String separator) {
        if (addCustomFieldsData.getFieldType().equalsIgnoreCase("Text")) {
            return getInputCustomFieldValues(addCustomFieldsData.getFieldName());
        } else if (addCustomFieldsData.getFieldType().equalsIgnoreCase("Textarea")) {
            return getTextAreaCustomFieldValues(addCustomFieldsData.getFieldName());
        } else {
            return getSelectTypeCustomFieldValues(addCustomFieldsData.getFieldName(), separator);
        }

    }

    public List<String> getAddSpeakerDetails(AddSpeakerData addSpeakerData) {
        List<String> myInfoList = new ArrayList<>();
        myInfoList.add(addSpeakerData.getFirstName());
        myInfoList.add(addSpeakerData.getLastName());
        myInfoList.add(addSpeakerData.getPrefix());
        myInfoList.add(addSpeakerData.getMiddleName());
        myInfoList.add(addSpeakerData.getSuffix());
        myInfoList.add(addSpeakerData.getEmail());
        myInfoList.add(addSpeakerData.getUsername());
        myInfoList.add(addSpeakerData.getOrganization());
        myInfoList.add(addSpeakerData.getPosition());
        myInfoList.add(addSpeakerData.getPhone());
        myInfoList.add(addSpeakerData.getFacebook());
        myInfoList.add(addSpeakerData.getLinkedIn());
        myInfoList.add(addSpeakerData.getGoogle());
        myInfoList.add(addSpeakerData.getTwitter());
        myInfoList.add(addSpeakerData.getAddressLine1());
        myInfoList.add(addSpeakerData.getAddressLine2());
        myInfoList.add(addSpeakerData.getCity());
        myInfoList.add(addSpeakerData.getPostalCode());
        myInfoList.add(addSpeakerData.getState());
        myInfoList.add(addSpeakerData.getCountry());
        myInfoList.add(addSpeakerData.getBio());
        myInfoList.add(addSpeakerData.getNotes());
        myInfoList.add(addSpeakerData.getGender());
        myInfoList.add(addSpeakerData.getDob());
        myInfoList.add(addSpeakerData.getFax());
        myInfoList.add(addSpeakerData.getWebAddress());
        myInfoList.add(addSpeakerData.getMobile());
        return myInfoList;

    }

    public List<String> getInformationLayoutFields() {
        List<String> infoDetails = new ArrayList<>();
        for (WebElement e : SPEAKER_DETAILS_INFO_MINIMAL) {
            infoDetails.add(e.getText().trim());
        }
        for (WebElement e : SPEAKER_DETAILS_INFO_STANDARD) {
            infoDetails.add(e.getText().trim());
        }
        return infoDetails;
    }

}
