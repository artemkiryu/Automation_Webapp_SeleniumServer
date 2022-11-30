package pageObjects.Planning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 25-08-2017.
 */
public class TasksListPage extends CommonActionsPage {

    @FindBy(xpath = "//div[contains(.,'Task List')]/button[text()='Add New']")
    public WebElement ADD_NEW_TASK_BUTTON;

    public TasksListPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public AddTaskPage clickAddNewTaskButton() throws Exception {
        Wait(ADD_NEW_TASK_BUTTON, 30);
        click(ADD_NEW_TASK_BUTTON);
        logReport("Add new Tasks button clicked successfully.");
        VerifyPageReady(30);
        return new AddTaskPage(browser);
    }
}
