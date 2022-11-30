package pageObjects.Communication;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.EventEmailTemplate;

/**
 * Created by infoobjects on 25-05-2017.
 */
public class EventPersonalDocumentDetailsPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@name='perDocName']")
    public WebElement PERSONAL_DOCUMENT_NAME_TEXT_BOX;
    @FindBy(xpath = "//input[@name='perDocDescription']")
    public WebElement PERSONAL_DOCUMENT_DESCRIPTION_TEXT_BOX;
    @FindBy(xpath = "//select[@name='perDocTemplate']")
    public WebElement PERSONAL_DOCUMENT_TEMPLATE_DROP_DOWN;
    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement PERSONAL_DOCUMENT_SAVE_BUTTON;
    @FindBy(xpath = "//input[@id='cancelForm']")
    public WebElement PERSONAL_DOCUMENT_CANCEL_BUTTON;

    public EventPersonalDocumentDetailsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void fillPersonalDocumentPage(EventEmailTemplate eventEmailTemplate) throws Exception {

        enterPersonalDocumentName(eventEmailTemplate.getPersonalDocName());
        enterPersonalDocumentDescription(eventEmailTemplate.getPersonalDocDesc());
        selectTemplateName(eventEmailTemplate.getPersonalDocTemplateName());
        selectOutputFormatRadioButton(eventEmailTemplate.getPersonalDocOutputFormatRadioButton());

    }


    public void enterPersonalDocumentName(String name) throws Exception {

        type(PERSONAL_DOCUMENT_NAME_TEXT_BOX, name);
        logReport("Personal Document Name" + name + "is Entered Successfully ");
    }

    public void enterPersonalDocumentDescription(String description) throws Exception {

        type(PERSONAL_DOCUMENT_DESCRIPTION_TEXT_BOX, description);
        logReport("Personal Document Description" + description + "is Entered Successfully ");
    }

    public void selectTemplateName(String template) throws Exception {

        select(PERSONAL_DOCUMENT_TEMPLATE_DROP_DOWN, template);
        logReport("Personal Document Template" + template + "is selected Successfully");
    }

    public void selectOutputFormatRadioButton(String radioButton) throws Exception {

        String xpath = "//input[contains(@id,'" + radioButton + "')]";
        browser.findElement(By.xpath(xpath)).click();
        logReport("Personal Document OutPut Format Radio Button" + radioButton + "is selected Successfully");
    }

    public EventPersonalDocumentPage clickPersonalSaveDocument() throws Exception {

        click(PERSONAL_DOCUMENT_SAVE_BUTTON);
        logReport("Save Button is clicked Successfully");

        logReport("Redirected to" + browser.getTitle() + "Page");
        return new EventPersonalDocumentPage(browser);
    }

    public EventPersonalDocumentPage clickPersonalCancelDocument() throws Exception {

        click(PERSONAL_DOCUMENT_CANCEL_BUTTON);
        logReport("Cancel Button is clicked Successfully");
        logReport("Redirected to" + browser.getTitle() + "Page");
        return new EventPersonalDocumentPage(browser);

    }
}
