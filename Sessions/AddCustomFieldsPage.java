package pageObjects.Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;
import java.util.List;

public class AddCustomFieldsPage extends CommonActionsPage {

    @FindBy(xpath = "//button[@x-ng-click='addSections()']")
    public WebElement ADD_SECTIONS_BUTTON;

    public AddCustomFieldsPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void addAllStandardAndCustomFields() throws Exception {

        List<WebElement> STANDARD_FIELDS_LIST = browser.findElements(By.xpath("//div[@ng-repeat='standardSection in standardSections | filter:query']//input"));
        List<WebElement> CUSTOM_FIELDS_LIST = browser.findElements(By.xpath("//div[@ng-repeat='customField in customFields | filter:query']//input"));
        Thread.sleep(500);
        if (STANDARD_FIELDS_LIST.size() > 0) {
            for (WebElement standardField : STANDARD_FIELDS_LIST) {
                if (!standardField.isSelected()) {
                    standardField.click();
                    logReport("Standard field element clicked");
                }

            }
        } else
            logReport("Standard field not exist on layout");
        if (CUSTOM_FIELDS_LIST.size() > 0) {
            for (WebElement customField : CUSTOM_FIELDS_LIST) {
                if (!customField.isSelected()) {
                    customField.click();
                    logReport("Custom field element clicked");
                }

            }
        } else
            logReport("Custom field not exist on layout");
    }

    public void addStandardFieldsOnly() throws Exception {
        List<WebElement> STANDARD_FIELDS_LIST = browser.findElements(By.xpath("//div[@ng-repeat='standardSection in standardSections | filter:query']//input"));
        List<WebElement> CUSTOM_FIELDS_LIST = browser.findElements(By.xpath("//div[@ng-repeat='customField in customFields | filter:query']//input"));
        Thread.sleep(500);
        if (STANDARD_FIELDS_LIST.size() > 0) {
            for (WebElement standardField : STANDARD_FIELDS_LIST) {
                if (!standardField.isSelected()) {
                    standardField.click();
                    logReport("Standard field element checked");
                }

            }
        } else
            logReport("Standard field not exist on layout");
        if (CUSTOM_FIELDS_LIST.size() > 0) {
            for (WebElement customField : CUSTOM_FIELDS_LIST) {
                if (customField.isSelected()) {
                    clickByJavaScript(customField);
                    logReport("Custom field element unchecked");
                }

            }
        } else
            logReport("Custom field not exist on layout");
    }

    public SessionLayoutPage addSections() throws Exception {
        Wait(ADD_SECTIONS_BUTTON, 30);
        click(ADD_SECTIONS_BUTTON);
        logReport("Standard and Custom fields are added successfully ");
        return new SessionLayoutPage(browser);
    }

}
