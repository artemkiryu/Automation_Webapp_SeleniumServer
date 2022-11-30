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
public class EventCustomBlockDetailsPage extends CommonActionsPage {

    @FindBy(xpath = "//input[@type='Text']")
    public WebElement CUSTOM_BLOCK_NAME_TEXT_BOX;
    @FindBy(xpath = "//input[@id='submitForm']")
    public WebElement CUSTOM_BLOCK_SAVE_BUTTON;
    @FindBy(xpath = "//input[@id='cancelForm']")
    public WebElement CUSTOM_BLOCK_CANCEL_BUTTON;

    public EventCustomBlockDetailsPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void fillCustomBlockPage(EventEmailTemplate eventEmailTemplate) throws Exception {

        enterCustomBlockName(eventEmailTemplate.getCustomBlockName());

    }

    public void enterCustomBlockName(String name) throws Exception {

        type(CUSTOM_BLOCK_NAME_TEXT_BOX, name);
        logReport("Custom Block Name" + name + "is Entered Successfully ");
    }


    public EventCustomBlockPage clickCustomBlockSaveButton() throws Exception {

        clickByJavaScript(CUSTOM_BLOCK_SAVE_BUTTON);
        logReport("Save Button is clicked Successfully");

        logReport("Redirected to" + browser.getTitle() + "Page");
        return new EventCustomBlockPage(browser);
    }

    public EventCustomBlockPage clickCustomBlockCancelButton() throws Exception {

        click(CUSTOM_BLOCK_CANCEL_BUTTON);
        logReport("Cancel Button is clicked Successfully");
        logReport("Redirected to" + browser.getTitle() + "Page");
        return new EventCustomBlockPage(browser);

    }
}
