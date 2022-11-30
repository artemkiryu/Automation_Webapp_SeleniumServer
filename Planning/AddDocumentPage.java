package pageObjects.Planning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.DocumentDetailsData;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 25-08-2017.
 */
public class AddDocumentPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@id='txtFileTitle']")
    public WebElement NAME_TEXTBOX;
    @FindBy(xpath = "//select[@id='txtFileGroup']")
    public WebElement TYPE_DROPDOWN;
    @FindBy(xpath = "//input[@id='txtFileDescription']")
    public WebElement DESCRIPTION_TEXTBOX;
    @FindBy(xpath = "//input[@id='optDocSourceFile']")
    public WebElement FILE_PATH_RADIO_BTN;
    @FindBy(xpath = "//input[@name='fileToUpload']")
    public WebElement CHOOSE_FILE_UPLOAD_BTN;
    @FindBy(xpath = "//input[@id='optDocSourceLink']")
    public WebElement FILE_LINK_RADIO_BTN;
    @FindBy(xpath = "//input[@id='txtFileHref']")
    public WebElement FILE_HREF_TEXTBOX;

    public AddDocumentPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void fillDocumentDetails(DocumentDetailsData documentDetailsData) throws Exception{
        Wait(SAVE_BUTTON, 30);
        VerifyAjaxRequestsFinished(30);
        type(NAME_TEXTBOX, documentDetailsData.getDocumentName());
        select(TYPE_DROPDOWN, documentDetailsData.getDocumentType());
        type(DESCRIPTION_TEXTBOX, documentDetailsData.getDescription());
        //click(CHOOSE_FILE_UPLOAD_BTN);
        click(FILE_LINK_RADIO_BTN);
        type(FILE_HREF_TEXTBOX, documentDetailsData.getFileHREF());

    }

}
