package pageObjects.EventRegistrations;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.RegistrationEmailData;

/**
 * Created by infoobjects on 8/31/2017.
 */
public class EmailPage extends CommonActionsPage {

    @FindBy(xpath = "//select[@id='my_select']")
    public WebElement EMAIL_TEMPLATE_DROPDOWN;
    @FindBy(xpath = "//input[@name='messageFrom']")
    public WebElement Message_From_Text_Box;
    @FindBy(xpath = "//input[@name='messageTo']")
    public WebElement Message_To_Text_Box;
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
    @FindBy(xpath = "//input[@value='Send Email NOW']")
    public WebElement SEND_EMAIL_NOW_BUTTON;



    /**
     * Email page Constructor for setting up page webdriver
     */
    public EmailPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }
    private void selectEmailTempelate(String emailTemplate)throws Exception{
        VerifyPageReady(30);
        Wait(EMAIL_TEMPLATE_DROPDOWN, 30);
        select(EMAIL_TEMPLATE_DROPDOWN, emailTemplate);
        logReport("Successfully selected value: " + emailTemplate + " in email template dropdown.");

    }
    private void enterFromEmail(String fromEmail) throws Exception {
        clearTextBoxValue(Message_From_Text_Box);
        type(Message_From_Text_Box, fromEmail);
        logReport("From Email " + fromEmail + "is entered Successfully");
    }
    private void enterToEmail(String toEmail) throws Exception {

        clearTextBoxValue(Message_To_Text_Box);
        type(Message_To_Text_Box, toEmail);
        logReport("To Email " + toEmail + "is entered Successfully");
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

    public void clickSendEmailNowButton()throws Exception{
        VerifyPageReady(30);
        Wait(SEND_EMAIL_NOW_BUTTON, 30);
        click(SEND_EMAIL_NOW_BUTTON);
        logReport("Successfully clicked on 'Send Email Now' button.");
    }

    public void fillRegistrationEmailDetails(RegistrationEmailData registrationEmailData)throws Exception{
        selectEmailTempelate(registrationEmailData.getEmailTempelate());
        enterFromEmail(registrationEmailData.getFrom());
        enterToEmail(registrationEmailData.getTo());
        enterReplyToEmail(registrationEmailData.getReplyTo());
        selectAppendValue(registrationEmailData.getAppend());
        clickSubjectButton();
        clickMessageButton();
        enterSubject(registrationEmailData.getSubject());
        clickSendEmailNowButton();

    }
}
