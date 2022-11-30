package pageObjects.Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pageObjects.EventRegistrations.AttendeeOverviewPage;

import javax.naming.ConfigurationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProfileAnonymizationPage extends CommonActionsPage {

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement SAVE_BUTTON;
    @FindBy(xpath = "//input[@id='anonymizSearch']")
    public WebElement PROFILE_ANONYMIZATION_SEARCH_BOX;
    @FindBy(xpath = "//input[@id='anonymizSearch']/..//span//i")
    public WebElement PROFILE_ANONYMIZATION_SEARCH_BUTTON;
    @FindBy(xpath = "//button[text()='Anonymize']")
    public WebElement ANONYMIZE_BUTTON;
    @FindBy(xpath = " //input[@id='auditReportSearch']")
    public WebElement ANONYMIZED_PROFILES_AUDIT_SEARCH_BOX;
    @FindBy(xpath = "//input[@id='auditReportSearch']/..//span//i")
    public WebElement ANONYMIZED_PROFILES_AUDIT_SEARCH_BUTTON;

    @FindBy(xpath = "//input[@id='standardField']")
    public WebElement ALL_STANDARD_FIELDS_CHECKBOX;
    @FindBy(xpath = "//input[@id='customField']")
    public WebElement ALL_CUSTOM_FIELDS_CHECKBOX;

    @FindBy(xpath = "//input[@id='anonymizeRegData']")
    public WebElement Profile_Inactive;
    @FindBy(xpath = "//input[@id='anonymizeRegQue']")
    public WebElement ANONYMIZE_REG_QUES_CHECKBOX;

    @FindBy(xpath = "//input[@id='anonymizeStr']")
    public WebElement ANONYMIZE_STRING_TEXTBOX;

    @FindBy(xpath = "//span[@x-ng-click='close()']")
    public WebElement ALERT_CLOSE_BUTTON;

    @FindBy(xpath = "//div[@header='Profile Anonymization']//div[text()='No record found.']")
    public WebElement PROFILE_ANONYMIZATION_NO_RECORD_TEXT;
    @FindBy(xpath = "//div[@header='Anonymized Profiles Audit Report']//div[text()='No record found.']")
    public WebElement PROFILE_ANONYMIZED_NO_RECORD_TEXT;

    @FindBy(xpath = "//tr[@ng-repeat='customQuestionsField in customQuestionsFields']//input")
    public List<WebElement> CUSTOM_QUESTIONS_FIELDS_LIST;

    @FindBy(xpath = "//div[@header='Anonymized Profiles Audit Report']//table//tr//th")
    public List<WebElement> AUDIT_REPORT_HEADER_LIST;

    //for sorting anonymized profiles
    //th[contains(.,'Registrations')]//a//img[@ng-src[contains(.,'sort_descending_off')]]
    //for anonymized profiles table header


    public ProfileAnonymizationPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void saveProfileFieldsButton() throws Exception {
        Wait(SAVE_BUTTON, 30);
        clickByJavaScript(SAVE_BUTTON);
        logReport("Save Profile Field button clicked successfully");
        VerifyAngularHasFinishedProcessing(30);
    }

    public void searchProfileByProfileEmail(String email) throws Exception {
        type(PROFILE_ANONYMIZATION_SEARCH_BOX, email, true);
        logReport("Entered email value " + email + " in the search box");
        Wait(PROFILE_ANONYMIZATION_SEARCH_BUTTON, 20);
        clickByJavaScript(PROFILE_ANONYMIZATION_SEARCH_BUTTON);
        logReport("Profile Anonymization search button clicked successfully");
        VerifyAngularHasFinishedProcessing(30);
        /*if(isAlertPresent()){
            getAlertMessageText();
        }*/
    }

    public void searchAnonymizedProfileByPkProfileId(String pkProfileId) throws Exception {
        type(ANONYMIZED_PROFILES_AUDIT_SEARCH_BOX, pkProfileId, true);
        logReport("Entered PkProfileId value " + pkProfileId + " in the search box");
        Wait(ANONYMIZED_PROFILES_AUDIT_SEARCH_BUTTON, 20);
        clickByJavaScript(ANONYMIZED_PROFILES_AUDIT_SEARCH_BUTTON);
        logReport("Anonymized Profile Audit search button clicked successfully");
        VerifyAngularHasFinishedProcessing(30);
    }

    public boolean isProfileFound(String email) throws Exception {
        boolean found = false;
        searchProfileByProfileEmail(email);
        String xpath = "//tr[@ng-repeat='profile in profileList']//td[text()='" + email + "']";
        if (verifyElementDisplayed(By.xpath(xpath), 5)) {
            found = true;
            logReport("Anonymization profile found successfully.");
        }
        return found;
    }

    public void selectProfileToAnonymize(String email) throws Exception {
        if (isProfileFound(email)) {
            String xpath = "//tr[@ng-repeat='profile in profileList']//td[text()='" + email + "']/..//td//input";
            WebElement element = browser.findElement(By.xpath(xpath));
            clickByJavaScript(element);
            clickOnAnonymizeButton();
            logReport("Profile Anonymization done successfully");
        }
    }

    public String getPkProfileId(String email) throws Exception {
        String pkProfileId = "";
        if (isProfileFound(email)) {
            String xpath = "//tr[@ng-repeat='profile in profileList']//td[text()='" + email + "']/..//td[2]";
            WebElement element = browser.findElement(By.xpath(xpath));
            pkProfileId = element.getText().trim();
            logReport("PkProfileId is : " + pkProfileId);
        }
        return pkProfileId;
    }

    public void clickOnAnonymizeButton() throws Exception {
        Wait(ANONYMIZE_BUTTON, 30);
        click(ANONYMIZE_BUTTON);
        logReport("Anonymize button clicked successfully");
        VerifyAngularHasFinishedProcessing(30);
    }

    public boolean isAnonymizedProfileFound(String pkProfileId) throws Exception {
        boolean found = false;
        searchAnonymizedProfileByPkProfileId(pkProfileId);
        String xpath = "//tr[@ng-repeat='auditLog in auditLogList']//td[text()='" + pkProfileId + "']";
        if (verifyElementDisplayed(By.xpath(xpath), 5)) {
            found = true;
            logReport("Anonymized profile found successfully.");
        }
        return found;
    }

    public String getRegistrations(String pkProfileId) throws Exception {
        String registrations = "";
        if (isAnonymizedProfileFound(pkProfileId)) {
            String xpath = "//tr[@ng-repeat='auditLog in auditLogList']//td[text()='" + pkProfileId + "']/..//td[4]";
            WebElement element = browser.findElement(By.xpath(xpath));
            registrations = element.getText().trim();
            logReport("Registrations are: " + registrations);
        }
        return registrations;
    }

    public void replaceAnonymizeString(String value) throws Exception {
        Wait(ANONYMIZE_STRING_TEXTBOX, 10);
        ANONYMIZE_STRING_TEXTBOX.clear();
        type(ANONYMIZE_STRING_TEXTBOX, value);
        logReport("Anonymize string replace value is : " + value);
    }

    public void selectCheckbox(String fieldName) throws Exception {
        String xpath = "//label[contains(.,'" + fieldName + "')]/..//input";
        WebElement element = browser.findElement(By.xpath(xpath));
        if (!isCheckboxSelected(fieldName)) {
            checkByJavascript(element);
            logReport(fieldName + " is selected.");
        } else {
            logReport(fieldName + " is already selected.");
        }
    }

    public void selectFieldsCheckbox(String fieldName) throws Exception {
        String xpath = "//strong[contains(.,'" + fieldName + "')]/../..//input";
        WebElement element = browser.findElement(By.xpath(xpath));
        if (!isFieldsCheckboxSelected(fieldName)) {
            checkByJavascript(element);
            VerifyPageReady(20);
            logReport(fieldName + " is selected.");
        } else {
            logReport(fieldName + " is already selected.");
        }
    }

    public void selectDefaultFields(String fieldName) throws Exception {
        String xpath = "//strong[contains(.,'" + fieldName + "')]/../..//input";
        WebElement element = browser.findElement(By.xpath(xpath));
        uncheckByJavascript(element);
        VerifyPageReady(20);
        logReport(fieldName + " is not selected.");

    }

    public void unCheckAllCustomFields(String fieldName) throws Exception {
        Thread.sleep(1000);
        if (CUSTOM_QUESTIONS_FIELDS_LIST.size() > 0) {
            for (int i = 0; i < CUSTOM_QUESTIONS_FIELDS_LIST.size(); i++) {
                uncheckByJavascript(CUSTOM_QUESTIONS_FIELDS_LIST.get(i));
                logReport(CUSTOM_QUESTIONS_FIELDS_LIST.get(i) + " is unchecked.");

            }
            logReport(fieldName + " is unchecked.");
        } else {
            logReport(fieldName + " is already unchecked.");
        }

    }

    public boolean isFieldsCheckboxSelected(String fieldName) throws Exception {
        boolean found = false;
        String xpath = "//strong[contains(.,'" + fieldName + "')]/../..//input";
        if (VerifyElementPresent(By.xpath(xpath), 10)) {
            WebElement element = browser.findElement(By.xpath(xpath));
            if (element.isSelected()) {
                found = true;
                logReport(fieldName + " is selected.");
            } else {
                found = false;
                logReport(fieldName + " is not selected.");
            }
        }
        return found;
    }

    public boolean isCheckboxSelected(String fieldName) throws Exception {
        boolean found = false;
        String xpath = "//label[contains(.,'" + fieldName + "')]/..//input";
        if (VerifyElementPresent(By.xpath(xpath), 10)) {
            WebElement element = browser.findElement(By.xpath(xpath));
            if (element.isSelected()) {
                found = true;
                logReport(fieldName + " is selected.");
            } else {
                found = false;
                logReport(fieldName + " is not selected.");
            }
        }
        return found;
    }

    public void makeProfileInactive(String fieldName) throws Exception {
        logReport("" + Profile_Inactive.isSelected());
        if (Profile_Inactive.isSelected()) {
            uncheckByJavascript(Profile_Inactive);
            logReport(fieldName + " is unchecked.");
        } else {
            logReport(fieldName + " is already unchecked.");
        }
    }

    public void unCheckAnonymizeRegQues(String fieldName) throws Exception {
        logReport("" + ANONYMIZE_REG_QUES_CHECKBOX.isSelected());
        if (ANONYMIZE_REG_QUES_CHECKBOX.isSelected()) {
            uncheckByJavascript(ANONYMIZE_REG_QUES_CHECKBOX);
            logReport(fieldName + " is unchecked.");
        } else {
            logReport(fieldName + " is already unchecked.");
        }
    }

    public String searchProfileByChar(String value) throws Exception {
        String title = "No record found.";
        type(PROFILE_ANONYMIZATION_SEARCH_BOX, value, true);
        logReport("Entered value " + value + " in the search box");
        clickByJavaScript(PROFILE_ANONYMIZATION_SEARCH_BUTTON);
        logReport("Profile Anonymization search button clicked successfully");
        VerifyAngularHasFinishedProcessing(10);
        String xpath = "//span[text()='Minimum 3 characters are required to start a search.']";
        if (VerifyElementPresent(By.xpath(xpath), 5)) {
            WebElement element = browser.findElement(By.xpath(xpath));
            title = element.getText().trim();
            logReport("title : " + title);
            ALERT_CLOSE_BUTTON.click();
        }
        return title;
    }

    public AttendeeOverviewPage clickProfileAnonymizationEditButton(String email, String pkProfileId) throws Exception {
        if (isProfileFound(email)) {
            String xpath = "//tr[@ng-repeat='profile in profileList']//td[text()='" + email + "']/..//td[text()='" + pkProfileId + "']/..//i";
            WebElement element = browser.findElement(By.xpath(xpath));
            clickByJavaScript(element);
            logReport("Profile Anonymization edit button clicked successfully");
        }
        return new AttendeeOverviewPage(browser);
    }

    public boolean isAuditReportHeaderDisplayed(String headerName) {
        scrollIntoView(ANONYMIZED_PROFILES_AUDIT_SEARCH_BUTTON);
        String xpath = "//div[@header='Anonymized Profiles Audit Report']//table//tr//th[contains(.,'" + headerName + "')]";
        return verifyElementDisplayed(By.xpath(xpath), 1);
    }

    public List<String> getValuesByHeaderName(String headerName) {
        int i = getColumnIndex(AUDIT_REPORT_HEADER_LIST, headerName);
        String xpath = "//div[@header='Anonymized Profiles Audit Report']//table//tr[@ng-repeat='auditLog in auditLogList']//td[" + i + "]";
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        List<String> values = new ArrayList<>();
        for (WebElement e : elements) {
            values.add(e.getText().trim());
        }
        return values;
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

    public void clickInAscendingOrDescendingForAuditReportFieldList(String column) {
        List<WebElement> reportHeader = AUDIT_REPORT_HEADER_LIST;
        for (int i = 0; i < reportHeader.size(); i++) {
            if (reportHeader.get(i).getText().trim().equals(column)) {
                WebElement element = reportHeader.get(i).findElement(By.xpath("./a"));
                clickByJavaScript(element);
            }
        }
    }

}
