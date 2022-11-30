package pageObjects.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddSessionsFormsData;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 23-08-2017.
 */
public class AddSessionsSectionPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@name='sessionName']")
    public static WebElement SESSION_NAME;
    @FindBy(xpath = "//div[@class='form-horizontal']//select[@id='sessionTypes']")
    public static WebElement SESSIONS_TYPE_DROPDOWN;
    @FindBy(xpath = "//div[@class='form-horizontal']//select[@id='groupBySelect1']")
    public WebElement GROUP_BY_DROPDOWN;
    @FindBy(xpath = "//div[@class='form-horizontal']//select[@id='groupByFont1']")
    public WebElement GROUP_BY_STYLE_DROPDOWN;
    @FindBy(xpath = "//div[@id='SessionTemplateId']//select[@id='sessionTemplateId']")
    public WebElement SESSION_TEMPLATE_DROPDOWN;

    public AddSessionsSectionPage(WebDriver driver) throws ConfigurationException{
        PageFactory.initElements(driver, this);
    }

    public void fillFormSessionSectionDetails(AddSessionsFormsData addSessionsFormsData)throws Exception{
        Wait(CommonActionsPage.SAVE_BUTTON, 30);
        VerifyAjaxRequestsFinished(30);
        type(SESSION_NAME, addSessionsFormsData.getSessionSectionName());
        select(SESSIONS_TYPE_DROPDOWN, addSessionsFormsData.getSessionSectionType());
        select(GROUP_BY_DROPDOWN, addSessionsFormsData.getSessionSectionGroupBy());
        select(GROUP_BY_STYLE_DROPDOWN, addSessionsFormsData.getSessionSectionGroupByStyle());
        select(SESSION_TEMPLATE_DROPDOWN, addSessionsFormsData.getSessionTemplate());

    }
}
