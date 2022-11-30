package pageObjects;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pojo.PrivacyConfigurationData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by infoobjects on 6/28/2017.
 */
public class PrivacyComplianceSettingsPage extends CommonActionsPage {


    @FindBy(xpath = "//ul[not(contains(@style,'display: none'))]//table[@role='grid']//button[@class='btn btn-default btn-sm pull-left']")
    public WebElement DATE_PICKER_PREVIOUS_LINK;

    @FindBy(xpath = "//ul[not(contains(@style,'display: none'))]//table[@role='grid']//button[@class='btn btn-default btn-sm']")
    public WebElement DATE_PICKER_CENTER_LINK;

    @FindBy(xpath = "//ul[not(contains(@style,'display: none'))]//table[@role='grid']//button[@class='btn btn-default btn-sm pull-right']")
    public WebElement DATE_PICKER_NEXT_LINK;

    @FindBy(xpath = "//h3[text()='Russian Data Privacy']")
    public WebElement RUSSIAN_PRIVACY_DATA;

    @FindBy(id = "create-link")
    public WebElement ADD_NEW_BUTTON;

    @FindBy(xpath = "//select[@id='policy-type']")
    public WebElement POLICY_DROPDOWN;

    @FindBy(xpath = "//input[@id='config-name']")
    public WebElement CONFIG_NAME_TEXTBOX;

    @FindBy(xpath = "//input[@id='startDate']")
    public WebElement START_DATE_TEXTBOX;

    @FindBy(xpath = "//input[@id='endDate']")
    public WebElement END_DATE_TEXTBOX;

    @FindBy(xpath = "//select[@id='authType']")
    public WebElement SERVICE_AUTH_DROPDOWN;

    @FindBy(xpath = "//input[@id='serviceUri']")
    public WebElement SERVICE_URL_TEXTBOX;

    @FindBy(xpath = "//input[@id='clientId']")
    public WebElement CLINET_ID_TEXTBOX;

    @FindBy(xpath = "//input[@id='clientSecret']")
    public WebElement CLIENT_SECRET_TEXTBOX;

    @FindBy(xpath = "//input[@id='tokenUrl']")
    public WebElement TOKEN_URL_TEXTBOX;

    @FindBy(xpath = "//input[@id='resource']")
    public WebElement RESOURCE_TEXTBOX;

    @FindBy(xpath = "//textarea[@id='messageRequest']")
    public WebElement WAIT_MESSAGE_TEXTAREA;

    @FindBy(xpath = "//textarea[@id='messageError']")
    public WebElement SERVICE_ERROR_TEXTAREA;

    @FindBy(xpath = "//input[@id='externalIdKey']")
    public WebElement EXTERNAL_ID_TEXTBOX;

    @FindBy(xpath = "//select[@id='triggerField']")
    public WebElement TRIGGER_FIELD_DROPDOWN;

    @FindBy(xpath = "//ul[@class='select2-results']//li//div")
    public List<WebElement> TRIGGER_VALUE_LIST;

    @FindBy(xpath = "//select[@id='triggerValues']")
    public WebElement TRIGGER_VALUE_DROPDOWN;

    @FindBy(xpath = "//select[@ng-model='fieldMapping.certainField']")
    public WebElement CERTAIN_FIELD_DROPDOWN;

    @FindBy(xpath = "//input[@ng-model='fieldMapping.targetField']")
    public WebElement TARGET_VALUE_TEXTBOX;

    @FindBy(xpath = "//button[@x-ng-click='savePrivacyConfig()']")
    public WebElement SAVE_PRIVACY_CONFIGURATION_BUTTON;

    @FindBy(xpath = "//button[@x-ng-click='savePrivacyConfigTrigger();']")
    public WebElement SAVE_EVENT_TRIGGER_BUTTON;

    @FindBy(xpath = "//a[@ng-click='addMappingRow()']")
    public WebElement ADD_FIELD_MAPPING_BUTTON;

    @FindBy(xpath = "//button[@x-ng-click='savePrivacyConfigMapping();']")
    public WebElement SAVE_FIELD_MAPPING_BUTTON;

    public PrivacyComplianceSettingsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }


    public void clickOnRussianPrivacyData() throws Exception {
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(30);
        Wait(RUSSIAN_PRIVACY_DATA, 30);
        click(RUSSIAN_PRIVACY_DATA);
        logReport("Successfully clicked on 'Russian Data Privacy.");


    }

    public void clickOnAddNewButton() throws Exception {
        VerifyPageReady(30);
        Wait(ADD_NEW_BUTTON, 30);
        click(ADD_NEW_BUTTON);
        logReport("Successfully clicked on 'Add New' button.");
        VerifyAngularHasFinishedProcessing(30);
    }

    private void selectPolicyType(String type) throws Exception {
        Wait(POLICY_DROPDOWN, 30);
        select(POLICY_DROPDOWN, type);
        logReport("Successfully selected value: " + type + " in policy type dropdown.");
    }

    public void selectDateFromDatePicker(String date) throws Exception {
        //Date to be selected (Format dd_MM_YYYY)
        String dateTime = date;


        logReport("----Date time value " + dateTime);

        //Split the date to get only the date part

        String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");


        //get the year difference between current year and year to set in calender
        int Year = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);

        clickByJavaScript(DATE_PICKER_CENTER_LINK);


        if (Year != 0) {
            //if you have to move next year
            if (Year > 0) {
                for (int i = 0; i < Year; i++) {
                    clickByJavaScript(DATE_PICKER_NEXT_LINK);

                }
            }
            //if you have to move previous year
            else if (Year < 0) {
                for (int i = 0; i < (Year * (-1)); i++) {
                    clickByJavaScript(DATE_PICKER_PREVIOUS_LINK);

                }
            }
        }
        Thread.sleep(1000);

        List<WebElement> list_Months = browser.findElements(By.xpath("//ul[not(contains(@style,'display: none'))]//table[@role='grid']//tbody/tr/td[@class='text-center ng-scope']"));


        logReport("----------" + list_Months.get(Integer.parseInt(date_dd_MM_yyyy[1]) - 1));
        list_Months.get(Integer.parseInt(date_dd_MM_yyyy[1]) - 1).click();

        Thread.sleep(1000);

        List<WebElement> list_Days = browser.findElements(By.xpath("//ul[not(contains(@style,'display: none'))]//td[@ng-repeat='dt in row track by dt.date'][@aria-disabled='false']//button/span[@class='ng-binding'or@class='ng-binding text-info']"));
        for (WebElement e : list_Days) {
            if (Integer.parseInt(e.getText().trim()) == Integer.parseInt(date_dd_MM_yyyy[0])) {
                clickByJavaScript(e);

                break;
            }
        }


        Thread.sleep(1000);
        logReport("Selected Session Start Date : " + dateTime);
    }


    private void enterConfigName(String name) throws Exception {
        type(CONFIG_NAME_TEXTBOX, name, true);
        logReport("Successfully entered value: " + name + " in config name textbox.");
    }

    private void enterStartDate(String date) throws Exception {
        Wait(START_DATE_TEXTBOX, 30);
        clickByJavaScript(START_DATE_TEXTBOX);
        logReport("Successfully clicked start date Calender.");
        selectDateFromDatePicker(date);
    }

    private void enterEndDate(String date) throws Exception {
        Wait(END_DATE_TEXTBOX, 30);
        clickByJavaScript(END_DATE_TEXTBOX);
        logReport("Successfully clicked End date Calender.");
        selectDateFromDatePicker(date);
    }

    private void selectServiceAuth(String authType) throws Exception {
        select(SERVICE_AUTH_DROPDOWN, authType);
        logReport("Successfully selected value: " + authType + " in service auth dropdown.");
    }

    private void enterServiceURL(String url) throws Exception {
        type(SERVICE_URL_TEXTBOX, url, true);
        logReport("Successfully entered value: " + url + " in service url textbox.");
    }

    private void enterClientId(String id) throws Exception {
        type(CLINET_ID_TEXTBOX, id, true);
        logReport("Successfully entered value: " + id + " in client id textbox.");
    }

    private void enterClientSecret(String secretId) throws Exception {
        type(CLIENT_SECRET_TEXTBOX, secretId, true);
        logReport("Successfully entered value: " + secretId + " in client secret textbox.");
    }

    private void enterTokeURL(String url) throws Exception {
        VerifyPageReady(30);
        Wait(TOKEN_URL_TEXTBOX, 30);
        type(TOKEN_URL_TEXTBOX, url, true);
        logReport("Successfully entered value: " + url + " in token url textbox.");
    }

    private void enterResourceURL(String url) throws Exception {
        type(RESOURCE_TEXTBOX, url, true);
        logReport("Successfully entered value: " + url + " in resource url textbox.");
    }

    private void enterWaitMessage(String text) throws Exception {
        type(WAIT_MESSAGE_TEXTAREA, text, true);
        logReport("Successfully entered value: " + text + " in wait message textbox.");
    }

    private void enterServiceErrorMessage(String text) throws Exception {
        type(SERVICE_ERROR_TEXTAREA, text, true);
        logReport("Successfully entered value: " + text + " in service error message textbox.");
    }

    private void enterExternalIdKey(String key) throws Exception {
        type(EXTERNAL_ID_TEXTBOX, key, true);
        logReport("Successfully entered value: " + key + " in external id key textbox.");
    }

    private void clickOnSavePrivacyConfigurationButton() throws Exception {
        click(SAVE_PRIVACY_CONFIGURATION_BUTTON);
        logReport("Successfully clicked on 'Save Privacy' button.");
        VerifyAjaxRequestsFinished(30);
        VerifyAngularHasFinishedProcessing(10);

    }

    public String getDateByDaysPC(Integer noOfDays) throws Exception {
        String currentDate, convertedDate;
        Date dt = new Date();
        SimpleDateFormat DtFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-7"));
        DtFormat.setTimeZone(cal.getTimeZone());
        currentDate = DtFormat.format(dt);
        cal.setTime(DtFormat.parse(currentDate));
        cal.add(Calendar.DATE, noOfDays);
        convertedDate = DtFormat.format(cal.getTime());
        logReport("Current date by no of days " + convertedDate);
        return convertedDate;
    }

    public String getCurrentDatePC() {
        Date dt = new Date();
        SimpleDateFormat DtFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-8"));
        DtFormat.setTimeZone(cal.getTimeZone());
        String currentDate = DtFormat.format(dt);
        System.out.println(currentDate);
        return currentDate;
    }

    public void createPrivacyConfiguration(PrivacyConfigurationData privacyConfigurationData, int noOfDays) throws Exception {
        selectPolicyType(privacyConfigurationData.getPolicyType());
        enterConfigName(privacyConfigurationData.getConfigName());
        enterEndDate(getDateByDaysPC(noOfDays));
        enterStartDate(getCurrentDatePC());
        selectServiceAuth(privacyConfigurationData.getServiceAuthType());
        enterServiceURL(privacyConfigurationData.getServiceUrl());
        enterClientId(privacyConfigurationData.getClientId());
        enterClientSecret(privacyConfigurationData.getClientSecret());
        enterTokeURL(privacyConfigurationData.getTokenUrl());
        enterResourceURL(privacyConfigurationData.getResourceUrl());
        enterWaitMessage(privacyConfigurationData.getWaitMessage());
        enterServiceErrorMessage(privacyConfigurationData.getServiceErrorMessage());
        enterExternalIdKey(privacyConfigurationData.getExternalIdKey());
        clickOnSavePrivacyConfigurationButton();
    }

    public void selectTriggerFieldValue(String triggerField) throws Exception {
        Wait(TRIGGER_FIELD_DROPDOWN, 30);
        select(TRIGGER_FIELD_DROPDOWN, triggerField);
        logReport("Selected trigger field value " + triggerField);
    }

    public void selectTriggerValue(String triggerValue) {
        select(TRIGGER_VALUE_DROPDOWN, triggerValue);
        logReport("Selected trigger value" + triggerValue);
        /*for(WebElement e:TRIGGER_VALUE_LIST){
            if(e.getText().trim().equalsIgnoreCase(triggerValue))
            {
                e.click();
                logReport("Selected trigger value" + triggerValue);
                return;
            }
        }*/
    }

    public void clickTriggerSaveButton() throws Exception {
        SAVE_EVENT_TRIGGER_BUTTON.click();
        logReport("Save event trigger button clicked");
        VerifyPageReady(30);
        VerifyAjaxRequestsFinished(30);
        VerifyAngularHasFinishedProcessing(20);
    }

    public void selectMappingFields(PrivacyConfigurationData privacyConfigurationData) {

        String[] certainFields = privacyConfigurationData.getCertainField().split(",");
        String[] targetFields = privacyConfigurationData.getTargetField().split(",");

        for (int i = 0; i < certainFields.length; i++) {
            if (i > 0) {
                clickByJavaScript(ADD_FIELD_MAPPING_BUTTON);
            }
            String targetFieldXpath = "//div[@class='fieldMappingRow ng-scope'][" + (i + 1) + "]//input[@ng-model='fieldMapping.targetField']";
            String certainFieldXpath = "//div[@class='fieldMappingRow ng-scope'][" + (i + 1) + "]//select[@ng-model='fieldMapping.certainField']";
            WebElement targetElement = browser.findElement(By.xpath(targetFieldXpath));
            WebElement certainElement = browser.findElement(By.xpath(certainFieldXpath));
            select(certainElement, certainFields[i]);
            logReport("Selected certain field value " + certainFields[i]);
            type(targetElement, targetFields[i]);
            logReport("Typed target value " + targetFields[i]);
        }
    }

    public void clickMappingSaveButton() throws Exception {
        SAVE_FIELD_MAPPING_BUTTON.click();
        logReport("Save field mapping button clicked");
        VerifyAngularHasFinishedProcessing(30);


    }
}
