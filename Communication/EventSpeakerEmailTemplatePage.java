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
public class EventSpeakerEmailTemplatePage extends CommonActionsPage {

    @FindBy(xpath = "//button[@id='create-link']")
    public WebElement ADD_NEW_SPEAKER_EMAIL_TEMPLATE;
    @FindBy(xpath = "//table[@id='list-templates']/tbody/tr/td[1]")
    public List<WebElement> SPEAKER_EMAIL_TEMPLATE_LIST;

    public EventSpeakerEmailTemplatePage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public EventSpeakerEmailTemplateDetailsPage clickAddNewButton() throws Exception {
        VerifyPageReady(30);
        ADD_NEW_SPEAKER_EMAIL_TEMPLATE.click();
        VerifyPageReady(30);
        return new EventSpeakerEmailTemplateDetailsPage(browser);
    }

    public List<String> getSpeakerEmailTemplateItems() throws Exception {
        Wait(ADD_NEW_SPEAKER_EMAIL_TEMPLATE, 30);

        logReport("" + SPEAKER_EMAIL_TEMPLATE_LIST.size() + "Items");
        List<String> items = new ArrayList<>();
        for (WebElement e : SPEAKER_EMAIL_TEMPLATE_LIST) {
            items.add(e.getText().trim());
        }
        return items;
    }
}
