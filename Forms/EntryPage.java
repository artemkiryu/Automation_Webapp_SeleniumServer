package pageObjects.Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddFormEntryPageData;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 21-08-2017.
 */
public class EntryPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@name='addTitle']")
    public WebElement ADD_TO_PAGE_HTML_BUTTON;
    @FindBy(xpath = "//select[@id='selectEventData']")
    public WebElement APPEND_DATA_FIELDS_DROPDOWN;

    public EntryPage(WebDriver driver) throws ConfigurationException{
        PageFactory.initElements(driver, this);
    }

    public void fillEntryPageDetails(AddFormEntryPageData addFormEntryPageData) throws Exception {
        Wait(SAVE_BUTTON_FORM, 30);
        VerifyAjaxRequestsFinished(30);
        select(APPEND_DATA_FIELDS_DROPDOWN, addFormEntryPageData.getDataFieldName());
        click(ADD_TO_PAGE_HTML_BUTTON);
    }

}
