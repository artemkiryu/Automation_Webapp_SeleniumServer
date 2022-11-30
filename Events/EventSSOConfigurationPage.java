package pageObjects.Events;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import java.util.List;

public class EventSSOConfigurationPage extends CommonActionsPage {

    @FindBy(xpath = "//strong[text()='Conference Sessions']/../input")
    public WebElement CONFERENCE_SESSION_CHK;
    @FindBy(xpath = "//input[@id='event-configs-save']")
    public WebElement SAVE_EVENT;

    public EventSSOConfigurationPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void checkAppCheckbox(String appName) throws Exception {
        String xpath = "//td[contains(text(),'" + appName + "')]/preceding-sibling::td//input";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 20);
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        if (elements.size() > 1) {
            if (!elements.get(elements.size() - 1).isSelected()) {
                clickByJavaScript(elements.get(elements.size() - 1));
                //  elements.get(elements.size() - 1).click();
            }
        } else
            checkByJavascript(element);
    }

    /**
     * Method for clicking save button
     */
    public void clickSaveButton() throws Exception {
        clickByJavaScript(SAVE_EVENT);
        reporter.info("Save button clicked successfully");
        VerifyPageReady(30);
    }

    public boolean isAppPresentInConfigurationPage(String appName) {
        String xpath = "//td[contains(text(),'" + appName + "')]";
        return verifyElementDisplayed(By.xpath(xpath), 10);
    }

}
