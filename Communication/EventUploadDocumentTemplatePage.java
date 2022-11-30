package pageObjects.Communication;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

/**
 * Created by infoobjects on 25-05-2017.
 */
public class EventUploadDocumentTemplatePage extends CommonActionsPage {

    @FindBy(xpath = "//button[@id='create-link']")
    public WebElement ADD_NEW_UPLOAD_DOCUMENT_TEMPLATE;

    public EventUploadDocumentTemplatePage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public EventUploadDocumentTemplatesDetailsPage clickUploadDocumenttemplateAddNewButton() throws Exception {
        VerifyPageReady(30);
        logReport("Verified Page is Ready");
        ADD_NEW_UPLOAD_DOCUMENT_TEMPLATE.click();
        logReport("Add New Upload Document Templates button is Clicked");
        return new EventUploadDocumentTemplatesDetailsPage(browser);
    }

}
