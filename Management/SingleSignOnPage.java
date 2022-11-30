package pageObjects.Management;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;
import java.util.List;

/**
 * Created by infoobjects on 31-08-2017.
 */
public class SingleSignOnPage extends CommonActionsPage {

    private String EDIT_XPATH = "//td[text()='TestGoogleApp']/..//img";
    private String CHECKBOX_XPATH = "//td[text()='TestGoogleApp']/..//input";
    private String IDP_NAME_XPATH = "//td[text()='TestGoogleApp']/following-sibling::td[2]";

    @FindBy(xpath = "//button[text()='Add an SSO Config']")
    public WebElement ADD_SSO_CONFIG_BUTTON;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement CONFIRM_OK_BUTTON;

    public SingleSignOnPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void clickToEditSSOConnection(String configName) throws Exception {

        String EDIT_XPATH = "//td[text()='" + configName + "']/..//img";
        VerifyAjaxRequestsFinished(30);
        click(EDIT_XPATH);

    }

    public void getIDPName(String configName) throws Exception {

        String IDP_NAME_XPATH = "//td[text()='" + configName + "']/following-sibling::td[2]";


    }

    public AddSsoConfigPage clickAddSsoConfigButton() throws Exception {
        Wait(ADD_SSO_CONFIG_BUTTON, 30);
        clickByJavaScript(ADD_SSO_CONFIG_BUTTON);
        logReport("Add SSO Config Button clicked successfully");
        VerifyAngularHasFinishedProcessing(30);
        return new AddSsoConfigPage(browser);
    }

    public void checkAppCheckbox(String appName) throws Exception {
        Thread.sleep(3000);
        String xpath = "//td[text()='" + appName + "']/preceding-sibling::td//input";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 30);
        List<WebElement> elements = browser.findElements(By.xpath(xpath));
        if (elements.size() > 1) {
            if (!elements.get(elements.size() - 1).isSelected()) {
                clickByJavaScript(elements.get(elements.size() - 1));
                //  elements.get(elements.size() - 1).click();
            }
        } else
            checkByJavascript(browser.findElement(By.xpath(xpath)));
        Thread.sleep(3000);
    }

    public void clickOkButton() throws Exception {
        //webDriver.waitFor().waitForPageToLoad();
        Wait(CONFIRM_OK_BUTTON, 10);
        clickByJavaScript(CONFIRM_OK_BUTTON);
        logReport("Confirm pop up ok button clicked successfully");
        VerifyPageReady(30);
    }

    public AddSsoConfigPage clickEditAppIcon(String appName) throws Exception {
        String xpath = "//td[text()='" + appName + "']/following-sibling::td//img";
        WebElement element = browser.findElement(By.xpath(xpath));
        Wait(element, 20);
        clickByJavaScript(element);
        logReport("Edit App icon clicked successfully");
        VerifyAngularHasFinishedProcessing(30);
        return new AddSsoConfigPage(browser);
    }

}
