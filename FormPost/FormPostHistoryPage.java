package pageObjects.FormPost;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;
import java.util.List;

public class FormPostHistoryPage extends CommonActionsPage {

    @FindBy(xpath = "//button[@ng-click='cancel()']")
    public WebElement CANCEL_BUTTON;

    public FormPostHistoryPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public boolean isRegFoundInFormPostHistory(String regCode) throws Exception {
        boolean found = false;
        String xpath = "//tr[@ng-repeat='historyRow in formPostJobHistory']//td[1][text()='" + regCode + "']";
        List<WebElement> element = browser.findElements(By.xpath(xpath));
        if (element.size() > 0) {
            found = true;
        } else if (element.size() < 0) {
            found = false;
        }
        return found;
    }

    public FormPostPage clickOnCancel() throws Exception {
        Wait(CANCEL_BUTTON, 30);
        click(CANCEL_BUTTON);
        VerifyPageReady(30);
        logReport("Successfully clicked on 'Form Post History Cancel' button.");
        return new FormPostPage(browser);
    }
}
