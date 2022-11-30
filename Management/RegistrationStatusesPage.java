package pageObjects.Management;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

public class RegistrationStatusesPage extends CommonActionsPage {

    public RegistrationStatusesPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void associateTagWithRegStatus(String regStatus, String tagName) throws Exception {
        if (isRegStatusPresent(regStatus)) {
            logReport("" + regStatus + " is a valid type registration status.");
            clickEditTag(regStatus);
            selectTags(regStatus, tagName);
            clickSaveTag(regStatus);
        } else {
            logReport("" + regStatus + " is an invalid type registration status.");
        }
    }

    public boolean isRegStatusPresent(String regStatus) {
        String xpath = "//tr[@x-ng-repeat='status in statuses']//span[text()='" + regStatus + "']";
        return verifyElementDisplayed(By.xpath(xpath), 2);
    }

    public void selectTags(String regStatus, String tagName) throws Exception {
        String xpath = "//tr[@x-ng-repeat='status in statuses']//span[text()='" + regStatus + "']/../..//following-sibling::select";
        WebElement element = browser.findElement(By.xpath(xpath));
        scrollIntoView(element);
        select(element, tagName);
        logReport("Selected tag value " + tagName);
    }

    public void clickSaveTag(String regStatus) throws Exception {
        String xpath = "//tr[@x-ng-repeat='status in statuses']//span[text()='" + regStatus + "']/../..//following-sibling::td[@class='user-action']//i";
        logReport("-----------" + xpath);
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        logReport("Tag Save button clicked successfully ");
    }

    public void clickEditTag(String regStatus) throws Exception {
        String xpath = "//tr[@x-ng-repeat='status in statuses']//span[text()='" + regStatus + "']/../..//following-sibling::td[@class='user-action']//i[2]";
        logReport("-----------" + xpath);
        WebElement element = browser.findElement(By.xpath(xpath));
        clickByJavaScript(element);
        wait(10);
        logReport("Tag Edit button clicked successfully ");
    }
}
