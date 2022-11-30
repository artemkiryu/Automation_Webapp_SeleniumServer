package pageObjects.Communication;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.EventEmailTemplate;

/**
 * Created by infoobjects on 25-05-2017.
 */
public class EventInvoicesDetailsPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@id='txtInvName']")
    public WebElement INVOICE_NAME_TEXT_BOX;
    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement INVOICES_SAVE_BUTTON;
    @FindBy(xpath = "//input[@id='cancelForm']")
    public WebElement INVOICES_CANCEL_BUTTON;

    public EventInvoicesDetailsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void fillInvoicesPage(EventEmailTemplate eventEmailTemplate) throws Exception {

        enterUploadDocumentName(eventEmailTemplate.getInvoiceName());


    }


    public void enterUploadDocumentName(String name) throws Exception {

        type(INVOICE_NAME_TEXT_BOX, name);
        logReport("Invoice Name" + name + "is Entered Successfully ");
    }


    public EventInvoicesPage clickInvoiceSaveButton() throws Exception {

        clickByJavaScript(INVOICES_SAVE_BUTTON);
        logReport("Save Button is clicked Successfully");
        logReport("Redirected to" + browser.getTitle() + "Page");
        return new EventInvoicesPage(browser);
    }

    public EventInvoicesPage clickInvoiceCancelButton() throws Exception {

        click(INVOICES_CANCEL_BUTTON);
        logReport("Cancel Button is clicked Successfully");
        logReport("Redirected to" + browser.getTitle() + "Page");
        return new EventInvoicesPage(browser);

    }
}
