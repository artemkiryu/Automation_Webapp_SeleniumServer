package pageObjects.Communication;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.EventEmailTemplate;

import java.io.File;

/**
 * Created by infoobjects on 5/3/2017.
 */
public class EventSpeakerEmailTemplateDetailsPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@name='txtSpecificationName']")
    public WebElement Email_Template_Name_Text_Box;
    @FindBy(xpath = "//input[contains(@id,'specAccess1')]")
    public WebElement This_Event_Only_Radio_button;
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

    public EventSpeakerEmailTemplateDetailsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void testEventSpeakerTemplateFill(EventEmailTemplate emailTemplate) throws Exception {
        Wait(Save_Button, 30);
        uploadEmailTemplateAttachment(emailTemplate.getSpeakerFileName());
        VerifyAjaxRequestsFinished(30);
        entertemplateName(emailTemplate.getSpeakerTemplateName());
        selectVisibleRadioButton(emailTemplate.getSpeakerVisibleToRadioButtonValue());
        checkUncheckCurrentUserOnlyCheckBox(emailTemplate.getSpeakerCurrentUserOnlyCheckbox());
        enterFromEmail(emailTemplate.getSpeakerFromEmail());
        enterReplyToEmail(emailTemplate.getSpeakerReplyToEmail());
        selectAppendValue(emailTemplate.getSpeakerAppendDropDownValue());
        clickSubjectButton();
        clickMessageButton();
        enterSubject(emailTemplate.getSpeakerMessageSubject());
        enterMessage(emailTemplate.getSpeakerMessageBody());
        checkUnCheckEnableEditorCheckBox(emailTemplate.getSpeakerEnableEditorCheckbox());
        checkUnCheckSendAsHtmlCheckBox(emailTemplate.getSpeakerSendAsHTMLCheckbox());
        checkUnCheckIncludeEventDisplayShellCheckBox(emailTemplate.getSpeakerIncludeEventDisplayCheckbox());

    }

    public void fillSpeakerEmailTemplateDetails(EventEmailTemplate emailTemplate) throws Exception {
        Wait(Save_Button, 30);
        entertemplateName(emailTemplate.getTemplateName());
        enterFromEmail(emailTemplate.getFromEmail());
        enterReplyToEmail(emailTemplate.getReplyToEmail());
        selectAppendValue(emailTemplate.getAppendDropDownValue());
        enterSubject(emailTemplate.getMessageSubject());
        clickSubjectButton();
        enterMessage(emailTemplate.getMessageBody());

    }


    public void entertemplateName(String name) throws Exception {

        VerifyPageReady(30);
        Wait(Email_Template_Name_Text_Box, 30);
        type(Email_Template_Name_Text_Box, name, true);
        logReport("Entered Speaker Email Template Name" + name + "Successfully");

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
        logReport("Append Value Selected Successfully");

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

    public void enterSubject(String subject) throws Exception {

        type(Subject_Text_Box, subject);
        logReport("Email Template Subject " + subject + "is entered Successfully");
    }

    private void checkUnCheckEnableEditorCheckBox(String state) throws Exception {

        if (Boolean.valueOf(state)) {
            checkByJavascript(Enable_Editor_Check_Box);
            logReport("Enable Editor check box is checked Successfully");
        } else {
            uncheckByJavascript(Enable_Editor_Check_Box);
            logReport("Enable Editor check box is unChecked Successfully");
        }

    }


    private void checkUnCheckSendAsHtmlCheckBox(String state) throws Exception {

        if (Boolean.valueOf(state)) {
            checkByJavascript(Send_As_HTML_Check_Box);
            logReport("Send As HTML check box is checked Successfully");
        } else {
            uncheckByJavascript(Send_As_HTML_Check_Box);
            logReport("Send As HTML check box is unChecked Successfully");
        }

    }


    private void checkUnCheckIncludeEventDisplayShellCheckBox(String state) throws Exception {

        if (Boolean.valueOf(state)) {
            checkByJavascript(Include_Event_Display_Shell_Check_Box);
            logReport("Include Event Display Shell check box is checked Successfully");
        } else {
            uncheckByJavascript(Include_Event_Display_Shell_Check_Box);
            logReport("Include Event Display Shell check box is unChecked Successfully");

        }

    }


    public void enterMessage(String message) throws Exception {

        switchToIframeMessage();
        browser.findElement(By.cssSelector("body")).sendKeys(message);
        browser.switchTo().defaultContent();
        logReport("Message Entered Successfully");
    }

    public void uploadEmailTemplateAttachment(String fileName) throws Exception {

        System.out.println("File Name" + fileName);
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

    public EventSpeakerEmailTemplatePage clickSaveButton() throws Exception {
        Save_Button.click();
        VerifyPageReady(30);
        logReport("Save Button clicked Successfully");
        return new EventSpeakerEmailTemplatePage(browser);
    }

    public void clickCancelButton() throws Exception {
        Cancel_Button.click();
        VerifyPageReady(30);
        logReport("Save Button clicked Successfully");
    }


}
