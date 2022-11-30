package pageObjects.Communication;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.EventEmailTemplate;

import java.io.File;

/**
 * Created by infoobjects on 25-05-2017.
 */
public class EventUploadDocumentTemplatesDetailsPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@id='name']")
    public WebElement UPLOAD_DOCUMENT_NAME_TEXT_BOX;
    @FindBy(xpath = "//input[@id='description']")
    public WebElement UPLOAD_DOCUMENT_DESCRIPTION_TEXT_BOX;
    @FindBy(xpath = "//input[@id='templateFile']")
    public WebElement UPLOAD_DOCUMENT_TEMPLATE_FILE_UPLOAD;
    @FindBy(xpath = "//input[@id='previewImg']")
    public WebElement UPLOAD_DOCUMENT_TEMPLATE_IMAGE_UPLOAD;
    @FindBy(xpath = "//select[@class='form-control']")
    public WebElement UPLOAD_DOCUMENT_TEMPLATE_REPORT_TYPE_DROP_DOWN;
    @FindBy(xpath = "//input[@id='preSortCol']")
    public WebElement UPLOAD_DOCUMENT_TEMPLATE_PreSort_Column_DROP_DOWN;
    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement UPLOAD_DOCUMENT_SAVE_BUTTON;
    @FindBy(xpath = "//input[@id='cancelForm']")
    public WebElement UPLOAD_DOCUMENT_CANCEL_BUTTON;

    public EventUploadDocumentTemplatesDetailsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void fillUploadDocumentTemplatePage(EventEmailTemplate eventEmailTemplate) throws Exception {

        enterUploadDocumentName(eventEmailTemplate.getUploadDocName());
        enterUploadDocumentDescription(eventEmailTemplate.getUploadDocDesc());
        String file = reName();
        Thread.sleep(5000);
        uploadDocumentTemplateImage(eventEmailTemplate.getUploadDocImage());
        Thread.sleep(5000);
        uploadDocumentTemplateFile(file);
        selectReportType(eventEmailTemplate.getUploadDocReportType());
        enterPreSortColumn(eventEmailTemplate.getUploadDocPreSortColumn());

    }


    public void enterUploadDocumentName(String name) throws Exception {

        type(UPLOAD_DOCUMENT_NAME_TEXT_BOX, name);
        logReport("Personal Document Name" + name + "is Entered Successfully ");
    }

    public void enterUploadDocumentDescription(String description) throws Exception {

        type(UPLOAD_DOCUMENT_DESCRIPTION_TEXT_BOX, description);
        logReport("Personal Document Description" + description + "is Entered Successfully ");
    }


    public void uploadDocumentTemplateFile(String fileName) throws Exception {


        Wait(UPLOAD_DOCUMENT_TEMPLATE_FILE_UPLOAD, 30);
        logReport("Wait for Upload Template Browse Button");
        File file = new File("./src/test/resources/files/" + fileName);
        String absolutePath = file.getAbsolutePath();
        UPLOAD_DOCUMENT_TEMPLATE_FILE_UPLOAD.sendKeys(absolutePath);
        logReport("Entered Path of the File in the Template File browse button" + absolutePath);
    }

    public void uploadDocumentTemplateImage(String fileName) throws Exception {

        Wait(UPLOAD_DOCUMENT_TEMPLATE_IMAGE_UPLOAD, 30);
        logReport("Wait for Upload Template Browse Button");
        File file = new File("./src/test/resources/files/" + fileName);
        String absolutePath = file.getAbsolutePath();
        UPLOAD_DOCUMENT_TEMPLATE_IMAGE_UPLOAD.sendKeys(absolutePath);
        logReport("Entered Path of the Image in the Template File browse button" + absolutePath);
    }

    public void selectReportType(String reportType) throws Exception {

        select(UPLOAD_DOCUMENT_TEMPLATE_REPORT_TYPE_DROP_DOWN, reportType);
        logReport("Upload Document Template Report type " + reportType + "is selected Successfully");
    }

    public void enterPreSortColumn(String preSortColunm) throws Exception {

        type(UPLOAD_DOCUMENT_TEMPLATE_PreSort_Column_DROP_DOWN, preSortColunm);
        logReport("Entered value in PreSort Column Successfully");
    }

    public EventUploadDocumentTemplatePage clickUploadDocumentTemplateSaveButton() throws Exception {

        click(UPLOAD_DOCUMENT_SAVE_BUTTON);
        logReport("Save Button is clicked Successfully");

        logReport("Redirected to" + browser.getTitle() + "Page");
        return new EventUploadDocumentTemplatePage(browser);
    }

    public EventUploadDocumentTemplatePage clickUploadDocumentTemplateCancelButton() throws Exception {

        click(UPLOAD_DOCUMENT_CANCEL_BUTTON);
        logReport("Cancel Button is clicked Successfully");
        logReport("Redirected to" + browser.getTitle() + "Page");
        return new EventUploadDocumentTemplatePage(browser);

    }
}
