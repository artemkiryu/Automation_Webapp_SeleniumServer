package pageObjects.SpeakerPortal;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import java.util.List;

public class MyTasksPage extends CommonActionsPage {
    @FindBy(xpath = "//div[@class='panel-heading']/span[1]")
    public List<WebElement> SESSION_LIST;
    @FindBy(xpath = "//input[@x-ng-click='updateTaskStatus()']")
    public WebElement SAVE_TASK;

    public MyTasksPage(WebDriver driver)
            throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public void expandSession(String sessionName) {
        for (WebElement e : SESSION_LIST) {
            if (e.getText().trim().equalsIgnoreCase(sessionName)) {
                e.click();
                logReport("Session expanded");
                return;
            }
        }
    }

    public void saveTask(String taskName) {
        String xpath = "//td[text()='" + taskName + "']/..//td[1]//input";
        WebElement element = browser.findElement(By.xpath(xpath));
        checkByJavascript(element);
        logReport("Task checked successfully");
        click(SAVE_TASK);
        logReport("Save task button clicked");
        VerifyAngularHasFinishedProcessing(10);
    }
}
