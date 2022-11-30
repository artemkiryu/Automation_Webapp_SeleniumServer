package pageObjects.Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddIndustryData;

import javax.naming.ConfigurationException;

public class SessionIndustriesPage extends CommonActionsPage {

    @FindBy(xpath = "//button[@ng-click='toggleDropdown()']")

    public WebElement INDUSTRIES_DROPDOWN;

    @FindBy(xpath = "//input[@x-ng-model='accountListActual.selectAll']")

    public WebElement SELECT_ALL_CHECKBOX;

    @FindBy(xpath = "//input[@value='Save Event Industries']")

    public WebElement SAVE_EVENT_INDUSTRIES_BUTTON;

    @FindBy(xpath = "//button[text()='Choose Industries']")

    public WebElement CHOOSE_INDUSTRIES_BUTTON;


    public SessionIndustriesPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void selectAllIndustries() throws Exception {
        VerifyPageReady(30);
        click(INDUSTRIES_DROPDOWN);
        Thread.sleep(2000);
        Wait(SELECT_ALL_CHECKBOX, 20);
        if (!SELECT_ALL_CHECKBOX.isSelected()) {
            clickByJavaScript(SELECT_ALL_CHECKBOX);
        }
        logReport("All industries are selected successfully");
        saveAllIndustries();
    }

    public void saveAllIndustries() throws Exception {
        Wait(SAVE_EVENT_INDUSTRIES_BUTTON, 20);
        clickByJavaScript(SAVE_EVENT_INDUSTRIES_BUTTON);
        logReport("All industries are saved successfully");
    }

    public void selectIndustryDropdown(AddIndustryData industry) throws Exception {
        Wait(CHOOSE_INDUSTRIES_BUTTON, 20);
        click(CHOOSE_INDUSTRIES_BUTTON);
        String xpath = "//div[@class='dropdown-list-block']//span[contains(.,'" + industry.getIndustryName() + "')]/input";
        WebElement element = browser.findElement(By.xpath(xpath));
        check(element);
        click(SAVE_EVENT_INDUSTRIES_BUTTON);
        logReport("Save event industries button clicked successfully");
        VerifyPageReady(30);
    }
}

