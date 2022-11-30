package pageObjects.Speaker;

import globals.CommonActionsPage;
import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sqlite.util.StringUtils;
import pojo.AddCustomFieldsData;
import pojo.AddSpeakerData;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class AddSpeakerPage extends CommonActionsPage{

    @FindBy(xpath = "//input[@ng-model='speaker.prefix']")
    public static WebElement PREFIX_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.firstName']")
    public static WebElement FIRST_NAME_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.middleName']")
    public static WebElement MIDDLE_NAME_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.lastName']")
    public static WebElement LAST_NAME_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.suffix']")
    public static WebElement SUFFIX_TEXTBOX;

    @FindBy(xpath = "//input[@id='dLabel']")
    public static WebElement SPEAKER_TYPE_COMBOBOX;

    @FindBy(xpath = "//select[@ng-model='speaker.gender']")
    public static WebElement GENDER_COMBOBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.badgeName']")
    public static WebElement BADGE_NAME_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.organization']")
    public static WebElement ORGANIZATION_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.email']")
    public static WebElement EMAIL_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.position']")
    public static WebElement POSITION_TEXTBOX;
    @FindBy(xpath = "//input[@ng-model='speaker.pin']")
    public static WebElement USER_NAME_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.speakerPassword']")
    public static WebElement PASSWORD_TEXTBOX;

    //@FindBy(xpath = "//select[@ng-model='dob.datepicker']")
    @FindBy(xpath = "//input[@id='dobEdit']")
    public WebElement DATE_OF_BIRTH_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.phone']")
    public static WebElement PHONE_NUMBER_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.phoneMobile']")
    public static WebElement MOBILE_NUMBER_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.fax']")
    public static WebElement FAX_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.weblink']")
    public static WebElement WEB_ADDRESS_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.address.line1']")
    public static WebElement ADDRESS_LINE1_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.address.line2']")
    public static WebElement ADDRESS_LINE2_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.address.city']")
    public static WebElement CITY_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.address.postalCode']")
    public static WebElement POSTAL_CODE_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.address.state']")
    public static WebElement STATE_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='speaker.address.country']")
    public static WebElement COUNTRY_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='facebook.url']")
    public static WebElement FACEBOOK_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='google.url']")
    public static WebElement GOOGLE_TEXTBOX;

    //@FindBy(xpath = "//input[@ng-model='linkedin.url']")
    @FindBy(xpath = "//input[@ng-model='linkedIn.url']")
    public static WebElement LINKEDIN_TEXTBOX;

    @FindBy(xpath = "//input[@ng-model='twitter.url']")
    public static WebElement TWITTER_TEXTBOX;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement SPEAKER_SAVE_BUTTON;

    @FindBy(xpath = "//input[@value='Cancel']")
    public WebElement SPEAKER_CANCEL_BUTTON;

    @FindBy(xpath = "//label[text()='Speaker Type']/..//button[@id='dLabel']")
    public WebElement SPEAKER_TYPE_BUTTON;

    @FindBy(xpath = "//label[text()='Speaker Type']/..//following-sibling::div/ul/div[2]//div")
    public List<WebElement> SPEAKER_TYPE_DROPDOWN_LIST;
    @FindBy(xpath = "//label[text()='Speaker Type']/..//following-sibling::div/ul//input[@placeholder='Add New']")
    public WebElement SPEAKER_TYPE_TEXTBOX;
    @FindBy(xpath = "//label[text()='Speaker Type']/..//following-sibling::div/ul//span[text()='Add New']")
    public WebElement SPEAKER_TYPE_ADDNEW_BUTTON;

    @FindBy(xpath = "//button[text()='Session(s)']")
    public WebElement SESSIONS_EXPAND_BUTTON;
    @FindBy(xpath = "//tr[@ng-repeat='sessionInstance in sessionInstanceList']")
    public List<WebElement> SESSIONS_LIST;

    @FindBy(xpath = "//h4[text()='Custom Speaker Data']/..//i")
    public WebElement CUSTOM_SPEAKER_DATA_EXPAND_BUTTON;

    @FindBy(xpath = "//button[text()='Upload File']")
    public WebElement UPLOAD_FILE_BUTTON;
    @FindBy(xpath = "//button[text()='Choose File']")
    public WebElement CHOOSE_FILE_BUTTON;

    @FindBy(xpath = "//h4[text()='Additional Detail']/..//i")
    public WebElement ADDITIONAL_DETAIL_SECTION_EXPAND;

    @FindBy(xpath = "//textarea[@x-ng-model='speaker.notes']")
    public WebElement SPEAKER_NOTES;

    @FindBy(xpath = "//iframe[@id='bioEdit_ifr']")
    public WebElement SPEAKER_BIO_IFRAME;

    @FindBy(xpath = "//label[text()='Speaker Agreement']//following-sibling::div//button[contains(@ng-click,'toggleShowDragDropForChangeFile')]")
    public WebElement SPEAKER_AGREEMENT_UPLOAD_BUTTON;

    @FindBy(xpath = "//label[text()='Speaker Agreement']//following-sibling::div//input[@type='file']")
    public WebElement FILE_CHOOSER_BUTTON;

    @FindBy(xpath = "//input[@id='fileUploadAdd']")
    public WebElement PROFILE_BROWSE_BUTTON;

    @FindBy(xpath = "//input[@id='uploadAdd']")
    public WebElement PROFILE_UPLOAD_BUTTON;

    public AddSpeakerPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

     private void enterPrefix(String value)throws Exception{
         type(PREFIX_TEXTBOX, value);
         logReport("entered value "+value+" in prefix text box.");
     }

    private void enterFirstName(String value)throws Exception{
        type(FIRST_NAME_TEXTBOX, value);
        logReport("entered value "+value+" in first name text box.");
    }

    private void enterMiddleName(String value)throws Exception{
        type(MIDDLE_NAME_TEXTBOX, value);
        logReport("entered value "+value+" in middle name text box.");
    }

    private void enterLastName(String value)throws Exception{
        type(LAST_NAME_TEXTBOX, value);
        logReport("entered value "+value+" in last name text box.");
    }

    private void enterSuffix(String value)throws Exception{
        type(SUFFIX_TEXTBOX, value);
        logReport("entered value "+value+" in suffix text box.");
    }


    private void selectSpeakerType(String value) throws Exception{
        select(SPEAKER_TYPE_COMBOBOX, value);
        logReport("selected value "+value+" in Speaker type combo box.");
    }

    private void selectGender(String value) throws Exception{
        select(GENDER_COMBOBOX, value);
        logReport("selected value "+value+" in gender combo box.");
    }

    private void enterBadgeName(String value)throws Exception{
        type(BADGE_NAME_TEXTBOX, value);
        logReport("entered value "+value+" in badge name text box.");
    }

    private void enterOrganization(String value)throws Exception{
        type(ORGANIZATION_TEXTBOX, value);
        logReport("entered value "+value+" in organization text box.");
    }

    private void enterEmail(String value)throws Exception{
        type(EMAIL_TEXTBOX, value);
        logReport("entered value "+value+" in email text box.");
    }


    private void enterPosition(String value)throws Exception{

        type(POSITION_TEXTBOX,value);
        logReport("entered value "+value+" in position text box.");
    }

    private void enterUsername(String value)throws Exception{
        type(USER_NAME_TEXTBOX, value);
        logReport("entered value "+value+" in user name text box.");
    }

    private void enterPassword(String value)throws Exception{
        type(PASSWORD_TEXTBOX, value);
        logReport("entered value "+value+" in password text box.");
    }

    private void enterDateOfBirth(String value)throws Exception{
        DATE_OF_BIRTH_TEXTBOX.sendKeys(value);
        DATE_OF_BIRTH_TEXTBOX.sendKeys(Keys.TAB);
        logReport("entered value "+value+" in DOB text box.");
    }

    private void enterPhoneNumber(String value)throws Exception{
        type(PHONE_NUMBER_TEXTBOX, value);
        logReport("entered value "+value+" in phone number text box.");
    }

    private void enterMobileNumber(String value)throws Exception{
        Wait(MOBILE_NUMBER_TEXTBOX,20);
        type(MOBILE_NUMBER_TEXTBOX,value);
        logReport("entered value "+value+" in mobile number text box.");
    }

    private void enterFax(String value)throws Exception{
        type(FAX_TEXTBOX, value);
        logReport("entered value "+value+" in fax text box.");
    }

    private void enterWebAddress(String value)throws Exception{
        type(WEB_ADDRESS_TEXTBOX, value);
        logReport("entered value "+value+" in web address text box.");
    }

    private void enterAddressLineOne(String value)throws Exception{
        type(ADDRESS_LINE1_TEXTBOX,value);
        logReport("entered value "+value+" in address line 1 text box.");
    }

    private void enterAddressLineTwo(String value)throws Exception{
        type(ADDRESS_LINE2_TEXTBOX, value);
        logReport("entered value "+value+" in address line 2 text box.");
    }

    private void enterCity(String value)throws Exception{
        Wait(CITY_TEXTBOX,20);
        type(CITY_TEXTBOX,value);
        logReport("entered value "+value+" in city text box.");
    }

    private void enterPostalCode(String value)throws Exception{
        type(POSTAL_CODE_TEXTBOX, value);
        logReport("entered value "+value+" in postal code text box.");
    }

    private void enterState(String value)throws Exception{
        type(STATE_TEXTBOX, value);
        logReport("entered value "+value+" in state text box.");
    }

    private void enterCountry(String value)throws Exception{

        type(COUNTRY_TEXTBOX,value);
        logReport("entered value "+value+" in country text box.");
    }

    private void enterFaceBookId(String value)throws Exception{

        type(FACEBOOK_TEXTBOX,value);
        logReport("entered value "+value+" in facebook text box.");
    }

    private void enterGoogleId(String value)throws Exception{

        type(GOOGLE_TEXTBOX,value);
        logReport("entered value "+value+" in google text box.");
    }

    private void enterLinkedInId(String value)throws Exception{

        type(LINKEDIN_TEXTBOX,value);
        logReport("entered value "+value+" in linked in text box.");
    }

    private void enterTwitterId(String value)throws Exception{
        type(TWITTER_TEXTBOX,value);
        logReport("entered value "+value+" in twitter text box.");
    }

    public SpeakerPage clickSpeakerSaveButton() throws Exception {
        Wait(SPEAKER_SAVE_BUTTON, 30);
        click(SPEAKER_SAVE_BUTTON);
        logReport("Speaker Save button clicked successfully.");
        VerifyAngularHasFinishedProcessing(10);
        VerifyAjaxRequestsFinished(30);
        VerifyPageReady(30);
        return  new SpeakerPage(browser);
    }

    public SpeakerPage clickSpeakerCancelButton() throws Exception {
        Wait(SPEAKER_CANCEL_BUTTON, 30);
        clickByJavaScript(SPEAKER_CANCEL_BUTTON);
        logReport("Speaker Cancel button clicked successfully.");
        VerifyPageReady(30);
        return new SpeakerPage(browser);
    }

    public void selectProfilePicture(String fileName) throws Exception {
        File file = new File("target/test-classes/files/" + fileName);
        String absolutePath = file.getAbsolutePath();
        reporter.info("file path " + absolutePath);
        PROFILE_BROWSE_BUTTON.sendKeys(absolutePath);
        Wait(PROFILE_UPLOAD_BUTTON, 30);
        click(PROFILE_UPLOAD_BUTTON);
        VerifyPageReady(20);
        VerifyAjaxRequestsFinished(20);
        VerifyAngularHasFinishedProcessing(20);
    }
    public boolean isSpeakerTypeValueFound(String speakerType) {
        boolean found = false;
        if (SPEAKER_TYPE_DROPDOWN_LIST.size() > 0) {
            for (WebElement e : SPEAKER_TYPE_DROPDOWN_LIST) {
                if (e.getText().trim().equalsIgnoreCase(speakerType)) {
                    found = true;
                    break;
                }

            }
        }
        return found;
    }

    public void selectSpeakerTypeOrAddNew(String speakerType) throws Exception {
        click(SPEAKER_TYPE_BUTTON);
        logReport("click on speaker type dropdown button.");
        for (WebElement e : SPEAKER_TYPE_DROPDOWN_LIST) {
                if (e.getText().trim().equalsIgnoreCase(speakerType)) {
                    e.click();
                    logReport("Speaker type exist and clicked successfully.");
                    return;
                }

        }
        type(SPEAKER_TYPE_TEXTBOX, speakerType);
        logReport("Entered speaker type text value " + speakerType);
        click(SPEAKER_TYPE_ADDNEW_BUTTON);
        logReport("Speaker Type add new button clicked successfully.");
        click(SPEAKER_TYPE_BUTTON);
        logReport("Speaker Type button clicked.");


    }

    public void fillSpeakerDetails(AddSpeakerData addSpeakerData) throws Exception{
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        enterPrefix(addSpeakerData.getPrefix());
        enterFirstName(addSpeakerData.getFirstName());
        enterMiddleName(addSpeakerData.getMiddleName());
        enterLastName(addSpeakerData.getLastName());
        enterSuffix(addSpeakerData.getSuffix());
        selectSpeakerTypeOrAddNew(addSpeakerData.getSpeakerType());
        selectGender(addSpeakerData.getGender());
        enterBadgeName(addSpeakerData.getBadgeName());
        enterOrganization(addSpeakerData.getOrganization());
        enterEmail(addSpeakerData.getEmail());
        enterPosition(addSpeakerData.getPosition());
        enterUsername(addSpeakerData.getUsername());
        enterPassword(addSpeakerData.getPassword());
        enterDateOfBirth(addSpeakerData.getDob());
        enterPhoneNumber(addSpeakerData.getPhone());
        enterMobileNumber(addSpeakerData.getMobile());
        enterFax(addSpeakerData.getFax());
        enterWebAddress(addSpeakerData.getWebAddress());
        enterAddressLineOne(addSpeakerData.getAddressLine1());
        enterAddressLineTwo(addSpeakerData.getAddressLine2());
        enterCity(addSpeakerData.getCity());
        enterPostalCode(addSpeakerData.getPostalCode());
        enterState(addSpeakerData.getState());
        enterCountry(addSpeakerData.getCountry());
        enterFaceBookId(addSpeakerData.getFacebook());
        enterGoogleId(addSpeakerData.getGoogle());
        enterLinkedInId(addSpeakerData.getLinkedIn());
        enterTwitterId(addSpeakerData.getTwitter());

    }

    public void fillSpeakerMandatoryDetails(AddSpeakerData addSpeakerData) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        String email = addSpeakerData.getFirstName() + "@gmail.com";
        String userName = addSpeakerData.getFirstName() + " " + addSpeakerData.getLastName();
        logReport("User Name is : " + userName);
        enterFirstName(addSpeakerData.getFirstName());
        enterLastName(addSpeakerData.getLastName());
        selectSpeakerTypeOrAddNew(addSpeakerData.getSpeakerType());
        enterEmail(email);
        enterUsername(userName);
        enterPassword(addSpeakerData.getFirstName());
    }

    public void fillSpeaker(AddSpeakerData addSpeakerData) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        logReport("User Name is : " + userName);
        enterFirstName(addSpeakerData.getFirstName());
        enterLastName(addSpeakerData.getLastName());
        selectSpeakerTypeOrAddNew(addSpeakerData.getSpeakerType());
        enterEmail(addSpeakerData.getEmail());
        enterUsername(addSpeakerData.getUsername());
        enterPassword(addSpeakerData.getPassword());
    }

    public void expandSessionsSection() throws Exception {
        click(SESSIONS_EXPAND_BUTTON);
        logReport("Sessions section expand button clicked successfully.");
        VerifyPageReady(20);
    }

    public boolean isSessionFound(String sessionName) throws Exception {
        Thread.sleep(2000);
        String xpath = "//li[@ng-repeat='sessionInstance in sessionInstanceList']//h4[text()='" + sessionName + "']";
        return verifyElementDisplayed(By.xpath(xpath), 5);

    }

    public boolean isSessionFoundForConfSession(String sessionName) {
        String xpath = "//tr[@x-ng-if='showMasterSpeaker(sessionInstance)']//td[1][text()='" + sessionName + "']";
        return verifyElementDisplayed(By.xpath(xpath), 10);

    }

    public void expandCustomSpeakerDataSection() throws Exception {
        String xpath = "//h4[text()='Custom Speaker Data']/..//i[@class='fa fa-caret-down fa-2x pull-right p5']";

        if (VerifyElementPresent(By.xpath(xpath), 2)) {
            Wait(CUSTOM_SPEAKER_DATA_EXPAND_BUTTON, 10);
            click(CUSTOM_SPEAKER_DATA_EXPAND_BUTTON);
            VerifyAngularHasFinishedProcessing(10);
            logReport("Custom speaker data section expand button clicked successfully.");
        } else {
            logReport("Custom speaker data section expand button already clicked.");
        }
    }


    public void assignCustomField(AddCustomFieldsData addCustomFieldsData) throws Exception {
        String fieldName = addCustomFieldsData.getFieldName();
        String fieldType = addCustomFieldsData.getFieldType();
        String options[] = addCustomFieldsData.getOptions().split(",");
        if (fieldType.equalsIgnoreCase("Radio") || fieldType.equalsIgnoreCase("Select") || fieldType.equalsIgnoreCase("Checkbox") || fieldType.equalsIgnoreCase("Select Multiple")) {
            String xpath = "//label[contains(text(),'" + fieldName + "')][@class='boldFont expand-question-label ng-binding']/../..//select";
            WebElement element = browser.findElement(By.xpath(xpath));
            Wait(element, 10);
            select(element, options[0]);
            logReport("Custom speaker field : " + fieldName + " selected successfully.");
        }

        if (fieldType.equalsIgnoreCase("Text")) {
            String xpath = "//label[contains(text(),'" + fieldName + "')][@class='boldFont expand-question-label ng-binding']/../..//input";
            WebElement element = browser.findElement(By.xpath(xpath));
            Wait(element, 10);
            type(element, options[0]);
            logReport("Custom speaker field : " + fieldName + " selected successfully.");

        }
        if (fieldType.equalsIgnoreCase("Textarea")) {
            String xpath = "//label[contains(text(),'" + fieldName + "')][@class='boldFont expand-question-label ng-binding']/../..//textarea";
            WebElement element = browser.findElement(By.xpath(xpath));
            Wait(element, 10);
            type(element, options[0]);
            logReport("Custom speaker field : " + fieldName + " selected successfully.");

        } else {
            logReport("Custom speaker field is not selected successfully.");
        }
    }

    public boolean isCustomFieldFound(String fieldName) throws Exception {
        boolean found = false;

        String xpath = "//label[contains(text(),'" + fieldName + "')][@class='boldFont expand-question-label ng-binding']";
        if (VerifyElementPresent(By.xpath(xpath), 1)) {
            found = true;
        } else {
            logReport("Custom field : " + fieldName + " is not assigned to Speaker.");
        }

        return found;
    }

    public void unAssignCustomField(AddCustomFieldsData addCustomFieldsData) throws Exception {

        String fieldName = addCustomFieldsData.getFieldName();
        String fieldType = addCustomFieldsData.getFieldType();
        if (fieldType.equalsIgnoreCase("Radio") || fieldType.equalsIgnoreCase("Select")) {
            String xpath = "//label[contains(text(),'" + fieldName + "')][@class='boldFont expand-question-label ng-binding']/../..//span//i";
            WebElement element = browser.findElement(By.xpath(xpath));
            Wait(element, 10);
            click(element);
            logReport("Custom speaker field : " + fieldName + " removed successfully.");
        }

        if (fieldType.equalsIgnoreCase("Checkbox") || fieldType.equalsIgnoreCase("Select Multiple")) {
            String options[] = addCustomFieldsData.getOptions().split(",");
            String xpath = "//label[contains(text(),'" + fieldName + "')][@class='boldFont expand-question-label ng-binding']/../..//div[text()='" + options[0] + "']/..//a";
            WebElement element = browser.findElement(By.xpath(xpath));
            Wait(element, 10);
            click(element);
            logReport("Custom speaker field : " + fieldName + " removed successfully.");

        }

        if (fieldType.equalsIgnoreCase("Text")) {
            String xpath = "//label[contains(text(),'" + fieldName + "')][@class='boldFont expand-question-label ng-binding']/../..//input";
            WebElement element = browser.findElement(By.xpath(xpath));
            Wait(element, 10);
            element.clear();
            logReport("Custom speaker field : " + fieldName + " removed successfully.");

        }
        if (fieldType.equalsIgnoreCase("Textarea")) {
            String xpath = "//label[contains(text(),'" + fieldName + "')][@class='boldFont expand-question-label ng-binding']/../..//textarea";
            WebElement element = browser.findElement(By.xpath(xpath));
            Wait(element, 10);
            element.clear();
            logReport("Custom speaker field : " + fieldName + " removed successfully.");

        } else {
            logReport("Custom speaker field : " + fieldName + " is not removed successfully.");
        }
    }


    public void importCustomFieldFile(String fieldName, String fileName) throws Exception {
        clickUploadFileButton(fieldName);
        selectImportFile(fieldName, fileName);
        logReport("File Uploaded SuccessFully.");

    }

    public void clickUploadFileButton(String fieldName) throws Exception {
        String xpath = "//label[contains(text(),'" + fieldName + "')][@class='boldFont expand-question-label ng-binding']/..//following-sibling::div//button[text()='Upload File']";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 10);
        clickByJavaScript(element);
        logReport("Upload file Button is clicked SuccessFully.");

    }

    public void selectImportFile(String fieldName, String fileName) throws Exception {
        File file = new File("target/test-classes/files/" + fileName);
        String absolutePath = file.getAbsolutePath();
        reporter.info("file path " + absolutePath);
        String xpath = "//label[contains(text(),'" + fieldName + "')][@class='boldFont expand-question-label ng-binding']/..//following-sibling::div//input[@type='file']";
        WebElement element = browser.findElement(By.xpath(xpath));
        if (element.getAttribute("class").contains("hidden")) {
            setElementAttribute(element, "btn btn-info fileChooser");
        }
        Thread.sleep(2000);
        element.sendKeys(absolutePath);
        VerifyAjaxRequestsFinished(20);
    }

    public void assignFileTypeCustomField(String fieldName, String fileName) throws Exception {
        String xpath = "//label[contains(text(),'" + fieldName + "')][@class='boldFont expand-question-label ng-binding']";
        if (VerifyElementPresent(By.xpath(xpath), 1)) {
            importCustomFieldFile(fieldName, fileName);
        } else {
            logReport("Custom field : " + fieldName + " is not present on Custom speaker data section.");
        }
    }

    public void setElementAttribute(WebElement element, String value) {
        executeJavascript("arguments[0].setAttribute('class', '" + value + "')", element);

    }

    public void clickOnShowMoreExpand() throws Exception {
        String xpath = "//span[text()='Show More..']";
        if (VerifyElementPresent(By.xpath(xpath), 1)) {
            click(browser.findElement(By.xpath(xpath)));
            logReport("More show button is clicked successfully.");

        } else {
            logReport("More show button is already clicked.");
        }
    }

    public void expandAdditionalDetailSection() throws Exception {
        if (ADDITIONAL_DETAIL_SECTION_EXPAND.getAttribute("class").contains("down")) {
            clickByJavaScript(ADDITIONAL_DETAIL_SECTION_EXPAND);
            logReport("Additional detail section expanded successfully");
        }
        VerifyPageReady(30);
    }

    public void enterTextareaNotes(String notes) {
        type(SPEAKER_NOTES, notes, true);
        logReport("Entered speaker notes value " + notes);
    }

    public void enterBioNotes(String bio) throws Exception {
        Thread.sleep(3000);
        browser.switchTo().frame(SPEAKER_BIO_IFRAME);
        browser.findElement(By.cssSelector("body")).clear();
        browser.findElement(By.cssSelector("body")).sendKeys(bio);
        browser.switchTo().defaultContent();
        /*String value = "display: block;";
        executeJavascript("arguments[0].setAttribute('style', '" + value + "')", SPEAKER_BIO_IFRAME);
        Thread.sleep(1000);
        type(SPEAKER_BIO_IFRAME, bio, true);*/
        logReport("Entered bio notes vaue " + bio);

    }

    public void selectSpeakerAgreementFile(String fileName) throws Exception {
        Wait(SPEAKER_AGREEMENT_UPLOAD_BUTTON, 20);
        clickByJavaScript(SPEAKER_AGREEMENT_UPLOAD_BUTTON);
        logReport("Speaker agreement upload file button clicked successfully");
        selectFile(fileName, FILE_CHOOSER_BUTTON);
        clickByJavaScript(SPEAKER_AGREEMENT_UPLOAD_BUTTON);
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

    public void fillCompleteSpeakerDetails(AddSpeakerData addSpeakerData) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(10);
        enterPrefix(addSpeakerData.getPrefix());
        enterFirstName(addSpeakerData.getFirstName());
        enterMiddleName(addSpeakerData.getMiddleName());
        enterLastName(addSpeakerData.getLastName());
        enterSuffix(addSpeakerData.getSuffix());
        selectSpeakerTypeOrAddNew(addSpeakerData.getSpeakerType());
        selectGender(addSpeakerData.getGender());
        enterBadgeName(addSpeakerData.getBadgeName());
        enterOrganization(addSpeakerData.getOrganization());
        enterEmail(addSpeakerData.getEmail());
        enterPosition(addSpeakerData.getPosition());
        enterUsername(addSpeakerData.getUsername());
        enterPassword(addSpeakerData.getPassword());
        enterDateOfBirth(addSpeakerData.getDob());
        enterPhoneNumber(addSpeakerData.getPhone());
        enterMobileNumber(addSpeakerData.getMobile());
        enterFax(addSpeakerData.getFax());
        enterWebAddress(addSpeakerData.getWebAddress());
        enterAddressLineOne(addSpeakerData.getAddressLine1());
        enterAddressLineTwo(addSpeakerData.getAddressLine2());
        enterCity(addSpeakerData.getCity());
        enterPostalCode(addSpeakerData.getPostalCode());
        enterState(addSpeakerData.getState());
        enterCountry(addSpeakerData.getCountry());
        enterFaceBookId(addSpeakerData.getFacebook());
        enterGoogleId(addSpeakerData.getGoogle());
        enterLinkedInId(addSpeakerData.getLinkedIn());
        enterTwitterId(addSpeakerData.getTwitter());
        expandAdditionalDetailSection();
        enterBioNotes(addSpeakerData.getBio());
        enterTextareaNotes(addSpeakerData.getNotes());

    }

    public String getInputCustomFieldValues(String customFieldName) {
        String xpath = "//label[contains(text(),'" + customFieldName + "')]/..//following-sibling::div/input";
        return browser.findElement(By.xpath(xpath)).getAttribute("value").trim();
    }

    public String getTextAreaCustomFieldValues(String customFieldName) {
        String xpath = "//label[contains(text(),'" + customFieldName + "')]/..//following-sibling::div/textarea";
        return browser.findElement(By.xpath(xpath)).getAttribute("value").trim();
    }

    public String getSelectTypeCustomFieldValues(String customFieldName, String separator) {
        String xpath = "//label[contains(text(),'" + customFieldName + "')]/..//following-sibling::div[1]//select";
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

}
