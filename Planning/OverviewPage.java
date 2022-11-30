package pageObjects.Planning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonActionsPage;

import javax.naming.ConfigurationException;

/**
 * Created by infoobjects on 25-08-2017.
 */
public class OverviewPage extends CommonActionsPage {

    public OverviewPage(WebDriver driver) throws ConfigurationException {
        PageFactory.initElements(driver, this);
    }

    public TasksListPage clickTasksTab() throws Exception {
        click(TASKS_TAB);
        logReport("Tasks tab clicked successfully.");
        return new TasksListPage(browser);
    }

    public DocumentsListPage clickDocumentsTab() throws Exception {
        click(DOCUMENTS_TAB);
        logReport("Documents tab clicked successfully");
        return new DocumentsListPage(browser);
    }

    public BudgetPage clickBudgetTab() throws Exception {
        click(BUDGET_TAB);
        logReport("Budget tab clicked successfully");
        return new BudgetPage(browser);
    }
}
