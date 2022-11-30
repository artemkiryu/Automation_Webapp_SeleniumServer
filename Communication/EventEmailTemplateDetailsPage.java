package pageObjects.Communication;


import org.apache.commons.configuration.ConfigurationException;
import org.bouncycastle.asn1.x509.Time;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.EmailTemplates;
import pojo.EventEmailTemplate;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by infoobjects on 5/3/2017.
 */
public class EventEmailTemplateDetailsPage extends CommonActionsPage {

    public static final String SELECT_FUTURE_TIME_ERROR_MESSAGE = "The email schedule date must be a date in the near future.";
    @FindBy(xpath = "//input[@name='txtSpecificationName']")
    public WebElement Email_Template_Name_Text_Box;
    @FindBy(xpath = "//input[contains(@id,'specAccess1')]")
    public WebElement This_Event_Only_Radio_button;
    @FindBy(xpath = "//input[contains(@id,'specAccess2')]")
    public WebElement All_Event_In_Account;
    @FindBy(xpath = "//input[@type='Checkbox']")
    public WebElement Current_User_Only_Check_Box;
    @FindBy(xpath = "//input[@name='messageFrom']")
    public WebElement Message_From_Text_Box;
    @FindBy(xpath = "//input[@name='messageReplyTo']")
    public WebElement Message_Reply_To_Text_Box;
    @FindBy(xpath = "//select[@id='selectRegData']")
    public WebElement Append_Drop_Box;
    @FindBy(xpath = "//input[@id='s2id_autogen1_search']")
    public WebElement Append_Search_Text_Box;
    @FindBy(xpath = "//input[@id='appendToSubject']")
    public WebElement Subject_Button;
    @FindBy(xpath = "//input[@id='appendToMessage']")
    public WebElement Message_Button;
    @FindBy(xpath = "//input[@name='subject']")
    public WebElement Subject_Text_Box;
    @FindBy(xpath = "//iframe[@class='cke_wysiwyg_frame cke_reset']")
    public WebElement Iframe_text_Editor;
    @FindBy(xpath = "//input[@name='toggleEditor-body']")
    public WebElement Enable_Editor_Check_Box;
    @FindBy(xpath = "//input[@name='sendAsHtml']")
    public WebElement Send_As_HTML_Check_Box;
    @FindBy(xpath = "//input[@name='includeDisplayShell']")
    public WebElement Include_Event_Display_Shell_Check_Box;
    @FindBy(xpath = "//input[@name='includeConfirmation']")
    public WebElement Include_Registration_Confirmation_Check_Box;
    @FindBy(xpath = "//input[@name='forgotPasswordTemplate']")
    public WebElement Use_As_The_Template_For_Forgot_Password_Check_Box;
    @FindBy(xpath = "//input[@name='includeItinerary']")
    public WebElement Attach_Iteinerary_PDF_Check_Box;
    @FindBy(xpath = "//a[@title='Click to upload a new file']")
    public WebElement Upload_File_Link;
    @FindBy(xpath = "//input[@name='fileToUpload']")
    public WebElement Browse_File_Button;
    @FindBy(xpath = "//select[@id='emailAttachment']")
    public WebElement Attachment_Drop_Down;
    @FindBy(xpath = "//input[@value='Skip']")
    public WebElement Don_Not_Upload_Radio_Buttom;
    @FindBy(xpath = "//input[@value='Overwrite']")
    public WebElement Overwrite_Existing_File_Radio_Buttom;
    @FindBy(xpath = "//input[@value='MakeUnique']")
    public WebElement Upload_And_Rename_Existing_File_Radio_Buttom;
    @FindBy(xpath = "//input[@name='uploadFile']")
    public WebElement Upload_Image_File_Button;
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement Save_Button;
    @FindBy(xpath = "//input[@value='Cancel']")
    public WebElement Cancel_Button;
    @FindBy(xpath = "//input[@name='isScheduled']")
    public WebElement Schedule_Email_Check_Box;
    @FindBy(xpath = "//input[@name='txtSpecificationCode']")
    public WebElement Schedule_Code_Text_Box;
    @FindBy(xpath = "//select[@id='scheduleDate']")
    public WebElement Schedule_Drop_Down;
    @FindBy(xpath = "//input[@id='custom_date']")
    public WebElement Date_Text_Box;
    @FindBy(xpath = "//input[@id='custom_time']")
    public WebElement Time_Text_Box;
    @FindBy(xpath = "//select[@id='adv_column1']")
    public WebElement Filter_Column_Drop_Down;
    @FindBy(xpath = "//select[@id='adv_operator1']")
    public WebElement Filter_Operator_Drop_Down;
    @FindBy(xpath = "//div[@class='ui-pnotify-closer']")
    public WebElement ERROR_MESSAGE_CLOSE;
    public static final By SCHEDULED_DATE_TIME = By.xpath("//td[@id='customDatePreview']");
    @FindBy(xpath = "//input[@id='adv_value1']")
    public WebElement FILTER_VALUE_TEXTBOX;

    public EventEmailTemplateDetailsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void testEventTemplateFill(EventEmailTemplate emailTemplate) throws Exception {
        Wait(Save_Button, 30);
        uploadEmailTemplateAttachment(emailTemplate.getFileName());
        VerifyAjaxRequestsFinished(30);
        entertemplateName(emailTemplate.getTemplateName());
        selectVisibleRadioButton(emailTemplate.getVisibleToRadioButtonValue());
        enterFromEmail(emailTemplate.getFromEmail());
        enterReplyToEmail(emailTemplate.getReplyToEmail());
        selectAppendValue(emailTemplate.getAppendDropDownValue());
        clickSubjectButton();
        clickMessageButton();
        enterSubject(emailTemplate.getMessageSubject());
        enterMessage(emailTemplate.getMessageBody());
        checkUnCheckEnableEditorCheckBox(emailTemplate.getEnableEditorCheckbox());
        checkUnCheckSendAsHtmlCheckBox(emailTemplate.getSendAsHTMLCheckbox());
        checkUnCheckIncludeEventDisplayShellCheckBox(emailTemplate.getIncludeEventDisplayCheckbox());
        checkUnCheckIncludeRegistrationConfirmationCheckBox(emailTemplate.getIncludeRegistrationCheckbox());
        checkUnCheckUseTemplateForForgetPasswordCheckBox(emailTemplate.getUseAsForgotPasswordCheckbox());
        checkUnCheckAttacheItineraryPDFCheckBox(emailTemplate.getAttachItineraryPDFCheckbox());
        checkUncheckScheduleEmailCheckBox(emailTemplate.getScheduleeEmailCheckBox());
        enterCode(emailTemplate.getTemplateName());
        scheduleEmailUsingDateAndTime();
        saveDataWithFutureTime(0);

    }

    public void saveDataWithFutureTime(int count) throws Exception {
        click(Save_Button);
        VerifyPageReady(10);
        String messageText = getMessageText();
        logReport("Message text = " + messageText);
        if (messageText.contains(SELECT_FUTURE_TIME_ERROR_MESSAGE) && count < 10) {
            logReport("Need to Set future Time");
            count++;
            click(ERROR_MESSAGE_CLOSE);
            selectFutureTime(count);
        }
    }

    public void selectFutureTime(EmailTemplates emailTemplates, int count) throws Exception {
        reporter.info("Inside Future Time");
        checkUncheckScheduleEmailCheckBox("true");
        enterCode(emailTemplates.getCode());
        select(Schedule_Drop_Down, emailTemplates.getScheduled());

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-7"));
        dateFormat.setTimeZone(cal.getTimeZone());
        timeFormat.setTimeZone(cal.getTimeZone());

        dateFormat.format(cal.getTime());
        timeFormat.format(cal.getTime());
        cal.add(Calendar.MINUTE, count);

        type(Date_Text_Box, dateFormat.format(cal.getTime()), true);
        type(Time_Text_Box, timeFormat.format(cal.getTime()), true);
        saveDataWithFutureTime(emailTemplates, count);
    }

    public void selectFutureTime(int count) throws Exception {
        logReport("Inside Future Time");

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-7"));
        dateFormat.setTimeZone(cal.getTimeZone());
        timeFormat.setTimeZone(cal.getTimeZone());

        dateFormat.format(cal.getTime());
        timeFormat.format(cal.getTime());
        cal.add(Calendar.MINUTE, count);

        type(Date_Text_Box, dateFormat.format(cal.getTime()));
        type(Time_Text_Box, timeFormat.format(cal.getTime()));
        saveDataWithFutureTime(count);
    }

    private void entertemplateName(String name) throws Exception {

        VerifyPageReady(30);
        Wait(Email_Template_Name_Text_Box, 30);
        type(Email_Template_Name_Text_Box, name);
        logReport("Entered Email Temaplate Name" + name + "Successfully");

    }

    private void selectVisibleRadioButton(String radioButton) throws Exception {


        String xpath = "//label[contains(.,'" + radioButton + "')]";
        click(This_Event_Only_Radio_button);
        logReport("Select This event Radio Button is selected Successfully");
    }


    private void checkUncheckCurrentUserOnlyCheckBox(String state) throws Exception {

        if (Boolean.valueOf(state)) {
            check(Current_User_Only_Check_Box);
            logReport("Select Current user checkBox is Checked Successfully");
        } else {
            unCheck(Current_User_Only_Check_Box);
            logReport("Select Current user checkBox is UnChecked Successfully");
        }
    }

    private void checkUncheckScheduleEmailCheckBox(String state) throws Exception {

        VerifyPageReady(30);

        System.out.println("Value of Email Schedule Check Box ------------->>> " + state);

        if (Boolean.valueOf(state)) {
            checkByJavascript(Schedule_Email_Check_Box);
            logReport("Schedule Email checkBox is Checked Successfully");
        } else {
            unCheck(Schedule_Email_Check_Box);
            logReport("Schedule Email checkBox is UnChecked Successfully");
        }
    }

    private void enterCode(String code) throws Exception {
        type(Schedule_Code_Text_Box, code);
        logReport("Schedule Email Code" + code + " is Entered Successfully");


    }

    private void scheduleEmailUsingDateAndTime() throws Exception {

        select(Schedule_Drop_Down, "At a specified time and date");
        //Wait(Date_Text_Box,10);
        //type(Date_Text_Box, getCurrentDate());
        //type(Time_Text_Box,getcurrentTime(),true);
    }


    private void enterFromEmail(String fromEmail) throws Exception {


        clearTextBoxValue(Message_From_Text_Box);
        type(Message_From_Text_Box, fromEmail);
        logReport("From Email " + fromEmail + "is entered Successfully");
    }

    private void enterReplyToEmail(String replyTomEmail) throws Exception {

        clearTextBoxValue(Message_Reply_To_Text_Box);
        type(Message_Reply_To_Text_Box, replyTomEmail);
        logReport("Reply To Email " + replyTomEmail + "is entered Successfully");
    }

    public void selectAppendValue(String dropdownValue) throws Exception {
        scrollIntoView(Append_Drop_Box);
        select(Append_Drop_Box, dropdownValue);
        logReport("Apeend Vvalue Selected Successfully");

    }

    private void clickSubjectButton() throws Exception {

        clickByJavaScript(Subject_Button);
        logReport("Subject button is clicked Successfully");
    }

    private void clickMessageButton() throws Exception {

        clickByJavaScript(Message_Button);
        logReport("Message button is clicked Successfully");
    }


    public void switchToIframeMessage() throws Exception {

        browser.switchTo().frame(Iframe_text_Editor);
        logReport("Switched to iframe Successfully");

    }

    private void enterSubject(String subject) throws Exception {

        type(Subject_Text_Box, subject);
        logReport("Email Template Subject " + subject + "is entered Successfully");
    }

    private void checkUnCheckEnableEditorCheckBox(String state) throws Exception {

        if (Boolean.valueOf(state)) {
            check(Enable_Editor_Check_Box);
            logReport("Enable Editor check box is checked Successfully");
        } else {
            unCheck(Enable_Editor_Check_Box);
            logReport("Enable Editor check box is unChecked Successfully");
        }

    }


    private void checkUnCheckSendAsHtmlCheckBox(String state) throws Exception {

        if (Boolean.valueOf(state)) {
            check(Send_As_HTML_Check_Box);
            logReport("Send As HTML check box is checked Successfully");
        } else {
            unCheck(Send_As_HTML_Check_Box);
            logReport("Send As HTML check box is unChecked Successfully");
        }

    }


    private void checkUnCheckIncludeEventDisplayShellCheckBox(String state) throws Exception {

        if (Boolean.valueOf(state)) {
            checkByJavascript(Include_Event_Display_Shell_Check_Box);
            logReport("Include Event Display Shell check box is checked Successfully");
        } else {
            unCheck(Include_Event_Display_Shell_Check_Box);
            logReport("Include Event Display Shell check box is unChecked Successfully");

        }

    }

    private void checkUnCheckIncludeRegistrationConfirmationCheckBox(String state) throws Exception {

        if (Boolean.valueOf(state)) {
            checkByJavascript(Include_Registration_Confirmation_Check_Box);
            logReport("Include Registration Confirmation check box is checked Successfully");
        } else {
            unCheck(Include_Registration_Confirmation_Check_Box);
            logReport("Include Registration Confirmation check box is unChecked Successfully");
        }

    }


    private void checkUnCheckUseTemplateForForgetPasswordCheckBox(String state) throws Exception {

        if (Boolean.valueOf(state)) {
            checkByJavascript(Use_As_The_Template_For_Forgot_Password_Check_Box);
            Alert alert = browser.switchTo().alert();
            alert.accept();
            logReport("Use As The TemplatUse_As_The_Template_For_Forgot_Password_Check_Boxe For Forgot password check box is checked Successfully");

        } else {
            unCheck(Use_As_The_Template_For_Forgot_Password_Check_Box);
            logReport("Use As The Template For Forgot password check box is unChecked Successfully");
        }


    }


    private void checkUnCheckAttacheItineraryPDFCheckBox(String state) throws Exception {

        if (Boolean.valueOf(state)) {
            checkByJavascript(Attach_Iteinerary_PDF_Check_Box);
            logReport("Attache Itinerary PDF check box is checked Successfully");
        } else {
            unCheck(Attach_Iteinerary_PDF_Check_Box);
            logReport("Attache Itinerary PDF  check box is unChecked Successfully");
        }

    }


    public void enterMessage(String message) throws Exception {

        switchToIframeMessage();
        browser.findElement(By.cssSelector("body")).sendKeys(message);
        browser.switchTo().defaultContent();
        logReport("Message Entered Successfully");
    }

    public void uploadEmailTemplateAttachment(String fileName) throws Exception {
        clickByJavaScript(Upload_File_Link);
        logReport("Upload Button Clicked");
        switchToLatestTabOrWindow();
        logReport("Switched to new Window");
        Wait(Browse_File_Button, 30);
        logReport("Wait for Browse Button");
        File file = new File("target/test-classes/files/" + fileName);
        String absolutePath = file.getAbsolutePath();
        Browse_File_Button.sendKeys(absolutePath);
        logReport("Entered Path of the File in the browse button");
        Overwrite_Existing_File_Radio_Buttom.click();
        logReport("Override Radio Button is clicked");
        Upload_Image_File_Button.click();
        logReport("File Upload Button Clicked");
        waitForWindowToDispose();
        browser.navigate().refresh();
        VerifyPageReady(30);
        Wait(Attachment_Drop_Down, 30);
        logReport("Wait for the Attachment Drop Down");
        select(Attachment_Drop_Down, fileName);
        logReport("Attachment Selected From the Drop down");

    }

    public EventEmailTemplatePage clickSaveButton() throws Exception {
        Save_Button.click();
        VerifyPageReady(30);
        logReport("Save Button clicked Successfully");
        return new EventEmailTemplatePage(browser);
    }

    public void clickCancelButton() throws Exception {
        Cancel_Button.click();
        VerifyPageReady(30);
        logReport("Save Button clicked Successfully");
    }

    public void emailTemplatesData(EmailTemplates emailTemplates) throws Exception {
        entertemplateName(emailTemplates.getName());
        selectAppendValue(emailTemplates.getAppendType());
        enterSubject(emailTemplates.getSubject());
        enterMessage(emailTemplates.getMessage());
        checkUncheckScheduleEmailCheckBox("true");
        enterCode(emailTemplates.getCode());
        select(Schedule_Drop_Down, emailTemplates.getScheduled());


    }

    /**
     * Method for getting current time value
     *
     * @return currentTime
     */
    public String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        /* Setting the Timezone */
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-8"));
        dateFormat.setTimeZone(cal.getTimeZone());
        /* Picking the time value in the required Format */
        String currentTime = dateFormat.format(cal.getTime());
        logReport("get current time is " + currentTime);
        return currentTime;
    }

    public void selectDate(String dateValue) {
        type(Date_Text_Box, dateValue, true);
    }

    public String getDateValue() {
        WebElement dateValue = Date_Text_Box;
        logReport("get date value" + dateValue.getAttribute("value"));
        return dateValue.getAttribute("value");
    }

    /**
     * Method for select time
     *
     * @param timeValue value of time
     */
    public void selectTime(String timeValue) {
        type(Time_Text_Box, timeValue, true);
    }

    public String getTimeValue() {
        WebElement timeValue = Time_Text_Box;
        logReport("value of time is" + timeValue.getAttribute("value"));
        return timeValue.getAttribute("value");
    }

    public void clickScheduledDateLabel() {
        WebElement element = browser.findElement(By.xpath("//td[text()='Schedule Date']"));
        click(element);
    }

    public void setFilterData(String columnType, String operatorValue, String value) {
        select(Filter_Column_Drop_Down, columnType);
        logReport("selected column filter  value is " + columnType);
        select(Filter_Operator_Drop_Down, operatorValue);
        logReport("selected operator value is " + operatorValue);
        type(FILTER_VALUE_TEXTBOX, value, true);
        logReport("entered value " + value);
    }

    public void fillAndSaveData(EmailTemplates emailTemplates) throws Exception {

        setFilterData(emailTemplates.getColumnFilters(), emailTemplates.getOperatorFilters(), emailTemplates.getValueFilters());
        saveDataWithFutureTime(emailTemplates, 0);
    }

    public boolean verifyScheduledDate() throws Exception {
        WebElement scheduledDate = browser.findElement(SCHEDULED_DATE_TIME);
        String getScheduledDate = scheduledDate.getText();
        String newScheduledDate, compareDate;
        getScheduledDate = getScheduledDate.replaceAll("\\(Pacific Time\\)", "");
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a");
        Date newDate = sdf.parse(getScheduledDate);
        sdf.applyPattern("MM/dd/yyyy hh:mm a");
        newScheduledDate = sdf.format(newDate);
        System.out.println(newScheduledDate);
        compareDate = getDateValue() + " " + getTimeValue();
        return newScheduledDate.equals(compareDate);


    }

    public void saveDataWithFutureTime(EmailTemplates emailTemplates, int count) throws Exception {
        click(Save_Button);
        VerifyPageReady(30);
        String messageText = getMessageText();
        reporter.info("Message text = " + messageText);
        if (messageText.contains(SELECT_FUTURE_TIME_ERROR_MESSAGE) && count < 10) {
            reporter.info("Need to Set future Time");
            count++;
            if (verifyElementDisplayed(ERROR_MESSAGE_CLOSE, 0)) {
                click(ERROR_MESSAGE_CLOSE);
            }
            selectFutureTime(emailTemplates, count);
        }
    }
}
