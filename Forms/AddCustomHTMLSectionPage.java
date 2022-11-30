package pageObjects.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddFormCustomHTMLData;
import pojo.SectionHeader;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 23-08-2017.
 */
public class AddCustomHTMLSectionPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@name='customBlockName']")
    public WebElement CUSTOM_HTML_SECTION_NAME;

    public AddCustomHTMLSectionPage(WebDriver driver) throws ConfigurationException{
        PageFactory.initElements(driver, this);
    }

    public void enterCustomHTMLSectionName(String customHTMLSectionName) throws Exception {
        Wait(CUSTOM_HTML_SECTION_NAME, 30);
        type(CUSTOM_HTML_SECTION_NAME, customHTMLSectionName, true);
        logReport("Entered Value: " + customHTMLSectionName + " in 'CustomHTML Section Name' TextBox");
    }

    public void fillCustomHTMLPageDetails(SectionHeader sectionHeaderData, AddFormCustomHTMLData addFormCustomHTMLData) throws Exception {
        Wait(SAVE_BUTTON_FORM, 30);
        VerifyAjaxRequestsFinished(30);
        fillSectionHeaderDetails(sectionHeaderData);
        enterCustomHTMLSectionName(addFormCustomHTMLData.getCustomSectionHTMLName());

    }


}
