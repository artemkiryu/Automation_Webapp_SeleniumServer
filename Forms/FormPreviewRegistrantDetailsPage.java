package pageObjects.Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.FormPreviewRegistrantDetails;

import javax.naming.ConfigurationException;

public class FormPreviewRegistrantDetailsPage extends CommonActionsPage {
    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement CONTINUE_BUTTON;
    @FindBy(xpath = "//input[@id='pro_fname']")
    public WebElement FIRSTNAME_TEXTBOX;
    @FindBy(xpath = "//input[@id='pro_lname']")
    public WebElement LASTNAME_TEXTBOX;
    @FindBy(xpath = "//input[@id='pro_email']")
    public WebElement EMAIL_ADDRESS_TEXTBOX;
    @FindBy(xpath = "//input[@id='pro_position']")
    public WebElement OCCUPATION_TEXTBOX;
    @FindBy(xpath = "//input[@id='pro_organization']")
    public WebElement COMPANY_TEXTBOX;
    @FindBy(xpath = "//input[@id='pro_addr_line1']")
    public WebElement ADDRESS_TEXTBOX;
    @FindBy(xpath = "//input[@id='pro_addr_line2']")
    public WebElement ADDRESS_LINE2_TEXTBOX;
    @FindBy(xpath = "//input[@id='pro_addr_city']")
    public WebElement CITY_TEXTBOX;
    @FindBy(xpath = "//select[@id='pro_addr_state']")
    public WebElement STATE_DROPDOWN;
    @FindBy(xpath = "//input[@id='pro_addr_postal_code']")
    public WebElement ZIPCODE_TEXTBOX;
    @FindBy(xpath = "//select[@id='pro_addr_country']")
    public WebElement COUNTRY_DROPDOWN;
    @FindBy(xpath = "//input[@id='pro_phone']")
    public WebElement PHONENUMBER_TEXTBOX;
    @FindBy(xpath = "//select[@id='pro_ans_field01']")
    public WebElement CUSTOM_FIELD_DROPDOWN;

    public FormPreviewRegistrantDetailsPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void selectCustomFieldDropdown(String country) throws Exception {
        select(CUSTOM_FIELD_DROPDOWN, country);
        logReport("Selected custom field value " + country);
        VerifyPageReady(30);
    }
    private void selectAttendeeTypeRadiobutton(String attendeeType) {
        //    webDriver.click(By.xpath(ATTENDEE_CHK));
        String xpath = "//table[@class='form-table']//tr/td/font[text()='" + attendeeType + "']/..//following-sibling::td/input";
        clickByJavaScript(browser.findElement(By.xpath(xpath)));
        reporter.info("Attendee type radio button selected");
    }

    public void fillRegistrantDetails(FormPreviewRegistrantDetails formPreviewRegistrantDetails, String attendeeType) throws Exception {
        Wait(FIRSTNAME_TEXTBOX, 10);
        type(FIRSTNAME_TEXTBOX, formPreviewRegistrantDetails.getFirstName(), true);
        type(LASTNAME_TEXTBOX, formPreviewRegistrantDetails.getLastName(), true);
        type(EMAIL_ADDRESS_TEXTBOX, formPreviewRegistrantDetails.getEmail(), true);
        type(OCCUPATION_TEXTBOX, formPreviewRegistrantDetails.getOccupation(), true);
        type(COMPANY_TEXTBOX, formPreviewRegistrantDetails.getCompanyName(), true);
        type(ADDRESS_TEXTBOX, formPreviewRegistrantDetails.getAddressLine1(), true);
        type(ADDRESS_LINE2_TEXTBOX, formPreviewRegistrantDetails.getAddressLine2(), true);
        type(CITY_TEXTBOX, formPreviewRegistrantDetails.getCity(), true);
        select(COUNTRY_DROPDOWN, formPreviewRegistrantDetails.getCountry());
        VerifyAjaxRequestsFinished(20);
        select(STATE_DROPDOWN, formPreviewRegistrantDetails.getState());
        type(ZIPCODE_TEXTBOX, formPreviewRegistrantDetails.getZipCode(), true);
        type(PHONENUMBER_TEXTBOX, formPreviewRegistrantDetails.getPhoneNo(), true);
        selectAttendeeTypeRadiobutton(attendeeType);
    }

    public FormPreviewVerifyPage clickContinueButton() throws Exception {
        Wait(CONTINUE_BUTTON, 20);
        click(CONTINUE_BUTTON);
        VerifyPageReady(30);
        reporter.info("Continue button clicked successfully");
        return new FormPreviewVerifyPage(browser);

    }

    public FormPreviewPaymentPage clickContinueButtonForPayment() throws Exception {
        Wait(CONTINUE_BUTTON, 20);
        click(CONTINUE_BUTTON);
        VerifyPageReady(30);
        reporter.info("Continue button clicked successfully");
        return new FormPreviewPaymentPage(browser);

    }
}

