package pageObjects.EventSetup;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddEventContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by infoobjects on 8/18/2017.
 */
public class EventContactPage extends CommonActionsPage{

    public EventContactPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@name='con_name']")
    public WebElement NAME_TEXTBOX;

    @FindBy(xpath = "//input[@name='con_email']")
    public WebElement EMAIL_TEXTBOX;

    @FindBy(xpath = "//input[@name='con_organization']")
    public WebElement ORGANIZATION_TEXTBOX;

    @FindBy(xpath = "//input[@name='con_url']")
    public WebElement URL_TEXTBOX;

    @FindBy(xpath = "//input[@name='con_phone']")
    public WebElement PHONE_TEXTBOX;

    @FindBy(xpath = "//input[@name='con_fax']")
    public WebElement FAX_TEXTBOX;

    @FindBy(xpath = "//input[@name='con_tollfree']")
    public WebElement TOLL_FREE_TEXTBOX;

    @FindBy(xpath = "//input[@name='addr_line1']")
    public WebElement STREET_ADDRESS_LINE1_TEXTBOX;

    @FindBy(xpath = "//input[@name='addr_line2']")
    public WebElement STREET_ADDRESS_LINE2_TEXTBOX;

    @FindBy(xpath = "//input[@name='addr_line3']")
    public WebElement STREET_ADDRESS_LINE3_TEXTBOX;

    @FindBy(xpath = "//input[@name='addr_city']")
    public WebElement CITY_TEXTBOX;

    @FindBy(xpath = "//select[@id='addr_state']")
    public WebElement STATE_DROPDOWN;

    @FindBy(xpath = "//input[@name='addr_postal_code']")
    public WebElement ZIP_CODE_TEXTBOX;

    @FindBy(xpath = "//input[@name='addr_intl_state']")
    public WebElement NON_US_PROVIENCE_TEXTBOX;

    @FindBy(xpath = "//select[@id='addr_country']")
    public WebElement COUNTRY_DROPDOWN;

    @FindBy(xpath = "//select[@id='con_frn_acnt_id']")
    public WebElement ACCOUNT_DROPDOWN;

    @FindBy(xpath = "//textarea[@name='con_notes']")
    public WebElement USER_NOTES_TEXTBOX;

    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement SAVE_BUTTON;


    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[contains(.,'Attendee Types')]")
    public WebElement ATTENDEE_TYPES_TAB;


    private void enterContactName (String name) throws Exception {
        VerifyPageReady(30);
        Wait(NAME_TEXTBOX,30);
        type(NAME_TEXTBOX, name);
        logReport("Entered contact Name"+ name + "Successfully");
    }

    private void enterContactEmail (String mailId) throws Exception {
        VerifyPageReady(30);
        Wait(EMAIL_TEXTBOX,30);
        type(EMAIL_TEXTBOX, mailId);
        logReport("Entered contact email "+ mailId + "Successfully");
    }

    private void enterContactOrganization (String organization) throws Exception {
        VerifyPageReady(30);
        Wait(ORGANIZATION_TEXTBOX,30);
        type(ORGANIZATION_TEXTBOX, organization);
        logReport("Entered contact organization "+ organization + "Successfully");
    }

    private void enterContactURL (String url) throws Exception {
        VerifyPageReady(30);
        Wait(URL_TEXTBOX,30);
        type(URL_TEXTBOX, url);
        logReport("Entered contact url "+ url + "Successfully");
    }

    private void enterContactPhone (String number) throws Exception {
        VerifyPageReady(30);
        Wait(PHONE_TEXTBOX,30);
        type(PHONE_TEXTBOX, number);
        logReport("Entered contact number "+ number + "Successfully");
    }

    private void enterContactFax (String number) throws Exception {
        VerifyPageReady(30);
        Wait(FAX_TEXTBOX,30);
        type(FAX_TEXTBOX, number);
        logReport("Entered contact fax number "+ number + "Successfully");
    }

    private void enterTollFreeNumber (String number) throws Exception {
        VerifyPageReady(30);
        Wait(TOLL_FREE_TEXTBOX,30);
        type(TOLL_FREE_TEXTBOX, number);
        logReport("Entered contact toll free number "+ number + "Successfully");
    }

    private void enterStreetAddressLineOne (String address) throws Exception {
        VerifyPageReady(30);
        Wait(STREET_ADDRESS_LINE1_TEXTBOX,30);
        type(STREET_ADDRESS_LINE1_TEXTBOX, address);
        logReport("Entered contact toll free number "+ address + "Successfully");
    }

    private void enterStreetAddressLineTwo (String address) throws Exception {
        VerifyPageReady(30);
        Wait(STREET_ADDRESS_LINE2_TEXTBOX,30);
        type(STREET_ADDRESS_LINE2_TEXTBOX, address);
        logReport("Entered contact toll free number "+ address + "Successfully");
    }

    private void enterStreetAddressLineThree (String address) throws Exception {
        VerifyPageReady(30);
        Wait(STREET_ADDRESS_LINE3_TEXTBOX,30);
        type(STREET_ADDRESS_LINE3_TEXTBOX, address);
        logReport("Entered contact toll free number "+ address + "Successfully");
    }

    private void enterCity (String cityName) throws Exception {
        VerifyPageReady(30);
        Wait(CITY_TEXTBOX,30);
        type(CITY_TEXTBOX, cityName);
        logReport("Entered contact toll free number "+ cityName + "Successfully");
    }

    private void selectState (String stateName) throws Exception {
        VerifyPageReady(30);
        scrollIntoView(STATE_DROPDOWN);
        Wait(STATE_DROPDOWN,30);
        select(STATE_DROPDOWN, stateName);
        logReport("select state "+ stateName + "Successfully");
    }

    private void enterZipCode (String code) throws Exception {
        VerifyPageReady(30);
        scrollIntoView(ZIP_CODE_TEXTBOX);
        Wait(ZIP_CODE_TEXTBOX, 30);
        type(ZIP_CODE_TEXTBOX, code);
        logReport("Entered contact zip code number "+ code + "Successfully");
    }

    private void enterNonUsProvience (String text) throws Exception {
        VerifyPageReady(30);
        scrollIntoView(NON_US_PROVIENCE_TEXTBOX);
        Wait(NON_US_PROVIENCE_TEXTBOX,30);
        type(NON_US_PROVIENCE_TEXTBOX, text);
        logReport("Entered non us provience value "+ text + " Successfully");
    }

    private void selectCountry (String country) throws Exception {
        VerifyPageReady(30);
        scrollIntoView(COUNTRY_DROPDOWN);
        Wait(COUNTRY_DROPDOWN,30);
        select(COUNTRY_DROPDOWN, country);
        logReport("select country "+ country + "Successfully");
    }

    private void selectAccount (String account) throws Exception {
        VerifyPageReady(30);
        Wait(ACCOUNT_DROPDOWN,30);
        select(ACCOUNT_DROPDOWN, account);
        logReport("select account "+ account + "Successfully");
    }

    private void enterUserNotes (String text) throws Exception {
        VerifyPageReady(30);
        scrollIntoView(USER_NOTES_TEXTBOX);
        Wait(USER_NOTES_TEXTBOX, 30);
        type(USER_NOTES_TEXTBOX, text);
        logReport("Entered user notes "+ text + "Successfully");
    }

    public void clickSaveButton()throws Exception{
        VerifyPageReady(30);
        Wait(SAVE_BUTTON, 30);
        click(SAVE_BUTTON);
        logReport("Successfully clicked on 'Save' button.");
    }
    public void fillRegistrationContactDetail(AddEventContactData addEventContactData)throws Exception{
        enterContactName(addEventContactData.getName());
        enterContactEmail(addEventContactData.getEmail());
        enterContactOrganization(addEventContactData.getOrganization());
        enterContactURL(addEventContactData.getUrl());
        enterContactPhone(addEventContactData.getPhone());
        enterContactFax(addEventContactData.getFax());
        enterTollFreeNumber(addEventContactData.getTollFree());
        enterStreetAddressLineOne(addEventContactData.getAddressLine1());
        enterStreetAddressLineTwo(addEventContactData.getAddressLine2());
        enterStreetAddressLineThree(addEventContactData.getAddressLine3());
        enterCity(addEventContactData.getCity());
        selectCountry(addEventContactData.getCountry());
        enterZipCode(addEventContactData.getZipCode());
        selectState(addEventContactData.getState());
        enterNonUsProvience(addEventContactData.getNonUsProvince());
        // selectAccount(addRegistrationContact.getAccount());
        enterUserNotes(addEventContactData.getUserNotes());
    }


    public AttendeeTypePage clickOnAttendeeTypesTab()throws Exception{
        VerifyPageReady(30);
        Wait(ATTENDEE_TYPES_TAB, 30);
        click(ATTENDEE_TYPES_TAB);
        logReport("Successfully clicked on 'Attendee Type' tab.");
        return new AttendeeTypePage(browser);
    }

    public List<String> getRegistrationContactDetail(){
        List<String> contactData = new ArrayList<>();
        String name = NAME_TEXTBOX.getText();
        String email = EMAIL_TEXTBOX.getText();
        String organization = ORGANIZATION_TEXTBOX.getText();
        String url = URL_TEXTBOX.getText();
        String phone = PHONE_TEXTBOX.getText();
        String fax = FAX_TEXTBOX.getText();
        String tollFree = TOLL_FREE_TEXTBOX.getText();
        String streetAddress1 = STREET_ADDRESS_LINE1_TEXTBOX.getText();
        String streetAddress2 = STREET_ADDRESS_LINE2_TEXTBOX.getText();
        String streetAddress3 = STREET_ADDRESS_LINE3_TEXTBOX.getText();
        String city = CITY_TEXTBOX.getText();
        String state = STATE_DROPDOWN.getText();
        String zipCode = ZIP_CODE_TEXTBOX.getText();
        String nonUsProvince = NON_US_PROVIENCE_TEXTBOX.getText();
        String country = COUNTRY_DROPDOWN.getText();
        String account = ACCOUNT_DROPDOWN.getText();
        String userNotes = USER_NOTES_TEXTBOX.getText();

        contactData.add(name);
        contactData.add(email);
        contactData.add(organization);
        contactData.add(url);
        contactData.add(phone);
        contactData.add(fax);
        contactData.add(tollFree);
        contactData.add(streetAddress1);
        contactData.add(streetAddress2);
        contactData.add(streetAddress3);
        contactData.add(city);
        contactData.add(state);
        contactData.add(zipCode);
        contactData.add(nonUsProvince);
        contactData.add(country);
        contactData.add(account);
        contactData.add(userNotes);

        return contactData;

    }


}
