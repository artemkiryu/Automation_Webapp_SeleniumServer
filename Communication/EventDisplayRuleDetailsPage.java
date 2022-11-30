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
public class EventDisplayRuleDetailsPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@type='Text']")
    public WebElement DISPLAY_RULE_NAME_TEXT_BOX;
    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement DISPLAY_RULE_SAVE_BUTTON;
    @FindBy(xpath = "//input[@id='cancelForm']")
    public WebElement DISPLAY_RULE_CANCEL_BUTTON;

    public EventDisplayRuleDetailsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void fillDisplayRulePage(EventEmailTemplate eventEmailTemplate) throws Exception {

        enterDisplayRuleName(eventEmailTemplate.getDisplayRuleName());

    }

    public void enterDisplayRuleName(String name) throws Exception {

        type(DISPLAY_RULE_NAME_TEXT_BOX, name);
        logReport("Display Rule Name" + name + "is Entered Successfully ");
    }


    public EventDisplayRulePage clickDisplayRuleSaveButton() throws Exception {

        clickByJavaScript(DISPLAY_RULE_SAVE_BUTTON);
        logReport("Save Button is clicked Successfully");

        logReport("Redirected to" + browser.getTitle() + "Page");
        return new EventDisplayRulePage(browser);
    }

    public EventDisplayRulePage clickDisplayRuleCancelButton() throws Exception {

        click(DISPLAY_RULE_CANCEL_BUTTON);
        logReport("Cancel Button is clicked Successfully");
        logReport("Redirected to" + browser.getTitle() + "Page");
        return new EventDisplayRulePage(browser);

    }
}
