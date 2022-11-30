package pageObjects.FormPost;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pageObjects.EloquaHomePage;
import pojo.AddFormPostData;

import javax.naming.ConfigurationException;
import java.util.ArrayList;
import java.util.List;

public class FormPostPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@value='Add New']")
    public WebElement ADD_NEW_BUTTON;
    @FindBy(xpath = "//ul[@class='pagination ng-isolate-scope ng-pristine ng-valid']")
    public WebElement PAGINATION_TAB;
    @FindBy(xpath = "//input[@placeholder='Form Post Name']")
    public WebElement FORM_POST_NAME_TEXTBOX;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement SAVE_BUTTON;

    @FindBy(xpath = "//input[@ng-model='url']")
    public WebElement FORM_POST_URL_TEXTBOX;
    @FindBy(xpath = "//select[@ng-model='method']")
    public WebElement FORM_POST_METHOD_DROPDOWN;
    @FindBy(xpath = "//button[@ng-click='addMappingRow()']")
    public WebElement ADD_NEW_MAPPING_BUTTON;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Form Post']")
    public WebElement FORM_POST_TAB;

    @FindBy(xpath = "//tr[@ng-repeat='l in posts | orderBy:sortOrder:!reverse']")
    public List<WebElement> FORM_POST_LIST;

    @FindBy(xpath = "//label[text()='Enable']/..//input")
    public WebElement ENABLE_CHECKBOX;

    @FindBy(xpath = "//h4[@class='ng-binding']")
    public WebElement NAME_HEADER_TEXT;

    @FindBy(xpath = "//div[@ng-repeat='registrationStatus in registrationStatuses']//label//input")
    public List<WebElement> REG_STATUS_CHECKBOXES;

    @FindBy(xpath = "//div[@ng-repeat='registrationProperty in registrationProperties track by $index']//label//input")
    public List<WebElement> REG_PROPERTIES_CHECKBOXES;

    @FindBy(xpath = "//div[@ng-repeat='regSessionStatus in registrationSessionStatuses track by $index']//label//input")
    public List<WebElement> REGSESSION_STATUS_CHECKBOXES;

    public static final String[] SOURCE_FIELD_LIST = {"--Select Source--", "Event", "Profile", "Registration", "Session", "Static Value"};
    public static final String[] EVENT_VALUE_LIST = {"--Select Field Mapping--", "Event Name", "Event Code", "Event Start Date"};
    public static final String[] PROFILE_VALUE_LIST = {"--Select Field Mapping--", "Profile First Name", "Profile Last Name", "Profile Badge Name", "Profile Position", "Profile Mobile Phone", "Profile Phone Number", "Profile Email", "Profile Organization", "Profile Prefix", "Profile Suffix", "Profile Profile PIN", "Profile Unique Id", "Profile Weblink", "Profile Address Line 1", "Profile Address Line 2", "Profile Address City", "Profile Address State", "Profile Address Country", "Profile Address PostalCode", "Profile Facebook", "Profile Google+", "Profile LinkedIn", "Profile Twitter"};
    public static final String[] REGISTRATION_VALUE_LIST = {"--Select Field Mapping--", "Registration Code", "Registration Attendee Type", "Registration PKRegId", "Registration User Notes", "Registration Date Completed", "Registration Date Created", "Registration Date Modified", "Registration Date Cancelled", "Agenda Sessions", "Conference Sessions"};
    public static final String[] SESSION_VALUE_LIST = {"--Select Field Mapping--", "Session Instance Code", "Session Code", "Session Name", "Session Track", "Session Level", "Session Type"};
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement CANCEL_BUTTON;

    public FormPostPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void checkRegistrationStatusCheckboxes(String regStatusNames) {
        String[] a = regStatusNames.split(",");
        for (String s : a) {
            String xpath = "//div[@ng-repeat='registrationStatus in registrationStatuses']//label[contains(.,'" + s + "')]//input";
            WebElement element = browser.findElement(By.xpath(xpath));
            checkByJavascript(element);
            logReport("Selected registration standard and custom status checkbox " + s);
        }
    }

    public void checkRegistrationPropertiesCheckboxes(String property) {
        String[] a = property.split(",");
        for (String s : a) {
            String xpath = "//div[@ng-repeat='registrationProperty in registrationProperties track by $index']//label[contains(.,'" + s + "')]//input";
            WebElement element = browser.findElement(By.xpath(xpath));
            checkByJavascript(element);
            logReport("Selected registration standard and custom status checkbox " + s);
        }
    }

    public void checkRegistrationSessionStatusCheckboxes(String statuses) {
        String[] a = statuses.split(",");
        for (String s : a) {
            String xpath = "//div[@ng-repeat='regSessionStatus in registrationSessionStatuses track by $index']//label[contains(.,'" + s + "')]//input";
            WebElement element = browser.findElement(By.xpath(xpath));
            checkByJavascript(element);
            logReport("Selected registration standard and custom status checkbox " + s);
        }
    }

    public void createMappings(AddFormPostData addFormPostData) {
        String[] sourceNames = addFormPostData.getSourceName().split(",");
        String[] sourceValues = addFormPostData.getValue().split(",");
        String[] sourceFieldNames = addFormPostData.getFormFieldName().split(",");

        for (int i = 0; i < sourceNames.length; i++) {

            if (i >= 1) {
            if (verifyElementDisplayed(ADD_NEW_MAPPING_BUTTON, 10)) {
                clickByJavaScript(ADD_NEW_MAPPING_BUTTON);
                logReport("Add new mapping button clicked successfully");
            }
            }

            WebElement sourceElement = browser.findElement(By.xpath("//div[@ng-repeat='row in rows'][" + (i + 1) + "]//select[@ng-model='row.type']"));
            select(sourceElement, sourceNames[i]);
            logReport("Selected source element value " + sourceNames[i]);
            if (sourceNames[i].equalsIgnoreCase("Static Value")) {
                WebElement valueElement = browser.findElement(By.xpath("//div[@ng-repeat='row in rows'][" + (i + 1) + "]//input[@ng-model='row.mappingStatic']"));
                type(valueElement, sourceValues[i], true);
            } else {
                WebElement valueElement = browser.findElement(By.xpath("//div[@ng-repeat='row in rows'][" + (i + 1) + "]//select[@ng-model='row.mappingNonStatic']"));
                select(valueElement, sourceValues[i]);
            }
            logReport("Selected value element " + sourceValues[i]);
            WebElement formFieldElement = browser.findElement(By.xpath("//div[@ng-repeat='row in rows'][" + (i + 1) + "]//input[@ng-model='row.formFieldValue']"));
            type(formFieldElement, sourceFieldNames[i], true);
            logReport("Entered form field element value " + sourceFieldNames[i]);
        }

    }

    public void clickAddNewFormPost() throws Exception {
        Wait(ADD_NEW_BUTTON, 30);
        click(ADD_NEW_BUTTON);
        VerifyAngularHasFinishedProcessing(30);
        logReport("Successfully clicked on 'Add New Form Post' button.");
    }

    public void clickAddNewFormSaveButton() throws Exception {
        Wait(SAVE_BUTTON, 30);
        click(SAVE_BUTTON);
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(30);
        logReport("Successfully clicked on 'Save' button.");
    }

    public void clickSaveButton() throws Exception {
        Wait(SAVE_BUTTON, 30);
        click(SAVE_BUTTON);
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(30);
        logReport("Successfully clicked on 'Add New Form Post' button.");
    }

    public void enterFormPostName(String name) throws Exception {

        type(FORM_POST_NAME_TEXTBOX, name, true);
        logReport("Entered Form Post Name value " + name);
    }

    public void enterFormPostUrl(String url) throws Exception {

        type(FORM_POST_URL_TEXTBOX, url, true);
        logReport("Entered Form Post URL value " + url);
    }

    public void selectPostActionMethod(String method) throws Exception {

        select(FORM_POST_METHOD_DROPDOWN, method);
        logReport("Selected post action method value " + method);
    }

    public void fillAddNewFormPostDetails(AddFormPostData addFormPostData) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(30);
        enterFormPostName(addFormPostData.getFormPostName());
        clickAddNewFormSaveButton();
        checkRegistrationStatusCheckboxes(addFormPostData.getRegStatuses());
        checkRegistrationPropertiesCheckboxes(addFormPostData.getRegProperties());
        checkRegistrationSessionStatusCheckboxes(addFormPostData.getRegSessionStatus());
        enterFormPostUrl(addFormPostData.getUrl());
        selectPostActionMethod(addFormPostData.getMethod());
        createMappings(addFormPostData);

    }

    public void fillFormPostDetails(AddFormPostData addFormPostData, String regStatus) throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(30);
        enterFormPostName(addFormPostData.getFormPostName());
        clickAddNewFormSaveButton();
        checkRegistrationStatusCheckboxes(regStatus);
        enterFormPostUrl(addFormPostData.getUrl());
        selectPostActionMethod(addFormPostData.getMethod());
        createMappings(addFormPostData);


    }

    public boolean isFormPostFoundInFormPostList(String formPostName) throws Exception {
        String xpath = "//tr[@ng-repeat='l in posts | orderBy:sortOrder:!reverse']//td[1][text()='" + formPostName + "']";
        WebElement element = browser.findElement(By.xpath(xpath));
        return verifyElementDisplayed(element, 0);
    }

    public void deleteFormPostByFormPostName(String formPostName) {
        String xpath = "//td[1][text()='" + formPostName + "']//following-sibling::td//img[@title='Delete']";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        logReport("Form post delete icon clicked successfully");
        acceptAlert();

    }

    public FormPostPage editFormPost(String formPostName) throws Exception {
        String xpath = "//td[1][text()='" + formPostName + "']//following-sibling::td//img[@title='Edit']";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        VerifyAngularHasFinishedProcessing(30);
        logReport("Form Post Edit icon clicked successfully by name " + formPostName);
        return new FormPostPage(browser);

    }

    public boolean isFormPostListPresent() throws Exception {
        boolean found = false;
        if (FORM_POST_LIST.size() == 0) {
            found = false;
        }
        if (FORM_POST_LIST.size() > 0) {
            found = true;
        }
        return found;
    }

    public List<String> getFieldMappingList(String labelName) {
        String xpath = "//label[contains(text(),'" + labelName + "')]/..//following-sibling::div[@class='form-group']//select//option";
        List<WebElement> fieldsList = browser.findElements(By.xpath(xpath));
        List<String> fieldsArray = new ArrayList<>();
        for (WebElement e : fieldsList) {
            fieldsArray.add(e.getText().trim());
        }
        logReport("List of field " + labelName + " mapping : " + fieldsArray);
        return fieldsArray;
    }

    public AddFormPostData getFormPostFields() throws Exception {
        AddFormPostData addFormPostData;
        String formPostName = NAME_HEADER_TEXT.getText().trim().split("\\(")[0].trim();
        String url = FORM_POST_URL_TEXTBOX.getAttribute("value").trim();
        String method = getSelectedOption(FORM_POST_METHOD_DROPDOWN);
        StringBuilder regStatuses = new StringBuilder();
        for (WebElement e : REG_STATUS_CHECKBOXES) {
            if (e.isSelected()) {
                WebElement element = e.findElement(By.xpath("./.."));
                regStatuses.append(element.getText().trim());
                regStatuses.append(",");
            }
        }
        regStatuses.setLength(regStatuses.length() - 1);
        StringBuilder regProperties = new StringBuilder();
        for (WebElement e : REG_PROPERTIES_CHECKBOXES) {
            if (e.isSelected()) {
                WebElement element = e.findElement(By.xpath("./.."));
                regProperties.append(element.getText().trim());
                regProperties.append(",");
            }
        }
        regProperties.setLength(regProperties.length() - 1);
        StringBuilder regSessionStatuses = new StringBuilder();
        for (WebElement e : REGSESSION_STATUS_CHECKBOXES) {
            if (e.isSelected()) {
                WebElement element = e.findElement(By.xpath("./.."));
                regSessionStatuses.append(element.getText().trim());
                regSessionStatuses.append(",");
            }
        }
        regSessionStatuses.setLength(regSessionStatuses.length() - 1);
        StringBuilder source = new StringBuilder();
        StringBuilder formField = new StringBuilder();
        StringBuilder value = new StringBuilder();
        List<WebElement> rowsMapping = browser.findElements(By.xpath("//div[@ng-repeat='row in rows']"));
        for (int i = 0; i < rowsMapping.size(); i++) {
            WebElement sourceElement = browser.findElement(By.xpath("//div[@ng-repeat='row in rows'][" + (i + 1) + "]//select[@ng-model='row.type']"));
            source.append(getSelectedOption(sourceElement));
            source.append(",");
            if (VerifyElementPresent(By.xpath("//div[@ng-repeat='row in rows'][" + (i + 1) + "]//select[@ng-model='row.mappingNonStatic']"), 0)) {
                WebElement valueElement = browser.findElement(By.xpath("//div[@ng-repeat='row in rows'][" + (i + 1) + "]//select[@ng-model='row.mappingNonStatic']"));
                value.append(getSelectedOption(valueElement));
                value.append(",");
            } else if (VerifyElementPresent(By.xpath("//div[@ng-repeat='row in rows'][" + (i + 1) + "]//input[@ng-model='row.mappingStatic']"), 0)) {
                WebElement valueElement = browser.findElement(By.xpath("//div[@ng-repeat='row in rows'][" + (i + 1) + "]//input[@ng-model='row.mappingStatic']"));
                value.append(valueElement.getAttribute("value").trim());
                value.append(",");
            }
            WebElement formFieldElement = browser.findElement(By.xpath("//div[@ng-repeat='row in rows'][" + (i + 1) + "]//input[@ng-model='row.formFieldValue']"));
            formField.append(formFieldElement.getAttribute("value").trim());
            formField.append(",");
        }
        source.setLength(source.length() - 1);
        formField.setLength(formField.length() - 1);
        value.setLength(value.length() - 1);
        addFormPostData = new AddFormPostData(formPostName, regStatuses.toString(), regProperties.toString(), regSessionStatuses.toString(), url, method, source.toString(), value.toString(), formField.toString());
        return addFormPostData;
    }


    public void selectMappingSource(String sourceName) throws Exception {
        WebElement sourceElement = browser.findElement(By.xpath("//select[@ng-model='row.type']"));
        Wait(sourceElement, 10);
        select(sourceElement, sourceName);
        Wait(sourceElement, 20);
        logReport("Selected source element value " + sourceName + "---");

    }

    public void clickCancelButton() throws Exception {
        Wait(CANCEL_BUTTON, 30);
        clickByJavaScript(CANCEL_BUTTON);
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(30);
        logReport("Successfully clicked on 'Cancel' button.");

    }


    public EloquaHomePage fillEloquaLoginDetails(String companyName, String username, String password) throws Exception {
        type(browser.findElement(By.xpath("//input[@id='sitename']")), companyName, true);
        type(browser.findElement(By.xpath("//input[@id='username']")), username, true);
        type(browser.findElement(By.xpath("//input[@id='password']")), password, true);
        click(browser.findElement(By.xpath("//button[@id='submitButton']")));
        VerifyPageReady(30);
        Thread.sleep(3000);
        logReport("Eloqua login successfully");
        return new EloquaHomePage(browser);
    }

    public FormPostHistoryPage clickFormPostHistory(String formPostName) throws Exception {
        String xpath = "//td[1][text()='" + formPostName + "']//following-sibling::td//i[@title='Form Post History']";
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        VerifyAngularHasFinishedProcessing(30);
        logReport("Form Post History icon clicked successfully by name " + formPostName);
        return new FormPostHistoryPage(browser);

    }

}


