package pageObjects.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddFormData;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 21-08-2017.
 */
public class AddFormPage extends CommonActionsPage {

    //Setup Information
    @FindBy(xpath = "//input[@name='form_name']")
    public WebElement FORM_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@name='form_subtitle']")
    public WebElement FORM_SUBTITLE_TEXTBOX;
    @FindBy(xpath = "//input[@name='form_email_cc_list']")
    public WebElement FORM_EMAIL_CC_TEXTBOX;
    @FindBy(xpath = "//input[@name='form_label']")
    public WebElement FORM_HYPERLINK_LABEL_TEXTBOX;
    @FindBy(xpath = "//input[@name='txtFormGoogleAnalyticsToken']")
    public WebElement FORM_GOOGLE_ANALYTICS_TRACKING_ID_TEXTBOX;
    @FindBy(xpath = "//select[@id='form_entry_frn_reg_sts_id']")
    public WebElement FORM_REG_STATUS_DROPDOWN;
    @FindBy(xpath = "//textarea[@id='form_notes']")
    public WebElement FORM_NOTES_TEXTAREA ;

    public AddFormPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);

    }

    public void fillFormSetupInformationDetails(AddFormData addFormData) throws Exception {

        Wait(SAVE_BUTTON_FORM, 30);
        VerifyAjaxRequestsFinished(30);
        type(FORM_NAME_TEXTBOX, addFormData.getFormName(), true );
        type(FORM_SUBTITLE_TEXTBOX, addFormData.getSubtitle(), true);
        type(FORM_EMAIL_CC_TEXTBOX, addFormData.getCc(), true);
        type(FORM_HYPERLINK_LABEL_TEXTBOX, addFormData.getHyperlinkLabel(), true);
        type(FORM_GOOGLE_ANALYTICS_TRACKING_ID_TEXTBOX, addFormData.getGoogleTrackingID(), true);
        select(FORM_REG_STATUS_DROPDOWN, addFormData.getRegStatus());
        type(FORM_NOTES_TEXTAREA, addFormData.getUserNotes() , true);

    }

}
