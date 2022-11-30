package pageObjects.Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;
import pojo.AddJobFunctionData;

import javax.naming.ConfigurationException;

public class SessionJobFunctionsPage extends CommonActionsPage {

    @FindBy(xpath = "//button[@ng-click='toggleDropdown()']")

    public WebElement JOB_FUNCTIONS_DROPDOWN;

    @FindBy(xpath = "//input[@x-ng-model='accountListActual.selectAll']")

    public WebElement SELECT_ALL_CHECKBOX;

    @FindBy(xpath = "//input[@value='Save Event Job Functions']")

    public WebElement SAVE_EVENT_JOBFUNCTIONS_BUTTON;

    @FindBy(xpath = "//button[text()='Choose Job Functions']")

    public WebElement CHOOSE_JOB_FUNCTIONS_BUTTON;


    public SessionJobFunctionsPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void selectAllJobFunctions() throws Exception {
        VerifyPageReady(30);
        click(JOB_FUNCTIONS_DROPDOWN);
        Thread.sleep(2000);
        Wait(SELECT_ALL_CHECKBOX, 20);
        if (!SELECT_ALL_CHECKBOX.isSelected()) {
            clickByJavaScript(SELECT_ALL_CHECKBOX);
        }
        logReport("All job functions selected successfully");
        saveAllJobFunctions();
    }

    public void saveAllJobFunctions() throws Exception {
        Wait(SAVE_EVENT_JOBFUNCTIONS_BUTTON, 20);
        clickByJavaScript(SAVE_EVENT_JOBFUNCTIONS_BUTTON);
        logReport("All job functions saved successfully");
    }

    public void selectJobFunctionDropdown(AddJobFunctionData addJobFunctionData) throws Exception {
        Wait(CHOOSE_JOB_FUNCTIONS_BUTTON, 20);
        click(CHOOSE_JOB_FUNCTIONS_BUTTON);
        String xpath = "//div[@class='dropdown-list-block']//span[contains(.,'" + addJobFunctionData.getJobFunctionName() + "')]/input";
        WebElement element = browser.findElement(By.xpath(xpath));
        check(element);
        click(SAVE_EVENT_JOBFUNCTIONS_BUTTON);
        logReport("Save event jon function button clicked successfully");
        VerifyPageReady(30);
    }
}
