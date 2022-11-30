package pageObjects.SpeakerPortal;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.SessionProposalInfo;
import pojo.SpeakerInformation;
import pojo.SubmitterInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SubmitProposalPage extends CommonActionsPage {
    @FindBy(xpath = "//button[text()=' I AM THE SPEAKER FOR THIS SESSION – REMOVE SUBMITTER']")
    public WebElement SPEAKER_REMOVE_SUBMITTER;

    @FindBy(xpath = "//button[text()=' I AM SUBMITTING ON BEHALF OF SOMEONE ELSE']")
    public WebElement SPEAKER_SUBMITTER_BEHALF;

    @FindBy(xpath = "//input[@ng-model='submitterData.email']")
    public WebElement SUBMITTER_EMAIL;
    @FindBy(xpath = "//input[@ng-model='submitterData.firstName']")
    public WebElement SUBMITTER_FIRSTNAME;
    @FindBy(xpath = "//input[@ng-model='submitterData.lastName']")
    public WebElement SUBMITTER_LASTNAME;
    @FindBy(xpath = "//input[@ng-model='submitterData.position']")
    public WebElement SUBMITTER_POSITION;
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
    @FindBy(xpath = "//div[contains(@ng-repeat,'section in speakerSections')]//input[@placeholder='Phone']")
    public WebElement PHONE_TEXTBOX;
    @FindBy(xpath = "//div[contains(@ng-repeat,'section in speakerSections')]//input[@placeholder='Organization']")
    public WebElement ORGANIZATION_TEXTBOX;
    @FindBy(xpath = "//div[contains(@ng-repeat,'section in speakerSections')]//input[@placeholder='Position']")
    public WebElement POSITION_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='speakerJson.pin']")
    public WebElement USERNAME_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='speakerJson.speakerPassword']")
    public WebElement PASSWORD_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='speakerJson.confirmPassword']")
    public WebElement CONFIRM_PWD_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='newSpeakerObject.email']")
    public WebElement ADLSPK_EMAIL_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='newSpeakerObject.phone']")
    public WebElement ADLSPK_PHONE_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='newSpeakerObject.organization']")
    public WebElement ADLSPK_ORGANIZATION_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='newSpeakerObject.position']")
    public WebElement ADLSPK_POSITION_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='newSpeakerObject.firstName']")
    public WebElement ADLSPK_FIRST_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@x-ng-model='newSpeakerObject.lastName']")
    public WebElement ADLSPK_LAST_NAME_TEXTBOX;

    @FindBy(xpath = "//button[@ng-click='addNewSpeaker()']")
    public WebElement ADD_NEW_SPEAKER_BUTTON;

    @FindBy(xpath = "//button[text()='Add Speaker']")
    public WebElement ADD_SPEAKER_BUTTON;

    @FindBy(xpath = "//input[@x-ng-model='session.name']")
    public WebElement SESSION_NAME_TEXTBOX;
    @FindBy(xpath = "//label[text()='Session Type']/..//button[@id='dLabel']")
    public WebElement SESSION_TYPE_BUTTON;
    @FindBy(xpath = "//label[text()='Session Type']/..//following-sibling::div/ul/div[2]//div")
    public List<WebElement> SESSION_TYPE_DROPDOWN_LIST;
    @FindBy(xpath = "//label[@title='Tags']/..//following-sibling::div//select")
    public WebElement TAGS_DRODPOWN;
    @FindBy(xpath = "//label[@title='Track']/..//following-sibling::div//button[@id='dLabel']")
    public WebElement TRACK_BUTTON;
    @FindBy(xpath = "//label[text()='Track']/..//following-sibling::div//ul//div[contains(@ng-click,'session.eventTrack')]")
    public List<WebElement> TRACK_DROPDOWN_LIST;
    @FindBy(xpath = "//label[@title='Session Level']/..//following-sibling::div//button[@id='dLabel']")
    public WebElement SESSION_LEVEL_BUTTON;
    @FindBy(xpath = "//label[text()='Session Level']/..//following-sibling::div//ul//div[contains(@ng-click,'session.confSessionLevel')]")
    public List<WebElement> SESSION_LEVEL_DROPDOWN_LIST;
    @FindBy(xpath = "//span[contains(@ng-if,'abstractSessionDoc')]/..//button")
    public WebElement ABSTRACT_UPLOAD_FILE;
    @FindBy(xpath = "//button[text()='Change Profile Pic']")
    public WebElement PROFILE_PIC_BUTTON;
    @FindBy(xpath = "//span[contains(@ng-if,'abstractSessionDoc')]/..//following-sibling::div//input[@type='file']")
    public WebElement FILE_CHOOSER_BUTTON_ABSTRACT;
    @FindBy(xpath = "//div[@class='upload-div']//input[@type='file']")
    public WebElement FILE_CHOOSER_BUTTON_PIC;
    @FindBy(xpath = "//label[@title='Session Notes']/..//following-sibling::div//textarea")
    public WebElement SESSION_NOTES_TEXTAREA;
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
    @FindBy(xpath = "//input[@x-ng-click='saveEntity()']")
    public WebElement SPEAKER_SAVE_BUTTON;
    @FindBy(xpath = "//input[@x-ng-click='goToHome()']")
    public WebElement CANCEL_BUTTON;

    @FindBy(xpath = "//button[@x-ng-click='closeAdditionalSpeakerAddBox()']")
    public WebElement SPEAKER_CANCEL_BUTTON;

    public SubmitProposalPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public SpeakerPortalLoginPage clickCancelButton() throws Exception {
        clickByJavaScript(CANCEL_BUTTON);
        logReport("Cancel button clicked successfully");
        return new SpeakerPortalLoginPage(browser);
    }

    private void switchToIframe(String iFrameTitle) {
        browser.switchTo().defaultContent();
        WebElement frame = browser.findElement(By.xpath("//label[@title='" + iFrameTitle + "']/../..//iframe"));
        browser.switchTo().frame(frame);
        reporter.info("Switched into iFrame of " + iFrameTitle);
    }

    private void enterIFrameText(String iFrameName, String iFrameValue) {
        switchToIframe(iFrameName);
        browser.findElement(By.cssSelector("body")).clear();
        browser.findElement(By.cssSelector("body")).sendKeys(iFrameValue);
        browser.switchTo().defaultContent();
        reporter.info("Entered iFrame value " + iFrameValue);
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

    public void enterBioValue(String bio) throws Exception {
        WebElement frame = browser.findElement(By.xpath("//label[text()='Bio']/..//following-sibling::div//div/iframe"));
        browser.switchTo().frame(frame);
        browser.findElement(By.cssSelector("body")).clear();
        browser.findElement(By.cssSelector("body")).sendKeys(bio);
        browser.switchTo().defaultContent();
        logReport("Entered Bio notes value " + bio);

    }
    public void selectSessionType(String sessionType) throws Exception {
        clickByJavaScript(SESSION_TYPE_BUTTON);
        logReport("click on session type dropdown button.");
        for (WebElement e : SESSION_TYPE_DROPDOWN_LIST) {
            if (e.getText().trim().equalsIgnoreCase(sessionType)) {
                e.click();
                logReport("Session type exist and clicked successfully");

            }
        }

    }

    public void selectTagsDropdown(String tags) {
        //TAGS_DRODPOWN.clear();
        String a[] = tags.split(",");
        for (int i = 0; i < a.length; i++) {
            select(TAGS_DRODPOWN, a[i]);
            logReport("Selected tags values " + a[i]);
        }
    }

    public void selectSessionTrack(String track) throws Exception {
        //Wait(TRACK_BUTTON, 10);
        clickByJavaScript(TRACK_BUTTON);
        logReport("click on track dropdown button.");
        for (WebElement e : TRACK_DROPDOWN_LIST) {
            if (e.getText().trim().equalsIgnoreCase(track)) {
                e.click();
                logReport("Session track exist and clicked successfully");

            }
        }
    }

    public void selectSessionLevel(String sessionLevel) throws Exception {
        // Wait(SESSION_LEVEL_BUTTON, 10);
        clickByJavaScript(SESSION_LEVEL_BUTTON);
        logReport("click on Session level dropdown button.");
        for (WebElement e : SESSION_LEVEL_DROPDOWN_LIST) {
            if (e.getText().trim().equalsIgnoreCase(sessionLevel)) {
                e.click();
                logReport("Session level exist and clicked successfully");

            }
        }

    }

    public void selectAbstractFile(String fileName) throws Exception {
        Wait(ABSTRACT_UPLOAD_FILE, 20);
        clickByJavaScript(ABSTRACT_UPLOAD_FILE);
        logReport("Abstract upload file button clicked successfully");
        selectFile(fileName, FILE_CHOOSER_BUTTON_ABSTRACT);
        clickByJavaScript(ABSTRACT_UPLOAD_FILE);
        Thread.sleep(2000);

    }

    public void selectProfilePic(String fileName) throws Exception {
        Wait(PROFILE_PIC_BUTTON, 20);
        clickByJavaScript(PROFILE_PIC_BUTTON);
        logReport("Profile pic button clicked successfully");
        selectFile(fileName, FILE_CHOOSER_BUTTON_PIC);
        VerifyAjaxRequestsFinished(20);
        Thread.sleep(2000);

    }

    public void enterSessionName(String name) throws Exception {
        //String nameWithRandonNo = name + generateRandomNumber(3);
        type(SESSION_NAME_TEXTBOX, name, true);
        logReport("Entered Session Name value " + name);
    }

    public void selectFile(String fileName, WebElement element) throws Exception {
        File file = new File("target/test-classes/files/" + fileName);
        String absolutePath = file.getAbsolutePath();
        reporter.info("file path " + absolutePath);
        //webDriver.type(FILE_CHOOSER_BUTTON,absolutePath);
        if (element.getAttribute("class").contains("hidden")) {
            setElementAttribute(element, "btn btn-info fileChooser");

        }
        Thread.sleep(2000);
        element.sendKeys(absolutePath);
        VerifyAjaxRequestsFinished(20);

    }

    private void enterPrefix(String value) throws Exception {
        type(PREFIX_TEXTBOX, value, true);
        logReport("entered value " + value + " in prefix text box.");
    }

    private void enterFirstName(String value) throws Exception {
        type(FIRST_NAME_TEXTBOX, value, true);
        logReport("entered value " + value + " in first name text box.");
    }

    private void enterMiddleName(String value) throws Exception {
        type(MIDDLE_NAME_TEXTBOX, value, true);
        logReport("entered value " + value + " in middle name text box.");
    }

    private void enterLastName(String value) throws Exception {
        type(LAST_NAME_TEXTBOX, value, true);
        logReport("entered value " + value + " in last name text box.");
    }

    private void enterSuffix(String value) throws Exception {
        type(SUFFIX_TEXTBOX, value, true);
        logReport("entered value " + value + " in suffix text box.");
    }


    private void enterOrganization(String value) throws Exception {
        type(ORGANIZATION_TEXTBOX, value, true);
        logReport("entered value " + value + " in organization text box.");
    }

    private void enterEmail(String value) throws Exception {
        type(EMAIL_TEXTBOX, value, true);
        logReport("entered value " + value + " in email text box.");
    }


    private void enterPosition(String value) throws Exception {
        type(POSITION_TEXTBOX, value, true);
        logReport("entered value " + value + " in position text box.");
    }

    private void enterUsername(String value) throws Exception {
        type(USERNAME_TEXTBOX, value, true);
        logReport("entered value " + value + " in user name text box.");
    }

    private void enterPassword(String value) throws Exception {
        type(PASSWORD_TEXTBOX, value, true);
        logReport("entered value " + value + " in password text box.");
    }

    private void enterConfirmPassword(String value) throws Exception {
        type(CONFIRM_PWD_TEXTBOX, value, true);
        logReport("entered value " + value + " in password text box.");
    }

    private void enterPhoneNumber(String value) throws Exception {
        type(PHONE_TEXTBOX, value, true);
        logReport("entered value " + value + " in phone number text box.");
    }

    private void enterAddressLineOne(String value) throws Exception {
        type(ADDRESS_LINE1_TEXTBOX, value, true);
        logReport("entered value " + value + " in address line 1 text box.");
    }

    private void enterAddressLineTwo(String value) throws Exception {
        type(ADDRESS_LINE2_TEXTBOX, value, true);
        logReport("entered value " + value + " in address line 2 text box.");
    }

    private void enterCity(String value) throws Exception {
        Wait(CITY_TEXTBOX, 20);
        type(CITY_TEXTBOX, value, true);
        logReport("entered value " + value + " in city text box.");
    }

    private void enterPostalCode(String value) throws Exception {
        type(POSTAL_CODE_TEXTBOX, value, true);
        logReport("entered value " + value + " in postal code text box.");
    }

    private void enterState(String value) throws Exception {
        type(STATE_TEXTBOX, value, true);
        logReport("entered value " + value + " in state text box.");
    }

    private void enterCountry(String value) throws Exception {

        type(COUNTRY_TEXTBOX, value, true);
        logReport("entered value " + value + " in country text box.");
    }

    private void enterFaceBookId(String value) throws Exception {

        type(FACEBOOK_TEXTBOX, value, true);
        logReport("entered value " + value + " in facebook text box.");
    }

    private void enterGoogleId(String value) throws Exception {

        type(GOOGLE_TEXTBOX, value, true);
        logReport("entered value " + value + " in google text box.");
    }

    private void enterLinkedInId(String value) throws Exception {

        type(LINKEDIN_TEXTBOX, value, true);
        logReport("entered value " + value + " in linked in text box.");
    }

    private void enterTwitterId(String value) throws Exception {
        type(TWITTER_TEXTBOX, value, true);
        logReport("entered value " + value + " in twitter text box.");
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

    public void fillSpeakerProposalMandatoryInfo(SpeakerInformation speakerInformation) throws Exception {
        enterFirstName(speakerInformation.getFirstName());
        enterLastName(speakerInformation.getLastName());
        enterEmail(speakerInformation.getEmail());
        enterUsername(speakerInformation.getUsername());
        enterPassword(speakerInformation.getPassword());
        enterConfirmPassword(speakerInformation.getConfirmPwd());

    }

    public void fillSpeakerProposalInfo(SpeakerInformation speakerInformation) throws Exception {
        enterPrefix(speakerInformation.getPrefix());
        selectProfilePic(speakerInformation.getProfilePicture());
        enterFirstName(speakerInformation.getFirstName());
        enterMiddleName(speakerInformation.getMiddleName());
        enterLastName(speakerInformation.getLastName());
        enterSuffix(speakerInformation.getSuffix());
        enterEmail(speakerInformation.getEmail());
        enterPhoneNumber(speakerInformation.getPhone());
        enterOrganization(speakerInformation.getOrganization());
        enterPosition(speakerInformation.getPosition());
        enterUsername(speakerInformation.getUsername());
        enterPassword(speakerInformation.getPassword());
        enterConfirmPassword(speakerInformation.getConfirmPwd());
        enterAddressLineOne(speakerInformation.getAddressLine1());
        enterAddressLineTwo(speakerInformation.getAddressLine2());
        enterCity(speakerInformation.getCity());
        enterPostalCode(speakerInformation.getPostalCode());
        enterState(speakerInformation.getState());
        enterCountry(speakerInformation.getCountry());
        enterFaceBookId(speakerInformation.getFacebook());
        enterGoogleId(speakerInformation.getGoogle());
        enterLinkedInId(speakerInformation.getLinkedIn());
        enterTwitterId(speakerInformation.getTwitter());
        enterBioValue(speakerInformation.getBio());

    }

    public void fillSubmitterMandatoryInfo(SubmitterInfo submitterInfo) throws Exception {
        Wait(SUBMITTER_EMAIL, 20);
        type(SUBMITTER_EMAIL, submitterInfo.getEmail(), true);
        logReport("Submitter Email entered value " + submitterInfo.getEmail());
        type(SUBMITTER_FIRSTNAME, submitterInfo.getFirstName(), true);
        logReport("Submitter First Name entered value " + submitterInfo.getFirstName());
        type(SUBMITTER_LASTNAME, submitterInfo.getLastName(), true);
        logReport("Submitter Last Name entered value " + submitterInfo.getLastName());

    }

    public void fillSessionMandatoryInfo(SessionProposalInfo sessionProposalInfo) throws Exception {
        enterSessionName(sessionProposalInfo.getSessionName());
        selectSessionType(sessionProposalInfo.getSessionType());

    }

    public void fillSubmitterInfo(SubmitterInfo submitterInfo) throws Exception {
        Wait(SUBMITTER_EMAIL, 20);
        type(SUBMITTER_EMAIL, submitterInfo.getEmail(), true);
        logReport("Submitter Email entered value " + submitterInfo.getEmail());
        type(SUBMITTER_FIRSTNAME, submitterInfo.getFirstName(), true);
        logReport("Submitter First Name entered value " + submitterInfo.getFirstName());
        type(SUBMITTER_LASTNAME, submitterInfo.getLastName(), true);
        logReport("Submitter Last Name entered value " + submitterInfo.getLastName());
        type(SUBMITTER_POSITION, submitterInfo.getPosition(), true);
        logReport("Submitter Position entered value " + submitterInfo.getPosition());

    }

    public void fillSessionProposal(SessionProposalInfo sessionProposalInfo) throws Exception {
        enterSessionName(sessionProposalInfo.getSessionName());
        selectSessionType(sessionProposalInfo.getSessionType());
        selectSessionTrack(sessionProposalInfo.getTrack());
        selectTagsDropdown(sessionProposalInfo.getTags());
        selectSessionLevel(sessionProposalInfo.getSessionLevel());
        selectAbstractFile(sessionProposalInfo.getAbstractFile());
        enterAbstractDescription(sessionProposalInfo.getAbstractDesc());
        enterSessionDescription(sessionProposalInfo.getSessionDesc());
        enterNotesValue(sessionProposalInfo.getNotes());
    }

    public void fillAdditionalSpeaker(SpeakerInformation speakerInformation, int row) throws Exception {
        clickByJavaScript(ADD_NEW_SPEAKER_BUTTON);
        logReport("Add Speaker button clicked successfully");
        Wait(ADLSPK_EMAIL_TEXTBOX, 20);
        type(ADLSPK_EMAIL_TEXTBOX, speakerInformation.getEmail(), true);
        ADLSPK_EMAIL_TEXTBOX.sendKeys(Keys.TAB);
        logReport("Addtional speaker Email entered value " + speakerInformation.getEmail());
        VerifyAngularHasFinishedProcessing(10);
        Thread.sleep(2000);
        type(ADLSPK_FIRST_NAME_TEXTBOX, speakerInformation.getFirstName(), true);
        logReport("Addtional speaker First Name entered value " + speakerInformation.getFirstName());
        type(ADLSPK_LAST_NAME_TEXTBOX, speakerInformation.getLastName(), true);
        logReport("Addtional speaker Last Name entered value " + speakerInformation.getLastName());
        type(ADLSPK_POSITION_TEXTBOX, speakerInformation.getPosition(), true);
        logReport("Addtional speaker Position entered value " + speakerInformation.getPosition());
        type(ADLSPK_ORGANIZATION_TEXTBOX, speakerInformation.getOrganization(), true);
        logReport("Addtional speaker Organization entered value " + speakerInformation.getOrganization());
        type(ADLSPK_PHONE_TEXTBOX, speakerInformation.getPhone(), true);
        logReport("Addtional speaker Phone entered value " + speakerInformation.getPhone());
        clickByJavaScript(ADD_SPEAKER_BUTTON);
        logReport("Speaker added successfully");
        VerifyAngularHasFinishedProcessing(10);
        VerifyAjaxRequestsFinished(20);
    }

    public void clickSpeakerCancelButton() throws Exception {
        clickByJavaScript(SPEAKER_CANCEL_BUTTON);
        logReport("Speaker cancel button clicked successfully");
        VerifyPageReady(30);
    }

    public boolean isEditDeleteIconPresentWithAddedSpeaker(SpeakerInformation speakerInformation) {
        String xpath = "//div[@ng-repeat='speaker in newSpeakers track by $index']//p[text()='" + speakerInformation.getEmail() + "']/..//preceding-sibling::span[@class='remove-icon']/..//span[@class='edit-icon']";
        return verifyElementDisplayed(By.xpath(xpath), 10);
    }

    public void enterAdditionalEmailTextbox(String emailValue) throws Exception {
        Wait(ADLSPK_EMAIL_TEXTBOX, 20);
        type(ADLSPK_EMAIL_TEXTBOX, emailValue, true);
        ADLSPK_EMAIL_TEXTBOX.sendKeys(Keys.TAB);
        logReport("Addtional speaker Email entered value " + emailValue);
        VerifyAngularHasFinishedProcessing(10);
        Thread.sleep(2000);

    }

    public boolean isPopulatedValues() {
        List<String> addspeaklist = new ArrayList<>();
        String firstName = ADLSPK_FIRST_NAME_TEXTBOX.getAttribute("value").trim();
        String lastName = ADLSPK_LAST_NAME_TEXTBOX.getAttribute("value").trim();
        String position = ADLSPK_POSITION_TEXTBOX.getAttribute("value").trim();
        String organization = ADLSPK_ORGANIZATION_TEXTBOX.getAttribute("value").trim();
        String phone = ADLSPK_PHONE_TEXTBOX.getAttribute("value").trim();

        return !firstName.isEmpty() && !lastName.isEmpty() && !position.isEmpty() && !organization.isEmpty() && !phone.isEmpty();
    }
}
