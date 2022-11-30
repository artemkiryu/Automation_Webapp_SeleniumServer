package pageObjects.Communication;


import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by infoobjects on 5/3/2017.
 */
public class EventEmailTemplatePage extends CommonActionsPage {

    @FindBy(xpath = "//button[@id='create-link']")
    public WebElement ADD_NEW_EMAIL_TEMPLATE;
    @FindBy(xpath = "//table[@id='list-templates']/tbody/tr/td[1]")
    public List<WebElement> EMAIL_TEMPLATE_LIST;

    @FindBy(xpath = "//div[@class='sidebar-body']//a[@title='Speaker Email Templates for use in response/transactional emails.']")
    public WebElement SPEAKER_EMAIL_TEMPLATE_TAB;

    @FindBy(xpath = "//div[@id='sidebar-wrapper']//a[text()='Invoices']")
    public WebElement INVOICES_TAB;

    public EventEmailTemplatePage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public EventEmailTemplateDetailsPage clickAddNewButton() throws Exception {
        // VerifyPageReady(30);
        ADD_NEW_EMAIL_TEMPLATE.click();
        logReport("Add New Event Template Button is Clicked");
        VerifyPageReady(30);

        return new EventEmailTemplateDetailsPage(browser);
    }

    public List<String> getEmailTemplateItems() throws Exception {
        Wait(ADD_NEW_EMAIL_TEMPLATE, 30);

        logReport("" + EMAIL_TEMPLATE_LIST.size() + "Items");
        List<String> items = new ArrayList<>();
        for (WebElement e : EMAIL_TEMPLATE_LIST) {
            items.add(e.getText().trim());
        }
        return items;
    }

    public EventSpeakerEmailTemplatePage clickSpeakerEmailTemplateTab() throws Exception {
        Wait(SPEAKER_EMAIL_TEMPLATE_TAB, 30);
        click(SPEAKER_EMAIL_TEMPLATE_TAB);
        logReport("speaker email template tab clicked successfully");
        VerifyAngularHasFinishedProcessing(30);
        VerifyPageReady(30);
        return new EventSpeakerEmailTemplatePage(browser);
    }

    public EventInvoicesPage clickInvoicesTab() throws Exception {
        Wait(INVOICES_TAB, 30);
        click(INVOICES_TAB);
        logReport("Invoices tab clicked successfully");
        VerifyPageReady(30);
        VerifyAngularHasFinishedProcessing(30);
        return new EventInvoicesPage(browser);
    }
}
